<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title"><i class="fa fa-user"></i> <strong>Mi cuenta</strong> - ${AdminForm.usuario}</h3>
    </div>
    <div class="panel-body">
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#password" aria-controls="password" role="tab" data-toggle="tab">Cambiar contraseña</a></li>
        </ul>
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade in active" id="password">
                <div class="panel-body">
                    <html:form action="password.do" styleId="form-password" styleClass="form-horizontal">
                        <input type="hidden" name="opcion" id="opcion"/>
                        <html:hidden property="usuario" value="${AdminForm.usuario}"/>
                        <div class="alert alert-info">
                            <strong>Nota.-</strong> Existe diferencias entre Mayúsculas y Minúsculas para su contraseña.
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 col-sm-offset-3 control-label">Contraseña anterior:</label>
                            <div class="col-sm-3">
                                <html:password property="password" maxlength="15" styleClass="form-control required" redisplay="false"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 col-sm-offset-3 control-label">Nueva contraseña:</label>
                            <div class="col-sm-3">
                                <input type="password" name="newpassword" maxlength="15" class="form-control required" data-matches="confirmacion" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 col-sm-offset-3 control-label">Confirmar contraseña anterior:</label>
                            <div class="col-sm-3">
                                <input type="password" name="confirmacion" maxlength="15" class="form-control required" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-6 col-sm-offset-6">
                                <button class="btn btn-default" type="button" data-form="clean"><i class="fa fa-eraser"></i> Limpiar</button>
                                <button type="submit" class="btn btn-primary"><i class="fa fa-lock"></i> Cambiar contraseña</button>
                            </div>
                        </div>
                    </html:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        Anb.form.submit('#form-password', function (form) {
            Anb.form.cleanErrors(form);           
            if (Anb.validate.run(form)) {
                $("#opcion").val('CHANGE');  
                console.log('Enviado!');
                Anb.loading.show()                
                form.submit();
            }
        });
    });

</script>