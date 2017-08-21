// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 16/05/2012 12:10:18
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   reporteAction.java

package cad;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;

public class reporteAction extends Action
{

    public reporteAction()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        return mapping.findForward("success");
    }
}