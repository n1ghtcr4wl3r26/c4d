import java.sql.CallableStatement;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

public class Util {
    
    public static void main(String args[]) {
        Calendar calendario = GregorianCalendar.getInstance();
        Date fecha = calendario.getTime();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmmss");
        byte[] encodedBytes = Base64.encodeBase64(String.valueOf(Util.randomWord(5) + formato.format(fecha)).getBytes());
        System.out.println(new String(encodedBytes));
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
     
    public static String randomWord(int length) {
        Random random = new Random();
        StringBuilder word = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            word.append((char)('a' + random.nextInt(26)));
        }

        return word.toString();
    }
    
    public static String capitalizeString(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i] == '.' ||
                       chars[i] == '\'') { // You can add other chars here
                found = false;
            }
        }
        return String.valueOf(chars);
    }
    
    public static void isAjax(HttpServletRequest request, HttpServletResponse response) {
        if (!"XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            Util.redirect(request, response, "/index.do");
        }
    }
    
    public static void redirect(HttpServletRequest request, HttpServletResponse response, String url) {
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (ServletException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
               
    public static String join(String elements[], String separator) {
        String text = "";
        for (String el : elements) {
            text += el + separator;
        }
        return text.replaceAll("\\" + separator + "+$","");
    }
    
    public static void noCache(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.
    }
           
}