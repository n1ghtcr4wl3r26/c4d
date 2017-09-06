package anb.persistencia;


import anb.bean.AmpliacionForm;

import anb.entidades.Declaracion;
import anb.entidades.DeclaracionItem;
import anb.entidades.Tramite;

import anb.general.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import oracle.jdbc.OracleTypes;


public class AmpliacionDao extends Conexion {
    public AmpliacionDao() {
        super();
    }

    public List<Declaracion> declaracion(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                      NamingException {
            List<Declaracion> decls = new ArrayList<Declaracion>();
            String vpartida = "%";
            String vdeclarante = "%";
            String voperador = "%";
            String vemisor = "%";
            int cont = 1;     
            if(!(bean.getPartida() == null) && !(bean.getPartida().equals(""))){
                vpartida = bean.getPartida();
            }
            if(!(bean.getDeclarante() == null) && !(bean.getDeclarante().equals(""))){
                vdeclarante = bean.getDeclarante();
            }
            if(!(bean.getOperador() == null) && !(bean.getOperador().equals(""))){
                voperador = bean.getOperador();
            }
            if(!(bean.getEmisor() == null) && !(bean.getEmisor().equals(""))){
                vemisor = bean.getEmisor();
            }
            try {
                open();
                call = cn.prepareCall("{ ? = call pkg_memorizacion.devuelve_duis ( ?,?,?,?,?, ?,?,?,?,?,?)}");
                call.registerOutParameter(1, OracleTypes.VARCHAR);
                call.setString(2, bean.getFecIni());
                call.setString(3, bean.getFecFin());
                call.setString(4, bean.getAduana());
                call.setString(5, vpartida);
                call.setString(6, vdeclarante);
                call.setString(7, voperador);
                call.setString(8, vemisor);
                call.setString(9, bean.getOrigen());
                call.setString(10, bean.getTipoTramite());
                call.setString(11, bean.getUsuarioger());
                call.registerOutParameter(12, OracleTypes.CURSOR);
                call.execute();
                rs = (ResultSet)call.getObject(12);
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
                    dec.setProveedor(rs.getString(5));
                    dec.setFechaPase(rs.getString(5));
                    dec.setCanal(rs.getString(17));
                    dec.setFicha(rs.getString(18));
                    dec.setSequencia(String.valueOf(cont++));
                    if(dec.getEstado().substring(0,7).equals("SICODIF")){
                        dec.setVerifitem("1111");
                    } else {
                        if(dec.getEstado().substring(0,3).equals("FAP")){
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
    
    public List<DeclaracionItem> declaracionItem(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        List<DeclaracionItem> decls = new ArrayList<DeclaracionItem>();
        String vpartida = "%";
        String vdeclarante = "%";
        String voperador = "%";
        String vemisor = "%";
        int cont = 1;
        if(!(bean.getPartida() == null) && !(bean.getPartida().equals(""))){
            vpartida = bean.getPartida();
        }
        if(!(bean.getDeclarante() == null) && !(bean.getDeclarante().equals(""))){
            vdeclarante = bean.getDeclarante();
        }
        if(!(bean.getOperador() == null) && !(bean.getOperador().equals(""))){
            voperador = bean.getOperador();
        }
        if(!(bean.getEmisor() == null) && !(bean.getEmisor().equals(""))){
            vemisor = bean.getEmisor();
        }
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.devuelve_duis_item ( ?,?,?,?,?, ?,?,?,?,? ,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getFecIni());
            call.setString(3, bean.getFecFin());
            call.setString(4, bean.getAduana());
            call.setString(5, vpartida);
            call.setString(6, vdeclarante);
            call.setString(7, voperador);
            call.setString(8, vemisor);
            call.setString(9, bean.getOrigen());
            call.setString(10, bean.getTipoTramite());
            call.setString(11, bean.getUsuarioger());
            call.registerOutParameter(12, OracleTypes.CURSOR);
            call.execute();
            rs = (ResultSet)call.getObject(12);
            while (rs.next()) {
                DeclaracionItem dec = new DeclaracionItem();
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
                dec.setProveedor(rs.getString(5));
                dec.setFechaPase(rs.getString(5));
                dec.setSequencia(String.valueOf(cont++));
                dec.setItem(rs.getString(14));
                if(dec.getEstado().substring(0,7).equals("SICODIF")){
                    dec.setVerifitem("1111");
                } else {
                    if(dec.getEstado().substring(0,3).equals("FAP")){
                        dec.setVerifitem("1111");
                    } else {
                        dec.setVerifitem(rs.getString(15));
                    }    
                }   
                dec.setPartida(rs.getString(16));
                dec.setProveedor(rs.getString(17));
                dec.setDescripcion(rs.getString(18));
                dec.setCanal(rs.getString(19));
                dec.setFicha(rs.getString(20));
                decls.add(dec);
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return decls;
    }
    
    public List<Tramite> tramites(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        List<Tramite> decls = new ArrayList<Tramite>();
        int cont = 1;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.devuelve_tramites ( ?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.registerOutParameter(3, OracleTypes.CURSOR);
            call.execute();
            rs = (ResultSet)call.getObject(3);
            while (rs.next()) {
                Tramite dec = new Tramite();
                dec.setCodigo(rs.getString(1));
                dec.setTipoTramite(rs.getString(2));
                dec.setTramite(rs.getString(3));
                if(rs.getString(4).equals("ITEM")){
                    dec.setObservacion(rs.getString(5)+" "+rs.getString(4));
                }
                else{
                    dec.setObservacion(rs.getString(4));
                }
                dec.setNumero(String.valueOf(cont++));
                decls.add(dec);
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return decls;
    }
    
    public List<Tramite> tramitespadreamp(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        List<Tramite> decls = new ArrayList<Tramite>();
        int cont = 1;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.devuelve_tramitespadreamp ( ?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.registerOutParameter(3, OracleTypes.CURSOR);
            call.execute();
            rs = (ResultSet)call.getObject(3);
            while (rs.next()) {
                Tramite dec = new Tramite();
                dec.setCodigo(rs.getString(1));
                dec.setTipoTramite(rs.getString(2));
                dec.setTramite(rs.getString(3));
                if(rs.getString(4).equals("ITEM")){
                    dec.setObservacion(rs.getString(5)+" "+rs.getString(4));
                }
                else{
                    dec.setObservacion(rs.getString(4));
                }
                dec.setNumero(String.valueOf(cont++));
                dec.setEstado(rs.getString(7));
                decls.add(dec);
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return decls;
    }
    
    public List<Tramite> tramitesPadreAmpliatoria(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        List<Tramite> decls = new ArrayList<Tramite>();
        int cont = 1;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.devuelve_tramites ( ?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.registerOutParameter(3, OracleTypes.CURSOR);
            call.execute();
            rs = (ResultSet)call.getObject(3);
            while (rs.next()) {
                Tramite dec = new Tramite();
                dec.setCodigo(rs.getString(1));
                dec.setTipoTramite(rs.getString(2));
                dec.setTramite(rs.getString(3));
                if(rs.getString(4).equals("ITEM")){
                    dec.setObservacion(rs.getString(5)+" "+rs.getString(4));
                }
                else{
                    dec.setObservacion(rs.getString(4));
                }
                dec.setNumero(String.valueOf(cont++));
                decls.add(dec);
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return decls;
    }
    public List<Tramite> tramitesAmpliatoria(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        List<Tramite> decls = new ArrayList<Tramite>();
        int cont = 1;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.devuelve_tramitesamp ( ?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.registerOutParameter(3, OracleTypes.CURSOR);
            call.execute();
            rs = (ResultSet)call.getObject(3);
            while (rs.next()) {
                Tramite dec = new Tramite();
                dec.setCodigo(rs.getString(1));
                dec.setTipoTramite(rs.getString(2));
                dec.setTramite(rs.getString(3));
                if(rs.getString(4).equals("ITEM")){
                    dec.setObservacion(rs.getString(5)+" "+rs.getString(4));
                }
                else{
                    dec.setObservacion(rs.getString(4));
                }
                dec.setNumero(String.valueOf(cont++));
                decls.add(dec);
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return decls;
    }
    
    public List<Tramite> tramitesrep(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        List<Tramite> decls = new ArrayList<Tramite>();
        int cont = 1;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.devuelve_tramitesrepampliacion ( ?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.registerOutParameter(3, OracleTypes.CURSOR);
            call.execute();
            rs = (ResultSet)call.getObject(3);
            while (rs.next()) {
                Tramite dec = new Tramite();
                dec.setCodigo(rs.getString(1));
                dec.setTipoTramite(rs.getString(2));
                dec.setTramite(rs.getString(3));
                dec.setObservacion(rs.getString(4));
                dec.setItem(rs.getString(6));
                dec.setValor(rs.getString(7));
                dec.setOrigen(rs.getString(8));
                dec.setPartida(rs.getString(9));
                dec.setOtro(rs.getString(10));
                dec.setFecha(rs.getString(11));
                dec.setCodigoItem(rs.getString(12));
                dec.setNumero(String.valueOf(cont++));
                dec.setTipoEtapa(rs.getString(13));
                decls.add(dec);
            }
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return decls;
    }
    
    public String graba_tramites_selec(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            /*call = cn.prepareCall("{ ? = call pkg_memorizacion.graba_duis_selec ( ?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getCodigoconcat());
            call.setString(4, bean.getTipoTramite());
            call.setString(5, bean.getUsuario());
            call.setString(6, "AMPLIATORIA");*/
            
            call = cn.prepareCall("{ ? = call pkg_memorizacion.graba_duis_selec2 ( ?,?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getCodigoconcat());
            call.setString(4, bean.getTipoTramite());
            call.setString(5, bean.getUsuario());
            call.setString(6, "AMPLIATORIA"); 
            call.setString(7, bean.getNumeroOperador());
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public String graba_tramite_dec(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.graba_tram_dec ( ?,?,?,?,? ,?,?,?  ,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getTipoTramite());
            call.setString(4, bean.getGestion());
            call.setString(5, bean.getAduana());
            call.setString(6, bean.getNumero());
            call.setString(7, bean.getNumeroOperador());
            call.setString(8, "AMPLIATORIA"); 
            call.setString(9, bean.getUsuario());
            call.setString(10, bean.getChvalor());
            call.setString(11, bean.getChpartida());
            call.setString(12, bean.getChorigen());
            call.setString(13, bean.getChotro());
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public String graba_tramite_factura(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.graba_tramite_factura ( ?,?,?,?,? ,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, "FACTURA");
            call.setString(4, bean.getFacnumero());
            call.setString(5, bean.getFacfecha());
            call.setString(6, bean.getFacemisor());
            call.setString(7, bean.getOrigen());
            call.setString(8, bean.getUsuario()); 
            call.setString(9, "AMPLIATORIA");
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public String graba_tramite_transferencia(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.graba_tramite_transferencia ( ?,?,?,?,? ,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, "TRANSFERENCIA");
            call.setString(4, bean.getTragestion());
            call.setString(5, bean.getTrafecha());
            call.setString(6, bean.getTraemisor());
            call.setString(7, bean.getUsuario()); 
            call.setString(8, "AMPLIATORIA");
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public String graba_tramite_otro(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.graba_tramite_otro ( ?,?,?,?,? ,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, "OTROS");
            call.setString(4, bean.getOtrgestion());
            call.setString(5, bean.getOtrfecha());
            call.setString(6, bean.getOtremisor());
            call.setString(7, bean.getOtrtipoDoc());
            call.setString(8, bean.getUsuario()); 
            call.setString(9, "AMPLIATORIA");
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public String graba_tramites_selec_item(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.graba_duis_selecitem ( ?,?,?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getCodigoconcatval());
            call.setString(4, bean.getCodigoconcatpar());
            call.setString(5, bean.getCodigoconcatori());
            call.setString(6, bean.getTipoTramite());
            call.setString(7, bean.getUsuario());
            call.setString(8, "AMPLIATORIA");
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public String graba_tramites_selec_itemval(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.graba_duis_selecitemval ( ?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getCodigoconcatval());
            call.setString(4, bean.getTipoTramite());
            call.setString(5, bean.getUsuario());
            call.setString(6, "AMPLIATORIA");
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public String graba_tramites_selec_itemotr(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.graba_duis_selecitemotr ( ?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getCodigoconcatotr());
            call.setString(4, bean.getTipoTramite());
            call.setString(5, bean.getUsuario());
            call.setString(6, "AMPLIATORIA");
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public String graba_tramites_selec_itempar(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.graba_duis_selecitempar ( ?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getCodigoconcatpar());
            call.setString(4, bean.getTipoTramite());
            call.setString(5, bean.getUsuario());
            call.setString(6, "AMPLIATORIA");
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public String graba_tramites_selec_itemori(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.graba_duis_selecitempori ( ?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getCodigoconcatori());
            call.setString(4, bean.getTipoTramite());
            call.setString(5, bean.getUsuario());
            call.setString(6, "AMPLIATORIA");
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    
    
    
    
    
    public String graba_tramites_selec_decval(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.graba_duis_selecdecval ( ?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getCodigoconcatval());
            call.setString(4, bean.getTipoTramite());
            call.setString(5, bean.getUsuario());
            call.setString(6, "AMPLIATORIA");
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public String graba_tramites_selec_amp(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.graba_duis_selecdecamp ( ?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getCodigoconcatval());
            call.setString(4, bean.getTipoTramite());
            call.setString(5, bean.getUsuario());
            call.setString(6, "AMPLIATORIA");
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    
    public String graba_tramites_selec_decotr(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.graba_duis_selecdecotr ( ?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getCodigoconcatotr());
            call.setString(4, bean.getTipoTramite());
            call.setString(5, bean.getUsuario());
            call.setString(6, "AMPLIATORIA");
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public String graba_tramites_selec_decpar(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.graba_duis_selecdecpar ( ?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getCodigoconcatpar());
            call.setString(4, bean.getTipoTramite());
            call.setString(5, bean.getUsuario());
            call.setString(6, "AMPLIATORIA");
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public String graba_tramites_selec_decori(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.graba_duis_selecdecori ( ?,?,?,?,?)}");
            call.registerOutParameter(1, OracleTypes.VARCHAR);
            call.setString(2, bean.getCodigo());
            call.setString(3, bean.getCodigoconcatori());
            call.setString(4, bean.getTipoTramite());
            call.setString(5, bean.getUsuario());
            call.setString(6, "AMPLIATORIA");
            call.execute();
            res = (String)call.getObject(1);
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return res;
    }
    
    public String borra_tramite_selec(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.borra_tramite_selec ( ?,?)}");
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
    
    public String borra_tramite_selecitem(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.borra_tramite_selecitem ( ?,?)}");
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
    
    public String borra_tramite_todo(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.borra_tramite_todo_amp ( ?,?)}");
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
    
    public String borra_tramite_selecamp(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.borra_tramite_selecamp ( ?,?)}");
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
    
    public String verifica_registra_control(AmpliacionForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_memorizacion.verifica_ampliacion_control ( ?,?)}");
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
    
} 