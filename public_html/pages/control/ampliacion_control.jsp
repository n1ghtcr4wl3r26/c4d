<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="anb.bean.*"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h4 class="panel-title">
            <strong>AMPLIACIÓN CONTROL</strong>
        </h4>
    </div>
    <% 
        AmpliacionForm amp = (AmpliacionForm)request.getAttribute("AmpliacionForm");
    %>
    <div class="modal-body form-horizontal">
        <html:form styleId="form-ampliacion" action="ampconsultar.do">
            <input type="hidden" name="opcion" id="opcion"/>
            <html:hidden property="borrarid" styleId="borrarid"/>
            <html:hidden property="codigo" styleId="codigo"/>
            <html:hidden property="numeroOperador" styleId="numeroOperador"/>
            <html:hidden property="tipoOperador" styleId="tipoOperador"/>
            <html:hidden property="codigoconcat" styleId="codigoconcat"/>
            <html:hidden property="codigoconcatval" styleId="codigoconcatval"/>
            <html:hidden property="codigoconcatpar" styleId="codigoconcatpar"/>
            <html:hidden property="codigoconcatori" styleId="codigoconcatori"/>
            <html:hidden property="codigoconcatotr" styleId="codigoconcatotr"/>
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
                <label class="col-sm-2 control-label">Tipo de Trámite:</label>
                <div class="col-sm-2">
                    <html:select property="tipoTramite" styleClass="form-control required">
                        <html:option value="-">Seleccione...</html:option>
                        <html:option value="DUI">DUI</html:option>
                        <html:option value="DUE">DUE</html:option>
                    </html:select>
                </div>
            </div>
            
            <div class="form-group">
                <label class="col-sm-2 control-label">Fecha de Registro Desde:</label>
                <div class="col-sm-2">
                    <html:text property="fecIni" maxlength="10" styleClass="form-control required datepicker date-less-than" size="50"/>
                </div>
                <label class="col-sm-2 control-label">Fecha de Registro Hasta:</label>
                <div class="col-sm-2">
                    <html:text property="fecFin" maxlength="10" styleClass="form-control required datepicker date-less-than" size="50"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Aduana:</label>
                <div class="col-sm-4">
                    <html:select property="aduana" styleClass="form-control required">
                        <option value="-">Seleccione...</option>
                        <html:optionsCollection name="aduanas" value="codigo" label="descripcion"/>
                    </html:select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Operador:</label>
                <div class="col-sm-2">
                    <html:text property="operador" styleId="operador" maxlength="15" styleClass="form-control numeric " size="50"/>
                </div>                  
                <label class="col-sm-2 control-label">Declarante:</label>
                <div class="col-sm-2">
                    <html:text property="declarante" styleId="declarante" maxlength="15" styleClass="form-control numeric" size="50"/>
                </div>
            </div>
            <%/*<div class="form-group">
                <label class="col-sm-2 control-label">Partida:</label>
                <div class="col-sm-2">
                    <html:text property="partida" maxlength="11" styleClass="form-control numeric" size="50"/>
                </div>  
                <label class="col-sm-2 control-label">Proveedor:</label>
                <div class="col-sm-2">
                    <html:text property="emisor" maxlength="15" styleClass="form-control  " size="50"/>
                </div>
            </div>*/%>
            <div class="form-group">
                <label class="col-sm-2 control-label">Origen:</label>
                <div class="col-sm-2">
                    <html:select property="origen" styleClass="form-control required">
                        <html:option value="-">Seleccione...</html:option>
                        <html:optionsCollection name="paises" value="codigo" label="descripcion"/>
                    </html:select>
                </div>
                <label class="col-sm-2 control-label">Tipo de Búsqueda:</label>
                <div class="col-sm-2">
                    <html:select property="tipoBusqueda" styleId="tipoBusqueda" styleClass="form-control required">
                        <html:option value="-">Seleccione...</html:option>
                        <html:option value="Declaracion">Declaración</html:option>
                        <html:option value="Item">Item</html:option>
                    </html:select>
                </div>
            </div>
            <div class="btn-container">
                <button type="submit" id="boton" value="Consultar" onclick="consultar()" class="btn btn-primary" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Consultar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>            
            </div>
            <div class="form-group">
                <label class="label-message-required">
                    * Campos Obligatorios
                </label>
            </div>
          
            <% 
            if(!(amp.getOpcion() == null) && (amp.getOpcion().equals("CONSULTAR"))) {
                if(amp.getCantidad_dec() == 0){
                %>
                    <h4>
                        <strong>NO SE ENCONTRO NINGUNA DECLARACIÓN CON LOS PARAMETROS INTRODUCIDOS </strong>
                    </h4> 
                <%
                }else{
                    if(amp.getTipoBusqueda().equals("Declaracion"))
                    {
                    %>
                       
                        <br>
                        <div class="panel-title" >
                            <strong>RESULTADOS DE LA BÚSQUEDA DE DECLARACIONES </strong>
                        </div>
                        <button class="btn btn-info btn-sm newHide" 
                                type="button" id="btnInc2"
                                title="Agregar Declaraciones"
                                onfocus="concat_idsitem()">
                            <i class="fa fa-percent"></i> Agregar Declaraciones
                        </button>  
                        <div class="table-responsive">
                        <table class="table table-striped table-hover" id="main-table">
                            <thead>
                                <tr>
                                    <th class="text-center">
                                        &nbsp;
                                    </th>
                                    <th class="text-center">
                                        <input type="checkbox" style="width:13px;height:13px" class="check_allval" id="check_allval" />Valor
                                    </th>
                                    <th class="text-center">
                                        <input type="checkbox" style="width:13px;height:13px" class="check_allpar" id="check_allpar" />Partida
                                    </th>
                                    <th class="text-center">
                                        <input type="checkbox" style="width:13px;height:13px" class="check_allori" id="check_allori" />Origen
                                    </th>
                                    <th class="text-center">
                                        <input type="checkbox" style="width:13px;height:13px" class="check_allotr" id="check_allotr" />Otros
                                    </th>
                                    <th class="text-center">Número</th>
                                    <th class="text-center">Declaración</th>
                                    <th class="text-center">Canal</th>
                                    <th class="text-center">Fecha Registro</th>
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
                                        <c:if test="${fn:substring(esc.verifitem,0,4) == '0000' }">
                                            <input type="checkbox" style="width:13px;height:13px" id="todo${esc.sequencia}"  value="${esc.codigo}" class="check_grouptodo todo"/>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${fn:substring(esc.verifitem,0,1) == '0' }">
                                            <input type="checkbox" style="width:13px;height:13px" id="val${esc.sequencia}"  value="${esc.codigo}" class="check_groupval"/>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${fn:substring(esc.verifitem,1,2) == '0' }">
                                            <input type="checkbox" style="width:13px;height:13px"  id="par${esc.sequencia}" value="${esc.codigo}" class="check_grouppar"/>
                                        </c:if>
                                    </td>
                                    <td>  
                                        <c:if test="${fn:substring(esc.verifitem,2,3) == '0' }">
                                            <input type="checkbox" style="width:13px;height:13px"  id="ori${esc.sequencia}" value="${esc.codigo}" class="check_groupori"/>
                                        </c:if>
                                    </td>
                                    <td>  
                                        <c:if test="${fn:substring(esc.verifitem,3,4) == '0' }">
                                            <input type="checkbox" style="width:13px;height:13px"  id="otr${esc.sequencia}" value="${esc.codigo}" class="check_groupotr"/>
                                        </c:if>
                                    </td>
                                    <td>${esc.sequencia}</td>
                                    <td><a onclick=window.open('http://anbsw07.aduana.gob.bo:7601/mira/repduiform.jsp?gestion=${esc.gestion}&aduana=${esc.aduana}&registro=${esc.numero}&vdec=&vop=&vusu=${AlcanceForm.usuario}&bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >${esc.tramite}</a></td>
                                    <td class="text-center">${esc.canal}</td>
                                    <td class="text-center">${esc.fechaRegistro}</td>
                                    <td class="text-left">${esc.operador}&nbsp;${esc.operadorNombre}</td>
                                    <td class="text-left">${esc.declarante}&nbsp;${esc.declaranteNombre}</td>
                                    <td class="text-center">${esc.origen}</td>                                    
                                    <td class="text-left">${esc.estado}</td>
                                    <td class="text-center">
                                        <a onclick=window.open('http://anbsw07.aduana.gob.bo:7601/mira/repduiform.jsp?gestion=${esc.gestion}&aduana=${esc.aduana}&registro=${esc.numero}&vdec=&vop=&vusu=${AlcanceForm.usuario}&bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >
                                            DUI
                                        </a>
                                    </td>
                                    <td class="text-center">
                                        <a onclick=window.open('http://anbsw07.aduana.gob.bo:7601/mira/DUI_docadi.jsp?gestion=${esc.gestion}&aduana=${esc.aduana}&registro=${esc.numero}&vdec=&vop=&vusu=${AlcanceForm.usuario}&bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >
                                            Doc. Adicionales
                                        </a>
                                    </td>
                                    <td class="text-center">
                                        <a onclick=window.open('http://anbsw07.aduana.gob.bo:7601/mira/DUI_notaval.jsp?gestion=${esc.gestion}&aduana=${esc.aduana}&registro=${esc.numero}&vdec=&vop=&vusu=${AlcanceForm.usuario}&bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >
                                            Nota de Valor
                                        </a>
                                    </td>
                                    <td class="text-center">
                                        <a onclick=window.open('http://anbsw07.aduana.gob.bo:7601/mira/DUI_infadi.jsp?gestion=${esc.gestion}&aduana=${esc.aduana}&registro=${esc.numero}&vdec=&vop=&vusu=${AlcanceForm.usuario}&bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >
                                            Inf. Adicional
                                        </a>
                                    </td>
                                    <td class="text-center">
                                        <a onclick=window.open('http://anbsw07.aduana.gob.bo:7601/mira/DUI_frv.jsp?gestion=${esc.gestion}&aduana=${esc.aduana}&registro=${esc.numero}&vdec=&vop=&vusu=${AlcanceForm.usuario}&bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >
                                            FRV
                                        </a>
                                    </td>
                                    <td class="text-center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        </div>
                        <button class="btn btn-info btn-sm newHide" 
                                type="button" id="btnInc"
                                title="Agregar Declaraciones"
                                onfocus="concat_idsitem()">
                            <i class="fa fa-percent"></i> Agregar Declaraciones
                        </button>    
                    <%                    
                    }
                    if(amp.getTipoBusqueda().equals("Item"))
                    {
                    %>
                        <br>
                        <br>
                        
                        
                        <div class="panel-title" >
                            <strong>RESULTADOS DE LA BUSQUEDA DE DECLARACIONES POR ÍTEM </strong>
                        </div>
                        <button class="btn btn-info btn-sm newHide" 
                                type="button" id="btnInc"
                                title="Agregar Ítems Declaraciones"
                                onfocus="concat_idsitem()">
                            <i class="fa fa-percent"></i> Agregar Ítems Declaraciones
                        </button>   
                        <div class="table-responsive">
                        <table class="table table-striped table-hover" id="main-table">
                            <thead>
                                <tr>
                                    <th class="text-center">
                                        &nbsp;
                                    </th>
                                    <th class="text-center">
                                        <input type="checkbox" style="width:13px;height:13px" class="check_allval" id="check_allval" />Valor
                                    </th>
                                    <th class="text-center">
                                        <input type="checkbox" style="width:13px;height:13px" class="check_allpar" id="check_allpar" />Partida
                                    </th>
                                    <th class="text-center">
                                        <input type="checkbox" style="width:13px;height:13px" class="check_allori" id="check_allori" />Origen
                                    </th>
                                    <th class="text-center">
                                        <input type="checkbox" style="width:13px;height:13px" class="check_allotr" id="check_allotr" />Otros
                                    </th>
                                    <th class="text-center">Número</th>
                                    <th class="text-center">Declaración</th>
                                    <th class="text-center">Número de Ítem</th>
                                    <th class="text-center">Canal</th>
                                    <th class="text-center">Fecha Registro</th>
                                    <th class="text-center">Operador</th>
                                    <th class="text-center">Declarante</th>
                                    <th class="text-center">Origen</th>
                                    <th class="text-center">Partida</th>
                                    <th class="text-center">Proveedor</th>
                                    <th class="text-center">Descripcion</th>
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
                            
                                <c:forEach items="${declaracionesItem}" var="esc">
                                <tr>
                                    <td>   
                                        <c:if test="${fn:substring(esc.verifitem,0,4) == '0000' }">
                                            <input type="checkbox" style="width:13px;height:13px" id="todo${esc.sequencia}"  value="${esc.codigo}" class="check_grouptodo todo"/>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${fn:substring(esc.verifitem,0,1) == '0' }">
                                            <input type="checkbox" style="width:13px;height:13px" id="val${esc.sequencia}"  value="${esc.codigo}" class="check_groupval"/>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${fn:substring(esc.verifitem,1,2) == '0' }">
                                            <input type="checkbox" style="width:13px;height:13px"  id="par${esc.sequencia}" value="${esc.codigo}" class="check_grouppar"/>
                                        </c:if>
                                    </td>
                                    <td>  
                                        <c:if test="${fn:substring(esc.verifitem,2,3) == '0' }">
                                            <input type="checkbox" style="width:13px;height:13px"  id="ori${esc.sequencia}" value="${esc.codigo}" class="check_groupori"/>
                                        </c:if>
                                    </td>
                                    <td>  
                                        <c:if test="${fn:substring(esc.verifitem,3,4) == '0' }">
                                            <input type="checkbox" style="width:13px;height:13px"  id="otr${esc.sequencia}" value="${esc.codigo}" class="check_groupotr"/>
                                        </c:if>
                                    </td>
                                    <td>${esc.sequencia}</td>
                                    <td><a onclick=window.open('http://anbsw07.aduana.gob.bo:7601/mira/repduiform.jsp?gestion=${esc.gestion}&aduana=${esc.aduana}&registro=${esc.numero}&vdec=&vop=&vusu=${AlcanceForm.usuario}&bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >${esc.tramite}</a></td>
                                    <td>${esc.item}</td>
                                    <td class="text-center">${esc.canal}</td>
                                    <td class="text-center">${esc.fechaRegistro}</td>
                                    <td class="text-left">${esc.operador}&nbsp;${esc.operadorNombre}</td>
                                    <td class="text-left">${esc.declarante}&nbsp;${esc.declaranteNombre}</td>
                                    <td class="text-center">${esc.origen}</td>
                                    <td class="text-center">${esc.partida}</td>
                                    <td class="text-center">${esc.proveedor}</td>
                                    <td class="text-center">${esc.descripcion}</td>
                                    <td class="text-left">${esc.estado}</td>
                                    <td class="text-center">
                                        <a onclick=window.open('http://anbsw07.aduana.gob.bo:7601/mira/repduiform.jsp?gestion=${esc.gestion}&aduana=${esc.aduana}&registro=${esc.numero}&vdec=&vop=&vusu=${AlcanceForm.usuario}&bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >
                                            DUI
                                        </a>
                                    </td>
                                    <td class="text-center">
                                        <a onclick=window.open('http://anbsw07.aduana.gob.bo:7601/mira/DUI_docadi.jsp?gestion=${esc.gestion}&aduana=${esc.aduana}&registro=${esc.numero}&vdec=&vop=&vusu=${AlcanceForm.usuario}&bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >
                                            Doc. Adicionales
                                        </a>
                                    </td>
                                    <td class="text-center">
                                        <a onclick=window.open('http://anbsw07.aduana.gob.bo:7601/mira/DUI_notaval.jsp?gestion=${esc.gestion}&aduana=${esc.aduana}&registro=${esc.numero}&vdec=&vop=&vusu=${AlcanceForm.usuario}&bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >
                                            Nota de Valor
                                        </a>
                                    </td>
                                    <td class="text-center">
                                        <a onclick=window.open('http://anbsw07.aduana.gob.bo:7601/mira/DUI_infadi.jsp?gestion=${esc.gestion}&aduana=${esc.aduana}&registro=${esc.numero}&vdec=&vop=&vusu=${AlcanceForm.usuario}&bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >
                                            Inf. Adicional
                                        </a>
                                    </td>
                                    <td class="text-center">
                                        <a onclick=window.open('http://anbsw07.aduana.gob.bo:7601/mira/DUI_frv.jsp?gestion=${esc.gestion}&aduana=${esc.aduana}&registro=${esc.numero}&vdec=&vop=&vusu=${AlcanceForm.usuario}&bandera=undefined','_blank','width=550,height=580,menubar=0,scrollbars=yes,toolbar=0,location=0,directories=0,resizable=0,top=0,left=0') href='javascript:void(0)' >
                                            FRV
                                        </a>
                                    </td>
                                    <td class="text-center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        </div>
                        <button class="btn btn-info btn-sm newHide" 
                                type="button" id="btnInc"
                                title="Agregar Ítems Declaraciones"
                                onfocus="concat_idsitem()">
                            <i class="fa fa-percent"></i> Agregar Ítems Declaraciones
                        </button>    
                    <%
                    }
                }
            }
            %>
       
            <% 
            if(amp.getCantidad_amp() > 0) {
            %>  
                <br>
                <br>
                <h4>
                    <strong>LISTA DE LA AMPLIACIÓN DEL ALCANCE DE LA FISCALIZACIÓN</strong>
                </h4>       
                <div class="table-responsive">
                <table class="table table-striped table-hover" id="main-table">
                    <thead>
                        <tr>
                            <th>N&uacute;mero</th>
                            <th>Tipo</th>
                            <th>ítem</th>
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
                                                title="Borrar Ampliacion"
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
                </div>
            <%
            }
            %>   
        </html:form>
        <html:form styleId="form-alcance-borrar" action="ampliaciontramite.do">
            <input type="hidden" name="opcion" id="opcionb"/>
            <html:hidden property="codigo" styleId="codigob"/>
            <html:hidden property="numeroOperador" styleId="numeroOperadorb"/>
            <html:hidden property="tipoOperador" styleId="tipoOperadorb"/>
            <html:hidden property="operador" styleId="operadorb"/>
            <html:hidden property="declarante" styleId="declaranteb"/>         
            <html:hidden property="tipoTramite" styleId="tipoTramiteb"/>         
            <html:hidden property="fecIni" styleId="fecInib"/>         
            <html:hidden property="fecFin" styleId="fecFinb"/>         
            <html:hidden property="aduana" styleId="aduanab"/>         
            <html:hidden property="origen" styleId="origenb"/>         
            <html:hidden property="tipoBusqueda" styleId="tipoBusquedab"/>
         
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
    $(document).ready(function () {
    if($("#tipoOperador").val()=="IMPORTADOR/EXPORTADOR"){
       $("#operador").attr('readonly', 'true');
    }
    if($("#tipoOperador").val()=="DECLARANTE"){
       $("#declarante").attr('readonly', 'true');
    }
    
    $(".todo").click(function(){
        var clase = this.id;
        var indice = clase.substr(4,clase.length+1);
       
        if ($(this).is(":checked")) { 
            $("#val"+indice).prop('checked', true).attr('checked', 'checked');
            $("#par"+indice).prop('checked', true).attr('checked', 'checked');
            $("#ori"+indice).prop('checked', true).attr('checked', 'checked');
            $("#otr"+indice).prop('checked', true).attr('checked', 'checked');
        }
        else{
            $("#val"+indice).prop('checked', false).removeAttr('checked');
            $("#par"+indice).prop('checked', false).removeAttr('checked');
            $("#ori"+indice).prop('checked', false).removeAttr('checked');
            $("#otr"+indice).prop('checked', false).removeAttr('checked');
        }        
       
        
    });
        var DT = new Anb.datatable({
            filter: true,
            "iDisplayLength": -1,
            oLanguage: {"sSearch": '<i class="glyphicon glyphicon-search"></i> Buscar: '}
            
        });
        
        DT.$('.deletebtn').on('click', function() {           
            var id = this.getAttribute('data-item');
            Anb.confirm('¿Está seguro que desea eliminar el trámite de la ampliación del alcance?', function () {
                    $("#borrarid").val(id);
                    $("#opcion").val('BORRAR'); 
                    $("#form-ampliacion").submit();
            });
            
        });
        
        Anb.form.submit('#form-ampliacion', function (form) {
            Anb.form.cleanErrors(form);
            if ($("#opcion").val() =='BORRAR')
                form.submit();
            else
                if (Anb.validate.run(form)) {
                    console.log('Enviado!');
                    Anb.loading.show()                
                    form.submit();
                }
        });     
     
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
      
        $("#check_all").click(function(event){
            if ($(this).is(":checked")) { 
                $('.check_group:checkbox').prop('checked', true).attr('checked', 'checked');
            }
            else {
                $('.check_group:checkbox').prop('checked', false).removeAttr('checked');
            }        
        });
        $(".check_group").click(function(event){
            if ($(this).is(":checked")) { 
                ;//$('.check_group:checkbox').prop('checked', true).attr('checked', 'checked');
            }
            else {
                $('#check_all:checkbox').prop('checked', false).removeAttr('checked');
            }        
        });
        
        $("#check_allval").click(function(event){
            if ($(this).is(":checked")) { 
                $('.check_groupval:checkbox').prop('checked', true).attr('checked', 'checked');
            }
            else {
                $('.check_groupval:checkbox').prop('checked', false).removeAttr('checked');
            }        
        });
        $(".check_groupval").click(function(event){
            if ($(this).is(":checked")) { 
                ;//$('.check_group:checkbox').prop('checked', true).attr('checked', 'checked');
            }
            else {
                $('#check_allval:checkbox').prop('checked', false).removeAttr('checked');
            }        
        });
        
        $("#check_allpar").click(function(event){
            if ($(this).is(":checked")) { 
                $('.check_grouppar:checkbox').prop('checked', true).attr('checked', 'checked');
            }
            else {
                $('.check_grouppar:checkbox').prop('checked', false).removeAttr('checked');
            }        
        });
        $(".check_grouppar").click(function(event){
            if ($(this).is(":checked")) { 
                ;//$('.check_group:checkbox').prop('checked', true).attr('checked', 'checked');
            }
            else {
                $('#check_allpar:checkbox').prop('checked', false).removeAttr('checked');
            }        
        });
        
        $("#check_allori").click(function(event){
            if ($(this).is(":checked")) { 
                $('.check_groupori:checkbox').prop('checked', true).attr('checked', 'checked');
            }
            else {
                $('.check_groupori:checkbox').prop('checked', false).removeAttr('checked');
            }        
        });
        $(".check_groupori").click(function(event){
            if ($(this).is(":checked")) { 
                ;//$('.check_group:checkbox').prop('checked', true).attr('checked', 'checked');
            }
            else {
                $('#check_allori:checkbox').prop('checked', false).removeAttr('checked');
            }        
        });
        
        $("#check_allotr").click(function(event){
            if ($(this).is(":checked")) { 
                $('.check_groupotr:checkbox').prop('checked', true).attr('checked', 'checked');
            }
            else {
                $('.check_groupotr:checkbox').prop('checked', false).removeAttr('checked');
            }        
        });
        $(".check_groupotr").click(function(event){
            if ($(this).is(":checked")) { 
                ;//$('.check_group:checkbox').prop('checked', true).attr('checked', 'checked');
            }
            else {
                $('#check_allotr:checkbox').prop('checked', false).removeAttr('checked');
            }        
        });
        
        $("#check_alltodo").click(function(event){
            if ($(this).is(":checked")) { 
                $('.check_grouptodo:checkbox').prop('checked', true).attr('checked', 'checked');
            }
            else {
                $('.check_grouptodo:checkbox').prop('checked', false).removeAttr('checked');
            }        
        });
        $(".check_grouptodo").click(function(event){
            if ($(this).is(":checked")) { 
                ;//$('.check_group:checkbox').prop('checked', true).attr('checked', 'checked');
            }
            else {
                $('#check_alltodo:checkbox').prop('checked', false).removeAttr('checked');
            }        
        });
        
    });
  
    function concat_ids(){
        var chkArray = [];
	/* look for all checkboes that have a class 'chk' attached to it and check if it was checked */
	$(".check_group:checked").each(function() {
		chkArray.push($(this).val());
	});
	var selected;
	selected = chkArray.join(',') + ",";
	/* check if there is selected checkboxes, by default the length is 1 as it contains one single comma */
	if(selected.length > 1){        
            $("#opcion").val('GRABADUIS');
            $("#codigoconcat").val(selected);
            $("#form-ampliacion").submit();
	}else{
            Anb.alert('Debe seleccionar por lo menos una declaración para realizar esta acción.');
        }
    }
    
    function concat_idsitem(){
        var chkArrayval = [];
	$(".check_groupval:checked").each(function() {
		chkArrayval.push($(this).val());
	});
	var selectedval;
	selectedval = chkArrayval.join(',') + ",";
        
        var chkArraypar = [];
	$(".check_grouppar:checked").each(function() {
		chkArraypar.push($(this).val());
	});
	var selectedpar;
	selectedpar = chkArraypar.join(',') + ",";
        
        var chkArrayori = [];
	$(".check_groupori:checked").each(function() {
		chkArrayori.push($(this).val());
	});
	var selectedori;
	selectedori = chkArrayori.join(',') + ",";
        
        var chkArrayotr = [];
	$(".check_groupotr:checked").each(function() {
		chkArrayotr.push($(this).val());
	});
	var selectedotr;
	selectedotr = chkArrayotr.join(',') + ",";
        
	/* check if there is selected checkboxes, by default the length is 1 as it contains one single comma */
	if(selectedval.length > 1 || selectedpar.length > 1 || selectedori.length > 1 || selectedotr.length > 1){        
            $("#opcion").val('GRABADUIS');
            $("#codigoconcatval").val(selectedval);
            $("#codigoconcatpar").val(selectedpar);
            $("#codigoconcatori").val(selectedori);
            $("#codigoconcatotr").val(selectedotr);
            $("#form-ampliacion").submit();
	}else{
            Anb.alert('Debe seleccionar por lo menos un ítem de las declaraciones para realizar esta acción.');
        }
    }
    
    function borrar_alcance(){
        Anb.confirm('¿Está seguro que desea eliminar todos los trámites ampliados del alcance?', function () {
            $("#opcionb").val('BORRAALL'); 
            $("#codigob").val($("#codigo").val());
            $("#form-alcance-borrar").submit();
        });
    }
    
    function consultar(){
        $("#opcion").val('CONSULTAR');    
    }
</script>