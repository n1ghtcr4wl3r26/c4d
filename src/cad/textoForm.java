// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 16/05/2012 12:10:54
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   textoForm.java

package cad;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class textoForm extends ActionForm
{

    public textoForm()
    {
    }

    public void reset(ActionMapping mapping, HttpServletRequest request)
    {
        super.reset(mapping, request);
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
    {
        return super.validate(mapping, request);
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