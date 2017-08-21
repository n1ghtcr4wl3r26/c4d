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


public class asicarAction extends Action 
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
        asicarForm vform = (asicarForm)request.getAttribute("asicarForm");
        String ncarpeta;
        String eval = Util.es_despacho_directo(vform.getNit());
        if(eval.equals("0"))
        {
            vform.setMensaje2(Util.creamensaje("2","El NIT " + vform.getNit().toString() + " no corresponde a un Importador de Despacho Directo.","0"));
            request.setAttribute("asicarForm", vform);
        }
        else
        {

            ncarpeta = Util.devuelve_secuencia(vform.getNumero());
            if(ncarpeta == null)
            {
                vform.setMensaje2(Util.creamensaje("2","El N&uacute;mero de Carpeta " + vform.getNumero().toString() + " no es v&aacute;lido.","0"));
                request.setAttribute("asicarForm", vform);
            }
            else
            {

                ncarpeta = Util.devuelve_asociado(vform.getNumero());
                if(ncarpeta != null)
                {
                    vform.setMensaje2(Util.creamensaje("2","El N&uacute;mero de Carpeta " + vform.getNumero().toString() + " ya esta asociado al NIT " + ncarpeta,"0"));
                    request.setAttribute("asicarForm", vform);
                }
                else
                {
                    ncarpeta = Util.devuelve_dui_asociado(vform.getNumero());
                    if(!(ncarpeta.equals("0")))
                    {
                        vform.setMensaje2(Util.creamensaje("2","El N&uacute;mero de Carpeta " + vform.getNumero().toString() + " ya esta asociado a una Declaraci&oacute;n:","0")+ncarpeta);
                        
                       
                        request.setAttribute("asicarForm", vform);
                    }
                    else
                    {
                        conexion dc = new conexion();
                        Connection con = null;
                        CallableStatement call = null;
                        String rs = "";
                        String mensaje;
                        String estado;
                        String nrocarpeta;
                        String usuario;
                         try
                        {
                            
                            if(vform.getBoton().equals("Asociar"))
                            {
                                request.getSession().setAttribute("nrocarpeta", vform.getNumero().toString());
                                usuario = (String)request.getSession().getAttribute("user");
                 
                                con = dc.abrirConexion();
                                call = con.prepareCall("{ ? = call ops$asy.carpetas.asocia_carpeta(?,?,?,?) }");
                                call.registerOutParameter(1, 1);
                                call.setString(2, vform.getNumero().toString());
                                call.setString(3, vform.getNit().toString());
                                call.setString(4, "");
                                call.setString(5, usuario);
                                call.execute();
                                estado = (String)call.getObject(1);
                                if(estado.equals("OK"))
                                {
                                    vform.setMensaje2(Util.creamensaje("3","El N&uacute;mero de carpeta: " + vform.getNumero().toString() + " fue asociado al NIT: "+vform.getNit(),"0"));
                                    request.setAttribute("asicarForm", vform);
                                } else
                                {
                                    vform.setMensaje2(Util.creamensaje("2","ERROR: El N&uacute;mero de carpeta: " + vform.getNumero().toString() + " no pudo ser asociado al NIT: "+vform.getNit(),"0"));
                                    request.setAttribute("asicarForm", vform);
                                }
                            }
            
                        }
                        catch(Exception e)
                        {
                            ActionForward actionforward = mapping.findForward("asicar");
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
                    }
                }
            }
        
        }
        return mapping.findForward("asicar");
  }
}