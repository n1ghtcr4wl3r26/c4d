function traer(enlace, mdiv)
{ var url = enlace;
  var pars = 't=1';
  mdiv.innerHTML = "Espere un instante mientras se cargan los datos...";  
  var myAjax = new Ajax.Updater({success: mdiv.id}, url, { method: 'get', parameters: pars, onFailure: error(mdiv.id)});
}

function error (mivar)
{ $(mivar).innerHTML = "<table width=100% cellspacing=4 cellpadding=2 border=0 style='padding:2px; border-spacing:4px;' ><tr><td align=right valign=middle>Espere mientras se carga la pagina ...</td> <td align=left></td></tr></table>";
}

function errorAnt (mivar)
{ $(mivar).innerHTML = "<table width=100% cellspacing=4 cellpadding=2 border=0 style='padding:2px; border-spacing:4px;' ><tr><td align=right valign=middle>Espere mientras se carga la pagina ...</td> <td align=left><img id=imgwait3 src='../../../img/wait3.gif'  ></img></td></tr></table>";
}

function ocultaTR(id){
	if(document.getElementById(id).style.display==""){
		document.getElementById(id).style.display="none";
	}else{
		document.getElementById(id).style.display="";
	}
}
//funcion de leo
function act_select(id,valor,indice){
   var s_campo=campo.split('-');
   var s_id_campo=idcampo.split(',');
   var sw=true;

   if(idcampo!='')  for(i=0;(i<s_id_campo.length)&&sw;i++){	if(s_id_campo[i]==id) sw=false; }
   if(sw){ // no esta
      if(idcampo=='') {campo=valor; idcampo=id;}
	  else{ campo+='-'+valor; idcampo+=','+id; }
	  document.getElementById("td_"+indice).style.background='#FFFFCC';
   }
   else{
      sw=false;
	  for(i=0;i<s_id_campo.length;i++){
	     if(s_id_campo[i]==id){
		    if(i==0) sw=true;
		 }else{
		   if(i==0||sw) { campo=s_campo[i]; idcampo=s_id_campo[i]; sw=false;}
		   else { campo+='-'+s_campo[i]; idcampo+=','+s_id_campo[i]; }
		 }
	  }	
	  document.getElementById("td_"+indice).style.background='#FFFFFF';		   
   }
}

//pinta bornes de caja (secundarios)
var vPosTDSecA = "-1";
var vColorPosTDSecA = "#FFFFFF";
function pintaBorneCajaSelect(vPosTDN){
	//vColorPosTDA = document.getElementById("d_td_sec_"+vPosTDA).style.background.value;
	
	document.getElementById("d_td_sec_" + vPosTDN).style.background = "#FFFFCC";
	
	if (vPosTDSecA != '-1' && vPosTDSecA != vPosTDN){
		document.getElementById("d_td_sec_" + vPosTDSecA).style.background = vColorPosTDSecA;
	}
	vPosTDSecA = vPosTDN;
}

//pinta primarios y enlace
var vPosTDPEA = "-1";
var vColorPosTDPEA = "#FFFFFF";
function pintaBornePEArmarioSelect(vPosTDN){
	document.getElementById("d_td_pe_" + vPosTDN).style.background = "#FFFFCC";
	
	if (vPosTDPEA != '-1' && vPosTDPEA != vPosTDN){
		document.getElementById("d_td_pe_" + vPosTDPEA).style.background = vColorPosTDPEA;
	}
	vPosTDPEA = vPosTDN;
}

//pinta solo primarios
var vPosTDPA = "-1";
var vColorPosTDPA = "#FFFFFF";
function pintaBornePArmarioSelect(vPosTDN){
	document.getElementById("d_td_p_" + vPosTDN).style.background = "#FFFFCC";
	
	if (vPosTDPA != '-1' && vPosTDPA != vPosTDN){
		document.getElementById("d_td_p_" + vPosTDPA).style.background = vColorPosTDPA;
	}
	vPosTDPA = vPosTDN;
}

//pinta pex bajada
var vPosTDBA = "-1";
var vColorPosTDBA = "#FFFFFF";
function pintaBorneBArmarioSelect(vPosTDN){
	document.getElementById("d_td_b_" + vPosTDN).style.background = "#FFFFCC";
	
	if (vPosTDBA != '-1' && vPosTDBA != vPosTDN){
		document.getElementById("d_td_b_" + vPosTDBA).style.background = vColorPosTDBA;
	}
	vPosTDBA = vPosTDN;
}

//pinta pex subida
var vPosTDSA = "-1";
var vColorPosTDSA = "#FFFFFF";
function pintaBorneSArmarioSelect(vPosTDN){
	document.getElementById("d_td_s_" + vPosTDN).style.background = "#FFFFCC";
	
	if (vPosTDSA != '-1' && vPosTDSA != vPosTDN){
		document.getElementById("d_td_s_" + vPosTDSA).style.background = vColorPosTDSA;
	}
	vPosTDSA = vPosTDN;
}

//pinta atm de dslam
var vPosTDAA = "-1";
var vColorPosTDAA = "#FFFFFF";
function pintaBorneSArmarioSelect(vPosTDN){
	document.getElementById("d_td_a_" + vPosTDN).style.background = "#FFFFCC";
	
	if (vPosTDAA != '-1' && vPosTDAA != vPosTDN){
		document.getElementById("d_td_a_" + vPosTDAA).style.background = vColorPosTDAA;
	}
	vPosTDAA = vPosTDN;
}

function limpiaSecundario(f){
	f.hdnIDBorneCaja.value	= "-1";
	f.txtSecundario.value	= "";
	
		f.hdnEtiquetaCaja.value			= "";
		f.hdnEtiquetaBorneCaja.value	= "";
	
	//limpia seleccion pintado
	if (vPosTDSecA != '-1'){
		document.getElementById("d_td_sec_"+vPosTDSecA).style.background = vColorPosTDSecA;
	}
	vPosTDSecA = "-1";
	vColorPosTDSecA = "#FFFFFF";
}

function limpiaResvTel(f){
	//f.hdnFlagIDArmario.value = "-3"; //aca no el control
	
	f.txtPrimarios.value	= "";
	f.txtMDFVPex.value		= "";
	f.txtFlujoTS.value		= "";
	f.txtNotas.value		= "";
	
	f.hdnIDPrimarios.value	= "-1";
	
		f.hdnEtiquetaArmario1.value	= "";
		f.hdnEtiquetaArmario2.value	= "";
		f.hdnEtiquetaArmario3.value	= "";
		f.hdnEtiquetaArmario4.value	= "";
		
		f.hdnEtiquetaBorneArmario1.value	= "";
		f.hdnEtiquetaBorneArmario2.value	= "";
		f.hdnEtiquetaBorneArmario3.value	= "";
		f.hdnEtiquetaBorneArmario4.value	= "";
	
	limpiaSecundario(f);
	
	//limpia seleccion pintado
	if (vPosTDPEA != '-1'){
		document.getElementById("d_td_pe_"+vPosTDPEA).style.background = vColorPosTDPEA;
	}
	vPosTDPEA = "-1";
	vColorPosTDPEA = "#FFFFFF";
}

function limpiaResvAdp(f){
	limpiaResvArmarioAdp(f);
	limpiaSecundario(f);
	limpiaResvDslamAdp(f);
}

function limpiaResvArmarioAdp(f){
	//f.hdnFlagIDArmario.value = "-3"; //aca no el control
	
	f.txtPrimarios.value	= "";
	f.txtMDFVPex.value		= "";
	//f.txtFlujoTS.value		= "";
	f.txtNotas.value		= "";
	
	f.txtParPexADSLB.value	= "";
	
	f.hdnIDPrimarios.value	= "-1";
	
		f.hdnEtiquetaArmario1.value	= "";
		f.hdnEtiquetaArmario2.value	= "";
		f.hdnEtiquetaArmario3.value	= "";
		f.hdnEtiquetaArmario4.value	= "";
		
		f.hdnEtiquetaBorneArmario1.value	= "";
		f.hdnEtiquetaBorneArmario2.value	= "";
		f.hdnEtiquetaBorneArmario3.value	= "";
		f.hdnEtiquetaBorneArmario4.value	= "";
	
	f.hdnIDArmarioSB.value	= "-1";
	f.hdnIDPEXADSLS.value	= "-1";
	f.hdnIDPEXADSLB.value	= "-1";
	f.hdnIDBorneDSLAM.value	= "-1";
	f.hdnIDBorneSPLV.value	= "-1";
							
	//limpia seleccion pintado
	if (vPosTDBA != '-1'){
		document.getElementById("d_td_b_"+vPosTDBA).style.background = vColorPosTDBA;
	}
	vPosTDBA = "-1";
	vColorPosTDBA = "#FFFFFF";
	
	if (vPosTDPA != '-1'){
		document.getElementById("d_td_p_"+vPosTDPA).style.background = vColorPosTDPA;
	}
	vPosTDPA = "-1";
	vColorPosTDPA = "#FFFFFF";
}

function limpiaResvDslamAdp(f){
	f.txtMDFHADSB.value		= "";
	
	//f.txtIPDSLAM.value	= "";
	//f.txtDSLAM.value	= "";
	//f.txtNodoADSL.value	= "";
	
	f.txtEtiquetaPuertoATM.value	= "";
	f.txtTipoPuertoATM.value	= "";
	f.txtParADSLB.value	= "";
	f.txtNotas.value		= "";

	f.hdnIDBorneDSLAM.value	= "-1";
	
	//limpia seleccion pintado
	if (vPosTDAA != '-1'){
		document.getElementById("d_td_a_"+vPosTDAA).style.background = vColorPosTDAA;
	}
	vPosTDAA = "-1";
	vColorPosTDAA = "#FFFFFF";
}

function limpiaArmarioTI(f){
	//f.hdnFlagIDArmario.value = "-3"; //aca no el control
	
	f.txtPrimarios.value	= "";
	f.txtMDFVPex.value		= "";
	f.txtFlujoTS.value	= "";
	f.txtNotas.value		= "";
	
	f.txtParPexADSLB.value	= "";
	f.txtParPexADSLS.value	= "";
	
	f.hdnIDPrimarios.value	= "-1";
	
		f.hdnEtiquetaArmario1.value	= "";
		f.hdnEtiquetaArmario2.value	= "";
		f.hdnEtiquetaArmario3.value	= "";
		f.hdnEtiquetaArmario4.value	= "";
		
		f.hdnEtiquetaBorneArmario1.value	= "";
		f.hdnEtiquetaBorneArmario2.value	= "";
		f.hdnEtiquetaBorneArmario3.value	= "";
		f.hdnEtiquetaBorneArmario4.value	= "";
	
	f.hdnIDArmarioSB.value	= "-1";
	f.hdnIDPEXADSLS.value	= "-1";
	f.hdnIDPEXADSLB.value	= "-1";
	f.hdnIDBorneDSLAM.value	= "-1";
	f.hdnIDBorneSPLV.value	= "-1";
							
	//limpia seleccion pintado
	if (vPosTDBA != '-1'){
		document.getElementById("d_td_b_"+vPosTDBA).style.background = vColorPosTDBA;
	}
	vPosTDBA = "-1";
	vColorPosTDBA = "#FFFFFF";
	
	if (vPosTDSA != '-1'){
		document.getElementById("d_td_b_"+vPosTDSA).style.background = vColorPosTDSA;
	}
	vPosTDSA = "-1";
	vColorPosTDSA = "#FFFFFF";
	
	if (vPosTDPEA != '-1'){
		document.getElementById("d_td_pe_"+vPosTDPEA).style.background = vColorPosTDPEA;
	}
	vPosTDPEA = "-1";
	vColorPosTDPEA = "#FFFFFF";
}

function limpiaDSLAMTI(f){
	f.txtMDFHADSB.value		= "";
	f.txtMDFHADSS.value		= "";
	
	//f.txtIPDSLAM.value	= "";
	//f.txtDSLAM.value	= "";
	//f.txtNodoADSL.value	= "";
	
	f.txtEtiquetaPuertoATM.value	= "";
	f.txtTipoPuertoATM.value	= "";
	f.txtParADSLB.value	= "";
	f.txtParADSLS.value	= "";
	f.txtNotas.value		= "";

	f.hdnIDBorneDSLAM.value	= "-1";
	
	//limpia seleccion pintado
	if (vPosTDAA != '-1'){
		document.getElementById("d_td_a_"+vPosTDAA).style.background = vColorPosTDAA;
	}
	vPosTDAA = "-1";
	vColorPosTDAA = "#FFFFFF";
}

function refrescaResvxCasoAdp(vCaso){
	var f = document.formDatosReserva;
	var vFlagIDArmario = f.hdnFlagIDArmario.value;
	
	f.txtTipoNodoADSL.value	= vCaso;
	limpiaResvArmarioAdp(f);
	//limpiaSecundario(f);
	limpiaResvDslamAdp(f);
	
	//traer combos dslam
	traer("select_resv_dslam.jsp?pCaso="+vCaso+"&armario="+vFlagIDArmario, document.getElementById("comboDslam"));
	document.getElementById("bornesDslam").style.display = "none";
	
	//traer bornes armario, guardar datos etiqueta
	if (vFlagIDArmario == '-3' || vFlagIDArmario == '-1' || vFlagIDArmario == '-2'){
		return;
	}
	
	traer("bornes_resv_adp_armario_peb.jsp?armario="+vFlagIDArmario+"&pCaso="+vCaso, document.getElementById("bornesArmario"));
	document.getElementById("bornesArmario").style.display = "";
}

function refrescaResvAdp(vFlagIDArmario){
	var f = document.formDatosReserva;
	var vCaso = f.txtTipoNodoADSL.value;
	
	limpiaResvArmarioAdp(f);
	limpiaSecundario(f);
	
	if (vFlagIDArmario == '-3'){
		f.hdnFlagIDArmario.value = "-3";
		document.getElementById("bornesCaja").style.display = "none";
		document.getElementById("bornesArmario").style.display = "none";
		document.getElementById("comboCaja").style.display = "none";
		
		traer("select_resv_dslam.jsp?pCaso="+vCaso+"&armario="+vFlagIDArmario, document.getElementById("comboDslam"));
		document.getElementById("bornesDslam").style.display = "none";
		limpiaResvDslamAdp(f);
		return;
	}
	
	f.hdnFlagIDArmario.value = vFlagIDArmario; //caso contrario de que no es -3
	
	document.getElementById("comboCaja").style.display = "";
	traer("select_resv_caja.jsp?armario="+vFlagIDArmario, document.getElementById("comboCaja"));
	
	document.getElementById("bornesCaja").style.display = "none";
	
	if (vFlagIDArmario != -2 && vFlagIDArmario != -1){
		traer("bornes_resv_adp_armario_peb.jsp?armario="+vFlagIDArmario+"&pCaso="+vCaso, document.getElementById("bornesArmario"));
		document.getElementById("bornesArmario").style.display = "";
		if (vCaso == 'REMOTO'){
			document.getElementById("comboDslam").style.display = "";
			traer("select_resv_dslam.jsp?pCaso="+vCaso+"&armario="+vFlagIDArmario, document.getElementById("comboDslam"));
			document.getElementById("bornesDslam").style.display = "none";
		}
	}else{
		document.getElementById("bornesArmario").style.display = "none";
		if (vCaso == 'REMOTO'){
			traer("select_resv_dslam.jsp?pCaso="+vCaso+"&armario="+vFlagIDArmario, document.getElementById("comboDslam"));
			limpiaResvDslamAdp(f);
			document.getElementById("bornesDslam").style.display = "none";
		}
	}
}

function refrescaArmaTI(vFlagIDArmario){
	var f = document.formDatosReserva;
	var vCaso = f.txtTipoNodoADSL.value;
	
	limpiaArmarioTI(f);
	limpiaSecundario(f);
	
	if (vFlagIDArmario == '-3'){
		f.hdnFlagIDArmario.value = "-3";
		document.getElementById("bornesCaja").style.display = "none";
		document.getElementById("bornesArmario").style.display = "none";
		document.getElementById("comboCaja").style.display = "none";
		
		traer("select_resv_dslam.jsp?pCaso="+vCaso+"&armario="+vFlagIDArmario, document.getElementById("comboDslam"));
		document.getElementById("bornesDslam").style.display = "none";
		limpiaDSLAMTI(f);
		return;
	}
	
	f.hdnFlagIDArmario.value = vFlagIDArmario; //caso contrario de que no es -3
	
	document.getElementById("comboCaja").style.display = "";
	traer("select_resv_caja.jsp?armario="+vFlagIDArmario, document.getElementById("comboCaja"));
	
	document.getElementById("bornesCaja").style.display = "none";
	
	if (vFlagIDArmario != -2 && vFlagIDArmario != -1){
		traer("bornes_ti_armario_pesb.jsp?armario="+vFlagIDArmario+"&pCaso="+vCaso, document.getElementById("bornesArmario"));
		document.getElementById("bornesArmario").style.display = "";
		if (vCaso == 'REMOTO'){
			document.getElementById("comboDslam").style.display = "";
			traer("select_resv_dslam.jsp?pCaso="+vCaso+"&armario="+vFlagIDArmario, document.getElementById("comboDslam"));
			document.getElementById("bornesDslam").style.display = "none";
		}
	}else{
		document.getElementById("bornesArmario").style.display = "none";
		if (vCaso == 'REMOTO'){
			traer("select_resv_dslam.jsp?pCaso="+vCaso+"&armario="+vFlagIDArmario, document.getElementById("comboDslam"));
			limpiaDSLAMTI(f);
			document.getElementById("bornesDslam").style.display = "none";
		}
	}
}

function refrescaResvDslam(vFlagIDDslam){
	var f = document.formDatosReserva;
	limpiaResvDslamAdp(f);
	
	if (vFlagIDDslam == '-1'){
		document.getElementById("bornesDslam").style.display = "none";
		return;
	}
	
	document.getElementById("bornesDslam").style.display = "";
	traer("bornes_resv_dslam.jsp?pIDDslam="+vFlagIDDslam, document.getElementById("bornesDslam"));
}

function refrescaDatosDSLAM(vEtiquetaNodoAdsl,
							vIDDslam, 
							vEtiquetaDslam, 
							vIPDslam
							){
	var f = document.formDatosReserva;
	
	f.txtIPDSLAM.value	= vIPDslam;
	f.txtDSLAM.value	= vEtiquetaDslam;
	f.txtNodoADSL.value	= vEtiquetaNodoAdsl;
	
}

function refrescaResvTel(vFlagIDArmario){
	var f = document.formDatosReserva;
	
	limpiaResvTel(f);
	
	if (vFlagIDArmario=='-3'){
		f.hdnFlagIDArmario.value = "-3";
		document.getElementById("bornesCaja").style.display = "none";
		document.getElementById("bornesArmario").style.display = "none";
		document.getElementById("comboCaja").style.display = "none";
		return;
	}
	
	f.hdnFlagIDArmario.value = vFlagIDArmario; //caso contrario de que no es -3
	
	document.getElementById("comboCaja").style.display = "";
	traer("select_resv_caja.jsp?armario="+vFlagIDArmario, document.getElementById("comboCaja"));
	
	document.getElementById("bornesCaja").style.display = "none";
	
	if (vFlagIDArmario != -2 && vFlagIDArmario != -1){
		traer("bornes_resv_tel_armario_pe.jsp?armario="+vFlagIDArmario, document.getElementById("bornesArmario"));
		document.getElementById("bornesArmario").style.display = "";
	}else{
		document.getElementById("bornesArmario").style.display = "none";
	}
}

function refrescaResvCaja(vFlagIDCaja,
							vFlagIDArmario){
	
	var f = document.formDatosReserva;
	//alert(vFlagIDCaja);
	//alert(vFlagIDArmario);
	limpiaSecundario(f);
	
	if (vFlagIDArmario == '-1' || vFlagIDArmario == '-2') {
		f.txtMDFVPex.value = "";
	}
	
	if (vFlagIDCaja == '-1'){
		bornesCaja.style.display = "none";
		return;
	}
	
	document.getElementById("bornesCaja").style.display = "";
	traer("bornes_resv_caja.jsp?idcaja="+vFlagIDCaja, document.getElementById("bornesCaja"));
}

//pares primarios, enlace desde otro armario, mdfv pex, fts
function ponParesPrimariosAdp(vEtiquetaArmario,
							vIDBorneArmario,
							vEtiquetaBorne,
							vDescBorne,
							vTipoBorne,
							vMDFVPex,
							vIDArmarioOrigen,
							vEtiquetaArmarioOrigen){
	
	//var f = document.getElementById("formDatosReserva");
	var f = document.formDatosReserva;

	if(vTipoBorne=='ENLD'){
		f.hdnIDPrimarios.value		= "-1";
		f.txtPrimarios.value		= "";
		f.txtMDFVPex.value			= "";
		//f.txtFlujoTS.value			= "";
		
		f.hdnEtiquetaArmario1.value	= "";
		f.hdnEtiquetaArmario2.value	= "";
		f.hdnEtiquetaArmario3.value	= "";
		f.hdnEtiquetaArmario4.value	= "";
		
		f.hdnEtiquetaBorneArmario1.value	= "";
		f.hdnEtiquetaBorneArmario2.value	= "";
		f.hdnEtiquetaBorneArmario3.value	= "";
		f.hdnEtiquetaBorneArmario4.value	= "";
		
		var h = 600;
		var w = 600;
		var winl = (screen.width-w)/2;
		var wint = (screen.height-h)/2;
		var settings ='height='+h+',';
		settings+='width='+w+',';
		settings+='top='+wint+',';
		settings+='left='+winl+',';
		settings+='scrollbars=yes,';
		settings+='resizable=yes';
		
		win=window.open('bornes_resv_adp_armario_lk.jsp?armario='+vIDArmarioOrigen+'&etiqueta='+vEtiquetaArmarioOrigen+'&pDescBorne='+vDescBorne+'&pIDBorne='+vIDBorneArmario+'&pEtiquetaArmaA='+vEtiquetaArmario+'&pEtiquetaBorneA='+vEtiquetaBorne+'&pCount=1', 'enlaces',settings);
	}
	else{
		f.hdnIDPrimarios.value	= vIDBorneArmario;
		f.txtPrimarios.value	= vDescBorne;
		f.txtMDFVPex.value		= vMDFVPex;
		//f.txtFlujoTS.value		= vFlujoTS;
		
		f.hdnEtiquetaArmario1.value	= vEtiquetaArmario;
		f.hdnEtiquetaArmario2.value	= "";
		f.hdnEtiquetaArmario3.value	= "";
		f.hdnEtiquetaArmario4.value	= "";
		
		f.hdnEtiquetaBorneArmario1.value	= vEtiquetaBorne;
		f.hdnEtiquetaBorneArmario2.value	= "";
		f.hdnEtiquetaBorneArmario3.value	= "";
		f.hdnEtiquetaBorneArmario4.value	= "";
	}
}

//pares primarios, enlace desde otro armario, mdfv pex, fts
function ponParesPrimarios(vEtiquetaArmario,
							vIDBorneArmario,
							vEtiquetaBorne,
							vDescBorne,
							vTipoBorne,
							vMDFVPex,
							vFlujoTS,
							vIDArmarioOrigen,
							vEtiquetaArmarioOrigen){
	
	//var f = document.getElementById("formDatosReserva");
	var f = document.formDatosReserva;
	
	if(vTipoBorne=='ENLD'){
		f.hdnIDPrimarios.value		= "-1";
		f.txtPrimarios.value		= "";
		f.txtMDFVPex.value			= "";
		f.txtFlujoTS.value			= "";
		
		f.hdnEtiquetaArmario1.value	= "";
		f.hdnEtiquetaArmario2.value	= "";
		f.hdnEtiquetaArmario3.value	= "";
		f.hdnEtiquetaArmario4.value	= "";
		
		f.hdnEtiquetaBorneArmario1.value	= "";
		f.hdnEtiquetaBorneArmario2.value	= "";
		f.hdnEtiquetaBorneArmario3.value	= "";
		f.hdnEtiquetaBorneArmario4.value	= "";
		
		var h = 600;
		var w = 600;
		var winl = (screen.width-w)/2;
		var wint = (screen.height-h)/2;
		var settings ='height='+h+',';
		settings+='width='+w+',';
		settings+='top='+wint+',';
		settings+='left='+winl+',';
		settings+='scrollbars=yes,';
		settings+='resizable=yes';
		
		win=window.open('bornes_resv_tel_armario_lk.jsp?armario='+vIDArmarioOrigen+'&etiqueta='+vEtiquetaArmarioOrigen+'&pDescBorne='+vDescBorne+'&pIDBorne='+vIDBorneArmario+'&pEtiquetaArmaA='+vEtiquetaArmario+'&pEtiquetaBorneA='+vEtiquetaBorne+'&pCount=1', 'enlaces',settings);
	}
	else{
		f.hdnIDPrimarios.value	= vIDBorneArmario;
		f.txtPrimarios.value	= vDescBorne;
		f.txtMDFVPex.value		= vMDFVPex;
		f.txtFlujoTS.value		= vFlujoTS;
		
		f.hdnEtiquetaArmario1.value	= vEtiquetaArmario;
		f.hdnEtiquetaArmario2.value	= "";
		f.hdnEtiquetaArmario3.value	= "";
		f.hdnEtiquetaArmario4.value	= "";
		
		f.hdnEtiquetaBorneArmario1.value	= vEtiquetaBorne;
		f.hdnEtiquetaBorneArmario2.value	= "";
		f.hdnEtiquetaBorneArmario3.value	= "";
		f.hdnEtiquetaBorneArmario4.value	= "";
	}
}

function ponParPexBajada(vIDArmario,
							vEtiquetaArmario,
							vIDBorneArmario,
							vEtiquetaBorne,
							vDescBorne){
	var f = document.formDatosReserva;
	f.txtParPexADSLB.value	= vDescBorne;
	f.hdnIDArmarioSB.value	= vIDArmario;
	f.hdnIDPEXADSLB.value	= vIDBorneArmario;
}

function ponParPexSubida(vIDArmario,
							vEtiquetaArmario,
							vIDBorneArmario,
							vEtiquetaBorne,
							vDescBorne){
	var f = document.formDatosReserva;
	f.txtParPexADSLS.value	= vDescBorne;
	f.hdnIDArmarioSB.value	= vIDArmario;
	f.hdnIDPEXADSLS.value	= vIDBorneArmario;
}

function ponPuertoATMADSP(vIDPuertoATM,
							vEtiquetaPuertoATM,
							vTipoPuertoATM,
							vParADSB,
							vMDFHB){
	var f = document.formDatosReserva;
	
	f.txtMDFHADSB.value		= vMDFHB;
	f.txtEtiquetaPuertoATM.value	= vEtiquetaPuertoATM;
	f.txtTipoPuertoATM.value	= vTipoPuertoATM;
	f.txtParADSLB.value	= vParADSB;

	f.hdnIDBorneDSLAM.value	= vIDPuertoATM;
}

function  ponParSecundario(vEtiquetaCaja,
							vIDBorne,
							vEtiquetaBorne,
							vDescBorne,
							vMDFVPex, 
							vRed){
	var	f = document.formDatosReserva;
	//alert(vRed);
	f.txtSecundario.value	= vDescBorne;
	
	f.hdnIDBorneCaja.value	= vIDBorne;
	
	f.hdnEtiquetaCaja.value			= vEtiquetaCaja;
	f.hdnEtiquetaBorneCaja.value	= vEtiquetaBorne;
	
	if (vRed =='Rigida' || vRed =='Otros') {
		f.txtMDFVPex.value = vMDFVPex;
	}
}


function  PonPrimario(idBorne,primario,borne,tipo,pos_mdf,flu_ts,armario_origen,etiqueta)
{	var f = document.mainreserva;	// form que se visualiza
	var h = document.mainform;
	//----- la seleccion de las  instaciones -------------

	h.primarios.value='';	// limpiando si hay mas primarios de otraselleccion !
	f.par_primario1.value=borne;


	f.nom_armario1.value=mainformCaja.etiqueta.value;

	//----------- para enlaces a otros arm-
	if(tipo=='ENLD'){
		var h = 600;
		var w = 600;
		var winl = (screen.width-w)/2;
		var wint = (screen.height-h)/2;
		var settings ='height='+h+',';
		settings+='width='+w+',';
		settings+='top='+wint+',';
		settings+='left='+winl+',';
		settings+='scrollbars=yes,';
		settings+='resizable=yes';
		win=window.open('enlaces.jsp?armario='+armario_origen+'&etiqueta='+etiqueta+'&primario='+primario+'&idBorne='+idBorne+'&num_e=1','enlaces',settings);
		var	me = document.mainform;
		if (me.armario.value==0)	return ;
	}
	else{	f.id_borne_armario.value=idBorne;
			f.primario.value=('Arm:'+mainform.etiqueta.value + '  Par:' +borne);
			f.add_primario.value=('Arm:'+mainformCaja.etiqueta.value + '  Par:' +borne);
			f.add_pos_mdf.value = 	pos_mdf;
			f.add_flu_ts.value 	= 	flu_ts;
		}
}

function  PonSecundario(idBorne,etiqueta,mdfv, borne)
{	var	h = document.mainreserva
	h.nom_caja.value=mainform.etiqueta.value;
	h.id_borne_caja.value=idBorne;
	h.par_caja.value=borne;
	h.secundario.value=etiqueta;
	h.add_secundario.value=etiqueta;
	if(h.add_pos_mdf.value=='')
	{h.add_pos_mdf.value=mdfv;}
}


function onlyAlnum2 (field)   // esto  ya no se usara
{	return ;
	var tmp = "";
	i=0;
	field.value = field.value.toUpperCase();
	for (i=0; i<field.value.length; i++)
	{
		if ((field.value.charAt(i)>='A' && field.value.charAt(i)<='Z')
			|| (field.value.charAt(i)>='0' && field.value.charAt(i)<='9')
			|| field.value.charAt(i)==' '
			|| field.value.charAt(i)=='.'
			|| field.value.charAt(i)=='-'
			|| field.value.charAt(i)=='@'
			|| field.value.charAt(i)=='/')
			tmp+= ""+field.value.charAt(i);
	}
}

function enviaResvTel(f,
						vCircuito){
	//validamos si se selecciono algun recurso
	if (f.hdnFlagIDArmario.value == '-3'){
		alert("Seleccione algún Recurso");
		return;
	}else{
		if (f.hdnFlagIDArmario.value > 0){
			if (f.hdnIDPrimarios.value == '-1'){
				alert("Necesita Seleccionar Par Primario");
				return;
			}
		}
	}
	
	//se valida si caja fue seleccionado
	if (f.hdnIDBorneCaja.value=='-1'){
		alert("Necesita Seleccionar Par Secundario");
		return;
	}
	
    //
    //variables para provisionar
	parent.opener.document.all.item('id_borne_armario').value	= f.hdnIDPrimarios.value;
    parent.opener.document.all.item('id_borne_caja').value		= f.hdnIDBorneCaja.value;
    parent.opener.document.all.item('idnotas').value			= f.txtNotas.value;
    parent.opener.document.all.item('obs').value				= f.txtNotas.value;
	
    //
    //variables adicionales (ocultas)
    parent.opener.document.all.item('primario').value	= f.txtPrimarios.value;
    parent.opener.document.all.item('secundario').value	=f.txtSecundario.value;
    
	//
	//variables para mostrar
		//alambrico
		parent.opener.document.all.item('p1_al_enlace_caja').value		= f.hdnEtiquetaCaja.value ;
		parent.opener.document.all.item('p1_al_enlace_par_caja').value  = f.hdnEtiquetaBorneCaja.value ;
		
	    parent.opener.document.all.item('p1_al_mdf').value  = f.txtMDFVPex.value ;
	    
		parent.opener.document.all.item('p1_al_enlace_nodo1').value  = f.hdnEtiquetaArmario1.value ;
		parent.opener.document.all.item('p1_al_enlace_par_nodo1').value  = f.hdnEtiquetaBorneArmario1.value ;
		if (f.hdnEtiquetaArmario2.value != ''){
			parent.opener.document.all.item('al_enlace_2').style.display = "";
			parent.opener.document.all.item('p1_al_enlace_nodo2').value  = f.hdnEtiquetaArmario2.value ;
			parent.opener.document.all.item('p1_al_enlace_par_nodo2').value  = f.hdnEtiquetaBorneArmario2.value ;
		}
		if (f.hdnEtiquetaArmario3.value != ''){
			parent.opener.document.all.item('al_enlace_3').style.display = "";
			parent.opener.document.all.item('p1_al_enlace_nodo3').value  = f.hdnEtiquetaArmario3.value ;
			parent.opener.document.all.item('p1_al_enlace_par_nodo3').value  = f.hdnEtiquetaBorneArmario3.value ;
		}
		if (f.hdnEtiquetaArmario4.value != ''){
			parent.opener.document.all.item('al_enlace_4').style.display = "";
			parent.opener.document.all.item('p1_al_enlace_nodo4').value  = f.hdnEtiquetaArmario4.value ;
			parent.opener.document.all.item('p1_al_enlace_par_nodo4').value  = f.hdnEtiquetaBorneArmario4.value ;
		}
	
	    //fibra
	    parent.opener.document.all.item('p1_alfo_enlace_caja').value  = f.hdnEtiquetaCaja.value ;
	    parent.opener.document.all.item('p1_alfo_enlace_par_caja').value  = f.hdnEtiquetaBorneCaja.value ;
	    
	    parent.opener.document.all.item('p1_alfo_mdf').value  = f.txtMDFVPex.value ;
	    
	    parent.opener.document.all.item('p1_alfo_enlace_nodo1').value  = f.hdnEtiquetaArmario1.value ;
		parent.opener.document.all.item('p1_alfo_enlace_par_nodo1').value  = f.hdnEtiquetaBorneArmario1.value ;
	    if (f.hdnEtiquetaArmario2.value != ''){
			parent.opener.document.all.item('alfo_enlace_2').style.display = "";
			parent.opener.document.all.item('p1_alfo_enlace_nodo2').value  = f.hdnEtiquetaArmario2.value ;
			parent.opener.document.all.item('p1_alfo_enlace_par_nodo2').value  = f.hdnEtiquetaBorneArmario2.value ;
		}
		if (f.hdnEtiquetaArmario3.value != ''){
			parent.opener.document.all.item('alfo_enlace_3').style.display = "";
			parent.opener.document.all.item('p1_alfo_enlace_nodo3').value  = f.hdnEtiquetaArmario3.value ;
			parent.opener.document.all.item('p1_alfo_enlace_par_nodo3').value  = f.hdnEtiquetaBorneArmario3.value ;
		}
		if (f.hdnEtiquetaArmario4.value != ''){
			parent.opener.document.all.item('alfo_enlace_4').style.display = "";
			parent.opener.document.all.item('p1_alfo_enlace_nodo4').value  = f.hdnEtiquetaArmario4.value ;
			parent.opener.document.all.item('p1_alfo_enlace_par_nodo4').value  = f.hdnEtiquetaBorneArmario4.value ;
		}
    
    //
    //variables con operaciones adicionales (visibles)
    if(f.txtFlujoTS.value.length  != 0){
    	//alambrico
    	parent.opener.document.all.item('p1_al_annff').value 	= f.txtFlujoTS.value.split("-")[0];
    	//fibra optica
    	parent.opener.document.all.item('p1_alfo_annff').value 	= f.txtFlujoTS.value.split("-")[0];
	}else{
		//alambrico
		parent.opener.document.all.item('p1_al_annff').value	= "";
		//fibra optica
		parent.opener.document.all.item('p1_alfo_annff').value	= "";
	}
	if(f.txtFlujoTS.value.length  != 0){
		//alambrico
		parent.opener.document.all.item('p1_al_time_slot').value	= f.txtFlujoTS.value.split("-")[1];
		//fibra optica
		parent.opener.document.all.item('p1_alfo_time_slot').value	= f.txtFlujoTS.value.split("-")[1];
	}else{
		//alambrico
		parent.opener.document.all.item('p1_al_time_slot').value	= "";
		//fibra
		parent.opener.document.all.item('p1_alfo_time_slot').value	= "";
	}
	
	//
	//variables de adsl para provisionar
	parent.opener.document.all.item('id_armario_sb').value		= f.hdnIDArmarioSB.value;
	parent.opener.document.all.item('id_ADSL_subida').value		= f.hdnIDPEXADSLS.value;
	parent.opener.document.all.item('id_ADSL_bajada').value		= f.hdnIDPEXADSLB.value;
	
	parent.opener.document.all.item('id_borne_ADSL').value		= f.hdnIDBorneDSLAM.value;
 	parent.opener.document.all.item('id_borne_splitter').value	= f.hdnIDBorneSPLV.value;
 	
		//alambrico
		//parent.opener.document.all.item('p1_adsl_ip_dslm1').value	= f.txtIPDSLAM.value;
		//parent.opener.document.all.item('p1_adsl_puerto1').value	= f.txtEtiquetaPuertoATM.value;
		//parent.opener.document.all.item('p1_adsl_par_dslm1').value	= f.txtParADSLS.value + '/' + f.txtParADSLB.value;
		//parent.opener.document.all.item('p1_adsl_spliter1').value	= f.txtEtiquetaBorneSplitter.value;
		//parent.opener.document.all.item('p1_adsl_pex11').value		= f.txtParPexADSLS.value;
		//parent.opener.document.all.item('p1_adsl_pex21').value		= f.txtParPexADSLB.value;
		
		//Fibra Optica
		//parent.opener.document.all.item('p1_adsl_ip_dslm2').value	= f.txtIPDSLAM.value;
		//parent.opener.document.all.item('p1_adsl_puerto2').value	= f.txtEtiquetaPuertoATM.value;
		//parent.opener.document.all.item('p1_adsl_par_dslm2').value	= f.txtParADSLS.value + '/' + f.txtParADSLB.value;
		//parent.opener.document.all.item('p1_adsl_spliter2').value	= f.txtEtiquetaBorneSplitter.value;
		//parent.opener.document.all.item('p1_adsl_pex12').value		= f.txtParPexADSLS.value;
		//parent.opener.document.all.item('p1_adsl_pex22').value		= f.txtParPexADSLB.value;
	
    //
	parent.close();
}

function enviaResvAdp(f){
	//validamos si se selecciono algun recurso
	if (f.hdnFlagIDArmario.value == '-3'){
		alert("Seleccione algún Recurso");
		return;
	}else{
		if (f.hdnFlagIDArmario.value > 0){
			if (f.txtTipoNodoADSL.value == 'CENTRAL'){
				if (f.hdnIDPrimarios.value == '-1'){
					alert("Necesita Seleccionar Par Primario");
					return;
				}
			}else{
				if (f.hdnIDPEXADSLB.value == '-1'){
					alert("Necesita Seleccionar Par de Bajada");
					return;
				}
			}
		}
	}
	
	//se valida si caja fue seleccionado
	if (f.hdnIDBorneDSLAM.value=='-1'){
		alert("Necesita Seleccionar Puerto ATM (DSLAM)");
		return;
	}
	
	//se valida si caja fue seleccionado
	if (f.hdnIDBorneCaja.value=='-1'){
		alert("Necesita Seleccionar Par Secundario");
		return;
	}
	
    //
    //variables para provisionar
	parent.opener.document.all.item('id_borne_armario').value	= f.hdnIDPrimarios.value;
    parent.opener.document.all.item('id_borne_caja').value		= f.hdnIDBorneCaja.value;
    parent.opener.document.all.item('idnotas').value			= f.txtNotas.value;
    parent.opener.document.all.item('obs').value				= f.txtNotas.value;
	
    //
    //variables adicionales (ocultas)
    parent.opener.document.all.item('primario').value	= f.txtPrimarios.value;
    parent.opener.document.all.item('secundario').value	=f.txtSecundario.value;
    
	//
	//variables para mostrar
		//alambrico
		parent.opener.document.all.item('p1_al_enlace_caja').value		= f.hdnEtiquetaCaja.value ;
		parent.opener.document.all.item('p1_al_enlace_par_caja').value  = f.hdnEtiquetaBorneCaja.value ;
		
	    parent.opener.document.all.item('p1_al_mdf').value  = f.txtMDFVPex.value ;
	    
		parent.opener.document.all.item('p1_al_enlace_nodo1').value  = f.hdnEtiquetaArmario1.value ;
		parent.opener.document.all.item('p1_al_enlace_par_nodo1').value  = f.hdnEtiquetaBorneArmario1.value ;
		if (f.hdnEtiquetaArmario2.value != ''){
			parent.opener.document.all.item('al_enlace_2').style.display = "";
			parent.opener.document.all.item('p1_al_enlace_nodo2').value  = f.hdnEtiquetaArmario2.value ;
			parent.opener.document.all.item('p1_al_enlace_par_nodo2').value  = f.hdnEtiquetaBorneArmario2.value ;
		}
		if (f.hdnEtiquetaArmario3.value != ''){
			parent.opener.document.all.item('al_enlace_3').style.display = "";
			parent.opener.document.all.item('p1_al_enlace_nodo3').value  = f.hdnEtiquetaArmario3.value ;
			parent.opener.document.all.item('p1_al_enlace_par_nodo3').value  = f.hdnEtiquetaBorneArmario3.value ;
		}
		if (f.hdnEtiquetaArmario4.value != ''){
			parent.opener.document.all.item('al_enlace_4').style.display = "";
			parent.opener.document.all.item('p1_al_enlace_nodo4').value  = f.hdnEtiquetaArmario4.value ;
			parent.opener.document.all.item('p1_al_enlace_par_nodo4').value  = f.hdnEtiquetaBorneArmario4.value ;
		}
	
	    //fibra
	    parent.opener.document.all.item('p1_alfo_enlace_caja').value  = f.hdnEtiquetaCaja.value ;
	    parent.opener.document.all.item('p1_alfo_enlace_par_caja').value  = f.hdnEtiquetaBorneCaja.value ;
	    
	    parent.opener.document.all.item('p1_alfo_mdf').value  = f.txtMDFVPex.value ;
	    
	    parent.opener.document.all.item('p1_alfo_enlace_nodo1').value  = f.hdnEtiquetaArmario1.value ;
		parent.opener.document.all.item('p1_alfo_enlace_par_nodo1').value  = f.hdnEtiquetaBorneArmario1.value ;
	    if (f.hdnEtiquetaArmario2.value != ''){
			parent.opener.document.all.item('alfo_enlace_2').style.display = "";
			parent.opener.document.all.item('p1_alfo_enlace_nodo2').value  = f.hdnEtiquetaArmario2.value ;
			parent.opener.document.all.item('p1_alfo_enlace_par_nodo2').value  = f.hdnEtiquetaBorneArmario2.value ;
		}
		if (f.hdnEtiquetaArmario3.value != ''){
			parent.opener.document.all.item('alfo_enlace_3').style.display = "";
			parent.opener.document.all.item('p1_alfo_enlace_nodo3').value  = f.hdnEtiquetaArmario3.value ;
			parent.opener.document.all.item('p1_alfo_enlace_par_nodo3').value  = f.hdnEtiquetaBorneArmario3.value ;
		}
		if (f.hdnEtiquetaArmario4.value != ''){
			parent.opener.document.all.item('alfo_enlace_4').style.display = "";
			parent.opener.document.all.item('p1_alfo_enlace_nodo4').value  = f.hdnEtiquetaArmario4.value ;
			parent.opener.document.all.item('p1_alfo_enlace_par_nodo4').value  = f.hdnEtiquetaBorneArmario4.value ;
		}
    
    //
    //variables con operaciones adicionales (visibles)
    //if(f.txtFlujoTS.value.length  != 0){
    //	//alambrico
    //	parent.opener.document.all.item('p1_al_annff').value 	= f.txtFlujoTS.value.split("-")[0];
    //	//fibra optica
    //	parent.opener.document.all.item('p1_alfo_annff').value 	= f.txtFlujoTS.value.split("-")[0];
	//}else{
	//	//alambrico
	//	parent.opener.document.all.item('p1_al_annff').value	= "";
	//	//fibra optica
	//	parent.opener.document.all.item('p1_alfo_annff').value	= "";
	//}
	//if(f.txtFlujoTS.value.length  != 0){
	//	//alambrico
	//	parent.opener.document.all.item('p1_al_time_slot').value	= f.txtFlujoTS.value.split("-")[1];
	//	//fibra optica
	//	parent.opener.document.all.item('p1_alfo_time_slot').value	= f.txtFlujoTS.value.split("-")[1];
	//}else{
	//	//alambrico
	//	parent.opener.document.all.item('p1_al_time_slot').value	= "";
	//	//fibra
	//	parent.opener.document.all.item('p1_alfo_time_slot').value	= "";
	//}
	
	//
	//variables de adsl para provisionar
	parent.opener.document.all.item('id_armario_sb').value		= f.hdnIDArmarioSB.value;
	parent.opener.document.all.item('id_ADSL_subida').value		= f.hdnIDPEXADSLS.value;
	parent.opener.document.all.item('id_ADSL_bajada').value		= f.hdnIDPEXADSLB.value;
	
	parent.opener.document.all.item('id_borne_ADSL').value		= f.hdnIDBorneDSLAM.value;
 	parent.opener.document.all.item('id_borne_splitter').value	= f.hdnIDBorneSPLV.value;
 	
		//alambrico
		parent.opener.document.all.item('p1_adsl_ip_dslm1').value	= f.txtIPDSLAM.value;
		parent.opener.document.all.item('p1_adsl_puerto1').value	= f.txtEtiquetaPuertoATM.value;
		//parent.opener.document.all.item('p1_adsl_par_dslm1').value	= f.txtParADSLS.value + '/' + f.txtParADSLB.value;
		parent.opener.document.all.item('p1_adsl_par_dslm1').value	= f.txtParADSLB.value;
		//parent.opener.document.all.item('p1_adsl_spliter1').value	= f.txtEtiquetaBorneSplitter.value;
		parent.opener.document.all.item('p1_adsl_spliter1').value	= "";
		//parent.opener.document.all.item('p1_adsl_pex11').value		= f.txtParPexADSLS.value;
		parent.opener.document.all.item('p1_adsl_pex11').value		= "";
		parent.opener.document.all.item('p1_adsl_pex21').value		= f.txtParPexADSLB.value;
		
		//Fibra Optica
		parent.opener.document.all.item('p1_adsl_ip_dslm2').value	= f.txtIPDSLAM.value;
		parent.opener.document.all.item('p1_adsl_puerto2').value	= f.txtEtiquetaPuertoATM.value;
		//parent.opener.document.all.item('p1_adsl_par_dslm2').value	= f.txtParADSLS.value + '/' + f.txtParADSLB.value;
		parent.opener.document.all.item('p1_adsl_par_dslm2').value	= f.txtParADSLB.value;
		//parent.opener.document.all.item('p1_adsl_spliter2').value	= f.txtEtiquetaBorneSplitter.value;
		parent.opener.document.all.item('p1_adsl_spliter2').value	= "";
		//parent.opener.document.all.item('p1_adsl_pex12').value		= f.txtParPexADSLS.value;
		parent.opener.document.all.item('p1_adsl_pex12').value		= "";
		parent.opener.document.all.item('p1_adsl_pex22').value		= f.txtParPexADSLB.value;
	
	//parent.opener.document.all.item('p1_MDFVPex').value	= f.txtMDFVPex.value;
	//parent.opener.document.all.item('p1_MDFHADSS').value	= f.txtMDFHADSS.value;
	parent.opener.document.all.item('p1_MDFHADSB').value	= f.txtMDFHADSB.value;
	parent.opener.document.all.item('p1_DSLAM').value		= f.txtDSLAM.value;
	parent.opener.document.all.item('p1_NodoADSL').value	= f.txtNodoADSL.value;
	parent.opener.document.all.item('p1_TipoNodoADSL').value	= f.txtTipoNodoADSL.value;
	parent.opener.document.all.item('p1_TipoPuertoATM').value	= f.txtTipoPuertoATM.value;
	//parent.opener.document.all.item('p1_ParADSLS').value	= f.txtParADSLS.value;
	parent.opener.document.all.item('p1_ParADSLS').value	= "";
	parent.opener.document.all.item('p1_ParADSLB').value	= f.txtParADSLB.value;

    //
	parent.close();
}

function enviaTI(f){
	//validamos si se selecciono algun recurso
	if (f.hdnFlagIDArmario.value == '-3'){
		alert("Seleccione algún Recurso");
		return;
	}else{
		if (f.hdnFlagIDArmario.value > 0){
			if (f.txtTipoNodoADSL.value == 'CENTRAL'){
				if (f.hdnIDPrimarios.value == '-1'){
					alert("Necesita Seleccionar Par Primario");
					return;
				}
			}else{
				if (f.hdnIDPEXADSLB.value == '-1'){
					alert("Necesita Seleccionar Par de Bajada");
					return;
				}
			}
		}
	}
	
	//se valida si caja fue seleccionado
	if (f.hdnIDBorneDSLAM.value=='-1'){
		alert("Necesita Seleccionar Puerto ATM (DSLAM)");
		return;
	}
	
	//se valida si caja fue seleccionado
	if (f.hdnIDBorneCaja.value=='-1'){
		alert("Necesita Seleccionar Par Secundario");
		return;
	}
	
    //
    //variables para provisionar
	parent.opener.document.all.item('id_borne_armario').value	= f.hdnIDPrimarios.value;
    parent.opener.document.all.item('id_borne_caja').value		= f.hdnIDBorneCaja.value;
    parent.opener.document.all.item('idnotas').value			= f.txtNotas.value;
    parent.opener.document.all.item('obs').value				= f.txtNotas.value;
	
    //
    //variables adicionales (ocultas)
    parent.opener.document.all.item('primario').value	= f.txtPrimarios.value;
    parent.opener.document.all.item('secundario').value	=f.txtSecundario.value;
    
	//
	//variables para mostrar
		//alambrico
		parent.opener.document.all.item('p1_al_enlace_caja').value		= f.hdnEtiquetaCaja.value ;
		parent.opener.document.all.item('p1_al_enlace_par_caja').value  = f.hdnEtiquetaBorneCaja.value ;
		
	    parent.opener.document.all.item('p1_al_mdf').value  = f.txtMDFVPex.value ;
	    
		parent.opener.document.all.item('p1_al_enlace_nodo1').value  = f.hdnEtiquetaArmario1.value ;
		parent.opener.document.all.item('p1_al_enlace_par_nodo1').value  = f.hdnEtiquetaBorneArmario1.value ;
		if (f.hdnEtiquetaArmario2.value != ''){
			parent.opener.document.all.item('al_enlace_2').style.display = "";
			parent.opener.document.all.item('p1_al_enlace_nodo2').value  = f.hdnEtiquetaArmario2.value ;
			parent.opener.document.all.item('p1_al_enlace_par_nodo2').value  = f.hdnEtiquetaBorneArmario2.value ;
		}
		if (f.hdnEtiquetaArmario3.value != ''){
			parent.opener.document.all.item('al_enlace_3').style.display = "";
			parent.opener.document.all.item('p1_al_enlace_nodo3').value  = f.hdnEtiquetaArmario3.value ;
			parent.opener.document.all.item('p1_al_enlace_par_nodo3').value  = f.hdnEtiquetaBorneArmario3.value ;
		}
		if (f.hdnEtiquetaArmario4.value != ''){
			parent.opener.document.all.item('al_enlace_4').style.display = "";
			parent.opener.document.all.item('p1_al_enlace_nodo4').value  = f.hdnEtiquetaArmario4.value ;
			parent.opener.document.all.item('p1_al_enlace_par_nodo4').value  = f.hdnEtiquetaBorneArmario4.value ;
		}
	
	    //fibra
	    parent.opener.document.all.item('p1_alfo_enlace_caja').value  = f.hdnEtiquetaCaja.value ;
	    parent.opener.document.all.item('p1_alfo_enlace_par_caja').value  = f.hdnEtiquetaBorneCaja.value ;
	    
	    parent.opener.document.all.item('p1_alfo_mdf').value  = f.txtMDFVPex.value ;
	    
	    parent.opener.document.all.item('p1_alfo_enlace_nodo1').value  = f.hdnEtiquetaArmario1.value ;
		parent.opener.document.all.item('p1_alfo_enlace_par_nodo1').value  = f.hdnEtiquetaBorneArmario1.value ;
	    if (f.hdnEtiquetaArmario2.value != ''){
			parent.opener.document.all.item('alfo_enlace_2').style.display = "";
			parent.opener.document.all.item('p1_alfo_enlace_nodo2').value  = f.hdnEtiquetaArmario2.value ;
			parent.opener.document.all.item('p1_alfo_enlace_par_nodo2').value  = f.hdnEtiquetaBorneArmario2.value ;
		}
		if (f.hdnEtiquetaArmario3.value != ''){
			parent.opener.document.all.item('alfo_enlace_3').style.display = "";
			parent.opener.document.all.item('p1_alfo_enlace_nodo3').value  = f.hdnEtiquetaArmario3.value ;
			parent.opener.document.all.item('p1_alfo_enlace_par_nodo3').value  = f.hdnEtiquetaBorneArmario3.value ;
		}
		if (f.hdnEtiquetaArmario4.value != ''){
			parent.opener.document.all.item('alfo_enlace_4').style.display = "";
			parent.opener.document.all.item('p1_alfo_enlace_nodo4').value  = f.hdnEtiquetaArmario4.value ;
			parent.opener.document.all.item('p1_alfo_enlace_par_nodo4').value  = f.hdnEtiquetaBorneArmario4.value ;
		}
    
    //
    //variables con operaciones adicionales (visibles)
    //if(f.txtFlujoTS.value.length  != 0){
    //	//alambrico
    //	parent.opener.document.all.item('p1_al_annff').value 	= f.txtFlujoTS.value.split("-")[0];
    //	//fibra optica
    //	parent.opener.document.all.item('p1_alfo_annff').value 	= f.txtFlujoTS.value.split("-")[0];
	//}else{
	//	//alambrico
	//	parent.opener.document.all.item('p1_al_annff').value	= "";
	//	//fibra optica
	//	parent.opener.document.all.item('p1_alfo_annff').value	= "";
	//}
	//if(f.txtFlujoTS.value.length  != 0){
	//	//alambrico
	//	parent.opener.document.all.item('p1_al_time_slot').value	= f.txtFlujoTS.value.split("-")[1];
	//	//fibra optica
	//	parent.opener.document.all.item('p1_alfo_time_slot').value	= f.txtFlujoTS.value.split("-")[1];
	//}else{
	//	//alambrico
	//	parent.opener.document.all.item('p1_al_time_slot').value	= "";
	//	//fibra
	//	parent.opener.document.all.item('p1_alfo_time_slot').value	= "";
	//}
	
	//
	//variables de adsl para provisionar
	parent.opener.document.all.item('id_armario_sb').value		= f.hdnIDArmarioSB.value;
	parent.opener.document.all.item('id_ADSL_subida').value		= f.hdnIDPEXADSLS.value;
	parent.opener.document.all.item('id_ADSL_bajada').value		= f.hdnIDPEXADSLB.value;
	
	parent.opener.document.all.item('id_borne_ADSL').value		= f.hdnIDBorneDSLAM.value;
 	parent.opener.document.all.item('id_borne_splitter').value	= f.hdnIDBorneSPLV.value;
 	
		//alambrico
		parent.opener.document.all.item('p1_adsl_ip_dslm1').value	= f.txtIPDSLAM.value;
		parent.opener.document.all.item('p1_adsl_puerto1').value	= f.txtEtiquetaPuertoATM.value;
		parent.opener.document.all.item('p1_adsl_par_dslm1').value	= f.txtParADSLS.value + '/' + f.txtParADSLB.value;
		//parent.opener.document.all.item('p1_adsl_spliter1').value	= f.txtEtiquetaBorneSplitter.value;
		parent.opener.document.all.item('p1_adsl_spliter1').value	= "";
		parent.opener.document.all.item('p1_adsl_pex11').value		= f.txtParPexADSLS.value;
		parent.opener.document.all.item('p1_adsl_pex21').value		= f.txtParPexADSLB.value;
		
		//Fibra Optica
		parent.opener.document.all.item('p1_adsl_ip_dslm2').value	= f.txtIPDSLAM.value;
		parent.opener.document.all.item('p1_adsl_puerto2').value	= f.txtEtiquetaPuertoATM.value;
		parent.opener.document.all.item('p1_adsl_par_dslm2').value	= f.txtParADSLS.value + '/' + f.txtParADSLB.value;
		parent.opener.document.all.item('p1_adsl_spliter2').value	= f.txtEtiquetaBorneSplitter.value;
		parent.opener.document.all.item('p1_adsl_pex12').value		= f.txtParPexADSLS.value;
		parent.opener.document.all.item('p1_adsl_pex22').value		= f.txtParPexADSLB.value;
	
    //
	parent.close();
}
