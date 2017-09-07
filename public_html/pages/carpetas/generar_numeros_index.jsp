<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>PARAMETROS DE NÚMEROS DE CARPETAS</strong>
        </h4>
    </div>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-generarnumeros" action="generarnumeros.do">
            <input type="hidden" name="opcion" id="opcion"/>
            <div class="form-group">
                <label class="col-sm-4 control-label">N&uacute;mero limite de carpeta a generar:</label>
                <div class="col-sm-4">
                    <html:text property="numero" styleId="numero" maxlength="15" styleClass="form-control required numeric" size="15"/>
                </div>
            </div>
            <div class="btn-container">
                <button type="submit" id="boton" onclick="consultar()" class="btn btn-primary" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Consultar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>            
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
        Anb.form.submit('#form-generarnumeros', function (form) {
            Anb.form.cleanErrors(form);           
            if (Anb.validate.run(form)) {
                $("#opcion").val('CONSULTAR');
                console.log('Enviado!');
                Anb.loading.show()                
                form.submit();
            }
        });
        $("#boton").removeAttr("disabled");
    });
    function consultar(){
        $("#opcion").val('CONSULTAR');  
        
       
    }
</script>