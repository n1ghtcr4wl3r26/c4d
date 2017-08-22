package anb.bean;


public class textoForm extends ActionForm
{

    public textoForm()
    {
    }

    public String getMensaje()
    {
        return mensaje;
    }

    public void setMensaje(String newMensaje)
    {
        mensaje = newMensaje;
    }

    public String getBoton()
    {
        return boton;
    }

    public void setBoton(String newBoton)
    {
        boton = newBoton;
    }

    public int getOpcion()
    {
        return opcion;
    }

    public void setOpcion(int newOpcion)
    {
        opcion = newOpcion;
    }

    private String mensaje;
    private String boton;
    private int opcion;
}