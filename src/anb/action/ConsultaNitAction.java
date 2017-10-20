package anb.action;


import anb.bean.ConsultaNitForm;

import anb.general.Util;

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
        String aux;

        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        }
        if (!(bean.getBoton() == null) && bean.getBoton().equals("Verifica")) {
            aux = Util.esFechaMenorIgual(bean.getFecini(), bean.getFecfin());
            bean.setEstado("OK");
            if(aux.equals("1")) {
                request.setAttribute("ERROR",
                                 "Fecha Desde no puede ser mayor a Fecha Hasta");
                bean.setEstado("ERROR");
            }
            if(aux.equals("2")) {
                request.setAttribute("ERROR",
                                 "Fecha Desde no es una fecha valida");
                bean.setEstado("ERROR");
            }            
            if(aux.equals("3")) {
                request.setAttribute("ERROR",
                                 "Fecha Hasta no es una fecha valida");
                bean.setEstado("ERROR");
            }
        }
        return mapping.findForward(link);
    }
}
