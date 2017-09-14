package anb.bean;

import org.apache.struts.action.ActionForm;

public class AsignaCarpetaForm extends ActionForm {
    private String boton;
    private String opcion;
    private String codigo;
    private String codger;
    private String usuario;
    private String numero;
    private String nit;

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

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodger(String codger) {
        this.codger = codger;
    }

    public String getCodger() {
        return codger;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }
}
