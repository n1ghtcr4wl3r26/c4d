// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 16/05/2012 12:09:31
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   PasswordForm.java

package cad;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class PasswordForm extends ActionForm
{

    public PasswordForm()
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

    public String getTxt_pas()
    {
        return txt_pas;
    }

    public void setTxt_pas(String newTxt_pas)
    {
        txt_pas = newTxt_pas;
    }

    public String getTxt_confPas()
    {
        return txt_confPas;
    }

    public void setTxt_confPas(String newTxt_confPas)
    {
        txt_confPas = newTxt_confPas;
    }

    public int getValP()
    {
        return valP;
    }

    public void setValP(int newValP)
    {
        valP = newValP;
    }

    public String getBoton()
    {
        return boton;
    }

    public void setBoton(String newBoton)
    {
        boton = newBoton;
    }

    public String getTxt_pasant()
    {
        return txt_pasant;
    }

    public void setTxt_pasant(String newTxt_pasant)
    {
        txt_pasant = newTxt_pasant;
    }

    private String txt_pas;
    private String txt_confPas;
    private int valP;
    private String boton;
    private String txt_pasant;
}