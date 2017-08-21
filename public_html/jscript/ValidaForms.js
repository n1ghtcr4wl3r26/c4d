  var now = new Date();
  var dia = now.getDate();
  if (dia < 10)
  { dia = '0'+dia }
  var mes = now.getMonth()+1;
  if (mes < 10)
  { mes = '0'+mes }
  var anio = now.getYear();
  var hoy = dia+'/'+mes+'/'+anio;

function fSubmit(row)
  { f = document.forms[0];
    f.row_id.value = row;
  }

function fInicioOperador()
{ var Mensaje = "";
  f = document.forms[0];

  if (f.ope_nit != null)
  { if(EsVacio( f.ope_nit.value ))
      Mensaje = Mensaje + 'Ingrese el Nit del Operador \n';
  }
  
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }
};

function fOperador( tipo )
{ var Mensaje = "";
  f = document.forms[0];

  if( EsVacio( f.ope_nit.value ) || f.ope_nit.value == "%" )
      Mensaje = Mensaje + 'Ingrese el Nit del Operador. \n';
  else
    if ( !EsNro( f.ope_nit.value ) )
      Mensaje = Mensaje + 'El Nit del Operador es inv\341lido. \n';      
  if( !EsVacio( f.ruc_ant.value ) )
    if ( !EsNro( f.ruc_ant.value ) )
      Mensaje = Mensaje + 'El RUC Anterior es inv\341lido. \n';          
  if( EsVacio( f.nom_rzs.value ) )
      Mensaje = Mensaje + 'Ingrese la Raz\363n Social del Operador. \n';
  if ( f.cns_cod.value == "%")
      Mensaje = Mensaje + 'Elija la Constituci\363n de la Empresa. \n';
  if( EsVacio( f.nom_sid.value ) )
      Mensaje = Mensaje + 'Ingrese la Raz\363n Social del Operador (SIDUNEA). \n';    
  else
     if ( f.nom_sid.value.length<5 )
        Mensaje = Mensaje + 'La longitud de la Raz\363n Social del Operador (SIDUNEA) debe ser mayor a 5. \n';    

  if (tipo == "DEP")
  { if( EsVacio( f.rsm_nom.value ) )
      Mensaje = Mensaje + 'Ingrese la sigla del Operador. \n';    
    else
     if ( f.rsm_nom.value.length < 5 )
        Mensaje = Mensaje + 'La Sigla debe tener 5 caracteres. \n '
  }  
  if (tipo == "ZFR")
  { if ( f.cuo_cod.value == "%")
      Mensaje = Mensaje + 'Elija la Zona Franca. \n';          
  }
  if ( f.cty_cod.value == "%")
    Mensaje = Mensaje + 'Elija el Pa\355s. \n';            
/*  if( EsVacio( f.nro_ra.value ) )
      Mensaje = Mensaje + 'Ingrese la Resoluci�n Administrativa. \n';          
  if( EsVacio( f.fch_ra.value ) )
      Mensaje = Mensaje + 'Ingrese la fecha de la Resoluci�n Administrativa. \n';    
  else
      if( !EsFecha( f.fch_ra.value ))
        Mensaje = Mensaje + 'La fecha de la Resoluci�n Administrativa es inv�lida. \n';    */

  if (tipo == "TRE" || tipo == "TRN")
  { if( EsVacio( f.co_bo_tic.value ) )
      Mensaje = Mensaje + 'Ingrese el C\363digo Botic. \n';    
  }
  if ( f.loc_cod.value == "%")
      Mensaje = Mensaje + 'Elija la Localidad. \n';    
  if( EsVacio( f.ope_cdd.value ) )
      Mensaje = Mensaje + 'Ingrese la Ciudad. \n';    

  if (f.cty_cod.value != f.loc_cod.value.substr (0, 2) && f.loc_cod.value != "%" )
    Mensaje = Mensaje + 'La Localidad no corresponde al pa\363s elegido. \n';  
  if( EsVacio( f.dir_zon.value ) )
      Mensaje = Mensaje + 'Ingrese la Zona. \n';    
  if( EsVacio( f.dir_dom.value ) )
      Mensaje = Mensaje + 'Ingrese la Calle o Avenida. \n';        
  if( EsVacio( f.nro_dom.value ) )
      Mensaje = Mensaje + 'Ingrese el N�mero del Domicilio. \n';        
  else
    if ( !EsAlfaNumerico(f.nro_dom.value) )
      Mensaje = Mensaje + 'El N�mero del Domicilio es inv\341lido. \n';      
      
  if( !EsVacio( f.edf_pso.value ) )
    if ( !EsAlfaNumerico(f.edf_pso.value) )
      Mensaje = Mensaje + 'El piso es inv�lido. \n';      

  if( !EsVacio( f.dir_ofi.value ) )
    if ( !EsAlfaNumerico(f.dir_ofi.value) )
      Mensaje = Mensaje + 'El N\372mero de Oficina es inv\341lido. \n';      
  
  if( !EsVacio( f.nro_tlf.value ) )
    if ( !EsTelefono(f.nro_tlf.value) )
      Mensaje = Mensaje + 'El N�mero de Tel�fono es incorrecto. \n';        
  if( !EsVacio( f.nro_fax.value ) )
    if ( !EsTelefono(f.nro_fax.value) )
      Mensaje = Mensaje + 'El N�mero de Fax es incorrecto. \n';        
  if( !EsVacio( f.e_mail.value ) )
    if ( !EsEmail(f.e_mail.value) )
      Mensaje = Mensaje + 'El E-mail es incorrecto. \n';     
      
  if ( tipo == "TRE" || tipo == "TRN" || tipo == "DES" || tipo == "OTM" || tipo == "DFR")
  { if( EsVacio( f.nro_mat.value ) )
      Mensaje = Mensaje + 'Ingrese el N�mero de la Matr�cula (FUNDEMPRESA). \n';        
  }
  if ( tipo == "EXP" )
  { var n = 0;
    for ( var i = 0; i < f.ope_cls.length; i++ ) {
      if ( f.ope_cls[i].checked ) 
        n++;
    }
    if ( n == 0 )
      Mensaje = Mensaje + 'Elija si se acoge a la Ley Econ�mica del Alto. \n';        
  }

  if ( tipo == "DES")
  { if( EsVacio( f.ope_jrd.value ) )
      Mensaje = Mensaje + 'Elija la jurisdicci�n. \n';        
  }

  if( EsVacio( f.tbl_obs.value ) )
      Mensaje = Mensaje + 'Ingrese la Observaci�n. \n';     
      
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }
};

function fTipoOperador()
{ var Mensaje = "";
  f = document.forms[0];  
  if( EsVacio( f.ope_nit.value ) || f.ope_nit.value == "%" || f.ope_nit.value.indexOf("%") > -1)
      Mensaje = Mensaje + 'Ingrese o verifique el Nit del Operador. \n';
  if( f.cuo_cod.value == "%")
      Mensaje = Mensaje + 'Elija la Zona Franca. \n';
  if( EsVacio( f.tbl_obs.value ) )
      Mensaje = Mensaje + 'Ingrese la Observaci�n. \n';     
      
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }
};

function fRepresentante()
{ var Mensaje = "";
  f = document.forms[0];
  
  if( EsVacio( f.ope_nit.value ) || f.ope_nit.value == "%" || f.ope_nit.value.indexOf("%") > -1)
      Mensaje = Mensaje + 'Ingrese o verifique el Nit del Operador. \n';
  if( EsVacio( f.rep_cod.value ) )
      Mensaje = Mensaje + 'Ingrese el Documento del Representante. \n';  
  else
    if ( !EsNro(f.rep_cod.value) )
      Mensaje = Mensaje + 'El Documento del Representante es inv�lido. \n';  
  if ( f.doc_ide.value == "%")
      Mensaje = Mensaje + 'Elija el Tipo de  Documento. \n';  
  if( EsVacio( f.lug_emi.value ) )
      Mensaje = Mensaje + 'Ingrese el Lugar de Emisi�n del Documento del Representante. \n';  
  else
    if ( !EsCadena(f.lug_emi.value) )
      Mensaje = Mensaje + 'El Lugar de Emisi�n del Documento del Representante es inv�lido. \n';  
  if( EsVacio( f.rep_nom.value ) )
      Mensaje = Mensaje + 'Ingrese el Nombre del Representante. \n';  
  if( EsVacio( f.rep_ap.value ) )
      Mensaje = Mensaje + 'Ingrese el Apellido Paterno del Representante. \n';  
  if( EsVacio( f.nro_pnt.value ) )
      Mensaje = Mensaje + 'Ingrese el N�mero de Poder Notariado. \n';        
  if( EsVacio( f.fch_pnt.value ) )
      Mensaje = Mensaje + 'Ingrese la Fecha del Poder Notariado. \n';            
  else
  { if (!EsFecha(f.fch_pnt.value))
        Mensaje = Mensaje + 'La Fecha del Poder Notariado es inv�lida. \n';  
    else
    {   if( !fMayorOIgualQue(hoy, f.fch_pnt.value) )
          Mensaje = Mensaje + 'La Fecha del Poder no puede ser anterior la Fecha Actual. \n';
    }
  }
  if( EsVacio( f.dir_zon.value ) )
      Mensaje = Mensaje + 'Ingrese la Zona. \n';    
  if( EsVacio( f.dir_dom.value ) )
      Mensaje = Mensaje + 'Ingrese el Domicilio. \n';        
  if( EsVacio( f.nro_dom.value ) )
      Mensaje = Mensaje + 'Ingrese el N�mero del Domicilio. \n';        
  if( !EsVacio( f.nro_tlf.value ) )
    if ( !EsTelefono(f.nro_tlf.value) )
      Mensaje = Mensaje + 'El N�mero de Tel�fono es incorrecto. \n';        
  if( !EsVacio( f.nro_fax.value ) )
    if ( !EsTelefono(f.nro_fax.value) )
      Mensaje = Mensaje + 'El N�mero de Fax es incorrecto. \n';        
  if( !EsVacio( f.e_mail.value ) )
    if ( !EsEmail(f.e_mail.value) )
      Mensaje = Mensaje + 'El E-mail es incorrecto. \n';            
  if( EsVacio( f.tbl_obs.value ) )
      Mensaje = Mensaje + 'Ingrese la Observaci�n. \n';      

  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }
};

function fDespachante()
{ var Mensaje = "";
  f = document.forms[0];  
  if( EsVacio( f.ope_nit.value ) || f.ope_nit.value == "%" || f.ope_nit.value.indexOf("%") > -1 )
      Mensaje = Mensaje + 'Ingrese o verifique el Nit del Operador. \n';    
  if( EsVacio( f.des_cod.value ) )
      Mensaje = Mensaje + 'Ingrese el Documento del Representante. \n';  
  else
    if ( !EsNro(f.des_cod.value) )
      Mensaje = Mensaje + 'El Documento del Despachante es inv�lido. \n';    
  if (f.tip_doc.value == "%")
      Mensaje = Mensaje + 'Elija Tipo de Documento de Identidad. \n';  
  if( EsVacio( f.lug_emi.value ) )
      Mensaje = Mensaje + 'Ingrese el Lugar de Emisi�n del Documento del Despachante. \n';  
  else
    if ( !EsCadena(f.lug_emi.value) )
      Mensaje = Mensaje + 'El Lugar de Emisi�n del Documento del Despachante es inv�lido. \n';  
  if( EsVacio( f.des_nom.value ) )
      Mensaje = Mensaje + 'Ingrese el Nombre del Despachante. \n';    
  if( EsVacio( f.des_ap.value ) )
      Mensaje = Mensaje + 'Ingrese el Apellido Paterno del Despachante. \n';  
  if( EsVacio( f.dir_zon.value ) )
      Mensaje = Mensaje + 'Ingrese la Zona. \n';    
  if( EsVacio( f.dir_dom.value ) )
      Mensaje = Mensaje + 'Ingrese el Domicilio. \n';        
  if( EsVacio( f.nro_dom.value ) )
      Mensaje = Mensaje + 'Ingrese el N�mero del Domicilio. \n';                      
  if( !EsVacio( f.nro_tlf.value ) )
    if ( !EsTelefono(f.nro_tlf.value) )
      Mensaje = Mensaje + 'El N�mero de Tel�fono es incorrecto. \n';        
  if( !EsVacio( f.nro_fax.value ) )
    if ( !EsTelefono(f.nro_fax.value) )
      Mensaje = Mensaje + 'El N�mero de Fax es incorrecto. \n';        
  if( EsVacio( f.lic_cod.value ) )
      Mensaje = Mensaje + 'Ingrese el N�mero de Licencia. \n';            
  if ( !EsVacio(f.fch_lic.value) )
  { if( !EsFecha( f.fch_lic.value ))
      Mensaje = Mensaje + 'La Fecha de la Licencia es inv�lida. \n';    
    else
    { if( !fMayorOIgualQue(hoy, f.fch_lic.value) )
          Mensaje = Mensaje + 'La Fecha de la Licencia no puede ser anterior la Fecha Actual. \n';
    }
  }
  else
    Mensaje = Mensaje + 'Ingrese la Fecha de la Licencia. \n';   
  if( f.ope_jrd.value == "%" )
      Mensaje = Mensaje + 'Elija la Jurisdicci�n del Despachante. \n';          
  if( f.gar_nro.value == "%" )
      Mensaje = Mensaje + 'Elija la Garant�a del Despachante. \n';          
  if( EsVacio( f.tbl_obs.value ) )
      Mensaje = Mensaje + 'Ingrese la Observaci�n. \n';      

  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }
}

function fSocio()
{  var Mensaje = "";
  f = document.forms[0];

  if( EsVacio( f.ope_nit.value ) || f.ope_nit.value == "%" || f.ope_nit.value.indexOf("%") > -1 )
      Mensaje = Mensaje + 'Ingrese o verifique el Nit del Operador. \n';
  if( EsVacio( f.soc_cod.value ) )
      Mensaje = Mensaje + 'Ingrese el Documento del Socio. \n';  
  else
    if ( !EsNro(f.soc_cod.value) )
      Mensaje = Mensaje + 'El Documento del Socio es inv�lido. \n';  
  if ( f.tip_doc.value == "%")
      Mensaje = Mensaje + 'Elija el Tipo de  Documento de Identidad. \n';  
  if( EsVacio( f.lug_emi.value ) )
      Mensaje = Mensaje + 'Ingrese el Lugar de Emisi�n del Documento del Socio. \n';  
  else
    if ( !EsCadena(f.lug_emi.value) )
      Mensaje = Mensaje + 'El Lugar de Emisi�n del Documento del Socio es inv�lido. \n';  
    if( EsVacio( f.soc_nom.value ) )
      Mensaje = Mensaje + 'Ingrese el Nombre del Socio. \n';  
  if( EsVacio( f.soc_ap.value ) )
      Mensaje = Mensaje + 'Ingrese el Apellido Paterno del Socio. \n';  
  if( EsVacio( f.por_cto.value ) )
      Mensaje = Mensaje + 'Ingrese el Porcentaje de Participaci�n del Socio. \n';            
  else
    if ( !EsNro(f.por_cto.value) )
      Mensaje = Mensaje + 'El porcentaje de participaci�n debe ser num�rico. \n';            
  if( EsVacio( f.mnt_bob.value ) )
      Mensaje = Mensaje + 'Ingrese el Monto en Bs. del Socio. \n';            
  else
    if ( !EsNro(f.mnt_bob.value) )
      Mensaje = Mensaje + 'El Monto en Bs. debe ser num�rico. \n';         
    else
      if ( f.mnt_bob.value<=10 )
        Mensaje = Mensaje + 'El Monto en Bs. debe ser mayor a 10. \n';         
  if( EsVacio( f.tbl_obs.value ) )
      Mensaje = Mensaje + 'Ingrese la Observaci�n. \n';  

  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }    
};

function flocalizacion()
{ var Mensaje = "";
  f = document.forms[0];

  if( EsVacio( f.ope_nit.value ) || f.ope_nit.value == "%" || f.ope_nit.value.indexOf("%") > -1 )
      Mensaje = Mensaje + 'Ingrese el Nit del Operador. \n';
  if ( f.cuo.value == "%")
      Mensaje = Mensaje + 'Elija la Administraci�n Aduanera. \n';
  if ( f.cod_moda.value == "%")
      Mensaje = Mensaje + 'Elija la Modalidad. \n';      
  if( EsVacio( f.loc_dsc.value ) )
      Mensaje = Mensaje + 'Ingrese la Descripci�n del Dep�sito. \n';  
  if ( !EsVacio(f.fch_ini.value) )
  { if( !EsFecha( f.fch_ini.value ))
      Mensaje = Mensaje + 'La Fecha Inicial es inv�lida. \n';    
  }
  else
      Mensaje = Mensaje + 'Ingrese la Fecha Inicial. \n';    
  if ( !EsVacio(f.fch_fin.value) )
  { if( !EsFecha( f.fch_fin.value ))
      Mensaje = Mensaje + 'La Fecha Final es inv�lida. \n';    
  }
  if ( EsFecha(f.fch_ini.value) && EsFecha(f.fch_fin.value) )
    if( !fMayorOIgualQue(f.fch_fin.value, f.fch_ini.value) )
      Mensaje = Mensaje + 'El Rango de Fechas es inv�lido. \n';    
  if( EsVacio( f.dir_dom.value ) )
      Mensaje = Mensaje + 'Ingrese el Domicilio. \n';    
  if( EsVacio( f.dir_zon.value ) )
      Mensaje = Mensaje + 'Ingrese la Zona. \n';    
  if( EsVacio( f.dir_cdd.value ) )
      Mensaje = Mensaje + 'Ingrese la Ciudad. \n';    
  if( !EsVacio( f.nro_tlf.value ) )
    if ( !EsTelefono(f.nro_tlf.value) )
      Mensaje = Mensaje + 'El N�mero de Tel�fono es incorrecto. \n';    
  if( !EsVacio( f.nro_fax.value ) )
    if ( !EsTelefono(f.nro_fax.value) )
      Mensaje = Mensaje + 'El N�mero de Fax es incorrecto. \n';    
  if ( f.pbl_prv.value == "%")
      Mensaje = Mensaje + 'Elija el Tipo de Dep�sito. \n';       
  if( EsVacio( f.tbl_obs.value ) )
      Mensaje = Mensaje + 'Ingrese la Observaci�n. \n';  

  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }    
};

function fJurisdiccion()
{ var Mensaje = "";
  f = document.forms[0];

  if( EsVacio( f.ope_nit.value ) || f.ope_nit.value == "%" || f.ope_nit.value.indexOf("%") > -1 )
      Mensaje = Mensaje + 'Ingrese o verifique el Nit del Operador. \n';
  if ( f.ope_jrd.value == "%")
      Mensaje = Mensaje + 'Elija la Jurisdicci�n. \n';
  if( EsVacio( f.dir_zon.value ) )
      Mensaje = Mensaje + 'Ingrese la Zona. \n';
  if( EsVacio( f.dir_dom.value ) )
      Mensaje = Mensaje + 'Ingrese el Domicilio. \n';
  if( EsVacio( f.nro_dom.value ) )
      Mensaje = Mensaje + 'Ingrese el N�mero de la direcci�n. \n';
  if( !EsVacio( f.nro_tlf.value ) )
    if ( !EsTelefono(f.nro_tlf.value) )
      Mensaje = Mensaje + 'El N�mero de Tel�fono es incorrecto. \n';
  if( !EsVacio( f.nro_fax.value ) )
    if ( !EsTelefono(f.nro_fax.value) )
      Mensaje = Mensaje + 'El N�mero de Fax es incorrecto. \n';
  if( !EsVacio( f.e_mail.value ) )
    if ( !EsEmail(f.e_mail.value) )
      Mensaje = Mensaje + 'El E-mail es incorrecto. \n';            
  if( EsVacio( f.tbl_obs.value ) )
      Mensaje = Mensaje + 'Ingrese la Observaci�n. \n';      

  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }    
};

function fGarantia()
{ var Mensaje = "";
  f = document.forms[0];

  if( EsVacio( f.ope_nit.value ) || f.ope_nit.value == "%" || f.ope_nit.value.indexOf("%") > -1 )
      Mensaje = Mensaje + 'Ingrese o verifique el Nit del Operador. \n';
  if( EsVacio( f.gar_nro.value ) )
      Mensaje = Mensaje + 'Ingrese el N�mero de la Garant�a. \n';      
  if( f.gar_tip.value == "%" )
      Mensaje = Mensaje + 'Elija el Tipo de la Garant�a. \n';          
  if( f.gar_emi.value == "%" )
      Mensaje = Mensaje + 'Elija el Emisor de la Garant�a. \n';      
  if ( !EsVacio(f.fch_emi.value) )
  { if( !EsFecha( f.fch_emi.value ))
      Mensaje = Mensaje + 'La Fecha de Emisi�n es inv�lida. \n';    
    else
    {  if( !fMayorOIgualQue(hoy, f.fch_emi.value) )
        Mensaje = Mensaje + 'La Fecha de Emisi�n no puede ser posterior a la Fecha Actual. \n';
    }
  }
  else
      Mensaje = Mensaje + 'Ingrese la Fecha de Emisi�n. \n';              
  if ( !EsVacio(f.fch_ini.value) )
  { if( !EsFecha( f.fch_ini.value ))
      Mensaje = Mensaje + 'La Fecha Inicial es inv�lida. \n';  
    else
      if( !fMayorOIgualQue(f.fch_ini.value, f.fch_emi.value) )
        Mensaje = Mensaje + 'La Fecha Inicial no puede ser anterior a la de Emisi�n. \n';
  }
  else
      Mensaje = Mensaje + 'Ingrese la Fecha Inicial. \n';    
  if ( EsVacio(f.fch_fin.value) )
  {   if (f.ope_tip.value != "DES" && f.ope_tip.value != "NAL" && f.ope_tip.value != "TRE" && f.ope_tip.value != "TRN")    
      {  Mensaje = Mensaje + 'Ingrese la Fecha de Vencimiento. \n'; }
  }  
  else
  { if( !EsFecha( f.fch_fin.value ))
      Mensaje = Mensaje + 'La Fecha de Vencimiento es inv�lida. \n';    
  }  
  if ( EsFecha(f.fch_ini.value) && EsFecha(f.fch_fin.value) )
    if( !fMayorOIgualQue(f.fch_fin.value, f.fch_ini.value) )
      Mensaje = Mensaje + 'El Rango de Fechas es inv�lido. \n';        
  if( EsVacio( f.imp_tot.value ) )
      Mensaje = Mensaje + 'Ingrese el Importe de la Garant�a. \n';            
  else
    if ( !EsNro(f.imp_tot.value) )
      Mensaje = Mensaje + 'El Importe de la Garant�a debe ser num�rico. \n';         
    else
      if ( f.imp_tot.value <= 100 )
        Mensaje = Mensaje + 'El Importe de la Garant�a debe ser mayor a 100. \n';            

  if(f.ope_tip.value =="TRN" || f.ope_tip.value =="NAL")
    if( EsVacio( f.tbl_obs[0].value ) )
        Mensaje = Mensaje + 'Ingrese la Observaci�n. \n';    
  else      
    if( EsVacio( f.tbl_obs.value ) )
        Mensaje = Mensaje + 'Ingrese la Observaci�n. \n';  
        
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }    
}
function fVehiculo()
{ var Mensaje = "";
  f = document.forms[0];
  
  if( EsVacio( f.ope_nit.value ) || f.ope_nit.value == "%" || f.ope_nit.value.indexOf("%") > -1 )
      Mensaje = Mensaje + 'Ingrese o verifique el Nit del Operador. \n';
  if( EsVacio( f.nro_placa.value ) )
      Mensaje = Mensaje + 'Ingrese la Placa de la Unidad de Transporte. \n';
  else
    if ( !EsAlfaNumerico(f.nro_placa.value) )
      Mensaje = Mensaje + 'La Placa es inv�lida. \n';
  if( !EsVacio( f.plc_ant.value ) )
    if ( !EsAlfaNumerico(f.plc_ant.value) )
      Mensaje = Mensaje + 'La Placa Anterior es inv�lida. \n';      
  if( EsVacio( f.nro_cha.value ) )
      Mensaje = Mensaje + 'Ingrese el N�mero de Chasis. \n';
  else
    if ( !EsAlfaNumerico1(f.nro_cha.value) )
      Mensaje = Mensaje + 'El N�mero de Chasis es inv�lido. \n';
  if( EsVacio( f.nro_mtr.value ) )
      Mensaje = Mensaje + 'Ingrese el N�mero de Motor. \n';
  else    
    if ( !EsAlfaNumerico1(f.nro_mtr.value) )
      Mensaje = Mensaje + 'El N�mero de Motor es inv�lido. \n';
  if (f.mrc_cod.value == "%")
    Mensaje = Mensaje + 'Elija la Marca. \n';
  if( !EsVacio( f.cap_ton.value ) )
    if ( !EsNro(f.cap_ton.value) )
      Mensaje = Mensaje + 'La Capacidad de Tonelaje es inv�lida. \n';  
  if( !EsVacio( f.gst_mdl.value ) )
    if ( !EsNro(f.gst_mdl.value) )
      Mensaje = Mensaje + 'La Gesti�n es inv�lida. \n'; 
      
  if( !EsVacio( f.tar_ope.value ) || !EsVacio(f.fch_ini.value) || !EsVacio(f.fch_fin.value) )
  {   
      if( EsVacio( f.tar_ope.value ))
          Mensaje = Mensaje + 'Ingrese la Tarjeta de Operaciones. \n';    
      
      if ( EsVacio(f.fch_ini.value) )
      { Mensaje = Mensaje + 'Ingrese la Fecha Inicial. \n';
      }
      else
        if( !EsFecha( f.fch_ini.value ))
          Mensaje = Mensaje + 'La Fecha Inicial es inv�lida. \n';        
      if ( EsVacio(f.fch_fin.value) )
      {   Mensaje = Mensaje + 'Ingrese la Fecha de Vencimiento. \n'; 
      }  
      else
      { if( !EsFecha( f.fch_fin.value ))
          Mensaje = Mensaje + 'La Fecha de Vencimiento es inv�lida. \n';    
      }  
      if ( EsFecha(f.fch_ini.value) && EsFecha(f.fch_fin.value) )
        if( !fMayorOIgualQue(f.fch_fin.value, f.fch_ini.value) )
          Mensaje = Mensaje + 'El Rango de Fechas es inv�lido. \n';  
  }
  if( EsVacio( f.tbl_obs.value ) )
      Mensaje = Mensaje + 'Ingrese la Observaci�n. \n';    
  if( Mensaje == "" )
  {  
       return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }      
};

function fGarantiaVeh()
{ var Mensaje = "";
  f = document.forms[0];

  if( EsVacio( f.ope_nit.value ) || f.ope_nit.value == "%" || f.ope_nit.value.indexOf("%") > -1 )
      Mensaje = Mensaje + 'Ingrese el Nit del Operador. \n';
  if( EsVacio( f.gar_nro.value) )
      Mensaje = Mensaje + 'Ingrese el N�mero de Garant�a. \n';
  if( f.nro_placa.value == "%" )
      Mensaje = Mensaje + 'Elija el N�mero de la Placa. \n';    
  if( EsVacio( f.mnt_placa.value ) )
      Mensaje = Mensaje + 'Ingrese el Monto de la Placa. \n';            
  else
    if ( !EsNro(f.mnt_placa.value) )
      Mensaje = Mensaje + 'El Monto de la Placa debe ser num�rico. \n';         
    else
      if ( f.mnt_placa.value <= 100 )
        Mensaje = Mensaje + 'El Monto de la Placa debe ser mayor a 100. \n';          
  if( EsVacio( f.tbl_obs[1].value ) )
      Mensaje = Mensaje + 'Ingrese la Observaci�n. \n';    
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }            
};

function fParqueAut()
{ var Mensaje = "";
  f = document.forms[0];

  if( EsVacio( f.ope_nit.value ) || f.ope_nit.value == "%" || f.ope_nit.value.indexOf("%") > -1 )
      Mensaje = Mensaje + 'Ingrese el Nit del Operador. \n';
  if( EsVacio( f.nro_placa.value) )
      Mensaje = Mensaje + 'Ingrese el N�mero de la Placa. \n';    
  else
    if ( !EsAlfaNumerico(f.nro_placa.value) )
      Mensaje = Mensaje + 'La Placa es inv�lida. \n';       
  if ( !EsVacio(f.fch_ini.value) )
  { if( !EsFecha( f.fch_ini.value ))
      Mensaje = Mensaje + 'La Fecha Inicial es inv�lida. \n';    
  }
  else
      Mensaje = Mensaje + 'Ingrese la Fecha Inicial. \n';    
  if ( !EsVacio(f.fch_fin.value) )
  { if( !EsFecha( f.fch_fin.value ))
      Mensaje = Mensaje + 'La Fecha Final es inv�lida. \n';    
  }
  if ( EsFecha(f.fch_ini.value) && EsFecha(f.fch_fin.value) )
    if( !fMayorOIgualQue(f.fch_fin.value, f.fch_ini.value) )
      Mensaje = Mensaje + 'El Rango de Fechas es inv�lido. \n';      
  if( EsVacio( f.tbl_obs.value ) )
      Mensaje = Mensaje + 'Ingrese la Observaci�n. \n';    
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }
};

function fRutas()
{ var Mensaje = "";
  f = document.forms[0];  
  if( EsVacio( f.ope_nit.value ) || f.ope_nit.value == "%" || f.ope_nit.value.indexOf("%") > -1 )
      Mensaje = Mensaje + 'Ingrese o verifique el Nit del Operador. \n';  
  if( f.nro_placa.value == "%" )
      Mensaje = Mensaje + 'Elija el N�mero de la Placa. \n';       
  if ( f.rta_cod.value == "%")
      Mensaje = Mensaje + 'Elija el c�digo de la Ruta. \n';       
  if( EsVacio( f.rta_cod.value) )
      Mensaje = Mensaje + 'Ingrese el N�mero de la Placa. \n';           
  if( EsVacio( f.tbl_obs.value ) )
      Mensaje = Mensaje + 'Ingrese la Observaci�n. \n';    
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }
};

function fRegimen(op)
{ var Mensaje = "";
  f = document.forms[0];
  if (op != "Desbloqueo")
  {   if ( EsVacio(f.ope_nit.value) || f.ope_nit.value == "%" || f.ope_nit.value.indexOf("%") > -1 )
        Mensaje = Mensaje + 'Ingrese o verifique el Nit del Operador. \n';    
      if ( f.cp4_cod.value == "%" )
        Mensaje = Mensaje + 'Elija el R�gimen. \n';    
      if ( !EsVacio(f.fch_ini.value) )
      { if( !EsFecha( f.fch_ini.value ))
          Mensaje = Mensaje + 'La Fecha Inicial es inv�lida. \n';    
        else
          if( !fMayorOIgualQue(f.fch_ini.value, hoy) )
            Mensaje = Mensaje + 'La Fecha Inicial no puede ser anterior a la Actual. \n';
          else
            if ( fechaIgualQue(f.fch_ini.value, hoy) )
              Mensaje = Mensaje + 'La Fecha Inicial debe ser posterior a la Actual. \n';
      } 
      else
          Mensaje = Mensaje + 'Ingrese la Fecha Inicial. \n';    
      if ( !EsVacio(f.fch_fin.value) )
      { if( !EsFecha( f.fch_fin.value ))
          Mensaje = Mensaje + 'La Fecha Final es inv�lida. \n';          
      }
      if ( EsFecha(f.fch_ini.value) && EsFecha(f.fch_fin.value) )
        if( !fMayorOIgualQue(f.fch_fin.value, f.fch_ini.value) )
          Mensaje = Mensaje + 'El Rango de Fechas es inv�lido. \n';    
  }
  if( EsVacio( f.tbl_obs.value ) )
      Mensaje = Mensaje + 'Ingrese la Observaci�n. \n';    
    
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }
};

function fDocumentos()
{ var Mensaje = "";
  f = document.forms[0];

  if ( EsVacio(f.ope_nit.value) || f.ope_nit.value == "%" || f.ope_nit.value.indexOf("%") > -1 )
    Mensaje = Mensaje + 'Ingrese o verifique el Nit del Operador. \n';    
  if ( EsVacio(f.atd_cod.value) )
    Mensaje = Mensaje + 'Ingrese el C�digo del Documento. \n';    
  if ( EsVacio(f.nro_ref.value) )
    Mensaje = Mensaje + 'Ingrese el N�mero de Referencia del Documento. \n';        
  if ( EsVacio(f.doc_emi.value) )
    Mensaje = Mensaje + 'Ingrese el Emisor del Documento. \n';        
  if ( !EsVacio(f.fch_emi.value) )
  { if( !EsFecha( f.fch_emi.value ))
      Mensaje = Mensaje + 'La Fecha de Emisi�n es inv�lida. \n';    
    else
    { if( !fMayorOIgualQue(hoy, f.fch_emi.value) )
        Mensaje = Mensaje + 'La Fecha de Emisi�n no puede ser posterior a la actual. \n';
    }
  }
  else
      Mensaje = Mensaje + 'Ingrese la Fecha de Emisi�n. \n';        
  if ( !EsVacio(f.fch_ini.value) )
  { if( !EsFecha( f.fch_ini.value ))
      Mensaje = Mensaje + 'La Fecha Inicial es inv�lida. \n';    
  }
  else
      Mensaje = Mensaje + 'Ingrese la Fecha Inicial. \n';    
  if ( !EsVacio(f.fch_fin.value) )
  { if( !EsFecha( f.fch_fin.value ))
      Mensaje = Mensaje + 'La Fecha Final es inv�lida. \n';    
  }
  if ( EsFecha(f.fch_ini.value) && EsFecha(f.fch_fin.value) )
    if( !fMayorOIgualQue(f.fch_fin.value, f.fch_ini.value) )
      Mensaje = Mensaje + 'El Rango de Fechas es inv�lido. \n';      
  if( EsVacio( f.tbl_obs.value ) )
      Mensaje = Mensaje + 'Ingrese la Observaci�n. \n';    
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }            
};

function fAutorizacion()
{ var Mensaje = "";
  f = document.forms[0];
  if ( EsVacio(f.ope_nit.value) || f.ope_nit.value == "%" || f.ope_nit.value.indexOf("%") > -1 )
    Mensaje = Mensaje + 'Ingrese o verifique el Nit del Operador. \n';      
  if ( f.tip_aut.value == "%" )
    Mensaje = Mensaje + 'Elija el Tipo de Autorizaci�n. \n';  
  if (f.ope_tip.value == "TRE")
    if ( EsVacio(f.res_amplia.value) )
    Mensaje = Mensaje + 'Ingrese la Resoluci�n del Viceministerio. \n';  
  if ( EsVacio(f.fch_emi.value) )
    Mensaje = Mensaje + 'Ingrese la Fecha de Emisi�n. \n';  
  else
  { if ( !EsFecha (f.fch_emi.value) )
    { Mensaje = Mensaje + 'La Fecha de Emisi�n es inv�lida. \n';  
    }
    else
    {
      if( !fMayorOIgualQue(hoy, f.fch_emi.value) )
        Mensaje = Mensaje + 'La Fecha de Emisi�n no puede ser posterior a la Fecha Actual. \n';
    }
  }
  if ( EsVacio(f.fch_hab.value) )
    Mensaje = Mensaje + 'Ingrese la Fecha de Habilitaci�n. \n';  
  else
  { if ( !EsFecha (f.fch_hab.value) )
    { Mensaje = Mensaje + 'La Fecha de Habilitaci�n es inv�lida. \n';  
    }
    else
    {
      if( !fMayorOIgualQue(hoy, f.fch_hab.value) )
        Mensaje = Mensaje + 'La Fecha de Habilitaci�n no puede ser posterior a la Fecha Actual. \n';
    }
  }
  if( EsVacio( f.tbl_obs.value ) )
      Mensaje = Mensaje + 'Ingrese la Observaci�n. \n';    
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }            
};

function fFiltro( form )
{ var Mensaje = "";
  f = document.forms[0];

  if ( EsVacio(f.l_ope_nit.value) )
    Mensaje = Mensaje + 'Ingrese el Nit del Operador (% comodin). \n';    
  if (form != "Operador" && form != "Regimenes" && form != "UsuarioSid"&& form != "Jurisdiccion")
  { if (f.l_ope_tip.value == "0")
      Mensaje = Mensaje + 'Elija el Tipo de Operador. \n';    
  }        
  if( form == "Representante" )
  { if( EsVacio(f.l_rep_cod.value) )
      Mensaje = Mensaje + 'Ingrese el N�mero del Documento del Representante (% comodin). \n';    
  }
  if( form == "Despachante" )
  { if( EsVacio(f.l_des_cod.value) )
      Mensaje = Mensaje + 'Ingrese el N�mero del Documento del Despachante (% comodin). \n';    
  }
  if( form == "Socio" )
  { if( EsVacio(f.l_soc_cod.value) )
      Mensaje = Mensaje + 'Ingrese el N�mero del Documento del Socio (% comodin). \n';    
  }
  if( form == "Localizacion" )
  { if( EsVacio(f.l_loc_cod.value) )
      Mensaje = Mensaje + 'Ingrese el C�digo de la Localizaci�n (% comodin). \n';    
  }  
  if( form == "Garantia" )
  { if( EsVacio(f.l_gar_nro.value) )
      Mensaje = Mensaje + 'Ingrese el N�mero de la Garant�a (% comodin). \n';    
  }
  if( form == "Vehiculo" )
  { if( EsVacio(f.l_nro_placa.value) )
      Mensaje = Mensaje + 'Ingrese el N�mero de la Placa (% comodin). \n';    
  }  
  if( form == "GarantiaVeh" )
  { if( EsVacio(f.l_gar_nro.value) )
      Mensaje = Mensaje + 'Ingrese el N�mero de la Garant�a (% comodin). \n';    
    if( EsVacio(f.l_nro_placa.value) )
      Mensaje = Mensaje + 'Ingrese el N�mero de la Placa (% comodin). \n';      
  }
  if( form == "Parque" )
  { if( EsVacio(f.l_nro_placa.value) )
      Mensaje = Mensaje + 'Ingrese el N�mero de la Placa (% comodin). \n';    
  }
  if( form == "Rutas" )
  { if( EsVacio(f.l_nro_placa.value) )
      Mensaje = Mensaje + 'Ingrese el N�mero de la Placa (% comodin). \n';    
  }
  if( form == "Autorizacion" )
  { if( EsVacio(f.l_nro_aut.value) )
      Mensaje = Mensaje + 'Ingrese el N�mero de la Autorizaci�n. \n';    
  }  
  if( form == "Tiendas" )
  { if( EsVacio(f.l_nro_tnd.value) )
      Mensaje = Mensaje + 'Ingrese el N�mero de Tienda. \n';    
  }  
  if( form == "ShowRooms" )
  { if( EsVacio(f.l_nro_shr.value) )
      Mensaje = Mensaje + 'Ingrese el N�mero del Show Room. \n';    
  }  
  if( form == "UsuarioZF" )
  { if( EsVacio(f.l_ope_nit_uzf.value) )
      Mensaje = Mensaje + 'Ingrese el NIT del Usuario de Zona Franca. \n';    
  }  
  if( form == "Regimenes" )
  { if( EsVacio(f.l_cp4_cod.value) )
      Mensaje = Mensaje + 'Ingrese el R�gimen. \n';    
  }
  if (form == "DepositoAer")
  {
    if( EsVacio(f.l_dea_cod.value) )
      Mensaje = Mensaje + 'Ingrese el C�digo del Dep�sito Aeron�utico. \n';
  }
  if (form != "UsuarioSid")
  {
    if ( EsVacio(f.l_usr_mod.value) )
      f.l_usr_mod.value = "%";      
  }
  
  if ( !EsVacio(f.l_fch_ini.value) )
  { if( f.l_fch_ini.value != "%" )
      if( !EsFecha( f.l_fch_ini.value ))
      Mensaje = Mensaje + 'La Fecha Inicial es inv�lida. \n';    
  }
  if ( !EsVacio(f.l_fch_fin.value) )
  { if( f.l_fch_fin.value != "%" )
      if( !EsFecha( f.l_fch_fin.value ))
        Mensaje = Mensaje + 'La Fecha Final es inv�lida. \n';    
  }
  if ( EsFecha(f.l_fch_ini.value) && EsFecha(f.l_fch_fin.value) )
    if( !fMayorOIgualQue(f.l_fch_fin.value, f.l_fch_ini.value) )
      Mensaje = Mensaje + 'El Rango de Fechas es inv�lido. \n';    
  
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }
};

function fCconfigura()
{ var Mensaje = "";
  f = document.forms[0];

  if ( EsVacio(f.base_calculo_gar.value) )
    Mensaje = Mensaje + 'Ingrese la Base para calcular la Garant�a. \n';    
  else
    if ( !EsNro(f.base_calculo_gar.value) )
      Mensaje = Mensaje + 'La Base para Calcular la Garant�a es inv�lida. \n';    
  if ( EsVacio(f.nro_nit.value) )
    Mensaje = Mensaje + 'Ingrese el �ltimo N�mero de NIT, debido que a partir de ese N�mero se generar�n los siguientes. \n'; 
  else
    if ( !EsNro(f.nro_nit.value) )
      Mensaje = Mensaje + 'El N�mero de NIT es inv�lido. \n';   
  if ( EsVacio(f.emp_cod.value) )
    Mensaje = Mensaje + 'Ingrese el �ltimo c�digo del Operador, debido que a partir de ese N�mero se generar�n los siguientes. \n'; 
  else
    if ( !EsNro(f.emp_cod.value) )
      Mensaje = Mensaje + 'El c�digo del Operador es inv�lido. \n';   
  if ( EsVacio(f.trp_cod.value) )
    Mensaje = Mensaje + 'Ingrese el �ltimo c�digo de la Unidad de Transporte, debido que a partir de ese N�mero se generar�n los siguientes. \n'; 
  else
    if ( !EsNro(f.trp_cod.value) )
      Mensaje = Mensaje + 'El c�digo de la Unidad de Transporte es inv�lido. \n';   
  if ( EsVacio(f.nro_aut.value) )
    Mensaje = Mensaje + 'Ingrese el �ltimo N�mero de Autorizaci�n, debido que a partir de ese N�mero se generar�n los siguientes. \n'; 
  else
    if ( !EsNro(f.nro_aut.value) )
      Mensaje = Mensaje + 'El N�mero de la Autorizaci�n es inv�lido. \n';   
  if ( EsVacio(f.sol_cod.value) )
    Mensaje = Mensaje + 'Ingrese el �ltimo N�mero de Solicitud, debido que a partir de ese N�mero se generar�n los siguientes. \n'; 
  else
    if ( !EsNro(f.sol_cod.value) )
      Mensaje = Mensaje + 'El N�mero de solicitud es inv�lido. \n'; 
  if( EsVacio( f.tbl_obs.value ) )
      Mensaje = Mensaje + 'Ingrese la Observaci�n. \n'; 
      
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }
};

function fIncomp()
{ var Mensaje = "";
  f = document.forms[0];
  if (f.ope_tip.value == "%")
    Mensaje = Mensaje + "Elija el tipo de Operador. \n ";
  if (f.vigencia.value == "PERMANENTE")
  { if ( !EsVacio(f.ope_nit.value) )
    { Mensaje = Mensaje + "La Incompatibilidad Permanente no debe llevar un NIT espec�fico. \n ";}
  }  
  if ( !EsVacio(f.fch_ini.value) )
  { if( !EsFecha( f.fch_ini.value ))
      Mensaje = Mensaje + 'La Fecha Inicial es inv�lida. \n';    
    else
      if( !fMayorOIgualQue(f.fch_ini.value, hoy) && f.accion.value != "Modificar")
        Mensaje = Mensaje + 'La Fecha Inicial no pude ser anterior a la Actual. \n'; 
      
  }
  else
    Mensaje = Mensaje + 'Ingrese la Fecha Inicial. \n';    
    
  if ( !EsVacio(f.fch_fin.value) )
  { if (f.vigencia.value == "PERMANENTE")
      f.fch_fin.value = "";
    else
      if( !EsFecha( f.fch_fin.value ))
        Mensaje = Mensaje + 'La Fecha Final es inv�lida. \n';    
  }
  else
  { if (f.vigencia.value == "TEMPORAL")
    { Mensaje = Mensaje + 'Ingrese la Fecha Final. \n';}
  }
  if ( EsFecha(f.fch_ini.value) && EsFecha(f.fch_fin.value) )
    if( !fMayorOIgualQue(f.fch_fin.value, f.fch_ini.value) )
      Mensaje = Mensaje + 'El Rango de Fechas es inv�lido. \n';    
  
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }  
};

function fCoreq_doc(op)
{ var Mensaje = "";
  f = document.forms[0];  
  if (op == 1)
  { if( EsVacio( f.req_cod[0].value ) )
      Mensaje = Mensaje + 'Ingrese C�digo del Formulario. \n';     
    if( EsVacio( f.req_dsc.value ) )
      Mensaje = Mensaje + 'Ingrese Desccripci�n del Formulario. \n';         
  }
  if (op == 2)
  { if (f.ope_tip.value == "%")
      Mensaje = Mensaje + 'Elija el Tipo de Operador. \n';     
    if (f.req_cod[1].value == "%")
      Mensaje = Mensaje + 'Elija el Documento. \n';     
  }
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }
};

function fCoreq_ope()
{  var Mensaje = "";
    f = document.forms[0];
    if( EsVacio( f.req_cod.value ) )
      Mensaje = Mensaje + 'Ingrese el C�digo del formulario. \n'; 
    if( EsVacio( f.req_dsc.value ) )
      Mensaje = Mensaje + 'Ingrese el Formulario. \n';   
    if( EsVacio( f.sig_paso.value ) )
      Mensaje = Mensaje + 'Ingrese el C�digo interno. \n';     
    if( EsVacio( f.tbl_obs.value ) )
      Mensaje = Mensaje + 'Ingrese la Observaci�n. \n'; 
      
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }
};

function fTiendas()
{ var Mensaje = "";
    f = document.forms[0];
    if( EsVacio( f.ope_nit.value ) || f.ope_nit.value == "%"|| f.ope_nit.value.indexOf("%") > -1 )
      Mensaje = Mensaje + 'Ingrese o verifique el N�mero de Nit del Operador. \n';   
    if( EsVacio( f.nro_tnd.value ) )    
      Mensaje = Mensaje + 'Ingrese el N�mero de Tienda. \n';   
    if ( f.cuo_cod.value == "%")
      Mensaje = Mensaje + 'Elija el Aeropuerto. \n';   
    if( EsVacio( f.dir_dom.value ) )
      Mensaje = Mensaje + 'Ingrese el Domicilio. \n';        
    if( !EsVacio( f.nro_tlf.value ) )
    if ( !EsTelefono(f.nro_tlf.value) )
      Mensaje = Mensaje + 'El N�mero de Tel�fono es incorrecto. \n';        
  if( !EsVacio( f.nro_fax.value ) )
    if ( !EsTelefono(f.nro_fax.value) )
      Mensaje = Mensaje + 'El N�mero de Fax es incorrecto. \n';        
  if( !EsVacio( f.e_mail.value ) )
    if ( !EsEmail(f.e_mail.value) )
      Mensaje = Mensaje + 'El E-mail es incorrecto. \n';     
  if( EsVacio( f.tbl_obs.value ) )
      Mensaje = Mensaje + 'Ingrese la Observaci�n. \n'; 
      
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }
};


function fShowRoom()
{ var Mensaje = "";
    f = document.forms[0];
    if( EsVacio( f.ope_nit.value ) || f.ope_nit.value == "%"|| f.ope_nit.value.indexOf("%") > -1 )
      Mensaje = Mensaje + 'Ingrese o verifique el N�mero de Nit del Operador. \n';   
    if( EsVacio( f.nro_shr.value ) )
      Mensaje = Mensaje + 'Ingrese el N�mero de Show Room. \n';   
    if ( f.cuo_cod.value == "%")
      Mensaje = Mensaje + 'Elija la Administraci�n Aduanera. \n';   
    if( EsVacio( f.dir_dom.value ) )
      Mensaje = Mensaje + 'Ingrese el Domicilio. \n';        
    if( !EsVacio( f.nro_tlf.value ) )
    if ( !EsTelefono(f.nro_tlf.value) )
      Mensaje = Mensaje + 'El N�mero de Tel�fono es incorrecto. \n';        
  if( !EsVacio( f.nro_fax.value ) )
    if ( !EsTelefono(f.nro_fax.value) )
      Mensaje = Mensaje + 'El N�mero de Fax es incorrecto. \n';        
  if( EsVacio( f.tbl_obs.value ) )
      Mensaje = Mensaje + 'Ingrese la Observaci�n. \n'; 
      
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }
};

function fUsuarioZF()
{ var Mensaje = "";
  f = document.forms[0];
  if( EsVacio( f.ope_nit.value ) || f.ope_nit.value == "%")
      Mensaje = Mensaje + 'Ingrese el NIT del Concesionario de Zona Franca. \n';
  if ( f.cuo_cod.value == "%")
      Mensaje = Mensaje + 'Elija la Zona Franca. \n';
  if( EsVacio( f.ope_nit_uzf.value ) )
      Mensaje = Mensaje + 'Ingrese el Nit del Usuario. \n';
  if (f.sw_enc.value == "false")
  { if( EsVacio( f.nom_rzs.value ) )
        Mensaje = Mensaje + 'Ingrese la Raz�n Social del Operador. \n';
    if ( f.cns_cod.value == "%")  
        Mensaje = Mensaje + 'Elija Constituci�n de Empresa. \n';
    if( EsVacio( f.dir_zon.value ) )
        Mensaje = Mensaje + 'Ingrese la Zona. \n';    
    if( EsVacio( f.dir_dom.value ) )
        Mensaje = Mensaje + 'Ingrese el Domicilio. \n';        
    if( EsVacio( f.nro_dom.value ) )
        Mensaje = Mensaje + 'Ingrese el N�mero del Domicilio. \n';        
    else
      if ( !EsAlfaNumerico(f.nro_dom.value) )
        Mensaje = Mensaje + 'El N�mero del Domicilio es inv�lido. \n';      
    if( !EsVacio( f.edf_pso.value ) )
      if ( !EsAlfaNumerico(f.edf_pso.value) )
        Mensaje = Mensaje + 'El Piso es inv�lido. \n';      

    if( !EsVacio( f.dir_ofi.value ) )
      if ( !EsAlfaNumerico(f.dir_ofi.value) )
        Mensaje = Mensaje + 'El N�mero de Oficina es inv�lido. \n';   

    if( !EsVacio( f.nro_tlf.value ) )
      if ( !EsTelefono(f.nro_tlf.value) )
        Mensaje = Mensaje + 'El N�mero de Tel�fono es incorrecto. \n';        
    if( !EsVacio( f.nro_fax.value ) )
      if ( !EsTelefono(f.nro_fax.value) )
        Mensaje = Mensaje + 'El N�mero de Fax es incorrecto. \n';        
    if( !EsVacio( f.e_mail.value ) )
      if ( !EsEmail(f.e_mail.value) )
        Mensaje = Mensaje + 'El E-mail es incorrecto. \n';     
    if( EsVacio( f.nro_mat.value ) )
      Mensaje = Mensaje + 'Ingrese el N�mero de Matr�cula (FUNDEMPRESA). \n';        
  }
  
  if( EsVacio( f.nro_cto.value ) )
      Mensaje = Mensaje + 'Ingrese el N�mero de Contrato. \n';        
  else
    if ( !EsAlfaNumerico(f.nro_cto.value) )
      Mensaje = Mensaje + 'El N�mero de Contrato es inv�lido. \n';   
  if ( !EsVacio(f.fch_ini.value) )
  { if( !EsFecha( f.fch_ini.value ))
      Mensaje = Mensaje + 'La Fecha Inicial es inv�lida. \n';    
  }
    else
        Mensaje = Mensaje + 'Ingrese la Fecha Inicial. \n';    
    if ( !EsVacio(f.fch_fin.value) )
    { if( !EsFecha( f.fch_fin.value ))
        Mensaje = Mensaje + 'La Fecha Final es inv�lida. \n';    
    }
    if ( EsFecha(f.fch_ini.value) && EsFecha(f.fch_fin.value) )
      if( f.fch_ini.value == f.fch_fin.value )
        Mensaje = Mensaje + 'La Fecha de Vencimiento debe ser mayor a la de Inicio. \n';    
      else
        if ( !fMayorOIgualQue(f.fch_fin.value, f.fch_ini.value) )
          Mensaje = Mensaje + 'El Rango de Fechas es inv�lido. \n';    
        else
          if( !fMayorOIgualQue(f.fch_fin.value, hoy) )
            Mensaje = Mensaje + 'La Fecha de Vencimiento no debe ser anterior a la Fecha Actual . \n';    

    if( EsVacio( f.rep_cod.value ) )
        Mensaje = Mensaje + 'Ingrese el Documento del Representante. \n';  
  else
    if ( !EsNro(f.rep_cod.value) )
      Mensaje = Mensaje + 'El Documento del Representante es inv�lido. \n';  
  if( EsVacio( f.lug_emi.value ) )
      Mensaje = Mensaje + 'Ingrese el Lugar de Emisi�n del Documento de Identidad del Representante. \n';      
  else
    if( !EsCadena( f.lug_emi.value ) )
      Mensaje = Mensaje + 'El Lugar de Emisi�n del Documento de Identidad es incorrecto. \n'; 
  if( EsVacio( f.rep_nom.value ) )
      Mensaje = Mensaje + 'Ingrese el Nombre del Representante. \n';  
  if( EsVacio( f.rep_ap.value ) )
      Mensaje = Mensaje + 'Ingrese el Apellido Paterno del Representante. \n';  
  if( EsVacio( f.tbl_obs.value ) )
      Mensaje = Mensaje + 'Ingrese las Observaciones. \n';      
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }
};
function fdepositoAer()
{ var Mensaje = "";
  f = document.forms[0];

  if( EsVacio( f.ope_nit.value ) || f.ope_nit.value == '%' || f.ope_nit.value.indexOf("%") > -1)
      Mensaje = Mensaje + 'Ingrese o verifique el Nit del Operador. \n';
  if (f.dea_cuo.value == "%")
      Mensaje = Mensaje + 'Elija la Administraci�n Aduanera. \n';
  if( EsVacio( f.dea_cod.value ) )
      Mensaje = Mensaje + 'Ingrese el C�digo del Dep�sito. \n';  
    if( EsVacio( f.dea_dsc.value ) )
      Mensaje = Mensaje + 'Ingrese la Descripci�n del Dep�sito. \n';        
  if ( !EsVacio(f.fch_ini.value) )
  { if( !EsFecha( f.fch_ini.value ))
      Mensaje = Mensaje + 'La Fecha Inicial es inv�lida. \n';    
  }
  else
      Mensaje = Mensaje + 'Ingrese la Fecha Inicial. \n';    
  if ( !EsVacio(f.fch_fin.value) )
  { if( !EsFecha( f.fch_fin.value ))
      Mensaje = Mensaje + 'La Fecha Final es inv�lida. \n';    
  }
  if ( EsFecha(f.fch_ini.value) && EsFecha(f.fch_fin.value) )
    if( !fMayorOIgualQue(f.fch_fin.value, f.fch_ini.value) )
      Mensaje = Mensaje + 'El Rango de Fechas es inv�lido. \n';    
  if( EsVacio( f.dir_dom.value ) )
      Mensaje = Mensaje + 'Ingrese el Domicilio. \n';    
  if( !EsVacio( f.nro_tlf.value ) )
    if ( !EsTelefono(f.nro_tlf.value) )
      Mensaje = Mensaje + 'El N�mero de Tel�fono es incorrecto. \n';    
  if( !EsVacio( f.nro_fax.value ) )
    if ( !EsTelefono(f.nro_fax.value) )
      Mensaje = Mensaje + 'El N�mero de Fax es incorrecto. \n';    
  if( EsVacio( f.tbl_obs.value ) )
      Mensaje = Mensaje + 'Ingrese la Observaci�n. \n';  

  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }    
};

function fanexos(op)
{ var Mensaje = "";
  f = document.forms[0];
  var sw = false;  
  if (op != 'Bajas')
  { if( f.ope_age.value == "%" )
      Mensaje = Mensaje + "Elija la Agencia. \n";
    if (EsVacio(f.cuo_cod.value) && f.ope_age.value != "%")
      Mensaje = Mensaje + "La Agencia no tiene Aduanas asociadas. \n";
  }
  if( EsVacio( f.cite.value ) )
      Mensaje = Mensaje + 'Ingrese el Cite. \n';
  if( EsVacio( f.nro_hr.value ) )
      Mensaje = Mensaje + 'Ingrese el n�mero de Hoja de Ruta. \n';
  if( EsVacio( f.nro_nota.value ) )
      Mensaje = Mensaje + 'Ingrese el n�mero de Hoja de Ruta. \n';
  if ( !EsVacio(f.fch_nota.value) )
  { if( !EsFecha( f.fch_nota.value ))
      Mensaje = Mensaje + 'La Fecha de la Nota es inv�lida. \n'; 
      else
      { if( !fMayorOIgualQue(hoy, f.fch_nota.value) )
          Mensaje = Mensaje + 'La Fecha de la Nota no puede ser posterior a la Fecha Actual. \n';
      }
  }
    else
        Mensaje = Mensaje + 'Ingrese la Fecha de la Nota. \n'; 
  for (i=0; i<f.chk_veh.length;i++)
    if (f.chk_veh[i].checked)
      sw = true;
  if (!sw)
    Mensaje = Mensaje + 'Elija las Unidades y/o Medios para el Anexo. \n'
  
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  } 
};
function fUsidunea()
{ var Mensaje = "";
  f = document.forms[0];
  if ( EsVacio(f.usr_log.value) )
  { Mensaje =  Mensaje + 'Ingrese el Login de Usuario. \n'; }
  if ( EsVacio(f.usr_cod.value) )
  { Mensaje =  Mensaje + 'Ingrese el Documento de Identidad del Usuario. \n'; }
  if ( f.tip_doc.value == "%")
  { Mensaje =  Mensaje + 'Elija el Tipo de Documento de Identidad. \n'; }
  if ( EsVacio(f.lug_emi.value) )
  { Mensaje =  Mensaje + 'Ingrese el Lugar de Emisi�n. \n'; }
  if ( EsVacio(f.usr_nom.value) )
  { Mensaje =  Mensaje + 'Ingrese el Nombre del Usuario. \n'; }
  if ( EsVacio(f.usr_ap.value) )
  { Mensaje =  Mensaje + 'Ingrese el Apellido Paterno. \n'; }
  if ( EsVacio(f.tip_trb.value) )
  { Mensaje =  Mensaje + 'Ingrese el �rea de Trabajo. \n'; }
  if ( EsVacio(f.usr_crg.value) )
  { Mensaje =  Mensaje + 'Ingrese el Cargo. \n'; }
  if ( EsVacio(f.usr_sup.value) )
  { Mensaje =  Mensaje + 'Ingrese el nombre del Inmediato Superior. \n'; }
  if (f.emp_cod.value == '0')
  { if ( EsVacio(f.emp_nit.value) )
    { Mensaje =  Mensaje + 'Ingrese el NIT de la Empresa. \n'; }
    if ( EsVacio(f.emp_nom.value) )
    { Mensaje =  Mensaje + 'Ingrese el Nombre de la Empresa. \n'; }
    if ( EsVacio(f.emp_dir.value) )
    { Mensaje =  Mensaje + 'Ingrese la Direcci�n de la Empresa. \n'; }
  }
  if ( EsVacio(f.sol_jst.value) )
  { Mensaje =  Mensaje + 'Ingrese la Justificaci�n. \n'; }
  if ( f.tipo_inst.value == "%")
  { Mensaje =  Mensaje + 'Elija el Tipo de Instalaci�n. \n'; }
  if ( EsVacio(f.tbl_obs.value) )
  { Mensaje =  Mensaje + 'Ingrese las Observaciones. \n'; }
  
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }     
};

function fUsid_prf()
{ var Mensaje = "";
  f = document.forms[0];
  if ( f.cuo_cod.value == "%")
  { Mensaje =  Mensaje + 'Elija la Administraci�n Aduanera. \n'; }
  if ( f.tip_usr.value == "%")
  { Mensaje =  Mensaje + 'Elija el Tipo de Usuario. \n'; }
  if ( f.prf_sol.value == "%")
  { Mensaje =  Mensaje + 'Elija el Perfil. \n'; }
  if ( EsVacio(f.mtr_usr.value) )
  { Mensaje =  Mensaje + 'Ingrese el Motor. \n'; }
  if ( EsVacio(f.tbl_obs1.value) )
  { Mensaje =  Mensaje + 'Ingrese las Observaciones. \n'; }
  
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }
};

function fUso()
{ var Mensaje = "";
  f = document.forms[0];
  if ( EsVacio(f.fch_ini.value) )
  { Mensaje =  Mensaje + 'Ingrese La Fecha Inicial. \n'; }
  else
  { if( !EsFecha( f.fch_ini.value ))
      Mensaje = Mensaje + 'La Fecha Inicial es invalida. \n';
  }
  if ( EsVacio(f.fch_fin.value) )
  { Mensaje =  Mensaje + 'Ingrese las Fecha Final. \n'; }
  else
  { if( !EsFecha( f.fch_fin.value ))
      Mensaje = Mensaje + 'La Fecha Final es invalida. \n';
  }
  if ( EsFecha(f.fch_ini.value) && EsFecha(f.fch_fin.value) )
  {  if( !fMayorOIgualQue(f.fch_fin.value, f.fch_ini.value) )
       Mensaje = Mensaje + 'El Rango de Fechas es inv�lido. \n'; 
  }    
  if( Mensaje == "" )
  {
    return true;
  }
  else
  {
    alert( Mensaje );
    return false;
  }
};