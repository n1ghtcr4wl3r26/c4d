<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ page import="cad.*"%>

<table border="0" width="100%">
  <tr><td align="center"> 
  <html:img hspace="0" src="imagen/cad.jpg" /> 
  </td></tr>
   <tr><td align="center">
  <table border="0" width="950px"  id="a">
<tr ><th width="45px">Usuario:</th><td><%=request.getSession().getAttribute("user") %></td>

<th>Perfil:</th><td><%=request.getSession().getAttribute("user.perfil") %></td>
<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
</tr>
</table>
  
  </td></tr>
  
</table>