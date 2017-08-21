function bloquea() {
f = document.forms[1];
f.InicioForm.disabled = true;
f.breg_nber.disabled = true;

}

function expandcollapse2(obj)
{

f = document.forms[1];
 
 var div = document.getElementById(obj);
 if ( f.radio[0].checked)
   {
		f.div.style.display = "block";
		}
		else
		 {
		f.div.style.display = "none";
		}

};

function fSubmit()
{ f = document.forms[1];
  f.submit();
};

function esNumero()
{ key=window.event.keyCode; //codigo de tecla. 
  if (key < 48 || key > 57)//si no es numero 
  {    if (key != 44) //no es coma
       {   window.event.keyCode=0; }   //anula la entrada de texto. 
  }
};

function IsNumero(numero)
{ 
      if (numero!= ""){
         for (i = 0; i < numero.length; i++) {
                if (numero.charAt(i) < '0' || numero.charAt(i) > '9'){
                        return false;
              }
          }
          return true;
      }
      return false;
};

function esHora(hora)
{  res = 0;
   if ((hora.substr(2,1) == ":") && (hora.substr(5,1) == ":"))
   {  
       if (parseInt (hora.substr(0,2)) > 24)
          res = 1;
       else
         if (parseInt (hora.substr(3,2)) > 59)
            res = 1;
         else
            if (parseInt (hora.substr(5,2)) > 59)
               res = 1;
   }   
   else
       res = 1;
   if (res == 0)
       return true;
   else
       return false;
};

function esHoraSum(hora)
{  var res = 0;
   if ((hora.substr(2,1) == ":"))
   {  
       if (parseInt (hora.substr(0,2)) > 24)
          res = 1;
       else
         if (parseInt (hora.substr(3,2)) > 59)
            res = 1;
   }   
   else
       res = 1;
   if (res == 0)
       return true;
   else
       return false;
};
  
function ComparaFechas(fec0, fec1)
{  var bRes = false;
   var sDia0 = fec0.substr(0, 2);
   var sMes0 = fec0.substr(3, 2);
   var sAno0 = fec0.substr(6, 4);
   var sDia1 = fec1.substr(0, 2);
   var sMes1 = fec1.substr(3, 2);
   var sAno1 = fec1.substr(6, 4);
    if (sAno0 < sAno1) bRes = true;
   else 
   {  if (sAno0 == sAno1)
      {  if (sMes0 < sMes1) bRes = true;
         else 
         {  if (sMes0 == sMes1)
               if (sDia0 <= sDia1) bRes = true;
         }
      }
   }
   return bRes;
};

function ValidaMail(sDir)
{  var pos1, pos2, bOk = true; 
   if (sDir != "")
   {  pos1 = sDir.indexOf('@', 0); 
     pos2 = sDir.indexOf('.', 0); 
     bOk = bOk && (pos1 > 0); 
     bOk = bOk && (pos2 != -1); 
     bOk = bOk && (pos1 < pos2 - 1); 
     bOk = bOk && (pos2 < sDir.length - 1); 
     if (!bOk) 
       alert("Dirección de correo inválida"); 
   }
};

function Mayusculas(texto)
{  texto.value = texto.value.toUpperCase();
};

function esFecha(fecha)
   { borrar = fecha;     
     if ((fecha.substr(2,1) == "/") && (fecha.substr(5,1) == "/"))
     {  for (i=0; i<10; i++)
	      {	 if (((fecha.substr(i,1)<"0") || (fecha.substr(i,1)>"9")) && (i != 2) && (i != 5))
			     {  borrar = '';
              break;  
			     }  
        }        
	      if (borrar)        
	      {    d = fecha.substr(0,2);             
             m = fecha.substr(3,2);             
             y = fecha.substr(6,4);

		         if((y < 1900) || (y > 2050) || (m < 1) || (m > 12) || (d < 1) || (d > 31))
		                borrar = '';
		         else
		         {
        	      if((y%4 != 0) && (m == 2) && (d > 28))	   
		                borrar = ''; // Año no viciesto y es febrero y el dia es mayor a 28
			           else	
			           {   if ((((m == 4) || (m == 6) || (m == 9) || (m==11)) && (d>30)) || ((m==2) && (d>29)))
			                  borrar = '';	      				  	 
			           }  // else
		         } // fin else
        } // if (error)
     } // if ((caja.substr(2,1) == "/") && (caja.substr(5,1) == "/"))	
     else
         borrar = '';
     if (borrar == '')
   	   return false;  
     else
       return true;
}; 

function blancos ( texto )
{ 
  if (texto.length) 
  {
    while( '' + texto.charAt(0) == " " )
    {
      texto = texto.substring( 1, texto.length);
    }
  }
  return texto;
};

function TextoVacio(campo)
{  blancos(campo.value);
   campo.value = campo.value.toUpperCase();             
};

function comboObligatorio( texto )
{ 
  if( texto == "" ) 
  { return false;}
  else
    return true;
}

function textoObligatorio( texto )
{ 
  aux = blancos( texto );
  if( aux == "" ) 
  { return false;}
  else
    return true;
};
/////////////////////////////////////////// VALIDA GRABAR
function validaDescargo()
{  f = document.forms[1];
   var Mensaje = "";

  var now = new Date();
  var dia = now.getDate();
  if (dia < 10)
  { dia = '0'+dia }
  var mes = now.getMonth()+1;
  if (mes < 10)
  { mes = '0'+mes }
  var anio = now.getYear();
  var hoy = dia+'/'+mes+'/'+anio;
//    alert('1');
   if ( !textoObligatorio(f.dsc_fec_dsc.value) )
      Mensaje = Mensaje + "Ingrese la Fecha de Descargo  dd/mm/aaaa \n";
   else 
     if ( !esFecha (f.dsc_fec_dsc.value))
        Mensaje = Mensaje + "La Fecha de Descargo no es válida  dd/mm/aaaa \n";
     else
       if ( !ComparaFechas(f.dsc_fec_dsc.value, hoy))
          Mensaje = Mensaje + "La Fecha de Descargo es mayor a hoy.\n";

/*
//    alert('f.dsc_tpo.value:'+f.dsc_tpo.value);

    if ( f.dsc_tpo.value=="" || f.dsc_tpo.value=="D" || f.dsc_tpo.value=="M" )
    {
    if ( !comboObligatorio( f.dsc_tpo.value ) )
         Mensaje = Mensaje + "Elija el tipo de Documento descargo.\n";
//    alert('1.0');   
    if ( !textoObligatorio(f.dsc_doc_ges.value) && !textoObligatorio(f.dsc_doc_ges2.value))
        Mensaje = Mensaje + "Ingrese la gestión de Documento descargo.\n";
    else
      if (!IsNumero(f.dsc_doc_ges.value) && !IsNumero(f.dsc_doc_ges2.value))
        Mensaje = Mensaje + "La gestión de Documento descargo no es válida. \n";  
//    alert('1.1');   
    if ( !textoObligatorio(f.dsc_doc_adm.value) && !textoObligatorio(f.dsc_doc_adm2.value))
        Mensaje = Mensaje + "Ingrese la administración de Documento descargo.\n";
    else
      if (!IsNumero(f.dsc_doc_adm.value) && !IsNumero(f.dsc_doc_adm2.value))
        Mensaje = Mensaje + "La administración de Documento descargo no es válida. \n";  
//    alert('1.2');   
    if ( !textoObligatorio(f.dsc_doc_num.value) && !textoObligatorio(f.dsc_doc_num2.value))
        Mensaje = Mensaje + "Ingrese el número de Documento descargo.\n";
    else
      if (!IsNumero(f.dsc_doc_num.value) && !IsNumero(f.dsc_doc_num2.value))
        Mensaje = Mensaje + "El número de Documento descargo no es válido. \n";  
    }
*/

   if ( !esHoraSum(f.dsc_hra_dsc.value))   
      Mensaje = Mensaje + "Ingrese la Hora   hh:mm \n";

   if ( !textoObligatorio(f.dsc_des.value) )
      Mensaje = Mensaje + "Ingrese la Descripción mercadería.\n";

   if ( !textoObligatorio(f.dsc_adm.value) )
      Mensaje = Mensaje + "Ingrese la Administración.\n";

   if ( !textoObligatorio(f.dsc_lgr.value) )
      Mensaje = Mensaje + "Ingrese el Lugar de Control.\n";
//    alert('1.3');         
   if ( !textoObligatorio(f.dsc_fec_inc.value) )
      Mensaje = Mensaje + "Ingrese la Fecha de Control  dd/mm/aaaa \n";
   else 
     if ( !esFecha (f.dsc_fec_inc.value))
        Mensaje = Mensaje + "La Fecha de Control no es válida  dd/mm/aaaa \n";
     else
       if ( !ComparaFechas(f.dsc_fec_inc.value, hoy))
          Mensaje = Mensaje + "La Fecha de Control es mayor a hoy.\n";
       else
         if ( !ComparaFechas(f.dsc_fec_inc.value, f.dsc_fec_dsc.value))
            Mensaje = Mensaje + "La Fecha de Control es mayor a la fecha de Descargo.\n";
//    alert('1.4');         
    if (textoObligatorio(f.dsc_cnt.value) && !IsNumero(f.dsc_cnt.value))
       Mensaje = Mensaje + "La Cantidad mercadería no es válida. \n"; 

   if (Mensaje == ""){
    return true;
    }
   else
   {   alert (Mensaje);
       return false;
   }
};

function validaDescargoX()
{  f = document.forms[1];
   var Mensaje = "";

  var now = new Date();
  var dia = now.getDate();
  if (dia < 10)
  { dia = '0'+dia }
  var mes = now.getMonth()+1;
  if (mes < 10)
  { mes = '0'+mes }
  var anio = now.getYear();
  var hoy = dia+'/'+mes+'/'+anio;

   if ( !textoObligatorio( f.dsc_des.value ) )
        Mensaje = Mensaje + "Ingrese el texto del Descargo.\n";

   if ( !textoObligatorio(f.dsc_fec.value) )
      Mensaje = Mensaje + "Ingrese la Fecha  dd/mm/aaa \n";
   else 
     if ( !esFecha (f.dsc_fec.value))
        Mensaje = Mensaje + "La Fecha no es válida  dd/mm/aaa \n";
   else
     if ( !ComparaFechas(f.dsc_fec.value, hoy))
        Mensaje = Mensaje + "La Fecha es mayor a hoy.\n";

     if ( !esHoraSum(f.dsc_hra.value))   
      Mensaje = Mensaje + "Ingrese la Hora   hh:mm \n";
      
     if (Mensaje == "")
      return true;
     else
   {   alert (Mensaje);
       return false;
   }
};

/////////////////////////////////////////////// VALIDA BUSQUEDAS
function validaBusquedas()
{  f = document.forms[1];
   var Mensaje = "";

   if(!textoObligatorio(f.val_fec_dsc1.value) && !textoObligatorio(f.val_fec_dsc2.value)
       && !textoObligatorio(f.val_fec_inc1.value) && !textoObligatorio(f.val_fec_inc2.value)
       && !textoObligatorio(f.val_usr.value) && !textoObligatorio(f.val_adm.value))
      Mensaje = Mensaje + "Ingrese algún parámetro de búsqueda.\n";
   else
      if ( textoObligatorio(f.val_fec_dsc1.value) || textoObligatorio(f.val_fec_dsc2.value))
          if ( !esFecha (f.val_fec_dsc1.value) || !esFecha (f.val_fec_dsc2.value))
                Mensaje = Mensaje + "La Fecha no es válida o falta alguna de las Fechas.\n"
             if ( textoObligatorio(f.val_fec_inc1.value) || textoObligatorio(f.val_fec_inc2.value))
                if ( !esFecha (f.val_fec_inc1.value) || !esFecha (f.val_fec_inc2.value))
                     Mensaje = Mensaje + "La Fecha no es válida o falta alguna de las Fechas.\n";
       
     if (Mensaje == "")
      return true;
     else
   {   alert (Mensaje);
       return false;
   }
};
//////////////////////////////////////////////////// VALIDA ANULAR
function validaAnular()
{  f = document.forms[1];
   var Mensaje = "";

   if ( !textoObligatorio(f.dnc_ges.value) )
      Mensaje = Mensaje + "Elija un caso registrado.\n";
   else
      {
        if (confirmaEliminacion())
          return true;
        else
          return false;
      }
     if (Mensaje == "")
      return true;
     else
   {   alert (Mensaje);
       return false;
   }
};

function ConfirmaEliminacion()
{   return confirm("Esta seguro de anular el registro ? ");
};


function validaAnularNotificacion()
{  f = document.forms[1];
   var Mensaje = "";

   if ( !textoObligatorio(f.ntf_des.value) )
      Mensaje = Mensaje + "Elija un registro.\n";
   else
      {
        if (confirmaEliminacion())
          return true;
        else
          return false;
      }
     if (Mensaje == "")
      return true;
     else
   {   alert (Mensaje);
       return false;
   }
};

function validaAnularDescargo()
{  f = document.forms[1];
   var Mensaje = "";

   if ( !textoObligatorio(f.dsc_des.value) )
      Mensaje = Mensaje + "Elija un registro.\n";
   else
      {
        if (confirmaEliminacion())
          return true;
        else
          return false;
      }
     if (Mensaje == "")
      return true;
     else
   {   alert (Mensaje);
       return false;
   }
};
/////////////////////////////////////////////// VALIDA REGISTRO
function validaRegistro()
{  f = document.forms[1];
   var Mensaje = "";
   var now = new Date();
   var anio = now.getYear();
  
   if(!textoObligatorio(f.reg_serial.value)
       && !textoObligatorio(f.key_year.value) && !textoObligatorio(f.key_year2.value)
       && !textoObligatorio(f.key_cuo.value) && !textoObligatorio(f.key_cuo2.value)
       && !textoObligatorio(f.reg_nber.value)  && !textoObligatorio(f.reg_nber2.value))
      Mensaje = Mensaje + "Ingrese algún parámetro de búsqueda.\n";
   else
   {
    if ( f.reg_serial.value=="" || f.reg_serial.value=="D" || f.reg_serial.value=="M" )
    {
    if ( !comboObligatorio( f.reg_serial.value ) )
         Mensaje = Mensaje + "Elija el tipo de Documento descargo.\n";
    if ( !textoObligatorio(f.key_year.value) && !textoObligatorio(f.key_year2.value))
        Mensaje = Mensaje + "Ingrese la gestión de Documento descargo.\n";
       else
         if (!IsNumero(f.key_year.value) && !IsNumero(f.key_year2.value))
            Mensaje = Mensaje + "La gestión de Documento descargo no es válida. \n";  
         else
           {
            if (f.reg_serial.value=="D")
            {
            if (f.key_year.value < 2001 || f.key_year.value > anio)
               Mensaje = Mensaje + "La gestión de Documento descargo no es válida. \n";  
            } 
            if (f.reg_serial.value=="M")
            {
            if (f.key_year2.value < 2001 || f.key_year2.value > anio)
               Mensaje = Mensaje + "La gestión de Documento descargo no es válida. \n";  
            } 
            }
    if ( !textoObligatorio(f.key_cuo.value) && !textoObligatorio(f.key_cuo2.value))
        Mensaje = Mensaje + "Ingrese la administración de Documento descargo.\n";
    else
      if (!IsNumero(f.key_cuo.value) && !IsNumero(f.key_cuo2.value))
        Mensaje = Mensaje + "La administración de Documento descargo no es válida. \n";  
    if ( !textoObligatorio(f.reg_nber.value) && !textoObligatorio(f.reg_nber2.value))
        Mensaje = Mensaje + "Ingrese el número de Documento descargo.\n";
    else
      if (!IsNumero(f.reg_nber.value) && !IsNumero(f.reg_nber2.value))
        Mensaje = Mensaje + "El número de Documento descargo no es válido. \n";  
    }
   }
     if (Mensaje == "")
      return true;
     else
   {   alert (Mensaje);
       return false;
   }
};
