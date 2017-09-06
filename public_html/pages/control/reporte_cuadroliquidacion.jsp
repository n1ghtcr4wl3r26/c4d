<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="anb.bean.*"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>CUADRO RESUMEN DE LIQUIDACIÓN</strong>
        </h4>
    </div>
    <% 
       ReporteControlForm gen = (ReporteControlForm)request.getAttribute("ReporteControlForm");
    %>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-reportecontrol" action="reportecuadroliquidacionidx.do">
            <% 
            if(!(gen.getOpcion() == null) && (gen.getOpcion().equals("CONSULTAR"))) {
            %>
            <br/>
            <table class="table table-striped table-hover" id="main-table">
                <thead>
                    <tr>
                        <th class="text-center">Usuario - Supervisor</th>
                        <th class="text-center">Cantidad de FAP asignadas</th>
                        <th class="text-center">Cantidad de FAP concluidas</th>
                        <th class="text-center">Cantidad CD asignados</th>
                        <th class="text-center">Cantidad CD concluidas</th>
                    </tr>
                </thead>
                 
                <tbody>
                    <c:forEach items="${reporteControlAsig}" var="esc">
                        <tr>
                            <td class="text-center">
                                ${esc.funcionario}
                            </td>
                            <td class="text-center">
                                ${esc.cantAsigFAP}
                            </td>
                            <td class="text-center">
                                ${esc.cantConFAP}
                            </td>
                            <td class="text-center">
                                ${esc.cantAsigCD}
                            </td>
                            <td class="text-center">
                                ${esc.cantConCD}
                            </td>                            
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br/>
            <table class="table table-striped table-hover" id="main-table">
                <thead>
                    <tr>
                        <th class="text-center">&nbsp;</th>
                        <th class="text-center">Total asignadas</th>
                        <th class="text-center">Total concluidas</th>
                    </tr>
                </thead>
                 
                <tbody>
                    <c:forEach items="${reporteControlAsigTot}" var="tot">
                        <tr>
                            <th class="text-center">
                                Total FAP
                            </th>
                            <td class="text-center">
                                ${tot.cantAsigFAP}
                            </td>
                            <td class="text-center">
                                ${tot.cantConFAP}
                            </td>                                        
                        </tr>
                        <tr>
                            <th class="text-center">
                                Total CD
                            </th>
                            <td class="text-center">
                                ${tot.cantAsigCD}
                            </td>
                            <td class="text-center">
                                ${tot.cantConCD}
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