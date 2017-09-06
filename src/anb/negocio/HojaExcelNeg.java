package anb.negocio;

import anb.bean.GeneracionExcelForm;

import anb.bean.GeneracionHojaForm;

import anb.entidades.HojaExcel;
import anb.entidades.HojaExcelCab;
import anb.entidades.HojaTrabajoDui;
import anb.entidades.Tramite;

import anb.general.Respuesta;

import anb.persistencia.HojaExcelDao;

import anb.persistencia.HojaTrabajoDao;

import java.sql.SQLException;

import java.util.List;

import javax.naming.NamingException;
public class HojaExcelNeg {
    private final HojaExcelDao dao = new HojaExcelDao();
    private final String CORRECTO_BD = "CORRECTO";
    private final String ERROR_BD = "ERROR";

    private boolean estaConectadoBd() {
        return dao != null;
    }
    
    public Respuesta<HojaExcel[]> hojaExcel(GeneracionExcelForm bean) {
        Respuesta<HojaExcel[]> respuesta = new Respuesta<HojaExcel[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<HojaExcel> result = dao.hojaExcel(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new HojaExcel[result.size()]));
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
    
    public Respuesta<HojaExcelCab> hojaExcelCap(GeneracionExcelForm bean) {
        Respuesta<HojaExcelCab> respuesta = new Respuesta<HojaExcelCab>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                HojaExcelCab result = dao.hojaExcelCap(bean);
                if (result == null ) {
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
