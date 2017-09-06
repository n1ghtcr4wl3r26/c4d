package anb.negocio;


import anb.bean.MemorizacionControlForm;

import anb.entidades.Aduana;
import anb.entidades.Declaracion;
import anb.entidades.Nit;

import anb.general.Respuesta;

import anb.persistencia.MemorizacionControlDao;

import java.sql.SQLException;

import java.util.List;

import javax.naming.NamingException;


public class MemorizacionControlNeg {
    private final MemorizacionControlDao dao = new MemorizacionControlDao();
    private final String CORRECTO_BD = "CORRECTO";
    private final String ERROR_BD = "ERROR";

    private boolean estaConectadoBd() {
        return dao != null;
    }

    // LLAMADA AJAX
    public Respuesta<Nit[]> devuelveNit(String nit) {
        Respuesta<Nit[]> respuesta = new Respuesta<Nit[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Nit> result = dao.devuelveNit(nit);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new Nit[result.size()]));
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
        
    public Respuesta<Declaracion[]> devuelveDatosDUI(String codigo) {
        Respuesta<Declaracion[]> respuesta = new Respuesta<Declaracion[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Declaracion> result = dao.devuelveDatosDUI(codigo);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new Declaracion[result.size()]));
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
    
    // LLAMADA A FUNCIONES PARAMETRICAS

    public Respuesta<List<Aduana>> obtenerAduanas() {
        Respuesta<List<Aduana>> respuesta = new Respuesta<List<Aduana>>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Aduana> res = dao.obtenerAduanas();
                if (res == null && res.size() == 0) {
                    respuesta.setCodigo(0);
                    respuesta.setMensaje("No existen aduanas registradas");
                } else {
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(res);
                }
            } catch (SQLException e) {
                respuesta.setMensaje("Error no identificado - " + e.getMessage());
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                respuesta.setMensaje("Error no identificado - " + e.getMessage());
            } catch (NamingException e) {
                respuesta.setMensaje("Error no identificado - " + e.getMessage());
            }
        } else {
            respuesta.setMensaje("Error. No se puede conectar a la base de datos.");
        }

        return respuesta;
    }
    
    public Respuesta<Boolean> grabaMemorizacionDiferido (MemorizacionControlForm bean) {

        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.grabaMemorizacionDiferido(bean);
                if (result == null) {
                    respuesta.setMensaje("No se pudo guardar la información");
                } else if (result.substring(0,8).equals(CORRECTO_BD)) {
                    respuesta.setCodigo(1);
                    respuesta.setMensaje(result.substring(8));
                    respuesta.setResultado(true);
                } else {
                    respuesta.setMensaje(result);
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
    
    public Respuesta<Boolean> grabaMemorizacionPosterior (MemorizacionControlForm bean) {

        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.grabaMemorizacionPosterior(bean);
                if (result == null) {
                    respuesta.setMensaje("No se pudo guardar la información");
                } else if (result.substring(0,8).equals(CORRECTO_BD)) {
                    respuesta.setCodigo(1);
                    respuesta.setMensaje(result.substring(8));
                    respuesta.setResultado(true);
                } else {
                    respuesta.setMensaje(result);
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
    
    public Respuesta<Boolean> grabaMemorizacionAmpliatoria (MemorizacionControlForm bean) {

        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.grabaMemorizacionAmpliatoria(bean);
                if (result == null) {
                    respuesta.setMensaje("No se pudo guardar la información");
                } else if (result.substring(0,8).equals(CORRECTO_BD)) {
                    respuesta.setCodigo(1);
                    respuesta.setMensaje(result.substring(8));
                    respuesta.setResultado(true);
                } else {
                    respuesta.setMensaje(result);
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
    
    public Respuesta<Declaracion[]> consulta1(MemorizacionControlForm bean) {
        Respuesta<Declaracion[]> respuesta = new Respuesta<Declaracion[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Declaracion> result = dao.consulta1(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCodigo(1);
                    respuesta.setCantidad(result.size());
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new Declaracion[result.size()]));
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
    
    public Respuesta<Declaracion[]> consulta2(MemorizacionControlForm bean) {
        Respuesta<Declaracion[]> respuesta = new Respuesta<Declaracion[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Declaracion> result = dao.consulta2(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCodigo(1);
                    respuesta.setCantidad(result.size());
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new Declaracion[result.size()]));
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
    
    public Respuesta<Declaracion[]> consulta3(MemorizacionControlForm bean) {
        Respuesta<Declaracion[]> respuesta = new Respuesta<Declaracion[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Declaracion> result = dao.consulta3(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCodigo(1);
                    respuesta.setCantidad(result.size());
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new Declaracion[result.size()]));
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