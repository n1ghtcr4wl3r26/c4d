package anb.action;


import anb.bean.NotificacionControlForm;

import anb.entidades.Fiscalizador;
import anb.entidades.InfoControl;
import anb.entidades.Tramite;

import anb.general.Respuesta;

import anb.negocio.GeneralNeg;
import anb.negocio.NotificacionNeg;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


public class NotificacionControlAction extends MappingDispatchAction {
    private final NotificacionNeg neg = new NotificacionNeg();
    private final GeneralNeg gen = new GeneralNeg();
    
    public ActionForward notificacionidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {

        NotificacionControlForm bean = new NotificacionControlForm();
        bean = (NotificacionControlForm)request.getAttribute("NotificacionControlForm");
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setCodger((String)request.getSession().getAttribute("user.codger"));
            bean.setUsuarioger((String)request.getSession().getAttribute("gerencia"));
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
                    //verifica si el usuario esta habilitado para el control ******
                    Respuesta<Boolean> ver = gen.verificaAccesoUsuario(bean.getCodigo(), bean.getUsuario(), "NOTIFICACION", bean.getUsuarioger());
                    if (ver.getCodigo() == 1) {
                        Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                        request.setAttribute("infoControl", inf.getResultado());
                        Respuesta<NotificacionControlForm> ben = neg.devuelveNotificacion(bean);
                        if (ben.getCodigo() == 1) {
                            bean = ben.getResultado();
                        }
                        link = "ok";
                    } else {
                        request.setAttribute("ERROR", "No esta asignado a la Orden de Fiscalizaci&oacute;n");   
                    }
                    //******
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

    public ActionForward notificacion(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                HttpServletResponse response) throws Exception {

        NotificacionControlForm bean = new NotificacionControlForm();
        bean = (NotificacionControlForm)request.getAttribute("NotificacionControlForm");
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setCodger((String)request.getSession().getAttribute("user.codger"));
            String link = "index";
            String codigo;
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("ASIGNA")) {
                Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                request.setAttribute("infoControl", inf.getResultado());
                Respuesta<Tramite[]> tram = gen.ver_TramitesControl(bean.getCodigo());
                request.setAttribute("tramites", tram.getResultado());
                Respuesta<List<Fiscalizador>> fis = gen.obtenerFuncionarios(bean.getCodger());
                request.setAttribute("fiscalizadores", fis.getResultado());
                Respuesta<Fiscalizador[]> asig = gen.devuelveFisAsignados(bean.getCodigo());
                request.setAttribute("asignados", asig.getResultado());
                Respuesta<Boolean> res = neg.graba_notificacion(bean);
                if (res.getCodigo() == 1) {
                    request.setAttribute("OK", res.getMensaje());
                    link = "ok";
                } else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                        link = "index";
                    }
                }

            }
            return mapping.findForward("ok");
        }
    }
    
}