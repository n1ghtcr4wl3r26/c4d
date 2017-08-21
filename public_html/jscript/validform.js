bCancel = false;
_mandatory = 1;
_fmtnumber = 2;
_fmtdate   = 4;
_fmtemail  = 8;
_fmtmask   = 16;
_fmteval   = 32;
_msgmandatory=" es obligatorio.";
_msgnumber=" debe ser un valor n\372merico."
_msgdate=" formato incorrecto. Ingrese dd/mm/aaaa.";
_msgemail=" formato incorrecto.";
_msgmask=" formato incorrecto.";
function isEmpty(o){
  var re = /\b.+/;
  return !re.test(o.value);
}
function isNumber(o){
  var re = /^[-]?\d*\.?\d*$/;
  return re.test(o.value);
}
function isDate(o){
  var mo, day, yr;
  var status = 0;
  var entry = o.value;
  var reLong = /\b\d{1,2}[\/-]\d{1,2}[\/-]\d{4}\b/;
  var reShort = /\b\d{1,2}[\/-]\d{1,2}[\/-]\d{2}\b/;
  var valid=(reLong.test(entry)) || (reShort.test(entry));
  if(valid){
    var delimChar = (entry.indexOf("/") != -1) ? "/" : "-";
    var delim1 = entry.indexOf(delimChar);
    var delim2 = entry.lastIndexOf(delimChar);
    day = parseInt(entry.substring(0, delim1), 10);
    mo = parseInt(entry.substring(delim1 + 1, delim2), 10);
    yr = parseInt(entry.substring(delim2 + 1), 10);
    if(yr < 100){
      var today = new Date( );
      var currCent = parseInt(today.getFullYear( ) / 100) * 100;
      var threshold = (today.getFullYear( ) + 15) - currCent;
      if (yr > threshold) {
        yr += currCent-100;
        } else {
        yr += currCent;
      }
    }
    var testDate = new Date(yr,mo-1,day);
    if ((testDate.getDate() == day)
    && (testDate.getMonth()+1 == mo)
    && (testDate.getFullYear() == yr)){
      if (mo < 10)
        mo="0"+mo;
      if (day<10)
        day = "0" + day;
      o.value = day + "/" + mo + "/" + yr;
      status = 1;
    }
  }
  return status;
}
function isEMailAddress(o) {
  var re = /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/;
  return re.test(o.value);
}
function checkMask(o, fm) {
  var re = new RegExp(fm);
  return re.test(o.value);
}
function checkEval(o, _eval) {
  var searchStr = "\\?";
  var replaceStr = "o\.value";
  var re = new RegExp(searchStr , "g");
  var ex = "var result = " + _eval.replace(re, replaceStr);
  eval(ex);
  return result;
}
function validField(fld,lbl,flg,msk,msg){
  this.fld = fld;
  this.lbl = lbl;
  this.flg = flg;
  this.msk = msk;
  this.msg = msg;
}
function validForm(f,l){  
  if(bCancel) return false;
  alert(f.elements[1];);
  var msg=new ("Errores de validaci�n:");  
  var of=null;
  for(var i=0;i<l.length;i++){
    var c=l[i];
    var o=f.elements[c.fld];
    vc=isEmpty(o);
    if((c.flg & _mandatory)==_mandatory){
      if(vc){
        msg.addMessage(c.lbl+_msgmandatory);
      }
    }
    if(!vc){
      if((c.flg & _fmtnumber)==_fmtnumber){
        if(!isNumber(o)){
          msg.addMessage(c.lbl+_msgnumber);
        }
      }
      if((c.flg & _fmtdate)==_fmtdate){
        if(!isDate(o)) {
          msg.addMessage(c.lbl+_msgdate);
        }
      }
      if((c.flg & _fmtemail)==_fmtemail){
        if(!isEMailAddress(o)){
          msg.addMessage(c.lbl+_msgemail);
        }
      }
      if((c.flg & _fmtmask)==_fmtmask){
        if(!checkMask(o,c.msk)){
          msg.addMessage(c.msg);
        }
      }
      if((c.flg & _fmteval)==_fmteval){
        if(!checkEval(o,c.msk)){
          msg.addMessage(c.msg);
        }
      }
    }
    if(!of && !msg.isEmpty){
      of = o;
		}
  }
  if(of){
    of.focus();
    of.select();
    msg.display();
  }
  return msg.isEmpty;
}