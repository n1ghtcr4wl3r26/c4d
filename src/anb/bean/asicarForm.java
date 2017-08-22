package anb.bean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class asicarForm extends ActionForm 
{
  private String boton;
  private String mensaje;
  private String numero;
  private String observacion;
  private String desde;
  private String hasta;
  private String aduana;
  private String nit;
  private String recibo;
  private String mensaje2;

  /**
   * Reset all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   */
  public void reset(ActionMapping mapping, HttpServletRequest request)
  {
    super.reset(mapping, request);
  }

  /**
   * Validate all properties to their default values.
   * @param mapping The ActionMapping used to select this instance.
   * @param request The HTTP Request we are processing.
   * @return ActionErrors A list of all errors found.
   */
  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
  {
    return super.validate(mapping, request);
  }

  public String getBoton()
  {
    return boton;
  }

  public void setBoton(String newBoton)
  {
    boton = newBoton;
  }

  public String getMensaje()
  {
    return mensaje;
  }

  public void setMensaje(String newMensaje)
  {
    mensaje = newMensaje;
  }

  public String getNumero()
  {
    return numero;
  }

  public void setNumero(String newNumero)
  {
    numero = newNumero;
  }

  public String getObservacion()
  {
    return observacion;
  }

  public void setObservacion(String newObservacion)
  {
    observacion = newObservacion;
  }

  public String getDesde()
  {
    return desde;
  }

  public void setDesde(String newDesde)
  {
    desde = newDesde;
  }

  public String getHasta()
  {
    return hasta;
  }

  public void setHasta(String newHasta)
  {
    hasta = newHasta;
  }

  public String getAduana()
  {
    return aduana;
  }

  public void setAduana(String newAduana)
  {
    aduana = newAduana;
  }

  public String getNit()
  {
    return nit;
  }

  public void setNit(String newNit)
  {
    nit = newNit;
  }

  public String getRecibo()
  {
    return recibo;
  }

  public void setRecibo(String newRecibo)
  {
    recibo = newRecibo;
  }

  public String getMensaje2()
  {
    return mensaje2;
  }

  public void setMensaje2(String newMensaje2)
  {
    mensaje2 = newMensaje2;
  }
}