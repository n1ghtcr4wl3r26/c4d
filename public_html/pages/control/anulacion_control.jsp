<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>ANULACIÓN DE ORDEN</strong>
        </h4>
    </div>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-anulacion" action="anulacion.do">
            <html:hidden property="codigo" styleId="codigo"/>
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
            <table class="table table-striped table-hover" id="main-table">
                <thead>
                    <tr>
                        <th>N&uacute;mero</th>
                        <th>Tipo</th>
                        <th>Documento</th>
                        <th>Observaci&oacute;n</th>
                    </tr>
                </thead>
                 
                <tbody>
                    <c:forEach items="${tramites}" var="tra">
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
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
            <h4>
                <strong>JUSTIFICACIÓN PARA LA ANULACIÓN DEL CONTROL</strong>
            </h4>
            <div class="form-group">
                <label class="col-sm-2 control-label">jutificación:</label>
                <div class="col-sm-4">
                    <textarea name="justificacion" id="justificacion" class="form-control required" data-maxlength="300" onkeyup="Textarea_Sin_Enter(event.keyCode, event.which, 'difDetDocumento');" >${AnulacionForm.justificacion}</textarea>
                </div>
            </div>
            <br/>
            <div class="btn-container">
                <button type="submit" id="boton" onclick="consultar()" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ANULAR ORDEN&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
            </div>
        </html:form>
    </div>
</div>
<script>
  $(document).ready(function () {
      $("#boton").removeAttr('disabled');
      Anb.form.submit('#form-anulacion', function (form) {
      Anb.confirm('¿Está seguro de Anular la Orden?, esta operación no podrá ser revertida.', function () {
          Anb.form.cleanErrors(form);
          if (Anb.validate.run(form)) {
              console.log('Enviado!');
              Anb.loading.show()
              form.submit();
          }
           });
      });
      
      $("#boton").removeAttr('disabled');
  });

  function consultar() {
      $("#opcion").val('ANULACION');
  }
</script>