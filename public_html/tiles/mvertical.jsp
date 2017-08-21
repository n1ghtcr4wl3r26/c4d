<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<html:html>
  <head>
    <meta name="Author" content="Gabriela del Llano Archondo" lang="es">
    <meta name="copyright" content="&copy; 2008, Aduana Nacional de Bolivia" lang="es">
    <link href="css/Estilos.css" rel="stylesheet" type="text/css" media="screen"/>     
  </head>
<html:errors/>
<body>
  <title><tiles:getAsString name="title"/></title>
  <div align="center">
  <table style="width:960px;" border=0 cellpadding=0 cellspacing=0 class="m">
    <tr height="20px">
      <td colspan="2"><tiles:insert attribute="header"/></td>
    </tr>
    <tr> 
      <td width="20%" valign="top" align="center"><tiles:insert attribute="vertical"/></td>
      <td width="*"><tiles:insert attribute="body"/></td>
    </tr>
      <tr height="50px">
      <td colspan="2" class="s9">&nbsp;</td>
    </tr>
    <tr height="20px">
      <td colspan="2" class="s9"><tiles:insert attribute="footer"/></td>
    </tr>
  </table>
  
  
  
  
</body>
</html:html>