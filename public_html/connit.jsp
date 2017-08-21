<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ page import="java.sql.*, cad.*, java.text.*,  java.util.*" %>
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
<body><%
connitForm vform = (connitForm) request.getAttribute("connitForm");

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
<html:form action="/connit" >
<table width="500px" align="center" class="soloborde" bgcolor="#C1C1FF">
<tr> 
  <td class="FondoVerde" align="center" colspan=2><b>CONSULTA NIT</b></td>
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
  <td class="parath">Número de NIT : </td><td><html:text property="numero" onblur="this.value=trimm(this.value);"  /></td>
</tr>
<tr>
  <td colspan=2> <hr> </td>
</tr>
<tr>
  <td align="center" colspan=2><html:submit property="boton" value="Consultar" styleClass="boton1" onclick="return fEvaluaconnit()" /></td>
</tr>

</table>


<%

try
{
%>

<%=vform.getMensaje().toString()%>
<%
}
catch (Exception e)
    { System.out.println(e.toString()); 
    %><%--<table><tr><td class="T8r"><b>Error:</b> <%=e.toString()%></td></tr></table>--%>
<%  }
%>



<%
if(vform != null)
if(vform.getNumero()!=null)
{

    conexion dc = new conexion();
    Connection con = null;
    CallableStatement call = null;
    ResultSet l_rset = null;
    String StrSql;
%>
<table width="500px" align="center" class="soloborde" bgcolor="#C1C1FF" id="c">
<tr><td colspan="3" align=center><b>CARPETAS ASOCIADAS</b></td></tr>
<tr><th>N&Uacute;MERO CARPETA</th><th>FECHA ASOCIACI&Oacute;N</th><th>USUARIO</th></tr>
<%
try{
   con = dc.abrirConexion();
   StrSql = "SELECT a.cad_secuencial || a.cad_encriptado, to_char(a.cad_nit_fecha,'dd/mm/yyyy HH24:mi:ss') , nvl(a.cad_nit_usuario,'-') FROM OPS$ASY.CORR_CARPETAS a WHERE a.cad_nit ='"+vform.getNumero()+"' "; 
   StrSql = StrSql + "and to_date(to_char(cad_nit_fecha,'dd/mm/yyyy'),'dd/mm/yyyy') between to_date('"+vform.getDfecini()+"','dd/mm/yyyy') and  to_date('"+vform.getDfecfin()+"','dd/mm/yyyy') and  a.lst_ope = 'U' ORDER BY a.cad_fecha desc";
   l_rset = (ResultSet) dc.pQuery(con, StrSql); 
   if ( l_rset != null && l_rset.next()) {   
      do {%>
        <tr><td><%=l_rset.getString(1)%></td>
            <td><%=l_rset.getString(2)%></td>
            <td><%=l_rset.getString(3)%></td>
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


