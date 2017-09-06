<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="anb.bean.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>
<style type="text/css">
table, td
{
    font-family:'Times New Roman', 'Arial Black', times, Serif;
    border-color:Black ;
    border-style:solid;
    font-size:10px;
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

    <div id="formulario">
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
      
          <table width="710px">
          <tr><td style="width:30px;height:0px; padding:0px"></td><td style="width:100px;height:0px; padding:0px"></td><td style="width:100px;height:0px; padding:0px"></td><td style="width:300px;height:0px; padding:0px"></td><td style="width:50px;height:0px; padding:0px"></td><td style="width:130px;height:0px; padding:0px"></td></tr>
<tr><td align="center" style="width:130px; height:100px" colspan="2" >
<img src="../../img/logo_adu_s.jpg" /></td>
<td style="width:450px; height:100px" colspan="3" ><center><label style="font-size:16px;"><strong>ORDEN DE ${infoControl2.tipoControl}</strong></label></center></td>


<td style="width:130px; height:100px"><label style="font-size:12px;"><strong>ORDEN DE<br/>FISCALIZACIÓN<br/>No.<br/></strong></label>
<label style="font-size:13px;"><strong>${infoControl2.codigoControl}</strong></label><br/>
<label style="font-size:12px;"><strong>Fecha: ${infoControl2.fechaRegistro}</strong></label>

</td></tr>
<tr><td colspan="6"  style="height:10px; padding:0px; ">&nbsp;</td></tr>


<tr><td colspan="6" style="text-align:justify">En aplicación del artículo 104º parágrafo I. de la Ley No.2492 y el Procedimiento Sancionatorio y de Determinación, aprobado mediante Resolución Administrativa No. RA-PE-01-029-16, la Aduana Nacional ha dispuesto la verificación del cumplimiento de la normativa legal aplicable y las formalidades aduaneras del Operador.</td></tr>
<tr><td colspan="6"><strong>I. INFORMACIÓN DEL OPERADOR</strong></td></tr>

<tr><td colspan="3">Número del ${infoControl2.tipoDocIdentificacion}:</td><td colspan="3">${infoControl2.docIdentificacion}</td></tr>
<tr><td colspan="3">Nombre o Razón Social:</td><td colspan="3">${infoControl2.nomIdentificacion}</td></tr>
<tr><td colspan="3">Dirección:</td><td colspan="3">${infoControl2.direccion}</td></tr>
<tr><td colspan="3">Actividad Principal:</td><td colspan="3">${infoControl2.actividad}</td></tr>

<tr><td colspan="6"><strong>II. TRIBUTOS A FISCALIZAR</strong></td></tr>
<tr>
    <td colspan="6"  style="text-align:justify">  
        <c:if test="${infoControl2.ga == 'SI' }">
            Gravamen Arancelario de las Importaciones (GA)
        </c:if>
        <c:if test="${infoControl2.iva == 'SI' }">
            Impuesto al Valor Agregado de la Importaciones (IVA)
        </c:if>
        <c:if test="${infoControl2.ice == 'SI' }">
            Impuesto a los Consumos Específicos Importaciones (ICE)
        </c:if>
        <c:if test="${infoControl2.iehd == 'SI' }">
            Impuesto Especial a los Hidrocarburos y sus Derivados (IEHD)
        </c:if>
        <c:if test="${infoControl2.icd == 'SI' }">
            Impuesto a los Consumos Específicos Importaciones Deportes (ICD)
        </c:if>
        <c:if test="${infoControl2.noaplica == 'SI' }">
            No Aplica (N/A)
        </c:if>
    </td>
</tr>


<tr><td colspan="6"><strong>III. ALCANCE Y PERIODO DE LA FISCALIZACIÓN</strong></td></tr>
<tr><td colspan="6" style="height:50px; vertical-align:top;text-align:justify">Trámite(s) detallados en Anexo adjunto correspondientes a la Gestión(es) ${infoControl2.periodo} 

</td></tr>

<tr><td colspan="6"><strong>IV. EQUIPO DE TRABAJO ASIGNADO</strong></td></tr>

<tr><td><strong>No.</strong></td><td colspan="2"><strong>Cargo del Funcionario</strong></td><td><strong>Nombres y Apellidos</strong></td><td colspan="2"><strong>C.I.</strong></td></tr>

<c:forEach items="${asignados2}" var="asig">
                    <tr>
                    <td>${asig.numero}</td>
                        <td colspan="2" class="text-left">${asig.cargo}</td>
                        <td class="text-left">${asig.nombre}</td>
                        <td class="text-center" colspan="2">${asig.ci}</td>                        
                    </tr>
                    </c:forEach>

<tr><td colspan="6" style="border-width: 1px 1px 0 0;height:80px"></td></tr>

<tr><td align="center" style="width:130px; height:100px" colspan="2" ><center>
&nbsp;<br/>
&nbsp;<br/>
&nbsp;<br/>
VºBº<br/>
Jefe DFO/DIA/UFR
</center>
</td>
<td colspan="4" style="border-width: 0 1px 1px 1px;"  ><center><label style="font-size:13px;">
&nbsp;<br/>
&nbsp;<br/>

<strong>Firma y Sello<br/>GERENTE</strong></label></center></td>

</tr>

</table>   
     
        <table width="710px"  style="border-width:0px;border-style:none;"><tr><td width="33%" style="border-width:0px;"><center>Ejemplar 1: Operador</center></td><td width="33%"  style="border-width:0px;"><center>Ejemplar 2: Archivo GNF</center></td><td width="33%"  style="border-width:0px;"><center>Ejemplar 3: Archivo DFO/UFR</center></td></tr></table>
        
        
      <%}
      
      }catch (Exception er) 
  {
    er.printStackTrace();
  } 
  finally 
  {}%>   
        
       
   
       
       
       
       
       
       
       
    </div>