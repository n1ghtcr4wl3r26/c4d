// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 16/05/2012 12:11:07
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   verificaAction.java

package cad;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;


// Referenced classes of package cad:
//            verificaForm, BDConection

public class verificaAction extends Action
{

    public verificaAction()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        verificaForm vform = (verificaForm)request.getAttribute("verificaForm");
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        try
        {
            con = dc.abrirConexion();
            if(vform.getBoton().equals("Verifica"))
            {
                call = con.prepareCall("{? = call ops$asy.carpetas.devuelve_valido(" + vform.getNumero().toString() + ") }");
                call.registerOutParameter(1, 1);
                call.execute();
                String mensaje = (String)call.getObject(1);
                if(mensaje.equals("1"))
                {
                    vform.setMensaje("El N&uacute;mero: " + vform.getNumero().toString() + " es v&aacute;lido.");
                    request.setAttribute("verificaForm", vform);
                } else
                {
                    vform.setMensaje("El N&uacute;mero: " + vform.getNumero().toString() + " no es v&aacute;lido.");
                    request.setAttribute("verificaForm", vform);
                }
            }
        }
        catch(Exception e)
        {
            ActionForward actionforward = mapping.findForward("verifica");
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
        return mapping.findForward("verifica");
    }
}