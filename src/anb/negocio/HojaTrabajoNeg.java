package anb.negocio;


import anb.bean.GeneracionHojaForm;

import anb.entidades.HojaTrabajoDui;

import anb.general.Respuesta;

import anb.persistencia.HojaTrabajoDao;

import java.sql.SQLException;

import java.util.List;

import javax.naming.NamingException;


public class HojaTrabajoNeg {
    private final HojaTrabajoDao dao = new HojaTrabajoDao();
    private final String CORRECTO_BD = "CORRECTO";
    private final String ERROR_BD = "ERROR";

    private boolean estaConectadoBd() {
        return dao != null;
    }
    
    public Respuesta<HojaTrabajoDui[]> hojaTrabajoDui(GeneracionHojaForm bean) {
        Respuesta<HojaTrabajoDui[]> respuesta = new Respuesta<HojaTrabajoDui[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<HojaTrabajoDui> result = dao.hojaTrabajoDui(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new HojaTrabajoDui[result.size()]));
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
    
    public Respuesta<HojaTrabajoDui[]> hojaTrabajoTramite(GeneracionHojaForm bean) {
        Respuesta<HojaTrabajoDui[]> respuesta = new Respuesta<HojaTrabajoDui[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<HojaTrabajoDui> result = dao.hojaTrabajoTramite(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new HojaTrabajoDui[result.size()]));
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
