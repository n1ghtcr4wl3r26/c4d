function soloNumeros()
{ key=window.event.keyCode; //codigo de tecla. 
  if (key < 48 || key > 57)//si no es numero 
  {    if (key != 44) //no es coma
       {   window.event.keyCode=0;}   //anula la entrada de texto. 
  }
};
   

function finmes()
{
	this[1]=31;this[2]=29;this[3]=31;this[4]=30;this[5]=31;this[6]=30;
	this[7]=31;this[8]=31;this[9]=30;this[10]=31;this[11]=30;this[12]=31;
};
function EsFecha(fecha)
{
var a,d,m;
var mes = new finmes;
var er = new RegExp("^[0-3]{1}[0-9]{1}/(01|02|03|04|05|06|07|08|09|10|11|12)/[1-2]{1}[0-9]{3}$","g");
a = er.test(fecha);
if (a) {
		d = parseInt(fecha.substring(0,2),10);
		m = parseInt(fecha.substring(3,5),10);
		if (d > 0 && d <= mes[m]) { return true; };
};
return false;
};

function EsTelefono(valor)
{
var fono = new RegExp("^[0-9\-]{7,17}$","g");
return fono.test(valor)
};

function EsNro(valor)
{
var nro = new RegExp("^[0-9,.]{1,12}$","g");
return nro.test(valor)
};

function EsCadena(valor)
{
var tipo = new RegExp("^[a-zA-Z0-9_. ]+$","g");
return tipo.test(valor)
};

function EsAlfaNumerico(valor)
{
var tipo = new RegExp("^[a-zA-Z0-9]+$","g");
return tipo.test(valor)
};

function EsAlfaNumerico1(valor)
{
var tipo = new RegExp("^[a-zA-Z0-9]+$","g");
return tipo.test(valor)
};

function EsEmail(valor)
{ 
//var re  = /^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-])+.)+([a-zA-Z0-9]{2,4})+$/; 
var email = new RegExp("^[a-zA-Z0-9_.]+@[a-zA-Z.]+$","g");
return email.test(valor)
};

function EsVacio(valor)
{
if (valor == "") return true
else return false;
};


function Redondea(num, numDec, decSep, thousandSep)
{
    // rounds number to X decimal places, defaults to 2
    numDec = (!numDec ? 2 : numDec);
    return Math.round(num*Math.pow(10,numDec))/Math.pow(10,numDec);
}; 

function EvaluateText(cadena, obj)
{
    opc = false; 
    if (cadena == "%d")
     if (event.keyCode > 47 && event.keyCode < 58)
      opc = true;
    if (cadena == "%f"){ 
     if (event.keyCode > 47 && event.keyCode < 58)
      opc = true;
     if (obj.value.search("[.*]") == -1 && obj.value.length != 0)
      if (event.keyCode == 46)
       opc = true;
    }
    if(opc == false)
     event.returnValue = false; 
};

// Scripts de validacion de fechas

function esDigito(sChr){
    var sCod = sChr.charCodeAt(0);
    return ((sCod > 47) && (sCod < 58));
   };

   function valSep(oTxt){
    var bOk = false;
    bOk = bOk || ((oTxt.value.charAt(2) == "-") && (oTxt.value.charAt(5) == "-"));
    bOk = bOk || ((oTxt.value.charAt(2) == "/") && (oTxt.value.charAt(5) == "/"));
    return bOk;
   };

   function finMes(oTxt){
    var nMes = parseInt(oTxt.value.substr(3, 2), 10);
    var nAno = parseInt(oTxt.value.substr(6), 10);
    var nRes = 0;
    switch (nMes){
     case 1: nRes = 31; break;
     case 2: nRes = 28; break;
     case 3: nRes = 31; break;
     case 4: nRes = 30; break;
     case 5: nRes = 31; break;
     case 6: nRes = 30; break;
     case 7: nRes = 31; break;
     case 8: nRes = 31; break;
     case 9: nRes = 30; break;
     case 10: nRes = 31; break;
     case 11: nRes = 30; break;
     case 12: nRes = 31; break;
    }
    return nRes + (((nMes == 2) && (nAno % 4) == 0)? 1: 0);
   };

   function valDia(oTxt){
    var bOk = false;
    var nDia = parseInt(oTxt.value.substr(0, 2), 10);
    bOk = bOk || ((nDia >= 1) && (nDia <= finMes(oTxt)));
    return bOk;
   };

   function valMes(oTxt){
    var bOk = false;
    var nMes = parseInt(oTxt.value.substr(3, 2), 10);
    bOk = bOk || ((nMes >= 1) && (nMes <= 12));
    return bOk;
   };

   function valAno(oTxt){
    var bOk = true;
    var nAno = oTxt.value.substr(6);
    bOk = bOk && ((nAno.length == 2) || (nAno.length == 4));
    if (bOk){
     for (var i = 0; i < nAno.length; i++){
      bOk = bOk && esDigito(nAno.charAt(i));
     }
    }
    return bOk;
   };

   function valFecha(oTxt){
    var bOk = true;
    if (oTxt.value != ""){
     bOk = bOk && (valAno(oTxt));
     bOk = bOk && (valMes(oTxt));
     bOk = bOk && (valDia(oTxt));
     bOk = bOk && (valSep(oTxt));
     return bOk;
    }
   };

   function fechaMayorOIgualQue(fec0, fec1){
    var bRes = false;    
    var sDia0 = fec0.value.substr(0, 2);
    var sMes0 = fec0.value.substr(3, 2);
    var sAno0 = fec0.value.substr(6, 4);
    var sDia1 = fec1.value.substr(0, 2);
    var sMes1 = fec1.value.substr(3, 2);
    var sAno1 = fec1.value.substr(6, 4);
    if (sAno0 > sAno1) bRes = true;
    else {
     if (sAno0 == sAno1){
      if (sMes0 > sMes1) bRes = true;
      else {
       if (sMes0 == sMes1)
        if (sDia0 >= sDia1) bRes = true;
      }
     }
    }
    return bRes;
   };

   function fechaIgualQue(fec0, fec1){
    var bRes = false;    
    var sDia0 = fec0.substr(0, 2);
    var sMes0 = fec0.substr(3, 2);
    var sAno0 = fec0.substr(6, 4);
    var sDia1 = fec1.substr(0, 2);
    var sMes1 = fec1.substr(3, 2);
    var sAno1 = fec1.substr(6, 4);
    if (sAno0 == sAno1) 
      if (sMes0 == sMes1) 
        if (sDia0 == sDia1)
          bRes = true;
    
    return bRes;
   };


   function fMayorOIgualQue(fec0, fec1){
    var bRes = false;       
    if(EsVacio(fec1))
      fec1 = '31/12/2010';
    var sDia0 = fec0.substr(0, 2);
    var sMes0 = fec0.substr(3, 2);
    var sAno0 = fec0.substr(6, 4);
    var sDia1 = fec1.substr(0, 2);
    var sMes1 = fec1.substr(3, 2);
    var sAno1 = fec1.substr(6, 4);
    if (sAno0 > sAno1) bRes = true;
    else { 
     if (sAno0 == sAno1){ 
      if (sMes0 > sMes1) bRes = true;
      else {
       if (sMes0 == sMes1)
       {  if (sDia0 >= sDia1) 
          {  bRes = true; 
          }
       } 
      }
     }
    }    
    return bRes;
   };
   
function habilita_texto(check, texto)
{  //f = document.forms[0]; 
    if (check.checked) 
    { texto.disabled = false;
      texto.focus();}
    else 
     texto.disabled = true; 
};
function habilita_read(check, texto)
{   if (check.checked) 
    { texto.disabled = false;
      texto.focus();}
    else 
    {
     texto.disabled = true; }
};

function habilita_boton_REG()
{   f = document.forms[0]; 
    sw = 0;
    if (f.cp4_cod_chk.checked)
    {   sw = 1;}
    if (f.fch_ini_chk.checked)
    { sw = 1;  }
    if (f.fch_fin_chk.checked)
    { sw = 1;  }
    
    if (sw == 1)
    { f.boton_jsp[0].disabled = false;
      f.boton_jsp[1].disabled = false;
    }
    else
    {  f.boton_jsp[0].disabled = true;
       f.boton_jsp[1].disabled = true;
    }
};

function habilita_boton_DES()
{   f = document.forms[0]; 
    sw = 0;
    if (f.tip_doc_chk.checked)
    { sw = 1;  }    
    if (f.des_nom_chk.checked)
    { sw = 1;  }
    if (f.des_ap_chk.checked)
    { sw = 1;  }
    if (f.des_am_chk.checked)
    { sw = 1;  }
    if (f.dir_zon_chk.checked) 
    { sw = 1;  }
    if (f.dir_dom_chk.checked) 
    { sw = 1;  }
    if (f.nro_dom_chk.checked) 
    { sw = 1;  }    
    if (f.nro_tlf_chk.checked) 
    { sw = 1;  }
    if (f.nro_fax_chk.checked) 
    { sw = 1;  }
    if (f.frm_sll_chk.checked)
    { sw = 1;  }    
    if (f.lic_cod_chk.checked)
    { sw = 1;  }
    if (f.lic_dsc_chk.checked)
    { sw = 1;  }
    if (f.fch_lic_chk.checked)
    { sw = 1;  }
    if (f.ope_jrd_chk.checked)
    { sw = 1;  }
    
    if (sw == 1)
    { f.boton_jsp[0].disabled = false;
      f.boton_jsp[1].disabled = false;
    }
    else
    {  f.boton_jsp[0].disabled = true;
       f.boton_jsp[1].disabled = true;
    }
};

function habilita_boton_REP()
{   f = document.forms[0]; 
    sw = 0;
    if (f.doc_ide_chk.checked)
    {   sw = 1;}
    if (f.rep_nom_chk.checked)
    { sw = 1;  }
    if (f.rep_ap_chk.checked)
    { sw = 1;  }
    if (f.rep_am_chk.checked)
    { sw = 1;  }
    if (f.dir_zon_chk.checked) 
    { sw = 1;  }
    if (f.dir_dom_chk.checked) 
    { sw = 1;  }
    if (f.nro_dom_chk.checked) 
    { sw = 1;  }
    if (f.nro_tlf_chk.checked) 
    { sw = 1;  }
    if (f.nro_fax_chk.checked) 
    { sw = 1;  }
    if (f.nro_pnt_chk.checked) 
    { sw = 1;  }
    if (f.e_mail_chk.checked) 
    { sw = 1;  }
    if (f.nro_csl_chk.checked)
    { sw = 1;  }
    
    if (sw == 1)
    { f.boton_jsp[0].disabled = false;
      f.boton_jsp[1].disabled = false;
    }
    else
    {  f.boton_jsp[0].disabled = true;
       f.boton_jsp[1].disabled = true;
    }
};
function habilita_boton_SOC()
{   f = document.forms[0]; 
    sw = 0;
    if (f.tip_doc_chk.checked)
    { sw = 1;  }
    if (f.soc_nom_chk.checked)
    { sw = 1;  }
    if (f.soc_ap_chk.checked)
    { sw = 1;  }
    if (f.soc_am_chk.checked)
    { sw = 1;  }    
    if (f.por_cto_chk.checked)
    { sw = 1;  }       
    if (f.mnt_bob_chk.checked)
    { sw = 1;  }

    if (sw == 1)
    { f.boton_jsp[0].disabled = false;
      f.boton_jsp[1].disabled = false;
    }
    else
    {  f.boton_jsp[0].disabled = true;
       f.boton_jsp[1].disabled = true;
    }
};
function habilita_boton_JUR()
{   f = document.forms[0]; 
    sw = 0;
    if (f.dir_zon_chk.checked) 
    { sw = 1;  }
    if (f.dir_dom_chk.checked) 
    { sw = 1;  }
    if (f.nro_dom_chk.checked) 
    { sw = 1;  }
    if (f.nro_tlf_chk.checked) 
    { sw = 1;  }
    if (f.nro_fax_chk.checked) 
    { sw = 1;  }
    if (f.e_mail_chk.checked) 
    { sw = 1;  }
    if (f.nro_tnd_chk.checked) 
    { sw = 1;  }
    if (f.ofi_pri_chk.checked)
    { sw = 1;  }

    if (sw == 1)
    { f.boton_jsp[0].disabled = false;
      f.boton_jsp[1].disabled = false;
    }
    else
    {  f.boton_jsp[0].disabled = true;
       f.boton_jsp[1].disabled = true;
    }
};

function habilita_boton_GAR()
{   f = document.forms[0]; 
    sw = 0;
    
    if (f.gar_tip_chk.checked)
    { sw = 1;  }
    if (f.gar_emi_chk.checked)
    { sw = 1;  }
    if (f.fch_ini_chk.checked)
    { sw = 1;  }
    if (f.fch_fin_chk.checked)
    { sw = 1;  }
    if (f.fch_emi_chk.checked)
    { sw = 1;  }
    if (f.imp_tot_chk.checked) 
    { sw = 1;  }    

    if (sw == 1)
    { f.boton_jsp[0].disabled = false;
      f.boton_jsp[1].disabled = false;
    }
    else
    {  f.boton_jsp[0].disabled = true;
       f.boton_jsp[1].disabled = true;
    }
};
function habilita_boton_AUT()
{   f = document.forms[0]; 
    sw = 0;
    if (f.tip_aut_chk.checked)
    {   sw = 1;}
    if (f.res_amplia_chk.checked)
    { sw = 1;  }
    if (f.aut_ant_chk.checked)
    { sw = 1;  }    
    if (f.fch_emi_chk.checked)
    { sw = 1;  }
    if (f.fch_vto_chk.checked)
    { sw = 1;  }
    if (f.fch_hab_chk.checked)
    { sw = 1;  }

    if (sw == 1)
    { f.boton_jsp[0].disabled = false;
      f.boton_jsp[1].disabled = false;
    }
    else
    {  f.boton_jsp[0].disabled = true;
       f.boton_jsp[1].disabled = true;
    }
    };

    function habilita_boton_LOC()
{   f = document.forms[0]; 
    sw = 0;
   if (f. loc_dsc_chk.checked)
    {   sw = 1;}
    /*if (f.cod_ant_chk.checked)
    { sw = 1;  }
    if (f.cod_moda_chk.checked)
    { sw = 1;  }*/
    if (f.fch_fin_chk.checked)
    { sw = 1;  }
    if (f.fch_ini_chk.checked)
    { sw = 1;  }
    if (f.dir_zon_chk.checked) 
    { sw = 1;  }
    if (f.dir_dom_chk.checked) 
    { sw = 1;  }
    if (f.dir_cdd_chk.checked) 
    { sw = 1;  }
    if (f.nro_tlf_chk.checked) 
    { sw = 1;  }
    if (f.nro_fax_chk.checked) 
    { sw = 1;  }
    if (f.pbl_prv_chk.checked) 
    { sw = 1;  }

    if (sw == 1)
    { f.boton_jsp[0].disabled = false;
      f.boton_jsp[1].disabled = false;
    }
    else
    {  f.boton_jsp[0].disabled = true;
       f.boton_jsp[1].disabled = true;
    }
};    

function habilita_boton_DEA()
{   f = document.forms[0]; 
    sw = 0;
   if (f. dea_cuo_chk.checked)
    {   sw = 1;}
    if (f.dea_dsc_chk.checked)
    { sw = 1;  }
    if (f.fch_fin_chk.checked)
    { sw = 1;  }
    if (f.fch_ini_chk.checked)
    { sw = 1;  }
    if (f.dir_dom_chk.checked) 
    { sw = 1;  }
    if (f.nro_tlf_chk.checked) 
    { sw = 1;  }
    if (f.nro_fax_chk.checked) 
    { sw = 1;  }

    if (sw == 1)
    { f.boton_jsp[0].disabled = false;
      f.boton_jsp[1].disabled = false;
    }
    else
    {  f.boton_jsp[0].disabled = true;
       f.boton_jsp[1].disabled = true;
    }
};    

    function habilita_boton_VEH()
{   f = document.forms[0]; 
    sw = 0;
    
    if (f.plc_ant_chk.checked)
    { sw = 1;  }
    if (f.trp_cls_chk.checked)
    { sw = 1;  }
    if (f.mrc_cod_chk.checked)
    { sw = 1;  }
    if (f.tpo_cod_chk.checked)
    { sw = 1;  }
    if (f.sub_cod_chk.checked)
    { sw = 1;  }
    if (f.cap_ton_chk.checked)
    { sw = 1;  }
    if (f.nro_mtr_chk.checked)
    { sw = 1;  }
    if (f.nro_cha_chk.checked)
    { sw = 1;  }
    if (f.gst_mdl_chk.checked)
    { sw = 1;  }
    if (f.nro_eje_chk.checked)
    { sw = 1;  }
    if (f.trp_clr_chk.checked)
    { sw = 1;  }

    if (sw == 1)
    { f.boton_jsp[0].disabled = false;
      f.boton_jsp[1].disabled = false;
    }
    else
    {  f.boton_jsp[0].disabled = true;
       f.boton_jsp[1].disabled = true;
    }
};
    function habilita_boton_PAU()
{   f = document.forms[0]; 
    sw = 0;
    if (f.fch_ini_chk.checked)
    { sw = 1;  }
    if (f.fch_fin_chk.checked)
    { sw = 1;  }

    if (sw == 1)
    { f.boton_jsp[0].disabled = false;
      f.boton_jsp[1].disabled = false;
    }
    else
    {  f.boton_jsp[0].disabled = true;
       f.boton_jsp[1].disabled = true;
    }
};

function habilita_boton_RTA()
{   f = document.forms[0]; 
    sw = 0;

    if (f.rta_cod_chk.checked)
    { sw = 1;  }

    if (sw == 1)
    { f.boton_jsp[0].disabled = false;
      f.boton_jsp[1].disabled = false;
    }
    else
    {  f.boton_jsp[0].disabled = true;
       f.boton_jsp[1].disabled = true;
    }
};

function habilita_boton_GVE()
{   f = document.forms[0]; 
    sw = 0;

    if (f.mnt_placa_chk.checked)
    { sw = 1;  }

    if (sw == 1)
    { f.boton_jsp[0].disabled = false;
      f.boton_jsp[1].disabled = false;
    }
    else
    {  f.boton_jsp[0].disabled = true;
       f.boton_jsp[1].disabled = true;
    }
};

function habilita_boton_SUC()
{   f = document.forms[0]; 
    sw = 0;

    if (f.dir_dom_chk.checked)
    { sw = 1;  }
    if (f.nro_tlf_chk.checked)
    { sw = 1;  }
    if (f.nro_csl_chk.checked)
    { sw = 1;  }
    if (f.e_mail_chk.checked)
    { sw = 1;  }
    if (f.nro_tnd_chk.checked)
    { sw = 1;  }

    if (sw == 1)
    { f.boton_jsp[0].disabled = false;
      f.boton_jsp[1].disabled = false;
    }
    else
    {  f.boton_jsp[0].disabled = true;
       f.boton_jsp[1].disabled = true;
    }
};

