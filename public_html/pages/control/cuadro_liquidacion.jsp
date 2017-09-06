<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="anb.bean.*"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>LIQUIDACIÓN DEL ADEUDO TRIBUTARIO</strong>
        </h4>
    </div>
    <% 
        CuadroLiquidacionForm gen = (CuadroLiquidacionForm)request.getAttribute("CuadroLiquidacionForm");
    %>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-liquidacion" action="liquidacion.do">
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
            %>
            <br></br>
            <br></br>
            <div class="panel-title imp">
                <strong>LIQUIDACIÓN DEL ADEUDO TRIBUTARIO</strong>
            </div>
            <div class="table-responsive">
            <table class="table table-striped table-hover" id="main-table">
                <thead>                   
                    <tr>
                        <th class="text-center">N&uacute;mero</th>
                        <th class="text-center">Item</th>
                        <th class="text-center">Subpartida Declarada</th>
                        <th class="text-center">Subpartida Determinada</th>
                        <th class="text-center">Declaraci&oacute;n</th>
                        <th class="text-center">Fecha Validaci&oacute;n</th>
                        <th class="text-center">Fecha Vencimiento</th>
                        <th class="text-center">Fecha de Calculo</th>
                        
                        <th class="text-center">FOB USD DECLARADO</th>
                        <th class="text-center">FLETE USD DECLARADO</th>
                        <th class="text-center">SEGURO USD DECLARADO</th>
                        <th class="text-center">OTROS USD DECLARADO</th>
                        <th class="text-center">VALOR CIF USD DECLARADO</th>
                        <th class="text-center">T/C DECLARADO</th>
                        <th class="text-center">VALOR CIF Bs DECLARADO</th>
                        <th class="text-center">GA DECLARADO</th>
                        <th class="text-center">IVA DECLARADO</th>
                        <th class="text-center">ICE DECLARADO</th>
                        <th class="text-center">IEHD DECLARADO</th>
                        <th class="text-center">ICD DECLARADO</th>
                        
                           
                        <th class="text-center">FOB USD DETERMINADO</th>
                        <th class="text-center">FLETE USD DETERMINADO</th>
                        <th class="text-center">SEGURO USD DETERMINADO</th>
                        <th class="text-center">OTROS USD DETERMINADO</th>
                        <th class="text-center">VALOR CIF USD DETERMINADO</th>
                        <th class="text-center">T/C DETERMINADO</th>
                        <th class="text-center">VALOR CIF Bs DETERMINADO</th>
                        <th class="text-center">GA DETERMINADO</th>
                        <th class="text-center">IVA DETERMINADO</th>
                        <th class="text-center">ICE DETERMINADO</th>
                        <th class="text-center">IEHD DETERMINADO</th>
                        <th class="text-center">ICD DETERMINADO</th>
                        
                          
                        <th class="text-center">TRIBUTO OMITIDO GA Bs</th>
                        <th class="text-center">TRIBUTO OMITIDO IVA Bs</th>
                        <th class="text-center">TRIBUTO OMITIDO ICE Bs</th>
                        <th class="text-center">TRIBUTO OMITIDO IEHD Bs</th>
                        <th class="text-center">TRIBUTO OMITIDO ICD Bs</th>
                        <th class="text-center">TRIBUTO OMITIDO TOTAL Bs</th>
                        
                        <th class="text-center">TRIBUTO OMITIDO GA UFV</th>
                        <th class="text-center">TRIBUTO OMITIDO IVA UFV</th>
                        <th class="text-center">TRIBUTO OMITIDO ICE UFV</th>
                        <th class="text-center">TRIBUTO OMITIDO IEHD UFV</th>
                        <th class="text-center">TRIBUTO OMITIDO ICD UFV</th>
                        <th class="text-center">TRIBUTO OMITIDO TOTAL UFV</th>
                        
                        <th class="text-center">UFV FECHA VENCIMIENTO</th>
                        <th class="text-center">D&iacute;as</th>
                        <th class="text-center">UFV FECHA DE CALCULO</th>  
                        
                        <th class="text-center">TRIBUTO OMITIDO + INTERES GA UFV</th>
                        <th class="text-center">TRIBUTO OMITIDO + INTERES IVA UFV</th>
                        <th class="text-center">TRIBUTO OMITIDO + INTERES ICE UFV</th>
                        <th class="text-center">TRIBUTO OMITIDO + INTERES IEHD UFV</th>
                        <th class="text-center">TRIBUTO OMITIDO + INTERES ICD UFV</th>
                        
                        
                        <th class="text-center">SANCIÓN POR OMISION DE PAGO UFV</th>
                        <th class="text-center">ADEUDO TOTAL UFV</th>
                        <th class="text-center">ADEUDO TOTAL BS</th>
                        
                    </tr>
                </thead>
                 
                <tbody>
                    <c:forEach items="${cuadroLiquidacion}" var="esc">
                        <tr>
                            <td class="text-center">
                                ${esc.sequencia}
                            </td>
                            <td class="text-center">
                                ${esc.item}
                            </td>
                            <td class="text-center">
                                ${esc.subpartidadec}
                            </td>
                            <td class="text-center">
                                ${esc.subpartidadet}
                            </td>
                            <td class="text-center">
                                ${esc.gestion}/${esc.aduana}/${esc.serial}-${esc.numero}
                            </td>
                            <td class="text-center">
                                ${esc.fechaval}
                            </td>
                            <td class="text-center">
                                ${esc.fechavcto}
                            </td>
                            <td class="text-center">
                                ${esc.fechacalculo}
                            </td>
                           
                            <td class="text-right">
                                ${esc.decfobusd}
                            </td>
                            <td class="text-right">
                                ${esc.decfleteusd}
                            </td>
                            <td class="text-right">
                                ${esc.decsegurousd}
                            </td>
                            <td class="text-right">
                                ${esc.decotrosusd}
                            </td>
                            <td class="text-right">
                                ${esc.deccifusd}
                            </td>
                            <td class="text-right">
                                ${esc.dectc}
                            </td>
                            <td class="text-right">
                                ${esc.deccifbs}
                            </td>
                            <td class="text-right">
                                ${esc.decga}
                            </td>
                            <td class="text-right">
                                ${esc.deciva}
                            </td>
                            <td class="text-right">
                                ${esc.decice}
                            </td>
                            <td class="text-right">
                                ${esc.deciehd}
                            </td>
                            <td class="text-right">
                                ${esc.decicd}
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
                                ${esc.dettc}
                            </td>
                            <td class="text-right">
                                ${esc.detcifbs}
                            </td>
                            <td class="text-right">
                                ${esc.detga}
                            </td>
                            <td class="text-right">
                                ${esc.detiva}
                            </td>
                            <td class="text-right">
                                ${esc.detice}
                            </td>
                            <td class="text-right">
                                ${esc.detiehd}
                            </td>
                            <td class="text-right">
                                ${esc.deticd}
                            </td>
                             
                             
                            <td class="text-right">
                                ${esc.toga}
                            </td>
                            <td class="text-right">
                                ${esc.toiva}
                            </td>
                            <td class="text-right">
                                ${esc.toice}
                            </td>
                            <td class="text-right">
                                ${esc.toiehd}
                            </td>
                            <td class="text-right">
                                ${esc.toicd}
                            </td>
                            <td class="text-right">
                                ${esc.tototal}
                            </td>
                            
                            <td class="text-right">
                                ${esc.toufvga}
                            </td>
                            <td class="text-right">
                                ${esc.toufviva}
                            </td>
                            <td class="text-right">
                                ${esc.toufvice}
                            </td>
                            <td class="text-right">
                                ${esc.toufviehd}
                            </td>
                            <td class="text-right">
                                ${esc.toufvicd}
                            </td>
                            <td class="text-right">
                                ${esc.toufvtotal}
                            </td>
                            
                            
                            <td class="text-right">
                                ${esc.ufvvenc}
                            </td>
                            <td class="text-right">
                                ${esc.dias}
                            </td>
                            <td class="text-right">
                                ${esc.ufvhoy}
                            </td>
                            <td class="text-right">
                                ${esc.dtufvga}
                            </td>
                            <td class="text-right">
                                ${esc.dtufviva}
                            </td>
                            <td class="text-right">
                                ${esc.dtufvice}
                            </td>
                            <td class="text-right">
                                ${esc.dtufviehd}
                            </td>
                            <td class="text-right">
                                ${esc.dtufvicd}
                            </td>
                           
                            <td class="text-right">
                                ${esc.toufvtotal}
                            </td>
                            <td class="text-right">
                                ${esc.adeudo_totalufv}
                            </td>
                            <td class="text-right">
                                ${esc.adeudo_totalbs}
                            </td>
                            
                            
                            
                                                        
                             
                             
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            </div>
            <%
              
            }
            %>
            
            
        </html:form>
    </div>
</div>
<script>
  $(document).ready(function () {
      Anb.form.submit('#form-liquidacion', function (form) {
          Anb.form.cleanErrors(form);
          if ($("#opcion").val() =='MOSTRAR')
                form.submit();
            else
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
            $("#mostrarid").val(id);
            $("#opcion").val('MOSTRAR'); 
            $("#form-liquidacion").submit();
      });
      
  });

  
</script>