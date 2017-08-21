// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 15/05/2012 16:00:48
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   generarForm.java

package cad;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class generarForm extends ActionForm
{

    public generarForm()
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

    private String mensaje;
    private String boton;
}