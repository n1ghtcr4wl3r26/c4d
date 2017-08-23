package anb.bean;


public class ParametrosForm extends ActionForm
{

    public ParametrosForm()
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

    public String getMaximo()
    {
        return maximo;
    }

    public void setMaximo(String newMaximo)
    {
        maximo = newMaximo;
    }

    public String getMensaje()
    {
        return mensaje;
    }

    public void setMensaje(String newMensaje)
    {
        mensaje = newMensaje;
    }

    private String maximo;
    private String boton;
    private String mensaje;
}