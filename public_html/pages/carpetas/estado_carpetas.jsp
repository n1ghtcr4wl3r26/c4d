<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="java.sql.*, anb.bean.*, java.text.*,  java.util.*, anb.general.*"%>
<div class="panel panel-default" >
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>N&uacute;meros Generados</strong>
        </h4>        
    </div>
    <br/>
    <div class="panel-body">
    <%
        ConexionCad dc = new ConexionCad();
        Connection con = null;
        CallableStatement call = null;
        ResultSet l_rset = null;
        String StrSql;
    %>
    <div  align="center" class="panel-body form-horizontal col-lg-7 col-sm-7">
    <table class="table table-striped table-hover">
        <thead>
            <tr>
                <td colspan="3" align="center">
                    <b>ULTIMO PARAMETRO HABILITADO</b>
                </td>
            </tr>  
        </thead>
        <tbody>
            <tr>
                <th>N&Uacute;MERO MAXIMO</th>
                <th>USUARIO</th>
                <th>FECHA</th>
            </tr>         
            <%
            try{
                con = dc.abrirConexion();
                StrSql = "SELECT a.cad_maximo , a.cad_usuario, to_char(a.cad_fecha,'dd/mm/yyyy hh24:mi') FROM OPS$ASY.CORR_PARAMETROS a WHERE a.lst_ope = 'U' ORDER BY a.cad_fecha desc";
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
    <table class="table table-striped table-hover">        
        <thead>
            <tr>
                <td colspan="3" align="center">
                    <b>ULTIMA ACCION DE USUARIO</b>
                </td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th>RANGO</th>
                <th>USUARIO</th>
                <th>FECHA</th>
            </tr>         
            <%
            try{
                con = dc.abrirConexion();
                StrSql = "SELECT a.cad_secuencial_inicial ||'-'|| a.cad_secuencial_final, a.cad_usuario,to_char(a.cad_fecha,'dd/mm/yyyy hh24:mi') FROM OPS$ASY.corr_usuarios a ORDER BY a.cad_fecha desc";
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
</div>