package anb.action;


import anb.bean.ConclusionControlForm;

import anb.entidades.Aduana;
import anb.entidades.Fiscalizador;
import anb.entidades.InfoControl;
import anb.entidades.PanelConclusion;
import anb.entidades.Tramite;

import anb.general.Respuesta;

import anb.negocio.ConclusionNeg;
import anb.negocio.GeneralNeg;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


public class ConclusionControlAction extends MappingDispatchAction {
    private final ConclusionNeg neg = new ConclusionNeg();
    private final GeneralNeg gen = new GeneralNeg();

    public ActionForward conclusionidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {

        ConclusionControlForm bean = new ConclusionControlForm();
        bean = (ConclusionControlForm)request.getAttribute("ConclusionControlForm");
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
                    Respuesta<Boolean> ver =
                        gen.verificaAccesoUsuario(bean.getCodigo(), bean.getUsuario(), "CONCLUSION",
                                                  bean.getUsuarioger());
                    if (ver.getCodigo() == 1) {                        
                        Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                        inf.getResultado().setUsuario(usuario);
                        request.setAttribute("infoControl", inf.getResultado());
                        Respuesta<List<Aduana>> adu = gen.obtenerAduanas2();
                        request.setAttribute("aduanas", adu.getResultado());
                        Respuesta<ConclusionControlForm> ben = neg.devuelveNotificacion(bean);
                        if (ben.getCodigo() == 1) {
                            Respuesta<PanelConclusion> panel = neg.devuelveConclusionPanel(bean.getCodigo());
                            request.setAttribute("panelConclusion", panel.getResultado());
                            bean = ben.getResultado();
                        }
                        link = "ok";
                    } else {
                        request.setAttribute("ERROR", "No esta asignado a la Orden de Fiscalizaci&oacute;n");
                    }
                    //******
                } else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                    }
                }
            } else {
                bean.setFgestion((String)request.getSession().getAttribute("sgestion"));
                bean.setFgerencia((String)request.getSession().getAttribute("sgerencia"));
                bean.setFcontrol((String)request.getSession().getAttribute("scontrol"));
                bean.setFnumero((String)request.getSession().getAttribute("snumero"));
            }
            return mapping.findForward(link);
        }
    }

    public ActionForward conclusion(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        ConclusionControlForm bean = new ConclusionControlForm();
        bean = (ConclusionControlForm)request.getAttribute("ConclusionControlForm");
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            bean.setCodger((String)request.getSession().getAttribute("user.codger"));
            Respuesta<List<Aduana>> adu = gen.obtenerAduanas2();
            request.setAttribute("aduanas", adu.getResultado());
            String link = "index";
            String codigo;
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("ASIGNA")) {
                Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                inf.getResultado().setUsuario(usuario);
                request.setAttribute("infoControl", inf.getResultado());
                Respuesta<Tramite[]> tram = gen.ver_TramitesControl(bean.getCodigo());
                request.setAttribute("tramites", tram.getResultado());
                Respuesta<List<Fiscalizador>> fis = gen.obtenerFuncionarios(bean.getCodger());
                request.setAttribute("fiscalizadores", fis.getResultado());
                Respuesta<Fiscalizador[]> asig = gen.devuelveFisAsignados(bean.getCodigo());
                request.setAttribute("asignados", asig.getResultado());
                Respuesta<Boolean> res = neg.graba_conclusion(bean);
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
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("con_viscargo")) {

                Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                inf.getResultado().setUsuario(usuario);
                request.setAttribute("infoControl", inf.getResultado());
                Respuesta<Tramite[]> tram = gen.ver_TramitesControl(bean.getCodigo());
                request.setAttribute("tramites", tram.getResultado());
                Respuesta<List<Fiscalizador>> fis = gen.obtenerFuncionarios(bean.getCodger());
                request.setAttribute("fiscalizadores", fis.getResultado());
                Respuesta<Fiscalizador[]> asig = gen.devuelveFisAsignados(bean.getCodigo());
                request.setAttribute("asignados", asig.getResultado());

                if (!(bean.getOpcion2() == null) && bean.getOpcion2().equals("concluir")) {
                    if (!(bean.getCvc_numero_vc().equals("")) && !(bean.getCvc_fecha_vc().equals(""))) {
                        bean.setTipo_grabado("CONCLUIR");
                        Respuesta<Boolean> res = neg.graba_con_viscargo(bean);
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
                    } else {
                        request.setAttribute("ERROR",
                                             "Para concluir la fiscalización con VISTA DE CARGO, debe registrar los campos Número de Vista de Cargo y Fecha de Vista de Cargo obligatoriamente.");
                    }
                } else {
                    bean.setTipo_grabado("GRABAR");
                    Respuesta<Boolean> res = neg.graba_con_viscargo(bean);
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
            }
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("con_resdeter")) {
                Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                inf.getResultado().setUsuario(usuario);
                request.setAttribute("infoControl", inf.getResultado());
                Respuesta<Tramite[]> tram = gen.ver_TramitesControl(bean.getCodigo());
                request.setAttribute("tramites", tram.getResultado());
                Respuesta<List<Fiscalizador>> fis = gen.obtenerFuncionarios(bean.getCodger());
                request.setAttribute("fiscalizadores", fis.getResultado());
                Respuesta<Fiscalizador[]> asig = gen.devuelveFisAsignados(bean.getCodigo());
                request.setAttribute("asignados", asig.getResultado());

                if (!(bean.getOpcion2() == null) && bean.getOpcion2().equals("concluir")) {
                    if (!(bean.getCrd_rd_final().equals("")) && !(bean.getCrd_fecha_not_rd_final().equals(""))) {
                        bean.setTipo_grabado("CONCLUIR");
                        Respuesta<Boolean> res = neg.graba_con_resdeter(bean);
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
                    } else {
                        request.setAttribute("ERROR",
                                             "Para concluir la fiscalización con RESOLUCIÓN DETERMINATIVA FINAL SIN VISTA DE CARGO , debe registrar los campos Número RD final y Fecha de notificación de la RD final obligatoriamente.");
                    }
                } else {
                    bean.setTipo_grabado("GRABAR");
                    Respuesta<Boolean> res = neg.graba_con_resdeter(bean);
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
            }
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("con_actainter")) {
                Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                inf.getResultado().setUsuario(usuario);
                request.setAttribute("infoControl", inf.getResultado());
                Respuesta<Tramite[]> tram = gen.ver_TramitesControl(bean.getCodigo());
                request.setAttribute("tramites", tram.getResultado());
                Respuesta<List<Fiscalizador>> fis = gen.obtenerFuncionarios(bean.getCodger());
                request.setAttribute("fiscalizadores", fis.getResultado());
                Respuesta<Fiscalizador[]> asig = gen.devuelveFisAsignados(bean.getCodigo());
                request.setAttribute("asignados", asig.getResultado());

                if (!(bean.getOpcion2() == null) && bean.getOpcion2().equals("concluir")) {
                    if (!(bean.getCai_acta_interv().equals("")) && !(bean.getCai_fecha_acta_interv().equals(""))) {
                        bean.setTipo_grabado("CONCLUIR");
                        Respuesta<Boolean> res = neg.graba_con_actainter(bean);
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
                    } else {
                        request.setAttribute("ERROR",
                                             "Para concluir la fiscalización con ACTA DE INTERVENCIÓN , debe registrar los campos Número Acta de Intervención y Fecha de la Acta de Intervención obligatoriamente.");
                    }
                } else {
                    bean.setTipo_grabado("GRABAR");
                    Respuesta<Boolean> res = neg.graba_con_actainter(bean);
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
            }
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("con_resadmin")) {
                Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                inf.getResultado().setUsuario(usuario);
                request.setAttribute("infoControl", inf.getResultado());
                Respuesta<Tramite[]> tram = gen.ver_TramitesControl(bean.getCodigo());
                request.setAttribute("tramites", tram.getResultado());
                Respuesta<List<Fiscalizador>> fis = gen.obtenerFuncionarios(bean.getCodger());
                request.setAttribute("fiscalizadores", fis.getResultado());
                Respuesta<Fiscalizador[]> asig = gen.devuelveFisAsignados(bean.getCodigo());
                request.setAttribute("asignados", asig.getResultado());

                if (!(bean.getOpcion2() == null) && bean.getOpcion2().equals("concluir")) {
                    if (!(bean.getCra_numero_ra().equals("")) && !(bean.getCra_fecha_ra().equals(""))) {
                        bean.setTipo_grabado("CONCLUIR");
                        Respuesta<Boolean> res = neg.graba_con_resadmin(bean);
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
                    } else {
                        request.setAttribute("ERROR",
                                             "Para concluir la fiscalización con RESOLUCIÓN ADMINISTRATIVA Y DETERMINATIVA DE FACILIDADES DE PAGO, debe registrar los campos Número de la Resolución Administrativa y Fecha de notificación de la Resolución Administrativa obligatoriamente.");
                    }
                } else {
                    bean.setTipo_grabado("GRABAR");
                    Respuesta<Boolean> res = neg.graba_con_resadmin(bean);
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
            }
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("con_autoinicial")) {
                Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                inf.getResultado().setUsuario(usuario);
                request.setAttribute("infoControl", inf.getResultado());
                Respuesta<Tramite[]> tram = gen.ver_TramitesControl(bean.getCodigo());
                request.setAttribute("tramites", tram.getResultado());
                Respuesta<List<Fiscalizador>> fis = gen.obtenerFuncionarios(bean.getCodger());
                request.setAttribute("fiscalizadores", fis.getResultado());
                Respuesta<Fiscalizador[]> asig = gen.devuelveFisAsignados(bean.getCodigo());
                request.setAttribute("asignados", asig.getResultado());

                if (!(bean.getOpcion2() == null) && bean.getOpcion2().equals("concluir")) {
                    if (!(bean.getCas_numero_aisc().equals("")) && !(bean.getCas_fecha_notificacion().equals(""))) {
                        bean.setTipo_grabado("CONCLUIR");
                        Respuesta<Boolean> res = neg.graba_con_autoinicial(bean);
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
                    } else {
                        request.setAttribute("ERROR",
                                             "Para concluir la fiscalización con AUTO INICIAL DE SUMARIO CONTRAVENCIONAL, debe registrar los campos Número AISC y Fecha de Notificación obligatoriamente.");
                    }
                } else {
                    bean.setTipo_grabado("GRABAR");
                    Respuesta<Boolean> res = neg.graba_con_autoinicial(bean);
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
            }
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("con_conclusion")) {
                Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                inf.getResultado().setUsuario(usuario);
                request.setAttribute("infoControl", inf.getResultado());
                Respuesta<Tramite[]> tram = gen.ver_TramitesControl(bean.getCodigo());
                request.setAttribute("tramites", tram.getResultado());
                Respuesta<List<Fiscalizador>> fis = gen.obtenerFuncionarios(bean.getCodger());
                request.setAttribute("fiscalizadores", fis.getResultado());
                Respuesta<Fiscalizador[]> asig = gen.devuelveFisAsignados(bean.getCodigo());
                request.setAttribute("asignados", asig.getResultado());
                Respuesta<Boolean> res = neg.graba_concluirfis(bean);
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
            Respuesta<PanelConclusion> panel = neg.devuelveConclusionPanel(bean.getCodigo());
            request.setAttribute("panelConclusion", panel.getResultado());
            Respuesta<ConclusionControlForm> ben = neg.devuelveNotificacion(bean);
            if (ben.getCodigo() == 1) {
                bean = ben.getResultado();
            }

            return mapping.findForward("ok");
        }
    }
}
