<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ page import="cad.*"%>
<html>
  <head>
    <meta name="Author" content="Fidel Aguilar Flores" lang="es">
    <meta name="copyright" content="&copy; 2010, Aduana Nacional de Bolivia" lang="es">
    <link href="css/Estilos.css" rel="stylesheet" type="text/css" media="screen"/>
    <script language="JavaScript" type="text/JavaScript" src="Validaciones.js"></script>
  </head>

<html:errors />
<body>
<table border="0" width="100%">
  <tr><td align="center"> 
  <html:img hspace="0" src="imagen/cad.jpg" /> 
  </td></tr>
</table>
<html:form action="/ingreso" focus="usuario">
<div class="centrar">
<table width="500px" class="soloborde">
  <tr><td class="FondoVerdeTitulo" colspan="2">ADUANA NACIONAL DE BOLIVIA</td></tr>
  <tr><td class="FondoVerdeTitulo" colspan="2">INTRODUZCA USUARIO Y CONTRASEÑA</td></tr>
  <tr>
    <th class="parath">USUARIO:</th>
    <td> <html:text property="usuario"  size="30" maxlength="21" accesskey="13" onblur="this.value=this.value.toUpperCase()" /> </td>
  </tr>
  <tr>
    <th class="parath">CONTRASEÑA:</th>
    <td> <html:password property="clave"  size="30" maxlength="30" accesskey="13" redisplay="false" /></td>
  </tr>
  <tr>
    <td align="center" colspan="2"><html:submit value="Aceptar" styleClass="boton1" /></td>
  </tr>
</table>
 <%
inputActionForm me = (inputActionForm)request.getAttribute("inputActionForm");
try
{
    if(!(me.getFmensaje()== null))
    {
        if(!(me.getFmensaje()==""))
        {
        %><center><%=me.getFmensaje()%></center><%
        }
    }
}
catch(Exception ex)
{
}
%>
<br>
	<br>
	<br>
	<br>
	<br>
	<br>
<FONT face="Arial, Helvetica, san-serif" size=1 color="#023264"> 
<em> 
<center>© 2013-<%= java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) %> Aduana Nacional de Bolivia. Todos los derechos reservados. - Versión 2.0.</center>
</em>
</FONT></font> 
</div>
</html:form> 

</body>
</html>
