package anb.action;


import anb.bean.EstadoCarpetaForm;

import anb.negocio.GeneralNeg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


public class EstadoCarpetaAction extends MappingDispatchAction {
    private final GeneralNeg gen = new GeneralNeg();

    public ActionForward estadoidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws Exception {
        EstadoCarpetaForm bean = new EstadoCarpetaForm();
        bean = (EstadoCarpetaForm)request.getAttribute("EstadoCarpetaForm");
        String link = "index";
        
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        }
        return mapping.findForward(link);
    }
}
