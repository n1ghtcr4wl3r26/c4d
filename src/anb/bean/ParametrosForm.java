package anb.bean;


public class ParametrosForm extends ActionForm {

    private String maximo;
    private String boton;
    private String mensaje;

    public void setMaximo(String maximo) {
        this.maximo = maximo;
    }

    public String getMaximo() {
        return maximo;
    }

    public void setBoton(String boton) {
        this.boton = boton;
    }

    public String getBoton() {
        return boton;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
