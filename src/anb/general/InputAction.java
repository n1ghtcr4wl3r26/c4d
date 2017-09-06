package anb.general;


import anb.entidades.Funcionario;

import cliente.ClaseEnvio;
import cliente.ServiciosUsuario;

import cliente.bean.ClaseOpcion;
import cliente.bean.ClaseUsuario;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import org.xml.sax.InputSource;


/*
*   Nombre de la clase: inputAction, Clase de autentificacion del usuario
*
*   Fecha creación, Fecha Modificación
*
*   Autor creador, Autor Modificador
*/
public class InputAction extends Action {
    
    private String GetTagXML(Document doc, String tag) {
        try {
            NodeList listaNodosHijos = doc.getElementsByTagName(tag);
            return listaNodosHijos.item(0).getFirstChild().getNodeValue();
        } catch (Exception e) {
            return "";
        }
    }

    private String GetTagXML(Element doc, String tag) {
        try {
            return (doc.getElementsByTagName(tag).item(0).getFirstChild().getNodeValue());
        } catch (Exception e) {
            return "";
        }
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {        
        String opcionini = "";
        String accionini = "";
        Log.IP = request.getRemoteHost();
        
        request.getSession().removeAttribute("ClaseSession");

        ClaseUsuario user = new ClaseUsuario();
        InputForm ini = (InputForm)form;
        request.getSession().setAttribute("InputForm", ini);
        ActionMessages errors = new ActionMessages();

        ServiciosUsuario serviciosUsuario = new ServiciosUsuario();
        ClaseEnvio claseEnvio = serviciosUsuario.getServiciosUsuario();

        try {

            // Inicio Autentificacion Virtual

            String xmlv = "";
            String vparam = request.getParameter("vsessionid");
            DocumentBuilderFactory factoryv = DocumentBuilderFactory.newInstance();
            DocumentBuilder builderv = factoryv.newDocumentBuilder();
            if (vparam != null) {
                try {
                    xmlv = claseEnvio.fUsuarioVirtual(vparam);
                    Document doc = builderv.parse(new InputSource(new StringReader(xmlv)));
                    doc.getDocumentElement().normalize();
                    ini.setUsuario(GetTagXML(doc, "Usuario"));
                    ini.setClave(GetTagXML(doc, "Clave"));
                } catch (Exception ex) {
                    ;
                }
            }
            //

            String xml = claseEnvio.listaOpcionesXML(ini.getUsuario().toUpperCase(), ini.getClave(), Log.APP); // (USUARIO,CLAVE, NOMBRE DEL SISTEMA)
            //String xml ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><GestionUsuario><Usuario>APELLIDO PAT CAP APELLIDO MAT CAP, NOMBRE CAP</Usuario><Nit>1004777023</Nit><Aduana>ALL</Aduana><Auxiliar>000000 UFLP</Auxiliar><Perfil>ADMPLAZOS,OPERATIVO,TRANSITO_ADMINISTRADORADUANA</Perfil><Sistema>-</Sistema><NroDocumento>3721457</NroDocumento><TipoDocumento>CI</TipoDocumento><LugarEmision>LP</LugarEmision><Telefono>12345678</Telefono><Movil>-</Movil><Ci>-</Ci><Foto>CAP00120151026152301.jpg</Foto><Observacion>-</Observacion><CodigoGerencia>14</CodigoGerencia><NombreGerencia>GERENCIA NACIONAL DE NORMAS</NombreGerencia><CodigoUnidad>18</CodigoUnidad><NombreUnidad>GERENCIA NACIONAL DE NORMAS</NombreUnidad><Paterno>APELLIDO PAT CAP</Paterno><Materno>APELLIDO MAT CAP</Materno><Nombres>NOMBRE CAP</Nombres><Correo>1@aduana.gob.bo</Correo><Version>137</Version><Opciones><Opcion><Codigo>1</Codigo><Descripcion>Inicio del Tr�nsito</Descripcion><NivelSuperior>1</NivelSuperior><Accion>1</Accion></Opcion><Opcion><Codigo>10</Codigo><Descripcion>Control Documento de Embarque</Descripcion><NivelSuperior>10</NivelSuperior><Accion>10</Accion></Opcion><Opcion><Codigo>101</Codigo><Descripcion>Enmienda Control DE</Descripcion><NivelSuperior>101</NivelSuperior><Accion>101</Accion></Opcion><Opcion><Codigo>11</Codigo><Descripcion>Adm. Rutas y Plazos</Descripcion><NivelSuperior>31</NivelSuperior><Accion>11</Accion></Opcion><Opcion><Codigo>12</Codigo><Descripcion>Etiqueta de Control</Descripcion><NivelSuperior>7</NivelSuperior><Accion>12</Accion></Opcion><Opcion><Codigo>122</Codigo><Descripcion>Registro de Dep�sito Transitorio</Descripcion><NivelSuperior>120</NivelSuperior><Accion>122</Accion></Opcion><Opcion><Codigo>126</Codigo><Descripcion>Dep�sitos TransitoriosRegistrados</Descripcion><NivelSuperior>120</NivelSuperior><Accion>126</Accion></Opcion><Opcion><Codigo>13</Codigo><Descripcion>Aduana de Paso Lector</Descripcion><NivelSuperior>5</NivelSuperior><Accion>13</Accion></Opcion><Opcion><Codigo>130</Codigo><Descripcion>Registro de Llegada a Dep�sito </Descripcion><NivelSuperior>120</NivelSuperior><Accion>130</Accion></Opcion><Opcion><Codigo>15</Codigo><Descripcion>Despacho Anticipado</Descripcion><NivelSuperior>9</NivelSuperior><Accion>15</Accion></Opcion><Opcion><Codigo>16</Codigo><Descripcion>Salida de Puerto</Descripcion><NivelSuperior>13</NivelSuperior><Accion>6</Accion></Opcion><Opcion><Codigo>17</Codigo><Descripcion>Lista Salida de Puerto</Descripcion><NivelSuperior>13</NivelSuperior><Accion>7</Accion></Opcion><Opcion><Codigo>18</Codigo><Descripcion>Transbordo Carretero a Ferreo</Descripcion><NivelSuperior>18</NivelSuperior><Accion>18</Accion></Opcion><Opcion><Codigo>2</Codigo><Descripcion>Cierre del Tr�nsito</Descripcion><NivelSuperior>8</NivelSuperior><Accion>2</Accion></Opcion><Opcion><Codigo>20</Codigo><Descripcion>Digitalizaci�n Precinto</Descripcion><NivelSuperior>20</NivelSuperior><Accion>20</Accion></Opcion><Opcion><Codigo>21</Codigo><Descripcion>Detalle Tr�nsito</Descripcion><NivelSuperior>41</NivelSuperior><Accion>21</Accion></Opcion><Opcion><Codigo>23</Codigo><Descripcion>Actas JUDIS registradas</Descripcion><NivelSuperior>51</NivelSuperior><Accion>23</Accion></Opcion><Opcion><Codigo>24</Codigo><Descripcion>Tr�nsitos por estados </Descripcion><NivelSuperior>42</NivelSuperior><Accion>24</Accion></Opcion><Opcion><Codigo>25</Codigo><Descripcion>Bit�cora</Descripcion><NivelSuperior>43</NivelSuperior><Accion>25</Accion></Opcion><Opcion><Codigo>26</Codigo><Descripcion>Tr�nsitos por Placa</Descripcion><NivelSuperior>44</NivelSuperior><Accion>26</Accion></Opcion><Opcion><Codigo>28</Codigo><Descripcion>Resumen de Tr�nsitos</Descripcion><NivelSuperior>46</NivelSuperior><Accion>28</Accion></Opcion><Opcion><Codigo>29</Codigo><Descripcion>Reporte Registro Peso</Descripcion><NivelSuperior>47</NivelSuperior><Accion>29</Accion></Opcion><Opcion><Codigo>3</Codigo><Descripcion>Reasignaci�n del Tr�nsito</Descripcion><NivelSuperior>2</NivelSuperior><Accion>3</Accion></Opcion><Opcion><Codigo>30</Codigo><Descripcion>Etiquetas Genericas</Descripcion><NivelSuperior>48</NivelSuperior><Accion>30</Accion></Opcion><Opcion><Codigo>31</Codigo><Descripcion>Manifiestos Pendientes</Descripcion><NivelSuperior>49</NivelSuperior><Accion>31</Accion></Opcion><Opcion><Codigo>32</Codigo><Descripcion>Manifiestos Pendientes</Descripcion><NivelSuperior>50</NivelSuperior><Accion>32</Accion></Opcion><Opcion><Codigo>34</Codigo><Descripcion>Control de Riesgos</Descripcion><NivelSuperior>34</NivelSuperior><Accion>34</Accion></Opcion><Opcion><Codigo>37</Codigo><Descripcion>Verificaci�n del Manifiesto de Carga</Descripcion><NivelSuperior>37</NivelSuperior><Accion>37</Accion></Opcion><Opcion><Codigo>4</Codigo><Descripcion>Cancelaci�n del Tr�nsito</Descripcion><NivelSuperior>3</NivelSuperior><Accion>4</Accion></Opcion><Opcion><Codigo>5</Codigo><Descripcion>Acta de interveci�n - JUDIS</Descripcion><NivelSuperior>21</NivelSuperior><Accion>5</Accion></Opcion><Opcion><Codigo>6</Codigo><Descripcion>Elimina Sol. Garant�as</Descripcion><NivelSuperior>23</NivelSuperior><Accion>6</Accion></Opcion><Opcion><Codigo>7</Codigo><Descripcion>Habilita Medio por TNA</Descripcion><NivelSuperior>22</NivelSuperior><Accion>7</Accion></Opcion><Opcion><Codigo>8</Codigo><Descripcion>Aduana de Paso</Descripcion><NivelSuperior>4</NivelSuperior><Accion>8</Accion></Opcion><Opcion><Codigo>9</Codigo><Descripcion>Puntos de Control</Descripcion><NivelSuperior>6</NivelSuperior><Accion>9</Accion></Opcion></Opciones><Aduanas><Aduana><CodigoAduana>ALL</CodigoAduana></Aduana><Aduana><CodigoAduana>072</CodigoAduana></Aduana><Aduana><CodigoAduana>111</CodigoAduana></Aduana><Aduana><CodigoAduana>201</CodigoAduana></Aduana><Aduana><CodigoAduana>211</CodigoAduana></Aduana><Aduana><CodigoAduana>231</CodigoAduana></Aduana><Aduana><CodigoAduana>241</CodigoAduana></Aduana><Aduana><CodigoAduana>242</CodigoAduana></Aduana><Aduana><CodigoAduana>243</CodigoAduana></Aduana><Aduana><CodigoAduana>244</CodigoAduana></Aduana><Aduana><CodigoAduana>261</CodigoAduana></Aduana><Aduana><CodigoAduana>311</CodigoAduana></Aduana><Aduana><CodigoAduana>422</CodigoAduana></Aduana><Aduana><CodigoAduana>522</CodigoAduana></Aduana><Aduana><CodigoAduana>623</CodigoAduana></Aduana><Aduana><CodigoAduana>701</CodigoAduana></Aduana></Aduanas></GestionUsuario>";
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xml)));
            doc.getDocumentElement().normalize();

            Funcionario fun =  new Funcionario();                                                        
            fun.setNombreUsuario(ini.getUsuario().toUpperCase());
            fun.setNombreCompleto(GetTagXML(doc, "Usuario"));
            fun.setAduana(GetTagXML(doc, "Aduana"));
            fun.setCorreoElectronico(GetTagXML(doc, "Correo"));
            fun.setGerencia(GetTagXML(doc, "NombreGerencia"));
            fun.setUnidad(GetTagXML(doc, "NombreUnidad"));
            fun.setPerfiles(GetTagXML(doc, "Perfil"));
            
            request.getSession().setAttribute("funcionario",fun);
            request.getSession().setAttribute("user", ini.getUsuario().toUpperCase());
            request.getSession().setAttribute("user.codger", GetTagXML(doc, "CodigoGerencia"));
            request.getSession().setAttribute("gerencia", Util.gusuarioGerencia(GetTagXML(doc, "CodigoGerencia")));
            request.getSession().setAttribute("numerogerencia", Util.numeroGerencia(Util.gusuarioGerencia(GetTagXML(doc, "CodigoGerencia"))));
            
            request.getSession().setAttribute("estado_reg", "0");
            
            request.getSession().setAttribute("user.data", user);

            ClaseSession cs = new ClaseSession();
            request.getSession().setAttribute("ClaseSession", cs);
            cs.setUsuario(ini.getUsuario().toUpperCase());
            cs.setNombreUsuario(GetTagXML(doc, "Usuario"));
            cs.setPerfil(GetTagXML(doc, "Perfil"));
            cs.setNit(GetTagXML(doc, "Nit"));
                
            request.getSession().setAttribute("sgestion", "2017");
            request.getSession().setAttribute("sgerencia", Util.gusuarioGerencia(GetTagXML(doc, "CodigoGerencia")));
            request.getSession().setAttribute("scontrol", "-");
            request.getSession().setAttribute("snumero", "");
            /*cs.setCodGerencia(Integer.parseInt(GetTagXML(doc, "CodigoGerencia")));
            cs.setCodUnidad(Integer.parseInt(GetTagXML(doc, "CodigoUnidad")));
            cs.setNomGerencia(GetTagXML(doc, "NombreGerencia"));
            cs.setNomUnidad(GetTagXML(doc, "NombreUnidad"));
            cs.setCorreo(GetTagXML(doc, "Correo"));
            cs.setAduana(GetTagXML(doc, "Aduana"));*/
            cs.setNomAduana(ini.getNombreAduana());
            cs.setAduana(ini.getAduana());
            cs.setGestion(Log.GESTION);

            ini.getOpciones().clear();
            ini.setOpciones(new ArrayList());
            
            NodeList OpcionesLista =
                ((Element)doc.getElementsByTagName("Opciones").item(0)).getElementsByTagName("Opcion");
            if (OpcionesLista != null) {
                for (int i = 0; i < OpcionesLista.getLength(); i++) {
                    Element itemOpcion = (Element)OpcionesLista.item(i);
                    ClaseOpcion bean = new ClaseOpcion();                    
                    bean.setCodopc(GetTagXML(itemOpcion, "Codigo"));
                    bean.setDesc(GetTagXML(itemOpcion, "Descripcion"));
                    bean.setCodant(GetTagXML(itemOpcion, "NivelSuperior"));
                    bean.setAccion(GetTagXML(itemOpcion, "Accion"));
                    ini.getOpciones().add(bean);
                }
            }
            
            String aduana = cs.getAduana();
            String nit = cs.getNit();
            request.getSession().setAttribute("aduana", aduana);
            
            // Datos para el sistema de Notificaciones
            String USER = cs.getUsuario().toUpperCase();
            request.getSession().setAttribute("USER", USER);
            request.getSession().setAttribute("APP", Log.APP);
            //request.getSession().setAttribute("TOKEN", Notifica.saveToken(USER, APP, request.getLocalAddr(), request.getHeader("User-Agent")));
            // Fin de los datos para Notificaciones
            
            Log.USER = USER;
            Log.ADUANA = aduana;
            Log.NIT = nit;
            //Log.info("El usuario '" + Log.USER + "' ingreso al sistema", "LOGIN");
            request.getSession().setAttribute("opcion", opcionini);
            //request.getSession().setAttribute("opcion", "ok");
        } catch (Exception e) {
            errors.add("error", new ActionMessage("error", "No es posible autentificar el usuario y clave"));
            saveErrors(request, errors);
            e.printStackTrace();
            return mapping.findForward("nook");

        } finally {
            if (!errors.isEmpty()) {
                saveErrors(request, errors);
                return mapping.findForward("nook");
            }
        }

        //return mapping.findForward(accionini);
        return mapping.findForward("ok");
    }
    
    protected void readConfigProperties(HttpServletRequest request) throws IOException {
        
        // Leyendo propiedades de configuración
        Properties prop = new Properties();
        InputStream in = getClass().getResourceAsStream("config.properties");
        prop.load(in);
        
        // Datos del sistema
        Log.NOMBRE_SISTEMA = prop.getProperty("system.name");
        Log.APP = prop.getProperty("system.app");
        
        // JDBC para el módulo de persistencia
        Log.JDBC_MAIN = prop.getProperty("system.jdbc");
                
        // Datos del log
        Log.PKG_BASE = prop.getProperty("log.package.base");
        Log.PKG_BD = prop.getProperty("log.package.bd");
        Log.JDBC = prop.getProperty("log.jdbc");
        
        // Tablas de extraccion de informacion
        Log.TABLA_GENERAL = prop.getProperty("system.tabla.general");
        Log.TABLA_RELACION = prop.getProperty("system.tabla.relacion");
        
        request.getSession().setAttribute("NOMBRE_SISTEMA", Log.NOMBRE_SISTEMA);
        
        in.close();
    }
    
    protected void readVersion (HttpServletRequest request) throws IOException {
        // Leyendo propiedades de configuración
        Properties prop = new Properties();
        InputStream in = getClass().getResourceAsStream("config.properties");
        prop.load(in);
        
        Log.VERSION = prop.getProperty("system.version");
        Log.VERSION_ASSETS = prop.getProperty("system.version.assets");
        
        Calendar cal = Calendar.getInstance();
        Log.GESTION = cal.get(Calendar.YEAR);
        
        request.getSession().setAttribute("VERSION", Log.VERSION);
        request.getSession().setAttribute("VERSION_ASSETS", Log.VERSION_ASSETS);
        request.getSession().setAttribute("GESTION", Log.GESTION);
        
    }
    
    public static void init (HttpServletRequest request) throws IOException {
        InputAction i = new InputAction();
        i.readVersion(request);
        i.readConfigProperties(request);
    }
    
}
