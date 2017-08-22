<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ page import="java.sql.*, cad.*, java.text.*,  java.util.*" %>

<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
   <link href="css/Estilos.css" rel="stylesheet" type="text/css" media="screen"/>
   <title>Gestión de Carpetas</title>
    <script language="JavaScript" type="text/JavaScript" src="jscript/consulta.js"></script>
</head>
<body>
<html:form action="/asicar" >
<table width="500px" align="center" class="soloborde" bgcolor="#C1C1FF">
<tr> 
  <td class="FondoVerde" align="center" colspan="2"><b>ASIGNACION DE CARPETAS</b></td>
</tr>
<tr>
  <td class="S10d" align="right" colspan=2></td>
</tr>
<tr>
  <td colspan="2"> <hr> </td>
</tr>
<tr>
  <td class="parath">Nro de NIT : </td><td><html:text property="nit" onblur="this.value=trimm(this.value);" /></td>
</tr>
<tr>
  <td class="parath">Nro de Carpeta :  </td><td><html:text property="numero" onblur="this.value=trimm(this.value);" /></td>
</tr>

<tr>
  <td colspan=2> <hr> </td>
</tr>
<tr>
  <td align="center" colspan=2><html:submit property="boton" value="Asociar" styleClass="boton1" onclick="return fEvaluaasicar()" /></td>
</tr>

<%
asicarForm vform = (asicarForm) request.getAttribute("asicarForm");
try
{
%>

<tr><td align="center" colspan=2><%=vform.getMensaje().toString()%></td></tr>
<%
}
catch (Exception e)
    { System.out.println(e.toString()); 
    %><%--<table><tr><td class="T8r"><b>Error:</b> <%=e.toString()%></td></tr></table>--%>
<%  }
%>
</table>

<%
try
{
%>
<center><%=vform.getMensaje2().toString()%></center>
<%
}
catch (Exception e)
    { System.out.println(e.toString()); 
     }
%>

</html:form>
</body>
</html>


