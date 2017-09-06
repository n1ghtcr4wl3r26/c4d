package anb.persistencia;


import anb.bean.TributosOmitidosForm;

import anb.entidades.TributosOmitidos;
import anb.entidades.TributosOmitidosTotales;

import anb.general.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import oracle.jdbc.OracleTypes;


public class TributosOmitidosDao extends Conexion {
    public TributosOmitidosDao() {
        super();
    }
    
    
    public List<TributosOmitidos> devuelveTributosOmitidos(TributosOmitidosForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        List<TributosOmitidos> htls = new ArrayList<TributosOmitidos>();
        int cont = 1;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_reporte.dev_tributoomitidofecha ( ?,?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getFfecha());
            call.execute();
            rs = (ResultSet)call.getObject(1);
            while (rs.next()) {
                TributosOmitidos ht = new TributosOmitidos();
                ht.setNumero(String.valueOf(cont++));
                ht.setDui(rs.getString(1)+"/"+rs.getString(2)+"/C-"+rs.getString(3));
                ht.setFechareg(rs.getString(4));
                ht.setGa(rs.getString(5));
                ht.setIva(rs.getString(6));
                ht.setIce(rs.getString(7));
                ht.setIehd(rs.getString(8));
                ht.setIcd(rs.getString(9));
                ht.setTotal(rs.getString(10));
                ht.setTotot(rs.getString(11));
                ht.setTototact(rs.getString(13));
                ht.setFecnotvc(rs.getString(14));
                ht.setFecnotvc10(rs.getString(15));
                ht.setFecnotrdvc(rs.getString(16));
                ht.setDiasnotvc(rs.getString(17));
                ht.setDiasnotrdvc(rs.getString(18));
                htls.add(ht);
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return htls;
    }
    

    public TributosOmitidosTotales devuelveTributosOmitidosTotales(TributosOmitidosForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        TributosOmitidosTotales ht = new TributosOmitidosTotales();
        int cont = 1;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_reporte.dev_tributoomitidofechatotal ( ?,?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getFfecha());
            call.execute();
            rs = (ResultSet)call.getObject(1);
            while (rs.next()) {
                ht.setSancionomision(rs.getString(1));
                ht.setContravdui(rs.getString(2));
                ht.setContravorden(rs.getString(3));
                ht.setSancioncontrabando(rs.getString(4));
                ht.setSanciondefraudacion(rs.getString(5));
                ht.setDelito(rs.getString(6));
                ht.setFechahoy(rs.getString(7));
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return ht;
    }
    
}
