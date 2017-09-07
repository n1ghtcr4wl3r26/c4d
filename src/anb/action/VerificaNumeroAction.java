package anb.action;


import anb.bean.VerificaNumeroForm;

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


public class VerificaNumeroAction extends MappingDispatchAction {
    private final GeneralNeg gen = new GeneralNeg();

    public ActionForward verificaidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        VerificaNumeroForm bean = new VerificaNumeroForm();
        bean = (VerificaNumeroForm)request.getAttribute("VerificaNumeroForm");
        String link = "index";

        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        }
        if (!(bean.getBoton() == null) && bean.getBoton().equals("Generar")) {
            ConexionCad dc = new ConexionCad();
            Connection con = null;
            CallableStatement call = null;
            try {
                con = dc.abrirConexion();
                call = con.prepareCall("{? = call ops$asy.carpetas.inserta_parametros(?,?) }");
                call.registerOutParameter(1, 1);
                call.setString(2, bean.getNumero());
                call.setString(3, (String)request.getSession().getAttribute("user"));
                call.execute();
                String mensaje = (String)call.getObject(1);
                if (mensaje.equals("1")) {
                    request.setAttribute("OK",
                                         "Se generaron correctamente los n\372meros de carpetas hasta el n\372mero. " +
                                         bean.getNumero().toString());
                } else {
                    request.setAttribute("ERROR",
                                         "No se generaron los n&uacute;meros de carpetas, vuelva a intentarlo.");
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
