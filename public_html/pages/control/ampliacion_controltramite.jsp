<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="anb.bean.*"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>AMPLIACIÓN ALCANCE POR TRÁMITE</strong>
        </h4>
    </div>
    <% 
        AmpliacionForm alc = (AmpliacionForm)request.getAttribute("AmpliacionForm");
    %>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-tramitedec" action="ampliaciontramite.do">
            <html:hidden property="boton" value="declaracion"/>
            <html:hidden property="opcion" value="GRABA"/>
            <html:hidden property="codigo" styleId="codigo"/>
            <div class="form-group">
                <h3>
                    <label class="col-sm-10">ADICIONAR DECLARACIÓN O MANIFIESTO</label>
                </h3>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Código:</label>
                <div class="col-sm-2">
                    ${infoControl.codigo}
                </div>
                <label class="col-sm-2 control-label">Tipo Control:</label>
                <div class="col-sm-2">
                    ${infoControl.tipoControl}
                </div>
            </div>
	    <div class="form-group">
                <label class="col-sm-2 control-label">Operador:</label>
                <div class="col-sm-6">
                    ${infoControl.tipoDocIdentificacion}
                &nbsp;
                    ${infoControl.docIdentificacion}
                :
                    ${infoControl.nomIdentificacion}
                </div>
            </div>
            <br>
            <div class="form-group">
                <div class="col-sm-10">
                    <div class="form-group">
                        <label class="col-sm-2 control-label label-required">Tipo:</label>
                         
                        <label class="col-sm-2 control-label label-required">Gesti&oacute;n:</label>
                         
                        <label class="col-sm-4 control-label label-required">Aduana:</label>
                         
                        <label class="col-sm-2 control-label label-required">N&uacute;mero:</label>
                    </div>
                    <div class="form-group">
                        <div class="form-group">
                            <div class="col-sm-2">
                                <html:select property="tipoTramite" styleClass="form-control required">
                                    <html:option value="-">Seleccione...</html:option>
                                    <html:option value="DUI">DUI</html:option>
                                    <html:option value="DUE">DUE</html:option>
                                    <html:option value="MIC">MANIFIESTO</html:option>
                                </html:select>
                            </div>
                            <div class="col-sm-2">
                                <html:text property="gestion" styleId="gestion"
                                           styleClass="form-control required numeric" size="30" maxlength="4"/>
                            </div>
                            <div class="col-sm-4">
                                <html:select property="aduana" styleClass="form-control required">
                                    <option value="-">Seleccione...</option>
                                    <html:optionsCollection name="aduanas" value="codigo" label="descripcion"/>
                                </html:select>
                            </div>
                            <div class="col-sm-2">
                                <html:text property="numero" styleId="numero" styleClass="form-control required numeric"
                                           size="30" maxlength="10"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-1 control-label">Valor:</label>
                         
                        <label class="col-sm-1 control-label">Partida:</label>
                         
                        <label class="col-sm-1 control-label">Origen:</label>
                         
                        <label class="col-sm-1 control-label">Otro:</label>
                    </div>
                    <div class="form-group">
                        <div class="form-group">
                            <div class="col-sm-1" style="text-align:center">
                                <html:checkbox property="chvalor" style="width:13px;height:13px" styleId="chvalor"  styleClass="form-control "/>
                            </div>
                            <div class="col-sm-1" style="text-align:center">
                                <html:checkbox property="chpartida" style="width:13px;height:13px" styleId="chvalor"  styleClass="form-control "/>
                            </div>
                            <div class="col-sm-1" style="text-align:center">
                                <html:checkbox property="chorigen" style="width:13px;height:13px" styleId="chvalor"  styleClass="form-control "/>
                            </div>
                            <div class="col-sm-1" style="text-align:center">
                                <html:checkbox property="chotro" style="width:13px;height:13px" styleId="chvalor"  styleClass="form-control "/>
                            </div>
                        </div>
                    </div>
                    <div class="btn-container">
                        <button type="submit" id="boton3" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grabar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                    </div>
                    <div class="form-group">
                        <label class="label-message-required">* Campos Obligatorios</label>
                    </div>
                </div>
            </div>
        </html:form>
        <br><br>
        <html:form styleId="form-tramitefac" action="ampliaciontramite.do">
            <html:hidden property="boton" value="factura"/>
            <html:hidden property="opcion" value="GRABA"/>
            <html:hidden property="codigo" styleId="codigo"/>
            <div class="form-group">
                <h3>
                    <label class="col-sm-10">ADICIONAR FACTURAS COMERCIALES</label>
                </h3>
            </div>
            <div class="form-group">
                <div class="col-sm-10">
                    <div class="form-group">
                        <label class="col-sm-2 control-label label-required">N&uacute;mero:</label>
                         
                        <label class="col-sm-2 control-label label-required">Fecha:</label>
                         
                        <label class="col-sm-2 control-label label-required">Proveedor:</label>
                         
                        <label class="col-sm-4 control-label label-required">Pa&iacute;s</label>
                    </div>
                    <div class="form-group">
                        <div class="form-group">
                            <div class="col-sm-2">
                                <html:text property="facnumero" styleId="facnumero"
                                           styleClass="form-control required numeric" size="30" maxlength="10"/>
                            </div>
                            <div class="col-sm-2">
                                <html:text property="facfecha" styleId="facfecha"
                                           styleClass="form-control required datepicker date-less-than" size="30" maxlength="10"/>
                            </div>
                            <div class="col-sm-2">
                                <html:text property="facemisor" styleId="facemisor"
                                           styleClass="form-control required" size="30" maxlength="50"/>
                            </div>
                            <div class="col-sm-4">
                                <html:select property="origen" styleClass="form-control required">
                                    <html:option value="-">Seleccione...</html:option>
                                    <html:optionsCollection name="paises" value="codigo" label="descripcion"/>
                                </html:select>
                            </div>
                        </div>
                    </div>
                    <div class="btn-container">
                        <button type="submit" id="boton3" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grabar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                    </div>
                    <div class="form-group">
                        <label class="label-message-required">* Campos Obligatorios</label>
                    </div>
                </div>
            </div>
        </html:form>
        <br><br>
        <html:form styleId="form-tramitetrans" action="ampliaciontramite.do">
            <html:hidden property="boton" value="transferencia"/>
            <html:hidden property="opcion" value="GRABA"/>
            <html:hidden property="codigo" styleId="codigo"/>
            <div class="form-group">
                <h3>
                    <label class="col-sm-10">ADICIONAR TRANSFERENCIAS BANCARIAS</label>
                </h3>
            </div>
            <div class="form-group">
                <div class="col-sm-10">
                    <div class="form-group">
                        <label class="col-sm-2 control-label label-required">Gesti&oacute;n:</label>
                         
                        <label class="col-sm-2 control-label label-required">Fecha:</label>
                         
                        <label class="col-sm-4 control-label label-required">Banco:</label>
                         
                    </div>
                    <div class="form-group">
                        <div class="form-group">
                            <div class="col-sm-2">
                                <html:text property="tragestion" styleId="tragestion"
                                           styleClass="form-control required numeric" size="30" maxlength="4"/>
                            </div>
                            <div class="col-sm-2">
                                <html:text property="trafecha" styleId="trafecha"
                                           styleClass="form-control required datepicker date-less-than" size="30" maxlength="10"/>
                            </div>
                            <div class="col-sm-4">
                                <html:text property="traemisor" styleId="traemisor"
                                           styleClass="form-control required" size="30" maxlength="50"/>
                            </div>
                        </div>
                    </div>
                    <div class="btn-container">
                        <button type="submit" id="boton3" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grabar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                    </div>
                    <div class="form-group">
                        <label class="label-message-required">* Campos Obligatorios</label>
                    </div>
                </div>
            </div>
        </html:form>
        <br><br>
        <html:form styleId="form-tramiteotro" action="ampliaciontramite.do">
            <html:hidden property="boton" value="otro"/>
            <html:hidden property="opcion" value="GRABA"/>
            <html:hidden property="codigo" styleId="codigo"/>
            <div class="form-group">
                <h3>
                    <label class="col-sm-10">ADICIONAR OTROS</label>
                </h3>
            </div>
            <div class="form-group">
                <div class="col-sm-10">
                    <div class="form-group">
                        <label class="col-sm-2 control-label label-required">Gesti&oacute;n:</label>
                         
                        <label class="col-sm-2 control-label label-required">Fecha:</label>
                         
                        <label class="col-sm-3 control-label label-required">Emisor:</label>
                         
                        <label class="col-sm-3 control-label label-required">Tipo de Documento:</label>
                    </div>
                    <div class="form-group">
                        <div class="form-group">
                            <div class="col-sm-2">
                                <html:text property="otrgestion" styleId="otrgestion"
                                           styleClass="form-control required numeric" size="30" maxlength="4"/>
                            </div>
                            <div class="col-sm-2">
                                <html:text property="otrfecha" styleId="otrfecha"
                                           styleClass="form-control required datepicker date-less-than" size="30" maxlength="10"/>
                            </div>
                            <div class="col-sm-3">
                                <html:text property="otremisor" styleId="otremisor"
                                           styleClass="form-control required" size="30" maxlength="50"/>
                            </div>
                            <div class="col-sm-3">
                                <html:text property="otrtipoDoc" styleId="otrtipoDoc" styleClass="form-control required "
                                           size="30" maxlength="30"/>
                            </div>
                        </div>
                    </div>
                    <div class="btn-container">
                        <button type="submit" id="boton3" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grabar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                    </div>
                    <div class="form-group">
                        <label class="label-message-required">* Campos Obligatorios</label>
                    </div>
                </div>
            </div>
        </html:form>
        
        
         <html:form styleId="form-alcance" action="ampliaciontramite.do">
            <input type="hidden" name="opcion" id="opcion"/>
            <html:hidden property="borrarid" styleId="borrarid"/>
            <html:hidden property="codigo" styleId="codigo"/>
        <% 
            if(alc.getCantidad_alc() > 0) {
            %>  
                <br>
                <br>
                <h4>
                    <strong>LISTA DEL ALCANCE DE LA FISCALIZACIÓN</strong>
                </h4>            
                <table class="table table-striped table-hover" id="main-table">
                    <thead>
                        <tr>
                            <th>N&uacute;mero</th>
                            <th>Tipo</th>
                            <th>Item</th>
                            <th>Documento</th>
                            <th>Observaci&oacute;n</th>
                            <th width="100px">Valor</th>
                            <th width="100px">Origen</th>
                            <th width="100px">Clasificación Arancelaria</th>
                            <th width="100px">Otro</th>
                            <th class="noExport">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>                    
                        <c:forEach items="${tramites}" var="tra">
                            <tr>
                                <td>${tra.numero}</td>
                                <td class="text-left">${tra.tipoTramite}</td>
                                <td style="text-align:center">
                                    ${tra.item}
                                </td>
                                <td class="text-left">${tra.tramite}</td>
                                <td class="text-left">${tra.observacion}</td>
                                <td style="text-align:center">
                                    ${tra.valor}
                                </td>
                                <td style="text-align:center">
                                    ${tra.origen}
                                </td>
                                <td style="text-align:center">
                                    ${tra.partida}
                                </td>
                                <td style="text-align:center">
                                    ${tra.otro}
                                </td>
                                <td>
                                    <c:if test="${tra.tipoEtapa == 'AMPLIATORIA' }">
                                        <button class="deletebtn btn btn-info btn-sm " 
                                            type="button"
                                            title="Borrar Alcance"
                                            data-item="${tra.codigoItem}"
                                            data-id="${tra.codigoItem}">
                                        <i class="fa fa-close"></i> Borrar
                                    </button>
                                    </c:if>
                                    &nbsp;
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>    
            <%
            }
            %> 
            
            </html:form>
            <html:form styleId="form-alcance-borrar" action="ampliaciontramite.do">
                <input type="hidden" name="opcion" id="opcionb"/>
                <html:hidden property="codigo" styleId="codigob"/>
                
                <button class="btn btn-info btn-sm newHide" 
                        type="button" id="btnInc"
                        title="Eliminar todo el alcance"
                        onfocus="borrar_alcance()">
                        <i class="fa fa-percent"></i> Eliminar todo el alcance
                </button> 
            </html:form>
        
    </div>
</div>
<script>
$(window).load(function() {
          $(".buttons-excel").hide();
    });
    function borrar_alcance(){
          Anb.confirm('¿Está seguro que desea eliminar todos los trámites ampliados del alcance?', function () {
              $("#opcionb").val('BORRAALL'); 
              $("#codigob").val($("#codigo").val());
              $("#form-alcance-borrar").submit();
          });
      }
  $(document).ready(function () {
      Anb.form.submit('#form-tramitedec', function (form) {
          Anb.form.cleanErrors(form);
          if (Anb.validate.run(form)) {
              console.log('Enviado!');
              Anb.loading.show()
              form.submit();
          }
      });
      
      Anb.form.submit('#form-tramitefac', function (form) {
          Anb.form.cleanErrors(form);
          if (Anb.validate.run(form)) {
              console.log('Enviado!');
              Anb.loading.show()
              form.submit();
          }
      });
      
      Anb.form.submit('#form-tramitetrans', function (form) {
          Anb.form.cleanErrors(form);
          if (Anb.validate.run(form)) {
              console.log('Enviado!');
              Anb.loading.show()
              form.submit();
          }
      });
      
      Anb.form.submit('#form-tramiteotro', function (form) {
          Anb.form.cleanErrors(form);
          if (Anb.validate.run(form)) {
              console.log('Enviado!');
              Anb.loading.show()
              form.submit();
          }
      });
      
      
      
      var DT = new Anb.datatable({
            filter: true,
            "iDisplayLength": -1,
            oLanguage: {"sSearch": '<i class="glyphicon glyphicon-search"></i> Buscar: '}
            
        });
        
        DT.$('.deletebtn').on('click', function() {           
            var id = this.getAttribute('data-item');
            Anb.confirm('¿Está seguro que desea eliminar el trámite de la ampliación de alcance?', function () {
                    $("#borrarid").val(id);
                    $("#opcion").val('BORRAR'); 
                    $("#form-alcance").submit();
            });
            
        });

  });
</script>