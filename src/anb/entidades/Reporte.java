package anb.entidades;

public class Reporte {    
    private String  secuencia;
    private String  sequencia;
    private String  orden_gestion;
    private String  orden_tipo_control;
    private String  orden_gerencia;
    private String  orden_numero;
    private String  orden_codigo;
    private String  orden_fecha;
    private String  orden_origen;
    private String  operador_numero_doc;
    private String  operador_nombre;
    private String  fiscalizador_asignado;
    private String  fiscalizador_nuevo;
    private String  supervisor_asignado;
    private String  supervisor_nuevo;
    private String  orden_ampliatoria_codigo;
    private String  orden_ampliatoria_fecha;
    private String  orden_ampliatoria_ope_num;
    private String  orden_ampliatoria_ope_nom;
    private String  notificacion_fecha;
    private String  notificacion_observacion;
    private String  notificacion_tipo;
    private String  notificacion_usuario;
    private String  dui_aduana;
    private String  dui_codigo;
    private String  dui_fecha;
    private String  dui_item;
    private String  dui_partida;
    private String  dui_descripcion;
    private String  dui_patron;
    private String  dui_canal;
    private String  dui_fecha_pase;
    private String  dui_importador_numero;
    private String  dui_importador_nombre;
    private String  dui_declarante_numero;
    private String  dui_declarante_nombre;
    private String  dui_proveedor_direccion;
    private String  dui_proveedor_nombre;
    private String  dui_localizacion;
    private String  dui_origen;
    private String  dui_procedencia_pais;
    private String  dui_embarque_pais;
    private String  dui_peso_bruto;
    private String  dui_peso_neto;
    private String  dui_declarado_fob;
    private String  dui_declarado_flete;
    private String  dui_declarado_seguro;
    private String  dui_declarado_otros;
    private String  dui_declarado_cif_sus;
    private String  dui_declarado_cif_bs;
    private String  dui_declarado_ga_bs;
    private String  dui_declarado_iva_bs;
    private String  dui_declarado_ice_bs;
    private String  dui_declarado_iehd_bs;
    private String  dui_declarado_icd_bs;
    private String  dui_declarado_tributos_bs;
    private String  res_informe_numero;
    private String  res_informe_fecha;
    private String  res_gerencia_ulegal;
    private String  res_documento_tipo;
    private String  res_documento_numero;
    private String  res_documento_fecha;
    private String  res_documento_usuario;
    private String  res_notificacion_fecha;
    private String  res_notificacion_tipo;
    private String  res_notificacion_usuario;
    private String  res_ci_remision_fecha;
    private String  res_ci_remision_numero;
    private String  res_ci_remision_usuario;
    private String  res_finalizacion_fecha;
    private String  res_finalizacion_usuario;
    private String  det_fob_sus;
    private String  det_flete_sus;
    private String  det_seguro_sus;
    private String  det_otros_sus;
    private String  det_cif_sus;
    private String  det_cif_bs;
    private String  to_ga;
    private String  to_iva;
    private String  to_ice;
    private String  to_iehd;
    private String  to_icd;
    private String  to_total;
    private String  adeudo_det_trib_total;
    private String  adeudo_det_sancion;
    private String  adeudo_det_multa_contrav_dui;
    private String  adeudo_det_multa_contrav_orden;
    private String  adeudo_det_multa_contrab_contrav;
    private String  adeudo_det_multa_contrab_delito;
    private String  adeudo_det_multa_otros;
    private String  adeudo_det_total;
    private String  adeudo_det_fecha_liq;
    private String  adeudo_det_fecha_liq_ufv;
    private String  orden_estado;
    private String  ilicito_omision_pago;
    private String  ilicito_contravencion_aduanera;
    private String  ilicito_contrabando_contrav;
    private String  ilicito_contrabando_delito;
    private String  ilicito_defraudacion;
    private String  ilicito_otros;
    private String  orden_conclusion_fecha_est;
    private String  recuperado_trib_ga;
    private String  recuperado_trib_iva;
    private String  recuperado_trib_ice;
    private String  recuperado_trib_iehd;
    private String  recuperado_trib_icd;
    private String  recuperado_trib_total;
    private String  recuperado_sancion;
    private String  recuperado_multa_contrav;
    private String  recuperado_multa_contravorden;
    private String  recuperado_multa_contrab;
    private String  recuperado_multa_contrab_delito;
    private String  recuperado_multa_defraudacion;
    private String  recuperado_total_recuperado;
    private String  facilidades_cuota_inicial;
    private String  facilidades_garantia;
    private String  facilidades_saldo;
    private String  facilidades_usuario;

    public void setOrden_gestion(String orden_gestion) {
        this.orden_gestion = orden_gestion;
    }

    public String getOrden_gestion() {
        return orden_gestion;
    }

    public void setOrden_tipo_control(String orden_tipo_control) {
        this.orden_tipo_control = orden_tipo_control;
    }

    public String getOrden_tipo_control() {
        return orden_tipo_control;
    }

    public void setOrden_gerencia(String orden_gerencia) {
        this.orden_gerencia = orden_gerencia;
    }

    public String getOrden_gerencia() {
        return orden_gerencia;
    }

    public void setOrden_numero(String orden_numero) {
        this.orden_numero = orden_numero;
    }

    public String getOrden_numero() {
        return orden_numero;
    }

    public void setOrden_codigo(String orden_codigo) {
        this.orden_codigo = orden_codigo;
    }

    public String getOrden_codigo() {
        return orden_codigo;
    }

    public void setOrden_fecha(String orden_fecha) {
        this.orden_fecha = orden_fecha;
    }

    public String getOrden_fecha() {
        return orden_fecha;
    }

    public void setOrden_origen(String orden_origen) {
        this.orden_origen = orden_origen;
    }

    public String getOrden_origen() {
        return orden_origen;
    }

    public void setOperador_numero_doc(String operador_numero_doc) {
        this.operador_numero_doc = operador_numero_doc;
    }

    public String getOperador_numero_doc() {
        return operador_numero_doc;
    }

    public void setOperador_nombre(String operador_nombre) {
        this.operador_nombre = operador_nombre;
    }

    public String getOperador_nombre() {
        return operador_nombre;
    }

    public void setFiscalizador_asignado(String fiscalizador_asignado) {
        this.fiscalizador_asignado = fiscalizador_asignado;
    }

    public String getFiscalizador_asignado() {
        return fiscalizador_asignado;
    }

    public void setFiscalizador_nuevo(String fiscalizador_nuevo) {
        this.fiscalizador_nuevo = fiscalizador_nuevo;
    }

    public String getFiscalizador_nuevo() {
        return fiscalizador_nuevo;
    }

    public void setSupervisor_asignado(String supervisor_asignado) {
        this.supervisor_asignado = supervisor_asignado;
    }

    public String getSupervisor_asignado() {
        return supervisor_asignado;
    }

    public void setSupervisor_nuevo(String supervisor_nuevo) {
        this.supervisor_nuevo = supervisor_nuevo;
    }

    public String getSupervisor_nuevo() {
        return supervisor_nuevo;
    }

    public void setOrden_ampliatoria_codigo(String orden_ampliatoria_codigo) {
        this.orden_ampliatoria_codigo = orden_ampliatoria_codigo;
    }

    public String getOrden_ampliatoria_codigo() {
        return orden_ampliatoria_codigo;
    }

    public void setOrden_ampliatoria_fecha(String orden_ampliatoria_fecha) {
        this.orden_ampliatoria_fecha = orden_ampliatoria_fecha;
    }

    public String getOrden_ampliatoria_fecha() {
        return orden_ampliatoria_fecha;
    }

    public void setOrden_ampliatoria_ope_num(String orden_ampliatoria_ope_num) {
        this.orden_ampliatoria_ope_num = orden_ampliatoria_ope_num;
    }

    public String getOrden_ampliatoria_ope_num() {
        return orden_ampliatoria_ope_num;
    }

    public void setOrden_ampliatoria_ope_nom(String orden_ampliatoria_ope_nom) {
        this.orden_ampliatoria_ope_nom = orden_ampliatoria_ope_nom;
    }

    public String getOrden_ampliatoria_ope_nom() {
        return orden_ampliatoria_ope_nom;
    }

    public void setNotificacion_fecha(String notificacion_fecha) {
        this.notificacion_fecha = notificacion_fecha;
    }

    public String getNotificacion_fecha() {
        return notificacion_fecha;
    }

    public void setNotificacion_observacion(String notificacion_observacion) {
        this.notificacion_observacion = notificacion_observacion;
    }

    public String getNotificacion_observacion() {
        return notificacion_observacion;
    }

    public void setNotificacion_tipo(String notificacion_tipo) {
        this.notificacion_tipo = notificacion_tipo;
    }

    public String getNotificacion_tipo() {
        return notificacion_tipo;
    }

    public void setNotificacion_usuario(String notificacion_usuario) {
        this.notificacion_usuario = notificacion_usuario;
    }

    public String getNotificacion_usuario() {
        return notificacion_usuario;
    }

    public void setDui_aduana(String dui_aduana) {
        this.dui_aduana = dui_aduana;
    }

    public String getDui_aduana() {
        return dui_aduana;
    }

    public void setDui_codigo(String dui_codigo) {
        this.dui_codigo = dui_codigo;
    }

    public String getDui_codigo() {
        return dui_codigo;
    }

    public void setDui_fecha(String dui_fecha) {
        this.dui_fecha = dui_fecha;
    }

    public String getDui_fecha() {
        return dui_fecha;
    }

    public void setDui_item(String dui_item) {
        this.dui_item = dui_item;
    }

    public String getDui_item() {
        return dui_item;
    }

    public void setDui_partida(String dui_partida) {
        this.dui_partida = dui_partida;
    }

    public String getDui_partida() {
        return dui_partida;
    }

    public void setDui_descripcion(String dui_descripcion) {
        this.dui_descripcion = dui_descripcion;
    }

    public String getDui_descripcion() {
        return dui_descripcion;
    }

    public void setDui_patron(String dui_patron) {
        this.dui_patron = dui_patron;
    }

    public String getDui_patron() {
        return dui_patron;
    }

    public void setDui_canal(String dui_canal) {
        this.dui_canal = dui_canal;
    }

    public String getDui_canal() {
        return dui_canal;
    }

    public void setDui_fecha_pase(String dui_fecha_pase) {
        this.dui_fecha_pase = dui_fecha_pase;
    }

    public String getDui_fecha_pase() {
        return dui_fecha_pase;
    }

    public void setDui_importador_numero(String dui_importador_numero) {
        this.dui_importador_numero = dui_importador_numero;
    }

    public String getDui_importador_numero() {
        return dui_importador_numero;
    }

    public void setDui_importador_nombre(String dui_importador_nombre) {
        this.dui_importador_nombre = dui_importador_nombre;
    }

    public String getDui_importador_nombre() {
        return dui_importador_nombre;
    }

    public void setDui_declarante_numero(String dui_declarante_numero) {
        this.dui_declarante_numero = dui_declarante_numero;
    }

    public String getDui_declarante_numero() {
        return dui_declarante_numero;
    }

    public void setDui_declarante_nombre(String dui_declarante_nombre) {
        this.dui_declarante_nombre = dui_declarante_nombre;
    }

    public String getDui_declarante_nombre() {
        return dui_declarante_nombre;
    }

    public void setDui_proveedor_direccion(String dui_proveedor_direccion) {
        this.dui_proveedor_direccion = dui_proveedor_direccion;
    }

    public String getDui_proveedor_direccion() {
        return dui_proveedor_direccion;
    }

    public void setDui_proveedor_nombre(String dui_proveedor_nombre) {
        this.dui_proveedor_nombre = dui_proveedor_nombre;
    }

    public String getDui_proveedor_nombre() {
        return dui_proveedor_nombre;
    }

    public void setDui_localizacion(String dui_localizacion) {
        this.dui_localizacion = dui_localizacion;
    }

    public String getDui_localizacion() {
        return dui_localizacion;
    }

    public void setDui_origen(String dui_origen) {
        this.dui_origen = dui_origen;
    }

    public String getDui_origen() {
        return dui_origen;
    }

    public void setDui_procedencia_pais(String dui_procedencia_pais) {
        this.dui_procedencia_pais = dui_procedencia_pais;
    }

    public String getDui_procedencia_pais() {
        return dui_procedencia_pais;
    }

    public void setDui_embarque_pais(String dui_embarque_pais) {
        this.dui_embarque_pais = dui_embarque_pais;
    }

    public String getDui_embarque_pais() {
        return dui_embarque_pais;
    }

    public void setDui_peso_bruto(String dui_peso_bruto) {
        this.dui_peso_bruto = dui_peso_bruto;
    }

    public String getDui_peso_bruto() {
        return dui_peso_bruto;
    }

    public void setDui_peso_neto(String dui_peso_neto) {
        this.dui_peso_neto = dui_peso_neto;
    }

    public String getDui_peso_neto() {
        return dui_peso_neto;
    }

    public void setDui_declarado_fob(String dui_declarado_fob) {
        this.dui_declarado_fob = dui_declarado_fob;
    }

    public String getDui_declarado_fob() {
        return dui_declarado_fob;
    }

    public void setDui_declarado_flete(String dui_declarado_flete) {
        this.dui_declarado_flete = dui_declarado_flete;
    }

    public String getDui_declarado_flete() {
        return dui_declarado_flete;
    }

    public void setDui_declarado_seguro(String dui_declarado_seguro) {
        this.dui_declarado_seguro = dui_declarado_seguro;
    }

    public String getDui_declarado_seguro() {
        return dui_declarado_seguro;
    }

    public void setDui_declarado_otros(String dui_declarado_otros) {
        this.dui_declarado_otros = dui_declarado_otros;
    }

    public String getDui_declarado_otros() {
        return dui_declarado_otros;
    }

    public void setDui_declarado_cif_sus(String dui_declarado_cif_sus) {
        this.dui_declarado_cif_sus = dui_declarado_cif_sus;
    }

    public String getDui_declarado_cif_sus() {
        return dui_declarado_cif_sus;
    }

    public void setDui_declarado_cif_bs(String dui_declarado_cif_bs) {
        this.dui_declarado_cif_bs = dui_declarado_cif_bs;
    }

    public String getDui_declarado_cif_bs() {
        return dui_declarado_cif_bs;
    }

    public void setDui_declarado_ga_bs(String dui_declarado_ga_bs) {
        this.dui_declarado_ga_bs = dui_declarado_ga_bs;
    }

    public String getDui_declarado_ga_bs() {
        return dui_declarado_ga_bs;
    }

    public void setDui_declarado_iva_bs(String dui_declarado_iva_bs) {
        this.dui_declarado_iva_bs = dui_declarado_iva_bs;
    }

    public String getDui_declarado_iva_bs() {
        return dui_declarado_iva_bs;
    }

    public void setDui_declarado_ice_bs(String dui_declarado_ice_bs) {
        this.dui_declarado_ice_bs = dui_declarado_ice_bs;
    }

    public String getDui_declarado_ice_bs() {
        return dui_declarado_ice_bs;
    }

    public void setDui_declarado_iehd_bs(String dui_declarado_iehd_bs) {
        this.dui_declarado_iehd_bs = dui_declarado_iehd_bs;
    }

    public String getDui_declarado_iehd_bs() {
        return dui_declarado_iehd_bs;
    }

    public void setDui_declarado_icd_bs(String dui_declarado_icd_bs) {
        this.dui_declarado_icd_bs = dui_declarado_icd_bs;
    }

    public String getDui_declarado_icd_bs() {
        return dui_declarado_icd_bs;
    }

    public void setDui_declarado_tributos_bs(String dui_declarado_tributos_bs) {
        this.dui_declarado_tributos_bs = dui_declarado_tributos_bs;
    }

    public String getDui_declarado_tributos_bs() {
        return dui_declarado_tributos_bs;
    }

    public void setRes_informe_numero(String res_informe_numero) {
        this.res_informe_numero = res_informe_numero;
    }

    public String getRes_informe_numero() {
        return res_informe_numero;
    }

    public void setRes_informe_fecha(String res_informe_fecha) {
        this.res_informe_fecha = res_informe_fecha;
    }

    public String getRes_informe_fecha() {
        return res_informe_fecha;
    }

    public void setRes_gerencia_ulegal(String res_gerencia_ulegal) {
        this.res_gerencia_ulegal = res_gerencia_ulegal;
    }

    public String getRes_gerencia_ulegal() {
        return res_gerencia_ulegal;
    }

    public void setRes_documento_tipo(String res_documento_tipo) {
        this.res_documento_tipo = res_documento_tipo;
    }

    public String getRes_documento_tipo() {
        return res_documento_tipo;
    }

    public void setRes_documento_numero(String res_documento_numero) {
        this.res_documento_numero = res_documento_numero;
    }

    public String getRes_documento_numero() {
        return res_documento_numero;
    }

    public void setRes_documento_fecha(String res_documento_fecha) {
        this.res_documento_fecha = res_documento_fecha;
    }

    public String getRes_documento_fecha() {
        return res_documento_fecha;
    }

    public void setRes_documento_usuario(String res_documento_usuario) {
        this.res_documento_usuario = res_documento_usuario;
    }

    public String getRes_documento_usuario() {
        return res_documento_usuario;
    }

    public void setRes_notificacion_fecha(String res_notificacion_fecha) {
        this.res_notificacion_fecha = res_notificacion_fecha;
    }

    public String getRes_notificacion_fecha() {
        return res_notificacion_fecha;
    }

    public void setRes_notificacion_tipo(String res_notificacion_tipo) {
        this.res_notificacion_tipo = res_notificacion_tipo;
    }

    public String getRes_notificacion_tipo() {
        return res_notificacion_tipo;
    }

    public void setRes_notificacion_usuario(String res_notificacion_usuario) {
        this.res_notificacion_usuario = res_notificacion_usuario;
    }

    public String getRes_notificacion_usuario() {
        return res_notificacion_usuario;
    }

    public void setRes_ci_remision_fecha(String res_ci_remision_fecha) {
        this.res_ci_remision_fecha = res_ci_remision_fecha;
    }

    public String getRes_ci_remision_fecha() {
        return res_ci_remision_fecha;
    }

    public void setRes_ci_remision_numero(String res_ci_remision_numero) {
        this.res_ci_remision_numero = res_ci_remision_numero;
    }

    public String getRes_ci_remision_numero() {
        return res_ci_remision_numero;
    }

    public void setRes_ci_remision_usuario(String res_ci_remision_usuario) {
        this.res_ci_remision_usuario = res_ci_remision_usuario;
    }

    public String getRes_ci_remision_usuario() {
        return res_ci_remision_usuario;
    }

    public void setRes_finalizacion_fecha(String res_finalizacion_fecha) {
        this.res_finalizacion_fecha = res_finalizacion_fecha;
    }

    public String getRes_finalizacion_fecha() {
        return res_finalizacion_fecha;
    }

    public void setRes_finalizacion_usuario(String res_finalizacion_usuario) {
        this.res_finalizacion_usuario = res_finalizacion_usuario;
    }

    public String getRes_finalizacion_usuario() {
        return res_finalizacion_usuario;
    }

    public void setDet_fob_sus(String det_fob_sus) {
        this.det_fob_sus = det_fob_sus;
    }

    public String getDet_fob_sus() {
        return det_fob_sus;
    }

    public void setDet_flete_sus(String det_flete_sus) {
        this.det_flete_sus = det_flete_sus;
    }

    public String getDet_flete_sus() {
        return det_flete_sus;
    }

    public void setDet_seguro_sus(String det_seguro_sus) {
        this.det_seguro_sus = det_seguro_sus;
    }

    public String getDet_seguro_sus() {
        return det_seguro_sus;
    }

    public void setDet_otros_sus(String det_otros_sus) {
        this.det_otros_sus = det_otros_sus;
    }

    public String getDet_otros_sus() {
        return det_otros_sus;
    }

    public void setDet_cif_sus(String det_cif_sus) {
        this.det_cif_sus = det_cif_sus;
    }

    public String getDet_cif_sus() {
        return det_cif_sus;
    }

    public void setDet_cif_bs(String det_cif_bs) {
        this.det_cif_bs = det_cif_bs;
    }

    public String getDet_cif_bs() {
        return det_cif_bs;
    }

    public void setTo_ga(String to_ga) {
        this.to_ga = to_ga;
    }

    public String getTo_ga() {
        return to_ga;
    }

    public void setTo_iva(String to_iva) {
        this.to_iva = to_iva;
    }

    public String getTo_iva() {
        return to_iva;
    }

    public void setTo_ice(String to_ice) {
        this.to_ice = to_ice;
    }

    public String getTo_ice() {
        return to_ice;
    }

    public void setTo_iehd(String to_iehd) {
        this.to_iehd = to_iehd;
    }

    public String getTo_iehd() {
        return to_iehd;
    }

    public void setTo_total(String to_total) {
        this.to_total = to_total;
    }

    public String getTo_total() {
        return to_total;
    }

    public void setAdeudo_det_trib_total(String adeudo_det_trib_total) {
        this.adeudo_det_trib_total = adeudo_det_trib_total;
    }

    public String getAdeudo_det_trib_total() {
        return adeudo_det_trib_total;
    }

    public void setAdeudo_det_sancion(String adeudo_det_sancion) {
        this.adeudo_det_sancion = adeudo_det_sancion;
    }

    public String getAdeudo_det_sancion() {
        return adeudo_det_sancion;
    }

    public void setAdeudo_det_multa_contrav_dui(String adeudo_det_multa_contrav_dui) {
        this.adeudo_det_multa_contrav_dui = adeudo_det_multa_contrav_dui;
    }

    public String getAdeudo_det_multa_contrav_dui() {
        return adeudo_det_multa_contrav_dui;
    }

    public void setAdeudo_det_multa_contrav_orden(String adeudo_det_multa_contrav_orden) {
        this.adeudo_det_multa_contrav_orden = adeudo_det_multa_contrav_orden;
    }

    public String getAdeudo_det_multa_contrav_orden() {
        return adeudo_det_multa_contrav_orden;
    }

    public void setAdeudo_det_multa_contrab_contrav(String adeudo_det_multa_contrab_contrav) {
        this.adeudo_det_multa_contrab_contrav = adeudo_det_multa_contrab_contrav;
    }

    public String getAdeudo_det_multa_contrab_contrav() {
        return adeudo_det_multa_contrab_contrav;
    }

    public void setAdeudo_det_multa_contrab_delito(String adeudo_det_multa_contrab_delito) {
        this.adeudo_det_multa_contrab_delito = adeudo_det_multa_contrab_delito;
    }

    public String getAdeudo_det_multa_contrab_delito() {
        return adeudo_det_multa_contrab_delito;
    }

    public void setAdeudo_det_multa_otros(String adeudo_det_multa_otros) {
        this.adeudo_det_multa_otros = adeudo_det_multa_otros;
    }

    public String getAdeudo_det_multa_otros() {
        return adeudo_det_multa_otros;
    }

    public void setAdeudo_det_total(String adeudo_det_total) {
        this.adeudo_det_total = adeudo_det_total;
    }

    public String getAdeudo_det_total() {
        return adeudo_det_total;
    }

    public void setAdeudo_det_fecha_liq(String adeudo_det_fecha_liq) {
        this.adeudo_det_fecha_liq = adeudo_det_fecha_liq;
    }

    public String getAdeudo_det_fecha_liq() {
        return adeudo_det_fecha_liq;
    }

    public void setAdeudo_det_fecha_liq_ufv(String adeudo_det_fecha_liq_ufv) {
        this.adeudo_det_fecha_liq_ufv = adeudo_det_fecha_liq_ufv;
    }

    public String getAdeudo_det_fecha_liq_ufv() {
        return adeudo_det_fecha_liq_ufv;
    }

    public void setOrden_estado(String orden_estado) {
        this.orden_estado = orden_estado;
    }

    public String getOrden_estado() {
        return orden_estado;
    }

    public void setIlicito_omision_pago(String ilicito_omision_pago) {
        this.ilicito_omision_pago = ilicito_omision_pago;
    }

    public String getIlicito_omision_pago() {
        return ilicito_omision_pago;
    }

    public void setIlicito_contravencion_aduanera(String ilicito_contravencion_aduanera) {
        this.ilicito_contravencion_aduanera = ilicito_contravencion_aduanera;
    }

    public String getIlicito_contravencion_aduanera() {
        return ilicito_contravencion_aduanera;
    }

    public void setIlicito_contrabando_contrav(String ilicito_contrabando_contrav) {
        this.ilicito_contrabando_contrav = ilicito_contrabando_contrav;
    }

    public String getIlicito_contrabando_contrav() {
        return ilicito_contrabando_contrav;
    }

    public void setIlicito_contrabando_delito(String ilicito_contrabando_delito) {
        this.ilicito_contrabando_delito = ilicito_contrabando_delito;
    }

    public String getIlicito_contrabando_delito() {
        return ilicito_contrabando_delito;
    }

    public void setIlicito_defraudacion(String ilicito_defraudacion) {
        this.ilicito_defraudacion = ilicito_defraudacion;
    }

    public String getIlicito_defraudacion() {
        return ilicito_defraudacion;
    }

    public void setIlicito_otros(String ilicito_otros) {
        this.ilicito_otros = ilicito_otros;
    }

    public String getIlicito_otros() {
        return ilicito_otros;
    }

    public void setOrden_conclusion_fecha_est(String orden_conclusion_fecha_est) {
        this.orden_conclusion_fecha_est = orden_conclusion_fecha_est;
    }

    public String getOrden_conclusion_fecha_est() {
        return orden_conclusion_fecha_est;
    }

    public void setRecuperado_trib_ga(String recuperado_trib_ga) {
        this.recuperado_trib_ga = recuperado_trib_ga;
    }

    public String getRecuperado_trib_ga() {
        return recuperado_trib_ga;
    }

    public void setRecuperado_trib_iva(String recuperado_trib_iva) {
        this.recuperado_trib_iva = recuperado_trib_iva;
    }

    public String getRecuperado_trib_iva() {
        return recuperado_trib_iva;
    }

    public void setRecuperado_trib_ice(String recuperado_trib_ice) {
        this.recuperado_trib_ice = recuperado_trib_ice;
    }

    public String getRecuperado_trib_ice() {
        return recuperado_trib_ice;
    }

    public void setRecuperado_trib_iehd(String recuperado_trib_iehd) {
        this.recuperado_trib_iehd = recuperado_trib_iehd;
    }

    public String getRecuperado_trib_iehd() {
        return recuperado_trib_iehd;
    }

    public void setRecuperado_trib_icd(String recuperado_trib_icd) {
        this.recuperado_trib_icd = recuperado_trib_icd;
    }

    public String getRecuperado_trib_icd() {
        return recuperado_trib_icd;
    }

    public void setRecuperado_trib_total(String recuperado_trib_total) {
        this.recuperado_trib_total = recuperado_trib_total;
    }

    public String getRecuperado_trib_total() {
        return recuperado_trib_total;
    }

    public void setRecuperado_sancion(String recuperado_sancion) {
        this.recuperado_sancion = recuperado_sancion;
    }

    public String getRecuperado_sancion() {
        return recuperado_sancion;
    }

    public void setRecuperado_multa_contrav(String recuperado_multa_contrav) {
        this.recuperado_multa_contrav = recuperado_multa_contrav;
    }

    public String getRecuperado_multa_contrav() {
        return recuperado_multa_contrav;
    }

    public void setRecuperado_multa_contrab(String recuperado_multa_contrab) {
        this.recuperado_multa_contrab = recuperado_multa_contrab;
    }

    public String getRecuperado_multa_contrab() {
        return recuperado_multa_contrab;
    }

    public void setRecuperado_multa_contrab_delito(String recuperado_multa_contrab_delito) {
        this.recuperado_multa_contrab_delito = recuperado_multa_contrab_delito;
    }

    public String getRecuperado_multa_contrab_delito() {
        return recuperado_multa_contrab_delito;
    }

    public void setRecuperado_total_recuperado(String recuperado_total_recuperado) {
        this.recuperado_total_recuperado = recuperado_total_recuperado;
    }

    public String getRecuperado_total_recuperado() {
        return recuperado_total_recuperado;
    }

    public void setFacilidades_cuota_inicial(String facilidades_cuota_inicial) {
        this.facilidades_cuota_inicial = facilidades_cuota_inicial;
    }

    public String getFacilidades_cuota_inicial() {
        return facilidades_cuota_inicial;
    }

    public void setFacilidades_garantia(String facilidades_garantia) {
        this.facilidades_garantia = facilidades_garantia;
    }

    public String getFacilidades_garantia() {
        return facilidades_garantia;
    }

    public void setFacilidades_saldo(String facilidades_saldo) {
        this.facilidades_saldo = facilidades_saldo;
    }

    public String getFacilidades_saldo() {
        return facilidades_saldo;
    }

    public void setFacilidades_usuario(String facilidades_usuario) {
        this.facilidades_usuario = facilidades_usuario;
    }

    public String getFacilidades_usuario() {
        return facilidades_usuario;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public String getSecuencia() {
        return secuencia;
    }

    public void setSequencia(String sequencia) {
        this.sequencia = sequencia;
    }

    public String getSequencia() {
        return sequencia;
    }

    public void setTo_icd(String to_icd) {
        this.to_icd = to_icd;
    }

    public String getTo_icd() {
        return to_icd;
    }

    public void setRecuperado_multa_contravorden(String recuperado_multa_contravorden) {
        this.recuperado_multa_contravorden = recuperado_multa_contravorden;
    }

    public String getRecuperado_multa_contravorden() {
        return recuperado_multa_contravorden;
    }

    public void setRecuperado_multa_defraudacion(String recuperado_multa_defraudacion) {
        this.recuperado_multa_defraudacion = recuperado_multa_defraudacion;
    }

    public String getRecuperado_multa_defraudacion() {
        return recuperado_multa_defraudacion;
    }
}
