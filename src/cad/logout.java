// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 15/05/2012 16:02:03
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   logout.java

package cad;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.struts.action.*;

// Referenced classes of package cad:
//            LoginForm

public class logout extends Action
{

    public logout()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {        
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("DescargoForm");
        request.getSession().removeAttribute("LoginForm");
        request.getSession().invalidate();
        return mapping.findForward("volver");
    }
}