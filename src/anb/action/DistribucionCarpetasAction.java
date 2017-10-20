package anb.action;


import anb.bean.DistribucionCarpetasForm;

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


public class DistribucionCarpetasAction extends MappingDispatchAction {
    private final GeneralNeg gen = new GeneralNeg();

    public ActionForward distribucioncarpetasidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        DistribucionCarpetasForm bean = new DistribucionCarpetasForm();
        bean = (DistribucionCarpetasForm)request.getAttribute("DistribucionCarpetasForm");
        String link = "index";
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        }
        if (bean.getNumdesde() == null && bean.getNumhasta() == null) {
            if (!(bean.getBoton() == null) && bean.getBoton().equals("Distribucion")) {
                ConexionCad dc = new ConexionCad();
                Connection con = null;
                CallableStatement call = null;
                String estado;
                String nrocarpeta;
                String res;
                String vdesde;
                String vhasta;
                String cant_asig;
                String cant_desh;
                String cant_total;
                vdesde = Util.devuelve_secuencia(bean.getNumerodesde());
                vhasta = Util.devuelve_secuencia(bean.getNumerohasta());
                StringBuffer mensaje = new StringBuffer();
                if (vdesde != null && vhasta != null) {
                    try {
                        con = dc.abrirConexion();
                        call = con.prepareCall("{call ops$asy.carpetas2.verifica_asignacion(?,?,?,?,?,?,?,?) }");
                        call.setString(1, bean.getNumerodesde());
                        call.setString(2, bean.getNumerohasta());
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
                        String tbl = "";
                        if (res == null) {
                            if (!(cant_total.equals("0"))) {
                                if (!(cant_asig.equals("0"))) {
                                    mensaje.append("De las " + cant_total + " seleccionadas, hay " + cant_asig +
                                                   " carpetas que se encuentran ya asignadas a una Gerencia");
                                    request.setAttribute("ERROR", mensaje);
                                }
                                if (cant_asig.equals("0")) {
                                    tbl =
                                    tbl + "<input type='hidden' name='numdesde' id='numdesde' value='" + Util.devuelve_secuencia(bean.getNumerodesde()) + "'/>" +
                                      "<input type='hidden' name='numhasta' id='numhasta' value='" + Util.devuelve_secuencia(bean.getNumerohasta()) + "'/>" +
                                      "<table class=\"table table-striped table-hover\">";
                                    tbl = tbl + "<thead><tr><th><b>Distribución de Carpetas</b></th></tr></thead>";
                                    tbl =
                                    tbl + "<tbody><tr><td>" + "Asignar " + cant_total + " carpetas a la " + Util.devuelve_gerencia(bean.getGerencia().toString()) +
                                      "</td></tr>";
                                    if (!(cant_desh.equals("0"))) {
                                        tbl =
                                        tbl + "<tr><td>" + cant_desh + " carpetas que se encuentran deshabilitadas</td></tr>";
                                    }
                                    tbl =
                                    tbl + "<tr><td>" + "<button class='btn btn-info btn-sm newHide' type='button' id='btnasig' title='Asignar Carpetas' onclick='asig()'>" +
                                      "<i class='fa fa-percent'></i> Asignar Carpetas</button>" + "</td></tr>";
                                    tbl = tbl + "</table>";
                                    bean.setResultado(tbl);
                                    request.setAttribute("DistribucionCarpetasForm", bean);
                                }
                            } else {
                                mensaje.append("No se encontraron Carpetas para realizar la asignaci&oacute;n");
                                request.setAttribute("WARNING", mensaje);
                            }
                        } else {
                            mensaje.append(res);
                            request.setAttribute("OK", mensaje);
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
                } else {
                    if (vdesde == null)
                        mensaje.append("El N&uacute;mero de carpeta dede:" + bean.getNumerodesde() +
                                       ", no corresponde a una carpeta v&aacute;lida <br/>");
                    if (vhasta == null)
                        mensaje.append("El N&uacute;mero de carpeta hasta:" + bean.getNumerohasta() +
                                       ", no corresponde a una carpeta v&aacute;lida ");
                    request.setAttribute("ERROR", mensaje);
                }
            }
        } else {
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("Asignar")) {
                request.setAttribute("OK",
                                     Util.asignacion_carpetas(bean.getNumdesde(), bean.getNumhasta(), bean.getGerencia(),
                                                              usuario));
            }
        }
        return mapping.findForward(link);
    }
}
