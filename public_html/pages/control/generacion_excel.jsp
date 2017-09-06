<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="anb.bean.*"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>GENERACIÓN HOJA EXCEL PARA MACRO</strong>
        </h4>
    </div>
    <% 
        GeneracionExcelForm gen = (GeneracionExcelForm)request.getAttribute("GeneracionExcelForm");
    %>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-hojaexcel" action="generacionxls.do">
            <html:hidden property="codigo" styleId="codigo"/>
            <html:hidden property="mostrarid" styleId="mostrarid"/>
            <input type="hidden" name="opcion" id="opcion"/>
            <div class="form-group">
                <label class="col-sm-2 control-label">Código:</label>
                <div class="col-sm-2">
                    ${infoControl.codigo}
                </div>
                <label class="col-sm-2 control-label">Código Control:</label>
                <div class="col-sm-2">
                    ${infoControl.codigoControl}
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Tipo Control:</label>
                <div class="col-sm-2">
                    ${infoControl.tipoControl}
                </div>
                <label class="col-sm-2 control-label">Tipo Documento:</label>
                <div class="col-sm-2">
                    ${infoControl.tipoDocumento}
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">N&uacute;mero de Documento:</label>
                <div class="col-sm-2">
                    ${infoControl.nroDocumento}
                </div>
                <label class="col-sm-2 control-label">Fecha Documento:</label>
                <div class="col-sm-2">
                    ${infoControl.fecDocumento}
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Resumen de la Observaci&oacute;n:</label>
                <div class="col-sm-2">
                    ${infoControl.detDocumento}
                </div>
                <label class="col-sm-2 control-label">Riesgo Identificado:</label>
                <div class="col-sm-2">
                    ${infoControl.riesgoIdentificado}
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Tipo Documento de Identificaci&oacute;n:</label>
                <div class="col-sm-2">
                    ${infoControl.tipoDocIdentificacion}
                </div>
                <label class="col-sm-2 control-label">Estado:</label>
                <div class="col-sm-2">
                    ${infoControl.estado}
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">N&uacute;mero de Identificación:</label>
                <div class="col-sm-2">
                    ${infoControl.docIdentificacion}
                </div>
                <label class="col-sm-2 control-label">Nombre/Raz&oacute;n Social:</label>
                <div class="col-sm-2">
                    ${infoControl.nomIdentificacion}
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Direcci&oacute;n:</label>
                <div class="col-sm-2">
                    ${infoControl.direccion}
                </div>
                <label class="col-sm-2 control-label">Actividad:</label>
                <div class="col-sm-2">
                    ${infoControl.actividad}
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Fecha de Registro:</label>
                <div class="col-sm-2">
                    ${infoControl.fechaRegistro}
                </div>
            </div>
            
            
             
           
            
            
            <h4>
                <strong>LISTA DEL ALCANCE DE LA FISCALIZACIÓN</strong>
            </h4>            
            <div class="table-responsive">
            <table class="table table-striped table-hover" id="main-3table">
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
                    <c:forEach items="${tramites}" var="tra">
                    <tr>
                    <td>${tra.numero}</td>
                        <td class="text-left">${tra.tipoTramite}</td>
                        <td class="text-left">${tra.tramite}</td>
                        <td class="text-left">${tra.observacion}</td>
                        <td>
                            <button class="deletebtn btn btn-info btn-sm " 
                                    type="button"
                                    title="Mostrar Ítems de la Declaración"
                                    data-item="${tra.codigo}"
                                    data-id="${tra.codigo}">
                                <i class="fa fa-close"></i> Ver Ítems
                            </button>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>   
            </div>
           
             <% 
            if(!(gen.getOpcion() == null) && (gen.getOpcion().equals("MOSTRAR"))) {
            %>
           
            <br>
            <div class="panel-title imp" id="macro">
                <strong>ARCHIVO EXCEL PARA MACRO - ${hojaexcelcab.dui}</strong>
            </div>
            <table class="table table-striped table-hover" id="main-table">
                <thead>
                    <tr>
                    
                        <th class="text-center">#</th>
                        <th class="text-center">VALOR FOB TOTAL</th>
                        <th class="text-center">FLETES</th>
                        <th class="text-center">DIVISA</th>
                        <th class="text-center">SEGURO</th>
                        <th class="text-center">DIVISA</th>
                        <th class="text-center">OTROS GASTOS</th>
                        <th class="text-center">DIVISA</th>
                        <th class="text-center">OTRAS EROGACIONES</th>
                        <th class="text-center">DIVISA</th>
                        <th class="text-center">DEDUCCIONES</th>
                        <th class="text-center">DIVISA</th>
                    </tr>
                </thead>
                 
                <tbody>
                    <tr>    <td class="text-left">
                                1
                            </td>
                            <td class="text-right">
                                ${hojaexcelcab.fobtotal}
                            </td>
                            <td class="text-right">
                               ${hojaexcelcab.flete}
                            </td>
                            <td class="text-center">
                               ${hojaexcelcab.fletediv}
                            </td>
                            <td class="text-right">
                               ${hojaexcelcab.seguro}
                            </td>
                            <td class="text-center">
                               ${hojaexcelcab.segurodiv}
                            </td>
                            <td class="text-right">
                               ${hojaexcelcab.otrosg}
                            </td>
                            <td class="text-center">
                               ${hojaexcelcab.otrosgdiv}
                            </td>
                            <td class="text-right">
                               ${hojaexcelcab.otrase}
                            </td>
                            <td class="text-center">
                               ${hojaexcelcab.otrasediv}
                            </td>
                            <td class="text-right">
                               ${hojaexcelcab.deducciones}
                            </td>
                            <td class="text-center">
                               ${hojaexcelcab.deduccionesdiv}
                            </td>
                                         
                        </tr>
                        <tr>
                            <td class="text-left">
                               2
                            </td>
                            <td class="text-right">
                               &nbsp;
                            </td>
                            <td class="text-right">
                               &nbsp;
                            </td>
                            <td class="text-center">
                               &nbsp;
                            </td>
                            <td class="text-right">
                               &nbsp;
                            </td>
                            <td class="text-center">
                               &nbsp;
                            </td>
                            <td class="text-right">
                               &nbsp;
                            </td>
                            <td class="text-center">
                               &nbsp;
                            </td>
                            <td class="text-right">
                               &nbsp;
                            </td>
                            <td class="text-center">
                               &nbsp;
                            </td>
                            <td class="text-right">
                               &nbsp;
                            </td>
                            <td class="text-center">
                               &nbsp;
                            </td>                                         
                        </tr>
                        <tr>
                        <td class="text-left">3</td>
                        <td class="text-center">NUMERO</td>
                        <td class="text-center">FOB ITEM</td>
                        <td class="text-center">&nbsp;</td>
                        <td class="text-center">PARTIDA</td>
                        <td class="text-center">SUB</td>
                        <td class="text-right">
                               &nbsp;
                            </td>
                            <td class="text-center">
                               &nbsp;
                            </td>
                            <td class="text-right">
                               &nbsp;
                            </td>
                            <td class="text-center">
                               &nbsp;
                            </td>
                            <td class="text-right">
                               &nbsp;
                            </td>
                            <td class="text-center">
                               &nbsp;
                            </td> 
                        </tr>
                    <c:forEach items="${hojaTrabajoDui}" var="esc">
                        <tr>
                            <td class="text-left">
                                4
                            </td>
                            <td class="text-center">
                                ${esc.item}
                            </td>
                            <td class="text-right">
                                ${esc.decfobusd}
                            </td>
                            <td class="text-right">
                              &nbsp;
                            </td>
                            <td class="text-center">
                                ${esc.partida}
                            </td>   
                            <td class="text-center">
                                ${esc.subpartida}
                            </td>   
                            <td class="text-right">
                               &nbsp;
                            </td>
                            <td class="text-center">
                               &nbsp;
                            </td>
                            <td class="text-right">
                               &nbsp;
                            </td>
                            <td class="text-center">
                               &nbsp;
                            </td>
                            <td class="text-right">
                               &nbsp;
                            </td>
                            <td class="text-center">
                               &nbsp;
                            </td> 
                        </tr>
                    </c:forEach>
                        <tr>
                            <td class="text-left">
                                5
                            </td>
                            <td class="text-center">
                                ${hojaexcelcab.totalitems}
                            </td>
                            <td class="text-right">
                                @
                            </td>
                            <td class="text-right">
                                &nbsp;
                            </td>
                            <td class="text-center">
                                &nbsp;
                            </td>   
                            <td class="text-center">
                                &nbsp;
                            </td>   
                            <td class="text-right">
                               &nbsp;
                            </td>
                            <td class="text-center">
                               &nbsp;
                            </td>
                            <td class="text-right">
                               &nbsp;
                            </td>
                            <td class="text-center">
                               &nbsp;
                            </td>
                            <td class="text-right">
                               &nbsp;
                            </td>
                            <td class="text-center">
                               &nbsp;
                            </td> 
                        </tr>
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
  
        
         var DT = new Anb.datatable({
            filter: false,
            columnDefs: [{
                targets: "datatable-nosort",
                orderable: false
            }],
            "iDisplayLength": -1,
            oLanguage: {"sSearch": '<i class="glyphicon glyphicon-search"></i> Buscar: ' }

        });
      
      Anb.form.submit('#form-hojaexcel', function (form) {
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
      
      
     
      $('.deletebtn').on('click', function() {           
            var id = this.getAttribute('data-item');
            var dui = this.getAttribute('data-id');
            $("#mostrarid").val(id);
            $("#opcion").val('MOSTRAR'); 
            
            $("#form-hojaexcel").submit();
           
      });
      
  });

  
</script>