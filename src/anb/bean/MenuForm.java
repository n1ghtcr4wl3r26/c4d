package anb.bean;

import org.apache.struts.action.ActionForm;


public class MenuForm extends ActionForm 
{
  private String opcion="0";
    
  public String getOpcion ()
  {
    return opcion;
  }

  public void setOpcion (String newOpcion)
  {
    opcion = newOpcion;
  }
  
}