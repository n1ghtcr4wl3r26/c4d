<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.sql.*, anb.bean.*, java.text.*,  java.util.*, anb.general.*"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>N&uacute;meros Generados</strong>
        </h4>
    </div>
    <%
        conexion_cad dc = new conexion_cad();
        Connection con = null;
        CallableStatement call = null;
        ResultSet l_rset = null;
        String StrSql;
    %>
    <table class="table col-lg-6 col-sm-6">
        <tr>
            <td colspan="3" align="center">
                <b>ULTIMO PARAMETRO HABILITADO</b>
            </td>
        </tr>         
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
    <br/>
    <br/>
    <table class="table col-lg-6 col-sm-6">        
        <tr>
            <td colspan="3" align="center">
                <b>ULTIMA ACCION DE USUARIO</b>
            </td>
        </tr>
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