package anb.action;


import anb.bean.inputActionForm;

import anb.general.MenuForm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


// Referenced classes of package cad:
//            MenuForm, LoginForm

public class MenuAction extends Action
{

    public MenuAction()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        MenuForm bMenu = (MenuForm)form;
        String op = null;
        String dia = null;
        String mes = null;
        switch(Integer.valueOf(bMenu.getOpcion()))
        {
        default:
            break;

        case 1: // '\001'
            op = "reporte";
            break;

        case 3: // '\003'
            op = "parametros";
            break;

        case 4: // '\004'
            op = "texto";
            break;

        case 6: // '\006'
            op = "verifica";
            break;

        case 7: // '\007'
            op = "carpetas";
            break;
            
        case 9: // '\009'
            op = "consulta";
            break;

        case 52: // '\009'
            op = "discar";
            break;
            
        case 76: // '\009'
            op = "condis";
            break;
            
        case 32: // '\009'
            op = "asicar";
            break;
            
        case 75: // '\009'
            op = "connit";
            break;
            
        case 98: // 'b'
            op = "password";
            break;

        case 99: // 'c'
            op = "logout";
            inputActionForm loform = (inputActionForm)request.getSession().getAttribute("inputActionForm");
            if(loform == null)
            {
                loform = new inputActionForm();
                request.getSession().setAttribute("inputActionForm", loform);
            }
            loform.setUsuario(null);
            break;
        }
        return mapping.findForward(op);
    }
}