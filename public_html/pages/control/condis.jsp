<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ page import="java.sql.*, anb.bean.*, java.text.*,  java.util.*, anb.general.*" %>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Calendar" %>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
   <link href="css/Estilos.css" rel="stylesheet" type="text/css" media="screen"/>
   <title>Gestión de Carpetas</title>
    <script language="JavaScript" type="text/JavaScript" src="jscript/consulta.js"></script>
</head>
<body>
<%
condisForm vform = (condisForm) request.getAttribute("condisForm");

SimpleDateFormat fFecha = new SimpleDateFormat("dd/MM/yyyy");
  Calendar fecha = Calendar.getInstance();
  fecha.setTime( fecha.getTime() );
  String fhasta;
  String fdesde;
  if (vform == null) 
  {
      fhasta = fFecha.format( fecha.getTime() );
      fecha.add(Calendar.DATE,-30);
      fdesde = fFecha.format( fecha.getTime() );
  }
  else
  {
      if (vform.getDfecfin() == null) 
      {
        fhasta = fFecha.format( fecha.getTime() );
      }
      else
      {
        fhasta = vform.getDfecfin();
      }
      
      if (vform.getDfecini() == null) 
      {
          fecha.add(Calendar.DATE,-30);
          fdesde = fFecha.format( fecha.getTime() );
      }
      else
      {
        fdesde = vform.getDfecini();
      }
  } %>
<html:form action="/condis" >
<table width="500px" align="center" class="soloborde" bgcolor="#C1C1FF">
<tr> 
  <td class="FondoVerde" align="center" colspan=2><b>CONSULTA DISTRIBUCION DE CARPETAS</b></td>
</tr>
<tr>
  <td class="S10d" align="right" colspan=2></td>
</tr>
<tr>
  <td colspan=2> <hr> </td>
</tr>
<tr><td class="parath" >
        Fecha Desde: </td><td><html:text property="dfecini" styleId="dfecini" maxlength="10" value="<%=fdesde%>" />
        </td>
        </tr><tr>
        <td class="parath" >Fecha Hasta:</td><td>
        <html:text property="dfecfin" styleId="dfecfin" maxlength="10" value="<%=fhasta%>" />
        </td>
</tr>
<tr>
      <td class="parath" >Gerencia: </td><td>
<html:select property="aduana">
        
            <html:option value="">&lt;-- Seleccione una Gerencia --&gt;</html:option> 
            <html:option value="GRLPZ">Gerencia Regional La Paz</html:option> 
            <html:option value="GRCBB">Gerencia Regional Cochabamba</html:option> 
            <html:option value="GRORR">Gerencia Regional Oruro</html:option>
            <html:option value="GRPTS">Gerencia Regional Potosi</html:option>
            <html:option value="GRTRJ">Gerencia Regional Tarija</html:option>
            <html:option value="GRSCZ">Gerencia Regional Santa Cruz</html:option>
        </html:select>

      </td>
</tr>
<tr>
  <td colspan=2> <hr> </td>
</tr>
<tr>
  <td align="center" colspan=2><html:submit property="boton" value="Consultar" styleClass="boton1" onclick="return fEvaluacondis()" /></td>
</tr>

<%

try
{
%>

<tr><td><%=vform.getMensaje().toString()%></td></tr>
<%
}
catch (Exception e)
    { System.out.println(e.toString()); 
    %><%--<table><tr><td class="T8r"><b>Error:</b> <%=e.toString()%></td></tr></table>--%>
<%  }
%>
</table>




<%
if(vform != null)
if(vform.getAduana()!=null)
{
conexion_cad dc = new conexion_cad();
                  Connection con = null;
                  CallableStatement call = null;
                  
  
    ResultSet l_rset = null;
    String StrSql;
%>
<table width="500px" align="center" class="soloborde" bgcolor="#C1C1FF" id="c">
<tr><td colspan="5" align=center><b>CARPETAS DISTRIBUIDAS</b></td></tr>
<tr><th>DESDE</th><th>HASTA</th><th>ADUANA</th><th>FECHA</th><th>USUARIO</th></tr>
<%
try{
    con = dc.abrirConexion();
   StrSql = "SELECT d.cad_secuencial || d.cad_encriptado, c.cad_secuencial || c.cad_encriptado, a.cad_aduana , to_char(a.cad_fecha,'dd/mm/yyyy HH24:mi:ss'), a.cad_usuario FROM OPS$ASY.CORR_ASIGNACIONES a, OPS$ASY.CORR_CARPETAS c, OPS$ASY.CORR_CARPETAS d WHERE a.cad_nro_carpeta_ini = d.cad_secuencial and a.cad_nro_carpeta_fin = c.cad_secuencial and a.cad_aduana LIKE '"+vform.getAduana()+"' ";
   StrSql = StrSql + " and TRUNC(a.cad_fecha) between to_date('"+vform.getDfecini()+"','dd/mm/yyyy') and  to_date('"+vform.getDfecfin()+"','dd/mm/yyyy') ORDER BY 4 desc"; 
   
   
   l_rset = (ResultSet) dc.pQuery(con, StrSql);
   if ( l_rset != null && l_rset.next()) {   
      do {%>
        <tr><td><%=l_rset.getString(1)%></td>
            <td><%=l_rset.getString(2)%></td>
            <td><%=l_rset.getString(3)%></td>
            <td><%=l_rset.getString(4)%></td>
            <td><%=l_rset.getString(5)%></td>
        </tr>
        <%} while (l_rset.next());
      }
}
catch (Exception e) { 
   System.out.println(e.toString()); %>
   
<% }
finally {
               try {
                if (l_rset != null) {
                    l_rset.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                ;
            }
}
%>
</table>

<%}%>




</html:form>
</body>
</html>


