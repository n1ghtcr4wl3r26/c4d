package anb.negocio;


import anb.bean.ReporteForm;

import anb.entidades.Reporte;

import anb.general.Respuesta;

import anb.persistencia.ReporteDao;

import java.sql.SQLException;

import java.util.List;

import javax.naming.NamingException;


public class ReporteNeg {
    private final ReporteDao dao = new ReporteDao();
    private final String CORRECTO_BD = "CORRECTO";
    private final String ERROR_BD = "ERROR";

    private boolean estaConectadoBd() {
        return dao != null;
    }
    
    public Respuesta<Reporte[]> reporte_seguimiento_orden(ReporteForm bean) {
        Respuesta<Reporte[]> respuesta = new Respuesta<Reporte[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Reporte> result = dao.reporte_seguimiento_orden(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new Reporte[result.size()]));
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
    
    public Respuesta<Reporte[]> reporte_seguimiento_dui(ReporteForm bean) {
        Respuesta<Reporte[]> respuesta = new Respuesta<Reporte[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Reporte> result = dao.reporte_seguimiento_dui(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new Reporte[result.size()]));
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
    
    public Respuesta<Reporte[]> reporte_seguimiento_item(ReporteForm bean) {
        Respuesta<Reporte[]> respuesta = new Respuesta<Reporte[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Reporte> result = dao.reporte_seguimiento_item(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new Reporte[result.size()]));
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
    
    public Respuesta<Reporte[]> reporte_liquidacion_dui(ReporteForm bean) {
        Respuesta<Reporte[]> respuesta = new Respuesta<Reporte[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Reporte> result = dao.reporte_liquidacion_dui(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new Reporte[result.size()]));
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
    
    public Respuesta<Reporte[]> reporte_liquidacion_item(ReporteForm bean) {
        Respuesta<Reporte[]> respuesta = new Respuesta<Reporte[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Reporte> result = dao.reporte_liquidacion_item(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new Reporte[result.size()]));
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
    
    public Respuesta<Reporte[]> reporte_recuperacion_dui(ReporteForm bean) {
        Respuesta<Reporte[]> respuesta = new Respuesta<Reporte[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Reporte> result = dao.reporte_recuperacion_dui(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new Reporte[result.size()]));
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
