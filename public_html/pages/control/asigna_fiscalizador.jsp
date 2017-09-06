<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>ASIGNACIÓN DE FISCALIZADOR</strong>
        </h4>
    </div>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-asigna" action="asigna.do">
            <html:hidden property="borrarid" styleId="borrarid"/>
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
                <label class="col-sm-2 control-label">Número de Documento:</label>
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
                <label class="col-sm-2 control-label">Tipo Documento de Identificación:</label>
                <div class="col-sm-2">
                    ${infoControl.tipoDocIdentificacion}
                </div>
                <label class="col-sm-2 control-label">Estado:</label>
                <div class="col-sm-2">
                    ${infoControl.estado}
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Número de Identificación:</label>
                <div class="col-sm-2">
                    ${infoControl.docIdentificacion}
                </div>
                <label class="col-sm-2 control-label">Nombre/Razón Social:</label>
                <div class="col-sm-2">
                    ${infoControl.nomIdentificacion}
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Dirección:</label>
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
            <div class="panel-heading">
                <h4 class="panel-title">
                    <strong>REGISTRAR ASIGNACIÓN DE FISCALIZADOR</strong>
                </h4>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">Funcionario:</label>
                <div class="col-sm-3">
                    <html:select property="funcionario" styleId="funcionario" styleClass="form-control required">
                        <html:option value="-">Seleccione...</html:option>
                        <c:forEach items="${fiscalizadores}" var="fis">
                            <html:option value="${fis.codigo}">${fis.nombre}</html:option>
                        </c:forEach>
                    </html:select>
                </div>
            </div>
            <div class="form-group">
                 <label class="col-sm-3 control-label">Cargo:</label>
                 <div class="col-sm-3">
                    <html:select property="cargo" styleId="cargo" styleClass="form-control required">
                        <html:option value="-">Seleccione...</html:option>
                        <html:option value="FISCALIZADOR">FISCALIZADOR</html:option>
                        <html:option value="JEFE">JEFE</html:option>
                        <html:option value="SUPERVISOR">SUPERVISOR</html:option>
                    </html:select>
                </div>
            </div>
            
            <div class="btn-container">
                <button type="submit" id="boton" onclick="consultar()" class="btn btn-primary" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Asignar Fiscalizador&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>            
            </div>
            <div class="form-group">
                <label class="label-message-required">
                    * Campos Obligatorios
                </label>
            </div>
            <br/>
            <br/>
            
            <h4>
                <strong>LISTA DEL FISCALIZADORES ASIGNADOS</strong>
            </h4>            
            <table class="table table-striped table-hover" id="main-table">
                <thead>
                    <tr>
                        <th>N&uacute;mero</th>
                        <th>Código Usuario</th>
                        <th>Nombre</th>
                        <th>Cargo</th>
                        <th>Fechas Asignación</th>
                        <th>Usuario que Asignó</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>                    
                    <c:forEach items="${asignados}" var="asig">
                    <tr>
                    <td>${asig.numero}</td>
                        <td class="text-center">${asig.codigo}</td>
                        <td class="text-left">${asig.nombre}</td>
                        <td class="text-left">${asig.cargo}</td>
                        <td class="text-center">${asig.fechaasig}</td>
                        <td class="text-center">${asig.usuasig}</td>
                        <td>
                            <button class="deletebotn btn btn-primary btn-sm " 
                                    type="button"
                                    title="Borrar Alcance"
                                    data-item="${asig.id}"
                                    data-id="${asig.id}">
                                <i class="fa fa-close"></i> Borrar
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
        var DT = new Anb.datatable({
            filter: true,
            "iDisplayLength": -1
        });
        
        DT.$('.deletebotn').on('click', function() {           
            var id = this.getAttribute('data-item');
            Anb.confirm('¿Está seguro que desea eliminar al funcionario?', function () {
                    $("#borrarid").val(id);
                    $("#opcion").val('BORRAR'); 
                    $("#form-asigna").submit();
            });
            
        });
    
        Anb.form.submit('#form-asigna', function (form) {
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
  
    function consultar(){
        $("#opcion").val('ASIGNA');    
    }
</script>