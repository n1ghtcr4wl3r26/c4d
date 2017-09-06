<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="anb.bean.*"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>RESUMEN DE CONTROLES ASIGNADOS</strong>
        </h4>
    </div>
    <% 
       ReporteControlForm gen = (ReporteControlForm)request.getAttribute("ReporteControlForm");
    %>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-reportecontrol" action="reportecontrolidx.do">
            <html:hidden property="funcionario" styleId="funcionario"/>
            <html:hidden property="funcionarionombre" styleId="funcionarionombre"/>
            <html:hidden property="ffecini" styleId="ffecini"/>
            <html:hidden property="ffecfin" styleId="ffecfin"/>
            <% 
            if(!(gen.getOpcion() == null) && (gen.getOpcion().equals("CONSULTAR"))) {
            %>
            <strong>Gerencia:</strong>  ${ReporteControlForm.fgerencianombre}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <strong>Usuario Supervisor:</strong>  ${ReporteControlForm.funcionarionombre}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <strong>Fecha desde:</strong>   ${ReporteControlForm.ffecini}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <strong>Fecha hasta:</strong>   ${ReporteControlForm.ffecfin}  
            <br/>
            <br/>
            <table class="table table-striped table-hover" id="main-table">
                <thead>
                    <tr>
                        <th class="text-center">Usuario - Supervisor</th>
                        <th class="text-center">Gerencia</th>
                        <th class="text-center">Cantidad de FAP asignadas</th>
                        <th class="text-center">Cantidad de FAP concluidas</th>
                        <th class="text-center">Cantidad CD asignados</th>
                        <th class="text-center">Cantidad CD concluidas</th>
                    </tr>
                </thead>
                 
                <tbody>
                    <c:forEach items="${reporteControlAsig}" var="esc">
                        <tr>
                            <td class="text-left">
                                ${esc.funcionario}
                            </td>
                            <td class="text-left">
                                ${esc.gerencia}
                            </td>
                            <td class="text-right">
                                ${esc.cantAsigFAP}
                            </td>
                            <td class="text-right">
                                ${esc.cantConFAP}
                            </td>
                            <td class="text-right">
                                ${esc.cantAsigCD}
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
      
      var DT = new Anb.datatable({
            filter: true,
            "iDisplayLength": -1,
            oLanguage: {"sSearch": '<i class="glyphicon glyphicon-search"></i> Buscar: '}
            
      });
      DT.$('.deletebtn').on('click', function() {           
            var id = this.getAttribute('data-item');
            $("#mostrarid").val(id);
            $("#opcion").val('MOSTRAR'); 
            $("#form-liquidacion").submit();
      });
      
  });

  
</script>