<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>MEMORIZACIÓN DEL CONTROL</strong>
        </h4>
    </div>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-memorizacion" action="memorizacionenv.do">
            <div class="form-group">
                <h3>
                    <label class="col-sm-6">DESEA REGISTRAR ALCANCE PARA EL CONTROL CREADO</label>
                </h3>
            </div>
            <html:hidden property="codigocontrol" styleId="codigocontrol"/>
            <html:hidden property="boton" value= "alcance"/>
            <div class="btn-container">
                <button type="submit" id="boton3" class="btn btn-primary" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Registrar Alcance del Control&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>            
            </div>
        </html:form>
    </div>
</div>
<script>
    $(document).ready(function () {
        
        Anb.form.submit('#form-memorizacion', function (form) {
            Anb.form.cleanErrors(form);
            if (Anb.validate.run(form)) {
                console.log('Enviado!');
                Anb.loading.show()
                form.submit();
            }
        });
    });
</script>