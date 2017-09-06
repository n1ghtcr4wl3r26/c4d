package anb.action;


import anb.bean.SubirHojaForm;

import anb.entidades.InfoControl;

import anb.general.Respuesta;

import anb.negocio.GeneralNeg;
import anb.negocio.SubirHojaNeg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


public class SubirHojaAction extends MappingDispatchAction {
    private final SubirHojaNeg neg = new SubirHojaNeg();
    private final GeneralNeg gen = new GeneralNeg();

    public ActionForward subiridx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {

        SubirHojaForm bean = new SubirHojaForm();
        bean = (SubirHojaForm)request.getAttribute("SubirHojaForm");
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
                    //verifica si el usuario esta habilitado para el control ******
                    Respuesta<Boolean> ver =
                        gen.verificaAccesoUsuario(bean.getCodigo(), bean.getUsuario(), "SUBIR",
                                                  bean.getUsuarioger());
                    if (ver.getCodigo() == 1) {
                        Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                        request.setAttribute("infoControl", inf.getResultado());
                        link = "ok";
                    } else {
                        request.setAttribute("ERROR", "No esta asignado a la Orden de Fiscalizaci&oacute;n");
                    }
                    //******
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

    public ActionForward subir(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                               HttpServletResponse response) throws Exception {

        SubirHojaForm bean = new SubirHojaForm();
        bean = (SubirHojaForm)request.getAttribute("SubirHojaForm");
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setCodger((String)request.getSession().getAttribute("user.codger"));
            String link = "index";
            String codigo;
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("SUBIR")) {
                Respuesta<String> res = gen.subirArchivo(bean.getFile(), bean.getCodigo());
                if (res.getCodigo() == 1) {
                    if (bean.getTipoAlcance().equals("DECLARACIONES")) {
                        Respuesta<Boolean> re = neg.leerArchivoExcel(res.getResultado(), bean.getCodigo(), usuario);
                        if (re.getCodigo() == 1) {
                            request.setAttribute("OK", re.getMensaje());
                            link = "ok";
                        } else {
                            if (re.getCodigo() == 0) {
                                request.setAttribute("WARNING", re.getMensaje());
                            } else {
                                request.setAttribute("ERROR", re.getMensaje());
                            }
                        }
                    } else {
                        if (bean.getTipoAlcance().equals("TRAMITES")) {
                            Respuesta<Boolean> re =
                                neg.leerArchivoExcelTramite(res.getResultado(), bean.getCodigo(), usuario);
                            if (re.getCodigo() == 1) {
                                request.setAttribute("OK", re.getMensaje());
                                link = "ok";
                            } else {
                                if (re.getCodigo() == 0) {
                                    request.setAttribute("WARNING", re.getMensaje());
                                } else {
                                    request.setAttribute("ERROR", re.getMensaje());
                                }
                            }
                        } else {
                            request.setAttribute("ERROR", "No se especifico el tipo de Trámite");
                        }

                    }

                } else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                    }
                }
            }
            Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
            request.setAttribute("infoControl", inf.getResultado());
            return mapping.findForward(link);
        }
    }
}
