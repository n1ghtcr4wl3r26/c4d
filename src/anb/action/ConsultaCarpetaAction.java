package anb.action;


import anb.bean.ConsultaCarpetaForm;

import anb.general.ConexionCad;

import anb.negocio.GeneralNeg;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


public class ConsultaCarpetaAction extends MappingDispatchAction {
    private final GeneralNeg gen = new GeneralNeg();

    public ActionForward consultacarpetaidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                            HttpServletResponse response) throws Exception {
        ConsultaCarpetaForm bean = new ConsultaCarpetaForm();
        bean = (ConsultaCarpetaForm)request.getAttribute("ConsultaCarpetaForm");
        String link = "index";

        String usuario = (String)request.getSession().getAttribute("user");
        bean.setUsuario(usuario);
        if (usuario == null) {
            return mapping.findForward("nook");
        }
        if (bean.getNumopc() == null) {

            if (!(bean.getBoton() == null) && bean.getBoton().equals("Verifica")) {
                ConexionCad dc = new ConexionCad();
                Connection con = null;
                CallableStatement call = null;
                CallableStatement call2 = null;
                try {
                    con = dc.abrirConexion();
                    call = con.prepareCall("{? = call ops$asy.carpetas2.carpeta_estado(?) }");
                    call.registerOutParameter(1, 1);
                    call.setString(2, bean.getNumero());
                    call.execute();
                    String mensaje = (String)call.getObject(1);
                    if (mensaje.equals("0")) {
                        request.setAttribute("ERROR",
                                             "El N&uacute;mero: " + bean.getNumero().toString() + " no es v&aacute;lido.");
                    } else {
                        if (mensaje.equals("1")) {
                            call2 = con.prepareCall("{? = call ops$asy.carpetas2.carpeta_asociada(?) }");
                            call2.registerOutParameter(1, 1);
                            call2.setString(2, bean.getNumero());
                            call2.execute();
                            String asociado = (String)call2.getObject(1);
                            if (asociado.equals("0")) {
                                request.setAttribute("OK",
                                                     "El N&uacute;mero de carpeta " + bean.getNumero().toString() + " no asociado a ninguna Declaraci&oacute;n.");
                            } else {
                                request.setAttribute("OK",
                                                     "El N&uacute;mero de carpeta " + bean.getNumero().toString() + " se encuentra asociado a una Declaraci&oacute;n.");
                                bean.setResultado(asociado);
                                request.setAttribute("GestionCarpetaForm", bean);
                            }
                        } else {
                            if (mensaje.equals("2")) {
                                request.setAttribute("WARNING",
                                                     "El N&uacute;mero de carpeta " + bean.getNumero().toString() + " se encuentra dada de baja.");
                            }
                        }
                    }
                } catch (Exception e) {
                    ActionForward actionforward = mapping.findForward("ok");
                    return actionforward;
                } finally {
                    try {
                        if (con != null)
                            con.close();

                    } catch (SQLException er) {
                        ;
                    }
                }
            }
        } 
        return mapping.findForward(link);
    }
}
