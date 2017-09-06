package anb.action;


import anb.bean.AsignaFiscalizadorForm;

import anb.entidades.Fiscalizador;
import anb.entidades.InfoControl;
import anb.entidades.Tramite;

import anb.general.Respuesta;

import anb.negocio.AsignacionNeg;
import anb.negocio.GeneralNeg;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


public class AsignaFiscalizadorAction extends MappingDispatchAction {
    private final AsignacionNeg neg = new AsignacionNeg();
    private final GeneralNeg gen = new GeneralNeg();

    public ActionForward asignaidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {

        AsignaFiscalizadorForm bean = new AsignaFiscalizadorForm();
        bean = (AsignaFiscalizadorForm)request.getAttribute("AsignaFiscalizadorForm");
        if (bean.getCodigo() == null) {
            bean.setCodigo((String)request.getSession().getAttribute("scodigo"));
        }
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
                Respuesta<Boolean> res = neg.verifica_asigna_control(bean);

                if (res.getCodigo() == 1) {
                    request.getSession().setAttribute("scodigo", bean.getCodigo());
                    Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                    request.setAttribute("infoControl", inf.getResultado());
                    if (inf.getResultado().getTipoControl().equals("FISCALIZACION AMPLIATORIA")) {
                        request.setAttribute("ERROR", "No requerido para Fiscalizaci&oacute;n Ampliatoria");
                        link = "index";
                    } else {
                        //verifica si el usuario esta habilitado para el control ******
                        Respuesta<Boolean> ver =
                            gen.verificaAccesoUsuario(bean.getCodigo(), bean.getUsuario(), "ASIGNACION",
                                                      bean.getUsuarioger());
                        if (ver.getCodigo() == 1) {
                            Respuesta<Tramite[]> tram = gen.ver_TramitesControl(bean.getCodigo());
                            request.setAttribute("tramites", tram.getResultado());
                            Respuesta<Fiscalizador[]> asig = gen.devuelveFisAsignados(bean.getCodigo());
                            request.setAttribute("asignados", asig.getResultado());
                            Respuesta<List<Fiscalizador>> fis = gen.obtenerFuncionarios(bean.getCodger());
                            if (fis.getCodigo() == 1) {
                                request.setAttribute("fiscalizadores", fis.getResultado());
                            } else {
                                request.setAttribute("fiscalizadores", null);
                            }
                            link = "ok";
                        } else {
                            if (ver.getMensaje().equals("NOPERFIL")) {
                                request.setAttribute("ERROR", "No tiene el perfil adecuado.");
                            } else {
                                request.setAttribute("ERROR", "No tiene acceso a la Orden de Fiscalizaci&oacute;n.");
                            }
                        }
                        //******
                    }
                } else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                        link = "index";
                    }
                }
            } else {
                bean.setCodigo((String)request.getSession().getAttribute("scodigo"));
            }
            return mapping.findForward(link);
        }
    }

    public ActionForward asigna(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                HttpServletResponse response) throws Exception {

        AsignaFiscalizadorForm bean = new AsignaFiscalizadorForm();
        bean = (AsignaFiscalizadorForm)request.getAttribute("AsignaFiscalizadorForm");
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
                Respuesta<Boolean> res = neg.graba_asignacion(bean);
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
                Respuesta<Fiscalizador[]> asig = gen.devuelveFisAsignados(bean.getCodigo());
                request.setAttribute("asignados", asig.getResultado());

            }
            if ((bean.getOpcion() == null) || !bean.getOpcion().equals("BORRAR")) {
            } else {
                Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                request.setAttribute("infoControl", inf.getResultado());
                Respuesta<Tramite[]> tram = gen.ver_TramitesControl(bean.getCodigo());
                request.setAttribute("tramites", tram.getResultado());
                Respuesta<List<Fiscalizador>> fis = gen.obtenerFuncionarios(bean.getCodger());
                request.setAttribute("fiscalizadores", fis.getResultado());
                Respuesta<Boolean> res = neg.borra_asignacion(bean);
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
                Respuesta<Fiscalizador[]> asig = gen.devuelveFisAsignados(bean.getCodigo());
                request.setAttribute("asignados", asig.getResultado());
            }
            return mapping.findForward("ok");
        }
    }

    public ActionForward reasignaidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {

        AsignaFiscalizadorForm bean = new AsignaFiscalizadorForm();
        bean = (AsignaFiscalizadorForm)request.getAttribute("AsignaFiscalizadorForm");
        if (bean.getCodigo() == null) {
            bean.setCodigo((String)request.getSession().getAttribute("scodigo"));
        }
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
                Respuesta<Boolean> res2 =
                    gen.devuelveCodigo(bean.getFgestion(), bean.getFcontrol(), bean.getFgerencia(), bean.getFnumero());
                request.setAttribute("codigo", res2.getResultado());
                if (res2.getCodigo() == 1) {
                    bean.setCodigo(res2.getMensaje().toString());
                    Respuesta<Boolean> res = neg.verifica_acceso_control(bean);

                    if (res.getCodigo() == 1) {
                        request.getSession().setAttribute("scodigo", bean.getCodigo());
                        Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                        request.setAttribute("infoControl", inf.getResultado());
                        if (inf.getResultado().getTipoControl().equals("FISCALIZACION AMPLIATORIA")) {
                            request.setAttribute("ERROR", "No REQUERIDO PARA FISCALIZACION AMPLIATORIA");
                            link = "index";
                        } else {
                            //verifica si el usuario esta habilitado para el control ******
                            Respuesta<Boolean> ver =
                                gen.verificaAccesoUsuario(bean.getCodigo(), bean.getUsuario(), "REASIGNA",
                                                          bean.getUsuarioger());
                            if (ver.getCodigo() == 1) {
                                Respuesta<Tramite[]> tram = gen.ver_TramitesControl(bean.getCodigo());
                                request.setAttribute("tramites", tram.getResultado());
                                Respuesta<Fiscalizador[]> asig = gen.devuelveFisAccesos(bean.getCodigo());
                                request.setAttribute("asignados", asig.getResultado());
                                Respuesta<List<Fiscalizador>> fis = gen.obtenerFuncionarios(bean.getCodger());
                                if (fis.getCodigo() == 1) {
                                    request.setAttribute("fiscalizadores", fis.getResultado());
                                } else {
                                    request.setAttribute("fiscalizadores", null);
                                }
                                link = "ok";
                            } else {
                                if (ver.getMensaje().equals("NOPERFIL")) {
                                    request.setAttribute("ERROR", "No tiene el perfil adecuado.");
                                } else {
                                    request.setAttribute("ERROR",
                                                         "No tiene acceso a la Orden de Fiscalizaci&oacute;n.");
                                }
                            }
                            //******
                        }
                    } else {
                        if (res.getCodigo() == 0) {
                            request.setAttribute("WARNING", res.getMensaje());
                        } else {
                            request.setAttribute("ERROR", res.getMensaje());
                            link = "index";
                        }
                    }
                } else {
                    if (res2.getCodigo() == 0) {
                        request.setAttribute("WARNING", res2.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res2.getMensaje());
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

    public ActionForward reasigna(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {

        AsignaFiscalizadorForm bean = new AsignaFiscalizadorForm();
        bean = (AsignaFiscalizadorForm)request.getAttribute("AsignaFiscalizadorForm");
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
                Respuesta<Boolean> res = neg.graba_acceso(bean);
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
                Respuesta<Fiscalizador[]> asig = gen.devuelveFisAccesos(bean.getCodigo());
                request.setAttribute("asignados", asig.getResultado());

            }
            if ((bean.getOpcion() == null) || !bean.getOpcion().equals("BORRAR")) {
            } else {
                Respuesta<InfoControl> inf = gen.devuelveControl(bean.getCodigo());
                request.setAttribute("infoControl", inf.getResultado());
                Respuesta<Tramite[]> tram = gen.ver_TramitesControl(bean.getCodigo());
                request.setAttribute("tramites", tram.getResultado());
                Respuesta<List<Fiscalizador>> fis = gen.obtenerFuncionarios(bean.getCodger());
                request.setAttribute("fiscalizadores", fis.getResultado());
                Respuesta<Boolean> res = neg.borra_acceso(bean);
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
                Respuesta<Fiscalizador[]> asig = gen.devuelveFisAccesos(bean.getCodigo());
                request.setAttribute("asignados", asig.getResultado());
            }
            return mapping.findForward("ok");
        }
    }
}
