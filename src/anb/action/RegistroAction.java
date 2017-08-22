package anb.action;

import anb.bean.DescargoForm;
import anb.bean.InicioForm;
import anb.bean.RegistroForm;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.struts.action.*;

// Referenced classes of package cad:
//            RegistroForm, DescargoForm, InicioForm, BDConection

public class RegistroAction extends Action
{

    public RegistroAction()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        RegistroForm rform = (RegistroForm)form;
        DescargoForm dform = (DescargoForm)request.getSession().getAttribute("DescargoForm");
        InicioForm iform = (InicioForm)request.getSession().getAttribute("InicioForm");
        if(dform == null)
        {
            dform = new DescargoForm();
            request.getSession().setAttribute("DescargoForm", dform);
        }
        ActionMessages error = new ActionMessages();
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        ResultSet l_rset = null;
        ArrayList getDescargos = new ArrayList();
        ArrayList getDatos = new ArrayList();
        try
        {
            con = dc.abrirConexion();
            if(rform.getBoton().equals("Buscar"))
            {
                call = con.prepareCall("{call PKG_SCDD.verifica (?,?,?,?,?,?) }");
                call.setString(1, rform.getReg_serial());
                call.setString(2, rform.getKey_year());
                call.setString(3, rform.getKey_cuo());
                call.setString(4, rform.getReg_nber());
                call.registerOutParameter(5, 4);
                call.registerOutParameter(6, 12);
                call.execute();
                int res = call.getInt(5);
                String msg = call.getString(6);
                if(res == 0)
                {
                    msg = "";
                    error.add("error", new ActionMessage("mensaje", msg));
                    saveErrors(request, error);
                    dform.setBoton(null);
                    call = con.prepareCall("{ ? = call PKG_SCDD.busca_datos (?,?,?,?) }");
                    call.registerOutParameter(1, -10);
                    call.setString(2, rform.getReg_serial());
                    call.setString(3, rform.getKey_year());
                    call.setString(4, rform.getKey_cuo());
                    call.setString(5, rform.getReg_nber());
                    call.execute();
                    l_rset = (ResultSet)call.getObject(1);
                    if(l_rset != null && l_rset.next())
                        do
                        {
                            DescargoForm dform2 = new DescargoForm();
                            dform2.setDesc1(l_rset.getString(1));
                            dform2.setDesc3(l_rset.getString(2));
                            dform2.setBultos(l_rset.getString(3));
                            getDatos.add(dform2);
                        } while(l_rset.next());
                    call = con.prepareCall("{ ? = call PKG_SCDD.busca_descargo (?,?,?,?) }");
                    call.registerOutParameter(1, -10);
                    call.setString(2, rform.getReg_serial());
                    call.setString(3, rform.getKey_year());
                    call.setString(4, rform.getKey_cuo());
                    call.setString(5, rform.getReg_nber());
                    call.execute();
                    l_rset = (ResultSet)call.getObject(1);
                    if(l_rset != null && l_rset.next())
                        do
                        {
                            DescargoForm dform1 = new DescargoForm();
                            dform1.setDsc_num(l_rset.getString(1));
                            dform1.setKey_year(l_rset.getString(2));
                            dform1.setKey_cuo(l_rset.getString(3));
                            dform1.setReg_nber(l_rset.getString(4));
                            dform1.setReg_serial(l_rset.getString(5));
                            dform1.setDsc_fec_dsc(l_rset.getString(6));
                            dform1.setDsc_hra_dsc(l_rset.getString(7));
                            dform1.setDsc_des(l_rset.getString(8));
                            dform1.setDsc_cnt(l_rset.getString(9));
                            dform1.setDsc_adm(l_rset.getString(10));
                            dform1.setDsc_adi(l_rset.getString(11));
                            dform1.setDsc_lgr(l_rset.getString(12));
                            dform1.setDsc_fec_inc(l_rset.getString(13));
                            dform1.setDsc_usr(l_rset.getString(14));
                            getDescargos.add(dform1);
                        } while(l_rset.next());
                } else
                {
                    error.add("error", new ActionMessage("error", msg));
                    saveErrors(request, error);
                    dform.setBoton(null);
                    dform.setLlave(1);
                    ActionForward actionforward = mapping.findForward("error");
                    return actionforward;
                }
            }
        }
        catch(Exception e)
        {
            error.add("error", new ActionMessage("error", e.toString()));
            saveErrors(request, error);
            ActionForward actionforward1 = mapping.findForward("volver");
            return actionforward1;
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
        request.getSession().setAttribute("datos_descargo", getDescargos);
        request.getSession().setAttribute("datos2_descargo", getDatos);
        return mapping.findForward("descargo");
    }
}