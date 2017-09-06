<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>NOTIFICACIÓN CONTROL</strong>
        </h4>
    </div>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-notificacioncontrol" action="notificacioncontrolidx.do">
            <html:hidden property="codigo" styleId="codigo"/>
            <input type="hidden" name="opcion" id="opcion"/>
            <div class="form-group">
                <label class="col-sm-2 control-label label-required">Gesti&oacute;n:</label>
                 
                <label class="col-sm-4 control-label label-required">Tipo Control:</label>
                 
                <label class="col-sm-2 control-label label-required">Gerencia:</label>
                 
                <label class="col-sm-2 control-label label-required">N&uacute;mero:</label>
            </div>
            <div class="form-group">
                <div class="col-sm-2">
                    <html:text property="fgestion" styleId="fgestion" styleClass="form-control required numeric"
                               size="30" maxlength="4"/>
                </div>
                <div class="col-sm-4">
                    <html:select property="fcontrol" styleClass="form-control required">
                        <html:option value="-">Seleccione...</html:option>
                        <html:option value="DIFERIDO">DIFERIDO</html:option>
                        <html:option value="POSTERIOR">POSTERIOR</html:option>
                        <html:option value="AMPLIATORIA DIFERIDO">AMPLIATORIA DIFERIDO</html:option>
                        <html:option value="AMPLIATORIA POSTERIOR">AMPLIATORIA POSTERIOR</html:option>
                    </html:select>
                </div>
                <div class="col-sm-2">
                    <html:select property="fgerencia" styleClass="form-control required">
                        <html:option value="-">Seleccione...</html:option>
                        <html:option value="GNF">NACIONAL DE FISCALIZACIÓN</html:option>
                        <html:option value="GRL">LA PAZ</html:option>
                        <html:option value="GRC">COCHABAMBA</html:option>
                        <html:option value="GRS">SANTA CRUZ</html:option>
                        <html:option value="GRO">ORURO</html:option>
                        <html:option value="GRT">TARIJA</html:option>
                        <html:option value="GRP">POTOSI</html:option>
                    </html:select>
                </div>
                <div class="col-sm-2">
                    <html:text property="fnumero" styleId="fnumero" styleClass="form-control required " size="30"
                               maxlength="10"/>
                </div>
            </div>
            <div class="btn-container">
                <button type="submit" id="boton" onclick="consultar()" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Consultar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
            </div>
            <div class="form-group">
                <label class="label-message-required">* Campos Obligatorios</label>
            </div>
        </html:form>
    </div>
</div>
<script>
        $(document).ready(function () {
       
          Anb.form.submit('#form-notificacioncontrol', function (form) {
              Anb.form.cleanErrors(form);
              if (Anb.validate.run(form)) {
                  $("#opcion").val('CONSULTAR');
                  console.log('Enviado!');
                  Anb.loading.show()
                  form.submit();
              }
          });
          $("#boton").removeAttr('disabled');

      });
  function consultar() {
  
                  $("#opcion").val('CONSULTAR');
           
  }
</script>