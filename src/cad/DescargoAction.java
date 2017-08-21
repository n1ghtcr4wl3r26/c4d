// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 15/05/2012 15:54:36
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   DescargoAction.java

package cad;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.struts.action.*;

// Referenced classes of package cad:
//            RegistroForm, DescargoForm, LoginForm, BDConection

public class DescargoAction extends Action
{

    public DescargoAction()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        RegistroForm rform = (RegistroForm)request.getSession().getAttribute("RegistroForm");
        DescargoForm dform = (DescargoForm)form;
        request.setAttribute("DescargoForm", dform);
         ActionMessages error = new ActionMessages();
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        
        try
        {
            con = dc.abrirConexion();
            con.setAutoCommit(false);
            
            if(dform.getBoton() != null)
            {
                int res;
                String msg;
                if(dform.getBoton().equals("Grabar"))
                {
                    call = con.prepareCall("{call PKG_SCDD.graba_descargo (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
                    call.setString(1, dform.getDsc_num());
                    call.setString(2, rform.getKey_year());
                    call.setString(3, rform.getKey_cuo());
                    call.setString(4, rform.getReg_nber());
                    call.setString(5, rform.getKey_year2());
                    call.setString(6, rform.getKey_cuo2());
                    call.setString(7, rform.getReg_nber2());
                    call.setString(8, rform.getReg_serial());
                    call.setString(9, dform.getDsc_fec_dsc());
                    call.setString(10, dform.getDsc_hra_dsc());
                    call.setString(11, dform.getDsc_des());
                    call.setString(12, dform.getDsc_cnt());
                    call.setString(13, dform.getDsc_adm());
                    call.setString(14, dform.getDsc_adi());
                    call.setString(15, dform.getDsc_lgr());
                    call.setString(16, dform.getDsc_fec_inc());
                    call.setString(17, (String)request.getSession().getAttribute("user"));
                    call.registerOutParameter(18, 4);
                    call.registerOutParameter(19, 12);
                    call.execute();
                    res = call.getInt(18);
                    msg = call.getString(19);
                } else
                {
                    call = con.prepareCall("{call PKG_SCDD.elimina_descargo (?,?,?,?,?,?,?,?) }");
                    call.setString(1, dform.getBoton());
                    call.setString(2, rform.getReg_serial());
                    call.setString(3, rform.getKey_year());
                    call.setString(4, rform.getKey_cuo());
                    call.setString(5, rform.getReg_nber());
                    call.setString(9, (String)request.getSession().getAttribute("user"));
                    call.registerOutParameter(10, 4);
                    call.registerOutParameter(11, 12);
                    call.execute();
                    res = call.getInt(10);
                    msg = call.getString(11);
                }
                if(res == 0)
                {
                    error.add("error", new ActionMessage("mensaje", msg));
                    saveErrors(request, error);
                    dform.setBoton(null);
                    ActionForward actionforward = mapping.findForward("volver");
                    return actionforward;
                }
                error.add("error", new ActionMessage("error", msg));
                saveErrors(request, error);
                dform.setBoton(null);
                ActionForward actionforward1 = mapping.findForward("volver");
                return actionforward1;
            }
        }
        catch(Exception e)
        {
            error.add("error", new ActionMessage("error", e.toString()));
            saveErrors(request, error);
            ActionForward actionforward2 = mapping.findForward("volver");
            return actionforward2;
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