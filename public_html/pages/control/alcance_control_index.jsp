<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="anb.bean.*"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>ALCANCE CONTROL</strong>
        </h4>
    </div>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-alcance" action="alcindex.do">
            
            <input type="hidden" name="opcion" id="opcion"/>
            <div class="form-group">
                <label class="col-sm-3 control-label">N&uacute;mero Control Memorizado:</label>
                <div class="col-sm-3">
                    <html:text property="codigo" styleId="codigo" maxlength="15" styleClass="form-control required numeric" size="15"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">Tipo de Búsqueda:</label>
                <div class="col-sm-3">
                    <html:select property="tipoBusqueda" styleClass="form-control required">
                        <html:option value="-">Seleccione...</html:option>
                        <html:option value="FILTRO">FILTRO</html:option>
                        <html:option value="TRAMITE">TRAMITE</html:option>
                    </html:select>
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
        Anb.form.submit('#form-alcance', function (form) {
            Anb.form.cleanErrors(form);
            if (Anb.validate.run(form)) {
                console.log('Enviado!');
                Anb.loading.show()                
                form.submit();
            }
        }); 
        $("#boton").removeAttr("disabled");
      
  });
  function consultar(){
        $("#opcion").val('CONSULTACTL');   
        
  }
</script>