package anb.action;

import anb.general.conexion_cad;
import anb.bean.generarForm;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.struts.action.*;

// Referenced classes of package cad:
//            generarForm, LoginForm, BDConection

public class generarAction extends Action
{

    public generarAction()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        generarForm gform = (generarForm)request.getAttribute("generarForm");
        conexion_cad dc = new conexion_cad();
        Connection con = null;
        CallableStatement call = null;
        
        try
        {
            con = dc.abrirConexion();
            if(gform.getBoton().equals("Generar"))
            {
                call = con.prepareCall("{? = call ops$asy.carpetas.encripta_carpetas(?)}");
                call.registerOutParameter(1, 1);
                call.setString(2, (String)request.getSession().getAttribute("user"));
                call.execute();
                String mensaje = (String)call.getObject(1);
                if(mensaje.equals("1"))
                {
                    gform.setMensaje("Se generaron correctamente los n&uacute;meros de carpetas.");
                    request.setAttribute("generarForm", gform);
                } else
                {
                    gform.setMensaje("No se generaron los n&uacute;meros de carpetas. Intentelo de nuevo.");
                    request.setAttribute("generarForm", gform);
                }
            }
        }
        catch(Exception e)
        {
            ActionForward actionforward = mapping.findForward("generar");
            return actionforward;
        }
        finally
        {
            try {
                if (con != null)
                    con.close();

            } catch (SQLException er) {
                ;
            }
        }
        return mapping.findForward("generar");
    }
}