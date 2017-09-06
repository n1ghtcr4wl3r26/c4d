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
        TributosOmitidosForm gen = (TributosOmitidosForm)request.getAttribute("TributosOmitidosForm");
    %>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-tributos" action="tributos.do">
            <html:hidden property="codigo" styleId="codigo"/>
            <input type="hidden" name="opcion" id="opcion"/>
            <div class="form-group">
                <label class="col-sm-2 control-label">Fecha de Generación del Reporte:</label>
                <div class="col-sm-2">
                    ${TributosOmitidosForm.ffecha}
                </div>
                
            </div>
            <% 
            if(!(gen.getOpcion() == null) && (gen.getOpcion().equals("CONSULTAR"))) {
            %>
          
            <br></br>
            <div class="panel-title">
                <strong>LIQUIDACIÓN DEL ADEUDO TRIBUTARIO</strong>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th class="text-center">N&uacute;mero</th>
                        <th class="text-center">DUI</th>
                        <th class="text-center">Fecha Validación</th>
                        <th class="text-center">GA Bs.</th>
                        <th class="text-center">IVA Bs.</th>
                        <th class="text-center">ICE Bs.</th>
                        <th class="text-center">IEHD Bs.</th>
                        <th class="text-center">ICD Bs.</th>
                        <th class="text-center">Total a Pagar Bs.</th>
                    </tr>
                </thead>
                 
                <tbody>
                    <c:forEach items="${tributosOm}" var="esc">
                        <tr>
                            <td class="text-center">
                                ${esc.numero}
                            </td>
                            <td class="text-left">
                                ${esc.dui}
                            </td>
                            <td class="text-center">
                                ${esc.fechareg}
                            </td>
                            <td class="text-right">
                                ${esc.ga}
                            </td>
                            <td class="text-right">
                                ${esc.iva}
                            </td>
                            <td class="text-right">
                                ${esc.ice}
                            </td>
                            <td class="text-right">
                                ${esc.iehd}
                            </td>
                            <td class="text-right">
                                ${esc.icd}
                            </td>
                            <td class="text-right">
                                ${esc.total}
                            </td>   
                        </tr>
                    </c:forEach>
                    <tr>
                        <th class="text-left" colspan="8">
                            Total Deuda Tributaria Bs.
                        </th>
                        <th class="text-right">
                             ${tributosOmtot.total}
                        </th>
                    </tr>
                    <tr>
                        <th class="text-left" colspan="8">
                            Sanción por Omisión de Pago Código 235 Bs.
                        </th>
                        <th class="text-right">
                             ${tributosOmtot.sancionomision}
                        </th>
                    </tr>
                    <tr>
                        <th class="text-left" colspan="8">
                            Contravencion Aduanera relacionada con la DUI Cod. 167 Bs.
                        </th>
                        <th class="text-right">
                             ${tributosOmtot.contravdui}
                        </th>
                    </tr>
                    <tr>
                        <th class="text-left" colspan="8">
                            Contravenciones Aduaneras relacionadas con la Orden Cod. 167 Bs.
                        </th>
                        <th class="text-right">
                             ${tributosOmtot.contravorden}
                        </th>
                    </tr>
                    <tr>
                        <th class="text-left" colspan="8">
                            Sanción por Contrabando Contravencional 235 Bs.
                        </th>
                        <th class="text-right">
                             ${tributosOmtot.sancioncontrabando}
                        </th>
                    </tr>
                    <tr>
                        <th class="text-left" colspan="8">
                            Sanción por Defraudación Cod 169 Bs.
                        </th>
                        <th class="text-right">
                             ${tributosOmtot.sanciondefraudacion}
                        </th>
                    </tr>
                    <tr>
                        <th class="text-left" colspan="8">
                            Sanción por  Delito Cod 236 Bs.
                        </th>
                        <th class="text-right">
                             ${tributosOmtot.delito}
                        </th>
                    </tr>
                    <tr>
                        <th class="text-left" colspan="8">
                            <strong>
                                Total Adeudo Bs.
                            </strong>
                        </th>
                        <th class="text-right">
                            <strong>
                                ${tributosOmtot.totalfinal}
                            </strong>
                        </th>
                    </tr>                    
                </tbody>
            
            <%
              
            }
            %>
                
            </table>
        </html:form>
    </div>
</div>
<script>
  $(document).ready(function () {
  });

  
</script>