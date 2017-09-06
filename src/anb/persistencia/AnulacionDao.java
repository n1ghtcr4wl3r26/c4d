package anb.persistencia;


import anb.bean.AnulacionForm;

import anb.entidades.Aduana;

import anb.general.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import oracle.jdbc.OracleTypes;


public class AnulacionDao extends Conexion {
    public AnulacionDao() {
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

    public String verifica_anulacion_control(AnulacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.verifica_anulacion_control ( ?,?,?)}");
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
    
    public String anula_control(AnulacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.anula_control ( ?,?,?,? )}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getGerencia());
            call.setString(4, bean.getUsuario());
            call.setString(5, bean.getJustificacion());            
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
