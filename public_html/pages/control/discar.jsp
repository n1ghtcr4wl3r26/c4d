


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
<html:form action="/discar" >
<table width="500px" align="center" class="soloborde" bgcolor="#C1C1FF">
<tr> 
  <td class="FondoVerde" align="center" colspan=2><b>DISTRIBUCION DE CARPETAS</b></td>
</tr>
<tr>
  <td class="S10d" align="right" colspan=2></td>
</tr>
<tr>
  <td colspan=2> <hr> </td>
</tr>
<tr>
  <td class="parath">Nro. de Carpeta Desde : </td><td><html:text property="desde" onblur="this.value=trimm(this.value);"  /></td>
</tr>
<tr>
  <td class="parath">Nro. de Carpeta Hasta : </td><td><html:text property="hasta" onblur="this.value=trimm(this.value);"  /></td>
</tr>
<tr>
      <td class="parath">Gerencia: </td><td><html:select property="aduana">
        
            <html:option value="">&lt;-- Seleccione una Gerencia --&gt;</html:option> 
            <html:option value="GRLPZ">Gerencia Regional La Paz</html:option> 
            <html:option value="GRCBB">Gerencia Regional Cochabamba</html:option> 
            <html:option value="GRORR">Gerencia Regional Oruro</html:option>
            <html:option value="GRPTS">Gerencia Regional Potosi</html:option>
            <html:option value="GRTRJ">Gerencia Regional Tarija</html:option>
            <html:option value="GRSCZ">Gerencia Regional Santa Cruz</html:option>
        </html:select>
      </td>
</tr>
<tr>
  <td colspan=2> <hr> </td>
</tr>
<tr>
  <td align="center" colspan=2><html:submit property="boton" value="Verificar Disponibilidad" styleClass="boton1" onclick="return fEvaluadiscar()" /></td>
</tr>

<%
discarForm vform = (discarForm) request.getAttribute("discarForm");
try
{
%>

<tr><td colspan=2><%=vform.getMensaje().toString()%></td></tr>
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




