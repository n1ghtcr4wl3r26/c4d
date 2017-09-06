package anb.action;


import anb.bean.ParametrosForm;

import anb.general.conexion_cad;

import java.io.IOException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class ParametrosAction extends Action {

    public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
            ParametrosForm bean = new ParametrosForm();
            bean = (ParametrosForm)request.getAttribute("ParametrosForm");
            return mapping.findForward("ok");
        }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws ServletException, IOException {
        ParametrosForm pform = (ParametrosForm)request.getAttribute("ParametrosForm");
        conexion_cad dc = new conexion_cad();
        Connection con = null;
        CallableStatement call = null;
        try {
            con = dc.abrirConexion();
            if (pform.getBoton().equals("Grabar")) {
                call = con.prepareCall("{? = call ops$asy.carpetas.inserta_parametros(?,?) }");
                call.registerOutParameter(1, 1);
                call.setString(2, pform.getMaximo());
                call.setString(3, (String)request.getSession().getAttribute("user"));
                call.execute();
                String mensaje = (String)call.getObject(1);
                if (mensaje.equals("1")) {
                    pform.setMensaje("Se generaron correctamente los n\372meros de carpetas hasta el n\372mero. " +
                                     pform.getMaximo().toString());
                    request.setAttribute("ParametrosForm", pform);
                } else {
                    pform.setMensaje("No se generaron los n&uacute;meros de carpetas, vuelva a intentarlo.");
                    request.setAttribute("parametrosForm", pform);
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
        return mapping.findForward("ok");
    }
}
