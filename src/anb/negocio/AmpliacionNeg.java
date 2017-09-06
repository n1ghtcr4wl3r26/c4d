package anb.negocio;


import anb.bean.AlcanceForm;
import anb.bean.AmpliacionForm;

import anb.entidades.Declaracion;
import anb.entidades.DeclaracionItem;
import anb.entidades.Tramite;

import anb.general.Respuesta;

import anb.persistencia.AmpliacionDao;

import java.sql.SQLException;

import java.util.List;

import javax.naming.NamingException;


public class AmpliacionNeg {
    private final AmpliacionDao dao = new AmpliacionDao();
    private final String CORRECTO_BD = "CORRECTO";
    private final String ERROR_BD = "ERROR";

    private boolean estaConectadoBd() {
        return dao != null;
    }

    public Respuesta<Declaracion[]> ver_Declaracion(AmpliacionForm bean) {
        Respuesta<Declaracion[]> respuesta = new Respuesta<Declaracion[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Declaracion> result = dao.declaracion(bean);
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
    
    public Respuesta<DeclaracionItem[]> ver_DeclaracionItem(AmpliacionForm bean) {
        Respuesta<DeclaracionItem[]> respuesta = new Respuesta<DeclaracionItem[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<DeclaracionItem> result = dao.declaracionItem(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCodigo(1);
                    respuesta.setCantidad(result.size());
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new DeclaracionItem[result.size()]));
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
    
    public Respuesta<Tramite[]> ver_TramitesControl(AmpliacionForm bean) {
        Respuesta<Tramite[]> respuesta = new Respuesta<Tramite[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Tramite> result = dao.tramites(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new Tramite[result.size()]));
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
    
    public Respuesta<Tramite[]> ver_TramitesPadreAmp(AmpliacionForm bean) {
        Respuesta<Tramite[]> respuesta = new Respuesta<Tramite[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Tramite> result = dao.tramitespadreamp(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new Tramite[result.size()]));
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
    
    public Respuesta<Tramite[]> ver_TramitesAmp(AmpliacionForm bean) {
        Respuesta<Tramite[]> respuesta = new Respuesta<Tramite[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Tramite> result = dao.tramitesAmpliatoria(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new Tramite[result.size()]));
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
    
    public Respuesta<Tramite[]> ver_TramitesControlrep(AmpliacionForm bean) {
        Respuesta<Tramite[]> respuesta = new Respuesta<Tramite[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Tramite> result = dao.tramitesrep(bean);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new Tramite[result.size()]));
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
    
    public Respuesta<Boolean> graba_tramites_selec(AmpliacionForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                //String result = dao.graba_tramites_selec(bean);
                String result = "";
                if(bean.getCodigoconcatori().length() > 3){
                    result = dao.graba_tramites_selec_decori(bean);
                }
                if(bean.getCodigoconcatpar().length() > 3){
                    result = dao.graba_tramites_selec_decpar(bean);
                }
                if(bean.getCodigoconcatval().length() > 3){
                    result = dao.graba_tramites_selec_decval(bean);
                }
                if(bean.getCodigoconcatotr().length() > 3){
                    result = dao.graba_tramites_selec_decotr(bean);
                }
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
    
    public Respuesta<Boolean> graba_tramites_selecamp(AmpliacionForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                //String result = dao.graba_tramites_selec(bean);
                String result = "";                
                if(bean.getCodigoconcatval().length() > 3){
                    result = dao.graba_tramites_selec_amp(bean);
                }              
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
    
    public Respuesta<Boolean> graba_tramite_dec(AmpliacionForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.graba_tramite_dec(bean);
                
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
    
    public Respuesta<Boolean> graba_tramite_factura(AmpliacionForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.graba_tramite_factura(bean);
                
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
    
    public Respuesta<Boolean> graba_tramite_transferencia(AmpliacionForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.graba_tramite_transferencia(bean);
                
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
      
    public Respuesta<Boolean> graba_tramite_otro(AmpliacionForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.graba_tramite_otro(bean);
                
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
      
        
    public Respuesta<Boolean> graba_tramites_selec_item(AmpliacionForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = "";
                if(bean.getCodigoconcatori().length() > 3){
                    result = dao.graba_tramites_selec_itemori(bean);
                }
                if(bean.getCodigoconcatpar().length() > 3){
                    result = dao.graba_tramites_selec_itempar(bean);
                }
                if(bean.getCodigoconcatval().length() > 3){
                    result = dao.graba_tramites_selec_itemval(bean);
                }
                if(bean.getCodigoconcatotr().length() > 3){
                    result = dao.graba_tramites_selec_itemotr(bean);
                }
                
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
    
    public Respuesta<Boolean> borra_tramite_selec(AmpliacionForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.borra_tramite_selec(bean);
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
    
    public Respuesta<Boolean> borra_tramite_selecitem(AmpliacionForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.borra_tramite_selecitem(bean);
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
    
    public Respuesta<Boolean> borra_tramite_todo(AmpliacionForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.borra_tramite_todo(bean);
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
    
    
    public Respuesta<Boolean> borra_tramite_selecamp(AmpliacionForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.borra_tramite_selecamp(bean);
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
            
    public Respuesta<Boolean> verifica_alcance_control(AmpliacionForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.verifica_registra_control(bean);
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
    
    public Respuesta<Boolean> verifica_ampliacion_control(AmpliacionForm bean){
            Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
            respuesta.setCodigo(-1);
            respuesta.setResultado(false);
            if (estaConectadoBd()) {
                try {
                    String result = dao.verifica_registra_control(bean);
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
}
 
 