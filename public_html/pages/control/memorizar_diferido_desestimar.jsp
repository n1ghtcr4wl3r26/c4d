<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="panel panel-default">
    
    <div class="panel-heading">
        <h4 class="panel-title"><strong>MEMORIZACIÓN DEL CONTROL</strong></h4>
    </div>
    <div class="modal-body form-horizontal">        
                    <div class="tab-pane active" id="1a">
                        <html:form styleId="form-diferido" action="memorizaciondiferido.do">
                            <html:hidden property="boton" value= "diferido"/>
                            <html:hidden property="difTipoDocumento"/>
                            <html:hidden property="difNroDocumento"/>
                            <html:hidden property="difFecDocumento"/>
                            <html:hidden property="difTipoOperador"/>
                            <html:hidden property="difRiesgoSubval"/>
                            <html:hidden property="difTipoDocPersona"/>
                            <html:hidden property="difNitEmpresa"/>
                            <html:hidden property="difNomEmpresa"/>
                            <html:hidden property="difDireccion"/>
                            <html:hidden property="difActividad"/>
                            <html:hidden property="difTribNoaplica"/>
                            <html:hidden property="difPeriodo"/>
                            <html:hidden property="difNroCIPersona"/>
                            <html:hidden property="difApPatPersona"/>
                            <html:hidden property="difApMatPersona"/>
                            <html:hidden property="difNombrePersona"/>
                            <html:hidden property="difExpCIPersona"/>
                            <br>
                            <div class="form-group">
                                <h3>
                                    <label class="col-sm-6">
                                        Memorización de Control Diferido
                                    </label>
                                </h3>
                            </div>
                            <div class="form-group">                            
                                <label class="col-sm-3 control-label">Tipo de Documento:</label>
                                <div class="col-sm-3">
                                    ${MemorizacionControlForm.difTipoDocumento}
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">N&uacute;mero de Documento:</label>
                                <div class="col-sm-3">
                                    ${MemorizacionControlForm.difNroDocumento}
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Fecha de Documento:</label>
                                <div class="col-sm-3">
                                    ${MemorizacionControlForm.difFecDocumento}
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Resumen de la Observaci&oacute;n:</label>
                                <div class="col-sm-4">
                                    <textarea name="difDetDocumento" id="difDetDocumento" class="form-control required" data-maxlength="500" onkeyup="Textarea_Sin_Enter(event.keyCode, event.which, 'difDetDocumento');" >${MemorizacionControlForm.difDetDocumento}</textarea>
                                </div>
                            </div>
                            <div class="form-group">                            
                                <label class="col-sm-3 control-label">Tipo de Operador:</label>
                                <div class="col-sm-3">
                                    ${MemorizacionControlForm.difTipoOperador}
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Tipo Documento de Identidad:</label>
                                <div class="col-sm-3">
                                    ${MemorizacionControlForm.difTipoDocPersona}
                                </div>
                            </div>
                            <c:if test="${fn:substring(esc.estado,0,3) == 'SIN' }">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">NIT:</label>
                                    <div class="col-sm-3">
                                        ${MemorizacionControlForm.difNitEmpresa}
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Raz&oacute;n Social:</label>
                                    <div class="col-sm-3">
                                        ${MemorizacionControlForm.difNomEmpresa}
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${fn:substring(esc.estado,0,3) == 'SIN' }">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">CI:</label>
                                    <div class="col-sm-2">
                                        ${MemorizacionControlForm.difNroCIPersona}
                                    </div>
                                    <div class="col-sm-3">
                                        ${MemorizacionControlForm.difExpCIPersona}
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Nombres:</label>
                                    <div class="col-sm-3">
                                        ${MemorizacionControlForm.difNombrePersona}
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Apellido Paterno:</label>
                                    <div class="col-sm-3">
                                        ${MemorizacionControlForm.difApPatPersona}
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Apellido Materno:</label>
                                    <div class="col-sm-3">
                                        ${MemorizacionControlForm.difApMatPersona}
                                    </div>
                                </div>
                            </c:if>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Direcci&oacute;n:</label>
                                <div class="col-sm-3">
                                    ${MemorizacionControlForm.difDireccion}
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Actividad:</label>
                                <div class="col-sm-3">
                                    ${MemorizacionControlForm.difActividad}
                                </div>
                            </div>
                            <div class="btn-container">
                                <button type="submit" id="boton" class="btn btn-primary" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grabar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>            
                            </div>
                            <div class="form-group">
                                <label class="label-message-required">
                                    * Campos Obligatorios
                                </label>
                            </div>
                        </html:form>
                    </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        
        function diasentrefechas(fechadesde,fechahasta){
            var dia1 = fechadesde.substring(0,2);
            var mes1 = fechadesde.substring(3,5);
            var anio1= fechadesde.substring(6,10);
            var dia2 = fechahasta.substring(0,2);
            var mes2 = fechahasta.substring(3,5);
            var anio2 = fechahasta.substring(6,10);
            var fecha1 = new Date(anio1,mes1-1,dia1);
            var fecha2 = new Date(anio2,mes2-1,dia2);
            var dias = Math.floor((fecha2-fecha1)/(1000*60*60*24));
            return dias;
        };
        
        function Textarea_Sin_Enter($char, $mozChar, $id){
        //alert ($char+" "+$mozChar);
           $textarea = document.getElementById($id);
           niveles = -1;
            
           if($mozChar != null) { // Navegadores compatibles con Mozilla
               if($mozChar == 13){
                   if(navigator.appName == "Opera") niveles = -2;
                   $textarea.value = $textarea.value.slice(0, niveles);
               }
           // navegadores compatibles con IE
           } else if($char == 13) $textarea.value = $textarea.value.slice(0,-2);
           var v = "";
           v = document.getElementById($id).value;
           $textarea.value=v.replace(/\n/g,"");
        };
        Anb.form.submit('#form-diferido', function (form) {
            Anb.form.cleanErrors(form);
            if (Anb.validate.run(form)) {
                console.log('Enviado!');
                Anb.loading.show()                
                form.submit();
            }
        });
    });
</script>


