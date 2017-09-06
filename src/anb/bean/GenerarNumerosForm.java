package anb.bean;

import org.apache.struts.action.ActionForm;

public class GenerarNumerosForm extends ActionForm {
    private String numero;
    private String boton;
    private String opcion;

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setBoton(String boton) {
        this.boton = boton;
    }

    public String getBoton() {
        return boton;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getOpcion() {
        return opcion;
    }
}
