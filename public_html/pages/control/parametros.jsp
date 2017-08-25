<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ page import="java.sql.*, anb.bean.*, java.text.*,  java.util.*" %>

<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
   <title>Archivo de Texto</title>
 <script language="JavaScript" type="text/JavaScript" src="jscript/consulta.js" ></script>
</head>
<body>
<div>
<html:form action="/parametros">
<table width="500px" align="center" class="soloborde" bgcolor="#C1C1FF">
<tr><td class="FondoVerde" align="center"><b>PARÁMETROS DE NÚMERO DE CARPETAS</b></td></tr>
<tr> <td class="S10d" align="right" colspan=2></td></tr>
<tr><td> <hr> </td></tr>
<tr><td class="parath">Número de Carpeta a Generar : <html:text property="maximo" onblur="this.value=trimm(this.value);" /></td></tr>
<tr><td> <hr> </td></tr>
<tr><td align="center"><html:submit property="boton" value="Grabar"  styleClass="boton1"  onclick="return fEvaluaparam()" /></td></tr>
<%
ParametrosForm pform = (ParametrosForm) request.getAttribute("ParametrosForm");
try
{
%>
<tr><td><%=pform.getMensaje().toString()%></td></tr>
<%
}
catch (Exception e)
    { System.out.println(e.toString()); 
    %><%--<table><tr><td class="T8r"><b>Error:</b> <%=e.toString()%></td></tr></table>--%>
<%  }
%>
</table>
</html:form>
</div>
</body>
</html>