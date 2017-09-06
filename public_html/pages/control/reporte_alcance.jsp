<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="anb.bean.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>
<style type="text/css">
        table, td {
            font-family: 'Times New Roman', 'Arial Black', times, Serif;
            border-color: Black;
            border-style: solid;
            font-size: 10px;
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
<div id="formulario">
    <%
        ReporteForm bean = new ReporteForm();
        bean = (ReporteForm)request.getSession().getAttribute("ReporteForm");
        int cantidad = (Integer)request.getSession().getAttribute("canttram");
        String control = "";
        if(bean.getFcontrol().equals("DIFERIDO")){
            control = "CD";
        }else{
            control = "FAP";
        }
try
{
    if(cantidad == 0) {
    %>
    <table width="710px">        
        <tr>
            <td style="width:710px; height:100px">
                <center>
                    <label style="font-size:16px;">
                        <strong>NO EXISTEN TRÁMITES AMPLIADOS PARA EL NÚMERO DE FISCALIZACIÓN <br/>${infoControl2.codigoControl}</strong>
                    </label>
                </center>
            </td>
        </tr>
    </table>
    <%}
    else {
    if(!(bean.getCodigo()== null))
    { %>
    <table width="710px">
        <tr>
            <td style="width:50px;height:0px; padding:0px"></td>
            <td style="width:50px;height:0px; padding:0px"></td>
            <td style="width:180px;height:0px; padding:0px"></td>
            <td style="width:180px;height:0px; padding:0px"></td>
            <td style="width:50px;height:0px; padding:0px"></td>
            <td style="width:50px;height:0px; padding:0px"></td>
            <td style="width:50px;height:0px; padding:0px"></td>
            <td style="width:50px;height:0px; padding:0px"></td>
            <td style="width:50px;height:0px; padding:0px"></td>
        </tr>
         
        <tr>
            <td align="center" style=" height:100px" colspan="9">
                <center>
                    <label style="font-size:20px;">
                        <strong>ORDEN DE FISCALIZACIÓN No.:
                            ${infoControl2.codigoControl}<br>DETALLE DE TRÁMITES A FISCALIZAR</strong>
                    </label>
                </center>
            </td>
        </tr>
        <tr>
                            <td style="text-align:center;font-weight:bold" rowspan="2">Correlativo</td>
                            <td style="text-align:center;font-weight:bold" rowspan="2">Item</td>
                            <td style="text-align:center;font-weight:bold" rowspan="2">Trámite</td>
                            <td style="text-align:center;font-weight:bold" rowspan="2">Tipo Trámite</td>
                            <td style="text-align:center;font-weight:bold" rowspan="2">Fecha</td>
                            <td style="text-align:center;font-weight:bold" colspan="4">Alcance</td>
        </tr>
        <tr>
                            <td style="text-align:center;font-weight:bold">Valor</td>
                            <td style="text-align:center;font-weight:bold">Origen</td>
                            <td style="text-align:center;font-weight:bold">Clasificación Arancelaria</td>
                            <td style="text-align:center;font-weight:bold">Otro</td>
        </tr>
         
        <tr>
            
                        <c:forEach items="${tramites2}" var="tra">
                            <tr>
                                <td style="text-align:center">
                                    ${tra.numero}
                                </td>
                                <td style="text-align:center">
                                    ${tra.item}
                                </td>
                                <td style="text-align:left">
                                    ${tra.tramite}
                                </td>
                                <td style="text-align:left">
                                   ${tra.tipoTramite}
                                </td>
                                <td style="text-align:center">
                                    ${tra.fecha}
                                </td>
                                <td style="text-align:center">
                                    ${tra.valor}
                                </td>
                                <td style="text-align:center">
                                    ${tra.origen}
                                </td>
                                <td style="text-align:center">
                                    ${tra.partida}
                                </td>
                                <td style="text-align:center">
                                    ${tra.otro}
                                </td>
                            </tr>
                        </c:forEach>
                   
    </table>
    <%}
    }
      
      }catch (Exception er) 
  {
    er.printStackTrace();
  } 
  finally 
  {}%>
</div>