package anb.persistencia;


import anb.bean.AdminForm;

import anb.entidades.Funcionario;

import anb.general.Conexion;

import java.sql.SQLException;

import javax.naming.NamingException;


public class AdminDao extends Conexion {
    public AdminDao() {
        super();
    }
    
    public String changePassword(AdminForm bean) throws SQLException, ClassNotFoundException,
                                                                  NamingException {
        String res;
        res = "CORRECTO";
        return res;
    }    
    
    public Funcionario getAccount(AdminForm bean) throws SQLException, ClassNotFoundException,NamingException {
        Funcionario fun =  new Funcionario();                                                        
        String res;
        res = "";
        fun.setNombreUsuario(bean.getUsuario());
        fun.setNombreCompleto("Juan");
        fun.setAduana("201");
        fun.setCorreoElectronico("j@aduana.gob.bo");
        fun.setGerencia("La Paz");
        fun.setUnidad("Fisca");
        fun.setPerfiles("FISCALIZADOR");

        return fun;
    }    
    
}
