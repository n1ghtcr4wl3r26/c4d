package anb.persistencia;


import anb.bean.NotificacionConclusionForm;

import anb.general.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import oracle.jdbc.OracleTypes;


public class NotificacionConDao extends Conexion {
    public NotificacionConDao() {
        super();
    }
    
    public String graba_notifiacion_con(NotificacionConclusionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_seguimiento.graba_not_conclusion ( ?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getUsuario());
            call.setString(4, bean.getFechaNotificacion());
            call.setString(5, bean.getTipoNotificacion());
            
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public NotificacionConclusionForm devuelveNotConclusion(NotificacionConclusionForm bean) throws SQLException, ClassNotFoundException, NamingException {
       try {
           open();
           call = cn.prepareCall("{ ? = call pkg_seguimiento.devuelve_not_conclusion ( ? )}");
           call.registerOutParameter(1, OracleTypes.CURSOR);
           call.setString(2, bean.getCodigo());
           call.execute();
           rs = (ResultSet) call.getObject(1);           
           while (rs.next()) {
               bean.setCodigo(rs.getString(1));
               bean.setFechaNotificacion(rs.getString(2));
               bean.setTipoNotificacion(rs.getString(3));     
           }
       } finally {
           if (cn != null) {
               cn.close();
           }
       }
       return bean;
    }
}
