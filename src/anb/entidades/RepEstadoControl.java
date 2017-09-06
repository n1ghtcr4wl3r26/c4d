package anb.entidades;

public class RepEstadoControl {
    
    private String funcionario;
    private String tipoControl;
    private String numeroControl;
    private String fechaAsignacion;
    private String cantTramites;
    private String fechaNotificacion;
    private String estado;
    private String operador;


    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setTipoControl(String tipoControl) {
        this.tipoControl = tipoControl;
    }

    public String getTipoControl() {
        return tipoControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setFechaAsignacion(String fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public String getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setCantTramites(String cantTramites) {
        this.cantTramites = cantTramites;
    }

    public String getCantTramites() {
        return cantTramites;
    }

    public void setFechaNotificacion(String fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public String getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getOperador() {
        return operador;
    }
}
