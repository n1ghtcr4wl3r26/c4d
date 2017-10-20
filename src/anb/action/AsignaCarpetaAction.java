package anb.action;


import anb.bean.AsignaCarpetaForm;

import anb.general.ConexionCad;
import anb.general.Util;

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


public class AsignaCarpetaAction extends MappingDispatchAction {
    private final GeneralNeg gen = new GeneralNeg();

    public ActionForward asignacarpetaidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                          HttpServletResponse response) throws Exception {
        AsignaCarpetaForm bean = new AsignaCarpetaForm();
        bean = (AsignaCarpetaForm)request.getAttribute("AsignaCarpetaForm");
        String link = "index";

        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        }
        if (!(bean.getBoton() == null) && bean.getBoton().equals("Asigna")) {
            String ncarpeta;
            String eval = Util.es_despacho_directo(bean.getNit());
            if (eval.equals("0")) {
                request.setAttribute("ERROR",
                                     "El NIT " + bean.getNit().toString() + " no corresponde a un Importador de Despacho Directo.");
            } else {
                ncarpeta = Util.devuelve_secuencia(bean.getNumero());
                if (ncarpeta == null) {
                    request.setAttribute("ERROR",
                                         "El N&uacute;mero de Carpeta " + bean.getNumero().toString() + " no es v&aacute;lido.");
                } else {
                    ncarpeta = Util.devuelve_asociado(bean.getNumero());
                    if (ncarpeta != null) {
                        request.setAttribute("ERROR",
                                             "El N&uacute;mero de Carpeta " + bean.getNumero().toString() + " ya esta asociado al NIT " +
                                             ncarpeta);
                    } else {
                        ncarpeta = Util.devuelve_dui_asociado(bean.getNumero());
                        if (!(ncarpeta.equals("0"))) {
                            request.setAttribute("ERROR",
                                                 "El N&uacute;mero de Carpeta " + bean.getNumero().toString() +
                                                 " ya esta asociado a una Declaraci&oacute;n:" + ncarpeta);
                        } else {
                            ConexionCad dc = new ConexionCad();
                            Connection con = null;
                            CallableStatement call = null;
                            String rs = "";
                            String mensaje;
                            String estado;
                            String nrocarpeta;
                            try {

                                if (bean.getBoton().equals("Asigna")) {
                                    request.getSession().setAttribute("nrocarpeta", bean.getNumero().toString());
                                    usuario = (String)request.getSession().getAttribute("user");
                                    con = dc.abrirConexion();
                                    call = con.prepareCall("{ ? = call ops$asy.carpetas2.asocia_carpeta(?,?,?,?) }");
                                    call.registerOutParameter(1, 1);
                                    call.setString(2, bean.getNumero().toString());
                                    call.setString(3, bean.getNit().toString());
                                    call.setString(4, "");
                                    call.setString(5, usuario);
                                    call.execute();
                                    estado = (String)call.getObject(1);
                                    if (estado.equals("OK")) {
                                        request.setAttribute("OK",
                                                             "El N&uacute;mero de carpeta: " + bean.getNumero().toString() +
                                                             " fue asociado al NIT: " + bean.getNit());
                                    } else {
                                        request.setAttribute("ERROR",
                                                             "El N&uacute;mero de carpeta: " + bean.getNumero().toString() +
                                                             " no pudo ser asociado al NIT: " + bean.getNit());
                                    }
                                }
                            } catch (Exception e) {
                                ActionForward actionforward = mapping.findForward("asicar");
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
                }

            }
        }
        return mapping.findForward(link);
    }
}
