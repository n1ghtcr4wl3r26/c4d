// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 16/05/2012 12:11:23
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   verificaForm.java

package cad;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class verificaForm extends ActionForm
{

    public verificaForm()
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