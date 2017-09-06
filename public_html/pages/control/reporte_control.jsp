<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="anb.bean.*"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>CONTROLES REGISTRADOS</strong>
        </h4>
    </div>
    <% 
       ReporteControlForm gen = (ReporteControlForm)request.getAttribute("ReporteControlForm");
    %>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-reportecontrol" action="reportecontrolidx.do">
        <html:hidden property="fcontrol" styleId="fcontrol"/>
        <html:hidden property="fcontrolnombre" styleId="fcontrol"/>
        <html:hidden property="ffecini" styleId="ffecini"/>
        <html:hidden property="ffecfin" styleId="ffecfin"/>
            
            <% 
            if(!(gen.getOpcion() == null) && (gen.getOpcion().equals("CONSULTAR"))) {
            %>
            <strong>Tipo Control:</strong>  ${ReporteControlForm.fcontrolnombre}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <strong>Fecha desde:</strong>   ${ReporteControlForm.ffecini}  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <strong>Fecha hasta:</strong>   ${ReporteControlForm.ffecfin}  
            <br/>
            <br/>
            <div class="panel-title">
                <strong>CONTROLES REGISTRADOS</strong>
            </div>
            <table class="table table-striped table-hover" id="main-table">
                <thead>
                    <tr>
                        <th class="text-center">Nro.</th>
                        <th class="text-center">Tipo de Control</th>
                        <th class="text-center">Gerencia</th>
                        <th class="text-center">Código Memorizado</th>
                        <th class="text-center">Fecha Memorización</th>
                        <th class="text-center">Código Registrado</th>
                        <th class="text-center">Fecha de Registro</th>
                        <th class="text-center">Documento Operador</th>
                        <th class="text-center">Nombre Operador</th>
                        <th class="text-center">Estado Control</th>
                        <th class="text-center">Usuario Operación</th>
                    </tr>
                </thead>
                 
                <tbody>
                    <c:forEach items="${reporteControl}" var="esc">
                        <tr>
                            <td class="text-center">
                                ${esc.secuencia}
                            </td>
                            <td class="text-center">
                                ${esc.tipo}
                            </td>
                            <td class="text-center">
                                ${esc.gerencia}
                            </td>
                            <td class="text-center">
                                ${esc.memorizado}
                            </td>
                            <td class="text-center">
                                ${esc.fec_mem}
                            </td>
                            <td class="text-center">
                                ${esc.codigo}
                            </td>
                            <td class="text-center">
                                ${esc.fec_reg}
                            </td>
                            <td class="text-center">
                                ${esc.doc_operador}
                            </td>
                           
                            <td class="text-left">
                                ${esc.nom_operador}
                            </td>
                            <td class="text-center">
                                ${esc.estado}
                            </td>
                            <td class="text-center">
                                ${esc.usuario}
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