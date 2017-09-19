package anb.bean;

import org.apache.struts.action.ActionForm;

public class DistribucionCarpetasForm extends ActionForm {
    private String boton;
    private String opcion;
    private String codigo;
    private String codger;
    private String usuario;
    private String numero;
    private String numerodesde;
    private String numerohasta;
    private String gerencia;
    private String resultado;
    private String numdesde;
    private String numhasta;

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

    public void setNumerodesde(String numerodesde) {
        this.numerodesde = numerodesde;
    }

    public String getNumerodesde() {
        return numerodesde;
    }

    public void setNumerohasta(String numerohasta) {
        this.numerohasta = numerohasta;
    }

    public String getNumerohasta() {
        return numerohasta;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getGerencia() {
        return gerencia;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setNumdesde(String numdesde) {
        this.numdesde = numdesde;
    }

    public String getNumdesde() {
        return numdesde;
    }

    public void setNumhasta(String numhasta) {
        this.numhasta = numhasta;
    }

    public String getNumhasta() {
        return numhasta;
    }
}
