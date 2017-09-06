package anb.persistencia;


import anb.bean.RegistroRecibosForm;

import anb.entidades.Aduana;
import anb.entidades.Recibo;

import anb.general.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import oracle.jdbc.OracleTypes;


public class RegistroRecibosDao extends Conexion {
    public RegistroRecibosDao() {
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

    public String verifica_registro_recibos(RegistroRecibosForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.verifica_registro_recibos ( ?,?,?)}");
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
    
    public String graba_recibo(RegistroRecibosForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.graba_recibo ( ?,?,?,? ,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getRupgestion());
            call.setString(4, bean.getRupaduana());
            call.setString(5, bean.getRupnumero());
            call.setString(6, bean.getRuptipo());
            call.setString(7, bean.getRupfecha());
            call.setString(8, bean.getRupimporte());
            call.setString(9, bean.getUsuario());          
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public String borra_recibo(RegistroRecibosForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.borra_recibo ( ?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getBorrarid());
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
    
    public List<Recibo> recibos(RegistroRecibosForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        List<Recibo> decls = new ArrayList<Recibo>();
        int cont = 1;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.devuelve_recibos ( ?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.registerOutParameter(3, OracleTypes.CURSOR);
            call.execute();
            rs = (ResultSet)call.getObject(3);
            while (rs.next()) {
                Recibo dec = new Recibo();
                dec.setCodigo(rs.getString(1));
                dec.setGestion(rs.getString(2));
                dec.setAduana(rs.getString(3));
                dec.setNumero(rs.getString(4));
                dec.setTipo(rs.getString(5));
                dec.setFecha(rs.getString(6));
                dec.setImporte(rs.getString(7));                
                dec.setSeq(String.valueOf(cont++));
                decls.add(dec);
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return decls;
    }
}
