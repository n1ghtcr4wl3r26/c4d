package anb.action;


import anb.bean.GestionCarpetaForm;

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


public class GestionCarpetaAction extends MappingDispatchAction {
    private final GeneralNeg gen = new GeneralNeg();

    public ActionForward gestioncarpetaidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        GestionCarpetaForm bean = new GestionCarpetaForm();
        bean = (GestionCarpetaForm)request.getAttribute("GestionCarpetaForm");
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
                                String tbl = "";
                                tbl = tbl + "<input type='hidden' name='numopc' id='numopc' value='"+bean.getNumero() +"'/>" +
                                      "<table class=\"table table-striped table-hover\">";
                                tbl =
                                tbl + "<thead><tr><td><b>N&uacute;mero de carpeta no asociado a ninguna Declaraci&oacute;n</b></td></tr></thead>";
                                tbl =
                                tbl + "<tbody><tr><td>Observacion: <input type='text' name='observacion' value=''></td></tr>";
                                tbl =
                                tbl + "<tr><td>" + "<button class='btn btn-info btn-sm newHide' type='button' id='btnbaj' title='Dar de baja numero de carpeta' onclick='baja()'>" +
                                      "<i class='fa fa-percent'></i> Dar de baja</button>" + "</td></tr>";
                                tbl = tbl + "</table>";
                                bean.setResultado(tbl);
                                request.setAttribute("GestionCarpetaForm", bean);
                            } else {
                                bean.setResultado(asociado);
                                request.setAttribute("GestionCarpetaForm", bean);
                            }
                        } else {
                            if (mensaje.equals("2")) {
                                String tbl = "";
                                tbl = tbl + "<input type='hidden' name='numopc' id='numopc' value='"+bean.getNumero() +"'/>" + 
                                "<table class='table table-striped table-hover'>";
                                tbl =
tbl + "<thead><tr><td><b>N&uacute;mero de carpeta dada de baja</b></td></tr></thead>";
                                tbl =
tbl + "<tbody><tr><td>Observacion: <input type='text' name='observacion' value=''></td></tr>";
                                tbl =
tbl + "<tr><td>" + "<button class='btn btn-info btn-sm newHide' type='button' id='btnreh' title='Rehabilitar numero de carpeta' onclick='rehabilitar()'>" +
  "<i class='fa fa-percent'></i> Rehabilitar</button>" + "</td></tr>";
                                tbl = tbl + "</table>";
                                bean.setResultado(tbl);
                                bean.setNumopc(bean.getNumero());
                                request.setAttribute("GestionCarpetaForm", bean);
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
        } else {
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("Baja")) {
                ConexionCad dc = new ConexionCad();
                Connection con = null;
                CallableStatement call = null;
                try {
                    con = dc.abrirConexion();
                    call = con.prepareCall("{? = call ops$asy.carpetas2.dar_baja(?,?,?) }");
                    call.registerOutParameter(1, 1);
                    call.setString(2, bean.getNumopc());
                    call.setString(3, bean.getUsuario());
                    call.setString(4, bean.getObservacion());
                    call.execute();
                    String mensaje = (String)call.getObject(1);
                    if (mensaje.equals("OK")) {
                        request.setAttribute("OK",
                                             "El n&uacute;mero de carpeta: " + bean.getNumopc().toString() + " se dio de baja satisfactoriamente.");
                    } else {
                        request.setAttribute("ERROR",
                                             "Se produjo un error al dar de baja el n&uacute;mero de carpeta: " +
                                             bean.getNumero().toString());
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
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("Rehabilitar")) {
                ConexionCad dc = new ConexionCad();
                Connection con = null;
                CallableStatement call = null;
                try {
                    con = dc.abrirConexion();
                    call = con.prepareCall("{? = call ops$asy.carpetas2.rehabilitar(?,?,?) }");
                    call.registerOutParameter(1, 1);
                    call.setString(2, bean.getNumopc());
                    call.setString(3, bean.getUsuario());
                    call.setString(4, bean.getObservacion());
                    call.execute();
                    String mensaje = (String)call.getObject(1);
                    if (mensaje.equals("OK")) {
                        request.setAttribute("OK",
                                             "El n&uacute;mero de carpeta: " + bean.getNumopc().toString() + " se rehabilito satisfactoriamente.");
                    } else {
                        request.setAttribute("ERROR",
                                             "Se produjo un error al rehabilitar el n&uacute;mero de carpeta: " +
                                             bean.getNumero().toString());
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
