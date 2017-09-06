package anb.bean;

import org.apache.struts.action.ActionForm;

public class ConclusionControlForm extends ActionForm {
    private String cargo;
    private String funcionario;

    private String numeroInforme;
    private String fechaInforme;
    private String tipoDocCon;
    private String numDocCon;
    private String fechaDocCon;

    private String fmemorizado;
    private String fgestion;
    private String fcontrol;
    private String fgerencia;
    private String fnumero;

    private String usuarioger; 

    private String boton;
    private String opcion;
    private String opcion2;
    private String codigo;
    private String codger;
    private String usuario;
    
    private String cvc_numero_informe;
    private String cvc_fecha_informe;
    private String cvc_numero_vc;
    private String cvc_fecha_vc;   
    
    private String cvc_tipo_notificacion;
    private String cvc_fecha_notificacion;
    private String cvc_fecha_presentacion;
    private String cvc_inf_descargo;
    private String cvc_fecha_descargo;
    private String cvc_rd_final;
    private String cvc_fecha_not_rd_final;
    private String cvc_ci_remision;
    private String cvc_fecha_ci_remision;
    private String cvc_numero_rd;
    private String cvc_fecha_rd;

    private String cvc_tipo_rd;
    private String cvc_gerencia_legal;
    
    private String crd_numero_informe;
    private String crd_fecha_informe;

    private String crd_rd_final;
    private String crd_fecha_not_rd_final;


    private String cai_numero_informe;
    private String cai_fecha_informe;
    
    private String cai_acta_interv;
    private String cai_fecha_acta_interv;
    private String cai_tipo_ilicito;
    private String cai_ci_remision;
    private String cai_fecha_ci_remision;
    private String cai_fecha_pres_descargos;
    private String cai_inf_descargo;
    private String cai_fecha_inf_descargo;
    private String cai_numero_rfs;
    private String cai_fecha_rfs;
    private String cai_numero_rs;
    private String cai_fecha_rs;

    private String cai_gerencia_legal;
    private String cai_fecha_not_ai;
    private String cai_tipo_not_ai;
    
    private String cai_resultado_des;
    private String cai_tipo_resolucion;
    
    private String cra_numero_informe;
    private String cra_fecha_informe;
    
    private String cra_fecha_pago_cuini;
    private String cra_monto_pago_cuoini;
    private String cra_numero_ra;
    private String cra_fecha_ra;
    private String cra_ci_remision_set;
    private String cra_fecha_remision_set;
    private String cra_saldo_por_cobrar;
    
    private String cra_rup_gestion;
    private String cra_rup_aduana;
    private String cra_rup_numero;
    private String cra_gerencia_legal;

    private String cas_numero_informe;
    private String cas_fecha_informe;
    
    private String cas_numero_aisc;
    private String cas_fecha_notificacion;
    private String cas_fecha_pres_descargos;
    private String cas_inf_descargo;
    private String cas_fecha_inf_descargo;
    private String cas_numero_rfs;
    private String cas_fecha_rfs;
    private String cas_ci_remision_gr;
    private String cas_fecha_ci;
    private String cas_numero_rs;
    private String cas_fecha_rs;   
    
    private String cas_gerencia_legal;
    
    private String tipo_grabado;
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFmemorizado(String fmemorizado) {
        this.fmemorizado = fmemorizado;
    }

    public String getFmemorizado() {
        return fmemorizado;
    }

    public void setFgestion(String fgestion) {
        this.fgestion = fgestion;
    }

    public String getFgestion() {
        return fgestion;
    }

    public void setFcontrol(String fcontrol) {
        this.fcontrol = fcontrol;
    }

    public String getFcontrol() {
        return fcontrol;
    }

    public void setFgerencia(String fgerencia) {
        this.fgerencia = fgerencia;
    }

    public String getFgerencia() {
        return fgerencia;
    }

    public void setFnumero(String fnumero) {
        this.fnumero = fnumero;
    }

    public String getFnumero() {
        return fnumero;
    }

    public void setBoton(String boton) {
        this.boton = boton;
    }

    public String getBoton() {
        return boton;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodger(String codger) {
        this.codger = codger;
    }

    public String getCodger() {
        return codger;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setNumeroInforme(String numeroInforme) {
        this.numeroInforme = numeroInforme;
    }

    public String getNumeroInforme() {
        return numeroInforme;
    }

    public void setFechaInforme(String fechaInforme) {
        this.fechaInforme = fechaInforme;
    }

    public String getFechaInforme() {
        return fechaInforme;
    }

    public void setTipoDocCon(String tipoDocCon) {
        this.tipoDocCon = tipoDocCon;
    }

    public String getTipoDocCon() {
        return tipoDocCon;
    }

    public void setNumDocCon(String numDocCon) {
        this.numDocCon = numDocCon;
    }

    public String getNumDocCon() {
        return numDocCon;
    }

    public void setFechaDocCon(String fechaDocCon) {
        this.fechaDocCon = fechaDocCon;
    }

    public String getFechaDocCon() {
        return fechaDocCon;
    }

    public void setCvc_tipo_notificacion(String cvc_tipo_notificacion) {
        this.cvc_tipo_notificacion = cvc_tipo_notificacion;
    }

    public String getCvc_tipo_notificacion() {
        return cvc_tipo_notificacion;
    }

    public void setCvc_fecha_notificacion(String cvc_fecha_notificacion) {
        this.cvc_fecha_notificacion = cvc_fecha_notificacion;
    }

    public String getCvc_fecha_notificacion() {
        return cvc_fecha_notificacion;
    }

    public void setCvc_fecha_presentacion(String cvc_fecha_presentacion) {
        this.cvc_fecha_presentacion = cvc_fecha_presentacion;
    }

    public String getCvc_fecha_presentacion() {
        return cvc_fecha_presentacion;
    }

    public void setCvc_inf_descargo(String cvc_inf_descargo) {
        this.cvc_inf_descargo = cvc_inf_descargo;
    }

    public String getCvc_inf_descargo() {
        return cvc_inf_descargo;
    }

    public void setCvc_fecha_descargo(String cvc_fecha_descargo) {
        this.cvc_fecha_descargo = cvc_fecha_descargo;
    }

    public String getCvc_fecha_descargo() {
        return cvc_fecha_descargo;
    }

    public void setCvc_rd_final(String cvc_rd_final) {
        this.cvc_rd_final = cvc_rd_final;
    }

    public String getCvc_rd_final() {
        return cvc_rd_final;
    }

    public void setCvc_fecha_not_rd_final(String cvc_fecha_not_rd_final) {
        this.cvc_fecha_not_rd_final = cvc_fecha_not_rd_final;
    }

    public String getCvc_fecha_not_rd_final() {
        return cvc_fecha_not_rd_final;
    }

    public void setCvc_ci_remision(String cvc_ci_remision) {
        this.cvc_ci_remision = cvc_ci_remision;
    }

    public String getCvc_ci_remision() {
        return cvc_ci_remision;
    }

    public void setCvc_fecha_ci_remision(String cvc_fecha_ci_remision) {
        this.cvc_fecha_ci_remision = cvc_fecha_ci_remision;
    }

    public String getCvc_fecha_ci_remision() {
        return cvc_fecha_ci_remision;
    }

    public void setCvc_numero_rd(String cvc_numero_rd) {
        this.cvc_numero_rd = cvc_numero_rd;
    }

    public String getCvc_numero_rd() {
        return cvc_numero_rd;
    }

    public void setCvc_fecha_rd(String cvc_fecha_rd) {
        this.cvc_fecha_rd = cvc_fecha_rd;
    }

    public String getCvc_fecha_rd() {
        return cvc_fecha_rd;
    }

    public void setCrd_rd_final(String crd_rd_final) {
        this.crd_rd_final = crd_rd_final;
    }

    public String getCrd_rd_final() {
        return crd_rd_final;
    }

    public void setCrd_fecha_not_rd_final(String crd_fecha_not_rd_final) {
        this.crd_fecha_not_rd_final = crd_fecha_not_rd_final;
    }

    public String getCrd_fecha_not_rd_final() {
        return crd_fecha_not_rd_final;
    }

    public void setCai_acta_interv(String cai_acta_interv) {
        this.cai_acta_interv = cai_acta_interv;
    }

    public String getCai_acta_interv() {
        return cai_acta_interv;
    }

    public void setCai_fecha_acta_interv(String cai_fecha_acta_interv) {
        this.cai_fecha_acta_interv = cai_fecha_acta_interv;
    }

    public String getCai_fecha_acta_interv() {
        return cai_fecha_acta_interv;
    }

    public void setCai_tipo_ilicito(String cai_tipo_ilicito) {
        this.cai_tipo_ilicito = cai_tipo_ilicito;
    }

    public String getCai_tipo_ilicito() {
        return cai_tipo_ilicito;
    }

    public void setCai_ci_remision(String cai_ci_remision) {
        this.cai_ci_remision = cai_ci_remision;
    }

    public String getCai_ci_remision() {
        return cai_ci_remision;
    }

    public void setCai_fecha_ci_remision(String cai_fecha_ci_remision) {
        this.cai_fecha_ci_remision = cai_fecha_ci_remision;
    }

    public String getCai_fecha_ci_remision() {
        return cai_fecha_ci_remision;
    }

    public void setCai_fecha_pres_descargos(String cai_fecha_pres_descargos) {
        this.cai_fecha_pres_descargos = cai_fecha_pres_descargos;
    }

    public String getCai_fecha_pres_descargos() {
        return cai_fecha_pres_descargos;
    }

    public void setCai_inf_descargo(String cai_inf_descargo) {
        this.cai_inf_descargo = cai_inf_descargo;
    }

    public String getCai_inf_descargo() {
        return cai_inf_descargo;
    }

    public void setCai_fecha_inf_descargo(String cai_fecha_inf_descargo) {
        this.cai_fecha_inf_descargo = cai_fecha_inf_descargo;
    }

    public String getCai_fecha_inf_descargo() {
        return cai_fecha_inf_descargo;
    }

    public void setCai_numero_rfs(String cai_numero_rfs) {
        this.cai_numero_rfs = cai_numero_rfs;
    }

    public String getCai_numero_rfs() {
        return cai_numero_rfs;
    }

    public void setCai_fecha_rfs(String cai_fecha_rfs) {
        this.cai_fecha_rfs = cai_fecha_rfs;
    }

    public String getCai_fecha_rfs() {
        return cai_fecha_rfs;
    }

    public void setCai_numero_rs(String cai_numero_rs) {
        this.cai_numero_rs = cai_numero_rs;
    }

    public String getCai_numero_rs() {
        return cai_numero_rs;
    }

    public void setCai_fecha_rs(String cai_fecha_rs) {
        this.cai_fecha_rs = cai_fecha_rs;
    }

    public String getCai_fecha_rs() {
        return cai_fecha_rs;
    }

    public void setCra_fecha_pago_cuini(String cra_fecha_pago_cuini) {
        this.cra_fecha_pago_cuini = cra_fecha_pago_cuini;
    }

    public String getCra_fecha_pago_cuini() {
        return cra_fecha_pago_cuini;
    }

    public void setCra_monto_pago_cuoini(String cra_monto_pago_cuoini) {
        this.cra_monto_pago_cuoini = cra_monto_pago_cuoini;
    }

    public String getCra_monto_pago_cuoini() {
        return cra_monto_pago_cuoini;
    }

    public void setCra_numero_ra(String cra_numero_ra) {
        this.cra_numero_ra = cra_numero_ra;
    }

    public String getCra_numero_ra() {
        return cra_numero_ra;
    }

    public void setCra_fecha_ra(String cra_fecha_ra) {
        this.cra_fecha_ra = cra_fecha_ra;
    }

    public String getCra_fecha_ra() {
        return cra_fecha_ra;
    }

    public void setCra_ci_remision_set(String cra_ci_remision_set) {
        this.cra_ci_remision_set = cra_ci_remision_set;
    }

    public String getCra_ci_remision_set() {
        return cra_ci_remision_set;
    }

    public void setCra_fecha_remision_set(String cra_fecha_remision_set) {
        this.cra_fecha_remision_set = cra_fecha_remision_set;
    }

    public String getCra_fecha_remision_set() {
        return cra_fecha_remision_set;
    }

    public void setCra_saldo_por_cobrar(String cra_saldo_por_cobrar) {
        this.cra_saldo_por_cobrar = cra_saldo_por_cobrar;
    }

    public String getCra_saldo_por_cobrar() {
        return cra_saldo_por_cobrar;
    }

    public void setCas_numero_aisc(String cas_numero_aisc) {
        this.cas_numero_aisc = cas_numero_aisc;
    }

    public String getCas_numero_aisc() {
        return cas_numero_aisc;
    }

    public void setCas_fecha_notificacion(String cas_fecha_notificacion) {
        this.cas_fecha_notificacion = cas_fecha_notificacion;
    }

    public String getCas_fecha_notificacion() {
        return cas_fecha_notificacion;
    }

    public void setCas_fecha_pres_descargos(String cas_fecha_pres_descargos) {
        this.cas_fecha_pres_descargos = cas_fecha_pres_descargos;
    }

    public String getCas_fecha_pres_descargos() {
        return cas_fecha_pres_descargos;
    }

    public void setCas_inf_descargo(String cas_inf_descargo) {
        this.cas_inf_descargo = cas_inf_descargo;
    }

    public String getCas_inf_descargo() {
        return cas_inf_descargo;
    }

    public void setCas_fecha_inf_descargo(String cas_fecha_inf_descargo) {
        this.cas_fecha_inf_descargo = cas_fecha_inf_descargo;
    }

    public String getCas_fecha_inf_descargo() {
        return cas_fecha_inf_descargo;
    }

    public void setCas_numero_rfs(String cas_numero_rfs) {
        this.cas_numero_rfs = cas_numero_rfs;
    }

    public String getCas_numero_rfs() {
        return cas_numero_rfs;
    }

    public void setCas_fecha_rfs(String cas_fecha_rfs) {
        this.cas_fecha_rfs = cas_fecha_rfs;
    }

    public String getCas_fecha_rfs() {
        return cas_fecha_rfs;
    }

    public void setCas_ci_remision_gr(String cas_ci_remision_gr) {
        this.cas_ci_remision_gr = cas_ci_remision_gr;
    }

    public String getCas_ci_remision_gr() {
        return cas_ci_remision_gr;
    }

    public void setCas_fecha_ci(String cas_fecha_ci) {
        this.cas_fecha_ci = cas_fecha_ci;
    }

    public String getCas_fecha_ci() {
        return cas_fecha_ci;
    }

    public void setCas_numero_rs(String cas_numero_rs) {
        this.cas_numero_rs = cas_numero_rs;
    }

    public String getCas_numero_rs() {
        return cas_numero_rs;
    }

    public void setCas_fecha_rs(String cas_fecha_rs) {
        this.cas_fecha_rs = cas_fecha_rs;
    }

    public String getCas_fecha_rs() {
        return cas_fecha_rs;
    }

    public void setCvc_numero_informe(String cvc_numero_informe) {
        this.cvc_numero_informe = cvc_numero_informe;
    }

    public String getCvc_numero_informe() {
        return cvc_numero_informe;
    }

    public void setCvc_fecha_informe(String cvc_fecha_informe) {
        this.cvc_fecha_informe = cvc_fecha_informe;
    }

    public String getCvc_fecha_informe() {
        return cvc_fecha_informe;
    }

    public void setCvc_numero_vc(String cvc_numero_vc) {
        this.cvc_numero_vc = cvc_numero_vc;
    }

    public String getCvc_numero_vc() {
        return cvc_numero_vc;
    }

    public void setCvc_fecha_vc(String cvc_fecha_vc) {
        this.cvc_fecha_vc = cvc_fecha_vc;
    }

    public String getCvc_fecha_vc() {
        return cvc_fecha_vc;
    }

    public void setCrd_numero_informe(String crd_numero_informe) {
        this.crd_numero_informe = crd_numero_informe;
    }

    public String getCrd_numero_informe() {
        return crd_numero_informe;
    }

    public void setCrd_fecha_informe(String crd_fecha_informe) {
        this.crd_fecha_informe = crd_fecha_informe;
    }

    public String getCrd_fecha_informe() {
        return crd_fecha_informe;
    }

    public void setCai_numero_informe(String cai_numero_informe) {
        this.cai_numero_informe = cai_numero_informe;
    }

    public String getCai_numero_informe() {
        return cai_numero_informe;
    }

    public void setCai_fecha_informe(String cai_fecha_informe) {
        this.cai_fecha_informe = cai_fecha_informe;
    }

    public String getCai_fecha_informe() {
        return cai_fecha_informe;
    }

    public void setCra_numero_informe(String cra_numero_informe) {
        this.cra_numero_informe = cra_numero_informe;
    }

    public String getCra_numero_informe() {
        return cra_numero_informe;
    }

    public void setCra_fecha_informe(String cra_fecha_informe) {
        this.cra_fecha_informe = cra_fecha_informe;
    }

    public String getCra_fecha_informe() {
        return cra_fecha_informe;
    }

    public void setCas_numero_informe(String cas_numero_informe) {
        this.cas_numero_informe = cas_numero_informe;
    }

    public String getCas_numero_informe() {
        return cas_numero_informe;
    }

    public void setCas_fecha_informe(String cas_fecha_informe) {
        this.cas_fecha_informe = cas_fecha_informe;
    }

    public String getCas_fecha_informe() {
        return cas_fecha_informe;
    }

    public void setCvc_tipo_rd(String cvc_tipo_rd) {
        this.cvc_tipo_rd = cvc_tipo_rd;
    }

    public String getCvc_tipo_rd() {
        return cvc_tipo_rd;
    }

    public void setCvc_gerencia_legal(String cvc_gerencia_legal) {
        this.cvc_gerencia_legal = cvc_gerencia_legal;
    }

    public String getCvc_gerencia_legal() {
        return cvc_gerencia_legal;
    }

    public void setCai_gerencia_legal(String cai_gerencia_legal) {
        this.cai_gerencia_legal = cai_gerencia_legal;
    }

    public String getCai_gerencia_legal() {
        return cai_gerencia_legal;
    }

    public void setCai_fecha_not_ai(String cai_fecha_not_ai) {
        this.cai_fecha_not_ai = cai_fecha_not_ai;
    }

    public String getCai_fecha_not_ai() {
        return cai_fecha_not_ai;
    }

    public void setCai_tipo_not_ai(String cai_tipo_not_ai) {
        this.cai_tipo_not_ai = cai_tipo_not_ai;
    }

    public String getCai_tipo_not_ai() {
        return cai_tipo_not_ai;
    }

    public void setCai_resultado_des(String cai_resultado_des) {
        this.cai_resultado_des = cai_resultado_des;
    }

    public String getCai_resultado_des() {
        return cai_resultado_des;
    }

    public void setCai_tipo_resolucion(String cai_tipo_resolucion) {
        this.cai_tipo_resolucion = cai_tipo_resolucion;
    }

    public String getCai_tipo_resolucion() {
        return cai_tipo_resolucion;
    }

    public void setCra_rup_gestion(String cra_rup_gestion) {
        this.cra_rup_gestion = cra_rup_gestion;
    }

    public String getCra_rup_gestion() {
        return cra_rup_gestion;
    }

    public void setCra_rup_aduana(String cra_rup_aduana) {
        this.cra_rup_aduana = cra_rup_aduana;
    }

    public String getCra_rup_aduana() {
        return cra_rup_aduana;
    }

    public void setCra_rup_numero(String cra_rup_numero) {
        this.cra_rup_numero = cra_rup_numero;
    }

    public String getCra_rup_numero() {
        return cra_rup_numero;
    }

    public void setCra_gerencia_legal(String cra_gerencia_legal) {
        this.cra_gerencia_legal = cra_gerencia_legal;
    }

    public String getCra_gerencia_legal() {
        return cra_gerencia_legal;
    }

    public void setCas_gerencia_legal(String cas_gerencia_legal) {
        this.cas_gerencia_legal = cas_gerencia_legal;
    }

    public String getCas_gerencia_legal() {
        return cas_gerencia_legal;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setTipo_grabado(String tipo_grabado) {
        this.tipo_grabado = tipo_grabado;
    }

    public String getTipo_grabado() {
        return tipo_grabado;
    }

    public void setUsuarioger(String usuarioger) {
        this.usuarioger = usuarioger;
    }

    public String getUsuarioger() {
        return usuarioger;
    }
}
