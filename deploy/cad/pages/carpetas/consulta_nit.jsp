<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="java.sql.*, anb.bean.*, java.text.*,  java.util.*, anb.general.*"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>CONSULTA NIT</strong>
        </h4>
    </div>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-consultanit" action="consultanit.do">
            <input type="hidden" name="boton" id="boton"/>
            <div class="form-group">
                <label class="col-sm-4 control-label label-required">N&uacute;mero de NIT:</label>
                <label class="col-sm-2 control-label label-required">Fecha Desde:</label>
                <label class="col-sm-2 control-label label-required">Fecha Hasta:</label>
            </div>
            <div class="form-group">
                <div class="col-sm-4">
                    <html:text property="numero" styleId="numero" maxlength="20" styleClass="form-control required numeric" size="15"/>
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
            ConsultaNitForm vform = (ConsultaNitForm) request.getAttribute("ConsultaNitForm");
            if(vform != null && vform.getEstado()!= null && vform.getEstado().equals("OK")){
            %>
            <div class="panel-body">
                <div  align="center" class="panel-body form-horizontal col-lg-6 col-sm-6">
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
                                    <b>CARPETAS ASOCIADAS</b>
                                </td>
                            </tr>  
                        </thead>
                        <tbody>
                            <tr>
                                <th>N&Uacute;MERO CARPETA</th>
                                <th>FECHA ASOCIACI&Oacute;N</th>
                                <th>USUARIO</th>
                            </tr>         
                            <%
                            try{
                                con = dc.abrirConexion();
                                StrSql = "SELECT a.cad_secuencial || a.cad_encriptado, to_char(a.cad_nit_fecha,'dd/mm/yyyy HH24:mi:ss') , nvl(a.cad_nit_usuario,'-') FROM OPS$ASY.CORR_CARPETAS a WHERE a.cad_nit ='"+vform.getNumero()+"' "; 
                                StrSql = StrSql + "and to_date(to_char(cad_nit_fecha,'dd/mm/yyyy'),'dd/mm/yyyy') between to_date('"+vform.getFecini()+"','dd/mm/yyyy') and  to_date('"+vform.getFecfin()+"','dd/mm/yyyy') and  a.lst_ope = 'U' ORDER BY a.cad_fecha desc";
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
                                    </tr>         
                                    <%
                                    } while (l_rset.next());
                                } else {
                                    %>
                                    <tr>
                                        <td colspan="3">
                                            No existen Números de Carpetas asociados.
                                        </td>
                                    </tr>
                                    <%
                                }
                            }
                            catch (Exception e) { 
                                System.out.println(e.toString()); 
                                %>
                                <tr>
                                    <td colspan="3">
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
                                <td colspan="3">
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
        Anb.form.submit('#form-consultanit', function (form) {
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
    function consultar(){
        $("#boton").val('Verificar');  
        
       
    }
</script>