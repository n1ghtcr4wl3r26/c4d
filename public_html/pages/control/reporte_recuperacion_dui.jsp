<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="anb.bean.*"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>REPORTE DE RECUPERACI&Oacute;N DE TRIBUTOS DE LA ORDEN POR DUI</strong>
        </h4>
    </div>
    <% 
        ReporteForm gen = (ReporteForm)request.getAttribute("ReporteForm");
    %>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-reporte_recuperacion_dui" action="reporte_recuperacion_duiidx.do">
            <html:hidden property="codigo" styleId="codigo"/>
            <input type="hidden" name="opcion" id="opcion"/>
            <strong>Gerencia:</strong>
            ${ReporteForm.fgerencianombre}
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <strong>Fecha desde:</strong>
            ${ReporteForm.ffecini}
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <strong>Fecha hasta:</strong>
            ${ReporteForm.ffecfin}
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <strong>Tipo de Tr&aacute;mite:</strong>
            ${ReporteForm.ftipotramitenombre}
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <strong>N&uacute;mero de NIT:</strong>
            ${ReporteForm.fnitnombre}
            <% 
            if(!(gen.getOpcion() == null) && (gen.getOpcion().equals("CONSULTAR"))) {
            %>
            <br></br>
            <div class="panel-title imp">
                <strong>REPORTE DE RECUPERACI&Oacute;N DE TRIBUTOS DE LA ORDEN POR DUI</strong>
            </div>
            <div class="table-responsive">
                <table class="table table-striped table-hover" id="main-table">
                    <thead>
                        <tr>
                           <th class="text-center">N&Uacute;MERO</th>
                            <th class="text-center">GESTI&Oacute;N</th>
                            <th class="text-center">TIPO DE CONTROL</th>
                            <th class="text-center">GERENCIA</th>
                            <th class="text-center">NUMERO CORRELATIVO POR GESTI&Oacute;N</th>
                            <th class="text-center">N&Uacute;MERO DE ORDEN</th>
                            <th class="text-center">FECHA DE LA ORDEN</th>
                            <th class="text-center">ORIGEN DE LA ORDEN</th>
                            <th class="text-center">N&ordm; DE NIT / CI IMPORTADOR</th>
                            <th class="text-center">NOMBRE IMPORTADOR</th>
                            <th class="text-center">FISCALIZADOR</th>
                            <th class="text-center">NUEVO FISCALIZADOR</th>
                            <th class="text-center">SUPERVISOR</th>
                            <th class="text-center">NUEVO SUPERVISOR</th>
                            <th class="text-center">FECHA DE NOTIFICACI&Oacute;N ORDEN DE CONTROL</th>
                            <th class="text-center">OBSERVACI&Oacute;N DE LA NOTIFICACI&Oacute;N</th>
                            <th class="text-center">TIPO NOTIFICACI&Oacute;N</th>
                            <th class="text-center">USUARIO QUE REALIZ&Oacute; LA NOTIFICACI&Oacute;N</th>
                            <th class="text-center">RESULTADOS DEL CONTROL - N&Uacute;MERO DE INFORME T&Eacute;CNICO</th>
                            <th class="text-center">RESULTADOS DEL CONTROL - FECHA DE INFORME T&Eacute;CNICO</th>
                            <th class="text-center">RESULTADOS DEL CONTROL - GERENCIA - UNIDAD LEGAL</th>
                            <th class="text-center">RESULTADOS DEL CONTROL - TIPO DE DOCUMENTO DE CONCLUSI&Oacute;N</th>
                            <th class="text-center">RESULTADOS DEL CONTROL - N&Uacute;MERO DE DOCUMENTO DE CONCLUSI&Oacute;N</th>
                            <th class="text-center">RESULTADOS DEL CONTROL - FECHA DE DOCUMENTO DE CONCLUSI&Oacute;N</th>
                            <th class="text-center">RESULTADOS DEL CONTROL - USUARIO QUE REGISTR&Oacute; LOS RESULTADOS</th>
                            <th class="text-center">RESULTADOS DEL CONTROL - FECHA DE NOTIFICACI&Oacute;N</th>
                            <th class="text-center">RESULTADOS DEL CONTROL - TIPO DE NOTIFICACI&Oacute;N</th>
                            <th class="text-center">RESULTADOS DEL CONTROL - USUARIO QUE REGISTR&Oacute; LA NOTIFICACI&Oacute;N</th>
                            <th class="text-center">RESULTADOS DEL CONTROL - FECHA COMUNICACI&Oacute;N INTERNA DE
                                                    REMISI&Oacute;N</th>
                            <th class="text-center">RESULTADOS DEL CONTROL - N&Uacute;MERO DE COMUNICACI&Oacute;N
                                                    INTERNA DE REMISI&Oacute;N</th>
                            <th class="text-center">FINALIZACI&Oacute;N DEL CONTROL - USUARIO QUE REALIZ&Oacute; LA
                                                    REMISI&Oacute;N A LA UNIDAD LEGAL</th>
                            <th class="text-center">FINALIZACI&Oacute;N DEL CONTROL - FECHA DE FINALIZACI&Oacute;N DEL
                                                    CONTROL</th>
                            <th class="text-center">FINALIZACI&Oacute;N DEL CONTROL - USUARIO QUE REGISTR&Oacute; LA
                                                    FINALIZACI&Oacute;N</th>
                            <th class="text-center">ESTADO DEL CONTROL</th>
                            <th class="text-center">TIPO DE IL&Iacute;CITO - OMISI&Oacute;N DE PAGO</th>
                            <th class="text-center">TIPO DE IL&Iacute;CITO - CONTRAVENCI&Oacute;N ADUANERA</th>
                            <th class="text-center">TIPO DE IL&Iacute;CITO - CONTRABANDO CONTRAVENCIONAL</th>
                            <th class="text-center">TIPO DE IL&Iacute;CITO - CONTRABANDO DELITO</th>
                            <th class="text-center">TIPO DE IL&Iacute;CITO - DEFRAUDACI&Oacute;N ADUANERA</th>
                            <th class="text-center">TIPO DE IL&Iacute;CITO - OTROS</th>
                            <th class="text-center">FECHA CONCLUSI&Oacute;N ESTIMADA</th>
                            <th class="text-center">TOTAL RECUPERADO - TRIBUTO PAGADO GA BS</th>
                            <th class="text-center">TOTAL RECUPERADO - TRIBUTO PAGADO IVA BS</th>
                            <th class="text-center">TOTAL RECUPERADO - TRIBUTO PAGADO ICE BS</th>
                            <th class="text-center">TOTAL RECUPERADO - TRIBUTO PAGADO IEHD BS</th>
                            <th class="text-center">TOTAL RECUPERADO - ICD PAGADO BS</th>
                            <th class="text-center">TOTAL RECUPERADO - TOTAL TRIBUTO PAGADO BS</th>
                            
                            <th class="text-center">TOTAL RECUPERADO - SANCI&Oacute;N OMISI&Oacute;N BS</th>
                            <th class="text-center">TOTAL RECUPERADO - MULTA POR CONTRAVENCI&Oacute;N ADUANERA RELACIONADA A LA DECLARACI&Oacute;N BS</th>
                            <th class="text-center">TOTAL RECUPERADO - MULTA POR CONTRAVENCI&Oacute;N ADUANERA RELACIONADA A LA ORDEN BS</th>
                            <th class="text-center">TOTAL RECUPERADO - MULTA CONTRABANDO CONTRAVENCIONAL</th>
                            <th class="text-center">TOTAL RECUPERADO - MULTA CONTRABANDO DELITO</th>
                            <th class="text-center">TOTAL RECUPERADO - MULTA POR DEFRAUDACI&Oacute;N</th>
                            <th class="text-center">TOTAL RECUPERADO - TOTAL RECUPERADO</th>
                            <th class="text-center">FACILIDADES DE PAGO - CUOTA INICIAL BS</th>
                            <th class="text-center">FACILIDADES DE PAGO - GARANT&Iacute;A EN EFECTIVO BS</th>
                            <th class="text-center" width="180px">FACILIDADES DE PAGO - SALDO POR COBRAR SUJETO A FACILIDADES DE PAGO
                                                    EN BS</th>
                            <th class="text-center">FACILIDADES DE PAGO - USUARIO QUE REGISTR&Oacute; LOS PAGOS</th>
                        </tr>
                    </thead>
                     
                    <tbody>
                        <c:forEach items="${reporte_recuperacion_dui}" var="rep">
                            <tr>
                                <td class="text-center">
                                    ${rep.secuencia}
                                </td>
                                <td class="text-center">
                                    ${rep.orden_gestion}
                                </td>
                                <td class="text-center">
                                    ${rep.orden_tipo_control}
                                </td>
                                <td class="text-center">
                                    ${rep.orden_gerencia}
                                </td>
                                <td class="text-center">
                                    ${rep.orden_numero}
                                </td>
                                <td class="text-center">
                                    ${rep.orden_codigo}
                                </td>
                                <td class="text-center">
                                    ${rep.orden_fecha}
                                </td>
                                <td class="text-center">
                                    ${rep.orden_origen}
                                </td>
                                <td class="text-center">
                                    ${rep.operador_numero_doc}
                                </td>
                                <td class="text-center">
                                    ${rep.operador_nombre}
                                </td>
                                <td class="text-center">
                                    ${rep.fiscalizador_asignado}
                                </td>
                                <td class="text-center">
                                    ${rep.fiscalizador_nuevo}
                                </td>
                                <td class="text-center">
                                    ${rep.supervisor_asignado}
                                </td>
                                <td class="text-center">
                                    ${rep.supervisor_nuevo}
                                </td>
                                <td class="text-center">
                                    ${rep.notificacion_fecha}
                                </td>
                                <td class="text-center">
                                    ${rep.notificacion_observacion}
                                </td>
                                <td class="text-center">
                                    ${rep.notificacion_tipo}
                                </td>
                                <td class="text-center">
                                    ${rep.notificacion_usuario}
                                </td>
                                <td class="text-center">
                                    ${rep.res_informe_numero}
                                </td>
                                <td class="text-center">
                                    ${rep.res_informe_fecha}
                                </td>
                                <td class="text-center">
                                    ${rep.res_gerencia_ulegal}
                                </td>
                                <td class="text-center">
                                    ${rep.res_documento_tipo}
                                </td>
                                <td class="text-center">
                                    ${rep.res_documento_numero}
                                </td>
                                <td class="text-center">
                                    ${rep.res_documento_fecha}
                                </td>
                                <td class="text-center">
                                    ${rep.res_documento_usuario}
                                </td>
                                <td class="text-center">
                                    ${rep.res_notificacion_fecha}
                                </td>
                                <td class="text-center">
                                    ${rep.res_notificacion_tipo}
                                </td>
                                <td class="text-center">
                                    ${rep.res_notificacion_usuario}
                                </td>
                                <td class="text-center">
                                    ${rep.res_ci_remision_fecha}
                                </td>
                                <td class="text-center">
                                    ${rep.res_ci_remision_numero}
                                </td>
                                <td class="text-center">
                                    ${rep.res_ci_remision_usuario}
                                </td>
                                <td class="text-center">
                                    ${rep.res_finalizacion_fecha}
                                </td>
                                <td class="text-center">
                                    ${rep.res_finalizacion_usuario}
                                </td>
                                <td class="text-center">
                                    ${rep.orden_estado}
                                </td>
                                <td class="text-center">
                                    ${rep.ilicito_omision_pago}
                                </td>
                                <td class="text-center">
                                    ${rep.ilicito_contravencion_aduanera}
                                </td>
                                <td class="text-center">
                                    ${rep.ilicito_contrabando_contrav}
                                </td>
                                <td class="text-center">
                                    ${rep.ilicito_contrabando_delito}
                                </td>
                                <td class="text-center">
                                    ${rep.ilicito_defraudacion}
                                </td>
                                <td class="text-center">
                                    ${rep.ilicito_otros}
                                </td>
                                <td class="text-center">
                                    ${rep.orden_conclusion_fecha_est}
                                </td>
                                <td class="text-right">
                                    ${rep.recuperado_trib_ga}
                                </td>
                                <td class="text-right">
                                    ${rep.recuperado_trib_iva}
                                </td>
                                <td class="text-right">
                                    ${rep.recuperado_trib_ice}
                                </td>
                                <td class="text-right">
                                    ${rep.recuperado_trib_iehd}
                                </td>
                                <td class="text-right">
                                    ${rep.recuperado_trib_icd}
                                </td>
                                <td class="text-right">
                                    ${rep.recuperado_trib_total}
                                </td>
                                <td class="text-right">
                                    ${rep.recuperado_sancion}
                                </td>
                                <td class="text-right">
                                    ${rep.recuperado_multa_contrav}
                                </td>
                                <td class="text-right">
                                    ${rep.recuperado_multa_contravorden}
                                </td>
                                <td class="text-right">
                                    ${rep.recuperado_multa_contrab}
                                </td>
                                <td class="text-right">
                                    ${rep.recuperado_multa_contrab_delito}
                                </td>
                                <td class="text-right">
                                    ${rep.recuperado_multa_defraudacion}
                                </td>
                                <td class="text-right">
                                    ${rep.recuperado_total_recuperado}
                                </td>
                                <td class="text-right">
                                    ${rep.facilidades_cuota_inicial}
                                </td>
                                <td class="text-right">
                                    ${rep.facilidades_garantia}
                                </td>
                                <td class="text-right">
                                    ${rep.facilidades_saldo}
                                </td>
                                <td class="text-center">
                                    ${rep.facilidades_usuario}
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
      Anb.form.submit('#form-reporte_recuperacion_dui', function (form) {
          Anb.form.cleanErrors(form);
          if (Anb.validate.run(form)) {
              console.log('Enviado!');
              Anb.loading.show()
              form.submit();
          }
      });
      var DT = new Anb.datatable( {
          filter : true, "iDisplayLength" :  - 1, oLanguage :  {
              "sSearch" : '<i class="glyphicon glyphicon-search"></i> Buscar: '
          }

      });
  });
</script>