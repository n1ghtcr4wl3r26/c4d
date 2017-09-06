package anb.persistencia;


import anb.bean.MemorizacionControlForm;

import anb.entidades.Aduana;
import anb.entidades.Declaracion;
import anb.entidades.Nit;

import anb.general.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import oracle.jdbc.OracleTypes;


public class MemorizacionControlDao extends Conexion {
    public MemorizacionControlDao() {
        super();
    }

    public List<Nit> devuelveNit(String nit) throws SQLException, ClassNotFoundException, NamingException {
        List<Nit> params = new ArrayList<Nit>();
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_general.devuelve_datos_nit ( ? )}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, nit);
            call.execute();

            rs = (ResultSet)call.getObject(1);

            while (rs.next()) {
                Nit f = new Nit();
                f.setNit(rs.getString("NIT"));
                f.setRazon(rs.getString("RAZON"));
                f.setDireccion(rs.getString("DIRECCION"));
                f.setActividad(rs.getString("ACTIVIDAD"));
                f.setTipodoc(rs.getString("TIPODOC"));
                f.setNombre(rs.getString("NOMBRE"));
                f.setPaterno(rs.getString("PATERNO"));
                f.setMaterno(rs.getString("MATERNO"));
                params.add(f);
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return params;
    }
    
    public List<Declaracion> devuelveDatosDUI(String codigo) throws SQLException, ClassNotFoundException, NamingException {
        List<Declaracion> params = new ArrayList<Declaracion>();
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_general.devuelve_datos_dui ( ? )}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, codigo);
            call.execute();

            rs = (ResultSet)call.getObject(1);

            while (rs.next()) {
                Declaracion f = new Declaracion();
                f.setKey_year(rs.getString(1));
                f.setKey_cuo(rs.getString(2));
                f.setKey_dec(rs.getString(3));
                f.setKey_nber(rs.getString(4));
                f.setSad_reg_year(rs.getString(5));
                f.setSad_reg_serial(rs.getString(6));
                f.setSad_reg_nber(rs.getString(7));
                f.setSad_consignee(rs.getString(8));
                f.setSad_reg_date(rs.getString(9));
                f.setSad_itm_total(rs.getString(10));
                params.add(f);
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return params;
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

    public String grabaMemorizacionDiferido(MemorizacionControlForm bean) throws SQLException, ClassNotFoundException,
                                                                                 NamingException {
        String res;
        try {
            open();
            call =
cn.prepareCall("{ ? = call pkg_memorizacion.graba_memorizacion_diferido ( ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,? ,?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);

            call.setString(2, bean.getDifTipoDocumento());
            call.setString(3, bean.getDifNroDocumento());
            call.setString(4, bean.getDifFecDocumento());
            call.setString(5, bean.getDifDetDocumento());
            call.setString(6, bean.getDifRiesgoIdentificado());
            call.setString(7, bean.getDifTipoDocPersona());
            call.setString(8, bean.getDifNitEmpresa());
            call.setString(9, bean.getDifNomEmpresa());
            call.setString(10, bean.getDifNroCIPersona());
            call.setString(11, bean.getDifExpCIPersona());
            call.setString(12, bean.getDifNombrePersona());
            call.setString(13, bean.getDifApPatPersona());
            call.setString(14, bean.getDifApMatPersona());
            call.setString(15, bean.getDifDireccion());
            call.setString(16, bean.getDifActividad());
            call.setString(17, bean.getUsuario());
            call.setString(18, bean.getDifTipoOperador());

            call.setString(19, bean.getDifTribTodos());
            call.setString(20, bean.getDifTribGa());
            call.setString(21, bean.getDifTribIva());
            call.setString(22, bean.getDifTribIce());
            call.setString(23, bean.getDifTribIehd());
            call.setString(24, bean.getDifTribIcd());
            call.setString(25, bean.getDifTribNoaplica());
            call.setString(26, bean.getDifPeriodo());
            call.setString(27, bean.getDifRiesgoDelito());
            call.setString(28, bean.getDifRiesgoSubval());
            call.setString(29, bean.getDifRiesgoClas());
            call.setString(30, bean.getDifRiesgoContrab());
            call.setString(31, bean.getGerencia());
            call.execute();

            res = call.getString(1);

        } finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return res;
    }

    public String grabaMemorizacionPosterior(MemorizacionControlForm bean) throws SQLException, ClassNotFoundException,
                                                                                  NamingException {
        String res;
        try {
            open();
            call =
cn.prepareCall("{ ? = call pkg_memorizacion.graba_memorizacion_posterior ( ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,? ,?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);

            call.setString(2, bean.getPosTipoDocumento());
            call.setString(3, bean.getPosNroDocumento());
            call.setString(4, bean.getPosFecDocumento());
            call.setString(5, bean.getPosDetDocumento());
            call.setString(6, bean.getPosRiesgoIdentificado());
            call.setString(7, bean.getPosTipoDocPersona());
            call.setString(8, bean.getPosNitEmpresa());
            call.setString(9, bean.getPosNomEmpresa());
            call.setString(10, bean.getPosNroCIPersona());
            call.setString(11, bean.getPosExpCIPersona());
            call.setString(12, bean.getPosNombrePersona());
            call.setString(13, bean.getPosApPatPersona());
            call.setString(14, bean.getPosApMatPersona());
            call.setString(15, bean.getPosDireccion());
            call.setString(16, bean.getPosActividad());
            call.setString(17, bean.getUsuario());
            call.setString(18, bean.getPosTipoOperador());
            call.setString(19, bean.getPosTribTodos());
            call.setString(20, bean.getPosTribGa());
            call.setString(21, bean.getPosTribIva());
            call.setString(22, bean.getPosTribIce());
            call.setString(23, bean.getPosTribIehd());
            call.setString(24, bean.getPosTribIcd());
            call.setString(25, bean.getPosTribNoaplica());
            call.setString(26, bean.getPosPeriodo());
            call.setString(27, bean.getPosRiesgoDelito());
            call.setString(28, bean.getPosRiesgoSubval());
            call.setString(29, bean.getPosRiesgoClas());
            call.setString(30, bean.getPosRiesgoContrab());
            call.setString(31, bean.getGerencia());
            call.execute();

            res = call.getString(1);

        } finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return res;
    }

    public String grabaMemorizacionAmpliatoria(MemorizacionControlForm bean) throws SQLException,
                                                                                    ClassNotFoundException,
                                                                                    NamingException {
        String res;
        try {
            open();
            call =
cn.prepareCall("{ ? = call pkg_memorizacion.graba_memorizacion_ampliatoria ( ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getAmpGestion());
            call.setString(3, bean.getAmpGerencia());
            call.setString(4, bean.getAmpNumero());
            call.setString(5, bean.getAmpTipoDocPersona());
            call.setString(6, bean.getAmpNitEmpresa());
            call.setString(7, bean.getAmpNomEmpresa());
            call.setString(8, bean.getAmpNroCIPersona());
            call.setString(9, bean.getAmpExpCIPersona());
            call.setString(10, bean.getAmpNombrePersona());
            call.setString(11, bean.getAmpApPatPersona());
            call.setString(12, bean.getAmpApMatPersona());
            call.setString(13, bean.getAmpDireccion());
            call.setString(14, bean.getAmpActividad());
            call.setString(15, bean.getUsuario());
            call.setString(16, bean.getAmpTipoOperador());
            call.setString(17, bean.getAmpControl());
            call.execute();

            res = call.getString(1);

        } finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return res;
    }

    public List<Declaracion> consulta1(MemorizacionControlForm bean) throws SQLException, ClassNotFoundException,
                                                                            NamingException {
        List<Declaracion> decls = new ArrayList<Declaracion>();
        String voperador = "%";
        int cont = 1;
        if (!(bean.getFd2Importador() == null) && !(bean.getFd2Importador().equals(""))) {
            voperador = bean.getFd2Importador();
        }
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.devuelve_dif_duis1  ( ?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getFd1FecIni());
            call.setString(3, bean.getFd1FecFin());
            call.setString(4, bean.getFd1Aduana());
            call.setString(5, "");
            call.registerOutParameter(6, OracleTypes.CURSOR);
            call.execute();
            rs = (ResultSet)call.getObject(6);
            while (rs.next()) {
                Declaracion dec = new Declaracion();
                dec.setTramite(rs.getString(1));
                dec.setGestion(rs.getString(2));
                dec.setAduana(rs.getString(3));
                dec.setNumero(rs.getString(4));
                dec.setFechaRegistro(rs.getString(5));
                dec.setFechaValidacion(rs.getString(6));
                dec.setOperador(rs.getString(7));
                dec.setOperadorNombre(rs.getString(8));
                dec.setDeclarante(rs.getString(9));
                dec.setDeclaranteNombre(rs.getString(10));
                dec.setOrigen(rs.getString(11));
                dec.setCodigo(rs.getString(12));
                dec.setEstado(rs.getString(13));
                dec.setProveedor(rs.getString(15));
                dec.setCanal(rs.getString(17));

                dec.setFicha(rs.getString(18));
                dec.setFechaLevante(rs.getString(19));
                dec.setFechaPase(rs.getString(20));
                dec.setItems(rs.getString(21));
                dec.setPatron(rs.getString(22));
                
                dec.setSequencia(String.valueOf(cont++));
                if (dec.getEstado().substring(0, 7).equals("SICODIF")) {
                    dec.setVerifitem("1111");
                } else {
                    if (dec.getEstado().substring(0, 3).equals("FAP")) {
                        dec.setVerifitem("1111");
                    } else {
                        dec.setVerifitem(rs.getString(14));
                    }
                }
                decls.add(dec);
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return decls;
    }
    
    public List<Declaracion> consulta2(MemorizacionControlForm bean) throws SQLException, ClassNotFoundException,
                                                                            NamingException {
        List<Declaracion> decls = new ArrayList<Declaracion>();
        String voperador = "%";
        int cont = 1;
        if (!(bean.getFd2Importador() == null) && !(bean.getFd2Importador().equals(""))) {
            voperador = bean.getFd2Importador();
        }
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.devuelve_dif_duis2  ( ?,?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getFd2FecIni());
            call.setString(3, bean.getFd2FecFin());
            call.setString(4, bean.getFd2Aduana());
            call.setString(5, bean.getFd2Importador());
            call.setString(6, "");
            call.registerOutParameter(7, OracleTypes.CURSOR);
            call.execute();
            rs = (ResultSet)call.getObject(7);
            while (rs.next()) {
                Declaracion dec = new Declaracion();
                dec.setTramite(rs.getString(1));
                dec.setGestion(rs.getString(2));
                dec.setAduana(rs.getString(3));
                dec.setNumero(rs.getString(4));
                dec.setFechaRegistro(rs.getString(5));
                dec.setFechaValidacion(rs.getString(6));
                dec.setOperador(rs.getString(7));
                dec.setOperadorNombre(rs.getString(8));
                dec.setDeclarante(rs.getString(9));
                dec.setDeclaranteNombre(rs.getString(10));
                dec.setOrigen(rs.getString(11));
                dec.setCodigo(rs.getString(12));
                dec.setEstado(rs.getString(13));
                dec.setProveedor(rs.getString(15));
                dec.setCanal(rs.getString(17));

                dec.setFicha(rs.getString(18));
                dec.setFechaLevante(rs.getString(19));
                dec.setFechaPase(rs.getString(20));
                dec.setItems(rs.getString(21));
                dec.setPatron(rs.getString(22));

                dec.setSequencia(String.valueOf(cont++));
                if (dec.getEstado().substring(0, 7).equals("SICODIF")) {
                    dec.setVerifitem("1111");
                } else {
                    if (dec.getEstado().substring(0, 3).equals("FAP")) {
                        dec.setVerifitem("1111");
                    } else {
                        dec.setVerifitem(rs.getString(14));
                    }
                }
                decls.add(dec);
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return decls;
    }
    
    public List<Declaracion> consulta3(MemorizacionControlForm bean) throws SQLException, ClassNotFoundException,
                                                                            NamingException {
        List<Declaracion> decls = new ArrayList<Declaracion>();
        String voperador = "%";
        int cont = 1;
        if (!(bean.getFd2Importador() == null) && !(bean.getFd2Importador().equals(""))) {
            voperador = bean.getFd2Importador();
        }
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.devuelve_dif_duis3  ( ?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getFd3Gestion());
            call.setString(3, bean.getFd3Aduana());
            call.setString(4, bean.getFd3Numero());
            call.setString(5, "");
            call.registerOutParameter(6, OracleTypes.CURSOR);
            call.execute();
            rs = (ResultSet)call.getObject(6);
            while (rs.next()) {
                Declaracion dec = new Declaracion();
                dec.setTramite(rs.getString(1));
                dec.setGestion(rs.getString(2));
                dec.setAduana(rs.getString(3));
                dec.setNumero(rs.getString(4));
                dec.setFechaRegistro(rs.getString(5));
                dec.setFechaValidacion(rs.getString(6));
                dec.setOperador(rs.getString(7));
                dec.setOperadorNombre(rs.getString(8));
                dec.setDeclarante(rs.getString(9));
                dec.setDeclaranteNombre(rs.getString(10));
                dec.setOrigen(rs.getString(11));
                dec.setCodigo(rs.getString(12));
                dec.setEstado(rs.getString(13));
                dec.setProveedor(rs.getString(15));
                dec.setCanal(rs.getString(17));

                dec.setFicha(rs.getString(18));
                dec.setFechaLevante(rs.getString(19));
                dec.setFechaPase(rs.getString(20));
                dec.setItems(rs.getString(21));
                dec.setPatron(rs.getString(22));

                dec.setSequencia(String.valueOf(cont++));
                if (dec.getEstado().substring(0, 7).equals("SICODIF")) {
                    dec.setVerifitem("1111");
                } else {
                    if (dec.getEstado().substring(0, 3).equals("FAP")) {
                        dec.setVerifitem("1111");
                    } else {
                        dec.setVerifitem(rs.getString(14));
                    }
                }
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
