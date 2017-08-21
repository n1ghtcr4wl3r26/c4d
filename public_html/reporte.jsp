<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ page import="java.sql.*, cad.*, java.text.*,  java.util.*" %>

<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
   <link href="css/Estilos.css" rel="stylesheet" type="text/css" media="screen"/>
   <title>Reporte Carpetas Agencias</title>
</head>
<body>
<%
    conexion dc = new conexion();
    Connection con = null;
    CallableStatement call = null;
    ResultSet l_rset = null;
    String StrSql;
%>
<table width="500px" align="center" class="soloborde" bgcolor="#C1C1FF" id="c">
<tr><td colspan="3" align=center><b>ULTIMO PARAMETRO HABILITADO</b></td></tr>
<tr><th>N&Uacute;MERO MAXIMO</th><th>USUARIO</th><th>FECHA</th></tr>
<%
try{
   con = dc.abrirConexion();
   StrSql = "SELECT a.cad_maximo , a.cad_usuario, a.cad_fecha FROM OPS$ASY.CORR_PARAMETROS a WHERE a.lst_ope = 'U' ORDER BY a.cad_fecha desc";
   l_rset = (ResultSet) dc.pQuery(con, StrSql);
   if ( l_rset != null && l_rset.next()) {   
      do {%>
        <tr><td><%=l_rset.getString(1)%></td>
            <td><%=l_rset.getString(2)%></td>
            <td><%=l_rset.getString(3)%></td>
        </tr>
        <%} while (l_rset.next());
      }
}
catch (Exception e) { 
   System.out.println(e.toString()); %>
   <table><tr><td class="T8r"><b>Error:</b> <%=e.toString()%></td></tr></table>
<% }
finally {
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
<tr><td colspan="3" align=center><b>ULTIMA ACCION DE USUARIO</b></td></tr>
<tr><th>RANGO</td><th>USUARIO</th><th>FECHA</th></tr>
<%
try{
   con = dc.abrirConexion();
   StrSql = "SELECT a.cad_secuencial_inicial ||'-'|| a.cad_secuencial_final, a.cad_usuario,a.cad_fecha FROM OPS$ASY.corr_usuarios a ORDER BY a.cad_fecha desc";
   l_rset = (ResultSet) dc.pQuery(con, StrSql); 
   if ( l_rset != null && l_rset.next()) {   
      do {%>
        <tr>
            <td><%=l_rset.getString(1)%></td>
            <td><%=l_rset.getString(2)%></td>
            <td><%=l_rset.getString(3)%></td>
        </tr>
        <%} while (l_rset.next());
      }
}
catch (Exception e) { 
   System.out.println(e.toString()); %>
   <table><tr><td class="T8r"><b>Error:</b> <%=e.toString()%></td></tr></table>
<% }
finally {
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
</table>

</body>
</html>
