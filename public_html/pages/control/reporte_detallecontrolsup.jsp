<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="anb.bean.*"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>DETALLE Y ESTADO DE CONTROLES ASIGNADOS POR FISCALIZADOR</strong>
        </h4>
    </div>
    <% 
       ReporteControlForm gen = (ReporteControlForm)request.getAttribute("ReporteControlForm");
    %>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-reportecontrol" action="reportedetallecontrolsupidx.do">
            <html:hidden property="funcionario" styleId="funcionario"/>
            <html:hidden property="funcionarionombre" styleId="funcionarionombre"/>
            <html:hidden property="ffecini" styleId="ffecini"/>
            <html:hidden property="ffecfin" styleId="ffecfin"/>
            <html:hidden property="ftipotramite" styleId="ftipotramite"/>
            <html:hidden property="ftipotramitenombre" styleId="ftipotramitenombre"/>
            <html:hidden property="festado" styleId="festado"/>
            <html:hidden property="festadonombre" styleId="festadonombre"/>
            <% 
            if(!(gen.getOpcion() == null) && (gen.getOpcion().equals("CONSULTAR"))) {
            %>
            <strong>Usuario Fiscalizador:</strong>  ${ReporteControlForm.funcionarionombre}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <strong>Fecha desde:</strong>   ${ReporteControlForm.ffecini}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <strong>Fecha hasta:</strong>   ${ReporteControlForm.ffecfin}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <strong>Tipo de Trámite:</strong>  ${ReporteControlForm.ftipotramitenombre}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <strong>Estado del Control:</strong>   ${ReporteControlForm.festadonombre}  
            <br/>
            <br/>
            <table class="table table-striped table-hover" id="main-table" style="width:90%">
                <thead>
                    <tr>
                        <th class="text-center">Usuario Fiscalizador</th>
                        <th class="text-center">Tipo de Control</th>
                        <th class="text-center">Nro. de Orden</th>
                        <th class="text-center">Operador</th>
                        <th class="text-center">Fecha de Asignación</th>
                        <th class="text-center">Cantidad de<br/>DUI's, DUE's<br/>u<br/>Otros Documentos</th>
                        <th class="text-center">Fecha de Notificación</th>
                        <th class="text-center">Estado</th>
                    </tr>
                </thead>
                 
                <tbody>
                    <c:forEach items="${detalleControles}" var="esc">
                        <tr>
                            <td class="text-left">
                                ${esc.funcionario}
                            </td>
                            <td class="text-center">
                                ${esc.tipoControl}
                            </td>
                            <td class="text-center">
                                ${esc.numeroControl}
                            </td>
                            <td class="text-left">
                                ${esc.operador}
                            </td>
                            <td class="text-center">
                                ${esc.fechaAsignacion}
                            </td>
                            <td class="text-right">
                                ${esc.cantTramites}
                            </td>    
                            <td class="text-center">
                                ${esc.fechaNotificacion}
                            </td>
                            <td class="text-center">
                                ${esc.estado}
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
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