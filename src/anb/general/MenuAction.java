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
        case 10:
            return mapping.findForward("estadocarpeta");

        case 3:
            return mapping.findForward("generar");

        case 6:
            return mapping.findForward("verifica");

        case 7:
            return mapping.findForward("gestion.carpeta");

        case 9:
            return mapping.findForward("consulta.carpeta");

        case 32:
            return mapping.findForward("asigna.carpeta");

        case 52:
            return mapping.findForward("distribucion.carpetas");

        case 75:
            return mapping.findForward("consulta.nit");

        case 76:
            return mapping.findForward("consulta.distribucion");

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
