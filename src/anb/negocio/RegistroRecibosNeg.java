package anb.negocio;


import anb.bean.AlcanceForm;
import anb.bean.RegistroRecibosForm;

import anb.entidades.Aduana;

import anb.entidades.Recibo;
import anb.entidades.Tramite;

import anb.general.Respuesta;

import anb.persistencia.RegistroRecibosDao;

import java.sql.SQLException;

import java.util.List;

import javax.naming.NamingException;


public class RegistroRecibosNeg {

    private final RegistroRecibosDao dao = new RegistroRecibosDao();
    private final String CORRECTO_BD = "CORRECTO";
    private final String ERROR_BD = "ERROR";

    private boolean estaConectadoBd() {
        return dao != null;
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
    
    public Respuesta<Boolean> graba_recibo(RegistroRecibosForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.graba_recibo(bean);
                if (result == null) {
                    respuesta.setMensaje("No se pudo guardar la información");
                } else if (result.substring(0, 8).equals(CORRECTO_BD)) {
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
    
    public Respuesta<Boolean> borra_recibo(RegistroRecibosForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.borra_recibo(bean);
                if (result == null) {
                    respuesta.setMensaje("No se pudo guardar la información");
                } else if (result.substring(0, 8).equals(CORRECTO_BD)) {
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
    
    public Respuesta<Boolean> verifica_registro_recibos(RegistroRecibosForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.verifica_registro_recibos(bean);
                if (result == null) {
                    respuesta.setMensaje("No se pudo verificar el control");
                } else if (result.substring(0, 8).equals(CORRECTO_BD)) {
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
    
    public Respuesta<Recibo[]> recibos(RegistroRecibosForm bean) {
        Respuesta<Recibo[]> respuesta = new Respuesta<Recibo[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Recibo> result = dao.recibos(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new Recibo[result.size()]));
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

