package cad;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import oracle.jdbc.driver.*;
import java.util.*;
import java.text.*;

import javax.naming.InitialContext;
import javax.sql.PooledConnection;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class carpetaAction extends Action 
{
  /**
   * This is the main action called from the Struts framework.
   * @param mapping The ActionMapping used to select this instance.
   * @param form The optional ActionForm bean for this request.
   * @param request The HTTP Request we are processing.
   * @param response The HTTP Response we are processing.
   */
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
        carpetaForm vform = (carpetaForm)request.getAttribute("carpetaForm");
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        CallableStatement call2 = null;
        String mensaje;
        String estado;
        String nrocarpeta;
        String usuario;
       
        try
        {
            con = dc.abrirConexion();
            if(vform.getBoton().equals("Verifica"))
            {
                request.getSession().setAttribute("nrocarpeta", vform.getNumero().toString());
                call = con.prepareCall("{? = call ops$asy.carpetas.carpeta_estado(" + vform.getNumero().toString() + ") }");
                call.registerOutParameter(1, 1);
                call.execute();
                estado = (String)call.getObject(1);
                if(estado.equals("0"))
                {
                    vform.setMensaje("El N&uacute;mero de carpeta: " + vform.getNumero().toString() + " no existe.");
                    request.setAttribute("carpetaForm", vform);
                } else
                {

                    if(estado.equals("1"))
                    {
                        call2 = con.prepareCall("{? = call ops$asy.carpetas.carpeta_asociada(" + vform.getNumero().toString() + ") }");
                        call2.registerOutParameter(1, 1);
                        call2.execute();
                        mensaje = (String)call2.getObject(1);
                        if(mensaje.equals("0"))
                        {
                            vform.setMensaje("<table width='500px' align='center' class='soloborde' bgcolor='#C1C1FF' id='c'><TBODY><tr><td style='color:#FFF' class=FondoActivo align=middle>N&uacute;mero de carpeta no asociado a ninguna Declaraci&oacute;n</td></tr></TBODY><tr><td class='parath'>Observacion: <input type='text' name='observacion' value=''></td></tr><tr><td align='center'><input type='submit' name='boton' value='Dar baja' class='boton1' onclick='return fEvalua3()'></td></tr></table>");
                            request.setAttribute("carpetaForm", vform);
                        }
                        else
                        {
                            vform.setMensaje(mensaje);
                            request.setAttribute("carpetaForm", vform);
                        }
                    }
                    else
                    {
                        if(estado.equals("2"))
                        {
                            vform.setMensaje("<table width='500px' align='center' class='soloborde' bgcolor='#C1C1FF' id='c'><TBODY><tr><td style='color:#FFF' class=FondoBaja align=middle>N&uacute;mero de carpeta dada de baja</td></tr></TBODY><tr><td class='parath'>Observacion: <input type='text' name='observacion' value=''></td></tr><tr><td align='center'><input type='submit' name='boton' value='Rehabilitar' class='boton1' onclick='return fEvalua4()'></td></tr></table>");
                            request.setAttribute("carpetaForm", vform);
                        }
                    }
                }
            }
            else
            {
                  usuario = (String)request.getSession().getAttribute("user");
                  nrocarpeta = (String)request.getSession().getAttribute("nrocarpeta");
                  if(vform.getBoton().equals("Dar baja"))
                  {   
                      if(nrocarpeta.equals(vform.getNumero().toString()))
                      {
                          call = con.prepareCall("{? = call ops$asy.carpetas.dar_baja(" + vform.getNumero().toString() + ",'"+usuario+"','" + vform.getObservacion().toString() + "') }");
                          call.registerOutParameter(1, 1);
                          call.execute();
                          mensaje = (String)call.getObject(1);
                          vform.setMensaje(mensaje);
                          request.setAttribute("carpetaForm", vform);
                      }
                      else
                      {
                          vform.setMensaje("Error en el n&uacute;mero de carpeta, vuelva a realizar la operaci&oacute;n");
                      }
                  }
                  else
                  {   
                      if(vform.getBoton().equals("Rehabilitar"))
                      {
                          if(nrocarpeta.equals(vform.getNumero().toString()))
                          {
                              call = con.prepareCall("{? = call ops$asy.carpetas.rehabilitar(" + vform.getNumero().toString() + ",'"+usuario+"','" + vform.getObservacion().toString() + "') }");
                              call.registerOutParameter(1, 1);
                              call.execute();
                              mensaje = (String)call.getObject(1);
                              vform.setMensaje(mensaje);
                              request.setAttribute("carpetaForm", vform);
                          }
                          else
                          {
                              vform.setMensaje("Error en el n&uacute;mero de carpeta, vuelva a realizar la operaci&oacute;n");
                          }
                      }
                  }
            }
        }
        catch(Exception e)
        {
            ActionForward actionforward = mapping.findForward("carpetas");
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
        return mapping.findForward("carpetas");
  }
}