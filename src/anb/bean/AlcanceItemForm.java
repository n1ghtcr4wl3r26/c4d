package anb.bean;

import org.apache.struts.action.ActionForm;

public class AlcanceItemForm extends ActionForm{
    
    /* VARIABLES PARA EDICION DE ALCANCE */
    private String idalcanceitem;
    private String etipo;
    private String edocumento;
    private String eitem;
    private String echvalor;
    private String echpartida;
    private String echorigen;
    private String echotro;
    
    public AlcanceItemForm() {
        super();
    }

    public void setIdalcanceitem(String idalcanceitem) {
        this.idalcanceitem = idalcanceitem;
    }

    public String getIdalcanceitem() {
        return idalcanceitem;
    }

    public void setEtipo(String etipo) {
        this.etipo = etipo;
    }

    public String getEtipo() {
        return etipo;
    }

    public void setEdocumento(String edocumento) {
        this.edocumento = edocumento;
    }

    public String getEdocumento() {
        return edocumento;
    }

    public void setEitem(String eitem) {
        this.eitem = eitem;
    }

    public String getEitem() {
        return eitem;
    }

    public void setEchvalor(String echvalor) {
        this.echvalor = echvalor;
    }

    public String getEchvalor() {
        return echvalor;
    }

    public void setEchpartida(String echpartida) {
        this.echpartida = echpartida;
    }

    public String getEchpartida() {
        return echpartida;
    }

    public void setEchorigen(String echorigen) {
        this.echorigen = echorigen;
    }

    public String getEchorigen() {
        return echorigen;
    }

    public void setEchotro(String echotro) {
        this.echotro = echotro;
    }

    public String getEchotro() {
        return echotro;
    }
}
