package anb.bean;

import org.apache.struts.action.ActionForm;

public class ConsultaDistribucionForm extends ActionForm {
    private String boton;
    private String opcion;
    private String codigo;
    private String codger;
    private String usuario;
    private String numero;
    private String gerencia;
    private String fecini;
    private String fecfin;

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

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getGerencia() {
        return gerencia;
    }

    public void setFecini(String fecini) {
        this.fecini = fecini;
    }

    public String getFecini() {
        return fecini;
    }

    public void setFecfin(String fecfin) {
        this.fecfin = fecfin;
    }

    public String getFecfin() {
        return fecfin;
    }
}
