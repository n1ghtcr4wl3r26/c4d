<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/sqltaglib.tld" prefix="database"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page import="anb.bean.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>
<%@ page contentType="text/html;charset=iso-8859-1"%>
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
        String control = "";
        if(bean.getFcontrol().equals("DIFERIDO")){
            control = "CD";
        }else{
            control = "FP";
        }
try
{
    if(!(bean.getCodigo()== null))
    {
       
        %>
    <table width="710px">        
        <tr>
            <td style="width:710px; height:100px">
                <center>
                    <label style="font-size:16px;">
                        <strong>NO EXISTE EL NÚMERO DE FISCALIZACIÓN ${infoControl2.codigoControl}</strong>
                    </label>
                </center>
            </td>
        </tr>
    </table>
    <%}
      
      }catch (Exception er) 
  {
    er.printStackTrace();
  } 
  finally 
  {}%>
</div>