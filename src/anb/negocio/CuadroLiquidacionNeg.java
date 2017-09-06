package anb.negocio;


import anb.bean.CuadroLiquidacionForm;

import anb.entidades.CuadroLiquidacion;

import anb.general.Respuesta;

import anb.persistencia.CuadroLiquidacionDao;

import java.sql.SQLException;

import java.util.List;

import javax.naming.NamingException;


public class CuadroLiquidacionNeg {
    private final CuadroLiquidacionDao dao = new CuadroLiquidacionDao();
    private final String CORRECTO_BD = "CORRECTO";
    private final String ERROR_BD = "ERROR";

    private boolean estaConectadoBd() {
        return dao != null;
    }
    
    public Respuesta<CuadroLiquidacion[]> devuelveCuadroLiq(CuadroLiquidacionForm bean) {
        Respuesta<CuadroLiquidacion[]> respuesta = new Respuesta<CuadroLiquidacion[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<CuadroLiquidacion> result = dao.devuelveCuadroLiq(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new CuadroLiquidacion[result.size()]));
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
