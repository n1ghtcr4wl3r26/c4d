package anb.negocio;


import anb.bean.TributosOmitidosForm;

import anb.entidades.TributosOmitidos;
import anb.entidades.TributosOmitidosTotales;

import anb.general.Respuesta;

import anb.persistencia.TributosOmitidosDao;

import java.sql.SQLException;

import java.util.List;

import javax.naming.NamingException;


public class TributosOmitidosNeg {
    private final TributosOmitidosDao dao = new TributosOmitidosDao();
    private final String CORRECTO_BD = "CORRECTO";
    private final String ERROR_BD = "ERROR";

    private boolean estaConectadoBd() {
        return dao != null;
    }
    
    public Respuesta<TributosOmitidos[]> devuelveTributosOmitidos(TributosOmitidosForm bean) {
        Respuesta<TributosOmitidos[]> respuesta = new Respuesta<TributosOmitidos[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<TributosOmitidos> result = dao.devuelveTributosOmitidos(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new TributosOmitidos[result.size()]));
                }
            } catch (SQLException e) {
                respuesta.setMensaje("Error no identificado -  " + e.getMessage());
            } catch (ClassNotFoundException e) {
                respuesta.setMensaje("Error no identificado -  " + e.getMessage());
            } catch (NamingException e) {
                respuesta.setMensaje("Error no identificado -  " + e.getMessage());
            }
        } else {
            respuesta.setMensaje("Error. No se puede conectar a la base de datos.");
        }
        return respuesta;
    } 
    
    public Respuesta<TributosOmitidosTotales> devuelveTributosOmitidosTotales(TributosOmitidosForm bean) {
        Respuesta<TributosOmitidosTotales> respuesta = new Respuesta<TributosOmitidosTotales>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                TributosOmitidosTotales result = dao.devuelveTributosOmitidosTotales(bean);
                if (result == null) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(1);
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result);
                }
            } catch (SQLException e) {
                respuesta.setMensaje("Error no identificado -  " + e.getMessage());
            } catch (ClassNotFoundException e) {
                respuesta.setMensaje("Error no identificado -  " + e.getMessage());
            } catch (NamingException e) {
                respuesta.setMensaje("Error no identificado -  " + e.getMessage());
            }
        } else {
            respuesta.setMensaje("Error. No se puede conectar a la base de datos.");
        }
        return respuesta;
    } 
    
}
