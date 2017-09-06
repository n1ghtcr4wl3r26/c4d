<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="anb.bean.*"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>RESUMEN DE ORDENES GENERADAS Y CONCLUIDAS POR GERENCIA</strong>
        </h4>
    </div>
    <% 
       ReporteControlForm gen = (ReporteControlForm)request.getAttribute("ReporteControlForm");
    %>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-reportecontrol" action="reportecontrolgenidx.do">
            <html:hidden property="funcionarionombre" styleId="funcionarionombre"/>
            <html:hidden property="ffecini" styleId="ffecini"/>
            <html:hidden property="ffecfin" styleId="ffecfin"/>
            <% 
            if(!(gen.getOpcion() == null) && (gen.getOpcion().equals("CONSULTAR"))) {
            %>
            <strong>Gerencia:</strong>  ${ReporteControlForm.fgerencianombre}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <strong>Fecha desde:</strong>   ${ReporteControlForm.ffecini}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <strong>Fecha hasta:</strong>   ${ReporteControlForm.ffecfin}  
            <br/>
            <br/>
            <table class="table table-striped table-hover" id="main-table">
                <thead>
                    <tr>
                        <th class="text-center">Gerencias</th>
                        <th class="text-center">FAP Asignadas</th>
                        <th class="text-center">CD Asignados</th>
                        <th class="text-center">FAP Concluidas</th>
                        <th class="text-center">CD Concluidas</th>
                    </tr>
                </thead>
                 
                <tbody>
                    <c:forEach items="${reporteControlAsig}" var="esc">
                        <tr>
                            <td class="text-left">
                                ${esc.gerencia}
                            </td>
                            <td class="text-right">
                                ${esc.cantAsigFAP}
                            </td>
                            <td class="text-right">
                                ${esc.cantAsigCD}
                            </td>
                            <td class="text-right">
                                ${esc.cantConFAP}
                            </td>
                            <td class="text-right">
                                ${esc.cantConCD}
                            </td>                            
                        </tr>
                    </c:forEach>
                </tbody>
            </table>           
            <%
            }
            %>
            
            
        </html:form>
    </div>
</div>
<script>
  $(document).ready(function () {
      Anb.form.submit('#form-liquidacion', function (form) {
          Anb.form.cleanErrors(form);
          if ($("#opcion").val() =='MOSTRAR')
                form.submit();
            else
          if (Anb.validate.run(form)) {
              console.log('Enviado!');
              Anb.loading.show()
              form.submit();
          }
      });
  });
</script>