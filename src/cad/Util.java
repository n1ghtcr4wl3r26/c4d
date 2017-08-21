package cad;

import java.sql.*;
import javax.naming.InitialContext;
import javax.sql.PooledConnection;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;

// Referenced classes of package Paquete:
//            modif_evalForm, formularioregForm

public class Util
{

    public Util()
    {
    }

    public static String devuelve_secuencia(String numero)
    {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String res = "";
        
        
        try {
            con = dc.abrirConexion();
                call = con.prepareCall("{? = call ops$asy.carpetas.devuelve_secuencia(?) }");
                call.registerOutParameter(1, 12);
                call.setString(2, numero);
                call.execute();
                res = (String) call.getObject(1);
           
        }    
        catch (Exception er) {
            res = er.toString();
        } finally
        {
            try {
                if (con != null)
                    con.close();

            } catch (SQLException er) {
                ;
            }
        }
        return res;
    
    }
 public static String devuelve_asociado(String numero)
    {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String res = "";
        
       
        try {
            con = dc.abrirConexion();
                call = con.prepareCall("{? = call ops$asy.carpetas.devuelve_asociado(?) }");
                call.registerOutParameter(1, 12);
                call.setString(2, numero);
                call.execute();
                res = (String) call.getObject(1);
           
        }    
        catch (Exception er) {
            res = er.toString();
        } finally
        {
            try {
                if (con != null)
                    con.close();

            } catch (SQLException er) {
                ;
            }
        }
        return res;
    
    }

    public static String devuelve_dui_asociado(String numero)
    {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String res = "";
        
        
        try {
            con = dc.abrirConexion();
                call = con.prepareCall("{? = call ops$asy.carpetas.carpeta_asociada(?) }");
                call.registerOutParameter(1, 12);
                call.setString(2, numero);
                call.execute();
                res = (String) call.getObject(1);
           
        }    
        catch (Exception er) {
            res = er.toString();
        } finally
        {
            try {
                if (con != null)
                    con.close();

            } catch (SQLException er) {
                ;
            }
        }
        return res;
    
    }

    public static String asignacion_carpetas(String desde, String hasta, String aduana, String usuario)
    {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String res = "";
        
       
        try {
            con = dc.abrirConexion();
                call = con.prepareCall("{call ops$asy.carpetas.asignacion_aduana(?,?,?,?,?) }");
                call.setString(1, desde);
                call.setString(2, hasta);
                call.setString(3, aduana);
                call.setString(4, usuario);
                call.registerOutParameter(5, 12);
                call.execute();
                res = (String) call.getObject(5);
        }    
        catch (Exception er) {
            res = er.toString();
        } finally
        {
            try {
                if (con != null)
                    con.close();

            } catch (SQLException er) {
                ;
            }
        }
        return res;
    }

    public static String es_despacho_directo(String nit)
    {
        conexion dc = new conexion();
        Connection con = null;
        CallableStatement call = null;
        String res = "";
        
        try {
            con = dc.abrirConexion();
                call = con.prepareCall("{? = call ops$asy.carpetas.es_despacho_directo(?) }");
                call.registerOutParameter(1, 12);
                call.setString(2, nit);
                call.execute();
                res = (String) call.getObject(1);
                
        }    
        catch (Exception er) {
            res = "0";
        } finally
        {
            try {
                if (con != null)
                    con.close();

            } catch (SQLException er) {
                ;
            }
        }
        return res;
    }


     public static String creamensaje(String tipo, String Mensaje, String tiempo)
        {
           

            String res="";
            if(tipo.equals("1"))
            {
            res= "<div id='msgalert'>"+Mensaje+"</div><script type='text/javascript'>$(document).ready(function(){$('#msgalert').fadeIn(1000);setTimeout('hide()',450000);});function hide(){$('#msgalert').fadeOut(3000);}</script>";
            }
            if(tipo.equals("2"))
            {
            res= "<div id='msgerror'>"+Mensaje+"</div><script type='text/javascript'>$(document).ready(function(){$('#msgerror').fadeIn(1000);setTimeout('hide()',450000);});function hide(){$('#msgerror').fadeOut(3000);}</script>";
            }
            if(tipo.equals("3"))
            {
            res= "<div id='msginfo'>"+Mensaje+"</div><script type='text/javascript'>$(document).ready(function(){$('#msginfo').fadeIn(1000);setTimeout('hide()',450000);});function hide(){$('#msginfo').fadeOut(3000);}</script>";
            }
            return res;
        }
 
}