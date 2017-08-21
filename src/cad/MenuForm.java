// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 16/05/2012 12:08:29
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   MenuForm.java

package cad;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class MenuForm extends ActionForm 
{
  private String opcion="0";
  
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
  }

  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    return super.validate(mapping, request);
  }

  public String getOpcion ()
  {
    return opcion;
  }

  public void setOpcion (String newOpcion)
  {
    opcion = newOpcion;
  }
  
}