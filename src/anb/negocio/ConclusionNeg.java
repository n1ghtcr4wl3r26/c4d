package anb.negocio;


import anb.bean.ConclusionControlForm;

import anb.entidades.PanelConclusion;

import anb.general.Respuesta;

import anb.persistencia.ConclusionDao;

import java.sql.SQLException;

import javax.naming.NamingException;


public class ConclusionNeg {
    private final ConclusionDao dao = new ConclusionDao();
    private final String CORRECTO_BD = "CORRECTO";
    private final String ERROR_BD = "ERROR";

    private boolean estaConectadoBd() {
        return dao != null;
    }

    public Respuesta<Boolean> graba_conclusion(ConclusionControlForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.graba_conclusion(bean);
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

    public Respuesta<ConclusionControlForm> devuelveNotificacion(ConclusionControlForm bean) {
        Respuesta<ConclusionControlForm> respuesta = new Respuesta<ConclusionControlForm>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                ConclusionControlForm res;// = dao.devuelveConclusion(bean);
                //res.setCvc_tipo_notificacion("prueba");
                res = dao.devuelvecon_viscargo(bean);
                res = dao.devuelvecon_resdeter(res);
                res = dao.devuelvecon_actainter(res); 
                res = dao.devuelvecon_resadmin(res); 
                res = dao.devuelvecon_autoinicial(res); 
                
                if (res == null ) {
                    respuesta.setCodigo(0);
                    respuesta.setMensaje("No existen control registrado");
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
    
    public Respuesta<Boolean> graba_con_viscargo(ConclusionControlForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.graba_con_viscargo(bean);
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
    
    public Respuesta<Boolean> graba_con_resdeter(ConclusionControlForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.graba_con_resdeter(bean);
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
    
    public Respuesta<Boolean> graba_con_actainter(ConclusionControlForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.graba_con_actainter(bean);
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
    
    public Respuesta<Boolean> graba_con_resadmin(ConclusionControlForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.graba_con_resadmin(bean);
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
    
    public Respuesta<Boolean> graba_concluirfis(ConclusionControlForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.graba_concluirfis(bean);
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
    
    public Respuesta<Boolean> graba_con_autoinicial(ConclusionControlForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.graba_con_autoinicial(bean);
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
    
    public Respuesta<PanelConclusion> devuelveConclusionPanel(String codigo) {
        Respuesta<PanelConclusion> respuesta = new Respuesta<PanelConclusion>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                PanelConclusion res = dao.devuelveConclusionPanel(codigo);
                if (res == null ) {
                    respuesta.setCodigo(0);
                    respuesta.setMensaje("No existen control registrado");
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
    
    
    
}
