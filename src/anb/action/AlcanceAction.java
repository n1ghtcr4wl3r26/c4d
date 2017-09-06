package anb.action;


import anb.bean.AlcanceForm;

import anb.bean.AlcanceItemForm;

import anb.entidades.Aduana;
import anb.entidades.Declaracion;
import anb.entidades.DeclaracionItem;
import anb.entidades.InfoControl;
import anb.entidades.Paises;
import anb.entidades.Tramite;

import anb.general.Json;
import anb.general.Respuesta;
import anb.general.Util;

import anb.negocio.AlcanceNeg;
import anb.negocio.GeneralNeg;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


public class AlcanceAction extends MappingDispatchAction {
    private final GeneralNeg neg = new GeneralNeg();
    private final AlcanceNeg alcneg = new AlcanceNeg();

    public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        AlcanceForm bean = (AlcanceForm)request.getAttribute("AlcanceForm");
        if (bean.getCodigo() == null) {
            bean.setCodigo((String)request.getSession().getAttribute("scodigo"));
        }
        String link = "index";
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setUsuarioger((String)request.getSession().getAttribute("gerencia"));
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("CONSULTACTL")) {
                Respuesta<Boolean> res = alcneg.verifica_alcance_control(bean);
                if (res.getCodigo() == 1) {
                    //verifica si el usuario esta habilitado para el control ******                
                    Respuesta<Boolean> ver = neg.verificaAccesoUsuario(bean.getCodigo(), bean.getUsuario(), "ALCANCE", bean.getUsuarioger());
                    if (ver.getCodigo() == 1) {
                        request.setAttribute("OK", res.getMensaje());
                        request.getSession().setAttribute("codigoalc", bean.getCodigo());
                        if (bean.getTipoBusqueda().equals("FILTRO")) {
                            link = "ok";
                        } else {
                            link = "oktram";
                        }
                    } else {
                        if (ver.getMensaje().equals("NOPERFIL")){
                            request.setAttribute("ERROR", "No tiene el perfil adecuado.");
                        } else {
                            request.setAttribute("ERROR", "No tiene acceso a la Orden de Fiscalizaci&oacute;n.");   
                        }
                    }
                    //******                    
                } else {
                    if (res.getMensaje().equals("No se puede registrar alcance de una fiscalización ampliatoria")) {

                        Respuesta<Tramite[]> tramo = alcneg.ver_TramitesPadreAmp(bean);
                        request.setAttribute("tramitespadreamp", tramo.getResultado());
                        Respuesta<Tramite[]> tramamp = alcneg.ver_TramitesAmp(bean);
                        request.setAttribute("tramitesamp", tramamp.getResultado());
                        /*se desmarcan las declaraciones que no pertenecen al declarante o importador de la orden ampliatoria*/
                        Respuesta<InfoControl> inf = neg.devuelveControl(bean.getCodigo());
                        request.setAttribute("infoControl", inf.getResultado());
                        int i;
                        String ope;
                        for(i=0;i<=tramo.getResultado().length-1;i++){
                            if(inf.getResultado().getTipoOperador().equals("DECLARANTE")){
                                if(tramo.getResultado()[i].getTipoTramite().equals("DUI")){
                                    if(!(inf.getResultado().getDocIdentificacion().equals( tramo.getResultado()[i].getDeclarante()))){
                                        tramo.getResultado()[i].setEstado("0");    
                                    }   
                                }
                            }
                            if(inf.getResultado().getTipoOperador().equals("IMPORTADOR/EXPORTADOR")){
                                if(tramo.getResultado()[i].getTipoTramite().equals("DUI")){
                                    if(!(inf.getResultado().getDocIdentificacion().equals( tramo.getResultado()[i].getImportador()))){
                                        tramo.getResultado()[i].setEstado("0");    
                                    }   
                                } 
                            }
                        }
                        /* ****** */
                        bean.setCantidad_alc(tramo.getCantidad());
                        request.setAttribute("AlcanceForm", bean);
                        link = "okamp";
                    } else {
                        if (res.getCodigo() == 0) {
                            request.setAttribute("WARNING", res.getMensaje());
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                            link = "index";
                        }
                    }
                }
                return mapping.findForward(link);
            } else {
                return mapping.findForward("index");
            }
        }
    }

    public ActionForward index2(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                HttpServletResponse response) throws Exception {
        AlcanceForm bean = (AlcanceForm)request.getSession().getAttribute("AlcanceForm");
        String link = "index";
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("CONSULTACTL")) {
                Respuesta<Boolean> res = alcneg.verifica_alcance_control(bean);
                if (res.getCodigo() == 1) {
                    request.setAttribute("OK", res.getMensaje());
                    request.getSession().setAttribute("codigoalc", bean.getCodigo());
                    if (bean.getTipoBusqueda().equals("FILTRO")) {
                        link = "ok";
                    } else {
                        link = "oktram";
                    }
                } else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                        link = "index";
                    }
                }
                request.getSession().setAttribute("scodigo", bean.getCodigo());
                return mapping.findForward(link);
            } else {
                return mapping.findForward("index");
            }
        }
    }

    public ActionForward alcance(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        //AlcanceForm bean = new AlcanceForm();
        AlcanceForm bean = (AlcanceForm)request.getAttribute("AlcanceForm");
        bean.setCodigo((String)request.getSession().getAttribute("codigoalc"));
        Respuesta<List<Paises>> pai = neg.obtenerPaises();
        request.setAttribute("paises", pai.getResultado());
        Respuesta<List<Aduana>> adu = neg.obtenerAduanas((String)request.getSession().getAttribute("gerencia"));
        if (adu.getCodigo() == 1) {
            request.setAttribute("aduanas", adu.getResultado());
        } else {
            request.setAttribute("aduanas", null);
            if (adu.getCodigo() == 0) {
                request.setAttribute("WARNING", adu.getMensaje());
            } else {
                request.setAttribute("ERROR", adu.getMensaje());
            }
        }
        Respuesta<InfoControl> inf = neg.devuelveControl(bean.getCodigo());
        request.setAttribute("infoControl", inf.getResultado());
        if (inf.getResultado().getTipoOperador().equals("IMPORTADOR/EXPORTADOR")) {
            bean.setOperador(inf.getResultado().getDocIdentificacion());
            bean.setNumeroOperador(inf.getResultado().getDocIdentificacion());
            bean.setTipoOperador(inf.getResultado().getTipoOperador());
            request.setAttribute("AlcanceForm", bean);
        }
        if (inf.getResultado().getTipoOperador().equals("DECLARANTE")) {
            bean.setDeclarante(inf.getResultado().getDocIdentificacion());
            bean.setNumeroOperador(inf.getResultado().getDocIdentificacion());
            bean.setTipoOperador(inf.getResultado().getTipoOperador());
            request.setAttribute("AlcanceForm", bean);
        }
        //Respuesta<Tramite[]> tram = alcneg.ver_TramitesControl(bean);
        Respuesta<Tramite[]> tram = alcneg.ver_TramitesControlrep(bean);
        request.setAttribute("tramites", tram.getResultado());
        bean.setCantidad_alc(tram.getCantidad());

        return mapping.findForward("ok");
    }

    public ActionForward alcconsultar(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        Util.noCache(response);
        AlcanceForm bean = new AlcanceForm();
        bean = (AlcanceForm)request.getAttribute("AlcanceForm");
        String usuario = (String)request.getSession().getAttribute("user");
        String usuarioger = (String)request.getSession().getAttribute("numerogerencia");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setUsuarioger(usuarioger);
            //Respuesta<Tramite[]> tram = alcneg.ver_TramitesControl(bean);
            Respuesta<Tramite[]> tram = alcneg.ver_TramitesControlrep(bean);
            request.setAttribute("tramites", tram.getResultado());
            bean.setCantidad_alc(tram.getCantidad());
            Respuesta<List<Paises>> pai = neg.obtenerPaises();
            request.setAttribute("paises", pai.getResultado());
            Respuesta<List<Aduana>> adu = neg.obtenerAduanas();
            request.setAttribute("aduanas", adu.getResultado());
            Respuesta<InfoControl> inf = neg.devuelveControl(bean.getCodigo());
            request.setAttribute("infoControl", inf.getResultado());

            if (bean.getOpcion().equals("CONSULTAR")) {
                if (bean.getTipoBusqueda().equals("Declaracion")) {
                    Respuesta<Declaracion[]> res = alcneg.ver_Declaracion(bean);
                    bean.setCantidad_dec(res.getCantidad());
                    if (res.getCodigo() == 1) {
                        request.setAttribute("declaraciones", res.getResultado());
                    } else {
                        request.setAttribute("declaraciones", null);
                        if (res.getCodigo() == 0) {
                            request.setAttribute("WARNING", res.getMensaje());
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                        }
                    }
                }
                if (bean.getTipoBusqueda().equals("Item")) {
                    Respuesta<DeclaracionItem[]> res = alcneg.ver_DeclaracionItem(bean);
                    bean.setCantidad_dec(res.getCantidad());
                    if (res.getCodigo() == 1) {
                        request.setAttribute("declaracionesItem", res.getResultado());
                    } else {
                        request.setAttribute("declaracionesItem", null);
                        if (res.getCodigo() == 0) {
                            request.setAttribute("WARNING", res.getMensaje());
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                        }
                    }
                }
            }
            if (bean.getOpcion().equals("GRABADUIS")) {
                if (bean.getTipoBusqueda().equals("Declaracion")) {
                    request.setAttribute("declaraciones", null);
                    Respuesta<Boolean> res = alcneg.graba_tramites_selec(bean);
                    if (res.getCodigo() == 1) {
                        request.setAttribute("OK", res.getMensaje());
                    } else {
                        if (res.getCodigo() == 0) {
                            request.setAttribute("WARNING", res.getMensaje());
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                        }
                    }
                    
                    //Respuesta<Tramite[]> tramo = alcneg.ver_TramitesControl(bean);
                    Respuesta<Tramite[]> tramo = alcneg.ver_TramitesControlrep(bean);
                    request.setAttribute("tramites", tramo.getResultado());
                    bean.setCantidad_alc(tramo.getCantidad());
                }
                if (bean.getTipoBusqueda().equals("Item")) {
                    request.setAttribute("declaracionesItem", null);
                    Respuesta<Boolean> res = alcneg.graba_tramites_selec_item(bean);
                    if (res.getCodigo() == 1) {
                        request.setAttribute("OK", res.getMensaje());
                    } else {
                        if (res.getCodigo() == 0) {
                            request.setAttribute("WARNING", res.getMensaje());
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                        }
                    }
                    //Respuesta<Tramite[]> tramo = alcneg.ver_TramitesControl(bean);
                    Respuesta<Tramite[]> tramo = alcneg.ver_TramitesControlrep(bean);
                    request.setAttribute("tramites", tramo.getResultado());
                    bean.setCantidad_alc(tramo.getCantidad());
                }
            }
            if (bean.getOpcion().equals("BORRAR")) {
                request.setAttribute("declaraciones", null);
                Respuesta<Boolean> res = alcneg.borra_tramite_selecitem(bean);
                if (res.getCodigo() == 1) {
                    request.setAttribute("OK", res.getMensaje());
                } else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                    }
                }
                //Respuesta<Tramite[]> tramo = alcneg.ver_TramitesControl(bean);
                Respuesta<Tramite[]> tramo = alcneg.ver_TramitesControlrep(bean);                
                request.setAttribute("tramites", tramo.getResultado());
                bean.setCantidad_alc(tramo.getCantidad());
            }
            if (bean.getOpcion().equals("BORRAALL")) {
                request.setAttribute("declaraciones", null);
                Respuesta<Boolean> res = alcneg.borra_tramite_todo(bean);
                if (res.getCodigo() == 1) {
                    request.setAttribute("OK", res.getMensaje());
                } else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                    }
                }
                //Respuesta<Tramite[]> tramo = alcneg.ver_TramitesControl(bean);
                Respuesta<Tramite[]> tramo = alcneg.ver_TramitesControlrep(bean);                
                request.setAttribute("tramites", tramo.getResultado());
                bean.setCantidad_alc(tramo.getCantidad());
            }
            return mapping.findForward("ok");
        }
    }

    public ActionForward ampliacion(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        AlcanceForm bean = new AlcanceForm();
        return mapping.findForward("ok");
    }

    public ActionForward alcancetramite(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws Exception {
        //AlcanceForm bean = new AlcanceForm();
        AlcanceForm bean = (AlcanceForm)request.getAttribute("AlcanceForm");
        bean.setCodigo((String)request.getSession().getAttribute("codigoalc"));

        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);

            Respuesta<List<Paises>> pai = neg.obtenerPaises2();
            request.setAttribute("paises", pai.getResultado());
            Respuesta<List<Aduana>> adu = neg.obtenerAduanas2((String)request.getSession().getAttribute("gerencia"));
            if (adu.getCodigo() == 1) {
                request.setAttribute("aduanas", adu.getResultado());
            } else {
                request.setAttribute("aduanas", null);
                if (adu.getCodigo() == 0) {
                    request.setAttribute("WARNING", adu.getMensaje());
                } else {
                    request.setAttribute("ERROR", adu.getMensaje());
                }
            }
            Respuesta<InfoControl> inf = neg.devuelveControl(bean.getCodigo());
            request.setAttribute("infoControl", inf.getResultado());
            if (inf.getResultado().getTipoOperador().equals("IMPORTADOR/EXPORTADOR")) {
                bean.setOperador(inf.getResultado().getDocIdentificacion());
                bean.setNumeroOperador(inf.getResultado().getDocIdentificacion());
                bean.setTipoOperador(inf.getResultado().getTipoOperador());
                request.setAttribute("AlcanceForm", bean);
            }
            if (inf.getResultado().getTipoOperador().equals("DECLARANTE")) {
                bean.setDeclarante(inf.getResultado().getDocIdentificacion());
                bean.setNumeroOperador(inf.getResultado().getDocIdentificacion());
                bean.setTipoOperador(inf.getResultado().getTipoOperador());
                request.setAttribute("AlcanceForm", bean);
            }
            //Respuesta<Tramite[]> tram = alcneg.ver_TramitesControl(bean);
            Respuesta<Tramite[]> tram = alcneg.ver_TramitesControlrep(bean);
            request.setAttribute("tramites", tram.getResultado());
            bean.setCantidad_alc(tram.getCantidad());

            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("GRABA")) {
                if (bean.getBoton().equals("declaracion")) {
                    request.setAttribute("declaraciones", null);
                    Respuesta<Boolean> res = alcneg.graba_tramite_dec(bean);
                    if (res.getCodigo() == 1) {
                        request.setAttribute("OK", res.getMensaje());
                    } else {
                        if (res.getCodigo() == 0) {
                            request.setAttribute("WARNING", res.getMensaje());
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                        }
                    }
                }
                if (bean.getBoton().equals("factura")) {
                    request.setAttribute("declaraciones", null);
                    Respuesta<Boolean> res = alcneg.graba_tramite_factura(bean);
                    if (res.getCodigo() == 1) {
                        request.setAttribute("OK", res.getMensaje());
                    } else {
                        if (res.getCodigo() == 0) {
                            request.setAttribute("WARNING", res.getMensaje());
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                        }
                    }
                }
                if (bean.getBoton().equals("transferencia")) {
                    request.setAttribute("declaraciones", null);
                    Respuesta<Boolean> res = alcneg.graba_tramite_transferencia(bean);
                    if (res.getCodigo() == 1) {
                        request.setAttribute("OK", res.getMensaje());
                    } else {
                        if (res.getCodigo() == 0) {
                            request.setAttribute("WARNING", res.getMensaje());
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                        }
                    }
                }
                if (bean.getBoton().equals("otro")) {
                    request.setAttribute("declaraciones", null);
                    Respuesta<Boolean> res = alcneg.graba_tramite_otro(bean);
                    if (res.getCodigo() == 1) {
                        request.setAttribute("OK", res.getMensaje());
                    } else {
                        if (res.getCodigo() == 0) {
                            request.setAttribute("WARNING", res.getMensaje());
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                        }
                    }
                }
            }
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("BORRAR")) {
                request.setAttribute("declaraciones", null);
                Respuesta<Boolean> res = alcneg.borra_tramite_selecitem(bean);
                if (res.getCodigo() == 1) {
                    request.setAttribute("OK", res.getMensaje());
                } else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                    }
                }
                //Respuesta<Tramite[]> tramo = alcneg.ver_TramitesControl(bean);
                Respuesta<Tramite[]> tramo = alcneg.ver_TramitesControlrep(bean);                
                request.setAttribute("tramites", tramo.getResultado());
                bean.setCantidad_alc(tramo.getCantidad());
            }
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("BORRAALL")) {
                request.setAttribute("declaraciones", null);
                Respuesta<Boolean> res = alcneg.borra_tramite_todo(bean);
                if (res.getCodigo() == 1) {
                    request.setAttribute("OK", res.getMensaje());
                } else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                    }
                }
                //Respuesta<Tramite[]> tramo = alcneg.ver_TramitesControl(bean);
                Respuesta<Tramite[]> tramo = alcneg.ver_TramitesControlrep(bean);                
                request.setAttribute("tramites", tramo.getResultado());
                bean.setCantidad_alc(tramo.getCantidad());
            }
            
            //Respuesta<Tramite[]> tramo = alcneg.ver_TramitesControl(bean);
            Respuesta<Tramite[]> tramo = alcneg.ver_TramitesControlrep(bean);
            request.setAttribute("tramites", tramo.getResultado());
            bean.setCantidad_alc(tramo.getCantidad());

            return mapping.findForward("ok");
        }
    }

    public ActionForward alcanceampliatoria(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                            HttpServletResponse response) throws Exception {
        Util.noCache(response);
        AlcanceForm bean = (AlcanceForm)request.getAttribute("AlcanceForm");

        String usuario = (String)request.getSession().getAttribute("user");
        String usuarioger = (String)request.getSession().getAttribute("numerogerencia");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setUsuarioger(usuarioger);
            //Respuesta<Tramite[]> tram = alcneg.ver_TramitesControl(bean);
            Respuesta<Tramite[]> tram = alcneg.ver_TramitesControlrep(bean);
            request.setAttribute("tramites", tram.getResultado());
            bean.setCantidad_alc(tram.getCantidad());
            Respuesta<List<Paises>> pai = neg.obtenerPaises();
            request.setAttribute("paises", pai.getResultado());
            Respuesta<List<Aduana>> adu = neg.obtenerAduanas();
            request.setAttribute("aduanas", adu.getResultado());
            Respuesta<InfoControl> inf = neg.devuelveControl(bean.getCodigo());
            request.setAttribute("infoControl", inf.getResultado());
            if (bean.getOpcion().equals("CONSULTAR")) {
                if (bean.getTipoBusqueda().equals("Declaracion")) {
                    Respuesta<Declaracion[]> res = alcneg.ver_Declaracion(bean);
                    bean.setCantidad_dec(res.getCantidad());
                    if (res.getCodigo() == 1) {
                        request.setAttribute("declaraciones", res.getResultado());
                    } else {
                        request.setAttribute("declaraciones", null);
                        if (res.getCodigo() == 0) {
                            request.setAttribute("WARNING", res.getMensaje());
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                        }
                    }
                }
                if (bean.getTipoBusqueda().equals("Item")) {
                    Respuesta<DeclaracionItem[]> res = alcneg.ver_DeclaracionItem(bean);
                    bean.setCantidad_dec(res.getCantidad());
                    if (res.getCodigo() == 1) {
                        request.setAttribute("declaracionesItem", res.getResultado());
                    } else {
                        request.setAttribute("declaracionesItem", null);
                        if (res.getCodigo() == 0) {
                            request.setAttribute("WARNING", res.getMensaje());
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                        }
                    }
                }
            }
            if (bean.getOpcion().equals("GRABADUIS")) {

                request.setAttribute("declaraciones", null);
                Respuesta<Boolean> res = alcneg.graba_tramites_selecamp(bean);
                if (res.getCodigo() == 1) {
                    request.setAttribute("OK", res.getMensaje());
                } else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                    }
                }
                Respuesta<Tramite[]> tramo = alcneg.ver_TramitesPadreAmp(bean);
                request.setAttribute("tramitespadreamp", tramo.getResultado());
                Respuesta<Tramite[]> tramamp = alcneg.ver_TramitesAmp(bean);
                request.setAttribute("tramitesamp", tramamp.getResultado());
                bean.setCantidad_alc(tramo.getCantidad());
                /*se desmarcan las declaraciones que no pertenecen al declarante o importador de la orden ampliatoria*/
                int i;
                String ope;
                for(i=0;i<=tramo.getResultado().length-1;i++){
                    if(inf.getResultado().getTipoOperador().equals("DECLARANTE")){
                        if(tramo.getResultado()[i].getTipoTramite().equals("DUI")){
                            if(!(inf.getResultado().getDocIdentificacion().equals( tramo.getResultado()[i].getDeclarante()))){
                                tramo.getResultado()[i].setEstado("0");    
                            }   
                        }
                    }
                    if(inf.getResultado().getTipoOperador().equals("IMPORTADOR/EXPORTADOR")){
                        if(tramo.getResultado()[i].getTipoTramite().equals("DUI")){
                            if(!(inf.getResultado().getDocIdentificacion().equals( tramo.getResultado()[i].getImportador()))){
                                tramo.getResultado()[i].setEstado("0");    
                            }   
                        } 
                    }
                }
                /* ****** */
            }
            if (bean.getOpcion().equals("BORRAR")) {
                request.setAttribute("declaraciones", null);
                Respuesta<Boolean> res = alcneg.borra_tramite_selecamp(bean);
                if (res.getCodigo() == 1) {
                    request.setAttribute("OK", res.getMensaje());
                } else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                    }
                }
                Respuesta<Tramite[]> tramo = alcneg.ver_TramitesPadreAmp(bean);
                request.setAttribute("tramitespadreamp", tramo.getResultado());
                Respuesta<Tramite[]> tramamp = alcneg.ver_TramitesAmp(bean);
                request.setAttribute("tramitesamp", tramamp.getResultado());
                bean.setCantidad_alc(tramo.getCantidad());
                /*se desmarcan las declaraciones que no pertenecen al declarante o importador de la orden ampliatoria*/
                int i;
                String ope;
                for(i=0;i<=tramo.getResultado().length-1;i++){
                    if(inf.getResultado().getTipoOperador().equals("DECLARANTE")){
                        if(tramo.getResultado()[i].getTipoTramite().equals("DUI")){
                            if(!(inf.getResultado().getDocIdentificacion().equals( tramo.getResultado()[i].getDeclarante()))){
                                tramo.getResultado()[i].setEstado("0");    
                            }   
                        }
                    }
                    if(inf.getResultado().getTipoOperador().equals("IMPORTADOR/EXPORTADOR")){
                        if(tramo.getResultado()[i].getTipoTramite().equals("DUI")){
                            if(!(inf.getResultado().getDocIdentificacion().equals( tramo.getResultado()[i].getImportador()))){
                                tramo.getResultado()[i].setEstado("0");    
                            }   
                        } 
                    }
                }
                /* ****** */
            }
            if (bean.getOpcion().equals("BORRAALL")) {
                request.setAttribute("declaraciones", null);
                Respuesta<Boolean> res = alcneg.borra_tramite_todo(bean);
                if (res.getCodigo() == 1) {
                    request.setAttribute("OK", res.getMensaje());
                } else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                    }
                }
                //Respuesta<Tramite[]> tramo = alcneg.ver_TramitesControl(bean);
                Respuesta<Tramite[]> tramo = alcneg.ver_TramitesControlrep(bean);                
                request.setAttribute("tramites", tramo.getResultado());
                bean.setCantidad_alc(tramo.getCantidad());
            }
            return mapping.findForward("ok");
        }
    }
    
    public ActionForward alcanceEdit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        Util.isAjax(request, response);
        Util.noCache(response);
        AlcanceForm alc = (AlcanceForm)form;
        
        alc.setIdalcanceitem(request.getParameter("idalcance"));
        alc.setEitem(request.getParameter("item"));
        alc.setEpagina(request.getParameter("pag"));
        Respuesta<Tramite[]> res=null;
        res = alcneg.ver_Alcance(alc);
        if(res.getCodigo() == 1) {          
            request.setAttribute("alcance", res.getResultado()[0]);
            alc.setIdalcanceitem(res.getResultado()[0].getCodigoItem());
            alc.setEtipo(res.getResultado()[0].getTipoTramite());
            alc.setEdocumento(res.getResultado()[0].getTramite());
            alc.setEitem(res.getResultado()[0].getItem());
            if (!(res.getResultado()[0].getValor() == null) && res.getResultado()[0].getValor().equals("X"))
                alc.setEchvalor("on");            
            if (!(res.getResultado()[0].getOrigen() == null) && res.getResultado()[0].getOrigen().equals("X"))
                alc.setEchorigen("on");
            if (!(res.getResultado()[0].getPartida() == null) && res.getResultado()[0].getPartida().equals("X"))
                alc.setEchpartida("on");
            if (!(res.getResultado()[0].getOtro() == null) && res.getResultado()[0].getOtro().equals("X"))
                alc.setEchotro("on");
            alc.setCodigo(res.getResultado()[0].getCodigo());
            request.setAttribute("AlcanceItemForm", alc);
        } else {
            if (res.getCodigo() == 0) {
                Json.warning(response, res.getMensaje());   
            } else {
                Json.error(response, res.getMensaje());    
            }
        }
        return mapping.findForward("alcance.edit");
    }
    
    public ActionForward alcanceGuardar(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        AlcanceForm alc = (AlcanceForm)form;
        String link = "ok";
        String usuario = (String)request.getSession().getAttribute("user");
        alc.setUsuario(usuario);
        Respuesta<Boolean> res = alcneg.actualiza_alcance_tramite(alc);
        if (res.getCodigo() == 1) {
            request.setAttribute("OK", res.getMensaje());
        } else {
            if (res.getCodigo() == 0) {
                request.setAttribute("WARNING", res.getMensaje());
            } else {
                request.setAttribute("ERROR", res.getMensaje());
            }
        }
        Respuesta<List<Paises>> pai = neg.obtenerPaises();
        request.setAttribute("paises", pai.getResultado());
        Respuesta<List<Aduana>> adu = neg.obtenerAduanas((String)request.getSession().getAttribute("gerencia"));
        request.setAttribute("aduanas", adu.getResultado());
        Respuesta<InfoControl> inf = neg.devuelveControl(alc.getCodigo());
        request.setAttribute("infoControl", inf.getResultado());
        Respuesta<Tramite[]> tram = alcneg.ver_TramitesControlrep(alc);
        request.setAttribute("tramites", tram.getResultado());
        alc.setCantidad_alc(tram.getCantidad());
        if (inf.getResultado().getTipoOperador().equals("IMPORTADOR/EXPORTADOR")) {
            alc.setOperador(inf.getResultado().getDocIdentificacion());
            alc.setNumeroOperador(inf.getResultado().getDocIdentificacion());
            alc.setTipoOperador(inf.getResultado().getTipoOperador());
            request.setAttribute("AlcanceForm", alc);
        }
        if (inf.getResultado().getTipoOperador().equals("DECLARANTE")) {
            alc.setDeclarante(inf.getResultado().getDocIdentificacion());
            alc.setNumeroOperador(inf.getResultado().getDocIdentificacion());
            alc.setTipoOperador(inf.getResultado().getTipoOperador());
            request.setAttribute("AlcanceForm", alc);
        }
        if(alc.getEpagina().equals("filtro"))
            link= "ok";
        if(alc.getEpagina().equals("tramite"))
            link= "oktram";
    
        return mapping.findForward(link);
    }
}
