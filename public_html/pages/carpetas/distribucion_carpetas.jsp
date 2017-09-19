<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>DISTRIBUCIÓN CARPETAS</strong>
        </h4>
    </div>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-distribucioncarpetas" action="distribucioncarpetas.do">
            <input type="hidden" name="boton" id="boton"/>
            <input type="hidden" name="opcion" id="opcion"/>
            <div class="form-group">
                <label class="col-sm-3 control-label">N&uacute;mero de Carpeta Desde:</label>
                <div class="col-sm-3">
                    <html:text property="numerodesde" styleId="numerodesde" maxlength="15" styleClass="form-control required numeric" size="15"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">N&uacute;mero de Carpeta Hasta:</label>
                <div class="col-sm-3">
                    <html:text property="numerohasta" styleId="numerohasta" maxlength="15" styleClass="form-control required numeric" size="15"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">Gerencia:</label>
                <div class="col-sm-3">
                    <html:select property="gerencia" styleClass="form-control required">
                        <html:option value="-">Seleccione...</html:option> 
                        <html:option value="GRLPZ">Gerencia Regional La Paz</html:option> 
                        <html:option value="GRCBB">Gerencia Regional Cochabamba</html:option> 
                        <html:option value="GRORR">Gerencia Regional Oruro</html:option>
                        <html:option value="GRPTS">Gerencia Regional Potosi</html:option>
                        <html:option value="GRTRJ">Gerencia Regional Tarija</html:option>
                        <html:option value="GRSCZ">Gerencia Regional Santa Cruz</html:option>
                    </html:select>
                </div>
            </div>
            <div class="btn-container">
                <button type="submit" id="botonsubmit" onclick="consultar()" class="btn btn-primary" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Consultar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>            
            </div>
            <div class="form-group">
                <label class="label-message-required">
                    * Campos Obligatorios
                </label>
            </div>
            <br/>
            <br/>
            <br/>
            <div class="panel-body">
                <div  align="center" class="panel-body form-horizontal col-lg-6 col-sm-6">
                    ${DistribucionCarpetasForm.resultado}
                </div>
            </div>
        </html:form>
    </div>
</div>
<script>
    $(document).ready(function () {
        Anb.form.submit('#form-distribucioncarpetas', function (form) {
            Anb.form.cleanErrors(form);           
            if (Anb.validate.run(form)) {
                $("#boton").val('Distribucion');
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
    function asig(){
        Anb.confirm('¿Está seguro de asignar las carpetas?', function () {
            $("#opcion").val('Asignar'); 
            $("#form-distribucioncarpetas").submit();
        });
    }
</script>