package anb.action;


import anb.bean.AmpliacionForm;

import anb.entidades.Aduana;
import anb.entidades.Declaracion;
import anb.entidades.DeclaracionItem;
import anb.entidades.InfoControl;
import anb.entidades.Paises;
import anb.entidades.Tramite;

import anb.general.Respuesta;
import anb.general.Util;

import anb.negocio.AmpliacionNeg;
import anb.negocio.GeneralNeg;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


public class AmpliacionAction extends MappingDispatchAction {
    private final GeneralNeg neg = new GeneralNeg();
    private final AmpliacionNeg ampneg = new AmpliacionNeg();

    public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        AmpliacionForm bean = new AmpliacionForm();
        bean = (AmpliacionForm)request.getAttribute("AmpliacionForm");

        String link = "index";
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setUsuarioger((String)request.getSession().getAttribute("gerencia"));
            String codigo;
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("CONSULTACTL")) {
                request.getSession().setAttribute("sgestion", bean.getFgestion());
                request.getSession().setAttribute("sgerencia", bean.getFgerencia());
                request.getSession().setAttribute("scontrol", bean.getFcontrol());
                request.getSession().setAttribute("snumero", bean.getFnumero());
                Respuesta<Boolean> resu =
                    neg.devuelveCodigo(bean.getFgestion(), bean.getFcontrol(), bean.getFgerencia(), bean.getFnumero());
                request.setAttribute("codigo", resu.getResultado());
                if (resu.getCodigo() == 1) {
                    bean.setCodigo(resu.getMensaje());
                    Respuesta<Boolean> res = ampneg.verifica_ampliacion_control(bean);
                    if (res.getCodigo() == 1) {
                        //verifica si el usuario esta habilitado para el control ******
                        Respuesta<Boolean> ver =
                            neg.verificaAccesoUsuario(bean.getCodigo(), bean.getUsuario(), "AMPLIACION",
                                                      bean.getUsuarioger());
                        if (ver.getCodigo() == 1) {
                            request.setAttribute("OK", res.getMensaje());
                            request.getSession().setAttribute("codigoamp", bean.getCodigo());
                            if (bean.getTipoBusqueda().equals("FILTRO")) {
                                link = "ok";
                            } else {
                                link = "oktram";
                            }
                        } else {
                            request.setAttribute("ERROR", "No esta asignado a la Orden de Fiscalizaci&oacute;n");
                        }
                        //******
                    } else {
                        if (res.getCodigo() == 0) {
                            request.setAttribute("WARNING", res.getMensaje());
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                            link = "index";
                        }
                    }
                } else {
                    if (resu.getCodigo() == 0) {
                        request.setAttribute("WARNING", resu.getMensaje());
                    } else {
                        request.setAttribute("ERROR", resu.getMensaje());
                        link = "index";
                    }
                }
            } else {
                bean.setFgestion((String)request.getSession().getAttribute("sgestion"));
                bean.setFgerencia((String)request.getSession().getAttribute("sgerencia"));
                bean.setFcontrol((String)request.getSession().getAttribute("scontrol"));
                bean.setFnumero((String)request.getSession().getAttribute("snumero"));
            }
            return mapping.findForward(link);
        }
    }

    public ActionForward index2(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                HttpServletResponse response) throws Exception {
        AmpliacionForm bean = (AmpliacionForm)request.getSession().getAttribute("AmpliacionForm");
        String link = "index";
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("CONSULTACTL")) {
                Respuesta<Boolean> res = ampneg.verifica_ampliacion_control(bean);
                if (res.getCodigo() == 1) {
                    request.setAttribute("OK", res.getMensaje());
                    request.getSession().setAttribute("codigoamp", bean.getCodigo());
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
                return mapping.findForward(link);
            } else {
                return mapping.findForward("index");
            }
        }
    }

    public ActionForward ampliacion(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        AmpliacionForm bean = (AmpliacionForm)request.getAttribute("AmpliacionForm");
        bean.setCodigo((String)request.getSession().getAttribute("codigoamp"));
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
            request.setAttribute("AmpliacionForm", bean);
        }
        if (inf.getResultado().getTipoOperador().equals("DECLARANTE")) {
            bean.setDeclarante(inf.getResultado().getDocIdentificacion());
            bean.setNumeroOperador(inf.getResultado().getDocIdentificacion());
            bean.setTipoOperador(inf.getResultado().getTipoOperador());
            request.setAttribute("AmpliacionForm", bean);
        }
        Respuesta<Tramite[]> tram = ampneg.ver_TramitesControlrep(bean);
        request.setAttribute("tramites", tram.getResultado());
        bean.setCantidad_amp(tram.getCantidad());

        return mapping.findForward("ok");
    }

    public ActionForward ampconsultar(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        Util.noCache(response);
        AmpliacionForm bean = new AmpliacionForm();
        bean = (AmpliacionForm)request.getAttribute("AmpliacionForm");
        String usuario = (String)request.getSession().getAttribute("user");
        String usuarioger = (String)request.getSession().getAttribute("numerogerencia");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setUsuarioger(usuarioger);
            Respuesta<Tramite[]> tram = ampneg.ver_TramitesControlrep(bean);
            request.setAttribute("tramites", tram.getResultado());
            bean.setCantidad_amp(tram.getCantidad());
            Respuesta<List<Paises>> pai = neg.obtenerPaises();
            request.setAttribute("paises", pai.getResultado());
            Respuesta<List<Aduana>> adu = neg.obtenerAduanas();
            request.setAttribute("aduanas", adu.getResultado());
            Respuesta<InfoControl> inf = neg.devuelveControl(bean.getCodigo());
            request.setAttribute("infoControl", inf.getResultado());

            if (bean.getOpcion().equals("CONSULTAR")) {
                if (bean.getTipoBusqueda().equals("Declaracion")) {
                    Respuesta<Declaracion[]> res = ampneg.ver_Declaracion(bean);
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
                    Respuesta<DeclaracionItem[]> res = ampneg.ver_DeclaracionItem(bean);
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
                    Respuesta<Boolean> res = ampneg.graba_tramites_selec(bean);
                    if (res.getCodigo() == 1) {
                        request.setAttribute("OK", res.getMensaje());
                    } else {
                        if (res.getCodigo() == 0) {
                            request.setAttribute("WARNING", res.getMensaje());
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                        }
                    }
                    Respuesta<Tramite[]> tramo = ampneg.ver_TramitesControlrep(bean);
                    request.setAttribute("tramites", tramo.getResultado());
                    bean.setCantidad_amp(tramo.getCantidad());
                }
                if (bean.getTipoBusqueda().equals("Item")) {
                    request.setAttribute("declaracionesItem", null);
                    Respuesta<Boolean> res = ampneg.graba_tramites_selec_item(bean);
                    if (res.getCodigo() == 1) {
                        request.setAttribute("OK", res.getMensaje());
                    } else {
                        if (res.getCodigo() == 0) {
                            request.setAttribute("WARNING", res.getMensaje());
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                        }
                    }
                    Respuesta<Tramite[]> tramo = ampneg.ver_TramitesControlrep(bean);
                    request.setAttribute("tramites", tramo.getResultado());
                    bean.setCantidad_amp(tramo.getCantidad());
                }
            }
            if (bean.getOpcion().equals("BORRAR")) {
                request.setAttribute("declaraciones", null);
                Respuesta<Boolean> res = ampneg.borra_tramite_selecitem(bean);
                if (res.getCodigo() == 1) {
                    request.setAttribute("OK", res.getMensaje());
                } else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                    }
                }
                Respuesta<Tramite[]> tramo = ampneg.ver_TramitesControlrep(bean);
                request.setAttribute("tramites", tramo.getResultado());
                bean.setCantidad_amp(tramo.getCantidad());
            }
            if (bean.getOpcion().equals("BORRAALL")) {
                request.setAttribute("declaraciones", null);
                Respuesta<Boolean> res = ampneg.borra_tramite_todo(bean);
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
                Respuesta<Tramite[]> tramo = ampneg.ver_TramitesControlrep(bean);                
                request.setAttribute("tramites", tramo.getResultado());
                bean.setCantidad_alc(tramo.getCantidad());
            }
            return mapping.findForward("ok");
        }
    }


    public ActionForward ampliaciontramite(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        //AlcanceForm bean = new AlcanceForm();
        AmpliacionForm bean = (AmpliacionForm)request.getAttribute("AmpliacionForm");
        bean.setCodigo((String)request.getSession().getAttribute("codigoamp"));

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
            Respuesta<Tramite[]> tram = ampneg.ver_TramitesControlrep(bean);
            request.setAttribute("tramites", tram.getResultado());
            bean.setCantidad_alc(tram.getCantidad());

            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("GRABA")) {
                if (bean.getBoton().equals("declaracion")) {
                    request.setAttribute("declaraciones", null);
                    Respuesta<Boolean> res = ampneg.graba_tramite_dec(bean);
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
                    Respuesta<Boolean> res = ampneg.graba_tramite_factura(bean);
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
                    Respuesta<Boolean> res = ampneg.graba_tramite_transferencia(bean);
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
                    Respuesta<Boolean> res = ampneg.graba_tramite_otro(bean);
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
                Respuesta<Boolean> res = ampneg.borra_tramite_selecitem(bean);
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
                Respuesta<Tramite[]> tramo = ampneg.ver_TramitesControlrep(bean);
                request.setAttribute("tramites", tramo.getResultado());
                bean.setCantidad_alc(tramo.getCantidad());
            }
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("BORRAALL")) {
                request.setAttribute("declaraciones", null);
                Respuesta<Boolean> res = ampneg.borra_tramite_todo(bean);
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
                Respuesta<Tramite[]> tramo = ampneg.ver_TramitesControlrep(bean);                
                request.setAttribute("tramites", tramo.getResultado());
                bean.setCantidad_alc(tramo.getCantidad());
            }

            //Respuesta<Tramite[]> tramo = alcneg.ver_TramitesControl(bean);
            Respuesta<Tramite[]> tramo = ampneg.ver_TramitesControlrep(bean);
            request.setAttribute("tramites", tramo.getResultado());
            bean.setCantidad_alc(tramo.getCantidad());

            return mapping.findForward("ok");
        }
    }
}
