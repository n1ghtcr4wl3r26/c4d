package anb.action;


import anb.bean.AlcanceForm;
import anb.bean.ReporteForm;

import anb.entidades.Fiscalizador;
import anb.entidades.Gerencia;
import anb.entidades.InfoControl;
import anb.entidades.Reporte;
import anb.entidades.Tramite;

import anb.general.Respuesta;
import anb.general.Util;

import anb.negocio.AlcanceNeg;
import anb.negocio.GeneralNeg;
import anb.negocio.RegistroControlNeg;
import anb.negocio.ReporteNeg;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


public class ReporteAction extends MappingDispatchAction {
    private final RegistroControlNeg neg = new RegistroControlNeg();
    private final ReporteNeg repneg = new ReporteNeg();
    private final GeneralNeg gen = new GeneralNeg();
    private final AlcanceNeg alcneg = new AlcanceNeg();

    public ActionForward repordenidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {

        ReporteForm bean = new ReporteForm();
        String link = "index";
        bean = (ReporteForm)request.getAttribute("ReporteForm");
        if (bean.getCodigo() == null) {
            bean.setCodigo((String)request.getSession().getAttribute("scodigo"));
        }
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setGerencia((String)request.getSession().getAttribute("gerencia"));
            bean.setUsuario(usuario);
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
                    request.getSession().setAttribute("infoControl2", inf.getResultado());
                    Respuesta<Fiscalizador[]> asig = gen.devuelveFisAsignados(bean.getCodigo());
                    request.getSession().setAttribute("asignados2", asig.getResultado());
                    request.getSession().setAttribute("ReporteForm", bean);
                    link = "ok";
                } else {
                    request.getSession().setAttribute("ReporteForm", bean);
                    link = "error";
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

    public ActionForward repnotificacionidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                            HttpServletResponse response) throws Exception {

        ReporteForm bean = new ReporteForm();
        String link = "index";
        bean = (ReporteForm)request.getAttribute("ReporteForm");
        if (bean.getCodigo() == null) {
            bean.setCodigo((String)request.getSession().getAttribute("scodigo"));
        }
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setGerencia((String)request.getSession().getAttribute("gerencia"));
            bean.setUsuario(usuario);
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
                    request.getSession().setAttribute("infoControl2", inf.getResultado());
                    Respuesta<Fiscalizador[]> asig = gen.devuelveFisAsignados(bean.getCodigo());
                    request.getSession().setAttribute("asignados2", asig.getResultado());
                    request.getSession().setAttribute("ReporteForm", bean);
                    link = "ok";
                } else {
                    request.getSession().setAttribute("ReporteForm", bean);
                    link = "error";
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

    public ActionForward repalcanceidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {

        ReporteForm bean = new ReporteForm();
        String link = "index";
        bean = (ReporteForm)request.getAttribute("ReporteForm");
        if (bean.getCodigo() == null) {
            bean.setCodigo((String)request.getSession().getAttribute("scodigo"));
        }
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setGerencia((String)request.getSession().getAttribute("gerencia"));
            bean.setUsuario(usuario);
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
                    request.getSession().setAttribute("infoControl2", inf.getResultado());
                    Respuesta<Fiscalizador[]> asig = gen.devuelveFisAsignados(bean.getCodigo());
                    request.getSession().setAttribute("asignados2", asig.getResultado());
                    AlcanceForm bean2 = new AlcanceForm();
                    bean2.setCodigo(bean.getCodigo());
                    Respuesta<Tramite[]> tram = alcneg.ver_TramitesControlreporte(bean2);
                    request.getSession().setAttribute("tramites2", tram.getResultado());
                    request.getSession().setAttribute("canttram", tram.getCantidad());
                    request.getSession().setAttribute("ReporteForm", bean);
                    link = "ok";
                } else {
                    request.getSession().setAttribute("ReporteForm", bean);
                    link = "error";
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

    public ActionForward repampliacionidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                          HttpServletResponse response) throws Exception {

        ReporteForm bean = new ReporteForm();
        String link = "index";
        bean = (ReporteForm)request.getAttribute("ReporteForm");
        if (bean.getCodigo() == null) {
            bean.setCodigo((String)request.getSession().getAttribute("scodigo"));
        }
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setGerencia((String)request.getSession().getAttribute("gerencia"));
            bean.setUsuario(usuario);
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
                    request.getSession().setAttribute("infoControl2", inf.getResultado());
                    Respuesta<Fiscalizador[]> asig = gen.devuelveFisAsignados(bean.getCodigo());
                    request.getSession().setAttribute("asignados2", asig.getResultado());
                    AlcanceForm bean2 = new AlcanceForm();
                    bean2.setCodigo(bean.getCodigo());
                    Respuesta<Tramite[]> tram = alcneg.ver_TramitesControlrepamp(bean2);
                    request.getSession().setAttribute("tramites2amp", tram.getResultado());
                    request.getSession().setAttribute("canttramamp", tram.getCantidad());
                    request.getSession().setAttribute("ReporteForm", bean);
                    link = "ok";
                } else {
                    request.getSession().setAttribute("ReporteForm", bean);
                    link = "error";
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

    public ActionForward repcontrolidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {

        ReporteForm bean = new ReporteForm();
        String link = "index";
        bean = (ReporteForm)request.getAttribute("ReporteForm");
        if (bean.getCodigo() == null) {
            bean.setCodigo((String)request.getSession().getAttribute("scodigo"));
        }
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setGerencia((String)request.getSession().getAttribute("gerencia"));
            bean.setUsuario(usuario);
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
                    request.getSession().setAttribute("infoControl2", inf.getResultado());
                    Respuesta<Fiscalizador[]> asig = gen.devuelveFisAsignados(bean.getCodigo());
                    request.getSession().setAttribute("asignados2", asig.getResultado());
                    AlcanceForm bean2 = new AlcanceForm();
                    bean2.setCodigo(bean.getCodigo());
                    Respuesta<Tramite[]> tram = alcneg.ver_TramitesControlrepamp(bean2);
                    request.getSession().setAttribute("tramites2amp", tram.getResultado());
                    request.getSession().setAttribute("canttramamp", tram.getCantidad());
                    request.getSession().setAttribute("ReporteForm", bean);
                    link = "ok";
                } else {
                    request.getSession().setAttribute("ReporteForm", bean);
                    link = "error";
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

    public ActionForward repcontrolasigidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {

        ReporteForm bean = new ReporteForm();
        String link = "index";
        bean = (ReporteForm)request.getAttribute("ReporteForm");
        if (bean.getCodigo() == null) {
            bean.setCodigo((String)request.getSession().getAttribute("scodigo"));
        }
        String usuario = (String)request.getSession().getAttribute("user");
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setGerencia((String)request.getSession().getAttribute("gerencia"));
            bean.setUsuario(usuario);
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
                    request.getSession().setAttribute("infoControl2", inf.getResultado());
                    Respuesta<Fiscalizador[]> asig = gen.devuelveFisAsignados(bean.getCodigo());
                    request.getSession().setAttribute("asignados2", asig.getResultado());
                    AlcanceForm bean2 = new AlcanceForm();
                    bean2.setCodigo(bean.getCodigo());
                    Respuesta<Tramite[]> tram = alcneg.ver_TramitesControlrepamp(bean2);
                    request.getSession().setAttribute("tramites2amp", tram.getResultado());
                    request.getSession().setAttribute("canttramamp", tram.getCantidad());
                    request.getSession().setAttribute("ReporteForm", bean);
                    link = "ok";
                } else {
                    request.getSession().setAttribute("ReporteForm", bean);
                    link = "error";
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

    public ActionForward reporte_seguimiento_ordenidx(ActionMapping mapping, ActionForm form,
                                                      HttpServletRequest request,
                                                      HttpServletResponse response) throws Exception {
        ReporteForm bean = new ReporteForm();
        bean = (ReporteForm)request.getAttribute("ReporteForm");
        String usuario = (String)request.getSession().getAttribute("user");
        String link = "index";
        String codigo;
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);
            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("CONSULTAR")) {
                if (bean.getFnit().equals("")) {
                    bean.setFnitnombre("TODOS");
                } else {
                    bean.setFnitnombre(bean.getFnit());
                }
                if (bean.getFtipotramite().equals("%")) {
                    bean.setFtipotramitenombre("TODOS");
                } else {
                    bean.setFtipotramitenombre(bean.getFtipotramite());
                }
                if (bean.getFgerencia().equals("%")) {
                    bean.setFgerencianombre("TODAS LAS GERENCIAS");
                } else {
                    bean.setFgerencianombre(Util.NombreGerencia(bean.getFgerencia()));
                }
                if (!Util.esFecha(bean.getFfecini())) {
                    request.setAttribute("WARNING", "La Fecha de Inicio no es una fecha v&aacute;lida");
                    link = "index";
                    String geren = (String)request.getSession().getAttribute("user.codger");
                    bean.setUsuarioger(geren);
                    request.setAttribute("ReporteForm", bean);
                    if (geren.equals("15")) {
                        if (bean.getFgerencia() == null) {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        } else {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        }
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                    return mapping.findForward(link);
                }
                if (!Util.esFecha(bean.getFfecfin())) {
                    request.setAttribute("WARNING", "La Fecha de Inicio no es una fecha v&aacute;lida");
                    link = "index";
                    String geren = (String)request.getSession().getAttribute("user.codger");
                    bean.setUsuarioger(geren);
                    request.setAttribute("ReporteForm", bean);
                    if (geren.equals("15")) {
                        if (bean.getFgerencia() == null) {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        } else {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        }
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                    return mapping.findForward(link);
                }
                Respuesta<Reporte[]> ben = repneg.reporte_seguimiento_orden(bean);
                if (ben.getCodigo() == 1) {
                    request.setAttribute("reporte_seguimiento_orden", ben.getResultado());
                    link = "ok";
                } else {
                    String geren = (String)request.getSession().getAttribute("user.codger");
                    bean.setUsuarioger(geren);
                    if (geren.equals("15")) {
                        if (bean.getFgerencia() == null) {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        } else {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        }
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                    if (ben.getCodigo() == 0) {
                        request.setAttribute("WARNING", ben.getMensaje());
                    } else {
                        request.setAttribute("ERROR", ben.getMensaje());
                    }
                }
            } else {
                String geren = (String)request.getSession().getAttribute("user.codger");
                bean.setUsuarioger(geren);
                request.setAttribute("ReporteForm", bean);
                if (geren.equals("15")) {
                    if (bean.getFgerencia() == null) {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                        request.setAttribute("gerencias", ger.getResultado());
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                } else {
                    Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                    request.setAttribute("gerencias", ger.getResultado());
                }
            }
            return mapping.findForward(link);
        }
    }

    public ActionForward reporte_seguimiento_duiidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                                    HttpServletResponse response) throws Exception {

        ReporteForm bean = new ReporteForm();
        bean = (ReporteForm)request.getAttribute("ReporteForm");
        String usuario = (String)request.getSession().getAttribute("user");
        String link = "index";
        String codigo;
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);

            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("CONSULTAR")) {
                if (bean.getFnit().equals("")) {
                    bean.setFnitnombre("TODOS");
                } else {
                    bean.setFnitnombre(bean.getFnit());
                }
                if (bean.getFtipotramite().equals("%")) {
                    bean.setFtipotramitenombre("TODOS");
                } else {
                    bean.setFtipotramitenombre(bean.getFtipotramite());
                }
                if (bean.getFgerencia().equals("%")) {
                    bean.setFgerencianombre("TODAS LAS GERENCIAS");
                } else {
                    bean.setFgerencianombre(Util.NombreGerencia(bean.getFgerencia()));
                }
                if (!Util.esFecha(bean.getFfecini())) {
                    request.setAttribute("WARNING", "La Fecha de Inicio no es una fecha v&aacute;lida");
                    link = "index";
                    String geren = (String)request.getSession().getAttribute("user.codger");
                    bean.setUsuarioger(geren);
                    request.setAttribute("ReporteForm", bean);
                    if (geren.equals("15")) {
                        if (bean.getFgerencia() == null) {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        } else {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        }
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                    return mapping.findForward(link);
                }
                if (!Util.esFecha(bean.getFfecfin())) {
                    request.setAttribute("WARNING", "La Fecha de Inicio no es una fecha v&aacute;lida");
                    link = "index";
                    String geren = (String)request.getSession().getAttribute("user.codger");
                    bean.setUsuarioger(geren);
                    request.setAttribute("ReporteForm", bean);
                    if (geren.equals("15")) {
                        if (bean.getFgerencia() == null) {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        } else {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        }
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                    return mapping.findForward(link);
                }
                Respuesta<Reporte[]> ben = repneg.reporte_seguimiento_dui(bean);
                if (ben.getCodigo() == 1) {
                    request.setAttribute("reporte_seguimiento_dui", ben.getResultado());
                    link = "ok";
                } else {
                    String geren = (String)request.getSession().getAttribute("user.codger");
                    bean.setUsuarioger(geren);
                    if (geren.equals("15")) {
                        if (bean.getFgerencia() == null) {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        } else {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        }
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                    if (ben.getCodigo() == 0) {
                        request.setAttribute("WARNING", ben.getMensaje());
                    } else {
                        request.setAttribute("ERROR", ben.getMensaje());
                    }
                }
            } else {
                String geren = (String)request.getSession().getAttribute("user.codger");
                bean.setUsuarioger(geren);
                request.setAttribute("ReporteForm", bean);
                if (geren.equals("15")) {
                    if (bean.getFgerencia() == null) {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                        request.setAttribute("gerencias", ger.getResultado());
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                } else {
                    Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                    request.setAttribute("gerencias", ger.getResultado());
                }
            }
            return mapping.findForward(link);
        }
    }

    public ActionForward reporte_seguimiento_itemidx(ActionMapping mapping, ActionForm form,
                                                     HttpServletRequest request,
                                                     HttpServletResponse response) throws Exception {

        ReporteForm bean = new ReporteForm();
        bean = (ReporteForm)request.getAttribute("ReporteForm");
        String usuario = (String)request.getSession().getAttribute("user");
        String link = "index";
        String codigo;
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);

            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("CONSULTAR")) {
                if (bean.getFnit().equals("")) {
                    bean.setFnitnombre("TODOS");
                } else {
                    bean.setFnitnombre(bean.getFnit());
                }
                if (bean.getFtipotramite().equals("%")) {
                    bean.setFtipotramitenombre("TODOS");
                } else {
                    bean.setFtipotramitenombre(bean.getFtipotramite());
                }
                if (bean.getFgerencia().equals("%")) {
                    bean.setFgerencianombre("TODAS LAS GERENCIAS");
                } else {
                    bean.setFgerencianombre(Util.NombreGerencia(bean.getFgerencia()));
                }
                if (!Util.esFecha(bean.getFfecini())) {
                    request.setAttribute("WARNING", "La Fecha de Inicio no es una fecha v&aacute;lida");
                    link = "index";
                    String geren = (String)request.getSession().getAttribute("user.codger");
                    bean.setUsuarioger(geren);
                    request.setAttribute("ReporteForm", bean);
                    if (geren.equals("15")) {
                        if (bean.getFgerencia() == null) {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        } else {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        }
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                    return mapping.findForward(link);
                }
                if (!Util.esFecha(bean.getFfecfin())) {
                    request.setAttribute("WARNING", "La Fecha de Inicio no es una fecha v&aacute;lida");
                    link = "index";
                    String geren = (String)request.getSession().getAttribute("user.codger");
                    bean.setUsuarioger(geren);
                    request.setAttribute("ReporteForm", bean);
                    if (geren.equals("15")) {
                        if (bean.getFgerencia() == null) {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        } else {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        }
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                    return mapping.findForward(link);
                }
                Respuesta<Reporte[]> ben = repneg.reporte_seguimiento_item(bean);
                if (ben.getCodigo() == 1) {
                    request.setAttribute("reporte_seguimiento_item", ben.getResultado());
                    link = "ok";
                } else {
                    String geren = (String)request.getSession().getAttribute("user.codger");
                    bean.setUsuarioger(geren);
                    if (geren.equals("15")) {
                        if (bean.getFgerencia() == null) {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        } else {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        }
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                    if (ben.getCodigo() == 0) {
                        request.setAttribute("WARNING", ben.getMensaje());
                    } else {
                        request.setAttribute("ERROR", ben.getMensaje());
                    }
                }
            } else {
                String geren = (String)request.getSession().getAttribute("user.codger");
                bean.setUsuarioger(geren);
                request.setAttribute("ReporteForm", bean);
                if (geren.equals("15")) {
                    if (bean.getFgerencia() == null) {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                        request.setAttribute("gerencias", ger.getResultado());
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                } else {
                    Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                    request.setAttribute("gerencias", ger.getResultado());
                }
            }
            return mapping.findForward(link);
        }
    }

    public ActionForward reporte_liquidacion_duiidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                                    HttpServletResponse response) throws Exception {

        ReporteForm bean = new ReporteForm();
        bean = (ReporteForm)request.getAttribute("ReporteForm");
        String usuario = (String)request.getSession().getAttribute("user");
        String link = "index";
        String codigo;
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);

            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("CONSULTAR")) {
                if (bean.getFnit().equals("")) {
                    bean.setFnitnombre("TODOS");
                } else {
                    bean.setFnitnombre(bean.getFnit());
                }
                if (bean.getFtipotramite().equals("%")) {
                    bean.setFtipotramitenombre("TODOS");
                } else {
                    bean.setFtipotramitenombre(bean.getFtipotramite());
                }
                if (bean.getFgerencia().equals("%")) {
                    bean.setFgerencianombre("TODAS LAS GERENCIAS");
                } else {
                    bean.setFgerencianombre(Util.NombreGerencia(bean.getFgerencia()));
                }
                if (!Util.esFecha(bean.getFfecini())) {
                    request.setAttribute("WARNING", "La Fecha de Inicio no es una fecha v&aacute;lida");
                    link = "index";
                    String geren = (String)request.getSession().getAttribute("user.codger");
                    bean.setUsuarioger(geren);
                    request.setAttribute("ReporteForm", bean);
                    if (geren.equals("15")) {
                        if (bean.getFgerencia() == null) {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        } else {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        }
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                    return mapping.findForward(link);
                }
                if (!Util.esFecha(bean.getFfecfin())) {
                    request.setAttribute("WARNING", "La Fecha de Inicio no es una fecha v&aacute;lida");
                    link = "index";
                    String geren = (String)request.getSession().getAttribute("user.codger");
                    bean.setUsuarioger(geren);
                    request.setAttribute("ReporteForm", bean);
                    if (geren.equals("15")) {
                        if (bean.getFgerencia() == null) {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        } else {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        }
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                    return mapping.findForward(link);
                }
                Respuesta<Reporte[]> ben = repneg.reporte_liquidacion_dui(bean);
                if (ben.getCodigo() == 1) {
                    request.setAttribute("reporte_liquidacion_dui", ben.getResultado());
                    link = "ok";
                } else {
                    String geren = (String)request.getSession().getAttribute("user.codger");
                    bean.setUsuarioger(geren);
                    if (geren.equals("15")) {
                        if (bean.getFgerencia() == null) {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        } else {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        }
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                    if (ben.getCodigo() == 0) {
                        request.setAttribute("WARNING", ben.getMensaje());
                    } else {
                        request.setAttribute("ERROR", ben.getMensaje());
                    }
                }
            } else {
                String geren = (String)request.getSession().getAttribute("user.codger");
                bean.setUsuarioger(geren);
                request.setAttribute("ReporteForm", bean);
                if (geren.equals("15")) {
                    if (bean.getFgerencia() == null) {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                        request.setAttribute("gerencias", ger.getResultado());
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                } else {
                    Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                    request.setAttribute("gerencias", ger.getResultado());
                }
            }
            return mapping.findForward(link);
        }
    }

    public ActionForward reporte_liquidacion_itemidx(ActionMapping mapping, ActionForm form,
                                                     HttpServletRequest request,
                                                     HttpServletResponse response) throws Exception {

        ReporteForm bean = new ReporteForm();
        bean = (ReporteForm)request.getAttribute("ReporteForm");
        String usuario = (String)request.getSession().getAttribute("user");
        String link = "index";
        String codigo;
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);

            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("CONSULTAR")) {
                if (bean.getFnit().equals("")) {
                    bean.setFnitnombre("TODOS");
                } else {
                    bean.setFnitnombre(bean.getFnit());
                }
                if (bean.getFtipotramite().equals("%")) {
                    bean.setFtipotramitenombre("TODOS");
                } else {
                    bean.setFtipotramitenombre(bean.getFtipotramite());
                }
                if (bean.getFgerencia().equals("%")) {
                    bean.setFgerencianombre("TODAS LAS GERENCIAS");
                } else {
                    bean.setFgerencianombre(Util.NombreGerencia(bean.getFgerencia()));
                }
                if (!Util.esFecha(bean.getFfecini())) {
                    request.setAttribute("WARNING", "La Fecha de Inicio no es una fecha v&aacute;lida");
                    link = "index";
                    String geren = (String)request.getSession().getAttribute("user.codger");
                    bean.setUsuarioger(geren);
                    request.setAttribute("ReporteForm", bean);
                    if (geren.equals("15")) {
                        if (bean.getFgerencia() == null) {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        } else {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        }
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                    return mapping.findForward(link);
                }
                if (!Util.esFecha(bean.getFfecfin())) {
                    request.setAttribute("WARNING", "La Fecha de Inicio no es una fecha v&aacute;lida");
                    link = "index";
                    String geren = (String)request.getSession().getAttribute("user.codger");
                    bean.setUsuarioger(geren);
                    request.setAttribute("ReporteForm", bean);
                    if (geren.equals("15")) {
                        if (bean.getFgerencia() == null) {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        } else {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        }
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                    return mapping.findForward(link);
                }
                Respuesta<Reporte[]> ben = repneg.reporte_liquidacion_item(bean);
                if (ben.getCodigo() == 1) {
                    request.setAttribute("reporte_liquidacion_item", ben.getResultado());
                    link = "ok";
                } else {
                    String geren = (String)request.getSession().getAttribute("user.codger");
                    bean.setUsuarioger(geren);
                    if (geren.equals("15")) {
                        if (bean.getFgerencia() == null) {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        } else {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        }
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                    if (ben.getCodigo() == 0) {
                        request.setAttribute("WARNING", ben.getMensaje());
                    } else {
                        request.setAttribute("ERROR", ben.getMensaje());
                    }
                }
            } else {
                String geren = (String)request.getSession().getAttribute("user.codger");
                bean.setUsuarioger(geren);
                request.setAttribute("ReporteForm", bean);
                if (geren.equals("15")) {
                    if (bean.getFgerencia() == null) {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                        request.setAttribute("gerencias", ger.getResultado());
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                } else {
                    Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                    request.setAttribute("gerencias", ger.getResultado());
                }
            }
            return mapping.findForward(link);
        }
    }

    public ActionForward reporte_recuperacion_duiidx(ActionMapping mapping, ActionForm form,
                                                     HttpServletRequest request,
                                                     HttpServletResponse response) throws Exception {

        ReporteForm bean = new ReporteForm();
        bean = (ReporteForm)request.getAttribute("ReporteForm");
        String usuario = (String)request.getSession().getAttribute("user");
        String link = "index";
        String codigo;
        if (usuario == null) {
            return mapping.findForward("nook");
        } else {
            bean.setUsuario(usuario);

            if (!(bean.getOpcion() == null) && bean.getOpcion().equals("CONSULTAR")) {
                if (bean.getFnit().equals("")) {
                    bean.setFnitnombre("TODOS");
                } else {
                    bean.setFnitnombre(bean.getFnit());
                }
                if (bean.getFtipotramite().equals("%")) {
                    bean.setFtipotramitenombre("TODOS");
                } else {
                    bean.setFtipotramitenombre(bean.getFtipotramite());
                }
                if (bean.getFgerencia().equals("%")) {
                    bean.setFgerencianombre("TODAS LAS GERENCIAS");
                } else {
                    bean.setFgerencianombre(Util.NombreGerencia(bean.getFgerencia()));
                }
                if (!Util.esFecha(bean.getFfecini())) {
                    request.setAttribute("WARNING", "La Fecha de Inicio no es una fecha v&aacute;lida");
                    link = "index";
                    String geren = (String)request.getSession().getAttribute("user.codger");
                    bean.setUsuarioger(geren);
                    request.setAttribute("ReporteForm", bean);
                    if (geren.equals("15")) {
                        if (bean.getFgerencia() == null) {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        } else {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        }
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                    return mapping.findForward(link);
                }
                if (!Util.esFecha(bean.getFfecfin())) {
                    request.setAttribute("WARNING", "La Fecha de Inicio no es una fecha v&aacute;lida");
                    link = "index";
                    String geren = (String)request.getSession().getAttribute("user.codger");
                    bean.setUsuarioger(geren);
                    request.setAttribute("ReporteForm", bean);
                    if (geren.equals("15")) {
                        if (bean.getFgerencia() == null) {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        } else {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        }
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                    return mapping.findForward(link);
                }
                Respuesta<Reporte[]> ben = repneg.reporte_recuperacion_dui(bean);
                if (ben.getCodigo() == 1) {
                    request.setAttribute("reporte_recuperacion_dui", ben.getResultado());
                    link = "ok";
                } else {
                    String geren = (String)request.getSession().getAttribute("user.codger");
                    bean.setUsuarioger(geren);
                    if (geren.equals("15")) {
                        if (bean.getFgerencia() == null) {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        } else {
                            Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                            request.setAttribute("gerencias", ger.getResultado());
                        }
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                    if (ben.getCodigo() == 0) {
                        request.setAttribute("WARNING", ben.getMensaje());
                    } else {
                        request.setAttribute("ERROR", ben.getMensaje());
                    }
                }
            } else {
                String geren = (String)request.getSession().getAttribute("user.codger");
                bean.setUsuarioger(geren);
                request.setAttribute("ReporteForm", bean);
                if (geren.equals("15")) {
                    if (bean.getFgerencia() == null) {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                        request.setAttribute("gerencias", ger.getResultado());
                    } else {
                        Respuesta<List<Gerencia>> ger = gen.obtenerGerencias("Todo");
                        request.setAttribute("gerencias", ger.getResultado());
                    }
                } else {
                    Respuesta<List<Gerencia>> ger = gen.obtenerGerencias(geren);
                    request.setAttribute("gerencias", ger.getResultado());
                }
            }
            return mapping.findForward(link);
        }
    }
}
