<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
    <h4 class="modal-title" id="myModalLabel">
        <strong>MODIFICAR ALCANCE</strong>
    </h4>
</div>
<html:form action="alcanceGuardar.do" method="post" styleId="form">
    <html:hidden property="idalcanceitem"/>
    <html:hidden property="eitem"/>
    <html:hidden property="codigo"/>
    <html:hidden property="epagina"/>
    <div class="modal-body form-horizontal">
        <div class="form-group">
            <label class="col-sm-3 control-label">Tipo:</label>
            <div class="col-sm-3">
                ${alcance.tipoTramite}
            </div>        
            <label class="col-sm-3 control-label">&nbsp;</label>
            <div class="col-sm-3">
                &nbsp;
            </div>
        </div>    
        <div class="form-group">
            <label class="col-sm-3 control-label">Tr&aacute;mite:</label>
            <div class="col-sm-3">
                ${alcance.tramite}
            </div>        
            <label class="col-sm-3 control-label">&Iacute;tem:</label>
            <div class="col-sm-3">
                ${alcance.item}
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Valor:</label>
            <div class="col-sm-1">
                <html:checkbox property="echvalor" style="width:13px;height:13px" styleId="echvalor"  styleClass="form-control ">&nbsp;</html:checkbox>
            </div>       
            <label class="col-sm-2 control-label">Origen:</label>
            <div class="col-sm-1">
                <html:checkbox property="echorigen" style="width:13px;height:13px" styleId="echorigen"  styleClass="form-control ">&nbsp;</html:checkbox>
            </div>
            <label class="col-sm-2 control-label">Partida:</label>
            <div class="col-sm-1">
                <html:checkbox property="echpartida" style="width:13px;height:13px" styleId="echpartida"  styleClass="form-control ">&nbsp;</html:checkbox>
            </div>
            <label class="col-sm-2 control-label">Otros:</label>
            <div class="col-sm-1">
                <html:checkbox property="echotro" style="width:13px;height:13px" styleId="echotro"  styleClass="form-control ">&nbsp;</html:checkbox>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-primary btn-principal">Guardar Cambios</button>
    </div>
</html:form>
<script>
  $(document).ready(function () {
      Anb.form.submit('#form', function (form) {
          if (Anb.validate.run(form)) {
              Anb.loading.show()
              form.submit();
          }
      });
  });
</script>