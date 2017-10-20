<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="java.sql.*, anb.bean.*, java.text.*,  java.util.*, anb.general.*"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>CONSULTA DISTRIBUCIÓN</strong>
        </h4>
    </div>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-consultadistribucion" action="consultadistribucion.do">
            <input type="hidden" name="boton" id="boton"/>
            <div class="form-group">
                <label class="col-sm-4 control-label label-required">Gerencia:</label>
                <label class="col-sm-2 control-label label-required">Fecha Desde:</label>
                <label class="col-sm-2 control-label label-required">Fecha Hasta:</label>
            </div>
            <div class="form-group">
                <div class="col-sm-4">
                    <html:select property="gerencia" styleClass="form-control required">
                        <html:option value="-">Seleccione...</html:option> 
                        <html:option value="GRLPZ">Gerencia Regional La Paz</html:option> 
                        <html:option value="GRCBB">Gerencia Regional Cochabamba</html:option> 
                        <html:option value="GRORR">Gerencia Regional Oruro</html:option>
                        <html:option value="GRPTS">Gerencia Regional Potosi</html:option>
                        <html:option value="GRTRJ">Gerencia Regional Tarija</html:option>
                        <html:option value="GRSCZ">Gerencia Regional Santa Cruz</html:option>
                    </html:select>
                </div>
                <div class="col-sm-2">
                    <html:text property="fecini" styleId="fecini" styleClass="form-control datepicker required date-less-than" size="30" maxlength="10" />
                </div>    
                <div class="col-sm-2">
                    <html:text property="fecfin" styleId="fecfin" styleClass="form-control datepicker required date-less-than" size="30" maxlength="10" />
                </div> 
            </div>
            <div class="btn-container">
                <button type="submit" id="botonsubmit" onclick="consultar()" class="btn btn-primary" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Consultar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>            
            </div>
            <div class="form-group">
                <label class="label-message-required">
                    * Campos Obligatorios
                </label>
            </div>
            <br/>
            <br/>
            <br/>
            <%
            ConsultaDistribucionForm vform = (ConsultaDistribucionForm) request.getAttribute("ConsultaDistribucionForm");
            if(vform != null && vform.getEstado()!= null && vform.getEstado().equals("OK")){
            %>
            <div class="panel-body">
                <div  align="center" class="panel-body form-horizontal col-lg-8 col-sm-8">
                    <%
                    ConexionCad dc = new ConexionCad();
                    Connection con = null;
                    CallableStatement call = null;
                    ResultSet l_rset = null;
                    String StrSql;
                    %>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <td colspan="3" align="center">
                                    <b>CARPETAS DISTRIBUIDAS</b>
                                </td>
                            </tr>  
                        </thead>
                        <tbody>
                            <tr>
                                <th>DESDE</th>
                                <th>HASTA</th>
                                <th>ADUANA</th>
                                <th>FECHA</th>
                                <th>USUARIO</th>
                            </tr>
                            <%
                            try{
                                con = dc.abrirConexion();
                                StrSql = "SELECT d.cad_secuencial || d.cad_encriptado, c.cad_secuencial || c.cad_encriptado, a.cad_aduana , to_char(a.cad_fecha,'dd/mm/yyyy HH24:mi:ss'), a.cad_usuario FROM OPS$ASY.CORR_ASIGNACIONES a, OPS$ASY.CORR_CARPETAS c, OPS$ASY.CORR_CARPETAS d WHERE a.cad_nro_carpeta_ini = d.cad_secuencial and a.cad_nro_carpeta_fin = c.cad_secuencial and a.cad_aduana LIKE '"+vform.getGerencia()+"' ";
                                StrSql = StrSql + " and TRUNC(a.cad_fecha) between to_date('"+vform.getFecini()+"','dd/mm/yyyy') and  to_date('"+vform.getFecfin()+"','dd/mm/yyyy') ORDER BY 4 desc"; 
                                l_rset = (ResultSet) dc.pQuery(con, StrSql);
                                if ( l_rset != null && l_rset.next()) {   
                                    do {
                                    %>
                                    <tr>
                                        <td>
                                            <%=l_rset.getString(1)%>
                                        </td>
                                        <td>
                                            <%=l_rset.getString(2)%>
                                        </td>
                                        <td>
                                            <%=l_rset.getString(3)%>
                                        </td>
                                        <td>
                                            <%=l_rset.getString(4)%>
                                        </td>
                                        <td>
                                            <%=l_rset.getString(5)%>
                                        </td>
                                    </tr>
                                    <%
                                    } while (l_rset.next());
                                } else {
                                    %>
                                    <tr>
                                        <td colspan="5">
                                            No existen Números de Carpetas distribuidas.
                                        </td>
                                    </tr>
                                    <%
                                }
                            }
                            catch (Exception e) { 
                                System.out.println(e.toString()); 
                                %>
                                <tr>
                                    <td colspan="5">
                                        <b>Error:</b>
                                        <%=e.toString()%>
                                    </td>
                                </tr>
                                <% 
                            }
                            finally {
                            %>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="5">
                                    &nbsp;
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                        <%
                            try {
                                if (l_rset != null) {
                                    l_rset.close();
                                }
                                if (con != null) {
                                    con.close();
                                }
                            } catch (SQLException e) {
                                ;
                            }
                        }
                        %>  
                </div>
            </div>
            <%}%>
        </html:form>
    </div>
</div>
<script>
  $(document).ready(function () {
      Anb.form.submit('#form-consultadistribucion', function (form) {
          Anb.form.cleanErrors(form);
          if (Anb.validate.run(form)) {
              $("#boton").val('Verifica');
              console.log('Enviado!');
              Anb.loading.show()
              form.submit();
          }
      });
      $("#botonsubmit").removeAttr("disabled");
  });

      function consultar() {
          $("#boton").val('Verificar');

      }
</script>