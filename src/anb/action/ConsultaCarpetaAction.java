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
        if (usuario == null) {
            return mapping.findForward("nook");
        }
        if (!(bean.getBoton() == null) && bean.getBoton().equals("Verifica")) {
            ConexionCad dc = new ConexionCad();
            Connection con = null;
            CallableStatement call = null;
            try {
                con = dc.abrirConexion();
                call = con.prepareCall("{? = call ops$asy.carpetas.devuelve_valido(?,?) }");
                call.registerOutParameter(1, 1);
                call.setString(2, bean.getNumero());
                call.execute();
                String mensaje = (String)call.getObject(1);
                if (mensaje.equals("1")) {
                    request.setAttribute("OK",
                                         "El N&uacute;mero: " + bean.getNumero().toString() + " es v&aacute;lido." +
                                         bean.getNumero().toString());
                } else {
                    request.setAttribute("ERROR",
                                         "El N&uacute;mero: " + bean.getNumero().toString() + " no es v&aacute;lido.");
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
        return mapping.findForward(link);
    }
}
