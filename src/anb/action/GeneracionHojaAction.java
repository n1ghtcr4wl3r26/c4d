package anb.action;


import anb.bean.GeneracionHojaForm;

import anb.entidades.HojaTrabajoDui;
import anb.entidades.InfoControl;

import anb.general.Respuesta;

import anb.negocio.GeneralNeg;
import anb.negocio.HojaTrabajoNeg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


public class GeneracionHojaAction extends MappingDispatchAction {
    private final HojaTrabajoNeg neg = new HojaTrabajoNeg();
    private final GeneralNeg gen = new GeneralNeg();

    public ActionForward generacionidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {

        GeneracionHojaForm bean = new GeneracionHojaForm();
        bean = (GeneracionHojaForm)request.getAttribute("GeneracionHojaForm");
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setCodger((String)request.getSession().getAttribute("user.codger"));
            bean.setUsuarioger((String)request.getSession().getAttribute("gerencia"));
            String link = "index";
            String codigo;
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("CONSULTAR")) {
                request.getSession().setAttribute("sgestion", bean.getFgestion());
                request.getSession().setAttribute("sgerencia", bean.getFgerencia());
                request.getSession().setAttribute("scontrol", bean.getFcontrol());
                request.getSession().setAttribute("snumero", bean.getFnumero());
                Respuesta<Boolean> res =
                    gen.devuelveCodigo(bean.getFgestion(), bean.getFcontrol(), bean.getFgerencia(), bean.getFnumero());
                request.setAttribute("codigo", res.getResultado());
                if (res.getCodigo() == 1) {
                    bean.setCodigo(res.getMensaje().toString());
                    Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                    request.setAttribute("infoControl", inf.getResultado());

                    if (bean.getTipoAlcance().equals("DECLARACIONES")) {
                        Respuesta<HojaTrabajoDui[]> ben = neg.hojaTrabajoDui(bean);
                        if (ben.getCodigo() == 1) {
                            //verifica si el usuario esta habilitado para el control ******
                            Respuesta<Boolean> ver =
                                gen.verificaAccesoUsuario(bean.getCodigo(), bean.getUsuario(), "GENERACION",
                                                          bean.getUsuarioger());
                            if (ver.getCodigo() == 1) {
                                bean.setCantidad("1");
                                request.setAttribute("hojaTrabajoDui", ben.getResultado());
                                link = "ok";
                            } else {
                                request.setAttribute("ERROR", "No esta asignado a la Orden de Fiscalizaci&oacute;n");
                                link = "index";
                            }
                            //******
                        } else {
                            bean.setCantidad("0");
                            request.setAttribute("hojaTrabajoDui", null);
                            request.setAttribute("ERROR", res.getMensaje());
                        }                       
                    } else {
                        if (bean.getTipoAlcance().equals("TRAMITES")) {
                            Respuesta<HojaTrabajoDui[]> ben = neg.hojaTrabajoTramite(bean);
                            if (ben.getCodigo() == 1) {
                                //verifica si el usuario esta habilitado para el control ******
                                Respuesta<Boolean> ver =
                                    gen.verificaAccesoUsuario(bean.getCodigo(), bean.getUsuario(), "GENERACION",
                                                              bean.getUsuarioger());
                                if (ver.getCodigo() == 1) {
                                    bean.setCantidad("1");
                                    request.setAttribute("hojaTrabajoDui", ben.getResultado());
                                    link = "oktramite";
                                } else {
                                    request.setAttribute("ERROR",
                                                         "No esta asignado a la Orden de Fiscalizaci&oacute;n");
                                    link = "index";
                                }
                                //******
                            } else {
                                bean.setCantidad("0");
                                request.setAttribute("hojaTrabajoDui", null);
                                request.setAttribute("ERROR", res.getMensaje());
                            }                            
                        } else {
                            link = "nook";
                        }
                    }
                } else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
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

    public ActionForward generacion(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        GeneracionHojaForm bean = new GeneracionHojaForm();
        bean = (GeneracionHojaForm)request.getAttribute("GeneracionHojaForm");
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setCodger((String)request.getSession().getAttribute("user.codger"));
            String link = "index";
            String codigo;
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("CONSULTAR")) {
                Respuesta<Boolean> res =
                    gen.devuelveCodigo(bean.getFgestion(), bean.getFcontrol(), bean.getFgerencia(), bean.getFnumero());
                request.setAttribute("codigo", res.getResultado());
                if (res.getCodigo() == 1) {
                    bean.setCodigo(res.getMensaje().toString());
                    Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                    request.setAttribute("infoControl", inf.getResultado());
                    Respuesta<HojaTrabajoDui[]> ben = neg.hojaTrabajoDui(bean);
                    if (ben.getCodigo() == 1) {
                        request.setAttribute("hojaTrabajoDui", ben.getResultado());
                    }
                    link = "ok";
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
