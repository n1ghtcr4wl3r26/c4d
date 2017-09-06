<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>REGISTRO DE PAGOS</strong>
        </h4>
    </div>
    <div class="modal-body form-horizontal">
        <div class="form-group">
            <label class="col-sm-2 control-label">C&oacute;digo:</label>
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
        <br/>
         
        <html:form styleId="form-recibos" action="registrorecibos.do">
            <html:hidden property="codigo" styleId="codigo"/>
            <input type="hidden" name="opcion" id="opcion"/>
            <html:hidden property="borrarid" styleId="borrarid"/>
            <div class="form-group">
                <label class="col-sm-2 control-label">Registro de Pago:</label>
                <div class="col-sm-8">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Gesti&oacute;n:</label>
                         
                        <label class="col-sm-2 control-label">Aduana:</label>
                         
                        <label class="col-sm-2 control-label">N&uacute;mero de RUP:</label>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <html:text property="rupgestion" styleId="rupgestion"
                                       styleClass="form-control required numeric" size="30" maxlength="4"/>
                        </div>
                        <div class="col-sm-2">
                            <html:select property="rupaduana" styleId="rupaduana" styleClass="form-control required">
                                <option value="-">Seleccione...</option>
                                <html:optionsCollection name="aduanas" value="codigo" label="descripcion"/>
                            </html:select>
                        </div>
                        <div class="col-sm-2">
                            <table><tr><td>R-</td><td> 
                            <html:text property="rupnumero" styleId="rupnumero"
                                       styleClass="form-control required numeric" size="30" maxlength="10"/></td></tr></table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Tipo de Pago:</label>
                <div class="col-sm-3">
                    <html:select property="ruptipo" styleId="ruptipo" styleClass="form-control required">
                        <html:option value="-">Seleccione...</html:option>
                        <html:option value="OP">Sanci&oacute;n por Omisi&oacute;n de Pago</html:option>
                        <html:option value="CA DUI">Multa por
                                                                                                           Contravenci&oacute;n
                                                                                                           Aduanera
                                                                                                           relacionada a
                                                                                                           la Declaraci&oacute;n</html:option>
                        <html:option value="CAO">Multa por Contravenci&oacute;n Aduanera
                                                                                                                          relacionada
                                                                                                                          a
                                                                                                                          la
                                                                                                                          Orden
                                                                                                                          de
                                                                                                                          Control
                                                                                                                          Posterior</html:option>
                        <html:option value="CC">Multa por Contrabando Contravencional</html:option>
                        <html:option value="CD">Multa por Contrabando Delito</html:option>
                        <html:option value="DF">Multa por Defraudaci&oacute;n</html:option>
                        <html:option value="CI FP">Cuota Inicial - Facilidades de Pago</html:option>
                        <html:option value="GE FP">Garant&iacute;a en efectivo -
                                                                                        Facilidades de Pago</html:option>
                    </html:select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Fecha de pago:</label>
                <div class="col-sm-3">
                    <html:text property="rupfecha" styleId="rupfecha"
                               styleClass="form-control datepicker required date-less-than" size="30" maxlength="10"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Importe en Bs.:</label>
                <div class="col-sm-3">
                    <html:text property="rupimporte" styleId="rupimporte" styleClass="form-control required numeric"
                               size="30" maxlength="30"/>
                </div>
            </div>
            <div class="btn-container">
                <button type="submit" id="boton3" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grabar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
            </div>
            <div class="form-group">
                <label class="label-message-required">* Campos Obligatorios</label>
            </div>
            <br/>
            <br/>
            <div class="panel-title imp">
                <strong>LISTA DE RECIBOS REGISTRADOS</strong>
            </div>
            <table class="table table-striped table-hover" id="main-table">
                <thead>
                    <tr>
                        <th>N&uacute;mero</th>
                        <th>N&uacute;mero de RUP</th>
                        <th>Tipo de Pago</th>
                        <th>Fecha de Pago</th>
                        <th>Importe en Bs.</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                 
                <tbody>
                    <c:forEach items="${recibos}" var="rec">
                        <tr>
                            <td>
                                ${rec.seq}
                            </td>
                            <td class="text-center">
                                ${rec.gestion}/${rec.aduana}/R-${rec.numero}
                            </td>
                            <td class="text-left">
                                ${rec.tipo}
                            </td>
                            <td class="text-left">
                                ${rec.fecha}
                            </td>
                            <td class="text-center">
                                ${rec.importe}
                            </td>
                            <td>
                                <button class="deletebtn btn btn-primary btn-sm " type="button" title="Borrar Recibo"
                                        data-item="${rec.codigo}">
                                    <i class="fa fa-close"></i>
                                    Borrar
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </html:form>
    </div>
</div>
<script>
  $(document).ready(function () {
      Anb.form.submit('#form-recibos', function (form) {
          Anb.form.cleanErrors(form);
          if (Anb.validate.run(form)) {
              $("#opcion").val('GRABA');
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
            Anb.confirm('¿Está seguro que desea eliminar el recibo de pago?', function () {
                    $("#borrarid").val(id);
                    $("#opcion").val('BORRAR'); 
                    $("#form-recibos").submit();
            });
      });
      
      Anb.form.submit('#form-recibos', function (form) {
            Anb.form.cleanErrors(form);
            if ($("#opcion").val() =='BORRAR')
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