package anb.negocio;


import anb.bean.ReporteControlForm;

import anb.entidades.RepCantidades;
import anb.entidades.RepControl;
import anb.entidades.RepEstadoControl;

import anb.general.Respuesta;

import anb.persistencia.ReporteControlDao;

import java.sql.SQLException;

import java.util.List;

import javax.naming.NamingException;


public class ReporteControlNeg {
    private final ReporteControlDao dao = new ReporteControlDao();
    private final String CORRECTO_BD = "CORRECTO";
    private final String ERROR_BD = "ERROR";

    private boolean estaConectadoBd() {
        return dao != null;
    }
    
    public Respuesta<RepControl[]> reporteControl(ReporteControlForm bean) {
        Respuesta<RepControl[]> respuesta = new Respuesta<RepControl[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<RepControl> result = dao.reporteControl(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new RepControl[result.size()]));
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
    
    public Respuesta<RepCantidades[]> reporteControlAsig(ReporteControlForm bean) {
        Respuesta<RepCantidades[]> respuesta = new Respuesta<RepCantidades[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<RepCantidades> result = dao.reporteControlAsig(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new RepCantidades[result.size()]));
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
    
    public Respuesta<RepCantidades[]> reporteControlGen(ReporteControlForm bean) {
        Respuesta<RepCantidades[]> respuesta = new Respuesta<RepCantidades[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<RepCantidades> result = dao.reporteControlGen(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new RepCantidades[result.size()]));
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
    
    public Respuesta<RepCantidades[]> reporteControlAsigTot(ReporteControlForm bean) {
        Respuesta<RepCantidades[]> respuesta = new Respuesta<RepCantidades[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<RepCantidades> result = dao.reporteControlAsigTot(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new RepCantidades[result.size()]));
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
    
    public Respuesta<RepEstadoControl[]> reporteDetalleControles(ReporteControlForm bean) {
        Respuesta<RepEstadoControl[]> respuesta = new Respuesta<RepEstadoControl[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<RepEstadoControl> result = dao.reporteDetalleControles(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new RepEstadoControl[result.size()]));
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
    public Respuesta<RepCantidades[]> reporteDetalleCantidades(ReporteControlForm bean) {
        Respuesta<RepCantidades[]> respuesta = new Respuesta<RepCantidades[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<RepCantidades> result = dao.reporteDetalleCantidades(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new RepCantidades[result.size()]));
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
    public Respuesta<RepCantidades[]> reporteDetalleTotales(ReporteControlForm bean) {
        Respuesta<RepCantidades[]> respuesta = new Respuesta<RepCantidades[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<RepCantidades> result = dao.reporteDetalleTotales(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new RepCantidades[result.size()]));
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
