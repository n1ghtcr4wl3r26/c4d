package anb.general;


import anb.persistencia.GeneralDao;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;


/*
*   Nombre de la clase: Util, metodos generales que se utilizaran en todo el sistema
*
*   Fecha creación, Fecha Modificación
*
*   Autor creador, Autor Modificador
*/

public class Util {
    
    public static String devuelveMaximo(){
        String res;
        GeneralDao dao = new GeneralDao();
        try{
            res = dao.devuelve_maximo();
        } catch(Exception ex){
            res = "";
        }
        
        return res;    
    }

    public static void main(String[] args) {
        Calendar calendario = GregorianCalendar.getInstance();
        Date fecha = calendario.getTime();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmmss");
        byte[] encodedBytes =
            Base64.encodeBase64(String.valueOf(Util.randomWord(5) + formato.format(fecha)).getBytes());
        System.out.println(new String(encodedBytes));
    }

    public static String devuelve_secuencia(String numero) {
        String res = "";
        GeneralDao dao = new GeneralDao();
        try {
            res = dao.devuelve_secuencia(numero);
        } catch (Exception ex) {
            res = null;
        }
        return res;
    }

    public static String devuelve_gerencia(String ger) {
        String res = "";

        if (ger.equals("GRLPZ"))
            res = "Gerencia Regional La Paz";
        else if (ger.equals("GRCBB"))
            res = "Gerencia Regional Cochabamba";
        else if (ger.equals("GRORR"))
            res = "Gerencia Regional Oruro";
        else if (ger.equals("GRPTS"))
            res = "Gerencia Regional Potosi";
        else if (ger.equals("GRTRJ"))
            res = "Gerencia Regional Tarija";
        else if (ger.equals("GRSCZ"))
            res = "Gerencia Regional Santa Cruz";
        else
            res = "";

        return res;
    }

    public static String devuelve_asociado(String numero) {
        String res = "";
        GeneralDao dao = new GeneralDao();
        try {
            res = dao.devuelve_asociado(numero);
        } catch (Exception ex) {
            res = null;
        }
        return res;
    }

    public static String devuelve_dui_asociado(String numero) {
        String res = "";
        GeneralDao dao = new GeneralDao();
        try {
            res = dao.devuelve_dui_asociado(numero);
        } catch (Exception ex) {
            res = null;
        }
        return res;
    }

    public static String asignacion_carpetas(String desde, String hasta, String aduana, String usuario) {
        String res = "";
        GeneralDao dao = new GeneralDao();
        try {
            res = dao.asignacion_carpetas(desde, hasta, aduana, usuario);
        } catch (Exception ex) {
            res = null;
        }
        return res;
    }

    public static String es_despacho_directo(String nit) {
        String res = "";
        GeneralDao dao = new GeneralDao();
        try {
            res = dao.es_despacho_directo(nit);
        } catch (Exception ex) {
            res = null;
        }
        return res;
    }


    public static String creamensaje(String tipo, String Mensaje, String tiempo) {
        String res = "";
        if (tipo.equals("1")) {
            res =
"<div id='msgalert'>" + Mensaje + "</div><script type='text/javascript'>$(document).ready(function(){$('#msgalert').fadeIn(1000);setTimeout('hide()',450000);});function hide(){$('#msgalert').fadeOut(3000);}</script>";
        }
        if (tipo.equals("2")) {
            res =
"<div id='msgerror'>" + Mensaje + "</div><script type='text/javascript'>$(document).ready(function(){$('#msgerror').fadeIn(1000);setTimeout('hide()',450000);});function hide(){$('#msgerror').fadeOut(3000);}</script>";
        }
        if (tipo.equals("3")) {
            res =
"<div id='msginfo'>" + Mensaje + "</div><script type='text/javascript'>$(document).ready(function(){$('#msginfo').fadeIn(1000);setTimeout('hide()',450000);});function hide(){$('#msginfo').fadeOut(3000);}</script>";
        }
        return res;
    }

    public static Boolean mostrar_botones(String gestion, String usuario, String opcion) {
        Boolean res;
        GeneralDao dao = new GeneralDao();
        try {
            res = dao.mostrar_botones(gestion, usuario, opcion);
        } catch (Exception ex) {
            res = false;
        }
        return res;
    }

    public static Boolean esFechaMenorIgualAHoy(String fecha) {
        Boolean res;
        GeneralDao dao = new GeneralDao();
        try {
            res = dao.esFechaMenorIgualAHoy(fecha);
        } catch (Exception ex) {
            res = false;
        }
        return res;
    }
    
    public static String esFechaMenorIgual(String fechaini, String fechafin) {
        String res;
        GeneralDao dao = new GeneralDao();
        try {
            res = dao.esFechaMenorIgual(fechaini, fechafin);
        } catch (Exception ex) {
            res = "1";
        }
        return res;
    }

    public static Boolean esFecha(String fecha) {
        Boolean res;
        GeneralDao dao = new GeneralDao();
        try {
            res = dao.esFecha(fecha);
        } catch (Exception ex) {
            res = false;
        }
        return res;
    }

    public static Boolean mostrar_botones_concluir(String codigo, String usuario, String opcion) {
        Boolean res;
        GeneralDao dao = new GeneralDao();
        try {
            res = dao.mostrar_botones_concluir(codigo, usuario, opcion);
        } catch (Exception ex) {
            res = false;
        }
        return res;
    }

    public static Boolean llenar_valores(String gestion, String usuario, String opcion, String nivel) {
        Boolean res;
        GeneralDao dao = new GeneralDao();
        try {
            res = dao.llenar_valores(gestion, usuario, opcion, nivel);
        } catch (Exception ex) {
            res = false;
        }
        return res;
    }

    public static String nombrecompleto(String codigo) {
        String res;
        GeneralDao dao = new GeneralDao();
        try {
            res = dao.nombrecompleto(codigo);
        } catch (Exception ex) {
            res = "";
        }
        return res;
    }

    public static String completarCeros6(String numero) {
        String res = "";

        if (numero.length() == 6)
            res = numero;
        if (numero.length() == 5)
            res = "0" + numero;
        if (numero.length() == 4)
            res = "00" + numero;
        if (numero.length() == 3)
            res = "000" + numero;
        if (numero.length() == 2)
            res = "0000" + numero;
        if (numero.length() == 1)
            res = "00000" + numero;

        return res;
    }

    public static String devuelveDireccionGerencia(String gerencia) {
        String res = "-";

        if (gerencia.length() == 3) {
            if (gerencia.equals("GNF"))
                res =
"Remitir a la Gerencia Nacional de Fiscalización, ubicada en la Av. 20 de Octubre Nº 2038 de la ciudad de La Paz";
            if (gerencia.equals("GRL"))
                res =
"Remitir a la Gerencia Regional La Paz, ubicada en Ciudad Satélite – Av. del Policía s/n entre calle Diego de Portugal y Av. Ballivian Otero de la Ciudad de El Alto";
            if (gerencia.equals("GRC"))
                res = "Remitir a la Gerencia Regional Cochabamba, ubicada en la Av. Capitán Victor Ustariz Km. 7.5";
            if (gerencia.equals("GRS"))
                res =
"Remitir a la Gerencia Regional Santa Cruz, ubicada en la Av. La Salle esq. Claudio Peñaranda s/n Edificio Don Uruguay de la ciudad de Santa Cruz de la Sierra";
            if (gerencia.equals("GRO"))
                res =
"Remitir a la Gerencia Regional Oruro, ubicada en la calle Madrid N° 390 entre América y Colón, zona sud, Oruro";
            if (gerencia.equals("GRT"))
                res =
"Remitir a la Gerencia Regional Tarija, ubicada en la Av. Jaime Paz Zamora N° 2381 (Zona Juan XXIII) – Tarija";
            if (gerencia.equals("GRP"))
                res =
"Remitir a la Gerencia Regional Potosi, ubicada en la Av. Villazon N° 242, segundo piso, ambiente N° 20";


        }

        return res;
    }

    public static String completaCerosDecimal(String numero) {
        String res = "";
        res = numero;
        if (numero != null)
            if (numero.length() > 0) {
                if (numero.substring(0, 1).equals(".")) {
                    res = "0" + numero;
                }
                if (numero.length() > 1) {
                    if (numero.substring(0, 2).equals("-.")) {
                        res = "-0" + numero.substring(1);
                    }
                }
            }
        return res;
    }

    public static String numeroGerencia(String gerencia) {
        String res = "";
        if (gerencia.equals("GNF"))
            res = "%";
        if (gerencia.equals("GRL"))
            res = "2";
        if (gerencia.equals("GRC"))
            res = "3";
        if (gerencia.equals("GRS"))
            res = "7";
        if (gerencia.equals("GRO"))
            res = "4";
        if (gerencia.equals("GRP"))
            res = "5";
        if (gerencia.equals("GRT"))
            res = "6";

        return res;
    }

    public static String gusuarioGerencia(String gerencia) {
        String res = "";

        if (gerencia.equals("15"))
            res = "GNF";
        if (gerencia.equals("19"))
            res = "GRL";
        if (gerencia.equals("20"))
            res = "GRO";
        if (gerencia.equals("21"))
            res = "GRC";
        if (gerencia.equals("22"))
            res = "GRS";
        if (gerencia.equals("23"))
            res = "GRT";
        if (gerencia.equals("24"))
            res = "GRP";

        return res;
    }

    public static String NombreGerencia(String gerencia) {
        String res = "";

        if (gerencia.equals("15"))
            res = "GERENCIA NACIONAL DE FISCALIZACION";
        if (gerencia.equals("19"))
            res = "GERENCIA REGIONAL LA PAZ";
        if (gerencia.equals("20"))
            res = "GERENCIA REGIONAL ORURO";
        if (gerencia.equals("21"))
            res = "GERENCIA REGIONAL COCHABAMBA";
        if (gerencia.equals("22"))
            res = "GERENCIA REGIONAL SANTA CRUZ";
        if (gerencia.equals("23"))
            res = "GERENCIA REGIONAL TARIJA";
        if (gerencia.equals("24"))
            res = "GERENCIA REGIONAL POTOSI";

        return res;
    }

    public static String completarCeros7(String numero) {
        String res = "";
        if (numero.length() == 7)
            res = numero;
        if (numero.length() == 6)
            res = "0" + numero;
        if (numero.length() == 5)
            res = "00" + numero;
        if (numero.length() == 4)
            res = "000" + numero;
        if (numero.length() == 3)
            res = "0000" + numero;
        if (numero.length() == 2)
            res = "00000" + numero;
        if (numero.length() == 1)
            res = "000000" + numero;

        return res;
    }

    public static String completarCeros8(String numero) {
        String res = "";

        if (numero.length() == 8)
            res = numero;
        if (numero.length() == 7)
            res = "0" + numero;
        if (numero.length() == 6)
            res = "00" + numero;
        if (numero.length() == 5)
            res = "000" + numero;
        if (numero.length() == 4)
            res = "0000" + numero;
        if (numero.length() == 3)
            res = "00000" + numero;
        if (numero.length() == 2)
            res = "000000" + numero;
        if (numero.length() == 1)
            res = "0000000" + numero;

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

    public static String join(String[] elements, String separator) {
        String text = "";
        for (String el : elements) {
            text += el + separator;
        }
        return text.replaceAll("\\" + separator + "+$", "");
    }

    public static void noCache(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.
    }

}
