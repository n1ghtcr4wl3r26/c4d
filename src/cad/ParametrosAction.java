// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 16/05/2012 12:08:51
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ParametrosAction.java

package cad;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.struts.action.*;

// Referenced classes of package cad:
//            ParametrosForm, LoginForm, BDConection

public class ParametrosAction extends Action
{

    public ParametrosAction()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        ParametrosForm pform = (ParametrosForm)request.getAttribute("ParametrosForm");
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        try
        {
            con = dc.abrirConexion();
            if(pform.getBoton().equals("Grabar"))
            {
                call = con.prepareCall("{? = call ops$asy.carpetas.inserta_parametros(?,?) }");
                call.registerOutParameter(1, 1);
                call.setString(2, pform.getMaximo());
                call.setString(3, (String)request.getSession().getAttribute("user"));
                call.execute();
                String mensaje = (String)call.getObject(1);
                if(mensaje.equals("1"))
                {
                    pform.setMensaje("Se generaron correctamente los n\372meros de carpetas hasta el n\372mero. " + pform.getMaximo().toString());
                    request.setAttribute("ParametrosForm", pform);
                } else
                {
                    pform.setMensaje("No se generaron los n&uacute;meros de carpetas, vuelva a intentarlo.");
                    request.setAttribute("parametrosForm", pform);
                }
            }
        }
        catch(Exception e)
        {
            ActionForward actionforward = mapping.findForward("parametros");
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
        return mapping.findForward("parametros");
    }
}