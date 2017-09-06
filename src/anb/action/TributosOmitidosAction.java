package anb.action;


import anb.bean.TributosOmitidosForm;

import anb.entidades.InfoControl;
import anb.entidades.TributosOmitidos;
import anb.entidades.TributosOmitidosTotales;

import anb.general.Respuesta;

import anb.negocio.GeneralNeg;
import anb.negocio.TributosOmitidosNeg;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


public class TributosOmitidosAction extends MappingDispatchAction {
    private final TributosOmitidosNeg neg = new TributosOmitidosNeg();
    private final GeneralNeg gen = new GeneralNeg();
    
    public ActionForward tributosidx(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {
        
        TributosOmitidosForm bean = new TributosOmitidosForm();
        bean = (TributosOmitidosForm)request.getAttribute("TributosOmitidosForm");
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
                    Respuesta<TributosOmitidos[]> ben = neg.devuelveTributosOmitidos(bean);
                    Respuesta<TributosOmitidosTotales> bentot = neg.devuelveTributosOmitidosTotales(bean);
                    
                    DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
                    simbolo.setDecimalSeparator('.');
                    simbolo.setGroupingSeparator(',');
                    DecimalFormat formato = new DecimalFormat("#,###,###.##", simbolo);
                    formato.setMaximumFractionDigits(2);
                    formato.setMinimumFractionDigits(2);
                                        
                    if (ben.getCodigo() == 1) {
                        bean.setCantidad("1");
                        double total = 0;
                        double ttotal = 0;
                        double totot = 0;
                        double sancion = 0;
                        double facufvact = 0;
                        int sw = 0;
                        String fecnotvc = "";
                        String fecnotvc10 = "";
                        String fecnotrdvc = "";
                        String diasnotvc = "";
                        String diasnotrdvc = "";
                        for (int i = 0; i <  ben.getResultado().length; i++) {
                            TributosOmitidos trib = (TributosOmitidos)ben.getResultado()[i];
                            total = total + Double.parseDouble(trib.getTotal().toString());
                            totot = totot + Double.parseDouble(trib.getTototact().toString());
                            if(sw == 0){
                                fecnotvc = trib.getFecnotvc();
                                fecnotvc10 = trib.getFecnotvc10();
                                fecnotrdvc = trib.getFecnotrdvc();
                                diasnotvc = trib.getDiasnotvc();
                                diasnotrdvc = trib.getDiasnotrdvc();
                                sw = 1;
                            }
                            ben.getResultado()[i].setGa(formato.format(Double.parseDouble(ben.getResultado()[i].getGa())));
                            ben.getResultado()[i].setIva(formato.format(Double.parseDouble(ben.getResultado()[i].getIva())));
                            ben.getResultado()[i].setIce(formato.format(Double.parseDouble(ben.getResultado()[i].getIce())));
                            ben.getResultado()[i].setIehd(formato.format(Double.parseDouble(ben.getResultado()[i].getIehd())));
                            ben.getResultado()[i].setIcd(formato.format(Double.parseDouble(ben.getResultado()[i].getIcd())));
                            ben.getResultado()[i].setTotal(formato.format(Double.parseDouble(ben.getResultado()[i].getTotal())));
                        }                        
                        bentot.getResultado().setTotal(String.valueOf(total));
                        /*Calculo de la Sancion*/
                        if(fecnotvc == null){
                            sancion = 0;
                        } else {
                            if(Integer.parseInt(diasnotvc) <= 0){
                                sancion = 0;
                            } else {
                                if(diasnotrdvc == null){
                                    sancion = totot * 0.2;
                                } else {
                                    if(Integer.parseInt(diasnotrdvc) <= 0){
                                        sancion = totot * 0.2;
                                    } else {
                                        sancion = totot * 0.4;
                                    } 
                                }   
                            }   
                        }
                        
                        bentot.getResultado().setSancionomision(String.valueOf(sancion)); 
                        /*---------*/
                        
                        /*ttotal = Double.parseDouble(bentot.getResultado().getContravdui());
                        ttotal = Double.parseDouble(bentot.getResultado().getContravorden());*/
                        ttotal = ttotal + Double.parseDouble(bentot.getResultado().getTotal()) + Double.parseDouble(bentot.getResultado().getSancionomision()) + Double.parseDouble(bentot.getResultado().getContravdui()) + Double.parseDouble(bentot.getResultado().getContravorden()) + Double.parseDouble(bentot.getResultado().getSancioncontrabando()) + Double.parseDouble(bentot.getResultado().getSanciondefraudacion()) + Double.parseDouble(bentot.getResultado().getDelito()) ;
                        bentot.getResultado().setTotalfinal(String.valueOf(ttotal)); 
                        
                        bentot.getResultado().setTotal(formato.format(Double.parseDouble(bentot.getResultado().getTotal())));
                        
                        bentot.getResultado().setSancionomision(formato.format(Double.parseDouble(bentot.getResultado().getSancionomision())));
                        bentot.getResultado().setContravdui(formato.format(Double.parseDouble(bentot.getResultado().getContravdui())));
                        bentot.getResultado().setContravorden(formato.format(Double.parseDouble(bentot.getResultado().getContravorden())));
                        
                        bentot.getResultado().setSancioncontrabando(formato.format(Double.parseDouble(bentot.getResultado().getSancioncontrabando())));
                        bentot.getResultado().setSanciondefraudacion(formato.format(Double.parseDouble(bentot.getResultado().getSanciondefraudacion())));
                        bentot.getResultado().setDelito(formato.format(Double.parseDouble(bentot.getResultado().getDelito())));
                        
                        bentot.getResultado().setTotalfinal(formato.format(Double.parseDouble(bentot.getResultado().getTotalfinal())));
                        
                        bean.setFechahoy(bentot.getResultado().getFechahoy());
                        request.getSession().setAttribute("tributosOm", ben.getResultado());
                        request.getSession().setAttribute("tributosOmtot", bentot.getResultado());
                        request.getSession().setAttribute("infoControl", inf.getResultado());
                    }
                    link = "okimp";
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
            request.getSession().setAttribute("TributosOmitidosForm", bean);
            return mapping.findForward(link);
        }
    }
    
    public ActionForward tributos(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {

        TributosOmitidosForm bean = new TributosOmitidosForm();
        bean = (TributosOmitidosForm)request.getAttribute("TributosOmitidosForm");
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
                    Respuesta<TributosOmitidos[]> ben = neg.devuelveTributosOmitidos(bean);
                    if (ben.getCodigo() == 1) {
                        request.setAttribute("hojaTrabajoDui", ben.getResultado());
                    }
                    link = "okimp";
                } 
                else {
                    if (res.getCodigo() == 0) {
                        request.setAttribute("WARNING", res.getMensaje());
                    } else {
                        request.setAttribute("ERROR", res.getMensaje());
                    }
                }
            }
            request.getSession().setAttribute("TributosOmitidosForm", bean);
            return mapping.findForward(link);
        }
    }
}