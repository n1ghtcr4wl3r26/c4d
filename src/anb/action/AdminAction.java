package anb.action;


import anb.bean.AdminForm;

import anb.entidades.Funcionario;

import anb.general.Respuesta;

import anb.negocio.AdminNeg;
import anb.negocio.GeneralNeg;

import cliente.ClaseEnvio;
import cliente.ServiciosUsuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


public class AdminAction extends MappingDispatchAction {
    private final GeneralNeg gen = new GeneralNeg();
    private final AdminNeg neg = new AdminNeg();

    public ActionForward account(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        AdminForm bean = new AdminForm();
        String link = "index";
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            if (!(bean == null)) {
                bean.setUsuario(usuario);
                Respuesta<Funcionario> res = neg.getAccount(bean);
                if (res.getCodigo() == 1) {
                    //request.setAttribute("OK", res.getMensaje());
                    //request.getSession().setAttribute("funcionario", res.getResultado());
                } else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                    }
                }
            }
        }
        return mapping.findForward("ok");
    }

    public ActionForward password(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws Exception {
        AdminForm bean = new AdminForm();
        bean = (AdminForm)request.getAttribute("AdminForm");
        String link = "index";
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            if (!(bean == null)) {
                bean.setUsuario(usuario);
                if (!(bean.getOpcion() == null) &&  bean.getOpcion().equals("CHANGE")) {
                    
                    ServiciosUsuario wsUser = new ServiciosUsuario();
                    ClaseEnvio claseEnvio = wsUser.getServiciosUsuario();
                    try {
                        Integer clave = claseEnvio.cambiaClave(bean.getUsuario(), bean.getPassword(), bean.getNewpassword());
                        if (clave.longValue() == 0) {
                            request.setAttribute("WARNING", "No se pudo cambiar la Contraseña, por favor, vuelva a intentarlo.");
                        } else {
                            request.setAttribute("OK", "La Contraseña se cambio correctamente."); 
                        }
                    } catch (Exception e) {
                        request.setAttribute("ERROR", e.getMessage());
                    }
                    /*
                    Respuesta<Boolean> res = neg.changePassword(bean);
                    if (res.getCodigo() == 1) {
                        request.setAttribute("OK", res.getMensaje());
                    } else {
                        if (res.getCodigo() == 0) {
                            request.setAttribute("WARNING", res.getMensaje());
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                        }
                    }*/
                }
            }
        }
        return mapping.findForward("ok");
    }
    
    public ActionForward passwordidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws Exception {
        AdminForm bean = new AdminForm();
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            request.setAttribute("AdminForm", bean);
        }
        return mapping.findForward("ok");
    }


}
