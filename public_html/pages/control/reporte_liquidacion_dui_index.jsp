<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>REPORTE DE LIQUIDACI&Oacute;N DE TRIBUTOS DE LA ORDEN POR DUI</strong>
        </h4>
    </div>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-reporte_liquidacion_dui" action="reporte_liquidacion_duiidx.do">
            <html:hidden property="codigo" styleId="codigo"/>
            <html:hidden property="usuarioger" styleId="usuarioger"/>
            <input type="hidden" name="opcion" id="opcion"/>
            <div class="form-group">
                <label class="col-sm-4 control-label label-required" id="labelgerencia">Gerencia:</label>
                <label class="col-sm-2 control-label label-required">Fecha Desde:</label>
                <label class="col-sm-2 control-label label-required">Fecha Hasta:</label>
            </div>
            <div class="form-group">
                <div class="col-sm-4">
                    <html:select property="fgerencia" styleId="fgerencia" styleClass="form-control required">
                        <c:forEach items="${gerencias}" var="ger">
                            <html:option value="${ger.codigo}">
                                ${ger.descripcion}
                            </html:option>
                        </c:forEach>
                    </html:select>
                </div>
                <div class="col-sm-2">
                    <html:text property="ffecini" styleId="ffecini" styleClass="form-control datepicker required date-less-than" size="30" maxlength="10" />
                </div>    
                <div class="col-sm-2">
                    <html:text property="ffecfin" styleId="ffecfin" styleClass="form-control datepicker required date-less-than" size="30" maxlength="10" />
                </div>   
            </div>
            <div class="form-group">
                <label class="col-sm-4 control-label label-required">Tipo de Trámite:</label>
                <label class="col-sm-4 control-label">NIT Operador:</label>
            </div>
            <div class="form-group">
                <div class="col-sm-4">
                    <html:select property="ftipotramite" styleClass="form-control required">
                        <html:option value="-">Seleccione...</html:option>
                        <html:option value="%">TODOS</html:option>
                        <html:option value="DIFERIDO">CONTROL DIFERIDO</html:option>
                        <html:option value="POSTERIOR">FISCALIZACIÓN POSTERIOR</html:option>
                    </html:select>
                </div>
                <div class="col-sm-4">
                    <html:text property="fnit" styleId="fnit" styleClass="form-control numeric" size="30" maxlength="15" />
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
        Anb.form.submit('#form-reporte_liquidacion_dui', function (form) {
            Anb.form.cleanErrors(form);           
            if (Anb.validate.run(form)) {
                $("#opcion").val('CONSULTAR'); 
                console.log('Enviado!');
                Anb.loading.show()                
                form.submit();
            }
        });
        $("#boton").removeAttr("disabled");
        if(!($("#usuarioger").val()=="15")){
            $("#fgerencia").removeClass("required");
            $("#labelgerencia").removeClass("label-required");
        }
    });
    function consultar(){
        $("#opcion").val('CONSULTAR');  
    }
</script>