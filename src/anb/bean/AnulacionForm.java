package anb.bean;

import org.apache.struts.action.ActionForm;

public class AnulacionForm extends ActionForm {
    private String codigo;
    private String gestion;
    private String tipo;
    private String gerencia;
    private String numero;

    private String usuarioger; 
    
    private String fcodigo;
    private String fgestion;
    private String fcontrol;
    private String fgerencia;
    private String fnumero;
    
    private String usuario;
    private String opcion;
    private String boton;
    private String justificacion;

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setGestion(String gestion) {
        this.gestion = gestion;
    }

    public String getGestion() {
        return gestion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getGerencia() {
        return gerencia;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setBoton(String boton) {
        this.boton = boton;
    }

    public String getBoton() {
        return boton;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setFcodigo(String fcodigo) {
        this.fcodigo = fcodigo;
    }

    public String getFcodigo() {
        return fcodigo;
    }

    public void setFgestion(String fgestion) {
        this.fgestion = fgestion;
    }

    public String getFgestion() {
        return fgestion;
    }

    public void setFcontrol(String fcontrol) {
        this.fcontrol = fcontrol;
    }

    public String getFcontrol() {
        return fcontrol;
    }

    public void setFgerencia(String fgerencia) {
        this.fgerencia = fgerencia;
    }

    public String getFgerencia() {
        return fgerencia;
    }

    public void setFnumero(String fnumero) {
        this.fnumero = fnumero;
    }

    public String getFnumero() {
        return fnumero;
    }

    public void setUsuarioger(String usuarioger) {
        this.usuarioger = usuarioger;
    }

    public String getUsuarioger() {
        return usuarioger;
    }
}
