package anb.persistencia;


import anb.bean.RegistroControlForm;

import anb.entidades.Aduana;

import anb.general.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import oracle.jdbc.OracleTypes;


public class RegistroControlDao extends Conexion {
    public RegistroControlDao() {
        super();
    }

    public List<Aduana> obtenerAduanas() throws SQLException, ClassNotFoundException, NamingException {
        List<Aduana> aduanas = null;
        try {
            open();
            call = cn.prepareCall("{ call PKG_GENERAL.LISTA_ADUANAS }");
            call.registerOutParameter("C_ADUANAS", OracleTypes.CURSOR);
            call.execute();

            rs = (ResultSet)call.getObject("C_ADUANAS");
            if (rs != null) {
                aduanas = new ArrayList<Aduana>();
                while (rs.next()) {
                    Aduana aduana = new Aduana();
                    aduana.setCodigo(rs.getString("CUO_COD"));
                    aduana.setDescripcion(rs.getString("CUO_NAM"));
                    aduanas.add(aduana);
                }
            }
        } finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return aduanas;
    }

    public String verifica_registra_control(RegistroControlForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.verifica_registra_control ( ?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getGerencia());
            call.setString(4, bean.getUsuario());
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public String registra_control(RegistroControlForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.registra_control ( ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?, ?,?,?,?,?, ?,  ?,?,?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getGerencia());
            call.setString(4, bean.getUsuario());
            call.setString(5, bean.getInn_1());
            call.setString(6, bean.getInn_2());
            call.setString(7, bean.getInn_3());
            call.setString(8, bean.getInn_4());
            call.setString(9, bean.getInn_5());
            call.setString(10, bean.getInn_6());
            call.setString(11, bean.getInn_7());
            call.setString(12, bean.getInn_8());
            call.setString(13, bean.getInn_9());
            call.setString(14, bean.getInn_10());
            call.setString(15, bean.getInn_11());
            call.setString(16, bean.getInn_12());
            call.setString(17, bean.getInn_13());
            call.setString(18, bean.getInn_14());
            call.setString(19, bean.getInn_15());
            call.setString(20, bean.getInn_16());
            call.setString(21, bean.getInn_17());
            call.setString(22, bean.getInn_18());
            call.setString(23, bean.getInn_19());
            call.setString(24, bean.getInn_20());
            call.setString(25, bean.getInn_21());
            call.setString(26, bean.getInn_plazo_conclusion());    
            call.setString(27, bean.getGa());
            call.setString(28, bean.getIva());
            call.setString(29, bean.getIce());
            call.setString(30, bean.getIehd());
            call.setString(31, bean.getIcd());
            call.setString(32, bean.getNoaplica());
            
            call.setString(33, bean.getPeriodosolicitar());
            call.setString(34, bean.getNroDocumento());
            call.setString(35, bean.getFecDocumento());
            call.setString(36, bean.getRiesgoDelito());
            call.setString(37, bean.getRiesgoSubval());
            call.setString(38, bean.getRiesgoClas());
            call.setString(39, bean.getRiesgoContrab());
            
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
