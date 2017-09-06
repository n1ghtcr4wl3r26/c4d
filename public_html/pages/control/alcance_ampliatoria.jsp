<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="anb.bean.*"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>ALCANCE AMPLIATORIA</strong>
        </h4>
    </div>
    <% 
        AlcanceForm alc = (AlcanceForm)request.getAttribute("AlcanceForm");
    %>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-alcance" action="alcanceampliatoria.do">
            <input type="hidden" name="opcion" id="opcion"/>
            <html:hidden property="borrarid" styleId="borrarid"/>
            <html:hidden property="codigo" styleId="codigo"/>
            <html:hidden property="codigoconcatval" styleId="codigoconcatval"/>
            <div class="form-group">
                <label class="col-sm-2 control-label">Código:</label>
                <div class="col-sm-2">
                    ${infoControl.codigo}
                </div>
                <label class="col-sm-2 control-label">Tipo Control:</label>
                <div class="col-sm-2">
                    ${infoControl.tipoControl}
                </div>
            </div>

	    <div class="form-group">
                <label class="col-sm-2 control-label">Operador:</label>
                <div class="col-sm-6">
                    ${infoControl.tipoDocIdentificacion}
                &nbsp;
                    ${infoControl.docIdentificacion}
                :
                    ${infoControl.nomIdentificacion}
                </div>
            </div>
            <br>
            <%
            if(alc.getCantidad_alc() > 0) {
            %>
            <br></br>
            <h4>
                <strong>LISTA DEL ALCANCE DE LA FISCALIZACIÓN PADRE</strong>
            </h4>
            <table class="table table-striped table-hover" id="main-table">          
                <thead>
                    <tr>
                        <th class="text-center">
                            <input type="checkbox" style="width:13px;height:13px" class="check_allval"
                                   id="check_allval"/>
                            Todo
                        </th>
                        <th>N&uacute;mero</th>
                        <th>Tipo</th>
                        <th>Documento</th>
                        <th>Observaci&oacute;n</th>
                        <th>Importador</th>
                        <th>Declarante</th>
                    </tr>
                </thead>
                 
                <tbody>
                    <c:forEach items="${tramitespadreamp}" var="tra">
                        <tr>
                            <td class="text-center">
                                <c:if test="${tra.estado == '1' }">
                                    <input type="checkbox" style="width:13px;height:13px" id="val${tra.numero}"
                                           value="${tra.codigo}" class="check_groupval todo"/>
                                </c:if>
                            </td>
                            <td>
                                ${tra.numero}
                            </td>
                            <td class="text-left">
                                ${tra.tipoTramite}
                            </td>
                            <td class="text-left">
                                ${tra.tramite}
                            </td>
                            <td class="text-left">
                                ${tra.observacion}
                            </td>
                            <td class="text-right">
                                ${tra.importador}
                            </td>
                            <td class="text-right">
                                ${tra.declarante}
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <button class="btn btn-info btn-sm newHide" type="button" id="btnInc" title="Agregar Declaraciones"
                    onfocus="concat_idsitem()">
                <i class="fa fa-percent"></i>
                Agregar Declaraciones
            </button>
            <%
            }
            %>
            <%
            if(alc.getCantidad_alc() > 0) {
            %>
            <br></br>
            <h4>
                <strong>LISTA DEL ALCANCE DE LA FISCALIZACIÓN AMPLIATORIA</strong>
            </h4>
            
            <table class="table table-striped table-hover" id="main-table">
                <thead>
                    <tr>
                        <th>N&uacute;mero</th>
                        <th>Tipo</th>
                        <th>Documento</th>
                        <th>Observaci&oacute;n</th>
                        <th class="noExport">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${tramitesamp}" var="tra">
                        <tr>
                            <td>
                                ${tra.numero}
                            </td>
                            <td class="text-left">
                                ${tra.tipoTramite}
                            </td>
                            <td class="text-left">
                                ${tra.tramite}
                            </td>
                            <td class="text-left">
                                ${tra.observacion}
                            </td>
                            <td>
                                <button class="deletebtn btn btn-info btn-sm " 
                                        type="button" 
                                        title="Borrar Alcance"
                                        data-item="${tra.codigo}" 
                                        data-id="${tra.codigo}">
                                    <i class="fa fa-close"></i>
                                    Borrar
                                </button>
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
      var DT = new Anb.datatable( {
          filter : true, "iDisplayLength" :  - 1, oLanguage :  {
              "sSearch" : '<i class="glyphicon glyphicon-search"></i> Buscar: '
          }

      });
      $('.deletebtn').on('click', function () {         
          var id = this.getAttribute('data-item');      
          Anb.confirm('¿Está seguro que desea eliminar el trámite del alcance?', function () {
              $("#borrarid").val(id);
              $("#opcion").val('BORRAR');
              $("#form-alcance").submit();
          });

      });
      $("#check_allval").click(function (event) {
          if ($(this).is(":checked")) {
              $('.check_groupval:checkbox').prop('checked', true).attr('checked', 'checked');
          }
          else {
              $('.check_groupval:checkbox').prop('checked', false).removeAttr('checked');
          }
      });
  });
  
  function concat_idsitem() {
          var chkArrayval = [];
          $(".check_groupval:checked").each(function () {
              chkArrayval.push($(this).val());
          });
          var selectedval;
          selectedval = chkArrayval.join(',') + ",";
          if (selectedval.length > 1) {
              $("#opcion").val('GRABADUIS');
              $("#codigoconcatval").val(selectedval);
              $("#form-alcance").submit();
          }
          else {
              Anb.alert('Debe seleccionar por lo menos un ítem de las declaraciones para realizar esta acción.');
          }
      }
</script>