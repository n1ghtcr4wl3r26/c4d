package anb.bean;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class LoginForm extends ActionForm {
    private String txt_usu;
    private String txt_pas;
    private ArrayList opciones;
    private String usuario;
    private String perfil;
    private String fec_proc;

    /**
     * Reset all properties to their default values.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
    }

    /**
     * Validate all properties to their default values.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return ActionErrors A list of all errors found.
     */
    public ActionErrors validate(ActionMapping mapping, 
                                 HttpServletRequest request) {
        return super.validate(mapping, request);
    }

    public String getTxt_usu() {
        return txt_usu;
    }

    public void setTxt_usu(String newTxt_usu) {
        txt_usu = newTxt_usu;
    }

    public String getTxt_pas() {
        return txt_pas;
    }

    public void setTxt_pas(String newTxt_pas) {
        txt_pas = newTxt_pas;
    }

    public ArrayList getOpciones() {
        return opciones;
    }

    public void setOpciones(ArrayList newOpciones) {
        opciones = newOpciones;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String newUsuario) {
        usuario = newUsuario;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String newPerfil) {
        perfil = newPerfil;
    }

    public String getFec_proc() {
        return fec_proc;
    }

    public void setFec_proc(String newFec_proc) {
        fec_proc = newFec_proc;
    }
}