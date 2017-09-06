package anb.action;


import anb.bean.CuadroLiquidacionForm;

import anb.entidades.CuadroLiquidacion;
import anb.entidades.InfoControl;

import anb.general.Respuesta;

import anb.negocio.CuadroLiquidacionNeg;
import anb.negocio.GeneralNeg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


public class CuadroLiquidacionAction extends MappingDispatchAction {
    private final CuadroLiquidacionNeg neg = new CuadroLiquidacionNeg();
    private final GeneralNeg gen = new GeneralNeg();
    
    public ActionForward liquidacionidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        
        CuadroLiquidacionForm bean = new CuadroLiquidacionForm();
        bean = (CuadroLiquidacionForm)request.getAttribute("CuadroLiquidacionForm");
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setCodger((String)request.getSession().getAttribute("user.codger"));
            String link = "index";
            String codigo;
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("CONSULTAR")) {
                request.getSession().setAttribute("sgestion", bean.getFgestion());
                request.getSession().setAttribute("sgerencia", bean.getFgerencia());
                request.getSession().setAttribute("scontrol", bean.getFcontrol());
                request.getSession().setAttribute("snumero", bean.getFnumero());
                Respuesta<Boolean> res =
                    gen.devuelveCodigo(bean.getFgestion(), bean.getFcontrol(), bean.getFgerencia(), bean.getFnumero());
                request.setAttribute("codigo", res.getResultado());
                if (res.getCodigo() == 1) {
                    bean.setCodigo(res.getMensaje().toString());
                    Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                    request.setAttribute("infoControl", inf.getResultado());
                    Respuesta<CuadroLiquidacion[]> ben = neg.devuelveCuadroLiq(bean);
                    if (ben.getCodigo() == 1) {
                        bean.setCantidad("1");
                        request.setAttribute("cuadroLiquidacion", ben.getResultado());
                    }
                    link = "ok";
                } 
                else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                    }
                }
            }else {
                bean.setFgestion((String)request.getSession().getAttribute("sgestion"));
                bean.setFgerencia((String)request.getSession().getAttribute("sgerencia"));
                bean.setFcontrol((String)request.getSession().getAttribute("scontrol"));
                bean.setFnumero((String)request.getSession().getAttribute("snumero"));                
            }
            return mapping.findForward(link);
        }
    }
    
    public ActionForward liquidacion(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {

        CuadroLiquidacionForm bean = new CuadroLiquidacionForm();
        bean = (CuadroLiquidacionForm)request.getAttribute("CuadroLiquidacionForm");
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setCodger((String)request.getSession().getAttribute("user.codger"));
            String link = "index";
            String codigo;
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("CONSULTAR")) {
                Respuesta<Boolean> res =
                    gen.devuelveCodigo(bean.getFgestion(), bean.getFcontrol(), bean.getFgerencia(), bean.getFnumero());
                request.setAttribute("codigo", res.getResultado());
                if (res.getCodigo() == 1) {
                    bean.setCodigo(res.getMensaje().toString());
                    Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                    request.setAttribute("infoControl", inf.getResultado());
                    Respuesta<CuadroLiquidacion[]> ben = neg.devuelveCuadroLiq(bean);
                    if (ben.getCodigo() == 1) {
                        request.setAttribute("cuadroLiquidacion", ben.getResultado());
                    }
                    link = "ok";
                } 
                else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                    }
                }
            }
            return mapping.findForward(link);
        }
    }
}
