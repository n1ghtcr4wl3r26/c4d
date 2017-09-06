package anb.persistencia;


import anb.general.Conexion;

import java.sql.SQLException;

import javax.naming.NamingException;

import oracle.jdbc.OracleTypes;


public class SubirExcelDao extends Conexion {
    public SubirExcelDao() {
        super();
    }

    public String graba_resultados(String dui, String item, String partida, double fob, double flete, double seguro,
                                   double otros, double cifusd, double cifbob, double contrav, String ilicito,
                                   String observacion, String usuario, String codigo, double contravorden, String idalcance) throws SQLException, ClassNotFoundException,
                                                                              NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_seguimiento.graba_resultados2 ( ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, dui);
            call.setString(3, item);
            call.setString(4, partida);
            call.setDouble(5, fob);
            call.setDouble(6, flete);
            call.setDouble(7, seguro);
            call.setDouble(8, otros);
            call.setDouble(9, cifusd);
            call.setDouble(10, cifbob);
            call.setDouble(11, contrav);
            call.setString(12, ilicito);
            call.setString(13, observacion);
            call.setString(14, usuario);
            call.setString(15, codigo);
            call.setDouble(16, contravorden);
            call.setString(17, idalcance);
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public String graba_resultados_tramite(String codigo, String idalcance, String mercancia, double fob, double flete, double seguro,
                                   double otros, double cifusd, double cifbob, double cifufv, String usuario, String ilicito, double contrav) throws SQLException, ClassNotFoundException,
                                                                              NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_seguimiento.graba_resultadostram ( ?,?,?,?,?,  ?,?,?,?,?, ?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, codigo);
            call.setString(3, idalcance);
            call.setString(4, mercancia);
            call.setDouble(5, fob);
            call.setDouble(6, flete);            
            call.setDouble(7, seguro);
            call.setDouble(8, otros);
            call.setDouble(9, cifusd);
            call.setDouble(10, cifbob);
            call.setDouble(11, cifufv);
            call.setString(12, usuario);
            call.setString(13, ilicito);
            call.setDouble(14, contrav);
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }

}
