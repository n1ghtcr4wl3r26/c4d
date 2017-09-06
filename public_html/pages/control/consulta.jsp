<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ page import="java.sql.*, anb.bean.consultaForm, java.text.*,  java.util.*" %>

<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
   <title>Consulta Numero de Carpetas</title>
   <link href="css/Estilos.css" rel="stylesheet" type="text/css" media="screen"/>
   <script language="JavaScript" type="text/JavaScript" src="jscript/consulta.js"></script>
   
</head>
<body>
<html:form action="/consulta">
<table width="500px" align="center" class="soloborde" bgcolor="#C1C1FF">
<tr> 
  <td class="FondoVerde" align="center"><b>CONSULTA DE N&Uacute;MERO DE CARPETA</b></td>
</tr>
<tr>
  <td class="S10d" align="right" colspan=2></td>
</tr>
<tr>
  <td> <hr> </td>
</tr>
<tr>
  <td class="parath">Número de Carpeta a Consultar : <html:text property="numero" onblur="this.value=trimm(this.value);"  /></td>
</tr>
<tr>
  <td> <hr> </td>
</tr>
<tr>
  <td align="center"><html:submit property="boton" value="Verifica" styleClass="boton1" onclick="return fEvaluacon()" /></td>
</tr>
<%
consultaForm vform = (consultaForm) request.getAttribute("consultaForm");
try
{
%>
<tr><td><%=vform.getMensaje().toString()%></td></tr>
<%
}
catch (Exception e)
    { System.out.println(e.toString()); 
    %><%--<table><tr><td class="T8r"><b>Error:</b> <%=e.toString()%></td></tr></table>--%>
<%  }
%>
</table>
</html:form>
</body>
</html>

