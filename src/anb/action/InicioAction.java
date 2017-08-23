package anb.action;


import anb.bean.InicioForm;

import java.io.IOException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;


// Referenced classes of package cad:
//            InicioForm, DescargoForm, BDConection

public class InicioAction extends Action {

    public InicioAction() {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws ServletException, IOException {
        InicioForm iform = (InicioForm)request.getSession().getAttribute("InicioForm");

        ActionMessages error = new ActionMessages();
        Connection con = null;
        CallableStatement call = null;
        ArrayList getDescargos = new ArrayList();
        try {
            if (iform.getBoton().equals("Buscar"))
                iform.setVal(1);
            else
                iform.setSelected(iform.getBoton());
        } catch (Exception e) {
            error.add("error", new ActionMessage("error", e.toString()));
            saveErrors(request, error);
            ActionForward actionforward = mapping.findForward("volver");
            return actionforward;
        } finally {
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
