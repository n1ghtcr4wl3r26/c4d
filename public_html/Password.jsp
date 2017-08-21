<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
   <link href="css/Estilos.css" rel="stylesheet" type="text/css" media="screen"/>
   <title>Cambio de Contraseña</title>
    <script language="JavaScript" type="text/JavaScript" src="jscript/consulta.js"></script>
</head>

<body>
  <html:form action="/password" focus="txt_pasant"  >
   <table width=70% align="center" class="soloborde" bgcolor="#C1C1FF">
       <tr> <td colspan="2" class="FondoVerde" align=left><b>INTRODUZCA NUEVA CONTRASEÑA.</b></td> </tr>
       <tr> <td colspan="2" class="parath" align="right" > <b>USUARIO:</b> 
            <%=(String)request.getSession().getAttribute("user.nick")%>
       </td></tr>
              <tr><td class="parath">CONTRASEÑA ANTERIOR : </td>
                  <td><html:password property="txt_pasant"  size="30" maxlength="30" redisplay="false"/></td>
              </tr>
              <tr><td class="parath">CONTRASEÑA NUEVA :</td>
                  <td><html:password property="txt_pas"  size="30" maxlength="30" redisplay="false"/></td>
              </tr>
              <tr><td class="parath">CONFIRMAR CONTRASEÑA :</td>
                  <td><html:password property="txt_confPas"  size="30" maxlength="30" redisplay="false"/> </td></tr>      
       <tr><td colspan="2" align="center">
           <html:submit property="boton" value="Aceptar" styleClass="boton1" onclick="return validaPassword();"/>
           <html:submit property="boton" value="Cancelar" styleClass="boton1" />
       </td></tr>
       <tr><td>&nbsp;</td></tr>
   </table>
  </html:form> 
</body>
</html:html>
