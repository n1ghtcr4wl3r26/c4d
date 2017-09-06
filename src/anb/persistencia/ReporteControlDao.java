package anb.persistencia;


import anb.bean.ReporteControlForm;

import anb.entidades.RepCantidades;
import anb.entidades.RepControl;
import anb.entidades.RepEstadoControl;

import anb.general.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import oracle.jdbc.OracleTypes;


public class ReporteControlDao  extends Conexion {
    
        public List<RepControl> reporteControl(ReporteControlForm bean) throws SQLException, ClassNotFoundException,
                                                                                      NamingException {
            List<RepControl> htls = new ArrayList<RepControl>();
            int cont = 1;
            try {
                open();
                call = cn.prepareCall("{ ? = call pkg_memorizacion.reporte_control ( ?,?,?,?)}");
                call.registerOutParameter(1, OracleTypes.CURSOR);
                call.setString(2, bean.getFcontrol());
                call.setString(3, bean.getFgerencia());
                call.setString(4, bean.getFfecini());
                call.setString(5, bean.getFfecfin());
                call.execute();
                rs = (ResultSet)call.getObject(1);
                while (rs.next()) {
                    RepControl ht = new RepControl();
                    ht.setSecuencia(String.valueOf(cont++));
                    ht.setGestion(rs.getString(1));
                    ht.setTipo(rs.getString(2));
                    ht.setGerencia(rs.getString(3));
                    ht.setNumero(rs.getString(4));
                    ht.setMemorizado(rs.getString(5));
                    ht.setFec_mem(rs.getString(6));
                    ht.setCodigo(rs.getString(7));
                    ht.setFec_reg(rs.getString(8));
                    ht.setDoc_operador(rs.getString(9));
                    ht.setNom_operador(rs.getString(10));
                    ht.setEstado(rs.getString(11));
                    ht.setUsuario(rs.getString(12));
                    htls.add(ht);
                }
            } finally {
                if (cn != null) {
                    cn.close();
                }
            }
            return htls;
        }
        
        public List<RepCantidades> reporteControlAsig(ReporteControlForm bean) throws SQLException, ClassNotFoundException,
                                                                                      NamingException {
            List<RepCantidades> htls = new ArrayList<RepCantidades>();
            int cont = 1;
            int posasig = 0;
            int poscon = 0;
            int difasig = 0;
            int difcon = 0;
            try {
                open();
                call = cn.prepareCall("{ ? = call pkg_reporte.resumen_controles ( ?,?,?,?)}");
                call.registerOutParameter(1, OracleTypes.CURSOR);
                call.setString(2, bean.getFuncionario());
                call.setString(3, bean.getFfecini());
                call.setString(4, bean.getFfecfin());
                call.setString(5, bean.getFgerencia());
                call.execute();
                rs = (ResultSet)call.getObject(1);
                while (rs.next()) {
                    RepCantidades ht = new RepCantidades();
                    ht.setFuncionario(rs.getString(1));
                    ht.setGerencia(rs.getString(2));
                    ht.setCantAsigFAP(rs.getString(3));
                    ht.setCantConFAP(rs.getString(4));
                    ht.setCantAsigCD(rs.getString(5));
                    ht.setCantConCD(rs.getString(6));
                    posasig = posasig + Integer.parseInt(ht.getCantAsigFAP());
                    poscon = poscon + Integer.parseInt(ht.getCantConFAP());
                    difasig = difasig + Integer.parseInt(ht.getCantAsigCD());
                    difcon = difcon + Integer.parseInt(ht.getCantConCD());
                    htls.add(ht);
                }
                RepCantidades rep = new RepCantidades();
                rep.setFuncionario("<strong>TOTAL</strong>");
                rep.setCantAsigFAP("<strong>"+posasig+"</strong>");
                rep.setCantConFAP("<strong>"+poscon+"</strong>");
                rep.setCantAsigCD("<strong>"+difasig+"</strong>");
                rep.setCantConCD("<strong>"+difcon+"</strong>");
                htls.add(rep);
            } finally {
                if (cn != null) {
                    cn.close();
                }
            }
            return htls;
        }
        
        public List<RepCantidades> reporteControlGen(ReporteControlForm bean) throws SQLException, ClassNotFoundException,
                                                                                      NamingException {
            List<RepCantidades> htls = new ArrayList<RepCantidades>();
            int cont = 1;
            int posasig = 0;
            int poscon = 0;
            int difasig = 0;
            int difcon = 0;
            try {
                open();
                call = cn.prepareCall("{ ? = call pkg_reporte.resumen_controles_gen ( ?,?,?)}");
                call.registerOutParameter(1, OracleTypes.CURSOR);
                call.setString(2, bean.getFfecini());
                call.setString(3, bean.getFfecfin());
                call.setString(4, bean.getFgerencia());
                call.execute();
                rs = (ResultSet)call.getObject(1);
                while (rs.next()) {
                    RepCantidades ht = new RepCantidades();
                    ht.setGerencia(rs.getString(1));
                    ht.setCantAsigFAP(rs.getString(2));
                    ht.setCantConFAP(rs.getString(3));
                    ht.setCantAsigCD(rs.getString(4));
                    ht.setCantConCD(rs.getString(5));
                    posasig = posasig + Integer.parseInt(ht.getCantAsigFAP());
                    poscon = poscon + Integer.parseInt(ht.getCantConFAP());
                    difasig = difasig + Integer.parseInt(ht.getCantAsigCD());
                    difcon = difcon + Integer.parseInt(ht.getCantConCD());
                    htls.add(ht);
                }
                RepCantidades rep = new RepCantidades();
                rep.setGerencia("<strong>TOTAL</strong>");
                rep.setCantAsigFAP("<strong>"+posasig+"</strong>");
                rep.setCantConFAP("<strong>"+poscon+"</strong>");
                rep.setCantAsigCD("<strong>"+difasig+"</strong>");
                rep.setCantConCD("<strong>"+difcon+"</strong>");
                htls.add(rep);
            } finally {
                if (cn != null) {
                    cn.close();
                }
            }
            return htls;
        }
        
        public List<RepCantidades> reporteControlAsigTot(ReporteControlForm bean) throws SQLException, ClassNotFoundException,
                                                                                      NamingException {
            List<RepCantidades> htls = new ArrayList<RepCantidades>();
            int cont = 1;
            try {
                open();
                call = cn.prepareCall("{ ? = call pkg_reporte.resumen_controles_tot ( ?,?,?,?)}");
                call.registerOutParameter(1, OracleTypes.CURSOR);
                call.setString(2, bean.getFuncionario());
                call.setString(3, bean.getFfecini());
                call.setString(4, bean.getFfecfin());
                call.setString(5, bean.getFgerencia());
                call.execute();
                rs = (ResultSet)call.getObject(1);
                while (rs.next()) {
                    RepCantidades ht = new RepCantidades();
                    ht.setCantAsigFAP(rs.getString(1));
                    ht.setCantConFAP(rs.getString(2));
                    ht.setCantAsigCD(rs.getString(3));
                    ht.setCantConCD(rs.getString(4));
                    htls.add(ht);
                }
            } finally {
                if (cn != null) {
                    cn.close();
                }
            }
            return htls;
        }
        
        public List<RepEstadoControl> reporteDetalleControles(ReporteControlForm bean) throws SQLException, ClassNotFoundException,
                                                                                      NamingException {
            List<RepEstadoControl> htls = new ArrayList<RepEstadoControl>();
            int cont = 1;
            try {
                open();
                call = cn.prepareCall("{ ? = call pkg_reporte.detalle_controles_sup ( ?,?,? ,?,?,?)}");
                call.registerOutParameter(1, OracleTypes.CURSOR);
                call.setString(2, bean.getFuncionario());
                call.setString(3, bean.getFfecini());
                call.setString(4, bean.getFfecfin());
                call.setString(5, bean.getFtipotramite());
                call.setString(6, bean.getFestado());
                call.setString(7, bean.getFgerencia());
                
                call.execute();
                rs = (ResultSet)call.getObject(1);
                while (rs.next()) {
                    RepEstadoControl ht = new RepEstadoControl();
                    ht.setFuncionario(rs.getString(1));
                    ht.setTipoControl(rs.getString(2));
                    ht.setNumeroControl(rs.getString(3));
                    ht.setOperador(rs.getString(4));
                    ht.setFechaAsignacion(rs.getString(5));
                    ht.setCantTramites(rs.getString(6));
                    ht.setFechaNotificacion(rs.getString(7));
                    ht.setEstado(rs.getString(8));
                    htls.add(ht);
                }
            } finally {
                if (cn != null) {
                    cn.close();
                }
            }
            return htls;
        }
        
        public List<RepCantidades> reporteDetalleCantidades(ReporteControlForm bean) throws SQLException, ClassNotFoundException,
                                                                                      NamingException {
            List<RepCantidades> htls = new ArrayList<RepCantidades>();
            int cont = 1;
            try {
                open();
                call = cn.prepareCall("{ ? = call pkg_reporte.detalle_cantidad_sup ( ?,?,?,?)}");
                call.registerOutParameter(1, OracleTypes.CURSOR);
                call.setString(2, bean.getFuncionario());
                call.setString(3, bean.getFfecini());
                call.setString(4, bean.getFfecfin());
                call.setString(5, bean.getFgerencia());
                call.execute();
                rs = (ResultSet)call.getObject(1);
                while (rs.next()) {
                    RepCantidades ht = new RepCantidades();
                    ht.setFuncionario(rs.getString(1));
                    ht.setCantAsigFAP(rs.getString(2));
                    ht.setCantConFAP(rs.getString(3));
                    ht.setCantAsigCD(rs.getString(4));
                    ht.setCantConCD(rs.getString(5));
                    htls.add(ht);
                }
            } finally {
                if (cn != null) {
                    cn.close();
                }
            }
            return htls;
        }       
        public List<RepCantidades> reporteDetalleTotales(ReporteControlForm bean) throws SQLException, ClassNotFoundException,
                                                                                      NamingException {
            List<RepCantidades> htls = new ArrayList<RepCantidades>();
            int cont = 1;
            try {
                open();
                call = cn.prepareCall("{ ? = call pkg_reporte.detalle_cantidad_sup_tot ( ?,?,?,?)}");
                call.registerOutParameter(1, OracleTypes.CURSOR);
                call.setString(2, bean.getFuncionario());
                call.setString(3, bean.getFfecini());
                call.setString(4, bean.getFfecfin());
                call.setString(5, bean.getFgerencia());
                call.execute();
                rs = (ResultSet)call.getObject(1);
                while (rs.next()) {
                    RepCantidades ht = new RepCantidades();
                    ht.setCantAsigFAP(rs.getString(1));
                    ht.setCantConFAP(rs.getString(2));
                    ht.setCantAsigCD(rs.getString(3));
                    ht.setCantConCD(rs.getString(4));
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

