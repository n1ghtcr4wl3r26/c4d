package anb.general;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/*
*   Nombre de la clase: MenuAction, Clase donde se define las pantallas para cada opcion del sistema
*
*   Fecha creación, Fecha Modificación
*
*   Autor creador, Autor Modificador
*/

public class MenuAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {
        MenuForm bMenu = (MenuForm)form;

        request.getSession().setAttribute("opcion", bMenu.getOpcion());

        switch (bMenu.getOpcion()) {

        case 1: // '\001'
            return mapping.findForward("reporte");

        case 3: // '\003'
            return mapping.findForward("parametros");

        case 4: // '\004'
            return mapping.findForward("texto");

        case 6: // '\006'
            return mapping.findForward("verifica");

        case 7: // '\007'
            return mapping.findForward("carpetas");

        case 9: // '\009'
            return mapping.findForward("consulta");

        case 52: // '\009'
            return mapping.findForward("discar");

        case 76: // '\009'
            return mapping.findForward("condis");

        case 32: // '\009'
            return mapping.findForward("asicar");

        case 75: // '\009'
            return mapping.findForward("connit");

        case 90:
            return mapping.findForward("usuario");

        case 91:
            return mapping.findForward("log");

        case 98:
            return mapping.findForward("account");

        case 99:
            return mapping.findForward("password");

        default:
            request.getSession().removeAttribute("user.data");
            request.getSession().removeAttribute("opcion");
            request.getSession().removeAttribute("ClaseSession");
            return mapping.findForward("exit");
        }
    }
}
