<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="anb.bean.*"%>
<%@ page import="anb.general.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>
<style type="text/css">
table, td
{
    font-family:'Times New Roman', 'Arial Black', times, Serif;
    border-color:Black ;
    border-style:solid;
    font-size:12px;
}

table
{
border-width: 0 0 1px 1px;
border-spacing: 0px;
border-collapse: collapse;
}
td{
margin:0;
padding:7px;
border-width: 1px 1px 0 0;
background-color: White;
}

</style>

    <div id="formulario" style="line-height:16pt">
        <%
        ReporteForm bean = new ReporteForm();
        bean = (ReporteForm)request.getSession().getAttribute("ReporteForm");
        String control = "";
        if(bean.getFcontrol().equals("DIFERIDO")){
            control = "CD";
        }else{
            control = "FAP";
        }
try
{
    if(!(bean.getCodigo()== null))
    {
       
        %>
      
          <table width="710px" style="line-height:16pt">
          <tr><td style="width:30px;height:0px; padding:0px"></td><td style="width:100px;height:0px; padding:0px"></td><td style="width:100px;height:0px; padding:0px"></td><td style="width:300px;height:0px; padding:0px"></td><td style="width:50px;height:0px; padding:0px"></td><td style="width:130px;height:0px; padding:0px"></td></tr>
<tr><td align="center" style="width:130px; height:100px" colspan="2" >
<img src="../../img/logo_adu.jpg" width="150px" height="100px"  /></td>
<td style="width:450px; height:100px" colspan="4" ><center><label style="font-size:20px;"><strong>NOTIFICACIÓN DE INICIO DE FISCALIZACIÓN</strong></label></center></td>
 

</tr>
<tr><td colspan="6" style="height:5px; padding:0px; ">&nbsp;</td></tr>

<tr><td colspan="6" style="text-align:justify">
En cumplimiento de la Orden de Fiscalización N° ${infoControl2.codigoControl} de ${infoControl2.fechaRegistro} se inicia la fiscalización al Operador ${infoControl2.nomIdentificacion} con ${infoControl2.tipoDocIdentificacion} ${infoControl2.docIdentificacion}.
<br/>
Para dicho fin se solicita:<br/>
<strong>1.</strong> Designar un representante, responsable de coordinar y proporcionar la información requerida por los Fiscalizadores  en el curso de su trabajo.  
<br/>
<strong>2.</strong>  <%=Util.devuelveDireccionGerencia(bean.getFgerencia())%>, fotocopias 
     legalizadas de la documentación e información detallada (1),  <strong>en el término improrrogable de diez (10) días hábiles</strong> a    
     partir de la recepción de la presente notificación:
<br/>

<tr><td colspan="6">

<c:if test="${infoControl2.inn_1 == 'on' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> Número de Identificación Tributaria.<br/>
</c:if>
<c:if test="${infoControl2.inn_2 == 'on' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> Cédula de identidad del Operador.<br/>
</c:if>
<c:if test="${infoControl2.inn_3 == 'on' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> Cédula de identidad y Poder del Representante Legal.<br/>
</c:if>
<c:if test="${infoControl2.inn_4 == 'on' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> Escritura de Constitución de la Empresa.<br/>
</c:if>
<c:if test="${infoControl2.inn_5 == 'on' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> Plan de Cuentas gestión(es) ${infoControl2.periodosolicitar}<br/>
</c:if>
<c:if test="${infoControl2.inn_6 == 'on' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> Estados Financieros gestión (es) ${infoControl2.periodosolicitar}<br/>
</c:if>
<c:if test="${infoControl2.inn_7 == 'on' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> Contratos con proveedores de las DUIs fiscalizadas.<br/>
</c:if>
<c:if test="${infoControl2.inn_8 == 'on' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> Kardex físico valorado gestión(es) ${infoControl2.periodosolicitar}<br/>
</c:if>
<c:if test="${infoControl2.inn_9 == 'on' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> Mayores Contables gestión(es) ${infoControl2.periodosolicitar}<br/>
</c:if>
<c:if test="${infoControl2.inn_10 == 'on' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> Comprobantes Contables gestión(es) ${infoControl2.periodosolicitar}<br/>
</c:if>
<c:if test="${infoControl2.inn_11 == 'on' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> Dirección de Correo Electrónico y Número de Teléfono y Fax.<br/>
</c:if>

<c:if test="${infoControl2.innv_12 == '1' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> ${infoControl2.inn_12}<br/>
</c:if>
<c:if test="${infoControl2.innv_13 == '1' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> ${infoControl2.inn_13}<br/>
</c:if>
<c:if test="${infoControl2.innv_14 == '1' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> ${infoControl2.inn_14}<br/>
</c:if>
<c:if test="${infoControl2.innv_15 == '1' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> ${infoControl2.inn_15}<br/>
</c:if>
<c:if test="${infoControl2.innv_16 == '1' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> ${infoControl2.inn_16}<br/>
</c:if>
<c:if test="${infoControl2.innv_17 == '1' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> ${infoControl2.inn_17}<br/>
</c:if>
<c:if test="${infoControl2.innv_18 == '1' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> ${infoControl2.inn_18}<br/>
</c:if>
<c:if test="${infoControl2.innv_19 == '1' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> ${infoControl2.inn_19}<br/>
</c:if>
<c:if test="${infoControl2.innv_20 == '1' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> ${infoControl2.inn_20}<br/>
</c:if>
<c:if test="${infoControl2.innv_21 == '1' }">
&nbsp;&nbsp;&nbsp;<strong>•</strong> ${infoControl2.inn_21}<br/>
</c:if>
<br/>
<strong>(1)	  Toda la documentación requerida, deberá ser legalizada con el sello y firma del operador, incluyendo la fecha de
Legalización.</strong>

</td></tr>

<tr><td colspan="6">

<strong>NOTIFICACIÓN</strong><br/>

En la ciudad de _________ el día  _________________________________________________del año ________________  ___/___/_____ a horas___________(numeral) _________________________________________(literal)  notifiqué personalmente al Operador ${infoControl2.nomIdentificacion} con ${infoControl2.tipoDocIdentificacion} ${infoControl2.docIdentificacion}, 
<c:if test="${infoControl2.tipoEmpresa == 'EMPRESA' }">
representado legalmente por el Sr.(a) _______________________________________ con C.I. ____________, 
</c:if>
el inicio de la fiscalización conforme la Orden de Fiscalización N° ${infoControl2.codigoControl} de ${infoControl2.fechaRegistro}, en su domicilio ubicado en la ${infoControl2.direccion}, quien recibió copia del mismo en mano propia, firmando como constancia la presente.
<br/>

<br/><br/><br/>
<center><strong>Firma del Notificado o Testigo</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>Firma del Funcionario de Aduana</strong></center>
<center><strong>&nbsp;&nbsp;&nbsp;&nbsp;C.I.__________________</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>C.I.__________________</strong></center>
<br/><br/><br/>

</td></tr>


</table>   
        
        
      <%}
      
      }catch (Exception er) 
  {
    er.printStackTrace();
  } 
  finally 
  {}%>   
        
       
   
       
       
       
       
       
       
       
    </div>