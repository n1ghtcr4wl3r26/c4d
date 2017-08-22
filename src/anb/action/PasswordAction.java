package anb.action;

import anb.bean.PasswordForm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import cliente.ClaseEnvio;
import cliente.ServiciosUsuario;
import cliente.bean.ClaseUsuario;
// Referenced classes of package cad:
//            PasswordForm, LoginForm

public class PasswordAction extends Action
{

    public PasswordAction()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        PasswordForm pform = (PasswordForm)form;
        
        ServiciosUsuario serviciosUsuario=new ServiciosUsuario();
        ClaseEnvio claseEnvio=serviciosUsuario.getServiciosUsuario();                                           
        
        ActionMessages messages = new ActionMessages();
          if(pform.getBoton() != null)
        {
            if(pform.getBoton().equals("Cancelar"))
                return mapping.findForward("menu");
            if(pform.getBoton().equals("Aceptar"))
                try
                {
                  
                        if(pform.getTxt_pas().equals(pform.getTxt_confPas()))
                        {
                            Integer Clave=claseEnvio.cambiaClave((String)request.getSession().getAttribute("user"),  pform.getTxt_pasant(), pform.getTxt_pas());                                                        
                            int i = (int) Clave.longValue();

                            if( i == 0 )
                            {                                messages.add("error", new ActionMessage("error", "No se pudo cambiar la Contrase\361a del Usuario"));
                                saveErrors(request, messages);
                                ActionForward actionforward2 = mapping.findForward("volver");
                                return actionforward2;
                                } else
                            {
                                
                                
                                messages.add("error", new ActionMessage("mensaje", "Se cambio correctamente la Contrase\361a del Usuario"));
                                saveErrors(request, messages);
                                ActionForward actionforward1 = mapping.findForward("login");
                                return actionforward1;
                                
                            }
                        } else
                        {
                            messages.add("error", new ActionMessage("error", "Existe diferencias en su contrase\361a y la confirmaci\363n."));
                            saveErrors(request, messages);
                            ActionForward actionforward = mapping.findForward("volver");
                            return actionforward;
                        }
                    
                }
                catch(Exception e)
                {
                    messages.add("error", new ActionMessage("error", "Error General"));
                    messages.add("error", new ActionMessage("error", e.getMessage()));
                    saveErrors(request, messages);
                    ActionForward actionforward3 = mapping.findForward("volver");
                    return actionforward3;
                }
        }
        return mapping.findForward("volver");
    }
}