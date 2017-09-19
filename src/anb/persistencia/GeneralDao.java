package anb.persistencia;


import anb.entidades.Aduana;
import anb.entidades.Fiscalizador;
import anb.entidades.Gerencia;
import anb.entidades.InfoControl;
import anb.entidades.Paises;
import anb.entidades.Tramite;

import anb.general.Conexion;
import anb.general.Util;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import oracle.jdbc.OracleTypes;


public class GeneralDao extends Conexion{
    public GeneralDao() {
        super();
    }
    
    public String devuelve_maximo() throws SQLException, ClassNotFoundException, NamingException {
        String res = "";
        try {
            open();
            call = cn.prepareCall("{? = call ops$asy.carpetas.devuelve_maximo() }");
            call.registerOutParameter(1, 12);
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
           res = (String) call.getObject(1);
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
        } catch (Exception e){
            String error = e.getMessage();
        }
        finally {
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
        } catch (Exception e){
            String error = e.getMessage();
        }
        finally {
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
            call.setString(2, Util.numeroGerencia(gerencia));
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
        } catch (Exception e){
            String error = e.getMessage();
        }
        finally {
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
            call.setString(2, Util.numeroGerencia(gerencia));
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
        } catch (Exception e){
            String error = e.getMessage();
        }
        finally {
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

    
    public List<Paises> obtenerPaises() throws SQLException, ClassNotFoundException, NamingException {
        List<Paises> paises = null;
        try {
            open();
            call = cn.prepareCall("{ ? = call PKG_GENERAL.LISTA_PAISES }");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.execute();

            rs = (ResultSet)call.getObject(1);
            if (rs != null) {
                paises = new ArrayList<Paises>();
                Paises paisini = new Paises();
                paisini.setCodigo("%");
                paisini.setDescripcion("Todos los Paises");
                paises.add(paisini);
                
                while (rs.next()) {
                    Paises pais = new Paises();
                    pais.setCodigo(rs.getString(1));
                    pais.setDescripcion(rs.getString(2));
                    paises.add(pais);
                }
            }
        } catch (Exception e){
            String error = e.getMessage();
        }
        finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return paises;
    }
    
    public List<Paises> obtenerPaises2() throws SQLException, ClassNotFoundException, NamingException {
        List<Paises> paises = null;
        try {
            open();
            call = cn.prepareCall("{ ? = call PKG_GENERAL.LISTA_PAISES }");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.execute();

            rs = (ResultSet)call.getObject(1);
            if (rs != null) {
                paises = new ArrayList<Paises>();
                
                while (rs.next()) {
                    Paises pais = new Paises();
                    pais.setCodigo(rs.getString(1));
                    pais.setDescripcion(rs.getString(2));
                    paises.add(pais);
                }
            }
        } catch (Exception e){
            String error = e.getMessage();
        }
        finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return paises;
    }
    
    public InfoControl devuelveControl(String codigo) throws SQLException, ClassNotFoundException, NamingException {
       InfoControl inf = new InfoControl();       
       try {
           open();
           call = cn.prepareCall("{ ? = call pkg_general.devuelve_datos_control ( ? )}");
           call.registerOutParameter(1, OracleTypes.CURSOR);
           call.setString(2, codigo);
           call.execute();
           rs = (ResultSet) call.getObject(1);
           
           while (rs.next()) {
               inf.setCodigo(rs.getString(1));
               inf.setCodigoControl(rs.getString(2));
               inf.setTipoControl(rs.getString(3));
               String obs = rs.getString(4);
               if(obs.equals("DECLARACION"))
                    obs = "DECLARACI&Oacute;N";
               inf.setTipoDocumento(obs);
               inf.setNroDocumento(rs.getString(5));
               inf.setFecDocumento(rs.getString(6));
               inf.setDetDocumento(rs.getString(7));
               inf.setRiesgoIdentificado(rs.getString(8));
               inf.setEstado(rs.getString(9));
               inf.setTipoDocIdentificacion(rs.getString(10));
               inf.setDocIdentificacion(rs.getString(11));
               inf.setNomIdentificacion(rs.getString(12));
               inf.setDireccion(rs.getString(13));
               inf.setActividad(rs.getString(14));    
               inf.setGa(rs.getString(15));
               inf.setIva(rs.getString(16));
               inf.setIce(rs.getString(17));
               inf.setIehd(rs.getString(18));
               inf.setIcd(rs.getString(19));
               inf.setNoaplica(rs.getString(20));
               inf.setPeriodo(rs.getString(21));
               inf.setFechaRegistro(rs.getString(22));
               inf.setTipoOperador(rs.getString(23));
               inf.setInn_plazo_conclusion(rs.getString(24));
               inf.setInn_1(rs.getString(25));
               inf.setInn_2(rs.getString(26));
               inf.setInn_3(rs.getString(27));
               inf.setInn_4(rs.getString(28));
               inf.setInn_5(rs.getString(29));
               inf.setInn_6(rs.getString(30));
               inf.setInn_7(rs.getString(31));
               inf.setInn_8(rs.getString(32));
               inf.setInn_9(rs.getString(33));
               inf.setInn_10(rs.getString(34));
               
               inf.setInn_11(rs.getString(35));
               inf.setInn_12(rs.getString(36));
               inf.setInn_13(rs.getString(37));
               inf.setInn_14(rs.getString(38));
               inf.setInn_15(rs.getString(39));
               inf.setInn_16(rs.getString(40));
               inf.setInn_17(rs.getString(41));
               inf.setInn_18(rs.getString(42));
               inf.setInn_19(rs.getString(43));
               inf.setInn_20(rs.getString(44));
               inf.setInn_21(rs.getString(45));
               
               inf.setInnv_12(rs.getString(46));
               inf.setInnv_13(rs.getString(47));
               inf.setInnv_14(rs.getString(48));
               inf.setInnv_15(rs.getString(49));
               inf.setInnv_16(rs.getString(50));
               inf.setInnv_17(rs.getString(51));
               inf.setInnv_18(rs.getString(52));
               inf.setInnv_19(rs.getString(53));
               inf.setInnv_20(rs.getString(54));
               inf.setInnv_21(rs.getString(55));
               inf.setTipoEmpresa(rs.getString(56));
               
               inf.setDoc_con_tipo(rs.getString(57));
               inf.setDoc_con_numero(rs.getString(58));
               inf.setDoc_con_fecha(rs.getString(59));
               inf.setDoc_con_usuario(rs.getString(60));
               inf.setDoc_con_fecreg(rs.getString(61));
               
               inf.setPeriodosolicitar(rs.getString(62));
               inf.setRiesgoDelito(rs.getString(63));
               inf.setRiesgoSubval(rs.getString(64));
               inf.setRiesgoClas(rs.getString(65));
               inf.setRiesgoContrab(rs.getString(66));

            }
       } finally {
           if (cn != null) {
               cn.close();
           }
       }
       return inf;
    }
    
    public List<Fiscalizador> obtenerFiscalizadores(String Gerencia) throws SQLException, ClassNotFoundException, NamingException {
        List<Fiscalizador> fiscalizadores = null;
        try {
            open();
            call = cn.prepareCall("{ ? = call PKG_GENERAL.lista_fiscalizadores (?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, Gerencia);
            call.execute();

            rs = (ResultSet)call.getObject(1);
            if (rs != null) {
                fiscalizadores = new ArrayList<Fiscalizador>();
                while (rs.next()) {
                    Fiscalizador fis = new Fiscalizador();
                    fis.setCodigo(rs.getString("codigo"));
                    fis.setNombre(rs.getString("nombre"));
                    fis.setCi(rs.getString("ci"));
                    fiscalizadores.add(fis);
                }
            }
        } catch (Exception e){
            String error = e.getMessage();
        }
        finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return fiscalizadores;
    }
    
    public List<Fiscalizador> obtenerFiscalizadoresT(String Gerencia) throws SQLException, ClassNotFoundException, NamingException {
        List<Fiscalizador> fiscalizadores = null;
        try {
            open();
            call = cn.prepareCall("{ ? = call PKG_GENERAL.lista_fiscalizadores (?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, Gerencia);
            call.execute();

            rs = (ResultSet)call.getObject(1);
            if (rs != null) {
                fiscalizadores = new ArrayList<Fiscalizador>();
                Fiscalizador fisa = new Fiscalizador();
                fisa.setCodigo("%");
                fisa.setNombre("Todos");
                fiscalizadores.add(fisa);
                while (rs.next()) {
                    Fiscalizador fis = new Fiscalizador();
                    fis.setCodigo(rs.getString("codigo"));
                    fis.setNombre(rs.getString("nombre"));
                    fis.setCi(rs.getString("ci"));
                    fiscalizadores.add(fis);
                }
            }
        } catch (Exception e){
            String error = e.getMessage();
        }
        finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return fiscalizadores;
    }
    
    public List<Fiscalizador> obtenerSupervisores(String Gerencia) throws SQLException, ClassNotFoundException, NamingException {
        List<Fiscalizador> fiscalizadores = null;
        try {
            open();
            call = cn.prepareCall("{ ? = call PKG_GENERAL.lista_supervisores (?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, Gerencia);
            call.execute();

            rs = (ResultSet)call.getObject(1);
            if (rs != null) {
                fiscalizadores = new ArrayList<Fiscalizador>();
                while (rs.next()) {
                    Fiscalizador fis = new Fiscalizador();
                    fis.setCodigo(rs.getString("codigo"));
                    fis.setNombre(rs.getString("nombre"));
                    fis.setCi(rs.getString("ci"));
                    fiscalizadores.add(fis);
                }
            }
        } catch (Exception e){
            String error = e.getMessage();
        }
        finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return fiscalizadores;
    }
    
    public List<Fiscalizador> obtenerSupervisoresT(String Gerencia) throws SQLException, ClassNotFoundException, NamingException {
        List<Fiscalizador> fiscalizadores = null;
        try {
            open();
            call = cn.prepareCall("{ ? = call PKG_GENERAL.lista_supervisores (?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, Gerencia);
            call.execute();

            rs = (ResultSet)call.getObject(1);
            if (rs != null) {
                fiscalizadores = new ArrayList<Fiscalizador>();
                Fiscalizador fisa = new Fiscalizador();
                fisa.setCodigo("%");
                fisa.setNombre("Todos");
                fiscalizadores.add(fisa);
                while (rs.next()) {
                    Fiscalizador fis = new Fiscalizador();
                    fis.setCodigo(rs.getString("codigo"));
                    fis.setNombre(rs.getString("nombre"));
                    fiscalizadores.add(fis);
                }
            }
        } catch (Exception e){
            String error = e.getMessage();
        }
        finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return fiscalizadores;
    }
    
    public List<Fiscalizador> obtenerFuncionarios(String Gerencia) throws SQLException, ClassNotFoundException, NamingException {
        List<Fiscalizador> fiscalizadores = null;
        try {
            open();
            call = cn.prepareCall("{ ? = call PKG_GENERAL.lista_funcionarios (?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, Gerencia);
            call.execute();

            rs = (ResultSet)call.getObject(1);
            if (rs != null) {
                fiscalizadores = new ArrayList<Fiscalizador>();
                while (rs.next()) {
                    Fiscalizador fis = new Fiscalizador();
                    fis.setCodigo(rs.getString("codigo"));
                    fis.setNombre(rs.getString("nombre"));
                    fis.setCi(rs.getString("ci"));
                    fiscalizadores.add(fis);
                }
            }
        } catch (Exception e){
            String error = e.getMessage();
        }
        finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return fiscalizadores;
    }
    
    
    public List<Gerencia> obtenerGerencias(String Gerencia) throws SQLException, ClassNotFoundException, NamingException {
        List<Gerencia> gerencias = null;
        try {
            open();
            call = cn.prepareCall("{ ? = call PKG_GENERAL.lista_gerencias (?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, Gerencia);
            call.execute();

            rs = (ResultSet)call.getObject(1);
            if (rs != null) {
                gerencias = new ArrayList<Gerencia>();
                while (rs.next()) {
                    Gerencia ger = new Gerencia();
                    ger.setCodigo(rs.getString("codigo"));
                    ger.setDescripcion(rs.getString("descripcion"));
                    gerencias.add(ger);
                }
            }
        } catch (Exception e){
            String error = e.getMessage();
        }
        finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return gerencias;
    }
    
    public List<Fiscalizador> devuelveFisAsignados(String codigo) throws SQLException, ClassNotFoundException, NamingException {
        List<Fiscalizador> fiscalizadores = null;
        int cont = 1;        
        try {
            open();
            call = cn.prepareCall("{ ? = call PKG_GENERAL.devuelve_fis_asignados (?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, codigo);
            call.execute();

            rs = (ResultSet)call.getObject(1);
            if (rs != null) {
                fiscalizadores = new ArrayList<Fiscalizador>();
                while (rs.next()) {
                    Fiscalizador fis = new Fiscalizador();
                    fis.setId(rs.getString("id"));
                    fis.setCodigo(rs.getString("codigo"));
                    fis.setNombre(rs.getString("nombre"));
                    fis.setCargo(rs.getString("cargo"));
                    fis.setFechaasig(rs.getString("fecha"));
                    fis.setUsuasig(rs.getString("usuario"));
                    fis.setCi(rs.getString("ci"));
                    fis.setNumero(String.valueOf(cont++));
                    fiscalizadores.add(fis);
                }
            }
        } catch (Exception e){
            String error = e.getMessage();
        }
        finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return fiscalizadores;
    }
    
    public List<Fiscalizador> devuelveFisAccesos(String codigo) throws SQLException, ClassNotFoundException, NamingException {
        List<Fiscalizador> fiscalizadores = null;
        int cont = 1;        
        try {
            open();
            call = cn.prepareCall("{ ? = call PKG_GENERAL.devuelve_fis_accesos (?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, codigo);
            call.execute();

            rs = (ResultSet)call.getObject(1);
            if (rs != null) {
                fiscalizadores = new ArrayList<Fiscalizador>();
                while (rs.next()) {
                    Fiscalizador fis = new Fiscalizador();
                    fis.setId(rs.getString("id"));
                    fis.setCodigo(rs.getString("codigo"));
                    fis.setNombre(rs.getString("nombre"));
                    fis.setCargo(rs.getString("cargo"));
                    fis.setFechaasig(rs.getString("fecha"));
                    fis.setUsuasig(rs.getString("usuario"));
                    fis.setCi(rs.getString("ci"));
                    fis.setNumero(String.valueOf(cont++));
                    fiscalizadores.add(fis);
                }
            }
        } catch (Exception e){
            String error = e.getMessage();
        }
        finally {
            if (!esTransaccional()) {
                close();
            }
        }
        return fiscalizadores;
    }
    
    public List<Tramite> tramites(String codigo) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        List<Tramite> decls = new ArrayList<Tramite>();
        int cont = 1;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.devuelve_tramites ( ?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, codigo);
            call.registerOutParameter(3, OracleTypes.CURSOR);
            call.execute();
            rs = (ResultSet)call.getObject(3);
            while (rs.next()) {
                Tramite dec = new Tramite();
                dec.setCodigo(rs.getString(1));
                dec.setTipoTramite(rs.getString(2));
                dec.setTramite(rs.getString(3));
                
                String obs = rs.getString(4);
                if(obs.equals("DECLARACION"))
                    obs = "DECLARACI&Oacute;N";
                if(obs.equals("TRAMITE"))
                    obs = "TR&Aacute;MITE";
                if(obs.equals("ITEM"))
                    obs = "&Iacute;TEM";
                dec.setObservacion(obs);
                
                dec.setNumero(String.valueOf(cont++));
                dec.setTipoAlcance(rs.getString(6));
                decls.add(dec);
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return decls;
    }
    
    public List<Tramite> tramitesxls(String codigo) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        List<Tramite> decls = new ArrayList<Tramite>();
        int cont = 1;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.devuelve_tramites ( ?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, codigo);
            call.registerOutParameter(3, OracleTypes.CURSOR);
            call.execute();
            rs = (ResultSet)call.getObject(3);
            while (rs.next()) {
                String obs = rs.getString(4);
                if(obs.equals("DECLARACION") || obs.equals("ITEM")){
                    Tramite dec = new Tramite();
                    dec.setCodigo(rs.getString(1));
                    dec.setTipoTramite(rs.getString(2));
                    dec.setTramite(rs.getString(3));
                    if(obs.equals("DECLARACION"))
                        obs = "DECLARACI&Oacute;N";
                    if(obs.equals("TRAMITE"))
                        obs = "TR&Aacute;MITE";
                    if(obs.equals("ITEM"))
                        obs = "&Iacute;TEM";
                    dec.setObservacion(obs);                
                    dec.setNumero(String.valueOf(cont++));
                    dec.setTipoAlcance(rs.getString(6));
                    decls.add(dec);
                }
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return decls;
    }
    
    public String devuelveCodigo(String gestion,String tipo, String gerencia, String numero) throws SQLException, ClassNotFoundException, NamingException {
       String res;
       try {
           open();
           call = cn.prepareCall("{ ? = call pkg_general.devuelve_codigo ( ?,?,?,? )}");
           call.registerOutParameter(1, OracleTypes.VARCHAR);
           call.setString(2, gestion);
           call.setString(3, tipo);
           call.setString(4, gerencia);
           call.setString(5, numero);
           call.execute();
           res = (String) call.getObject(1);
       } finally {
           if (cn != null) {
               cn.close();
           }
       }
       return res;
    }
    
    public Boolean mostrar_botones(String gestion,String usuario, String opcion) throws SQLException, ClassNotFoundException, NamingException {
       Boolean res;
       String valor;
       try {
           open();
           call = cn.prepareCall("{ ? = call pkg_general.mostrar_botones ( ?,?,? )}");
           call.registerOutParameter(1, OracleTypes.VARCHAR);
           call.setString(2, gestion);
           call.setString(3, usuario);
           call.setString(4, opcion);
           call.execute();
           valor = (String) call.getObject(1);
           if(valor.equals("MOSTRAR")){
               res = true;    
           } else {
               res = false;
           }
       } finally {
           if (cn != null) {
               cn.close();
           }
       }
       return res;
    }
    
    public Boolean esFechaMenorIgualAHoy(String fecha) throws SQLException, ClassNotFoundException, NamingException {
        Boolean res;
        String valor;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_general.esFechaMenorIgualAHoy ( ? )}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, fecha);
            call.execute();
            valor = (String) call.getObject(1);
            if(valor.equals("CORRECTO")){
                res = true;    
            } else {
                res = false;
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;        
    }
    
    public Boolean esFecha(String fecha) throws SQLException, ClassNotFoundException, NamingException {
        Boolean res;
        int valor;
        //es fecha 0 es verdad y 1 es falso
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_general.valida_fecha ( ? )}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, fecha);
            call.execute();
            valor = Integer.parseInt((String)call.getObject(1));
            if(valor == 0){
                res = true;    
            } else {
                res = false;
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;        
    }
    
    public Boolean mostrar_botones_concluir(String codigo,String usuario, String opcion) throws SQLException, ClassNotFoundException, NamingException {
       Boolean res;
       String valor;
       try {
           open();
           call = cn.prepareCall("{ ? = call pkg_general.mostrar_botones_concluir ( ?,?,? )}");
           call.registerOutParameter(1, OracleTypes.VARCHAR);
           call.setString(2, codigo);
           call.setString(3, usuario);
           call.setString(4, opcion);
           call.execute();
           valor = (String) call.getObject(1);
           if(valor.equals("MOSTRAR")){
               res = true;    
           } else {
               res = false;
           }
       } finally {
           if (cn != null) {
               cn.close();
           }
       }
       return res;
    }
    
    public Boolean llenar_valores(String gestion,String usuario, String opcion, String nivel) throws SQLException, ClassNotFoundException, NamingException {
       Boolean res;
       String valor;
       try {
           open();
           call = cn.prepareCall("{ ? = call pkg_general.llenar_valores ( ?,?,?,? )}");
           call.registerOutParameter(1, OracleTypes.VARCHAR);
           call.setString(2, gestion);
           call.setString(3, usuario);
           call.setString(4, opcion);
           call.setString(5, nivel);
           call.execute();
           valor = (String) call.getObject(1);
           if(valor.equals("LLENAR")){
               res = true;    
           } else {
               res = false;
           }
       } finally {
           if (cn != null) {
               cn.close();
           }
       }
       return res;
    }
    
    public String verificaAccesoUsuario(String idControl,String usuario, String opcion, String gerencia) throws SQLException, ClassNotFoundException, NamingException {
       String res;
       try {
           open();
           call = cn.prepareCall("{ ? = call pkg_general.verifica_acceso ( ?,?,?,? )}");
           call.registerOutParameter(1, OracleTypes.VARCHAR);
           call.setString(2, idControl);
           call.setString(3, usuario);
           call.setString(4, opcion);
           call.setString(5, gerencia);
           call.execute();
           res = (String) call.getObject(1);
       } finally {
           if (cn != null) {
               cn.close();
           }
       }
       return res;
    }
}
