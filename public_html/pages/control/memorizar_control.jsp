<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
 
<div class="panel panel-default">
    
    <div class="panel-heading">
        <h4 class="panel-title"><strong>MEMORIZACIÓN DEL CONTROL</strong></h4>
    </div>
    <div class="modal-body form-horizontal">        
            <div id="exTab1" >
                <ul class="nav nav-pills">
                    <li class="active" id="tabpos"  >
                        <a href="#2a" data-toggle="tab">Orden de Fiscalización Posterior</a>
                    </li>
                    <li id="tabamp">
                        <a href="#3a" data-toggle="tab">Orden de Fiscalización Ampliatoria</a>
                    </li>
                </ul>
                <div class="tab-content clearfix">
                    <div class="tab-pane active" id="2a">
                        <html:form styleId="form-posterior" action="memorizacionpos.do">
                            <html:hidden property="boton" value= "posterior"/>
                            <br>
                            <div class="form-group">
                                <h3>
                                    <label class="col-sm-6">
                                        Memorización de Orden de Fiscalización Posterior
                                    </label>
                                </h3>
                            </div>
                            <div class="form-group">                            
                                <label class="col-sm-3 control-label">Tipo de Documento:</label>
                                <div class="col-sm-3">
                                    <html:select property="posTipoDocumento" styleClass="form-control required">
                                        <html:option value="-">Seleccione...</html:option>
                                        <html:option value="ARF">ARF</html:option>
                                        <html:option value="INFORME">INFORME</html:option>
                                        <html:option value="DENUNCIA">DENUNCIA</html:option>
                                        <html:option value="OTRO">OTRO</html:option>
                                    </html:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">N&uacute;mero de Documento:</label>
                                <div class="col-sm-3">
                                    <html:text property="posNroDocumento" styleId="posNroDocumento" styleClass="form-control required" size="30" maxlength="30" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Fecha de Documento:</label>
                                <div class="col-sm-3">
                                    <html:text property="posFecDocumento" styleId="posFecDocumento" styleClass="form-control datepicker required date-less-than" size="30" maxlength="30" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Resumen de la Observaci&oacute;n:</label>
                                <div class="col-sm-4">
                                    <textarea name="posDetDocumento" id="posDetDocumento" class="form-control required" data-maxlength="500" onkeyup="Textarea_Sin_Enter(event.keyCode, event.which, 'posDetDocumento');" >${MemorizacionControlForm.posDetDocumento}</textarea>
                                </div>
                            </div>
                            <div class="form-group">                            
                                <label class="col-sm-3 control-label">Riesgo Identificado:</label>
                                <div class="col-sm-3">
                                    <html:checkbox property="posRiesgoDelito" style="width:13px;height:13px" styleId="posRiesgoDelito"  styleClass="form-control ">&nbsp;&nbsp;Delito</html:checkbox><br>
                                    <html:checkbox property="posRiesgoSubval" style="width:13px;height:13px" styleId="posRiesgoSubval"  styleClass="form-control ">&nbsp;&nbsp;Subvaluación</html:checkbox><br>
                                    <html:checkbox property="posRiesgoClas" style="width:13px;height:13px" styleId="posRiesgoClas"  styleClass="form-control ">&nbsp;&nbsp;Clasificación</html:checkbox><br>
                                    <html:checkbox property="posRiesgoContrab" style="width:13px;height:13px" styleId="posRiesgoContrab"  styleClass="form-control ">&nbsp;&nbsp;Contrabando Contravencional</html:checkbox><br>
                                </div>
                            </div>
                            <div class="form-group">                            
                                <label class="col-sm-3 control-label">Tipo de Operador:</label>
                                <div class="col-sm-3">
                                    <html:select property="posTipoOperador" styleClass="form-control required">
                                        <html:option value="-">Seleccione...</html:option>
                                        <html:option value="IMPORTADOR/EXPORTADOR">IMPORTADOR/EXPORTADOR</html:option>
                                        <html:option value="TRANSPORTISTA">TRANSPORTISTA</html:option>
                                        <html:option value="DECLARANTE">DECLARANTE</html:option>
                                    </html:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Tipo Documento de Identidad:</label>
                                <div class="col-sm-3">
                                    <html:select property="posTipoDocPersona" styleId="posTipoDocPersona" styleClass="form-control required">
                                        <html:option value="-">Seleccione...</html:option>
                                        <html:option value="NIT">NIT</html:option>
                                        <html:option value="CI">CI</html:option>
                                    </html:select>
                                </div>
                            </div>
                            <div id="pos-nit-panel" style="display:none">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">NIT:</label>
                                    <div class="col-sm-3">
                                        <html:text property="posNitEmpresa" styleId="posNitEmpresa" styleClass="form-control required numeric" size="30" maxlength="30" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Raz&oacute;n Social:</label>
                                    <div class="col-sm-3">
                                        <html:text property="posNomEmpresa" styleId="posNomEmpresa" styleClass="form-control required" size="30" maxlength="100" />
                                    </div>
                                </div>
                            </div>
                            <div id="pos-ci-panel" style="display:none">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">CI:</label>
                                    <div class="col-sm-2">
                                        <html:text property="posNroCIPersona" styleId="posNroCIPersona" styleClass="form-control required" size="30" maxlength="10" />
                                    </div>
                                    <div class="col-sm-3">
                                        <html:select property="posExpCIPersona" styleId="posExpCIPersona" styleClass="form-control required">
                                            <html:option value="-">Seleccione...</html:option>
                                            <html:option value="LP">La Paz</html:option>
                                            <html:option value="CB">Cochabamba</html:option>
                                            <html:option value="SC">Santa Cruz</html:option>
                                            <html:option value="PN">Pando</html:option>
                                            <html:option value="PT">Potosi</html:option>
                                            <html:option value="TR">Tarija</html:option>
                                            <html:option value="CH">Chuquisaca</html:option>
                                            <html:option value="BN">Beni</html:option>
                                            <html:option value="OR">Oruro</html:option>
                                        </html:select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Nombres:</label>
                                    <div class="col-sm-3">
                                        <html:text property="posNombrePersona" styleId="posNombrePersona" styleClass="form-control required" size="30" maxlength="30" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Apellido Paterno:</label>
                                    <div class="col-sm-3">
                                        <html:text property="posApPatPersona" styleId="posApPatPersona" styleClass="form-control required" size="30" maxlength="30" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Apellido Materno:</label>
                                    <div class="col-sm-3">
                                        <html:text property="posApMatPersona" styleId="posApMatPersona" styleClass="form-control required" size="30" maxlength="30" />
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Direcci&oacute;n:</label>
                                <div class="col-sm-3">
                                    <html:text property="posDireccion" styleId="posDireccion" styleClass="form-control required" size="30" maxlength="100" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Actividad:</label>
                                <div class="col-sm-3">
                                    <html:text property="posActividad" styleId="posActividad" styleClass="form-control required" size="30" maxlength="100" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Tributos a Fiscalizar:</label>
                                <div class="col-sm-3">
                                    <html:checkbox property="posTribGa" style="width:13px;height:13px" styleId="posTribGa"  styleClass="form-control ">&nbsp;&nbsp;GA</html:checkbox><br>
                                    <html:checkbox property="posTribIva" style="width:13px;height:13px" styleId="posTribIva"  styleClass="form-control ">&nbsp;&nbsp;IVA</html:checkbox><br>
                                    <html:checkbox property="posTribIce" style="width:13px;height:13px" styleId="posTribIce"  styleClass="form-control ">&nbsp;&nbsp;ICE</html:checkbox><br>
                                    <html:checkbox property="posTribIehd" style="width:13px;height:13px" styleId="posTribIehd"  styleClass="form-control ">&nbsp;&nbsp;IEHD</html:checkbox><br>
                                    <html:checkbox property="posTribIcd" style="width:13px;height:13px" styleId="posTribIcd"  styleClass="form-control ">&nbsp;&nbsp;ICD</html:checkbox><br>
                                    <html:checkbox property="posTribNoaplica" style="width:13px;height:13px" styleId="posTribNoaplica"  styleClass="form-control ">&nbsp;&nbsp;NO APLICA</html:checkbox>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Periodo a Fiscalizar:</label>
                                <div class="col-sm-3">
                                    <html:text property="posPeriodo" styleId="posPeriodo" styleClass="form-control required" size="30" maxlength="30" />
                                </div>
                            </div>
                            <div class="btn-container">
                                <button type="submit" id="boton2" class="btn btn-primary" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grabar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>            
                            </div>
                            <div class="form-group">
                                <label class="label-message-required">
                                    * Campos Obligatorios
                                </label>
                            </div>
                        </html:form>
                    </div>
                    <div class="tab-pane" id="3a">
                        <html:form styleId="form-ampliatoria" action="memorizacionamp.do">
                            <html:hidden property="boton" value= "ampliatoria"/>
                            <br>
                            <div class="form-group">
                                <h3>
                                    <label class="col-sm-8">
                                        Memorización de Orden de Fiscalización Ampliatoria
                                    </label>
                                </h3>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Orden de Fiscalizaci&oacute;n Padre:</label>
                                <div class="col-sm-8">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">Gesti&oacute;n:</label>
                                        <label class="col-sm-2 control-label">Tipo Control:</label>
                                        <label class="col-sm-4 control-label">Gerencia:</label>
                                        <label class="col-sm-2 control-label">N&uacute;mero de Orden de Fiscalización:</label>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-2">
                                            <html:text property="ampGestion" styleId="ampGestion" styleClass="form-control required numeric" size="30" maxlength="4" />
                                        </div>
                                        <div class="col-sm-2">
                                            <html:select property="ampControl" styleClass="form-control required">
                                                <html:option value="-">Seleccione...</html:option>
                                                <html:option value="DIFERIDO">DIFERIDO</html:option>
                                                <html:option value="POSTERIOR">POSTERIOR</html:option>
                                            </html:select>
                                        </div>
                                        <div class="col-sm-4">
                                            <html:select property="ampGerencia" styleClass="form-control required">
                                                <html:option value="-">Seleccione...</html:option>
                                                <html:option value="GNF">NACIONAL DE FISCALIZACIÓN</html:option>
                                                <html:option value="GRL">LA PAZ</html:option>
                                                <html:option value="GRC">COCHABAMBA</html:option>
                                                <html:option value="GRS">SANTA CRUZ</html:option>
                                                <html:option value="GRO">ORURO</html:option>
                                                <html:option value="GRT">TARIJA</html:option>
                                                <html:option value="GRP">POTOSI</html:option>
                                            </html:select>
                                        </div>
                                        <div class="col-sm-2">
                                            <html:text property="ampNumero" styleId="ampNumero" styleClass="form-control required numeric" size="30" maxlength="10" />
                                        </div>                
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">                            
                                <label class="col-sm-3 control-label">Tipo de Operador:</label>
                                <div class="col-sm-3">
                                    <html:select property="ampTipoOperador" styleClass="form-control required">
                                        <html:option value="-">Seleccione...</html:option>
                                        <html:option value="IMPORTADOR/EXPORTADOR">IMPORTADOR/EXPORTADOR</html:option>
                                        <html:option value="TRANSPORTISTA">TRANSPORTISTA</html:option>
                                        <html:option value="DECLARANTE">DECLARANTE</html:option>
                                    </html:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Tipo Documento de Identidad:</label>
                                <div class="col-sm-3">
                                    <html:select property="ampTipoDocPersona" styleId="ampTipoDocPersona" styleClass="form-control required">
                                        <html:option value="-">Seleccione...</html:option>
                                        <html:option value="NIT">NIT</html:option>
                                        <html:option value="CI">CI</html:option>
                                    </html:select>
                                </div>
                            </div>
                            <div id="amp-nit-panel" style="display:none">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">NIT:</label>
                                    <div class="col-sm-3">
                                        <html:text property="ampNitEmpresa" styleId="ampNitEmpresa" styleClass="form-control required numeric" size="30" maxlength="30" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Raz&oacute;n Social:</label>
                                    <div class="col-sm-5">
                                        <html:text property="ampNomEmpresa" styleId="ampNomEmpresa" styleClass="form-control required" size="30" maxlength="100" />
                                    </div>
                                </div>
                            </div>
                            <div id="amp-ci-panel" style="display:none">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">CI:</label>
                                    <div class="col-sm-3">
                                        <html:text property="ampNroCIPersona" styleId="ampNroCIPersona" styleClass="form-control required" size="30" maxlength="10" />
                                    </div>
                                    <div class="col-sm-3">
                                        <html:select property="ampExpCIPersona" styleId="ampExpCIPersona" styleClass="form-control required">
                                            <html:option value="-">Seleccione...</html:option>
                                            <html:option value="LP">La Paz</html:option>
                                            <html:option value="CB">Cochabamba</html:option>
                                            <html:option value="SC">Santa Cruz</html:option>
                                            <html:option value="PN">Pando</html:option>
                                            <html:option value="PT">Potosi</html:option>
                                            <html:option value="TR">Tarija</html:option>
                                            <html:option value="CH">Chuquisaca</html:option>
                                            <html:option value="BN">Beni</html:option>
                                            <html:option value="OR">Oruro</html:option>
                                        </html:select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Nombres:</label>
                                    <div class="col-sm-5">
                                        <html:text property="ampNombrePersona" styleId="ampNombrePersona" styleClass="form-control required" size="30" maxlength="30" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Apellido Paterno:</label>
                                    <div class="col-sm-5">
                                        <html:text property="ampApPatPersona" styleId="ampApPatPersona" styleClass="form-control required" size="30" maxlength="30" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Apellido Materno:</label>
                                    <div class="col-sm-5">
                                        <html:text property="ampApMatPersona" styleId="ampApMatPersona" styleClass="form-control required" size="30" maxlength="30" />
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Direcci&oacute;n:</label>
                                <div class="col-sm-5">
                                    <html:text property="ampDireccion" styleId="ampDireccion" styleClass="form-control required" size="30" maxlength="100" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Actividad:</label>
                                <div class="col-sm-5">
                                    <html:text property="ampActividad" styleId="ampActividad" styleClass="form-control required" size="30" maxlength="100" />
                                </div>
                            </div>
                            <div class="btn-container">
                                <button type="submit" id="boton3" class="btn btn-primary" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grabar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>            
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
    </div>
</div>
<script>
    $(document).ready(function () {
        if (!($('#posTipoDocPersona').val()=="-")) {
            $('#2a').addClass('active');
            $('#3a').removeClass('active');
            $('#tabpos').addClass('active');
            $('#tabamp').removeClass('active');            
        }
        if (!($('#ampTipoDocPersona').val()=="-")) {
            $('#2a').removeClass('active');
            $('#3a').addClass('active');
            $('#tabpos').removeClass('active');
            $('#tabamp').addClass('active');            
        }        
        if ($('#ampTipoDocPersona').val()=="NIT") {
            $('#amp-nit-panel').show();
            $('#amp-ci-panel').hide();
            $('#ampNitEmpresa').addClass('required');
            $('#ampNomEmpresa').addClass('required');
            $('#ampNroCIPersona').removeClass('required');
            $('#ampExpCIPersona').removeClass('required');
            $('#ampNombrePersona').removeClass('required');
            $('#ampApPatPersona').removeClass('required');
            $('#ampApMatPersona').removeClass('required');
            $('#ampNroCIPersona').val('');
            $('#ampExpCIPersona').val('');
            $('#ampNombrePersona').val('');
            $('#ampApPatPersona').val('');
            $('#ampApMatPersona').val('');
        }
        if ($('#ampTipoDocPersona').val()=="CI") {
            $('#amp-nit-panel').hide();
            $('#amp-ci-panel').show();
            $('#ampNitEmpresa').removeClass('required');
            $('#ampNomEmpresa').removeClass('required');
            $('#ampNitEmpresa').val('');
            $('#ampNomEmpresa').val('');
            $('#ampNroCIPersona').addClass('required');
            $('#ampExpCIPersona').addClass('required');
            $('#ampNombrePersona').addClass('required');
            $('#ampApPatPersona').addClass('required');
            $('#ampApMatPersona').addClass('required');
        }        
        if ($('#posTipoDocPersona').val()=="NIT") {
            $('#pos-nit-panel').show();
            $('#pos-ci-panel').hide();
            $('#posNitEmpresa').addClass('required');
            $('#posNomEmpresa').addClass('required');
            $('#posNroCIPersona').removeClass('required');
            $('#posExpCIPersona').removeClass('required');
            $('#posNombrePersona').removeClass('required');
            $('#posApPatPersona').removeClass('required');
            $('#posApMatPersona').removeClass('required');
            $('#posNroCIPersona').val('');
            $('#posExpCIPersona').val('');
            $('#posNombrePersona').val('');
            $('#posApPatPersona').val('');
            $('#posApMatPersona').val('');
        }
        if ($('#posTipoDocPersona').val()=="CI") {
            $('#pos-nit-panel').hide();
            $('#pos-ci-panel').show();
            $('#posNitEmpresa').removeClass('required');
            $('#posNomEmpresa').removeClass('required');
            $('#posNitEmpresa').val('');
            $('#posNomEmpresa').val('');
            $('#posNroCIPersona').addClass('required');
            $('#posExpCIPersona').addClass('required');
            $('#posNombrePersona').addClass('required');
            $('#posApPatPersona').addClass('required');
            $('#posApMatPersona').addClass('required');
        }
        
        $('#posNitEmpresa').change(function(){
           var aux = Math.random();
           if ($("#posNitEmpresa").val() != null && $("#posNitEmpresa").val() != "")
           $.get('completanit.do',{
                nit: $(this).val(), 
                vaux: aux
            },function(resultado){
                $("#posNomEmpresa").val(resultado[0].razon);
                $("#posDireccion").val(resultado[0].direccion);
                $("#posActividad").val(resultado[0].actividad);
            },'json');
        }); 
        
        $('#ampNitEmpresa').change(function(){
           var aux = Math.random();
           if ($("#ampNitEmpresa").val() != null && $("#ampNitEmpresa").val() != "")
           $.get('completanit.do',{
                nit: $(this).val(), 
                vaux: aux
            },function(resultado){
                $("#ampNomEmpresa").val(resultado[0].razon);
                $("#ampDireccion").val(resultado[0].direccion);
                $("#ampActividad").val(resultado[0].actividad);
            },'json');
        });         
        
        $('#posTipoDocPersona').change(function () {
            if ($('#posTipoDocPersona').val()=="NIT") {
                $('#pos-nit-panel').show();
                $('#pos-ci-panel').hide();
                $('#posNitEmpresa').addClass('required');
                $('#posNomEmpresa').addClass('required');
                $('#posNroCIPersona').removeClass('required');
                $('#posExpCIPersona').removeClass('required');
                $('#posNombrePersona').removeClass('required');
                $('#posApPatPersona').removeClass('required');
                $('#posApMatPersona').removeClass('required');
                
                $('#posNroCIPersona').val('');
                $('#posExpCIPersona').val('');
                $('#posNombrePersona').val('');
                $('#posApPatPersona').val('');
                $('#posApMatPersona').val('');
            }
            if ($('#posTipoDocPersona').val()=="CI") {
                $('#pos-nit-panel').hide();
                $('#pos-ci-panel').show();
                $('#posNitEmpresa').removeClass('required');
                $('#posNomEmpresa').removeClass('required');
                
                $('#posNitEmpresa').val('');
                $('#posNomEmpresa').val('');
                $('#posNroCIPersona').addClass('required');
                $('#posExpCIPersona').addClass('required');
                $('#posNombrePersona').addClass('required');
                $('#posApPatPersona').addClass('required');
                $('#posApMatPersona').addClass('required');
            }
        });
        
        $('#ampTipoDocPersona').change(function () {
            if ($('#ampTipoDocPersona').val()=="NIT") {
                $('#amp-nit-panel').show();
                $('#amp-ci-panel').hide();
                $('#ampNitEmpresa').addClass('required');
                $('#ampNomEmpresa').addClass('required');
                $('#ampNroCIPersona').removeClass('required');
                $('#ampExpCIPersona').removeClass('required');
                $('#ampNombrePersona').removeClass('required');
                $('#ampApPatPersona').removeClass('required');
                $('#ampApMatPersona').removeClass('required');
                
                $('#ampNroCIPersona').val('');
                $('#ampExpCIPersona').val('');
                $('#ampNombrePersona').val('');
                $('#ampApPatPersona').val('');
                $('#ampApMatPersona').val('');
            }
            if ($('#ampTipoDocPersona').val()=="CI") {
                $('#amp-nit-panel').hide();
                $('#amp-ci-panel').show();
                $('#ampNitEmpresa').removeClass('required');
                $('#ampNomEmpresa').removeClass('required');
                
                $('#ampNitEmpresa').val('');
                $('#ampNomEmpresa').val('');
                $('#ampNroCIPersona').addClass('required');
                $('#ampExpCIPersona').addClass('required');
                $('#ampNombrePersona').addClass('required');
                $('#ampApPatPersona').addClass('required');
                $('#ampApMatPersona').addClass('required');
            }
        });
        
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
    
        Anb.form.submit('#form-posterior', function (form) {
            Anb.form.cleanErrors(form);
            if (Anb.validate.run(form)) {
                console.log('Enviado!');
                Anb.loading.show()
                form.submit();
            }
        });
        Anb.form.submit('#form-ampliatoria', function (form) {
            Anb.form.cleanErrors(form);
            if (Anb.validate.run(form)) {
                console.log('Enviado!');
                Anb.loading.show()
                form.submit();
            }
        });
    });
</script>


