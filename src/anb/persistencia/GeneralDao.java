package anb.persistencia;

import anb.entidades.Aduana;

import anb.general.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import oracle.jdbc.OracleTypes;


public class GeneralDao extends Conexion {
    public GeneralDao() {
        super();
    }

    public static String numeroGerencia(String gerencia) {
        String res = "";
        if (gerencia.equals("GNF"))
            res = "%";
        if (gerencia.equals("GRL"))
            res = "2";
        if (gerencia.equals("GRC"))
            res = "3";
        if (gerencia.equals("GRS"))
            res = "7";
        if (gerencia.equals("GRO"))
            res = "4";
        if (gerencia.equals("GRP"))
            res = "5";
        if (gerencia.equals("GRT"))
            res = "6";

        return res;
    }

    public String nombrecompleto(String codigo) throws SQLException, ClassNotFoundException, NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_general.nombrecompleto ( ?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, codigo);
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }

    public List<Aduana> obtenerAduanas() throws SQLException, ClassNotFoundException, NamingException {
        List<Aduana> aduanas = null;
        try {
            open();
            call = cn.prepareCall("{ ? = call PKG_GENERAL.LISTA_ADUANAS }");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.execute();

            rs = (ResultSet)call.getObject(1);
            if (rs != null) {
                aduanas = new ArrayList<Aduana>();
                Aduana aduanaini = new Aduana();
                aduanaini.setCodigo("%");
                aduanaini.setDescripcion("Todas las Aduanas");
                aduanas.add(aduanaini);
                while (rs.next()) {
                    Aduana aduana = new Aduana();
                    aduana.setCodigo(rs.getString("CUO_COD"));
                    aduana.setDescripcion(rs.getString("CUO_NAM"));
                    aduanas.add(aduana);
                }
            }
        } catch (Exception e) {
            String error = e.getMessage();
        } finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return aduanas;
    }

    public List<Aduana> obtenerAduanas2() throws SQLException, ClassNotFoundException, NamingException {
        List<Aduana> aduanas = null;
        try {
            open();
            call = cn.prepareCall("{ ? = call PKG_GENERAL.LISTA_ADUANAS }");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.execute();

            rs = (ResultSet)call.getObject(1);
            if (rs != null) {
                aduanas = new ArrayList<Aduana>();
                while (rs.next()) {
                    Aduana aduana = new Aduana();
                    aduana.setCodigo(rs.getString("CUO_COD"));
                    aduana.setDescripcion(rs.getString("CUO_NAM"));
                    aduanas.add(aduana);
                }
            }
        } catch (Exception e) {
            String error = e.getMessage();
        } finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return aduanas;
    }

    public List<Aduana> obtenerAduanas(String gerencia) throws SQLException, ClassNotFoundException, NamingException {
        List<Aduana> aduanas = null;
        try {
            open();
            call = cn.prepareCall("{ ? = call PKG_GENERAL.LISTA_ADUANAS (?) }");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, numeroGerencia(gerencia));
            call.execute();

            rs = (ResultSet)call.getObject(1);
            if (rs != null) {
                aduanas = new ArrayList<Aduana>();
                Aduana aduanaini = new Aduana();
                aduanaini.setCodigo("%");
                aduanaini.setDescripcion("Todas las Aduanas");
                aduanas.add(aduanaini);
                while (rs.next()) {
                    Aduana aduana = new Aduana();
                    aduana.setCodigo(rs.getString("CUO_COD"));
                    aduana.setDescripcion(rs.getString("CUO_NAM"));
                    aduanas.add(aduana);
                }
            }
        } catch (Exception e) {
            String error = e.getMessage();
        } finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return aduanas;
    }

    public List<Aduana> obtenerAduanas2(String gerencia) throws SQLException, ClassNotFoundException, NamingException {
        List<Aduana> aduanas = null;
        try {
            open();
            call = cn.prepareCall("{ ? = call PKG_GENERAL.LISTA_ADUANAS (?) }");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, numeroGerencia(gerencia));
            call.execute();

            rs = (ResultSet)call.getObject(1);
            if (rs != null) {
                aduanas = new ArrayList<Aduana>();
                while (rs.next()) {
                    Aduana aduana = new Aduana();
                    aduana.setCodigo(rs.getString("CUO_COD"));
                    aduana.setDescripcion(rs.getString("CUO_NAM"));
                    aduanas.add(aduana);
                }
            }
        } catch (Exception e) {
            String error = e.getMessage();
        } finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return aduanas;
    }

    public String devuelve_secuencia(String numero) throws SQLException, ClassNotFoundException, NamingException {
        String res = "";
        try {
            open();
            call = cn.prepareCall("{? = call ops$asy.carpetas.devuelve_secuencia(?) }");
            call.registerOutParameter(1, 12);
            call.setString(2, numero);
            call.execute();
            res = (String)call.getObject(1);

        } catch (Exception e) {
            String error = e.getMessage();
        } finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return res;
    }

    public String devuelve_asociado(String numero) throws SQLException, ClassNotFoundException, NamingException {
        String res = "";
        try {
            open();
            call = cn.prepareCall("{? = call ops$asy.carpetas.devuelve_asociado(?) }");
            call.registerOutParameter(1, 12);
            call.setString(2, numero);
            call.execute();
            res = (String)call.getObject(1);

        } catch (Exception e) {
            String error = e.getMessage();
        } finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return res;

    }

    public String devuelve_dui_asociado(String numero) throws SQLException, ClassNotFoundException, NamingException {
        String res = "";
        try {
            open();
            call = cn.prepareCall("{? = call ops$asy.carpetas.carpeta_asociada(?) }");
            call.registerOutParameter(1, 12);
            call.setString(2, numero);
            call.execute();
            res = (String)call.getObject(1);

        } catch (Exception e) {
            String error = e.getMessage();
        } finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return res;

    }

    public String asignacion_carpetas(String desde, String hasta, String aduana, String usuario) throws SQLException,
                                                                                                        ClassNotFoundException,
                                                                                                        NamingException {
        String res = "";
        try {
            open();
            call = cn.prepareCall("{call ops$asy.carpetas.asignacion_aduana(?,?,?,?,?) }");
            call.setString(1, desde);
            call.setString(2, hasta);
            call.setString(3, aduana);
            call.setString(4, usuario);
            call.registerOutParameter(5, 12);
            call.execute();
            res = (String)call.getObject(5);
        } catch (Exception e) {
            String error = e.getMessage();
        } finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return res;
    }

    public String es_despacho_directo(String nit) throws SQLException, ClassNotFoundException, NamingException {
        String res = "";
        try {
            open();
            call = cn.prepareCall("{? = call ops$asy.carpetas.es_despacho_directo(?) }");
            call.registerOutParameter(1, 12);
            call.setString(2, nit);
            call.execute();
            res = (String)call.getObject(1);

        } catch (Exception e) {
            String error = e.getMessage();
        } finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return res;
    }

}
