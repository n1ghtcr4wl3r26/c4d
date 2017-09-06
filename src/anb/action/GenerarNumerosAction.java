package anb.action;


import anb.bean.GenerarNumerosForm;

import anb.negocio.GeneralNeg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


public class GenerarNumerosAction extends MappingDispatchAction {
    private final GeneralNeg gen = new GeneralNeg();
    
    public ActionForward asignaidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        GenerarNumerosForm bean = (GenerarNumerosForm)request.getAttribute("GenerarNumerosForm");
        bean.setNumero("123"); 
        return mapping.findForward("ok");
    }
}
