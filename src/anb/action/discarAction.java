package anb.action;

import anb.bean.discarForm;

import java.sql.CallableStatement;
import java.sql.SQLException;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class discarAction extends Action 
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
        discarForm vform = (discarForm)request.getAttribute("discarForm");

        if(vform.getBoton().equals("Verificar Disponibilidad"))
        {
            conexion dc = new conexion();
            Connection con = null;
            CallableStatement call = null;
            String estado;
            String nrocarpeta;
            String usuario;
            String res;
            String vdesde;
            String vhasta;
            
            String cant_asig;
            String cant_desh;
            String cant_total;
            vdesde = Util.devuelve_secuencia(vform.getDesde());
            vhasta = Util.devuelve_secuencia(vform.getHasta());
            StringBuffer mensaje = new StringBuffer();
            if(vdesde != null && vhasta != null)
            {
              try
              {
                  con = dc.abrirConexion();
                      
                      usuario = (String)request.getSession().getAttribute("user");
                      call = con.prepareCall("{call ops$asy.carpetas.verifica_asignacion(?,?,?,?,?,?,?,?) }");
                      call.setString(1, vform.getDesde());
                      call.setString(2, vform.getHasta());
                      call.registerOutParameter(3, 12);
                      call.registerOutParameter(4, 12);
                      call.registerOutParameter(5, 12);
                      call.registerOutParameter(6, 12);
                      call.registerOutParameter(7, 12);
                      call.registerOutParameter(8, 12);
                      call.execute();
                      res = (String)call.getObject(3);
                      vdesde = (String)call.getObject(4);
                      vhasta = (String)call.getObject(5);
                      cant_asig = (String)call.getObject(6);
                      cant_desh = (String)call.getObject(7);
                      cant_total = (String)call.getObject(8);
                      if(res == null)
                      
                          if (!(cant_total.equals("0")))
                          {
                            
                            if(!(cant_asig.equals("0")))
                              mensaje.append("<br>De las " + cant_total + " seleccionadas, hay " + cant_asig + " carpetas que se encuentran ya asignadas a una aduana"+"<br>");
                            
                            if(cant_asig.equals("0"))
                            {
                              mensaje.append("<br>Est&aacute; seguro de Asignar las " + cant_total + " carpetas a la aduana " + vform.getAduana()+"<br>");
                              if(!(cant_desh.equals("0")))
                              {
                                mensaje.append("<br>Hay " + cant_desh + " carpetas que se encuentran deshabilitadas"+"<br>");
                              }
                              mensaje.append("<br><center><input type='submit' name='boton' value='Asignar Carpetas' class='boton1'></center>");
                              request.getSession().setAttribute("fdesde",vdesde);
                              request.getSession().setAttribute("fhasta",vhasta);
                            }
                          } 
                          else
                          {
                          mensaje.append("<br>No se Encontraron Carpetas para realizar la asignaci&oacute;n"+"<br>");
                          }
                      else
                        mensaje.append(res);

                      vform.setMensaje(mensaje.toString());
                      request.setAttribute("discarForm",vform);
              }
              catch(Exception e)
              {
                  ActionForward actionforward = mapping.findForward("discar");
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
            else
            {
                if(vdesde == null)
                  mensaje.append("<br>El N&uacute;mero de carpeta '"+vform.getDesde()+"', no corresponde a una carpeta v&aacute;lida <br>");
                if(vhasta == null)
                  mensaje.append("<br>El N&uacute;mero de carpeta '"+vform.getHasta()+"', no corresponde a una carpeta v&aacute;lida <br>");

                  vform.setMensaje(mensaje.toString());
                  request.setAttribute("discarForm",vform);
            }
        }
        if(vform.getBoton().equals("Asignar Carpetas"))
        {
            String fdesde;
            String fhasta;
            String res;
            
            
            fdesde = (String)request.getSession().getAttribute("fdesde");
            fhasta = (String)request.getSession().getAttribute("fhasta");
            res = Util.asignacion_carpetas(fdesde,fhasta,vform.getAduana().toString(),(String)request.getSession().getAttribute("user"));
            vform.setMensaje2(Util.creamensaje("3",res,"0"));
            request.setAttribute("discarForm",vform);
        }
        
        return mapping.findForward("discar");
  }
}