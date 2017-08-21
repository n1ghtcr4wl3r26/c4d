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
<script language="javascript" type="text/javascript">
<!--
  bCancel = false;
-->
</script>
<body>



  <title><tiles:getAsString name="title"/></title>
  
  <div align="center">
  <table style="height:100%;width:960px;" border=0 cellpadding=0 cellspacing=0 class="m">
    <tr height="20px">
      <td><tiles:insert attribute="header"/></td>
    </tr>
    <tr align="center" valign="middle">
      <td><tiles:insert attribute="body"/></td>
    </tr>
    <tr height="20px">
      <td class="s9"><tiles:insert attribute="footer"/></td>
    </tr>
  </table>
  </div>
</body>
</html:html>