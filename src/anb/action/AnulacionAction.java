package anb.action;


import anb.bean.AnulacionForm;

import anb.bean.RegistroRecibosForm;

import anb.entidades.InfoControl;
import anb.entidades.Tramite;

import anb.general.Respuesta;

import anb.negocio.AnulacionNeg;
import anb.negocio.GeneralNeg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


public class AnulacionAction extends MappingDispatchAction {

    private final AnulacionNeg neg = new AnulacionNeg();
    private final GeneralNeg gen = new GeneralNeg();

    public ActionForward anulacionidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        AnulacionForm bean = new AnulacionForm();
        String link = "index";
        bean = (AnulacionForm)request.getAttribute("AnulacionForm");

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
                    Respuesta<Boolean> res = neg.verifica_anulacion_control(bean);
                    if (res.getCodigo() == 1) {
                        //verifica si el usuario esta habilitado para el control ******
                        Respuesta<Boolean> ver =
                            gen.verificaAccesoUsuario(bean.getCodigo(), bean.getUsuario(), "ANULACION",
                                                      bean.getUsuarioger());
                        if (ver.getCodigo() == 1) {
                            request.setAttribute("OK", res.getMensaje());
                            Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                            request.setAttribute("AnulacionForm", bean);
                            request.setAttribute("infoControl", inf.getResultado());
                            Respuesta<Tramite[]> tram = gen.ver_TramitesControl(bean.getCodigo());
                            request.setAttribute("tramites", tram.getResultado());
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
                Respuesta<Boolean> res = neg.verifica_anulacion_control(bean);
                if (res.getCodigo() == 1) {
                    //verifica si el usuario esta habilitado para el control ******
                    Respuesta<Boolean> ver =
                        gen.verificaAccesoUsuario(bean.getCodigo(), bean.getUsuario(), "ANULACION",
                                                  bean.getUsuarioger());
                    if (ver.getCodigo() == 1) {
                        request.setAttribute("OK", res.getMensaje());
                        Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                        request.setAttribute("AnulacionForm", bean);
                        request.setAttribute("infoControl", inf.getResultado());
                        Respuesta<Tramite[]> tram = gen.ver_TramitesControl(bean.getCodigo());
                        request.setAttribute("tramites", tram.getResultado());
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
            return mapping.findForward(link);
        }
    }

    public ActionForward anulacion(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {

        AnulacionForm bean = new AnulacionForm();
        String link = "ok";
        bean = (AnulacionForm)request.getAttribute("AnulacionForm");
        bean = (AnulacionForm)request.getAttribute("AnulacionForm");
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
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("ANULACION")) {
                Respuesta<Boolean> res = neg.anula_control(bean);
                if (res.getCodigo() == 1) {
                    request.setAttribute("OK", res.getMensaje());
                    /*String[] fisca = res.getMensaje().split("-");
                    request.getSession().setAttribute("sgestion", fisca[0].substring(37));
                    request.getSession().setAttribute("sgerencia", fisca[2]);
                    request.getSession().setAttribute("scontrol", fisca[1]);
                    request.getSession().setAttribute("snumero", fisca[3]);*/
                    link = "index";
                } else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                    }
                }
            }
            return mapping.findForward(link);
        }
    }
}
