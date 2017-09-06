<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>Parámetros de Números de Carpetas</strong>
        </h4>
    </div>
    <br/>
    <div class="modal-body form-horizontal">
        <html:form action="/parametros">
            <div class="form-group">
                <label class="col-sm-3 control-label">N&uacute;mero de Carpeta a Generar:</label>
                <div class="col-sm-3">
                    <html:text property="maximo" styleId="maximo" maxlength="30" styleClass="form-control required numeric" size="30"/>
                </div>
            </div>
            <div class="btn-container">
                <button type="submit" name="boton" id="boton" class="btn btn-primary" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Consultar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>            
            </div>
            <div class="form-group">
                <label class="label-message-required">
                    * Campos Obligatorios
                </label>
            </div>
        </html:form>
    </div>
</div>
<script>
    $(document).ready(function () {
        Anb.form.submit('#form-parametros', function (form) {
            Anb.form.cleanErrors(form);
            if (Anb.validate.run(form)) {
                Anb.loading.show()                
                form.submit();
            }
        });       
        $("#boton").removeAttr("disabled");
    });
</script>