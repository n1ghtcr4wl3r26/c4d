package anb.action;


import anb.bean.RegistroControlForm;

import anb.entidades.InfoControl;
import anb.entidades.Tramite;

import anb.general.Respuesta;

import anb.negocio.GeneralNeg;
import anb.negocio.RegistroControlNeg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


public class RegistroControlAction extends MappingDispatchAction {

    private final RegistroControlNeg neg = new RegistroControlNeg();
    private final GeneralNeg gen = new GeneralNeg();

    public ActionForward registroidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {

        RegistroControlForm bean = new RegistroControlForm();
        String link = "index";
        bean = (RegistroControlForm)request.getAttribute("RegistroControlForm");
        if (bean.getCodigo() == null) {
            bean.setCodigo((String)request.getSession().getAttribute("scodigo"));
        }
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setGerencia((String)request.getSession().getAttribute("gerencia"));
            bean.setUsuarioger((String)request.getSession().getAttribute("gerencia"));
            bean.setUsuario(usuario);
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("REGISTRA")) {

                Respuesta<Boolean> res = neg.verifica_registra_control(bean);
                if (res.getCodigo() == 1) {
                    //verifica si el usuario esta habilitado para el control ******
                    Respuesta<Boolean> ver =
                        gen.verificaAccesoUsuario(bean.getCodigo(), bean.getUsuario(), "REGISTRA", bean.getUsuarioger());
                    if (ver.getCodigo() == 1) {
                        request.setAttribute("OK", res.getMensaje());
                        Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                        if (inf.getResultado().getGa().equals("SI")) {
                            bean.setGa("on");
                        }
                        if (inf.getResultado().getIva().equals("SI")) {
                            bean.setIva("on");
                        }
                        if (inf.getResultado().getIce().equals("SI")) {
                            bean.setIce("on");
                        }
                        if (inf.getResultado().getIehd().equals("SI")) {
                            bean.setIehd("on");
                        }
                        if (inf.getResultado().getIcd().equals("SI")) {
                            bean.setIcd("on");
                        }
                        if (inf.getResultado().getNoaplica().equals("SI")) {
                            bean.setNoaplica("on");
                        }

                        if (inf.getResultado().getRiesgoDelito().equals("SI")) {
                            bean.setRiesgoDelito("on");
                        }
                        if (inf.getResultado().getRiesgoSubval().equals("SI")) {
                            bean.setRiesgoSubval("on");
                        }
                        if (inf.getResultado().getRiesgoClas().equals("SI")) {
                            bean.setRiesgoClas("on");
                        }
                        if (inf.getResultado().getRiesgoContrab().equals("SI")) {
                            bean.setRiesgoContrab("on");
                        }

                        bean.setNroDocumento(inf.getResultado().getNroDocumento());
                        bean.setFecDocumento(inf.getResultado().getFecDocumento());

                        request.setAttribute("RegistroControlForm", bean);
                        request.setAttribute("infoControl", inf.getResultado());
                        Respuesta<Tramite[]> tram = gen.ver_TramitesControl(bean.getCodigo());
                        request.setAttribute("tramites", tram.getResultado());
                        link = "ok";
                    } else {
                        if (ver.getMensaje().equals("NOPERFIL")) {
                            request.setAttribute("ERROR", "No tiene el perfil adecuado.");
                        } else {
                            request.setAttribute("ERROR", "No tiene acceso a la Orden de Fiscalizaci&oacute;n.");
                        }
                    }
                    //******
                } else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                        link = "index";
                    }
                }
            }
            return mapping.findForward(link);
        }
    }

    public ActionForward registro(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {

        RegistroControlForm bean = new RegistroControlForm();
        String link = "ok";
        bean = (RegistroControlForm)request.getAttribute("RegistroControlForm");
        bean = (RegistroControlForm)request.getAttribute("RegistroControlForm");
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setGerencia((String)request.getSession().getAttribute("gerencia"));
            bean.setUsuario(usuario);
            Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
            request.setAttribute("infoControl", inf.getResultado());
            Respuesta<Tramite[]> tram = gen.ver_TramitesControl(bean.getCodigo());
            request.setAttribute("tramites", tram.getResultado());
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("REGISTRA")) {
                Respuesta<Boolean> res = neg.registra_control(bean);
                if (res.getCodigo() == 1) {
                    request.setAttribute("OK", res.getMensaje());
                    /*String[] fisca = res.getMensaje().split("-");
                    request.getSession().setAttribute("sgestion", fisca[0].substring(37));
                    request.getSession().setAttribute("sgerencia", fisca[2]);
                    request.getSession().setAttribute("scontrol", fisca[1]);
                    request.getSession().setAttribute("snumero", fisca[3]);*/
                    link = "index";
                } else {
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
