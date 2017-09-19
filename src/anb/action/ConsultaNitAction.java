package anb.action;


import anb.bean.ConsultaNitForm;

import anb.negocio.GeneralNeg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


public class ConsultaNitAction extends MappingDispatchAction {
    private final GeneralNeg gen = new GeneralNeg();

    public ActionForward consultanitidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws Exception {
        ConsultaNitForm bean = new ConsultaNitForm();
        bean = (ConsultaNitForm)request.getAttribute("ConsultaNitForm");
        String link = "index";

        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        }
        if (!(bean.getBoton() == null) && bean.getBoton().equals("Verifica")) {
            ;
        }
        return mapping.findForward(link);
    }
}
