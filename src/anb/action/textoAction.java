package anb.action;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.struts.action.*;

// Referenced classes of package cad:
//            textoForm, LoginForm, BDConection

public class textoAction extends Action
{

    public textoAction()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        textoForm gform = (textoForm)request.getAttribute("textoForm");
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        try
        {
            con = dc.abrirConexion();
            if(gform.getBoton().equals("Generar"))
            {
                call = con.prepareCall("{? = call ops$asy.carpetas.bajar_tablas}");
                call.registerOutParameter(1, 1);
                call.execute();
                String mensaje = (String)call.getObject(1);
                if(mensaje.equals("1"))
                {
                    gform.setMensaje("SE GENERO CORRECTAMENTO EL ARCHIVO TEXTO.");
                    request.setAttribute("textoForm", gform);
                    gform.setOpcion(1);
                } else
                {
                    gform.setMensaje("NO SE PUDO GENERAR EL ARCHIVO DE TEXTO. INTENTELO DE NUEVO.");
                    request.setAttribute("textoForm", gform);
                    gform.setOpcion(0);
                }
            }
        }
        catch(Exception e)
        {
            ActionForward actionforward = mapping.findForward("texto");
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
        return mapping.findForward("texto");
    }
}