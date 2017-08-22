<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html;charset=iso-8859-1"%>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
   <link href="css/Estilos.css" rel="stylesheet" type="text/css" media="screen"/>
   <title>Archivo de Texto</title>
   <script language="JavaScript" type="text/JavaScript" src="jscript/jquery.js"></script>
   <script language="JavaScript" type="text/JavaScript">

     $(document).ready(function() {
       $('.boton1').bind('click', function() {
           $('#ocultar').removeClass('ocultar');
       });
     });  
 
     $(document).ready(function() {
       if (document.textoForm.opcion.value==0)
         $('#ocultar').addClass('ocultar');
     });

   </script>
</head>
<body>
<html:form action="/texto">
<table width="500px" align="center" class="soloborde" bgcolor="#C1C1FF">
  <tr>
    <td class="FondoVerde" align="center"><b>GENERAR Y BAJAR ARCHIVO TEXTO DE NÚMERO DE CARPETAS</b></td>
  </tr>
  <tr> 
    <td class="S10d" align="right" colspan=2></td>
  </tr>
  <tr>
    <td> <hr> </td>
  </tr>
  <tr>
    <td align="center"><html:hidden property="opcion" name="textoForm" /><html:submit property="boton" value="Generar" styleClass="boton1" /><br>
    <div id="ocultar">
    <a href="http://172.16.2.2/carpetas/carpetas.txt">Bajar archivo texo</a>
    </div>
    </td>
  </tr>
  <tr>
    <td> <hr> </td>
  </tr>
  <tr> 
    <td class="S10d" align="right" colspan=2></td>
  </tr>
</table>
</html:form>
</body>
</html>