package anb.bean;


public class verificaForm extends ActionForm
{

    public verificaForm()
    {
    }

    public String getBoton()
    {
        return boton;
    }

    public void setBoton(String newBoton)
    {
        boton = newBoton;
    }

    public String getNumero()
    {
        return numero;
    }

    public void setNumero(String newNumero)
    {
        numero = newNumero;
    }

    public String getMensaje()
    {
        return mensaje;
    }

    public void setMensaje(String newMensaje)
    {
        mensaje = newMensaje;
    }

    private String boton;
    private String numero;
    private String mensaje;
}