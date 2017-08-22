package anb.action;

import anb.bean.DescargoForm;
import anb.bean.InicioForm;

import java.io.IOException;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.SQLException;

import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.struts.action.*;

// Referenced classes of package cad:
//            InicioForm, DescargoForm, BDConection

public class InicioAction extends Action
{

    public InicioAction()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        InicioForm iform = (InicioForm)request.getSession().getAttribute("InicioForm");
        DescargoForm dform = (DescargoForm)request.getSession().getAttribute("DescargoForm");
        if(dform == null)
        {
            dform = new DescargoForm();
            request.getSession().setAttribute("DescargoForm", dform);
        }
        ActionMessages error = new ActionMessages();
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        ArrayList getDescargos = new ArrayList();
        try
        {
            con = dc.abrirConexion();
            if(iform.getBoton().equals("Buscar"))
                iform.setVal(1);
            else
                iform.setSelected(iform.getBoton());
        }
        catch(Exception e)
        {
            error.add("error", new ActionMessage("error", e.toString()));
            saveErrors(request, error);
            ActionForward actionforward = mapping.findForward("volver");
            return actionforward;
        }
        finally
        {
            try {
                if (con != null)
                    con.close();

            } catch (SQLException er) {
                ;
            }
        }
        return mapping.findForward("volver");
    }
}