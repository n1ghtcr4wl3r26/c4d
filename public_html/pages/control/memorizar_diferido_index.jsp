<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="anb.bean.*"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>MEMORIZACI&Oacute;N DE CONTROL DIFERIDO</strong>
        </h4>
    </div>
    <% 
        MemorizacionControlForm alc = (MemorizacionControlForm)request.getAttribute("MemorizacionControlForm");
    %>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-alcance" action="memorizaciondiferidoidx.do">
            <html:hidden property="opcion" value="CONSULTA1"/>
            <legend>Por Ficha Informativa</legend>
            <div class="form-group">
                <label class="col-sm-3 control-label">Fecha de Registro Ficha Informativa Desde:</label>
                <div class="col-sm-3">
                    <html:text property="fd1FecIni" maxlength="10" styleClass="form-control required datepicker"
                               size="50"/>
                </div>
                <label class="col-sm-3 control-label">Fecha de Registro Ficha Informativa Hasta:</label>
                <div class="col-sm-3">
                    <html:text property="fd1FecFin" maxlength="10" styleClass="form-control required datepicker"
                               size="50"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">Aduana:</label>
                <div class="col-sm-3">
                    <html:select property="fd1Aduana" styleClass="form-control required">
                        <option value="-">Seleccione...</option>
                        <html:optionsCollection name="aduanas" value="codigo" label="descripcion"/>
                    </html:select>
                </div>
            </div>
            <div class="btn-container">
                <button type="submit" id="boton" value="Consultar" onclick="consultar()" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Consultar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
            </div>
            <div class="form-group">
                <label class="label-message-required">* Campos Obligatorios</label>
            </div>
        </html:form>
        <br/>
        <br/>
        <html:form styleId="form-alcance3" action="memorizaciondiferidoidx.do">
            <html:hidden property="opcion" value="CONSULTA3"/>
            <legend>Por Declaraci&oacute;n</legend>
            <div class="form-group">
                <label class="col-sm-3 control-label">Gesti&oacute;n:</label>
                <div class="col-sm-3">
                    <html:text property="fd3Gestion" maxlength="10" styleClass="form-control required" size="50"/>
                </div>
                <label class="col-sm-3 control-label">Aduana:</label>
                <div class="col-sm-3">
                    <html:select property="fd3Aduana" styleClass="form-control required">
                        <option value="-">Seleccione...</option>
                        <html:optionsCollection name="aduanas" value="codigo" label="descripcion"/>
                    </html:select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label">N&uacute;mero de C:</label>
                <div class="col-sm-3">
                    <html:text property="fd3Numero" maxlength="10" styleClass="form-control required" size="50"/>
                </div>
            </div>
            <div class="btn-container">
                <button type="submit" id="boton3" value="Consultar" onclick="consultar()" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Consultar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
            </div>
            <div class="form-group">
                <label class="label-message-required">* Campos Obligatorios</label>
            </div>
        </html:form>
        <br></br>
        <% 
            if(!(alc.getOpcion() == null) && (alc.getOpcion().equals("CONSULTA1") || alc.getOpcion().equals("CONSULTA2") || alc.getOpcion().equals("CONSULTA3"))) {
                if(alc.getCantidad_dec() == 0){
                %>
        <h4>
            <strong>NO SE ENCONTRO NINGUNA DECLARACI&Oacute;N CON LOS PARAMETROS INTRODUCIDOS</strong>
        </h4>
        <%
                } else {                    
                    %>
        <br></br>
        <br></br>
        <div class="panel-title imp">
            <strong>RESULTADOS DE LA B&Uacute;SQUEDA DE DECLARACIONES</strong>
        </div>
        <html:form styleId="form-resultados" action="memorizaciondiferidoidx.do">
            <input type="hidden" name="fropcion" id="fropcion"/>
            <input type="hidden" name="frcodigo" id="frcodigo"/>
            <div class="table-responsive">
            <table class="table table-striped table-hover" id="main-table">
                <thead>
                    <tr>
                        <th class="text-center">&nbsp;</th>
                        <th class="text-center">&nbsp;</th>
                        <th class="text-center">N&uacute;mero</th>
                        <th class="text-center">Declaraci&oacute;n</th>
                        <th class="text-center">Ítems</th>
                        <th class="text-center">Patrón</th>
                        <th class="text-center">Ficha Informativa</th>                        
                        <th class="text-center">Fecha Registro</th>
                        <th class="text-center">Fecha Levante</th>
                        <th class="text-center">Fecha Pase de Salida</th>
                        <th class="text-center">Canal</th>
                        <th class="text-center">Operador</th>
                        <th class="text-center">Declarante</th>
                        <th class="text-center">Origen</th>
                        <th class="text-center">Estado</th>
                        <th class="text-center">&nbsp;</th>
                        <th class="text-center">&nbsp;</th>
                        <th class="text-center">&nbsp;</th>
                        <th class="text-center">&nbsp;</th>
                        <th class="text-center">&nbsp;</th>
                        <th class="text-center">&nbsp;</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${declaraciones}" var="esc">
                        <tr>
                            <td>
                                <c:if test="${fn:substring(esc.estado,0,3) == 'SIN' }">
                                    <button class="iniciarbtn btn btn-info btn-sm " 
                                                        type="button"
                                                        title="Iniciar Control"
                                                        data-item="${esc.gestion}${esc.aduana}${esc.numero}"
                                                        data-id="${esc.gestion}${esc.aduana}${esc.numero}">
                                                    <i class="fa fa-close"></i> Iniciar Control
                                    </button>
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${fn:substring(esc.estado,0,3) == 'SIN' }">
                                    <button class="desestimarbtn btn btn-info btn-sm " 
                                                        type="button"
                                                        title="Desestimar"
                                                        data-item="${esc.gestion}${esc.aduana}${esc.numero}"
                                                        data-id="${esc.gestion}${esc.aduana}${esc.numero}">
                                                    <i class="fa fa-close"></i> &nbsp;&nbsp;Desestimar&nbsp;&nbsp;
                                    </button>
                                </c:if>
                            </td>
                            <td>
                                ${esc.sequencia}
                            </td>
                            <td>
                                <a onclick="window.open('http://anbsw07.aduana.gob.bo:7601/mira/repduiform.jsp?gestion=${esc.gestion}&amp;aduana=${esc.aduana}&amp;registro=${esc.numero}&amp;vdec=&amp;vop=&amp;vusu=&amp;bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0')"
                                   href='javascript:void(0)'>
                                    ${esc.tramite}</a>
                            </td>
                            <td class="text-center">
                                ${esc.items}
                            </td>
                            <td class="text-center">
                                ${esc.patron}
                            </td>
                            <td class="text-center">
                                ${esc.ficha}
                            </td>
                            <td class="text-center">
                                ${esc.fechaRegistro}
                            </td>
                            <td class="text-center">
                                ${esc.fechaLevante}
                            </td>
                            <td class="text-center">
                                ${esc.fechaPase}
                            </td>
                            <td class="text-center">
                                ${esc.canal}
                            </td>
                            <td class="text-left">
                                ${esc.operador}:${esc.operadorNombre}
                            </td>
                            <td class="text-left">
                                ${esc.declarante}:${esc.declaranteNombre}
                            </td>
                            <td class="text-center">
                                ${esc.origen}
                            </td>
                            <td class="text-left">
                                ${esc.estado}
                            </td>
                            <td class="text-center">
                                <a onclick="window.open('http://anbsw07.aduana.gob.bo:7601/mira/repduiform.jsp?gestion=${esc.gestion}&amp;aduana=${esc.aduana}&amp;registro=${esc.numero}&amp;vdec=&amp;vop=&amp;vusu=&amp;bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0')"
                                   href='javascript:void(0)'>DUI</a>
                            </td>
                            <td class="text-center">
                                <a onclick="window.open('http://anbsw07.aduana.gob.bo:7601/mira/DUI_docadi.jsp?gestion=${esc.gestion}&amp;aduana=${esc.aduana}&amp;registro=${esc.numero}&amp;vdec=&amp;vop=&amp;vusu=&amp;bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0')"
                                   href='javascript:void(0)'>Doc. Adicionales</a>
                            </td>
                            <td class="text-center">
                                <a onclick="window.open('http://anbsw07.aduana.gob.bo:7601/mira/DUI_notaval.jsp?gestion=${esc.gestion}&amp;aduana=${esc.aduana}&amp;registro=${esc.numero}&amp;vdec=&amp;vop=&amp;vusu=&amp;bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0')"
                                   href='javascript:void(0)'>Nota de Valor</a>
                            </td>
                            <td class="text-center">
                                <a onclick="window.open('http://anbsw07.aduana.gob.bo:7601/mira/DUI_infadi.jsp?gestion=${esc.gestion}&amp;aduana=${esc.aduana}&amp;registro=${esc.numero}&amp;vdec=&amp;vop=&amp;vusu=&amp;bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0')"
                                   href='javascript:void(0)'>Inf. Adicional</a>
                            </td>
                            <td class="text-center">
                                <a onclick="window.open('http://anbsw07.aduana.gob.bo:7601/mira/DUI_frv.jsp?gestion=${esc.gestion}&amp;aduana=${esc.aduana}&amp;registro=${esc.numero}&amp;vdec=&amp;vop=&amp;vusu=&amp;bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0')"
                                   href='javascript:void(0)'>FRV</a>
                            </td>
                            <td class="text-center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            </div>
        </html:form>
        <%             
                }
            }
            %>
    </div>
</div>
<script>
    $(window).load(function() {
          $(".buttons-excel").hide();
    });
  $(document).ready(function () {
      

      var DT = new Anb.datatable( {
          filter : true, "iDisplayLength" :  - 1, oLanguage :  {
              "sSearch" : '<i class="glyphicon glyphicon-search"></i> Buscar: '
          }

      });

      DT.$('.iniciarbtn').on('click', function () {
          var id = this.getAttribute('data-item');
          Anb.confirm('¿Está seguro que desea iniciar control diferido con el trámite seleccionado?', function () {
              $("#frcodigo").val(id);
              $("#fropcion").val('INICIAR');
              $("#form-resultados").submit();
          });

      });
      
      DT.$('.desestimarbtn').on('click', function () {
          var id = this.getAttribute('data-item');
          Anb.confirm('¿Está seguro que desea desestimar el control diferido del trámite seleccionado?', function () {
              $("#frcodigo").val(id);
              $("#fropcion").val('DESESTIMAR');
              $("#form-resultados").submit();
          });

      });

      Anb.form.submit('#form-alcance', function (form) {
          Anb.form.cleanErrors(form);
          
          if (Anb.validate.run(form)) {
              console.log('Enviado!');
              Anb.loading.show()
              form.submit();
          }
      });
      $("#boton").removeAttr("disabled");

      Anb.form.submit('#form-alcance3', function (form) {
          Anb.form.cleanErrors(form);
          
          if (Anb.validate.run(form)) {
              console.log('Enviado!');
              Anb.loading.show()
              form.submit();
          }
      });
      $("#boton3").removeAttr("disabled");

      function diasentrefechas(fechadesde, fechahasta) {
          var dia1 = fechadesde.substring(0, 2);
          var mes1 = fechadesde.substring(3, 5);
          var anio1 = fechadesde.substring(6, 10);
          var dia2 = fechahasta.substring(0, 2);
          var mes2 = fechahasta.substring(3, 5);
          var anio2 = fechahasta.substring(6, 10);
          var fecha1 = new Date(anio1, mes1 - 1, dia1);
          var fecha2 = new Date(anio2, mes2 - 1, dia2);
          var dias = Math.floor((fecha2 - fecha1) / (1000 * 60 * 60 * 24));
          return dias;
      };
  });

  

  function consultar() {
      $("#opcion").val('CONSULTAR');
  }
</script>