function fEvalua( )
{
  var f = document.forms["consultaForm"];
  var msg = "";

  if( !fNumero(f.numero.value) )
    msg = msg + "El N\372mero de Carpeta a consultar, debe estar expresado en n\372meros.\n";  
    
  if(! (fTrim(f.numero.value)) )
    {
    alert("No ingreso ning\372n par\341metro para realizar la consulta");
    return false;
    }
    
  if( msg=="" )
    return true;
    
  alert( msg );
  return false;  
}




function fEvaluaconnit( )
{
  
  var f = document.forms["connitForm"];
  var msg = "";


  if(! (foFecha(f.dfecini.value)))
    msg = msg + "Fecha Desde es obligatoria, o tiene formato incorrecto.\n"; 

  if(! (foFecha(f.dfecfin.value)))
    msg = msg + "Fecha Hasta es obligatoria, o tiene formato incorrecto.\n";
  else
    if( (fcFechas(  f.dfecfin.value, fechaActual() )))
      msg = msg + "Fecha Desde debe ser menor o igual a la Fecha Actual.\n";
    else
      if( (fcFechas(f.dfecini.value, f.dfecfin.value   )))
        msg = msg + "Fecha Desde debe ser menor o igual a la Fecha Hasta.\n";



  if(! (fTrim(f.numero.value)) )
   msg = msg + "El N\372mero de NIT, es obligatorio.\n";
  else  
    if( !fNumero(f.numero.value) )
      msg = msg + "El N\372mero de NIT a consultar, debe estar expresado en n\372meros.\n"; 
    
  if( msg=="" )
    return true;
    
  alert( msg );
  return false;  
}

function fEvaluaasicar( )
{
  
  var f = document.forms["asicarForm"];
  var msg = "";

  if(! (fTrim(f.numero.value)) )
   msg = msg + "El N\372mero de Carpeta, es obligatorio.\n";
  else
    if( !fNumero(f.numero.value) )
      msg = msg + "El N\372mero de Carpeta a consultar, debe estar expresado en n\372meros.\n";  
  if(! (fTrim(f.nit.value)) )
   msg = msg + "El N\372mero de NIT, es obligatorio.\n";
  else  
    if( !fNumero(f.nit.value) )
      msg = msg + "El N\372mero de NIT a consultar, debe estar expresado en n\372meros.\n"; 
    
  if( msg=="" )
    return true;
    
  alert( msg );
  return false;  
}

function fEvaluadiscar( )
{

  var f = document.forms["discarForm"];
  var msg = "";
  if(! (fTrim(f.desde.value)) )
   msg = msg + "El N\372mero de Carpeta Desde, es obligatorio.\n";
  else
    if( !fNumero(f.desde.value) )
      msg = msg + "El N\372mero de Carpeta a consultar, debe estar expresado en n\372meros.\n";  

  if(! (fTrim(f.hasta.value)) )
   msg = msg + "El N\372mero de Carpeta Hasta, es obligatorio.\n";
  else
      if( !fNumero(f.hasta.value) )
        msg = msg + "El N\372mero de Carpeta a consultar, debe estar expresado en n\372meros.\n";  

  if(! (fTrim(f.aduana.value)) )
    msg = msg + "Debe seleccionar una Gerencia.\n";  
    
  if( msg=="" )
    return true;
    
  alert( msg );
  return false;  
}

function fEvaluacondis( )
{

  var f = document.forms["condisForm"];
  var msg = "";
  


  if(! (foFecha(f.dfecini.value)))
    msg = msg + "Fecha Desde es obligatoria, o tiene formato incorrecto.\n"; 

  if(! (foFecha(f.dfecfin.value)))
    msg = msg + "Fecha Hasta es obligatoria, o tiene formato incorrecto.\n";
  else
    if( (fcFechas(  f.dfecfin.value, fechaActual() )))
      msg = msg + "Fecha Desde debe ser menor o igual a la Fecha Actual.\n";
    else
      if( (fcFechas(f.dfecini.value, f.dfecfin.value   )))
        msg = msg + "Fecha Desde debe ser menor o igual a la Fecha Hasta.\n";


  
  if(! (fTrim(f.aduana.value)) )
    msg = msg + "Debe seleccionar una Gerencia.\n";  
    
  if( msg=="" )
    return true;
    
  alert( msg );
  return false;  
}


function fEvalua3( )
{
  var f = document.forms["carpetaForm"];
  var msg = "";

  if(f.observacion.value.length > 100)
    {
    alert("La observaci\363n, no debe ser mayor a 100 caracteres");
    return false;
    }
 
  if(! (fTrim(f.observacion.value)) )
    {
    alert("Debe colocar una observaci\363n, para la baja del n\372mero de carpeta");
    return false;
    }
    
  if( msg=="" )
    return confirm("Desea continuar  ?");
    
  alert( msg );
  return false;  
}

function fEvalua4( )
{
  var f = document.forms["carpetaForm"];
  var msg = "";
  
  if(f.observacion.value.length > 100)
    {
    alert("La observaci\363n, no debe ser mayor a 100 caracteres");
    return false;
    }
 
  if(! (fTrim(f.observacion.value)) )
    {
    alert("Debe colocar una observaci\363n, para la rehabilitaci\363n del n\372mero de carpeta");
    return false;
    }
    
  if( msg=="" )
    return confirm("Desea continuar ?");
    
  alert( msg );
  return false;  
}

function fEvaluaparam( )
{
  
  var f = document.forms["ParametrosForm"];
  var msg = "";

  if(! (fTrim(f.maximo.value)) )
   msg = msg + "El N\372mero de Carpeta, es obligatorio.\n";
  else  
    if( !fNumero(f.maximo.value) )
      msg = msg + "El N\372mero de Carpeta, debe estar expresado en n\372meros.\n"; 
    
  if( msg=="" )
    return true;
    
  alert( msg );
  return false;  
}


function fEvaluaverif( )
{
  
  var f = document.forms["verificaForm"];
  var msg = "";

  if(! (fTrim(f.numero.value)) )
   msg = msg + "El N\372mero de Carpeta, es obligatorio.\n";
  else  
    if( !fNumero(f.numero.value) )
      msg = msg + "El N\372mero de Carpeta, debe estar expresado en n\372meros.\n"; 
    
  if( msg=="" )
    return true;
    
  alert( msg );
  return false;  
}


function fEvaluacon( )
{
  
  var f = document.forms["consultaForm"];
  var msg = "";

  if(! (fTrim(f.numero.value)) )
   msg = msg + "El N\372mero de Carpeta, es obligatorio.\n";
  else  
    if( !fNumero(f.numero.value) )
      msg = msg + "El N\372mero de Carpeta, debe estar expresado en n\372meros.\n"; 
    
  if( msg=="" )
    return true;
    
  alert( msg );
  return false;  
}

function fEvalua2( )
{
  var f = document.forms["carpetaForm"];
  var msg = "";

 if(! (fTrim(f.numero.value)) )
   msg = msg + "El N\372mero de Carpeta, es obligatorio.\n";
  else  
    if( !fNumero(f.numero.value) )
      msg = msg + "El N\372mero de Carpeta, debe estar expresado en n\372meros.\n"; 

    
  if( msg=="" )
    return true;
    
  alert( msg );
  return false;  
}

function validaPassword( )
{
  var Mensaje = "";
  f = document.forms["PasswordForm"];
 
  if( ! fTrim( f.txt_pasant.value ) )
    Mensaje = Mensaje + "'Anterior Contrase\361a' es obligatorio\n";
  if( ! fTrim( f.txt_pas.value ) )
    Mensaje = Mensaje + "'Nueva Contrase\361a' es obligatorio\n";
  if( ! fTrim( f.txt_confPas.value ) )
    Mensaje = Mensaje + "'Confirmaci\363n Contrase\361a' es obligatorio\n";
  if( f.txt_pas.value != f.txt_confPas.value )
    Mensaje = Mensaje + "'Nueva Contrase\361a' y 'Confirmaci\363n Contrase\361a' no son iguales\n";

  if( Mensaje == "" )
    return confirm('Esta seguro de continuar!!!!');
  else
  {
    Mensaje = Mensaje + "\n... corrija los anteriores errores para continuar";
    alert( Mensaje );
    return false;
  }
}


function fNumero( texto )
{
  var mascara = new RegExp("^[0-9]{0,150}$","g");
  return mascara.test( texto )
}


function fTrim( texto )
{
  aux = Trim( texto );
  if( aux == "" ) 
    return false;
  else
    return true;
}  

function Trim ( texto )
{
  if (texto.length) 
  {
    while( '' + texto.charAt(0) == " " )
    {
      texto = texto.substring( 1, texto.length);
    }
  }
  return texto;
}

function trimm(stringToTrim) {

return stringToTrim.replace(/^\s+|\s+$/g,"");
}

function fechaActual()
  {
    var hoy = new Date();
    var dia=hoy.getDate();
    var mes=hoy.getMonth()+1;
    var anio=hoy.getFullYear();
    str_dia = new String (dia) 
    if (str_dia.length == 1) 
        dia = "0" + dia 
    str_mes = new String (mes) 
    if (str_mes.length == 1) 
        mes = "0" + mes 
    str_anio = new String (anio) 
    if (str_anio.length == 2) 
        anio = "20" + anio
    fechaImprimible = dia + "/" + mes + "/" + anio
    return fechaImprimible;
  }

function fFecha( texto )
{
  var mascara = new RegExp("^[0-3]{1}[0-9]{1}/(01|02|03|04|05|06|07|08|09|10|11|12)/[1-2][0-9]{3}$","g");
  if (texto.length)
  {
    if( mascara.test(texto) )
    {
      var dd = texto.substring( 0,  2);
      var mm = texto.substring( 3,  5);
      var aa = texto.substring( 6, 10);
  
      if( aa<1960 || aa>2030 ) return false; //verficar con la fecha actual
      if( dd==0 ) return false;
      if( mm==4 || mm==6 || mm==9 || mm==11 )
      if( dd>30 ) return false;
      if( mm==2 )
      {
        var dias = aa%4 ? 28 : 29;
        if( dd>dias ) return false;
      }
      else
        if( dd>31) return false;
      return true;
    }
    else
      return false;
  }
  else
    return true;
}

function foFecha( texto )
{
  return ( fTrim(texto) && fFecha(texto) );
}

function fcFechas( fecini, fecfin )
{
  var fini = fecini.substring( 6, 10) + fecini.substring( 3, 5) + fecini.substring( 0, 2);
  var ffin = fecfin.substring( 6, 10) + fecfin.substring( 3, 5) + fecfin.substring( 0, 2);
  if( fini > ffin )
    return true;
  else
    return false;
}
