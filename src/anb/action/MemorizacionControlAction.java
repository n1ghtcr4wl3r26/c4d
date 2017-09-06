package anb.action;


import anb.bean.AlcanceForm;
import anb.bean.MemorizacionControlForm;

import anb.entidades.Aduana;
import anb.entidades.Declaracion;
import anb.entidades.Nit;

import anb.general.Json;
import anb.general.Respuesta;
import anb.general.Util;

import anb.negocio.AlcanceNeg;
import anb.negocio.GeneralNeg;
import anb.negocio.MemorizacionControlNeg;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


public class MemorizacionControlAction extends MappingDispatchAction {

    private final MemorizacionControlNeg neg = new MemorizacionControlNeg();
    private final GeneralNeg gen = new GeneralNeg();
    private final AlcanceNeg alcneg = new AlcanceNeg();
    
    public ActionForward index(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                               HttpServletResponse response) throws Exception {

        MemorizacionControlForm bean = new MemorizacionControlForm();
        bean = (MemorizacionControlForm)request.getAttribute("MemorizacionControlForm");
        return mapping.findForward("ok");
    }

    public ActionForward memorizardif(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        MemorizacionControlForm bean = new MemorizacionControlForm();
        bean = (MemorizacionControlForm)request.getAttribute("MemorizacionControlForm");
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setGerencia((String)request.getSession().getAttribute("sgerencia"));
            if (!(bean == null)) {
                if (!(bean.getBoton() == null)) {
                    if (bean.getBoton().equals("diferido")) {
                        Respuesta<Boolean> res = neg.grabaMemorizacionDiferido(bean);
                        if (res.getCodigo() == 1) {
                            request.setAttribute("OK",
                                                 "Se memoriz&oacute; correctamente el Control Diferido. " + res.getMensaje());
                            bean.setCodigocontrol(res.getMensaje());
                            request.getSession().setAttribute("scodigo", bean.getCodigocontrol());
                            return mapping.findForward("ok");
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                            return mapping.findForward("ok");
                        }
                    }
                }
            }
            return mapping.findForward("ok");
        }
    }

    public ActionForward memorizarpos(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        MemorizacionControlForm bean = new MemorizacionControlForm();
        bean = (MemorizacionControlForm)request.getAttribute("MemorizacionControlForm");
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setGerencia((String)request.getSession().getAttribute("sgerencia"));
            if (!(bean == null)) {
                if (!(bean.getBoton() == null)) {
                    if (bean.getBoton().equals("posterior")) {
                        Respuesta<Boolean> res = neg.grabaMemorizacionPosterior(bean);
                        if (res.getCodigo() == 1) {
                            request.setAttribute("OK",
                                                 "Se memoriz&oacute; correctamente la Orden de Fiscalizaci&oacute;n Posterior. " + res.getMensaje());
                            bean.setCodigocontrol(res.getMensaje());
                            request.getSession().setAttribute("scodigo", bean.getCodigocontrol());
                            return mapping.findForward("ok");
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                            return mapping.findForward("ok");
                        }
                    }
                }
            }
            return mapping.findForward("ok");
        }
    }

    public ActionForward memorizaramp(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        MemorizacionControlForm bean = new MemorizacionControlForm();
        bean = (MemorizacionControlForm)request.getAttribute("MemorizacionControlForm");
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setGerencia((String)request.getSession().getAttribute("sgerencia"));
            if (!(bean == null)) {
                if (!(bean.getBoton() == null)) {
                    if (bean.getBoton().equals("ampliatoria")) {
                        Respuesta<Boolean> res = neg.grabaMemorizacionAmpliatoria(bean);
                        if (res.getCodigo() == 1) {
                            request.setAttribute("OK",
                                                 "Se memoriz&oacute; correctamente la Orden Ampliatoria. " + res.getMensaje());
                            bean.setCodigocontrol(res.getMensaje());
                            request.getSession().setAttribute("scodigo", bean.getCodigocontrol());
                            return mapping.findForward("ok");
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                            return mapping.findForward("ok");
                        }
                    }
                }
            }
            return mapping.findForward("ok");
        }
    }
    
    public ActionForward memorizarenv(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        MemorizacionControlForm bean = new MemorizacionControlForm();
        bean = (MemorizacionControlForm)request.getAttribute("MemorizacionControlForm");
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setGerencia((String)request.getSession().getAttribute("sgerencia"));
            if (!(bean == null)) {
                if (!(bean.getBoton() == null)) {
                    if (bean.getBoton().equals("alcance")) {
                        AlcanceForm alc = new AlcanceForm();
                        alc.setCodigo(bean.getCodigocontrol());
                        alc.setOpcion("CONSULTACTL");
                        request.getSession().setAttribute("AlcanceForm", alc);
                        return mapping.findForward("alcance");
                    }
                }
            }
            return mapping.findForward("ok");
        }
    }
        
    public ActionForward memorizarenvreg(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        MemorizacionControlForm bean = new MemorizacionControlForm();
        bean = (MemorizacionControlForm)request.getAttribute("MemorizacionControlForm");
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setGerencia((String)request.getSession().getAttribute("sgerencia"));
            if (!(bean == null)) {
                if (!(bean.getBoton() == null)) {
                    if (bean.getBoton().equals("alcance")) {
                        AlcanceForm alc = new AlcanceForm();
                        alc.setCodigo(bean.getCodigocontrol());
                        alc.setOpcion("CONSULTACTL");
                        request.getSession().setAttribute("AlcanceForm", alc);
                        return mapping.findForward("alcance");
                    }
                }
            }
            return mapping.findForward("ok");
        }
    }
    
    
    public ActionForward completanit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        Util.noCache(response);
        Util.isAjax(request, response);
        String nit = request.getParameter("nit");
    
        Respuesta<Nit[]>res=neg.devuelveNit(nit);
        if(res.getCodigo()==1){
            Json.gson(response, res.getResultado());
        }
        else{
            Json.error(response, res.getMensaje());
        }

        return null;
        
    }
    
    public ActionForward memorizardiferidoindex(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        MemorizacionControlForm bean = new MemorizacionControlForm();
        bean = (MemorizacionControlForm)request.getAttribute("MemorizacionControlForm");
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setGerencia((String)request.getSession().getAttribute("sgerencia"));
            Respuesta<List<Aduana>> adu = gen.obtenerAduanas2();
            if (adu.getCodigo() == 1) {
                request.setAttribute("aduanas", adu.getResultado());
            } else {
                request.setAttribute("aduanas", null);
            }
            if (!(bean == null)) {
                if (!(bean.getOpcion() == null)) {
                    if (bean.getOpcion().equals("CONSULTA1")) {
                        Respuesta<Declaracion[]> res = neg.consulta1(bean);
                        bean.setCantidad_dec(res.getCantidad());
                        if (res.getCodigo() == 1) {
                            request.setAttribute("declaraciones", res.getResultado());
                        } else {
                            request.setAttribute("declaraciones", null);
                            if (res.getCodigo() == 0) {
                                request.setAttribute("WARNING", res.getMensaje());
                            } else {
                                request.setAttribute("ERROR", res.getMensaje());
                            }
                        }
                        return mapping.findForward("ok");
                    }
                    if (bean.getOpcion().equals("CONSULTA2")) {
                        Respuesta<Declaracion[]> res = neg.consulta2(bean);
                        bean.setCantidad_dec(res.getCantidad());
                        if (res.getCodigo() == 1) {
                            request.setAttribute("declaraciones", res.getResultado());
                        } else {
                            request.setAttribute("declaraciones", null);
                            if (res.getCodigo() == 0) {
                                request.setAttribute("WARNING", res.getMensaje());
                            } else {
                                request.setAttribute("ERROR", res.getMensaje());
                            }
                        }
                        return mapping.findForward("ok");
                    }
                    if (bean.getOpcion().equals("CONSULTA3")) {
                        Respuesta<Declaracion[]> res = neg.consulta3(bean);
                        bean.setCantidad_dec(res.getCantidad());
                        if (res.getCodigo() == 1) {
                            request.setAttribute("declaraciones", res.getResultado());
                        } else {
                            request.setAttribute("declaraciones", null);
                            if (res.getCodigo() == 0) {
                                request.setAttribute("WARNING", res.getMensaje());
                            } else {
                                request.setAttribute("ERROR", res.getMensaje());
                            }
                        }
                        return mapping.findForward("ok");
                    }
                }
                if (!(bean.getFropcion() == null)) {
                    if (bean.getFropcion().equals("INICIAR")) {
                        Respuesta<Declaracion[]> dui = neg.devuelveDatosDUI(bean.getFrcodigo());
                        if(dui.getCodigo()==1){
                            Declaracion dec = dui.getResultado()[0];
                            Respuesta<Nit[]>res=neg.devuelveNit(dec.getSad_consignee());
                            if(res.getCodigo()==1){
                                Nit imp = res.getResultado()[0];
                                bean.setDifTipoDocumento("DECLARACION");
                                bean.setDifNroDocumento(dec.getSad_reg_year()+"/"+dec.getKey_cuo()+"/C-"+dec.getSad_reg_nber());
                                bean.setMgestion(dec.getSad_reg_year());
                                bean.setMaduana(dec.getKey_cuo());
                                bean.setMnumero(dec.getSad_reg_nber());
                                bean.setDifFecDocumento(dec.getSad_reg_date());
                                bean.setDifRiesgoSubval("on");
                                bean.setDifTipoOperador("IMPORTADOR/EXPORTADOR");
                                bean.setDifTipoDocPersona(imp.getTipodoc());
                                bean.setDifNitEmpresa(imp.getNit());
                                bean.setDifNomEmpresa(imp.getRazon());
                                bean.setDifDireccion(imp.getDireccion());
                                bean.setDifActividad(imp.getActividad());
                                bean.setDifTribNoaplica("on");
                                bean.setDifPeriodo(dec.getSad_reg_year());
                                bean.setDifNroCIPersona(imp.getNit());
                                bean.setDifApPatPersona(imp.getPaterno());
                                bean.setDifApMatPersona(imp.getMaterno());
                                bean.setDifNombrePersona(imp.getNombre());
                                bean.setDifExpCIPersona(imp.getEmision());
                            }
                        }
                        request.setAttribute("MemorizacionControlForm", bean);
                        return mapping.findForward("success");
                    }
                    if (bean.getOpcion().equals("DESESTIMAR")) {
                        request.getSession().setAttribute("MemorizacionDiferido", bean);
                        return mapping.findForward("success");
                    }
                }
            }
            return mapping.findForward("ok");
        }
    }
    
    public ActionForward memorizardiferido(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        MemorizacionControlForm bean = new MemorizacionControlForm();
        bean = (MemorizacionControlForm)request.getAttribute("MemorizacionControlForm");
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setGerencia((String)request.getSession().getAttribute("sgerencia"));
            if (!(bean == null)) {
                if (!(bean.getBoton() == null)) {
                    if (bean.getBoton().equals("diferido")) {
                        Respuesta<Boolean> res = neg.grabaMemorizacionDiferido(bean);
                        if (res.getCodigo() == 1) {
                            AlcanceForm balc = new AlcanceForm();  
                            balc.setCodigo(res.getMensaje());
                            balc.setTipoTramite("DUI");
                            balc.setGestion(bean.getMgestion());
                            balc.setAduana(bean.getMaduana());
                            balc.setNumero(bean.getMnumero());
                            if(bean.getDifTipoDocPersona().equals("NIT"))
                                balc.setNumeroOperador(bean.getDifNitEmpresa());
                            else
                                balc.setNumeroOperador(bean.getDifNroCIPersona());
                            balc.setUsuario(bean.getUsuario());
                            balc.setChvalor("on");
                            balc.setChpartida("on");
                            balc.setChorigen("on");
                            balc.setChotro("on");
                            Respuesta<Boolean> alc = alcneg.graba_tramite_dec(balc);
                            if (alc.getCodigo() == 1) {
                                request.setAttribute("OK",
                                                     "Se memoriz&oacute; correctamente el Control Diferido. " + res.getMensaje());
                                bean.setCodigocontrol(res.getMensaje());
                                request.getSession().setAttribute("scodigo", bean.getCodigocontrol());
                                return mapping.findForward("ok");
                            } else {
                                if (res.getCodigo() == 0) {
                                    request.setAttribute("WARNING", res.getMensaje());
                                } else {
                                    request.setAttribute("ERROR", res.getMensaje());
                                }
                            }                            
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                            return mapping.findForward("ok");
                        }
                    }
                }
            }
            return mapping.findForward("ok");
        }
    }
}
