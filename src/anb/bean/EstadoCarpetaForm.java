package anb.bean;

import org.apache.struts.action.ActionForm;

public class EstadoCarpetaForm extends ActionForm{
    private String boton;

    public void setBoton(String boton) {
        this.boton = boton;
    }

    public String getBoton() {
        return boton;
    }
}
