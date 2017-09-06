package anb.bean;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class SubirHojaForm extends ActionForm {
    private String cargo;
    private String funcionario;
    
    private String tipoAlcance;
    
    private String fmemorizado;
    private String fgestion;
    private String fcontrol;
    private String fgerencia;
    private String fnumero;
    
    private String boton;
    private String opcion;
    private String codigo;
    private String codger;
    private String usuario;
    
    private String excel;
    private FormFile file;
    
    private String usuarioger; 

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFmemorizado(String fmemorizado) {
        this.fmemorizado = fmemorizado;
    }

    public String getFmemorizado() {
        return fmemorizado;
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

    public void setTipoAlcance(String tipoAlcance) {
        this.tipoAlcance = tipoAlcance;
    }

    public String getTipoAlcance() {
        return tipoAlcance;
    }


    public void setExcel(String excel) {
        this.excel = excel;
    }

    public String getExcel() {
        return excel;
    }

    public void setFile(FormFile file) {
        this.file = file;
    }

    public FormFile getFile() {
        return file;
    }


    public void setUsuarioger(String usuarioger) {
        this.usuarioger = usuarioger;
    }

    public String getUsuarioger() {
        return usuarioger;
    }
}
