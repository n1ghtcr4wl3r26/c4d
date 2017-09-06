<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="anb.entidades.*, anb.general.*"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>CONCLUSIÓN DEL CONTROL</strong>
        </h4>
    </div>
    <div class="modal-body form-horizontal">
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
                String panel1 = "0";
                String panel2 = "0";
                String panel3 = "0";
                String panel4 = "0";
                String panel5 = "0";
                Boolean fbotones = false;
                Boolean fbotones_concluir = false;
                Boolean flegal = false;
                Boolean ffisca = false;
                InfoControl inf = (InfoControl)request.getAttribute("infoControl");
                if(Util.mostrar_botones(inf.getCodigo(),inf.getUsuario(),"19")){
                    fbotones = false;
                }else{
                    //fbotones = "style='display:none'";  
                    fbotones = true;            
                }
                
                if(Util.mostrar_botones_concluir(inf.getCodigo(),inf.getUsuario(),"19")){
                    fbotones_concluir = false;
                }else{
                    //fbotones = "style='display:none'";  
                    fbotones_concluir = true;            
                }
                
                if(Util.llenar_valores(inf.getCodigo(),inf.getUsuario(),"19","FISCA")){
                    //ffisca = "disabled='false'";
                    ffisca = false;
                }else{
                    //ffisca = "disabled='true'";    
                    ffisca = true; 
                }
                
                if(Util.llenar_valores(inf.getCodigo(),inf.getUsuario(),"19","LEGAL")){
                    //flegal = "disabled='false'";
                    flegal = false;
                }else{
                    //flegal = "disabled='true'";  
                    flegal = true; 
                }
                
                
                
                
                %>
         
        <c:choose>
            <c:when test="${panelConclusion.panel1 == '1'}">
                <%panel1 = "style='display: block'";%>
            </c:when>
            <c:otherwise>
                <%panel1 = "style='display: none'";%>
            </c:otherwise>
        </c:choose>
         
        <c:choose>
            <c:when test="${panelConclusion.panel2 == '1'}">
                <%panel2 = "style='display: block'";%>
            </c:when>
            <c:otherwise>
                <%panel2 = "style='display: none'";%>
            </c:otherwise>
        </c:choose>
         
        <c:choose>
            <c:when test="${panelConclusion.panel3 == '1'}">
                <%panel3 = "style='display: block'";%>
            </c:when>
            <c:otherwise>
                <%panel3 = "style='display: none'";%>
            </c:otherwise>
        </c:choose>
         
        <c:choose>
            <c:when test="${panelConclusion.panel4 == '1'}">
                <%panel4 = "style='display: block'";%>
            </c:when>
            <c:otherwise>
                <%panel4 = "style='display: none'";%>
            </c:otherwise>
        </c:choose>
         
        <c:choose>
            <c:when test="${panelConclusion.panel5 == '1'}">
                <%panel5 = "style='display: block'";%>
            </c:when>
            <c:otherwise>
                <%panel5 = "style='display: none'";%>
            </c:otherwise>
        </c:choose>
        <div class="panel panel-default" id="accordioncon_viscargo">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordioncon_viscargo" href="#d1"
                       onclick="muestra_oculta('con_viscargo')">
                        <b>VISTA DE CARGO</b></a>
                </h4>
            </div>
            <div id="con_viscargo" <%=panel1%>>
                <div class="modal-body">
                    <html:form styleId="form-conclusion" action="conclusion.do">
                        <html:hidden property="codigo" styleId="codigo"/>
                        <input type="hidden" name="opcion" id="opcion" class="opcion"/>
                        <input type="hidden" name="opcion2" id="opcion2" class="opcion2"/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">N&uacute;mero de informe Técnico:</label>
                            <div class="col-sm-3">
                                <html:text property="cvc_numero_informe" styleId="cvc_numero_informe"
                                           styleClass="form-control" size="30" maxlength="30" disabled="<%=ffisca%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha informe Técnico:</label>
                            <div class="col-sm-3">
                                <html:text property="cvc_fecha_informe" styleId="cvc_fecha_informe"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=ffisca%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">N&uacute;mero de Vista de Cargo:</label>
                            <div class="col-sm-3">
                                <html:text property="cvc_numero_vc" styleId="cvc_numero_vc"
                                           styleClass="form-control" size="30" maxlength="30" disabled="<%=ffisca%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha de Vista de Cargo:</label>
                            <div class="col-sm-3">
                                <html:text property="cvc_fecha_vc" styleId="cvc_fecha_vc"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=ffisca%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Notificaci&oacute;n Vista de Cargo:</label>
                            <div class="col-sm-3">
                                <html:select property="cvc_tipo_notificacion" styleId="cvc_tipo_notificacion"
                                             styleClass="form-control" disabled="<%=ffisca%>">
                                    <html:option value="-">-- Seleccione el Tipo --</html:option>
                                    <html:option value="ELECTRONICA">ELECTRONICA</html:option>
                                    <html:option value="PERSONAL">PERSONAL</html:option>
                                    <html:option value="CEDULA">CEDULA</html:option>
                                    <html:option value="EDICTO">EDICTO</html:option>
                                    <html:option value="TACITO">TACITO</html:option>
                                </html:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha de la Notificaci&oacute;n:</label>
                            <div class="col-sm-3">
                                <html:text property="cvc_fecha_notificacion" styleId="cvc_fecha_notificacion"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha de presentaci&oacute;n de descargos:</label>
                            <div class="col-sm-3">
                                <html:text property="cvc_fecha_presentacion" styleId="cvc_fecha_presentacion"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=ffisca%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">N&uacute;mero de informe de descargos:</label>
                            <div class="col-sm-3">
                                <html:text property="cvc_inf_descargo" styleId="cvc_inf_descargo"
                                           styleClass="form-control" size="30" maxlength="30" disabled="<%=ffisca%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha informe de descargos:</label>
                            <div class="col-sm-3">
                                <html:text property="cvc_fecha_descargo" styleId="cvc_fecha_descargo"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=ffisca%>"/>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label">N&uacute;mero CI de remisi&oacute;n a la GR:</label>
                            <div class="col-sm-3">
                                <html:text property="cvc_ci_remision" styleId="cvc_ci_remision;"
                                           styleClass="form-control" size="30" maxlength="30" disabled="<%=ffisca%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha de la CI de remisi&oacute;n a la GR:</label>
                            <div class="col-sm-3">
                                <html:text property="cvc_fecha_ci_remision" styleId="cvc_fecha_ci_remision"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=ffisca%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Gerencia - Unidad Legal:</label>
                            <div class="col-sm-3">
                                <html:select property="cvc_gerencia_legal" styleClass="form-control" styleId="cvc_gerencia_legal" disabled="<%=ffisca%>">
                                    <html:option value="-">Seleccione...</html:option>
                                    <html:option value="GRL">LA PAZ</html:option>
                                    <html:option value="GRC">COCHABAMBA</html:option>
                                    <html:option value="GRS">SANTA CRUZ</html:option>
                                    <html:option value="GRO">ORURO</html:option>
                                    <html:option value="GRT">TARIJA</html:option>
                                    <html:option value="GRP">POTOSI</html:option>
                                </html:select>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label label-required">Tipo de RD:</label>
                            <div class="col-sm-3">
                                <html:select property="cvc_tipo_rd" styleId="cvc_tipo_rd"
                                             styleClass="form-control" disabled="<%=flegal%>">
                                    <html:option value="-">-- Seleccione el Tipo --</html:option>
                                    <html:option value="DESCARGOS ACEPTADOS">DESCARGOS ACEPTADOS</html:option>
                                    <html:option value="DEUDA TRIBUTARIA PAGADA">DEUDA TRIBUTARIA PAGADA</html:option>
                                    <html:option value="DEUDA TRIBUTARIA NO PAGADA">DEUDA TRIBUTARIA NO PAGADA</html:option>
                                </html:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label label-required">N&uacute;mero RD:</label>
                            <div class="col-sm-3">
                                <html:text property="cvc_numero_rd" styleId="cvc_numero_rd;" styleClass="form-control"
                                           size="30" maxlength="30" disabled="<%=flegal%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label label-required">Fecha de notificaci&oacute;n de la RD:</label>
                            <div class="col-sm-3">
                                <html:text property="cvc_fecha_rd" styleId="cvc_fecha_rd"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=flegal%>"/>
                            </div>
                        </div>
                        <div class="btn-container">
                            <button type="submit" id="boton_viscargo" onclick="con_viscargo()" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grabar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="submit" id="boton_viscargo_conclusion" onclick="con_viscargo_conclusion()" class="btn btn-primary">&nbsp;&nbsp;&nbsp;Registro de la Conclusión del Control&nbsp;&nbsp;&nbsp;</button>
                        </div>
                        <div class="form-group">
                            <label class="label-message-required">
                                * Campos a ser llenados por la unidad legal
                            </label>
                        </div>
                    </html:form>
                </div>
            </div>
        </div>
        <div class="panel panel-default" id="accordioncon_resdeter">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordioncon_resdeter" href="#d1"
                       onclick="muestra_oculta('con_resdeter')">
                        <b>RESOLUCI&Oacute;N DETERMINATIVA FINAL SIN VISTA DE CARGO</b></a>
                </h4>
            </div>
            <div id="con_resdeter" <%=panel2%>>
                <div class="modal-body">
                    <html:form styleId="form-conclusion" action="conclusion.do">
                        <html:hidden property="codigo" styleId="codigo"/>
                        <input type="hidden" name="opcion" id="opcion" class="opcion"/>
                        <input type="hidden" name="opcion2" id="opcion2" class="opcion2"/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">N&uacute;mero de informe Técnico:</label>
                            <div class="col-sm-3">
                                <html:text property="crd_numero_informe" styleId="crd_numero_informe"
                                           styleClass="form-control" size="30" maxlength="30" disabled="<%=ffisca%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha informe Técnico:</label>
                            <div class="col-sm-3">
                                <html:text property="crd_fecha_informe" styleId="crd_fecha_informe"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=ffisca%>"/>
                            </div>
                        </div> 
                        <div class="form-group">
                            <label class="col-sm-3 control-label">N&uacute;mero RD final:</label>
                            <div class="col-sm-3">
                                <html:text property="crd_rd_final" styleId="crd_rd_final;" styleClass="form-control"
                                           size="30" maxlength="30" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha de notificaci&oacute;n de la RD final:</label>
                            <div class="col-sm-3">
                                <html:text property="crd_fecha_not_rd_final" styleId="crd_fecha_not_rd_final"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="btn-container">
                            <button type="submit" id="boton_resdeter" onclick="con_resdeter()" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grabar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="submit" id="boton_resdeter_conclusion" onclick="con_resdeter_conclusion()" class="btn btn-primary">&nbsp;&nbsp;&nbsp;Registro de la Conclusión del Control&nbsp;&nbsp;&nbsp;</button>
                        </div>
                    </html:form>
                </div>
            </div>
        </div>
        <div class="panel panel-default" id="accordioncon_actainter">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordioncon_actainter" href="#d1"
                       onclick="muestra_oculta('con_actainter')">
                        <b>ACTA DE INTERVENCI&Oacute;N</b></a>
                </h4>
            </div>
            <div id="con_actainter" <%=panel3%>>
                <div class="modal-body">
                    <html:form styleId="form-conclusion" action="conclusion.do">
                        <html:hidden property="codigo" styleId="codigo"/>
                        <input type="hidden" name="opcion" id="opcion" class="opcion"/>
                        <input type="hidden" name="opcion2" id="opcion2" class="opcion2"/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">N&uacute;mero de informe Técnico:</label>
                            <div class="col-sm-3">
                                <html:text property="cai_numero_informe" styleId="cai_numero_informe"
                                           styleClass="form-control" size="30" maxlength="30" disabled="<%=ffisca%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha informe Técnico:</label>
                            <div class="col-sm-3">
                                <html:text property="cai_fecha_informe" styleId="cai_fecha_informe"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=ffisca%>"/>
                            </div>
                        </div> 
                        <div class="form-group">
                            <label class="col-sm-3 control-label">N&uacute;mero del Acta de Intervenci&oacute;n :</label>
                            <div class="col-sm-3">
                                <html:text property="cai_acta_interv" styleId="cai_acta_interv;"
                                           styleClass="form-control" size="30" maxlength="30" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha del Acta de Intervenci&oacute;n:</label>
                            <div class="col-sm-3">
                                <html:text property="cai_fecha_acta_interv" styleId="cai_fecha_acta_interv"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Tipo de Il&iacute;cito:</label>
                            <div class="col-sm-3">
                                <html:select property="cai_tipo_ilicito" styleId="cai_tipo_ilicito"
                                             styleClass="form-control" disabled="<%=ffisca%>" >
                                    <html:option value="-">-- Seleccione el Tipo --</html:option>
                                    <html:option value="CONTRABANDO CONTRAVENCIONAL">CONTRABANDO CONTRAVENCIONAL</html:option>
                                    <html:option value="CONTRABANDO DELITO">CONTRABANDO DELITO</html:option>
                                    <html:option value="OTROS DELITOS">OTROS DELITOS</html:option>
                                </html:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">N&uacute;mero CI de remisi&oacute;n a la GR:</label>
                            <div class="col-sm-3">
                                <html:text property="cai_ci_remision" styleId="cai_ci_remision;"
                                           styleClass="form-control" size="30" maxlength="30" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha de la CI:</label>
                            <div class="col-sm-3">
                                <html:text property="cai_fecha_ci_remision" styleId="cai_fecha_ci_remision"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Gerencia - Unidad Legal:</label>
                            <div class="col-sm-3">
                                <html:select property="cai_gerencia_legal" styleClass="form-control" styleId="cai_gerencia_legal" disabled="<%=ffisca%>">
                                    <html:option value="-">Seleccione...</html:option>
                                    <html:option value="GRL">LA PAZ</html:option>
                                    <html:option value="GRC">COCHABAMBA</html:option>
                                    <html:option value="GRS">SANTA CRUZ</html:option>
                                    <html:option value="GRO">ORURO</html:option>
                                    <html:option value="GRT">TARIJA</html:option>
                                    <html:option value="GRP">POTOSI</html:option>
                                </html:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label label-required">Fecha de Notificaci&oacute;n del Acta de Intervenci&oacute;n:</label>
                            <div class="col-sm-3">
                                <html:text property="cai_fecha_not_ai" styleId="cai_fecha_not_ai"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=flegal%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label label-required">Tipo de Notificaci&oacute;n del Acta de Intervenci&oacute;n:</label>
                            <div class="col-sm-3">
                                <html:select property="cai_tipo_not_ai" styleId="cai_tipo_not_ai"
                                             styleClass="form-control" disabled="<%=flegal%>">
                                    <html:option value="-">-- Seleccione el Tipo --</html:option>
                                    <html:option value="ELECTRONICA">ELECTRONICA</html:option>
                                    <html:option value="PERSONAL">PERSONAL</html:option>
                                    <html:option value="CEDULA">CEDULA</html:option>
                                    <html:option value="EDICTO">EDICTO</html:option>
                                    <html:option value="TACITO">TACITO</html:option>
                                </html:select>
                            </div>
                        </div>                        
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label label-required">Fecha de presentaci&oacute;n de descargos:</label>
                            <div class="col-sm-3">
                                <html:text property="cai_fecha_pres_descargos" styleId="cai_fecha_pres_descargos"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=flegal%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label label-required">N&uacute;mero informe de descargos:</label>
                            <div class="col-sm-3">
                                <html:text property="cai_inf_descargo" styleId="cai_inf_descargo;"
                                           styleClass="form-control" size="30" maxlength="30" disabled="<%=flegal%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label label-required">Fecha informe de descargos:</label>
                            <div class="col-sm-3">
                                <html:text property="cai_fecha_inf_descargo" styleId="cai_fecha_inf_descargo"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=flegal%>"/>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label class="col-sm-3 control-label label-required">Resultado de la Evaluaci&oacute;n de Descargos:</label>
                            <div class="col-sm-3">
                                <html:select property="cai_resultado_des" styleId="cai_resultado_des"
                                             styleClass="form-control" disabled="<%=flegal%>" >
                                    <html:option value="-">-- Seleccione el Tipo --</html:option>
                                    <html:option value="DESCARGOS ACEPTADOS">DESCARGOS ACEPTADOS</html:option>
                                    <html:option value="SANCION PAGADA">SANCIÓN PAGADA</html:option>
                                    <html:option value="OBSERVACION RATIFICAD">OBSERVACIÓN RATIFICADA</html:option>
                                </html:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label label-required">Tipo de Resoluci&oacute;n:</label>
                            <div class="col-sm-3">
                                <html:select property="cai_tipo_resolucion" styleId="cai_tipo_resolucion"
                                             styleClass="form-control" disabled="<%=flegal%>" >
                                    <html:option value="-">-- Seleccione el Tipo --</html:option>
                                    <html:option value="RESOLUCION FINAL DE SUMARIO">RESOLUCIÓN FINAL DE SUMARIO</html:option>
                                    <html:option value="RESOLUCION SANCIONATORIA">RESOLUCIÓN SANCIONATORIA</html:option>
                                </html:select>
                            </div>
                        </div>                              
                        <div class="form-group">
                            <label class="col-sm-3 control-label label-required">N&uacute;mero Resoluci&oacute;n:</label>
                            <div class="col-sm-3">
                                <html:text property="cai_numero_rs" styleId="cai_numero_rs;" styleClass="form-control"
                                           size="30" maxlength="30" disabled="<%=flegal%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label label-required">Fecha de notificaci&oacute;n de la Resoluci&oacute;n:</label>
                            <div class="col-sm-3">
                                <html:text property="cai_fecha_rs" styleId="cai_fecha_rs"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=flegal%>"/>
                            </div>
                        </div>
                        <div class="btn-container">
                            <button type="submit" id="boton_actainter" onclick="con_actainter()" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grabar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="submit" id="boton_actainter_conclusion" onclick="con_actainter_conclusion()" class="btn btn-primary">&nbsp;&nbsp;&nbsp;Registro de la Conclusión del Control&nbsp;&nbsp;&nbsp;</button>
                        </div>
                        <div class="form-group">
                            <label class="label-message-required">
                                * Campos a ser llenados por la unidad legal
                            </label>
                        </div>
                    </html:form>
                </div>
            </div>
        </div>
        <div class="panel panel-default" id="accordioncon_resadmin">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordioncon_resadmin" href="#d1"
                       onclick="muestra_oculta('con_resadmin')">
                        <b>RESOLUCI&Oacute;N ADMINISTRATIVA Y DETERMINATIVA DE FACILIDADES DE PAGO</b></a>
                </h4>
            </div>
            <div id="con_resadmin" <%=panel4%>>
                <div class="modal-body">
                    <html:form styleId="form-conclusion" action="conclusion.do">
                        <html:hidden property="codigo" styleId="codigo"/>
                        <input type="hidden" name="opcion" id="opcion" class="opcion"/>
                        <input type="hidden" name="opcion2" id="opcion2" class="opcion2"/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">N&uacute;mero de informe T&eacute;cnico:</label>
                            <div class="col-sm-3">
                                <html:text property="cra_numero_informe" styleId="cra_numero_informe"
                                           styleClass="form-control" size="30" maxlength="30"
                                           disabled="<%=ffisca%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha informe T&eacute;cnico:</label>
                            <div class="col-sm-3">
                                <html:text property="cra_fecha_informe" styleId="cra_fecha_informe"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10"
                                           disabled="<%=ffisca%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha de pago cuota inicial:</label>
                            <div class="col-sm-3">
                                <html:text property="cra_fecha_pago_cuini" styleId="cra_fecha_pago_cuini"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10"
                                           disabled="<%=ffisca%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">N&uacute;mero de Recibo &Uacute;nico de Pago:</label>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">Gesti&oacute;n:</label>
                                     
                                    <label class="col-sm-6 control-label">Aduana:</label>
                                     
                                    <label class="col-sm-2 control-label">N&uacute;mero:</label>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-2">
                                        <html:text property="cra_rup_gestion" styleId="cra_rup_gestion"
                                                   styleClass="form-control required numeric" size="30" maxlength="4"/>
                                    </div>
                                    <div class="col-sm-6">
                                        <html:select property="cra_rup_aduana" styleClass="form-control required" styleId="cra_rup_aduana">
                                            <html:option value="-">Seleccione...</html:option>
                                            <html:optionsCollection name="aduanas" value="codigo" label="descripcion"/>
                                        </html:select>
                                    </div>
                                    <div class="col-sm-2">
                                        <html:text property="cra_rup_numero" styleId="cra_rup_numero"
                                                   styleClass="form-control required numeric" size="30" maxlength="10"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Monto del pago de la cuota inicial (UFV`s):</label>
                            <div class="col-sm-3">
                                <html:text property="cra_monto_pago_cuoini" styleId="cra_monto_pago_cuoini"
                                           styleClass="form-control numeric" size="30" maxlength="30"
                                           disabled="<%=ffisca%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">N&uacute;mero de la Resoluci&oacute;n Administrativa:</label>
                            <div class="col-sm-3">
                                <html:text property="cra_numero_ra" styleId="cra_numero_ra" styleClass="form-control"
                                           size="30" maxlength="30"  disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha de notificaci&oacute;n de la RA:</label>
                            <div class="col-sm-3">
                                <html:text property="cra_fecha_ra" styleId="cra_fecha_ra"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Comunicaci&oacute;n interna de remisi&oacute;n a la
                                                                  SET:</label>
                            <div class="col-sm-3">
                                <html:text property="cra_ci_remision_set" styleId="cra_ci_remision_set;"
                                           styleClass="form-control" size="30" maxlength="30" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha de la Comunicaci&oacute;n interna de
                                                                  remisi&oacute;n a la SET:</label>
                            <div class="col-sm-3">
                                <html:text property="cra_fecha_remision_set" styleId="cra_fecha_remision_set"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Gerencia - Unidad Legal:</label>
                            <div class="col-sm-3">
                                <html:select property="cra_gerencia_legal" styleClass="form-control" 
                                             styleId="cra_gerencia_legal" disabled="<%=ffisca%>">
                                    <html:option value="-">Seleccione...</html:option>
                                    <html:option value="GRL">LA PAZ</html:option>
                                    <html:option value="GRC">COCHABAMBA</html:option>
                                    <html:option value="GRS">SANTA CRUZ</html:option>
                                    <html:option value="GRO">ORURO</html:option>
                                    <html:option value="GRT">TARIJA</html:option>
                                    <html:option value="GRP">POTOSI</html:option>
                                </html:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Saldo por cobrar de las facilidades de pago (UFV`s):</label>
                            <div class="col-sm-3">
                                <html:text property="cra_saldo_por_cobrar" styleId="cra_saldo_por_cobrar;"
                                           styleClass="form-control numeric" size="30" maxlength="30" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="btn-container">
                            <button type="submit" id="boton_resadmin" onclick="con_resadmin()" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grabar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="submit" id="boton_resadmin_conclusion" onclick="con_resadmin_conclusion()" class="btn btn-primary">&nbsp;&nbsp;&nbsp;Registro de la Conclusión del Control&nbsp;&nbsp;&nbsp;</button>
                        </div>
                    </html:form>
                </div>
            </div>
        </div>
        <div class="panel panel-default" id="accordioncon_autoinicial">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordioncon_autoinicial" href="#d1"
                       onclick="muestra_oculta('con_autoinicial')">
                        <b>AUTO INICIAL DE SUMARIO CONTRAVENCIONAL</b></a>
                </h4>
            </div>
            <div id="con_autoinicial" <%=panel5%>>
                <div class="modal-body">
                    <html:form styleId="form-conclusion" action="conclusion.do">
                        <html:hidden property="codigo" styleId="codigo"/>
                        <input type="hidden" name="opcion" id="opcion" class="opcion"/>
                        <input type="hidden" name="opcion2" id="opcion2" class="opcion2"/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">N&uacute;mero de informe Técnico:</label>
                            <div class="col-sm-3">
                                <html:text property="cas_numero_informe" styleId="cas_numero_informe"
                                           styleClass="form-control" size="30" maxlength="30" disabled="<%=ffisca%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha informe Técnico:</label>
                            <div class="col-sm-3">
                                <html:text property="cas_fecha_informe" styleId="cas_fecha_informe"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=ffisca%>"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">N&uacute;mero AISC:</label>
                            <div class="col-sm-3">
                                <html:text property="cas_numero_aisc" styleId="cas_numero_aisc"
                                           styleClass="form-control" size="30" maxlength="30" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha de Notificaci&oacute;n:</label>
                            <div class="col-sm-3">
                                <html:text property="cas_fecha_notificacion" styleId="cas_fecha_notificacion"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha de presentaci&oacute;n de descargos:</label>
                            <div class="col-sm-3">
                                <html:text property="cas_fecha_pres_descargos" styleId="cas_fecha_pres_descargos"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">N&uacute;mero informe de descargos:</label>
                            <div class="col-sm-3">
                                <html:text property="cas_inf_descargo" styleId="cas_inf_descargo"
                                           styleClass="form-control" size="30" maxlength="30" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha informe de descargos:</label>
                            <div class="col-sm-3">
                                <html:text property="cas_fecha_inf_descargo" styleId="cas_fecha_inf_descargo"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">N&uacute;mero Resoluci&oacute;n Final de Sumario (RFS):</label>
                            <div class="col-sm-3">
                                <html:text property="cas_numero_rfs" styleId="cas_numero_rfs" styleClass="form-control"
                                           size="30" maxlength="30" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha de notificaci&oacute;n de la RFS:</label>
                            <div class="col-sm-3">
                                <html:text property="cas_fecha_rfs" styleId="cas_fecha_rfs"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">N&uacute;mero CI de remisi&oacute;n a la GR:</label>
                            <div class="col-sm-3">
                                <html:text property="cas_ci_remision_gr" styleId="cas_ci_remision_gr"
                                           styleClass="form-control" size="30" maxlength="30" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Fecha de la CI:</label>
                            <div class="col-sm-3">
                                <html:text property="cas_fecha_ci" styleId="cas_fecha_ci"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=ffisca%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">Gerencia - Unidad Legal:</label>
                            <div class="col-sm-3">
                                <html:select property="cas_gerencia_legal" styleClass="form-control"
                                             styleId="cas_gerencia_legal" disabled="<%=ffisca%>">
                                    <html:option value="-">Seleccione...</html:option>
                                    <html:option value="GRL">LA PAZ</html:option>
                                    <html:option value="GRC">COCHABAMBA</html:option>
                                    <html:option value="GRS">SANTA CRUZ</html:option>
                                    <html:option value="GRO">ORURO</html:option>
                                    <html:option value="GRT">TARIJA</html:option>
                                    <html:option value="GRP">POTOSI</html:option>
                                </html:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label label-required">N&uacute;mero Resoluci&oacute;n Sancionatoria (RS):</label>
                            <div class="col-sm-3">
                                <html:text property="cas_numero_rs" styleId="cas_numero_rs" styleClass="form-control"
                                           size="30" maxlength="30" disabled="<%=flegal%>" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label label-required">Fecha de notificaci&oacute;n de la RS:</label>
                            <div class="col-sm-3">
                                <html:text property="cas_fecha_rs" styleId="cas_fecha_rs"
                                           styleClass="form-control datepicker date-less-than" size="30" maxlength="10" disabled="<%=flegal%>" />
                            </div>
                        </div>
                        <div class="btn-container">
                            <button type="submit" id="boton_autoinicial" onclick="con_autoinicial()" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grabar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="submit" id="boton_autoinicial_conclusion" onclick="con_autoinicial_conclusion()" class="btn btn-primary">&nbsp;&nbsp;&nbsp;Registro de la Conclusión del Control&nbsp;&nbsp;&nbsp;</button>
                        </div>
                        <div class="form-group">
                            <label class="label-message-required">
                                * Campos a ser llenados por la unidad legal
                            </label>
                        </div>
                    </html:form>
                </div>
            </div>
        </div>
        <html:form styleId="form-conclusioncontrol" action="conclusion.do">
            <html:hidden property="codigo" styleId="codigo"/>
            <input type="hidden" name="opcion" id="opcion" class="opcion"/>
            <div class="btn-container">
                <button type="submit" id="boton_conclusion" onclick="con_conclusion()" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Finalizar Fiscalizaci&oacute;n&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
            </div>
        </html:form>
    </div>
</div>
<script>
  $(document).ready(function () {
     var fboton = <%=fbotones%>;
     if (fboton){
        $("#boton_viscargo").hide();
        $("#boton_resdeter").hide();
        $("#boton_actainter").hide();
        $("#boton_resadmin").hide();
        $("#boton_autoinicial").hide();
        $("#boton_conclusion").hide();
     }else{
        $("#boton_viscargo").show();
        $("#boton_resdeter").show();
        $("#boton_actainter").show();
        $("#boton_resadmin").show();
        $("#boton_autoinicial").show();
        $("#boton_conclusion").show();        
     }
     
     var fbotoncon = <%=fbotones_concluir%>;
     if (fbotoncon){
        $("#boton_viscargo_conclusion").hide();
        $("#boton_resdeter_conclusion").hide();
        $("#boton_actainter_conclusion").hide();
        $("#boton_resadmin_conclusion").hide();
        $("#boton_autoinicial_conclusion").hide();
        $("#boton_conclusion_conclusion").hide();
     }else{
        $("#boton_viscargo_conclusion").show();
        $("#boton_resdeter_conclusion").show();
        $("#boton_actainter_conclusion").show();
        $("#boton_resadmin_conclusion").show();
        $("#boton_autoinicial_conclusion").show();
        $("#boton_conclusion_conclusion").show();    
     }
     
     var doc_con = "<%=inf.getDoc_con_tipo()%>";
     if(doc_con == "VISTA DE CARGO"){
        //$("#cvc_numero_vc").prop('disabled', true);
        //$("#cvc_fecha_vc").prop('disabled', true);
     }
  });

  function muestra_oculta(id) {
      if (document.getElementById) {
          document.getElementById(id).style.display = (document.getElementById(id).style.display == 'none') ? 'block' : 'none';//damos un atributo display:none que oculta el div
      }
  }

  function consultar() {
      $(".opcion").val('ASIGNA');
  }

  function con_viscargo() {
      $(".opcion").val('con_viscargo');
  }

  function con_resdeter() {
      $(".opcion").val('con_resdeter');
  }

  function con_actainter() {
      $(".opcion").val('con_actainter');
  }

  function con_resadmin() {
      $(".opcion").val('con_resadmin');
  }

  function con_autoinicial() {
      $(".opcion").val('con_autoinicial');
  }
  
  function con_viscargo_conclusion() {
        $(".opcion2").val('concluir');
        $(".opcion").val('con_viscargo');
  }

  function con_resdeter_conclusion() {
      $(".opcion2").val('concluir');
      $(".opcion").val('con_resdeter');
  }

  function con_actainter_conclusion() {
      $(".opcion2").val('concluir');
      $(".opcion").val('con_actainter');
  }

  function con_resadmin_conclusion() {
      $(".opcion2").val('concluir');
      $(".opcion").val('con_resadmin');
  }

  function con_autoinicial_conclusion() {
      $(".opcion2").val('concluir');
      $(".opcion").val('con_autoinicial');
  }
  
  function con_conclusion() {
      $(".opcion").val('con_conclusion');
  }
</script>