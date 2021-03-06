<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>VERIFICA NÚMEROS</strong>
        </h4>
    </div>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-verificaridx" action="verificaidx.do">
            <input type="hidden" name="boton" id="boton"/>
            <div class="form-group">
                <label class="col-sm-3 control-label">N&uacute;mero de Carpeta:</label>
                <div class="col-sm-3">
                    <html:text property="numero" styleId="numero" maxlength="20" styleClass="form-control required numeric" size="15"/>
                </div>
            </div>
            <div class="btn-container">
                <button type="submit" id="botonsubmit" onclick="consultar()" class="btn btn-primary" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Verificar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>            
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
        Anb.form.submit('#form-verificaridx', function (form) {
            Anb.form.cleanErrors(form);           
            if (Anb.validate.run(form)) {
                $("#boton").val('Verifica');
                console.log('Enviado!');
                Anb.loading.show()                
                form.submit();
            }
        });
        $("#botonsubmit").removeAttr("disabled");
    });
    function consultar(){
        $("#boton").val('Verificar');  
        
       
    }
</script>