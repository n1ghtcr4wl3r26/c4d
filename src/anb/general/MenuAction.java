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
        case 101:
            return mapping.findForward("memorizaciondiferido");

        case 10:
            return mapping.findForward("memorizacion");

        case 11:
            return mapping.findForward("alcance");

        case 12:
            return mapping.findForward("asigna");

        case 13:
            return mapping.findForward("registro");

        case 14:
            return mapping.findForward("ampliacion");

        case 15:
            return mapping.findForward("notificacioncontrol");

        case 16:
            return mapping.findForward("generacionhoja");

        case 17:
            return mapping.findForward("subir");

        case 18:
            return mapping.findForward("generacionxls");

        case 19:
            return mapping.findForward("conclusion");

        case 20:
            return mapping.findForward("notificacionconclusion");

        case 31:
            return mapping.findForward("anulacion");

        case 32:
            return mapping.findForward("reasigna");

        case 41:
            return mapping.findForward("liquidacion");

        case 42:
            return mapping.findForward("tributos");

        case 43:
            return mapping.findForward("reporden");

        case 44:
            return mapping.findForward("repnotificacion");

        case 45:
            return mapping.findForward("repalcance");

        case 46:
            return mapping.findForward("repcontrol");

        case 47:
            return mapping.findForward("repampliacion");

        case 51:
            return mapping.findForward("repcontrolasig");

        case 511:
            return mapping.findForward("repcontrolgen");

        case 52:
            return mapping.findForward("repdetallecontrolsup");

        case 53:
            return mapping.findForward("repdetallecontrolfis");

        case 54:
            return mapping.findForward("repcuadroliquidacion");

        case 55:
            return mapping.findForward("repliquidacionprevia");

        case 90:
            return mapping.findForward("usuario");

        case 91:
            return mapping.findForward("log");

        case 98:
            return mapping.findForward("account");

        case 99:
            return mapping.findForward("password");

        case 182:
            return mapping.findForward("registrorecibos");

        case 61:
            return mapping.findForward("seguimiento.orden");

        case 62:
            return mapping.findForward("seguimiento.dui");

        case 63:
            return mapping.findForward("seguimiento.item");

        case 64:
            return mapping.findForward("liquidacion.dui");

        case 65:
            return mapping.findForward("liquidacion.item");

        case 66:
            return mapping.findForward("recuperacion.dui");


        default:
            request.getSession().removeAttribute("user.data");
            request.getSession().removeAttribute("opcion");
            request.getSession().removeAttribute("ClaseSession");
            return mapping.findForward("exit");
        }

    }
}
