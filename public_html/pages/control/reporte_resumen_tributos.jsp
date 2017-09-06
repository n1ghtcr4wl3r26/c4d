<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="anb.bean.*"%>
<%@ page import="anb.general.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>
<style type="text/css">
        table, td {
            font-family: 'Times New Roman', 'Arial Black', times, Serif;
            border-color: Black;
            border-style: solid;
            font-size: 12px;
        }

        table {
            border-width: 0 0 1px 1px;
            border-spacing: 0px;
            border-collapse: collapse;
        }

        td {
            margin: 0;
            padding: 7px;
            border-width: 1px 1px 0 0;
            background-color: White;
        }
    </style>
<div id="formulario" style="line-height:16pt">
    <%
        TributosOmitidosForm gen = (TributosOmitidosForm)request.getSession().getAttribute("TributosOmitidosForm");
        String control = "";
        if(gen.getFcontrol().equals("DIFERIDO")){
            control = "CD";
        }else{
            control = "FAP";
        }
  
try
{
    if(!(gen.getCodigo()== null))
    {
       
        %>
    <table width="710px" style="line-height:16pt">
        <tr>
            <td style="width:30px;height:0px; padding:0px"></td>
            <td style="width:100px;height:0px; padding:0px"></td>
            <td style="width:100px;height:0px; padding:0px"></td>
            <td style="width:300px;height:0px; padding:0px"></td>
            <td style="width:50px;height:0px; padding:0px"></td>
            <td style="width:130px;height:0px; padding:0px"></td>
        </tr>
         
        <tr>
            <td align="center" style="width:130px; height:100px" colspan="2">
                <img src="../../img/logo_adu.jpg" width="150px" height="100px"/>
            </td>
            <td style="width:450px; height:100px" colspan="4">
                <center>
                    <label style="font-size:20px;">
                        <strong>CUADRO RESUMEN DEL ADEUDO TRIBUTARIO</strong>
                    </label>
                </center>
            </td>
        </tr>
         
        <tr>
            <td colspan="6" style="height:5px; padding:0px; ">
                <label style="font-size:14px;text-align:left">
                    GERENCIA NACIONAL DE FISCALIZACION<br/>
                    DEPARTAMENTO DE FISCALIZACION A OPERADORES<br/>
                    FISCALIZACION ADUANERA POSTERIOR                    
                </label>
            </td>
        </tr>
         
        <tr>
            <td colspan="6" style="text-align:justify">
                <table width="100%" border="0" cellspacing="0">
                    <tr>
                        <td colspan="2">
                            <label style="font-size:13px;text-align:left">
                                OPERADOR:                    
                            </label>
                        </td>
                        <td colspan="4">
                            <label style="font-size:13px;text-align:left">
                                ${infoControl.nomIdentificacion}                    
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label style="font-size:13px;text-align:left">
                                NIT/CI:                    
                            </label>
                        </td>
                        <td colspan="4">
                            <label style="font-size:13px;text-align:left">
                                ${infoControl.docIdentificacion}                  
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label style="font-size:13px;text-align:left">
                                N° DE CONTROL POSTERIOR :                    
                            </label>
                        </td>
                        <td colspan="4">
                            <label style="font-size:13px;text-align:left">
                                ${infoControl.codigoControl}                    
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <label style="font-size:13px;text-align:left">
                                FECHA:                    
                            </label>
                        </td>
                        <td colspan="4">
                            <label style="font-size:13px;text-align:left">
                                ${infoControl.fechaRegistro}                    
                            </label>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td colspan="6" style="text-align:justify">
                <table width="100%" border="0" cellspacing="0">
                    <tr>
                        <td colspan="4">
                            <label style="font-size:13px;text-align:right">
                                Actualizado al:                    
                            </label>
                        </td>
                        <td colspan="2">
                            <label style="font-size:13px;text-align:right">
                                ${TributosOmitidosForm.ffecha}                    
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <label style="font-size:13px;text-align:right">
                                Fecha de Generación del reporte:                   
                            </label>
                        </td>
                        <td colspan="2">
                            <label style="font-size:13px;text-align:right">
                               ${TributosOmitidosForm.fechahoy}                
                            </label>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td colspan="6">
                <% 
                if(!(gen.getOpcion() == null) && (gen.getOpcion().equals("CONSULTAR"))) {
                %>
                <table style="line-height:16pt" width="100%" border="0" cellspacing="0">
                    <thead>
                        <tr>
                            <td style="font-size:12px;text-align:center">N&uacute;mero</td>
                            <td style="font-size:12px;text-align:center">DUI</td>
                            <td style="font-size:12px;text-align:center">Fecha Validación</td>
                            <td style="font-size:12px;text-align:center">GA Bs.</td>
                            <td style="font-size:12px;text-align:center">IVA Bs.</td>
                            <td style="font-size:12px;text-align:center">ICE Bs.</td>
                            <td style="font-size:12px;text-align:center">IEHD Bs.</td>
                            <td style="font-size:12px;text-align:center">ICD Bs.</td>
                            <td style="font-size:12px;text-align:center">Total a Pagar Bs.</td>
                        </tr>
                    </thead>
                     
                    <tbody>
                        <c:forEach items="${tributosOm}" var="esc">
                            <tr>
                                <td style="font-size:11px;text-align:center">
                                    ${esc.numero}
                                </td>
                                <td style="font-size:11px;text-align:left">
                                    ${esc.dui}
                                </td>
                                <td style="font-size:11px;text-align:center">
                                    ${esc.fechareg}
                                </td>
                                <td style="font-size:11px;text-align:right">
                                    ${esc.ga}
                                </td>
                                <td style="font-size:11px;text-align:right">
                                    ${esc.iva}
                                </td>
                                <td style="font-size:11px;text-align:right">
                                    ${esc.ice}
                                </td>
                                <td style="font-size:11px;text-align:right">
                                    ${esc.iehd}
                                </td>
                                <td style="font-size:11px;text-align:right">
                                    ${esc.icd}
                                </td>
                                <td style="font-size:11px;text-align:right">
                                    ${esc.total}
                                </td>   
                            </tr>
                        </c:forEach>
                        <tr>
                            <td style="font-size:12px;text-align:left" colspan="8">
                                Total Deuda Tributaria Bs.
                            </td>
                            <td style="font-size:11px;text-align:right">
                                 ${tributosOmtot.total}
                            </td>
                        </tr>
                        <tr>
                            <td style="font-size:12px;text-align:left" colspan="8">
                                Sanción por Omisión de Pago Código 235 Bs.
                            </td>
                            <td style="font-size:11px;text-align:right">
                                 ${tributosOmtot.sancionomision}
                            </td>
                        </tr>
                        <tr>
                            <td style="font-size:12px;text-align:left" colspan="8">
                                Contravencion Aduanera relacionada con la DUI Cod. 167 Bs.
                            </td>
                            <td style="font-size:11px;text-align:right">
                                 ${tributosOmtot.contravdui}
                            </td>
                        </tr>
                        <tr>
                            <td style="font-size:12px;text-align:left" colspan="8">
                                Contravenciones Aduaneras relacionadas con la Orden Cod. 167 Bs.
                            </td>
                            <td style="font-size:11px;text-align:right">
                                 ${tributosOmtot.contravorden}
                            </td>
                        </tr>
                        <tr>
                            <td style="font-size:12px;text-align:left" colspan="8">
                                Sanción por Contrabando Contravencional 235 Bs.
                            </td>
                            <td style="font-size:11px;text-align:right">
                                 ${tributosOmtot.sancioncontrabando}
                            </td>
                        </tr>
                        <tr>
                            <td style="font-size:12px;text-align:left" colspan="8">
                                Sanción por Defraudación Cod 169 Bs.
                            </td>
                            <td style="font-size:11px;text-align:right">
                                 ${tributosOmtot.sanciondefraudacion}
                            </td>
                        </tr>
                        <tr>
                            <td style="font-size:12px;text-align:left" colspan="8">
                                Sanción por  Delito Cod 236 Bs.
                            </td>
                            <td style="font-size:11px;text-align:right">
                                 ${tributosOmtot.delito}
                            </td>
                        </tr>
                        <tr>
                            <td style="font-size:12px;text-align:left" colspan="8">
                                <strong>
                                    Total Adeudo Bs.
                                </strong>
                            </td>
                            <td style="font-size:12px;text-align:right">
                                <strong>
                                    ${tributosOmtot.totalfinal}
                                </strong>
                            </td>
                        </tr>                    
                    </tbody>
                </table>                
                <%                  
                }
                %>    
            </td>
        </tr>        
    </table>
    <%}      
      }catch (Exception er) 
      {
        er.printStackTrace();
      } 
      finally 
      {
      }
    %>
</div>