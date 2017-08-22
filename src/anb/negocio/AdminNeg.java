package anb.negocio;

import anb.bean.AdminForm;

import anb.entidades.Funcionario;

import anb.general.Respuesta;

import anb.persistencia.AdminDao;

import java.sql.SQLException;

import javax.naming.NamingException;

public class AdminNeg {
    
    private final AdminDao dao = new AdminDao();
    private final String CORRECTO_BD = "CORRECTO";
    private final String ERROR_BD = "ERROR";
    
    private boolean estaConectadoBd() {
        return dao != null;    
    }
    
    public Respuesta<Boolean> changePassword(AdminForm bean){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()){
            try{
                String result = dao.changePassword(bean);
                if(result == null){
                    respuesta.setMensaje("No se pudo cambiar la contraseña");        
                } else if (result.substring(0, 8).equals(CORRECTO_BD)){
                    respuesta.setCodigo(1);
                    respuesta.setMensaje(result.substring(8));
                    respuesta.setResultado(true);
                } else {
                    respuesta.setMensaje(result);
                }
            } catch (SQLException e){
                respuesta.setMensaje("Error no identificado - " + e.getMessage());      
            } catch (ClassNotFoundException e){
                respuesta.setMensaje("Error no identificado - " + e.getMessage());   
            } catch (NamingException e){
                respuesta.setMensaje("Error no identificado - " + e.getMessage());
            }
        } else {
            respuesta.setMensaje("Error. No se puede conectar a la base de datos.");    
        }
        return respuesta;
    }   
    
    public Respuesta<Funcionario> getAccount(AdminForm bean){
        Respuesta<Funcionario> respuesta = new Respuesta<Funcionario>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()){
            try{
                Funcionario res = dao.getAccount(bean);
                if(res == null){
                    respuesta.setCodigo(0);
                    respuesta.setMensaje("No existe información del funcionario.");        
                } else {
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(res);
                }
            } catch (SQLException e){
                respuesta.setMensaje("Error no identificado - " + e.getMessage());      
            } catch (ClassNotFoundException e){
                respuesta.setMensaje("Error no identificado - " + e.getMessage());   
            } catch (NamingException e){
                respuesta.setMensaje("Error no identificado - " + e.getMessage());
            }
        } else {
            respuesta.setMensaje("Error. No se puede conectar a la base de datos.");    
        }
        return respuesta;
    }   
}
