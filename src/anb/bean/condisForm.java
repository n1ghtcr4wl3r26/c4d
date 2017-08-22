package anb.bean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class condisForm extends ActionForm 
{
  private String boton;
  private String mensaje;
  private String numero;
  private String observacion;
  private String aduana;
  private String dfecini;
  private String dfecfin;

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

  public String getAduana()
  {
    return aduana;
  }

  public void setAduana(String newAduana)
  {
    aduana = newAduana;
  }

  public String getDfecini()
  {
    return dfecini;
  }

  public void setDfecini(String newDfecini)
  {
    dfecini = newDfecini;
  }

  public String getDfecfin()
  {
    return dfecfin;
  }

  public void setDfecfin(String newDfecfin)
  {
    dfecfin = newDfecfin;
  }
}