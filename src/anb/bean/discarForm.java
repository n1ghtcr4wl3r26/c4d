package anb.bean;

import org.apache.struts.action.ActionForm;

public class discarForm extends ActionForm 
{
  private String boton;
  private String mensaje;
  private String numero;
  private String observacion;
  private String desde;
  private String hasta;
  private String aduana;
  private String mensaje2;


    public void setBoton(String boton) {
        this.boton = boton;
    }

    public String getBoton() {
        return boton;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getDesde() {
        return desde;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public String getHasta() {
        return hasta;
    }

    public void setAduana(String aduana) {
        this.aduana = aduana;
    }

    public String getAduana() {
        return aduana;
    }

    public void setMensaje2(String mensaje2) {
        this.mensaje2 = mensaje2;
    }

    public String getMensaje2() {
        return mensaje2;
    }
}
