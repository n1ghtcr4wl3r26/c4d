<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cliente.bean.ClaseOpcion"%>
<%@ page import="cad.*"%>
<script language="JavaScript" type="text/javascript">
function env(opcion) {
  var f=document.forms[0];
  f.opcion.value=opcion;
  f.submit();
}
</script>
<html:form action="/MenuAction">
<html:hidden property="opcion"/>
</html:form>
<tiles:importAttribute />
<div id="b" >
<div  align="left"  style="width:200px">
      <h3 class="t14">Principal</h3>
      <div>
<%  inputActionForm iform = (inputActionForm) request.getSession().getAttribute("inputActionForm");
    Iterator i=iform.getOpciones().iterator();
    
%>
<%
while(i.hasNext()){        
    ClaseOpcion bean = (ClaseOpcion) i.next();    
    if(bean.getAccion()==null || bean.getAccion().equals("-")){  
%>
<spam>
<%=bean.getDesc()%>
</spam>   
<%
    }
    else
    {
    String link = "env('"+ bean.getCodopc()+"')";
    %>
<spam><html:submit value="<%=bean.getDesc()%>" onclick="<%=link%>" /></spam>   
<%
    }
    
}
%>  
</div>
</div>
</div>
