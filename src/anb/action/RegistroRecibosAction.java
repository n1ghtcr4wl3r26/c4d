package anb.action;


import anb.bean.RegistroRecibosForm;

import anb.entidades.Aduana;
import anb.entidades.InfoControl;
import anb.entidades.Recibo;
import anb.entidades.Tramite;

import anb.general.Respuesta;

import anb.negocio.GeneralNeg;
import anb.negocio.RegistroRecibosNeg;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


public class RegistroRecibosAction extends MappingDispatchAction {

    private final RegistroRecibosNeg neg = new RegistroRecibosNeg();
    private final GeneralNeg gen = new GeneralNeg();

    public ActionForward registrorecibosidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        RegistroRecibosForm bean = new RegistroRecibosForm();
        String link = "index";
        bean = (RegistroRecibosForm)request.getAttribute("RegistroRecibosForm");

        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setGerencia((String)request.getSession().getAttribute("gerencia"));
            bean.setUsuarioger((String)request.getSession().getAttribute("gerencia"));
            bean.setUsuario(usuario);
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("CONSULTAR")) {
                request.getSession().setAttribute("sgestion", bean.getFgestion());
                request.getSession().setAttribute("sgerencia", bean.getFgerencia());
                request.getSession().setAttribute("scontrol", bean.getFcontrol());
                request.getSession().setAttribute("snumero", bean.getFnumero());
                Respuesta<Boolean> res2 =
                    gen.devuelveCodigo(bean.getFgestion(), bean.getFcontrol(), bean.getFgerencia(), bean.getFnumero());
                if (res2.getCodigo() == 1) {
                    bean.setCodigo(res2.getMensaje());
                    Respuesta<Boolean> res = neg.verifica_registro_recibos(bean);
                    if (res.getCodigo() == 1) {
                        //verifica si el usuario esta habilitado para el control ******
                        Respuesta<Boolean> ver =
                            gen.verificaAccesoUsuario(bean.getCodigo(), bean.getUsuario(), "RECIBOS",
                                                      bean.getUsuarioger());
                        if (ver.getCodigo() == 1) {
                            request.setAttribute("OK", res.getMensaje());
                            Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                            request.setAttribute("AnulacionForm", bean);
                            request.setAttribute("infoControl", inf.getResultado());
                            Respuesta<List<Aduana>> adu = gen.obtenerAduanas2();
                            request.setAttribute("aduanas", adu.getResultado());
                            Respuesta<Tramite[]> tram = gen.ver_TramitesControl(bean.getCodigo());
                            request.setAttribute("tramites", tram.getResultado());
                            Respuesta<Recibo[]> dac = neg.recibos(bean);
                            request.setAttribute("recibos", dac.getResultado());
                            link = "ok";
                        } else {
                            if (ver.getMensaje().equals("NOPERFIL")) {
                                request.setAttribute("ERROR", "No tiene el perfil adecuado.");
                            } else {
                                request.setAttribute("ERROR", "No tiene acceso a la Orden de Fiscalizaci&oacute;n.");
                            }
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
                    if (res2.getCodigo() == 0) {
                        request.setAttribute("WARNING", res2.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res2.getMensaje());
                        link = "index";
                    }
                }
            }
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("CONSULTAR2")) {
                bean.setCodigo(bean.getFcodigo());
                Respuesta<Boolean> res = neg.verifica_registro_recibos(bean);
                if (res.getCodigo() == 1) {
                    //verifica si el usuario esta habilitado para el control ******
                    Respuesta<Boolean> ver =
                        gen.verificaAccesoUsuario(bean.getCodigo(), bean.getUsuario(), "RECIBOS",
                                                  bean.getUsuarioger());
                    if (ver.getCodigo() == 1) {
                        request.setAttribute("OK", res.getMensaje());
                        Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                        request.setAttribute("infoControl", inf.getResultado());
                        Respuesta<List<Aduana>> adu = gen.obtenerAduanas2();
                        request.setAttribute("aduanas", adu.getResultado());
                        Respuesta<Recibo[]> dac = neg.recibos(bean);
                        request.setAttribute("recibos", dac.getResultado());
                        link = "ok";
                    } else {
                        if (ver.getMensaje().equals("NOPERFIL")) {
                            request.setAttribute("ERROR", "No tiene el perfil adecuado.");
                        } else {
                            request.setAttribute("ERROR", "No tiene acceso a la Orden de Fiscalizaci&oacute;n.");
                        }
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
                bean.setFgestion((String)request.getSession().getAttribute("sgestion"));
                bean.setFgerencia((String)request.getSession().getAttribute("sgerencia"));
                bean.setFcontrol((String)request.getSession().getAttribute("scontrol"));
                bean.setFnumero((String)request.getSession().getAttribute("snumero"));
            }
            bean.setOpcion("");
            return mapping.findForward(link);
        }
    }

    public ActionForward registrorecibos(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {

        RegistroRecibosForm bean = new RegistroRecibosForm();
        String link = "ok";
        bean = (RegistroRecibosForm)request.getAttribute("RegistroRecibosForm");
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setGerencia((String)request.getSession().getAttribute("gerencia"));
            bean.setUsuario(usuario);
            Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
            request.setAttribute("infoControl", inf.getResultado());
            Respuesta<Tramite[]> tram = gen.ver_TramitesControl(bean.getCodigo());
            request.setAttribute("tramites", tram.getResultado());
            Respuesta<List<Aduana>> adu = gen.obtenerAduanas2();
            request.setAttribute("aduanas", adu.getResultado());
            Respuesta<Recibo[]> dac = neg.recibos(bean);
            request.setAttribute("recibos", dac.getResultado());
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("GRABA")) {
                Respuesta<Boolean> res = neg.graba_recibo(bean);
                if (res.getCodigo() == 1) {
                    request.setAttribute("OK", res.getMensaje());                
                    link = "ok";
                } else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                    }
                }
            }
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("BORRAR")) {
                request.setAttribute("recibos", null);
                Respuesta<Boolean> res = neg.borra_recibo(bean);
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
            Respuesta<Recibo[]> daco = neg.recibos(bean);
            bean.setOpcion("");
            request.setAttribute("recibos", daco.getResultado());
            return mapping.findForward(link);
        }
    }
}
