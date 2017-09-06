<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>GENERACIÓN DE ORDEN</strong>
        </h4>
    </div>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-registro" action="registro.do">
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
                <strong>INFORMACIÓN COMPLEMENTARIA DE LA NOTIFICACIÓN DE LA ORDEN DE FISCALIZACIÓN</strong>
            </h4>
            <div class="form-group">
                <div class="col-sm-6">
                    <table class="table table-striped table-hover" id="main-table">
                        <thead>
                            <tr>
                                <th>Nro.</th>
                                <th>Requisitos que se desplegaran en el Documento de Notificaci&oacute;n</th>
                            </tr>
                        </thead>
                         
                        <tbody>
                            <tr>
                                <td>1.</td>
                                <td>
                                    <html:checkbox property="inn_1" style="width:13px;height:13px" styleId="inn_1"
                                                   styleClass="form-control ">&nbsp;&nbsp;N&uacute;mero de
                                                                              Identificaci&oacute;n Tributaria.</html:checkbox>
                                </td>
                            </tr>
                            <tr>
                                <td>2.</td>
                                <td>
                                    <html:checkbox property="inn_2" style="width:13px;height:13px" styleId="inn_2"
                                                   styleClass="form-control ">&nbsp;&nbsp;C&eacute;dula de identidad del
                                                                              Operador.</html:checkbox>
                                </td>
                            </tr>
                            <tr>
                                <td>3.</td>
                                <td>
                                    <html:checkbox property="inn_3" style="width:13px;height:13px" styleId="inn_3"
                                                   styleClass="form-control ">&nbsp;&nbsp;C&eacute;dula de identidad y
                                                                              Poder del Representante Legal.</html:checkbox>
                                </td>
                            </tr>
                            <tr>
                                <td>4.</td>
                                <td>
                                    <html:checkbox property="inn_4" style="width:13px;height:13px" styleId="inn_4"
                                                   styleClass="form-control ">&nbsp;&nbsp;Escritura de
                                                                              Constituci&oacute;n de la Empresa.</html:checkbox>
                                </td>
                            </tr>
                            <tr>
                                <td>5.</td>
                                <td>
                                    <html:checkbox property="inn_5" style="width:13px;height:13px" styleId="inn_5"
                                                   styleClass="form-control ">&nbsp;&nbsp;Plan de Cuentas
                                                                              gesti&oacute;n(es).</html:checkbox>
                                </td>
                            </tr>
                            <tr>
                                <td>6.</td>
                                <td>
                                    <html:checkbox property="inn_6" style="width:13px;height:13px" styleId="inn_6"
                                                   styleClass="form-control ">&nbsp;&nbsp;Estados Financieros
                                                                              gesti&oacute;n (es).</html:checkbox>
                                </td>
                            </tr>
                            <tr>
                                <td>7.</td>
                                <td>
                                    <html:checkbox property="inn_7" style="width:13px;height:13px" styleId="inn_7"
                                                   styleClass="form-control ">&nbsp;&nbsp;Contratos con proveedores de
                                                                              las DUIs fiscalizadas.</html:checkbox>
                                </td>
                            </tr>
                            <tr>
                                <td>8.</td>
                                <td>
                                    <html:checkbox property="inn_8" style="width:13px;height:13px" styleId="inn_8"
                                                   styleClass="form-control ">&nbsp;&nbsp;Kardex f&iacute;sico valorado
                                                                              gesti&oacute;n(es).</html:checkbox>
                                </td>
                            </tr>
                            <tr>
                                <td>9.</td>
                                <td>
                                    <html:checkbox property="inn_9" style="width:13px;height:13px" styleId="inn_9"
                                                   styleClass="form-control ">&nbsp;&nbsp;Mayores Contables
                                                                              gesti&oacute;n(es).</html:checkbox>
                                </td>
                            </tr>
                            <tr>
                                <td>10.</td>
                                <td>
                                    <html:checkbox property="inn_10" style="width:13px;height:13px" styleId="inn_10"
                                                   styleClass="form-control ">&nbsp;&nbsp;Comprobantes Contables
                                                                              gesti&oacute;n(es).</html:checkbox>
                                </td>
                            </tr>
                            <tr>
                                <td>11.</td>
                                <td>
                                    <html:checkbox property="inn_11" style="width:13px;height:13px" styleId="inn_11"
                                                   styleClass="form-control ">&nbsp;&nbsp;Direcci&oacute;n de Correo
                                                                              Electr&oacute;nico y N&uacute;mero de
                                                                              Tel&eacute;fono y Fax.</html:checkbox>
                                </td>
                            </tr>
                            <tr>
                                <td>12.</td>
                                <td>
                                    <html:text property="inn_12" styleId="inn_12" styleClass="form-control" size="50"
                                               maxlength="500"/>
                                </td>
                            </tr>
                            <tr>
                                <td>13.</td>
                                <td>
                                    <html:text property="inn_13" styleId="inn_13" styleClass="form-control" size="50"
                                               maxlength="500"/>
                                </td>
                            </tr>
                            <tr>
                                <td>14.</td>
                                <td>
                                    <html:text property="inn_14" styleId="inn_14" styleClass="form-control" size="50"
                                               maxlength="500"/>
                                </td>
                            </tr>
                            <tr>
                                <td>15.</td>
                                <td>
                                    <html:text property="inn_15" styleId="inn_15" styleClass="form-control" size="50"
                                               maxlength="500"/>
                                </td>
                            </tr>
                            <tr>
                                <td>16.</td>
                                <td>
                                    <html:text property="inn_16" styleId="inn_16" styleClass="form-control" size="50"
                                               maxlength="500"/>
                                </td>
                            </tr>
                            <tr>
                                <td>17.</td>
                                <td>
                                    <html:text property="inn_17" styleId="inn_17" styleClass="form-control" size="50"
                                               maxlength="500"/>
                                </td>
                            </tr>
                            <tr>
                                <td>18.</td>
                                <td>
                                    <html:text property="inn_18" styleId="inn_18" styleClass="form-control" size="50"
                                               maxlength="500"/>
                                </td>
                            </tr>
                            <tr>
                                <td>19.</td>
                                <td>
                                    <html:text property="inn_19" styleId="inn_19" styleClass="form-control" size="50"
                                               maxlength="500"/>
                                </td>
                            </tr>
                            <tr>
                                <td>20.</td>
                                <td>
                                    <html:text property="inn_20" styleId="inn_20" styleClass="form-control" size="50"
                                               maxlength="500"/>
                                </td>
                            </tr>
                            <tr>
                                <td>21.</td>
                                <td>
                                    <html:text property="inn_21" styleId="inn_21" styleClass="form-control" size="50"
                                               maxlength="500"/>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">Gesti&oacute;n(es) de la informaci&oacute;n a solicitar:</label>
                <div class="col-sm-3">
                    <html:text property="periodosolicitar" styleId="periodosolicitar"
                               styleClass="form-control required" size="50" maxlength="30"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">Plazo de conclusi&oacute;n de la Fiscalizaci&oacute;n (d&iacute;as):</label>
                <div class="col-sm-3">
                    <html:text property="inn_plazo_conclusion" styleId="inn_plazo_conclusion"
                               styleClass="form-control numeric required" size="50" maxlength="5"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">Nro. de Documento:</label>
                <div class="col-sm-3">
                    <html:text property="nroDocumento" styleId="nroDocumento"
                               styleClass="form-control required" size="30" maxlength="30" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">Fecha de Documento:</label>
                <div class="col-sm-3">
                    <html:text property="fecDocumento" styleId="fecDocumento"
                               styleClass="form-control datepicker required date-less-than" size="30" maxlength="10"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">Riesgo Identificado:</label>
                <div class="col-sm-3">
                    <html:checkbox property="riesgoDelito" style="width:13px;height:13px" styleId="riesgoDelito"  styleClass="form-control ">&nbsp;&nbsp;Delito</html:checkbox><br>
                    <html:checkbox property="riesgoSubval" style="width:13px;height:13px" styleId="riesgoSubval"  styleClass="form-control ">&nbsp;&nbsp;Subvaluación</html:checkbox><br>
                    <html:checkbox property="riesgoClas" style="width:13px;height:13px" styleId="riesgoClas"  styleClass="form-control ">&nbsp;&nbsp;Clasificación</html:checkbox><br>
                    <html:checkbox property="riesgoContrab" style="width:13px;height:13px" styleId="riesgoContrab"  styleClass="form-control ">&nbsp;&nbsp;Contrabando Contravencional</html:checkbox><br>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">Tributos a Fiscalizar:</label>
                <div class="col-sm-3">
                    <html:checkbox property="ga" style="width:13px;height:13px" styleId="ga"  styleClass="form-control ">&nbsp;&nbsp;GA</html:checkbox><br>
                    <html:checkbox property="iva" style="width:13px;height:13px" styleId="iva"  styleClass="form-control ">&nbsp;&nbsp;IVA</html:checkbox><br>
                    <html:checkbox property="ice" style="width:13px;height:13px" styleId="ice"  styleClass="form-control ">&nbsp;&nbsp;ICE</html:checkbox><br>
                    <html:checkbox property="iehd" style="width:13px;height:13px" styleId="iehd"  styleClass="form-control ">&nbsp;&nbsp;IEHD</html:checkbox><br>
                    <html:checkbox property="icd" style="width:13px;height:13px" styleId="icd"  styleClass="form-control ">&nbsp;&nbsp;ICD</html:checkbox><br>
                    <html:checkbox property="noaplica" style="width:13px;height:13px" styleId="noaplica"  styleClass="form-control ">&nbsp;&nbsp;NO APLICA</html:checkbox>
                </div>
            </div>
            <br/>
            <div class="btn-container">
                <button type="submit" id="boton" onclick="consultar()" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;GENERAR ORDEN&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
            </div>
        </html:form>
    </div>
</div>
<script>
  $(document).ready(function () {
      $("#boton").removeAttr('disabled');
      
      Anb.form.submit('#form-registro', function (form) {
      Anb.confirm('Esta operación no podrá ser revertida, debe verificar que se registró correctamente el alcance y se realizó la operación de asignación de fiscalizadores. \n ¿Está seguro de Generar la Orden?', function () {
                   
           
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
      $("#opcion").val('REGISTRA');
  }
</script>