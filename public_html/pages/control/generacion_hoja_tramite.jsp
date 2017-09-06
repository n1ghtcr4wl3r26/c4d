<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="anb.bean.*"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>GENERACIÓN HOJA DE TRABAJO TRÁMITES</strong>
        </h4>
    </div>
    <% 
        GeneracionHojaForm gen = (GeneracionHojaForm)request.getAttribute("GeneracionHojaForm");
    %>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-hojatrabajo" action="generacionhoja.do">
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
                <label class="col-sm-2 control-label">N&uacute;mero de Documento:</label>
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
                <label class="col-sm-2 control-label">Tipo Documento de Identificaci&oacute;n:</label>
                <div class="col-sm-2">
                    ${infoControl.tipoDocIdentificacion}
                </div>
                <label class="col-sm-2 control-label">Estado:</label>
                <div class="col-sm-2">
                    ${infoControl.estado}
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">N&uacute;mero de Identificación:</label>
                <div class="col-sm-2">
                    ${infoControl.docIdentificacion}
                </div>
                <label class="col-sm-2 control-label">Nombre/Raz&oacute;n Social:</label>
                <div class="col-sm-2">
                    ${infoControl.nomIdentificacion}
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Direcci&oacute;n:</label>
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
            <% 
            if(!(gen.getOpcion() == null) && (gen.getOpcion().equals("CONSULTAR"))) {
                if(gen.getCantidad().equals("0")){
                %>
                <h4>
                    <strong>NO SE ENCONTRO NINGÚN TRÁMITE</strong>
                </h4>
                <%
                }else{
                %>
            <br></br>
            <br></br>
            <div class="panel-title imp">
                <strong>HOJA DE TRABAJO TRÁMITES - ${infoControl.codigoControl}</strong>
                <br/>
                <label style="color:#049dbf;">Solo los valores de las columnas con (M), pueden ser modificados para ser cargados al sistema.</label> 
            </div>
            <div class="table-responsive">
            <table class="table table-striped table-hover" id="main-table">
                <thead>
                    <tr>
                        <th class="text-center">N&uacute;mero</th>
                        <th class="text-center">Tipo de Documento</th>
                        <th class="text-center">Número de Documento</th>
                        <th class="text-center">Fecha</th>
                        <th class="text-center">Proveedor</th>
                        <th class="text-center">Mercancía</th>
                        <th class="text-center">(M) FOB USD</th>
                        <th class="text-center">(M) FLETE 5% USD</th>
                        <th class="text-center">(M) SEGURO 2% USD</th>
                        <th class="text-center">(M) OTROS GASTOS USD</th>
                        <th class="text-center">(M) CIF USD</th>
                        <th class="text-center">(M) CIF Bs.</th>
                        <th class="text-center">(M) CIF UFV's</th> 
                        <th class="text-center"><a href="javascript:Popilicito()"><img src="./img/iconoinfo.png" height="25px" width="21px"/></a><br/><br/>(M) Ilícito Determinado</th>
                        <th class="text-center">(M) Contravenci&oacute;n Aduanera Relacionada con la Orden UFV</th>   
                        <th class="text-center">Codigo</th> 
                        <th class="text-center">&nbsp;&nbsp;&nbsp;&nbsp;</th>                         
                    </tr>
                </thead>
                 
                <tbody>
                    <c:forEach items="${hojaTrabajoDui}" var="esc">
                        <tr>
                            <td class="text-center">
                                ${esc.sequencia}
                            </td>
                            <td class="text-left">
                                ${esc.tipotramite}
                            </td>
                            <td class="text-left">
                                ${esc.tramite}
                            </td>
                            <td class="text-center">
                                ${esc.fecha}
                            </td>
                            <td class="text-left">
                                ${esc.proveedor}
                            </td>
                            <td class="text-left">
                                ${esc.mercancia}
                            </td>                            
                            <td class="text-right">
                                ${esc.detfobusd}
                            </td>
                            <td class="text-right">
                                ${esc.detfleteusd}
                            </td>
                            <td class="text-right">
                                ${esc.detsegurousd}
                            </td>
                            <td class="text-right">
                                ${esc.detotrosusd}
                            </td>
                            <td class="text-right">
                                ${esc.detcifusd}
                            </td>  
                            <td class="text-right">
                                ${esc.detcifbs}
                            </td> 
                            <td class="text-right">
                                ${esc.detcifufv}
                            </td> 
                            <td class="text-left">
                                ${esc.ilicitodet}
                            </td>   
                            <td class="text-right">
                                ${esc.contravencionorden}
                            </td> 
                            <td class="text-left">
                                ${esc.codigo}
                            </td>   
                            <td class="text-left">
                                &nbsp;&nbsp;&nbsp;&nbsp;
                            </td>   
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            </div>
            <%
                }
            }
            %>
        </html:form>
    </div>
</div>
<script>
  $(document).ready(function () {
      Anb.form.submit('#form-hojatrabajo', function (form) {
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
            oLanguage: {"sSearch": '<i class="glyphicon glyphicon-search"></i> Buscar: ' }

        });
  });

      function consultar() {
          $("#opcion").val('ASIGNA');
      }
      
      function Popilicito() {
          var rnd = Math.floor((Math.random() * 100) + 1);
          window.open('pages/control/infoilicito.jsp?'+rnd, 'Informaci\363n Il\355cito', 'width=400,height=400,menubar=no,scrollbars=yes,toolbar=no,location=no,directories=no,resizable=no,top=0,left=0');
      }
</script>