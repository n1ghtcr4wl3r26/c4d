package anb.persistencia;


import anb.bean.ReporteForm;

import anb.entidades.Reporte;

import anb.general.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import oracle.jdbc.OracleTypes;


public class ReporteDao extends Conexion {

    public List<Reporte> reporte_seguimiento_orden(ReporteForm bean) throws SQLException, ClassNotFoundException,
                                                                            NamingException {
        List<Reporte> htls = new ArrayList<Reporte>();
        int cont = 1;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_reporte.reporte_seguimiento_orden ( ?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, bean.getFtipotramite());
            call.setString(3, bean.getFgerencia());
            call.setString(4, bean.getFfecini());
            call.setString(5, bean.getFfecfin());
            call.setString(6, bean.getFnit());
            call.execute();
            
            rs = (ResultSet)call.getObject(1);
            while (rs.next()) {
                Reporte ht = new Reporte();
                ht.setSecuencia(String.valueOf(cont++));
                ht.setOrden_gestion(rs.getString(1));
                ht.setOrden_tipo_control(rs.getString(2));
                ht.setOrden_gerencia(rs.getString(3));
                ht.setOrden_numero(rs.getString(4));
                ht.setOrden_codigo(rs.getString(5));
                ht.setOrden_fecha(rs.getString(6));
                ht.setOrden_origen(rs.getString(7));
                ht.setOperador_numero_doc(rs.getString(8));
                ht.setOperador_nombre(rs.getString(9));
                ht.setFiscalizador_asignado(rs.getString(10));
                ht.setFiscalizador_nuevo(rs.getString(11));
                ht.setSupervisor_asignado(rs.getString(12));
                ht.setSupervisor_nuevo(rs.getString(13));
                ht.setNotificacion_fecha(rs.getString(14));
                ht.setNotificacion_observacion(rs.getString(15));
                ht.setNotificacion_tipo(rs.getString(16));
                ht.setNotificacion_usuario(rs.getString(17));
                ht.setRes_informe_numero(rs.getString(18));
                ht.setRes_informe_fecha(rs.getString(19));
                ht.setRes_gerencia_ulegal(rs.getString(20));
                ht.setRes_documento_tipo(rs.getString(21));
                ht.setRes_documento_numero(rs.getString(22));
                ht.setRes_documento_fecha(rs.getString(23));
                ht.setRes_documento_usuario(rs.getString(24));
                ht.setRes_notificacion_fecha(rs.getString(25));
                ht.setRes_notificacion_tipo(rs.getString(26));
                ht.setRes_notificacion_usuario(rs.getString(27));
                ht.setRes_ci_remision_fecha(rs.getString(28));
                ht.setRes_ci_remision_numero(rs.getString(29));
                ht.setRes_ci_remision_usuario(rs.getString(30));
                ht.setRes_finalizacion_fecha(rs.getString(31));
                ht.setRes_finalizacion_usuario(rs.getString(32));
                ht.setOrden_estado(rs.getString(33));
                ht.setIlicito_omision_pago(rs.getString(34));
                ht.setIlicito_contravencion_aduanera(rs.getString(35));
                ht.setIlicito_contrabando_contrav(rs.getString(36));
                ht.setIlicito_contrabando_delito(rs.getString(37));
                ht.setIlicito_defraudacion(rs.getString(38));
                ht.setIlicito_otros(rs.getString(39));
                ht.setOrden_conclusion_fecha_est(rs.getString(40));
                htls.add(ht);
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return htls;
    }

    public List<Reporte> reporte_seguimiento_dui(ReporteForm bean) throws SQLException, ClassNotFoundException,
                                                                          NamingException {
        List<Reporte> htls = new ArrayList<Reporte>();
        int cont = 1;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_reporte.reporte_seguimiento_dui ( ?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, bean.getFtipotramite());
            call.setString(3, bean.getFgerencia());
            call.setString(4, bean.getFfecini());
            call.setString(5, bean.getFfecfin());
            call.setString(6, bean.getFnit());
            call.execute();
            rs = (ResultSet)call.getObject(1);
            while (rs.next()) {
                Reporte ht = new Reporte();
                ht.setSecuencia(String.valueOf(cont++));
                ht.setOrden_gestion(rs.getString(1));
                ht.setOrden_tipo_control(rs.getString(2));
                ht.setOrden_gerencia(rs.getString(3));
                ht.setOrden_numero(rs.getString(4));
                ht.setOrden_codigo(rs.getString(5));
                ht.setOrden_fecha(rs.getString(6));
                ht.setOrden_origen(rs.getString(7));
                ht.setOperador_numero_doc(rs.getString(8));
                ht.setOperador_nombre(rs.getString(9));
                ht.setFiscalizador_asignado(rs.getString(10));
                ht.setFiscalizador_nuevo(rs.getString(11));
                ht.setSupervisor_asignado(rs.getString(12));
                ht.setSupervisor_nuevo(rs.getString(13));
                ht.setOrden_ampliatoria_codigo(rs.getString(14));
                ht.setOrden_ampliatoria_fecha(rs.getString(15));
                ht.setOrden_ampliatoria_ope_num(rs.getString(16));
                ht.setOrden_ampliatoria_ope_nom(rs.getString(17));
                ht.setNotificacion_fecha(rs.getString(18));
                ht.setNotificacion_observacion(rs.getString(19));
                ht.setNotificacion_tipo(rs.getString(20));
                ht.setNotificacion_usuario(rs.getString(21));
                ht.setDui_aduana(rs.getString(22));
                ht.setDui_codigo(rs.getString(23));
                ht.setDui_fecha(rs.getString(24));
                ht.setDui_patron(rs.getString(25));
                ht.setDui_canal(rs.getString(26));
                ht.setDui_fecha_pase(rs.getString(27));
                ht.setDui_importador_numero(rs.getString(28));
                ht.setDui_importador_nombre(rs.getString(29));
                ht.setDui_declarante_numero(rs.getString(30));
                ht.setDui_declarante_nombre(rs.getString(31));
                ht.setDui_proveedor_direccion(rs.getString(32));
                ht.setDui_proveedor_nombre(rs.getString(33));
                ht.setDui_localizacion(rs.getString(34));
                ht.setDui_origen(rs.getString(35));
                ht.setDui_procedencia_pais(rs.getString(36));
                ht.setDui_embarque_pais(rs.getString(37));
                ht.setDui_peso_bruto(rs.getString(38));
                ht.setDui_peso_neto(rs.getString(39));
                ht.setDui_declarado_fob(rs.getString(40));
                ht.setDui_declarado_flete(rs.getString(41));
                ht.setDui_declarado_seguro(rs.getString(42));
                ht.setDui_declarado_otros(rs.getString(43));
                ht.setDui_declarado_cif_sus(rs.getString(44));
                ht.setDui_declarado_cif_bs(rs.getString(45));
                ht.setDui_declarado_ga_bs(rs.getString(46));
                ht.setDui_declarado_iva_bs(rs.getString(47));
                ht.setDui_declarado_ice_bs(rs.getString(48));
                ht.setDui_declarado_iehd_bs(rs.getString(49));
                ht.setDui_declarado_icd_bs(rs.getString(50));
                ht.setDui_declarado_tributos_bs(rs.getString(51));
                ht.setRes_informe_numero(rs.getString(52));
                ht.setRes_informe_fecha(rs.getString(53));
                ht.setRes_gerencia_ulegal(rs.getString(54));
                ht.setRes_documento_tipo(rs.getString(55));
                ht.setRes_documento_numero(rs.getString(56));
                ht.setRes_documento_fecha(rs.getString(57));
                ht.setRes_documento_usuario(rs.getString(58));
                ht.setRes_notificacion_fecha(rs.getString(59));
                ht.setRes_notificacion_tipo(rs.getString(60));
                ht.setRes_notificacion_usuario(rs.getString(61));
                ht.setRes_ci_remision_fecha(rs.getString(62));
                ht.setRes_ci_remision_numero(rs.getString(63));
                ht.setRes_ci_remision_usuario(rs.getString(64));
                ht.setRes_finalizacion_fecha(rs.getString(65));
                ht.setRes_finalizacion_usuario(rs.getString(66));
                ht.setOrden_estado(rs.getString(67));
                ht.setIlicito_omision_pago(rs.getString(68));
                ht.setIlicito_contravencion_aduanera(rs.getString(69));
                ht.setIlicito_contrabando_contrav(rs.getString(70));
                ht.setIlicito_contrabando_delito(rs.getString(71));
                ht.setIlicito_defraudacion(rs.getString(72));
                ht.setIlicito_otros(rs.getString(73));
                ht.setOrden_conclusion_fecha_est(rs.getString(74));
                htls.add(ht);
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return htls;
    }

    public List<Reporte> reporte_seguimiento_item(ReporteForm bean) throws SQLException, ClassNotFoundException,
                                                                           NamingException {
        List<Reporte> htls = new ArrayList<Reporte>();
        int cont = 1;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_reporte.reporte_seguimiento_item ( ?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, bean.getFtipotramite());
            call.setString(3, bean.getFgerencia());
            call.setString(4, bean.getFfecini());
            call.setString(5, bean.getFfecfin());
            call.setString(6, bean.getFnit());
            call.execute();
            rs = (ResultSet)call.getObject(1);
            while (rs.next()) {
                Reporte ht = new Reporte();
                ht.setSecuencia(String.valueOf(cont++));
                ht.setOrden_gestion(rs.getString(1));
                ht.setOrden_tipo_control(rs.getString(2));
                ht.setOrden_gerencia(rs.getString(3));
                ht.setOrden_numero(rs.getString(4));
                ht.setOrden_codigo(rs.getString(5));
                ht.setOrden_fecha(rs.getString(6));
                ht.setOrden_origen(rs.getString(7));
                ht.setOperador_numero_doc(rs.getString(8));
                ht.setOperador_nombre(rs.getString(9));
                ht.setFiscalizador_asignado(rs.getString(10));
                ht.setFiscalizador_nuevo(rs.getString(11));
                ht.setSupervisor_asignado(rs.getString(12));
                ht.setSupervisor_nuevo(rs.getString(13));
                ht.setOrden_ampliatoria_codigo(rs.getString(14));
                ht.setOrden_ampliatoria_fecha(rs.getString(15));
                ht.setOrden_ampliatoria_ope_num(rs.getString(16));
                ht.setOrden_ampliatoria_ope_nom(rs.getString(17));
                ht.setNotificacion_fecha(rs.getString(18));
                ht.setNotificacion_observacion(rs.getString(19));
                ht.setNotificacion_tipo(rs.getString(20));
                ht.setNotificacion_usuario(rs.getString(21));
                ht.setDui_aduana(rs.getString(22));
                ht.setDui_codigo(rs.getString(23));
                ht.setDui_fecha(rs.getString(24));
                ht.setDui_item(rs.getString(25));
                ht.setDui_partida(rs.getString(26));
                ht.setDui_descripcion(rs.getString(27));
                ht.setDui_patron(rs.getString(28));
                ht.setDui_canal(rs.getString(29));
                ht.setDui_fecha_pase(rs.getString(30));
                ht.setDui_importador_numero(rs.getString(31));
                ht.setDui_importador_nombre(rs.getString(32));
                ht.setDui_declarante_numero(rs.getString(33));
                ht.setDui_declarante_nombre(rs.getString(34));
                ht.setDui_proveedor_direccion(rs.getString(35));
                ht.setDui_proveedor_nombre(rs.getString(36));
                ht.setDui_localizacion(rs.getString(37));
                ht.setDui_origen(rs.getString(38));
                ht.setDui_procedencia_pais(rs.getString(39));
                ht.setDui_embarque_pais(rs.getString(40));
                ht.setDui_peso_bruto(rs.getString(41));
                ht.setDui_peso_neto(rs.getString(42));
                ht.setDui_declarado_fob(rs.getString(43));
                ht.setDui_declarado_flete(rs.getString(44));
                ht.setDui_declarado_seguro(rs.getString(45));
                ht.setDui_declarado_otros(rs.getString(46));
                ht.setDui_declarado_cif_sus(rs.getString(47));
                ht.setDui_declarado_cif_bs(rs.getString(48));
                ht.setDui_declarado_ga_bs(rs.getString(49));
                ht.setDui_declarado_iva_bs(rs.getString(50));
                ht.setDui_declarado_ice_bs(rs.getString(51));
                ht.setDui_declarado_iehd_bs(rs.getString(52));
                ht.setDui_declarado_icd_bs(rs.getString(53));
                ht.setDui_declarado_tributos_bs(rs.getString(54));
                ht.setOrden_estado(rs.getString(55));
                ht.setIlicito_omision_pago(rs.getString(56));
                ht.setIlicito_contravencion_aduanera(rs.getString(57));
                ht.setIlicito_contrabando_contrav(rs.getString(58));
                ht.setIlicito_contrabando_delito(rs.getString(59));
                ht.setIlicito_defraudacion(rs.getString(60));
                ht.setIlicito_otros(rs.getString(61));
                ht.setOrden_conclusion_fecha_est(rs.getString(62));
                htls.add(ht);
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return htls;
    }

    public List<Reporte> reporte_liquidacion_dui(ReporteForm bean) throws SQLException, ClassNotFoundException,
                                                                          NamingException {
        List<Reporte> htls = new ArrayList<Reporte>();
        int cont = 1;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_reporte.reporte_liquidacion_dui ( ?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, bean.getFtipotramite());
            call.setString(3, bean.getFgerencia());
            call.setString(4, bean.getFfecini());
            call.setString(5, bean.getFfecfin());
            call.setString(6, bean.getFnit());
            call.execute();
            rs = (ResultSet)call.getObject(1);
            while (rs.next()) {
                Reporte ht = new Reporte();
                ht.setSecuencia(String.valueOf(cont++));
                ht.setOrden_gestion(rs.getString(1));
                ht.setOrden_tipo_control(rs.getString(2));
                ht.setOrden_gerencia(rs.getString(3));
                ht.setOrden_numero(rs.getString(4));
                ht.setOrden_codigo(rs.getString(5));
                ht.setOrden_fecha(rs.getString(6));
                ht.setDui_aduana(rs.getString(7));
                ht.setDui_codigo(rs.getString(8));
                ht.setDui_fecha(rs.getString(9));
                ht.setDui_patron(rs.getString(10));
                ht.setDui_canal(rs.getString(11));
                ht.setDui_fecha_pase(rs.getString(12));
                ht.setDui_importador_numero(rs.getString(13));
                ht.setDui_importador_nombre(rs.getString(14));
                ht.setDui_declarante_numero(rs.getString(15));
                ht.setDui_declarante_nombre(rs.getString(16));
                ht.setDui_proveedor_direccion(rs.getString(17));
                ht.setDui_proveedor_nombre(rs.getString(18));
                ht.setDui_localizacion(rs.getString(19));
                ht.setDui_origen(rs.getString(20));
                ht.setDui_procedencia_pais(rs.getString(21));
                ht.setDui_embarque_pais(rs.getString(22));
                ht.setDui_peso_bruto(rs.getString(23));
                ht.setDui_peso_neto(rs.getString(24));
                ht.setDui_declarado_fob(rs.getString(25));
                ht.setDui_declarado_flete(rs.getString(26));
                ht.setDui_declarado_seguro(rs.getString(27));
                ht.setDui_declarado_otros(rs.getString(28));
                ht.setDui_declarado_cif_sus(rs.getString(29));
                ht.setDui_declarado_cif_bs(rs.getString(30));
                ht.setDui_declarado_ga_bs(rs.getString(31));
                ht.setDui_declarado_iva_bs(rs.getString(32));
                ht.setDui_declarado_ice_bs(rs.getString(33));
                ht.setDui_declarado_iehd_bs(rs.getString(34));
                ht.setDui_declarado_icd_bs(rs.getString(35));
                ht.setDui_declarado_tributos_bs(rs.getString(36));
                ht.setDet_fob_sus(rs.getString(37));
                ht.setDet_flete_sus(rs.getString(38));
                ht.setDet_seguro_sus(rs.getString(39));
                ht.setDet_otros_sus(rs.getString(40));
                ht.setDet_cif_sus(rs.getString(41));
                ht.setDet_cif_bs(rs.getString(42));
                ht.setTo_ga(rs.getString(43));
                ht.setTo_iva(rs.getString(44));
                ht.setTo_ice(rs.getString(45));
                ht.setTo_iehd(rs.getString(46));
                ht.setTo_icd(rs.getString(47));
                ht.setTo_total(rs.getString(48));
                ht.setAdeudo_det_trib_total(rs.getString(49));
                ht.setAdeudo_det_sancion(rs.getString(50));
                ht.setAdeudo_det_multa_contrav_dui(rs.getString(51));
                ht.setAdeudo_det_multa_contrav_orden(rs.getString(52));
                ht.setAdeudo_det_multa_contrab_contrav(rs.getString(53));
                ht.setAdeudo_det_multa_contrab_delito(rs.getString(54));
                ht.setAdeudo_det_multa_otros(rs.getString(55));
                ht.setAdeudo_det_total(rs.getString(56));
                ht.setAdeudo_det_fecha_liq(rs.getString(57));
                ht.setAdeudo_det_fecha_liq_ufv(rs.getString(58));
                ht.setOrden_estado(rs.getString(59));
                htls.add(ht);
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return htls;
    }

    public List<Reporte> reporte_liquidacion_item(ReporteForm bean) throws SQLException, ClassNotFoundException,
                                                                           NamingException {
        List<Reporte> htls = new ArrayList<Reporte>();
        int cont = 1;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_reporte.reporte_liquidacion_item ( ?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, bean.getFtipotramite());
            call.setString(3, bean.getFgerencia());
            call.setString(4, bean.getFfecini());
            call.setString(5, bean.getFfecfin());
            call.setString(6, bean.getFnit());
            call.execute();
            rs = (ResultSet)call.getObject(1);
            while (rs.next()) {
                Reporte ht = new Reporte();
                ht.setSecuencia(String.valueOf(cont++));
                ht.setOrden_gestion(rs.getString(1));
                ht.setOrden_tipo_control(rs.getString(2));
                ht.setOrden_gerencia(rs.getString(3));
                ht.setOrden_numero(rs.getString(4));
                ht.setOrden_codigo(rs.getString(5));
                ht.setOrden_fecha(rs.getString(6));
                ht.setDui_aduana(rs.getString(7));
                ht.setDui_codigo(rs.getString(8));
                ht.setDui_fecha(rs.getString(9));
                ht.setDui_item(rs.getString(10));
                ht.setDui_partida(rs.getString(11));
                ht.setDui_descripcion(rs.getString(12));
                ht.setDui_patron(rs.getString(13));
                ht.setDui_canal(rs.getString(14));
                ht.setDui_fecha_pase(rs.getString(15));
                ht.setDui_importador_numero(rs.getString(16));
                ht.setDui_importador_nombre(rs.getString(17));
                ht.setDui_declarante_numero(rs.getString(18));
                ht.setDui_declarante_nombre(rs.getString(19));
                ht.setDui_proveedor_direccion(rs.getString(20));
                ht.setDui_proveedor_nombre(rs.getString(21));
                ht.setDui_localizacion(rs.getString(22));
                ht.setDui_origen(rs.getString(23));
                ht.setDui_procedencia_pais(rs.getString(24));
                ht.setDui_embarque_pais(rs.getString(25));
                ht.setDui_peso_bruto(rs.getString(26));
                ht.setDui_peso_neto(rs.getString(27));
                ht.setDui_declarado_fob(rs.getString(28));
                ht.setDui_declarado_flete(rs.getString(29));
                ht.setDui_declarado_seguro(rs.getString(30));
                ht.setDui_declarado_otros(rs.getString(31));
                ht.setDui_declarado_cif_sus(rs.getString(32));
                ht.setDui_declarado_cif_bs(rs.getString(33));
                ht.setDui_declarado_ga_bs(rs.getString(34));
                ht.setDui_declarado_iva_bs(rs.getString(35));
                ht.setDui_declarado_ice_bs(rs.getString(36));
                ht.setDui_declarado_iehd_bs(rs.getString(37));
                ht.setDui_declarado_icd_bs(rs.getString(38));
                ht.setDui_declarado_tributos_bs(rs.getString(39));
                ht.setDet_fob_sus(rs.getString(40));
                ht.setDet_flete_sus(rs.getString(41));
                ht.setDet_seguro_sus(rs.getString(42));
                ht.setDet_otros_sus(rs.getString(43));
                ht.setDet_cif_sus(rs.getString(44));
                ht.setDet_cif_bs(rs.getString(45));
                ht.setTo_ga(rs.getString(46));
                ht.setTo_iva(rs.getString(47));
                ht.setTo_ice(rs.getString(48));
                ht.setTo_iehd(rs.getString(49));
                ht.setTo_icd(rs.getString(50));
                ht.setTo_total(rs.getString(51));
                ht.setAdeudo_det_trib_total(rs.getString(52));
                ht.setAdeudo_det_sancion(rs.getString(53));
                ht.setAdeudo_det_multa_contrav_dui(rs.getString(54));
                ht.setAdeudo_det_multa_contrav_orden(rs.getString(55));
                ht.setAdeudo_det_multa_contrab_contrav(rs.getString(56));
                ht.setAdeudo_det_multa_contrab_delito(rs.getString(57));
                ht.setAdeudo_det_multa_otros(rs.getString(58));
                ht.setAdeudo_det_total(rs.getString(59));
                ht.setAdeudo_det_fecha_liq(rs.getString(60));
                ht.setAdeudo_det_fecha_liq_ufv(rs.getString(61));
                ht.setOrden_estado(rs.getString(62));
                htls.add(ht);
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return htls;
    }

    public List<Reporte> reporte_recuperacion_dui(ReporteForm bean) throws SQLException, ClassNotFoundException,
                                                                           NamingException {
        List<Reporte> htls = new ArrayList<Reporte>();
        int cont = 1;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_reporte.reporte_recuperacion_orden ( ?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, bean.getFtipotramite());
            call.setString(3, bean.getFgerencia());
            call.setString(4, bean.getFfecini());
            call.setString(5, bean.getFfecfin());
            call.setString(6, bean.getFnit());
            call.execute();
            rs = (ResultSet)call.getObject(1);
            while (rs.next()) {
                Reporte ht = new Reporte();
                /*ht.setSecuencia(String.valueOf(cont++));
                ht.setOrden_gestion(rs.getString(1));
                ht.setOrden_tipo_control(rs.getString(2));
                ht.setOrden_gerencia(rs.getString(3));
                ht.setOrden_numero(rs.getString(4));
                ht.setOrden_codigo(rs.getString(5));
                ht.setOrden_fecha(rs.getString(6));
                ht.setDui_aduana(rs.getString(7));
                ht.setDui_codigo(rs.getString(8));
                ht.setDui_fecha(rs.getString(9));
                ht.setDui_patron(rs.getString(10));
                ht.setDui_canal(rs.getString(11));
                ht.setDui_fecha_pase(rs.getString(12));
                ht.setDui_importador_numero(rs.getString(13));
                ht.setDui_importador_nombre(rs.getString(14));
                ht.setDui_declarante_numero(rs.getString(15));
                ht.setDui_declarante_nombre(rs.getString(16));
                ht.setDui_proveedor_direccion(rs.getString(17));
                ht.setDui_proveedor_nombre(rs.getString(18));
                ht.setDui_localizacion(rs.getString(19));
                ht.setDui_origen(rs.getString(20));
                ht.setDui_procedencia_pais(rs.getString(21));
                ht.setDui_embarque_pais(rs.getString(22));
                ht.setDui_peso_bruto(rs.getString(23));
                ht.setDui_peso_neto(rs.getString(24));
                ht.setDui_declarado_fob(rs.getString(25));
                ht.setDui_declarado_flete(rs.getString(26));
                ht.setDui_declarado_seguro(rs.getString(27));
                ht.setDui_declarado_otros(rs.getString(28));
                ht.setDui_declarado_cif_sus(rs.getString(29));
                ht.setDui_declarado_cif_bs(rs.getString(30));
                ht.setDui_declarado_ga_bs(rs.getString(31));
                ht.setDui_declarado_iva_bs(rs.getString(32));
                ht.setDui_declarado_ice_bs(rs.getString(33));
                ht.setDui_declarado_iehd_bs(rs.getString(34));
                ht.setDui_declarado_icd_bs(rs.getString(35));
                ht.setDui_declarado_tributos_bs(rs.getString(36));
                ht.setOrden_estado(rs.getString(37));*/
                ht.setSecuencia(String.valueOf(cont++));
                ht.setOrden_gestion(rs.getString(1));
                ht.setOrden_tipo_control(rs.getString(2));
                ht.setOrden_gerencia(rs.getString(3));
                ht.setOrden_numero(rs.getString(4));
                ht.setOrden_codigo(rs.getString(5));
                ht.setOrden_fecha(rs.getString(6));
                ht.setOrden_origen(rs.getString(7));
                ht.setOperador_numero_doc(rs.getString(8));
                ht.setOperador_nombre(rs.getString(9));
                ht.setFiscalizador_asignado(rs.getString(10));
                ht.setFiscalizador_nuevo(rs.getString(11));
                ht.setSupervisor_asignado(rs.getString(12));
                ht.setSupervisor_nuevo(rs.getString(13));
                ht.setNotificacion_fecha(rs.getString(14));
                ht.setNotificacion_observacion(rs.getString(15));
                ht.setNotificacion_tipo(rs.getString(16));
                ht.setNotificacion_usuario(rs.getString(17));
                ht.setRes_informe_numero(rs.getString(18));
                ht.setRes_informe_fecha(rs.getString(19));
                ht.setRes_gerencia_ulegal(rs.getString(20));
                ht.setRes_documento_tipo(rs.getString(21));
                ht.setRes_documento_numero(rs.getString(22));
                ht.setRes_documento_fecha(rs.getString(23));
                ht.setRes_documento_usuario(rs.getString(24));
                ht.setRes_notificacion_fecha(rs.getString(25));
                ht.setRes_notificacion_tipo(rs.getString(26));
                ht.setRes_notificacion_usuario(rs.getString(27));
                ht.setRes_ci_remision_fecha(rs.getString(28));
                ht.setRes_ci_remision_numero(rs.getString(29));
                ht.setRes_ci_remision_usuario(rs.getString(30));
                ht.setRes_finalizacion_fecha(rs.getString(31));
                ht.setRes_finalizacion_usuario(rs.getString(32));
                ht.setOrden_estado(rs.getString(33));
                ht.setIlicito_omision_pago(rs.getString(34));
                ht.setIlicito_contravencion_aduanera(rs.getString(35));
                ht.setIlicito_contrabando_contrav(rs.getString(36));
                ht.setIlicito_contrabando_delito(rs.getString(37));
                ht.setIlicito_defraudacion(rs.getString(38));
                ht.setIlicito_otros(rs.getString(39));
                ht.setOrden_conclusion_fecha_est(rs.getString(40));                
                ht.setRecuperado_trib_ga(rs.getString(41));
                ht.setRecuperado_trib_iva(rs.getString(42));
                ht.setRecuperado_trib_ice(rs.getString(43));
                ht.setRecuperado_trib_iehd(rs.getString(44));
                ht.setRecuperado_trib_icd(rs.getString(45));
                ht.setRecuperado_trib_total(rs.getString(46));
                ht.setRecuperado_sancion(rs.getString(47));
                ht.setRecuperado_multa_contrav(rs.getString(48));
                ht.setRecuperado_multa_contravorden(rs.getString(49));
                ht.setRecuperado_multa_contrab(rs.getString(50));
                ht.setRecuperado_multa_contrab_delito(rs.getString(51));
                ht.setRecuperado_multa_defraudacion(rs.getString(52));
                ht.setRecuperado_total_recuperado(rs.getString(53));
                ht.setFacilidades_cuota_inicial(rs.getString(54));
                ht.setFacilidades_garantia(rs.getString(55));
                ht.setFacilidades_saldo(rs.getString(56));
                ht.setFacilidades_usuario(rs.getString(57));
                htls.add(ht);
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return htls;
    }
}

