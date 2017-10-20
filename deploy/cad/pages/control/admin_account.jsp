<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title"><i class="fa fa-user"></i> <strong>Mi cuenta</strong> - ${funcionario.nombreUsuario}</h3>
    </div>
    <div class="panel-body">
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#data" aria-controls="data" role="tab" data-toggle="tab">Mis datos personales</a></li>
        </ul>
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade in active" id="data">
                <div class="panel-body form-horizontal user-data">                    
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Nombre completo:</label>
                        <div class="col-sm-10">
                            <div class="form-control-static">${funcionario.nombreCompleto}</div>
                        </div>
                    </div>
                    <div class="form-group" style="display:none">
                        <label class="col-sm-2 control-label">Aduana:</label>
                        <div class="col-sm-10">
                            <div class="form-control-static">${funcionario.aduana}</div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Correo electrónico:</label>
                        <div class="col-sm-10">
                            <div class="form-control-static">${funcionario.correoElectronico}</div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Gerencia:</label>
                        <div class="col-sm-10">
                            <div class="form-control-static">${funcionario.gerencia}</div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Unidad:</label>
                        <div class="col-sm-10">
                            <div class="form-control-static">${funcionario.unidad}</div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Perfil(es):</label>
                        <div class="col-sm-10">
                            <div class="form-control-static">${funcionario.perfiles}</div>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
    });
</script>