

var _ie = document.all?1:0;

// STATUSBAR: Mensajes
function statusbar(msg)
{
  window.status = msg;
  setTimeout("erase()",2000);
}

function erase()
{
  window.status="";
}

//MENU
color_origen='BDBFD2';
color_destino='DBE0E8';

function entrar(src)
{
  color_origen=src.bgColor;
  src.bgColor=color_destino;
}

function salir(src)
{
  src.bgColor=color_origen;
}

//VARIOS
function Runden(x,s)
{
  if(x.toFixed)
  {
    return x.toFixed(s);
  }
  else
  {
    return parseInt(x*Math.pow(10,s)+0.5)/Math.pow(10,s);
  }
}

