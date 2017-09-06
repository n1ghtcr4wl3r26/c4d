package anb.persistencia;


import anb.bean.ConclusionControlForm;

import anb.entidades.PanelConclusion;

import anb.general.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import oracle.jdbc.OracleTypes;


public class ConclusionDao extends Conexion {
    public ConclusionDao() {
        super();
    }
    
    public String graba_conclusion(ConclusionControlForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_seguimiento.graba_conclusion ( ?,?,?,?  ,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getUsuario());
            call.setString(4, bean.getNumeroInforme());
            call.setString(5, bean.getFechaInforme());
            call.setString(6, bean.getTipoDocCon());
            call.setString(7, bean.getNumDocCon());
            call.setString(8, bean.getFechaDocCon());                        
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public ConclusionControlForm devuelveConclusion(ConclusionControlForm bean) throws SQLException, ClassNotFoundException, NamingException {
       try {
           open();
           call = cn.prepareCall("{ ? = call pkg_seguimiento.devuelve_conclusion ( ? )}");
           call.registerOutParameter(1, OracleTypes.CURSOR);
           call.setString(2, bean.getCodigo());
           call.execute();
           rs = (ResultSet) call.getObject(1);           
           while (rs.next()) {
               bean.setCodigo(rs.getString(1));
               bean.setNumeroInforme(rs.getString(2));
               bean.setFechaInforme(rs.getString(3));
               bean.setTipoDocCon(rs.getString(4));
               bean.setNumDocCon(rs.getString(5));
               bean.setFechaDocCon(rs.getString(6));             
           }
       } finally {
           if (cn != null) {
               cn.close();
           }
       }
       return bean;
    }
    
    public PanelConclusion devuelveConclusionPanel(String codigo)throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        PanelConclusion res = new PanelConclusion();
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_conclusion.devuelve_paneles ( ? )}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, codigo);
            call.execute();
            rs = (ResultSet) call.getObject(1);
            
            while (rs.next()) {
                res.setPanel1(rs.getString(1));
                res.setPanel2(rs.getString(2));
                res.setPanel3(rs.getString(3));
                res.setPanel4(rs.getString(4));
                res.setPanel5(rs.getString(5));
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    
    public String graba_con_viscargo(ConclusionControlForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_conclusion.graba_con_viscargo ( ?,?,?,?,? ,?,?,?,?,? ,?,?,?  ,?,?,?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getCvc_tipo_notificacion());
            call.setString(4, bean.getCvc_fecha_notificacion());
            call.setString(5, bean.getCvc_fecha_presentacion());
            call.setString(6, bean.getCvc_inf_descargo());
            call.setString(7, bean.getCvc_fecha_descargo());  
            call.setString(8, bean.getCvc_rd_final());
            call.setString(9, bean.getCvc_fecha_not_rd_final());
            call.setString(10, bean.getCvc_ci_remision());
            call.setString(11, bean.getCvc_fecha_ci_remision());
            call.setString(12, bean.getCvc_numero_rd());
            call.setString(13, bean.getCvc_fecha_rd());
            call.setString(14, bean.getUsuario()); 
            call.setString(15, bean.getCvc_numero_informe()); 
            call.setString(16, bean.getCvc_fecha_informe()); 
            call.setString(17, bean.getCvc_numero_vc()); 
            call.setString(18, bean.getCvc_fecha_vc()); 
            call.setString(19, bean.getCvc_tipo_rd()); 
            call.setString(20, bean.getCvc_gerencia_legal()); 
            call.setString(21, bean.getTipo_grabado());
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public ConclusionControlForm devuelvecon_viscargo(ConclusionControlForm bean) throws SQLException, ClassNotFoundException, NamingException {
       try {
           open();
           call = cn.prepareCall("{ ? = call pkg_conclusion.devuelve_con_viscargo ( ? )}");
           call.registerOutParameter(1, OracleTypes.CURSOR);
           call.setString(2, bean.getCodigo());
           call.execute();
           rs = (ResultSet) call.getObject(1);           
           while (rs.next()) {
               bean.setCodigo(rs.getString(1));
               bean.setCvc_tipo_notificacion(rs.getString(2));
               bean.setCvc_fecha_notificacion(rs.getString(3));
               bean.setCvc_fecha_presentacion(rs.getString(4));
               bean.setCvc_inf_descargo(rs.getString(5));
               bean.setCvc_fecha_descargo(rs.getString(6));  
               bean.setCvc_rd_final(rs.getString(7));
               bean.setCvc_fecha_not_rd_final(rs.getString(8));
               bean.setCvc_ci_remision(rs.getString(9));
               bean.setCvc_fecha_ci_remision(rs.getString(10));
               bean.setCvc_numero_rd(rs.getString(11));
               bean.setCvc_fecha_rd(rs.getString(12));    
               bean.setCvc_numero_informe(rs.getString(17));  
               bean.setCvc_fecha_informe(rs.getString(18));  
               bean.setCvc_numero_vc(rs.getString(19));  
               bean.setCvc_fecha_vc(rs.getString(20));
               bean.setCvc_tipo_rd(rs.getString(21));
               bean.setCvc_gerencia_legal(rs.getString(22));
           }
       } finally {
           if (cn != null) {
               cn.close();
           }
       }
       return bean;
    }
    
    public String graba_con_resdeter(ConclusionControlForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_conclusion.graba_con_resdeter ( ?,?,?,? ,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getCrd_rd_final());
            call.setString(4, bean.getCrd_fecha_not_rd_final());
            call.setString(5, bean.getUsuario()); 
            call.setString(6, bean.getCrd_numero_informe());
            call.setString(7, bean.getCrd_fecha_informe());
            call.setString(8, bean.getTipo_grabado());
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public ConclusionControlForm devuelvecon_resdeter(ConclusionControlForm bean) throws SQLException, ClassNotFoundException, NamingException {
       try {
           open();
           call = cn.prepareCall("{ ? = call pkg_conclusion.devuelve_con_resdeter ( ? )}");
           call.registerOutParameter(1, OracleTypes.CURSOR);
           call.setString(2, bean.getCodigo());
           call.execute();
           rs = (ResultSet) call.getObject(1);           
           while (rs.next()) {
               bean.setCodigo(rs.getString(1));
               bean.setCrd_rd_final(rs.getString(2));
               bean.setCrd_fecha_not_rd_final(rs.getString(3));  
               bean.setCrd_numero_informe(rs.getString(8));
               bean.setCrd_fecha_informe(rs.getString(9));
               
           }
       } finally {
           if (cn != null) {
               cn.close();
           }
       }
       return bean;
    }
    
    public String graba_con_actainter(ConclusionControlForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_conclusion.graba_con_actainter ( ?,?,?,?,? ,?,?,?,?,? ,?,?,?,? ,?,?,? ,?,? ,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getCai_acta_interv());
            call.setString(4, bean.getCai_fecha_acta_interv());
            call.setString(5, bean.getCai_tipo_ilicito());
            call.setString(6, bean.getCai_ci_remision());
            call.setString(7, bean.getCai_fecha_ci_remision());
            call.setString(8, bean.getCai_fecha_pres_descargos());
            call.setString(9, bean.getCai_inf_descargo());
            call.setString(10, bean.getCai_fecha_inf_descargo());
            call.setString(11, bean.getCai_numero_rfs());
            call.setString(12, bean.getCai_fecha_rfs());
            call.setString(13, bean.getCai_numero_rs());
            call.setString(14, bean.getCai_fecha_rs());
            call.setString(15, bean.getUsuario()); 
            call.setString(16, bean.getCai_numero_informe());
            call.setString(17, bean.getCai_fecha_informe());
            call.setString(18, bean.getCai_gerencia_legal());
            call.setString(19, bean.getCai_fecha_not_ai());
            call.setString(20, bean.getCai_tipo_not_ai());
            call.setString(21, bean.getCai_resultado_des());
            call.setString(22, bean.getCai_tipo_resolucion());
            call.setString(23, bean.getTipo_grabado());
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public ConclusionControlForm devuelvecon_actainter(ConclusionControlForm bean) throws SQLException, ClassNotFoundException, NamingException {
       try {
           open();
           call = cn.prepareCall("{ ? = call pkg_conclusion.devuelve_con_actainter ( ? )}");
           call.registerOutParameter(1, OracleTypes.CURSOR);
           call.setString(2, bean.getCodigo());
           call.execute();
           rs = (ResultSet) call.getObject(1);           
           while (rs.next()) {
               bean.setCodigo(rs.getString(1));
               bean.setCai_acta_interv(rs.getString(2));
               bean.setCai_fecha_acta_interv(rs.getString(3));
               bean.setCai_tipo_ilicito(rs.getString(4));
               bean.setCai_ci_remision(rs.getString(5));
               bean.setCai_fecha_ci_remision(rs.getString(6));
               bean.setCai_fecha_pres_descargos(rs.getString(7));
               bean.setCai_inf_descargo(rs.getString(8));
               bean.setCai_fecha_inf_descargo(rs.getString(9));
               bean.setCai_numero_rfs(rs.getString(10));
               bean.setCai_fecha_rfs(rs.getString(11));
               bean.setCai_numero_rs(rs.getString(12));
               bean.setCai_fecha_rs(rs.getString(13));   
               bean.setCai_numero_informe(rs.getString(18)); 
               bean.setCai_fecha_informe(rs.getString(19));
               bean.setCai_gerencia_legal(rs.getString(20));
               bean.setCai_fecha_not_ai(rs.getString(21));
               bean.setCai_tipo_not_ai(rs.getString(22));                   
               bean.setCai_resultado_des(rs.getString(23));
               bean.setCai_tipo_resolucion(rs.getString(24));
           }
       } finally {
           if (cn != null) {
               cn.close();
           }
       }
       return bean;
    }
    
    public String graba_con_resadmin(ConclusionControlForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_conclusion.graba_con_resadmin ( ?,?,?,?,? ,?,?,?,?  ,?,?  ,?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getCra_fecha_pago_cuini());
            call.setString(4, bean.getCra_monto_pago_cuoini());
            call.setString(5, bean.getCra_numero_ra());
            call.setString(6, bean.getCra_fecha_ra());
            call.setString(7, bean.getCra_ci_remision_set());
            call.setString(8, bean.getCra_fecha_remision_set());
            call.setString(9, bean.getCra_saldo_por_cobrar());
            call.setString(10, bean.getUsuario()); 
            call.setString(11, bean.getCra_numero_informe());
            call.setString(12, bean.getCra_fecha_informe());
            call.setString(13, bean.getCra_rup_gestion());
            call.setString(14, bean.getCra_rup_aduana());
            call.setString(15, bean.getCra_rup_numero());
            call.setString(16, bean.getCra_gerencia_legal());
            call.setString(17, bean.getTipo_grabado());
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public String graba_concluirfis(ConclusionControlForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_conclusion.graba_conclusionfis ( ?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getUsuario()); 
            
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public ConclusionControlForm devuelvecon_resadmin(ConclusionControlForm bean) throws SQLException, ClassNotFoundException, NamingException {
       try {
           open();
           call = cn.prepareCall("{ ? = call pkg_conclusion.devuelve_con_resadmin ( ? )}");
           call.registerOutParameter(1, OracleTypes.CURSOR);
           call.setString(2, bean.getCodigo());
           call.execute();
           rs = (ResultSet) call.getObject(1);           
           while (rs.next()) {
               bean.setCodigo(rs.getString(1));
               bean.setCra_fecha_pago_cuini(rs.getString(2));
               bean.setCra_monto_pago_cuoini(rs.getString(3));
               bean.setCra_numero_ra(rs.getString(4));
               bean.setCra_fecha_ra(rs.getString(5));
               bean.setCra_ci_remision_set(rs.getString(6));
               bean.setCra_fecha_remision_set(rs.getString(7));
               bean.setCra_saldo_por_cobrar(rs.getString(8));   
               bean.setCra_numero_informe(rs.getString(13));
               bean.setCra_fecha_informe(rs.getString(14));
               bean.setCra_rup_gestion(rs.getString(15));
               bean.setCra_rup_aduana(rs.getString(16));
               bean.setCra_rup_numero(rs.getString(17));
               bean.setCra_gerencia_legal(rs.getString(18));
           }
       } finally {
           if (cn != null) {
               cn.close();
           }
       }
       return bean;
    }
    
    public String graba_con_autoinicial(ConclusionControlForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_conclusion.graba_con_autoinicial ( ?,?,?,?,? ,?,?,?,?,? ,?,?,?  ,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getCas_numero_aisc());
            call.setString(4, bean.getCas_fecha_notificacion());
            call.setString(5, bean.getCas_fecha_pres_descargos());
            call.setString(6, bean.getCas_inf_descargo());
            call.setString(7, bean.getCas_fecha_inf_descargo());
            call.setString(8, bean.getCas_numero_rfs());
            call.setString(9, bean.getCas_fecha_rfs());
            call.setString(10, bean.getCas_ci_remision_gr());
            call.setString(11, bean.getCas_fecha_ci());
            call.setString(12, bean.getCas_numero_rs());
            call.setString(13, bean.getCas_fecha_rs());
            call.setString(14, bean.getUsuario()); 
            call.setString(15, bean.getCas_numero_informe());
            call.setString(16, bean.getCas_fecha_informe());
            call.setString(17, bean.getCas_gerencia_legal());
            call.setString(18, bean.getTipo_grabado());
            
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public ConclusionControlForm devuelvecon_autoinicial(ConclusionControlForm bean) throws SQLException, ClassNotFoundException, NamingException {
       try {
           open();
           call = cn.prepareCall("{ ? = call pkg_conclusion.devuelve_con_autoinicial ( ? )}");
           call.registerOutParameter(1, OracleTypes.CURSOR);
           call.setString(2, bean.getCodigo());
           call.execute();
           rs = (ResultSet) call.getObject(1);           
           while (rs.next()) {
               bean.setCodigo(rs.getString(1));
               bean.setCas_numero_aisc(rs.getString(2));
               bean.setCas_fecha_notificacion(rs.getString(3));
               bean.setCas_fecha_pres_descargos(rs.getString(4));
               bean.setCas_inf_descargo(rs.getString(5));
               bean.setCas_fecha_inf_descargo(rs.getString(6));
               bean.setCas_numero_rfs(rs.getString(7));
               bean.setCas_fecha_rfs(rs.getString(8));    
               bean.setCas_ci_remision_gr(rs.getString(9));   
               bean.setCas_fecha_ci(rs.getString(10));   
               bean.setCas_numero_rs(rs.getString(11));   
               bean.setCas_fecha_rs(rs.getString(12)); 
               bean.setCas_numero_informe(rs.getString(17)); 
               bean.setCas_fecha_informe(rs.getString(18)); 
               bean.setCas_gerencia_legal(rs.getString(19)); 
               
           }
       } finally {
           if (cn != null) {
               cn.close();
           }
       }
       return bean;
    }
    
}
