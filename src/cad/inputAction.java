// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 17/12/2011 19:30:12
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   inputAction.java

package cad;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cliente.ClaseEnvio;
import cliente.ServiciosUsuario;
import cliente.bean.ClaseUsuario;
import cliente.bean.ClaseOpcion;

import java.io.StringReader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
//******
import org.w3c.dom.Document;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import org.xml.sax.InputSource;
//******


// Referenced classes of package selectividad:
//            inputActionForm, WsUsuarioStub

public class inputAction extends Action 
{
  /**
   * This is the main action called from the Struts framework.
   * @param mapping The ActionMapping used to select this instance.
   * @param form The optional ActionForm bean for this request.
   * @param request The HTTP Request we are processing.
   * @param response The HTTP Response we are processing.
   */
  
  
  //*********
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
  //*******
  
  
  
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  { 
    request.getSession().removeAttribute("ClaseSession");
    request.getSession().removeAttribute("ClaseUsuario");
    request.getSession().removeAttribute("inputActionForm");          
    request.getSession().removeAttribute("user.nick"); 
    //HttpSession sesion = request.getSession(); //instancia sesion con la sesion actual      
    //*****ClaseUsuario user=null;

    inputActionForm login = (inputActionForm) form;
    request.getSession().setAttribute("inputActionForm", login);      
    //sesion.setAttribute("inputActionForm", login);       

    ActionMessages mensaje = new ActionMessages();    
    try{   
        
        ServiciosUsuario serviciosUsuario=new ServiciosUsuario();        
        ClaseEnvio claseEnvio=serviciosUsuario.getServiciosUsuario();                
        List<ClaseOpcion> lista = new ArrayList<ClaseOpcion>(); 
        
        
        //****** INI AUTENTICACION CON EL VIRTUAL
                String xmlv="";
                String vparam=request.getParameter("vsessionid");   
                DocumentBuilderFactory factoryv = DocumentBuilderFactory.newInstance();
                DocumentBuilder builderv = factoryv.newDocumentBuilder();        
                if(vparam!=null){
                    try {
                        xmlv=claseEnvio.fUsuarioVirtual(vparam);
                        Document doc = builderv.parse(new InputSource(new StringReader(xmlv)));
                        doc.getDocumentElement().normalize();
                        login.setUsuario(GetTagXML(doc, "Usuario"));
                        login.setClave(GetTagXML(doc, "Clave"));
                    }catch (Exception ex) {
                        ;
                    }                            
                }
                //***** FIN AUTENTICACION CON EL VIRTUAL 
        
        //**********
                String xml=claseEnvio.listaOpcionesXML(login.getUsuario().toUpperCase(),login.getClave(),"CAD"); // (USUARIO,CLAVE, NOMBRE DEL SISTEMA)
                     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                     DocumentBuilder builder = factory.newDocumentBuilder();        
                     Document doc = builder.parse(new InputSource(new StringReader(xml)));
                     doc.getDocumentElement().normalize();       


        String Usuario=GetTagXML(doc, "Usuario");
        String Perfil=GetTagXML(doc, "Perfil");
        
        //****************
                
        //***********
        /*
        String vPerfilSidunea="NINGUNO";
        try{                         
            user=claseEnvio.listaOpciones(login.getUsuario().toUpperCase(),login.getClave(), "REPSEL");
            if(user==null){
                login.setFmensaje(modelo.creamensaje("2", "No es posible autentificar el usuario y clave", "20"));
                               request.setAttribute("inputActionForm", login);
                return mapping.findForward("nook");
            }
        }catch ( Exception e ){          
            login.setFmensaje(modelo.creamensaje("2", "No es posible autentificar el usuario y clave", "20"));
                           request.setAttribute("inputActionForm", login);
                return mapping.findForward("nook");
           
        }
*/
        
        
        /*ClaseUsuario cs = (ClaseUsuario) request.getSession().getAttribute("ClaseUsuario");                      
        cs = new ClaseUsuario();*/
        ClaseUsuario cs = new ClaseUsuario();
        request.getSession().setAttribute("ClaseUsuario", cs);      
        cs.setUsuario(login.getUsuario().toUpperCase());
        
        //cs.setPerfil(user.getPerfil());           
        cs.setPerfil(GetTagXML(doc, "Perfil"));
        
        request.getSession().setAttribute("user.nick", login.getUsuario().toUpperCase());
        request.getSession().setAttribute("user", login.getUsuario().toUpperCase());
        
        
        //request.getSession().setAttribute("user.data", user);
        
        //*****request.getSession().setAttribute("user.perfil", user.getPerfil());
        request.getSession().setAttribute("user.perfil", GetTagXML(doc, "Perfil"));
        //****request.getSession().setAttribute("user.codent", user.getAduana());
        request.getSession().setAttribute("user.codent", GetTagXML(doc, "Aduana"));
        
        
        request.getSession().setAttribute("ops", "A");
        //request.getSession().setAttribute("ok","1"); 
        
        
        /*lista=claseEnvio.listaOpcionesSistema("REPSEL", GetTagXML(doc, "Perfil"));                        
        login.getOpciones().clear();
        login.setOpciones(new ArrayList());
        Iterator i=lista.iterator();        
        while(i.hasNext()) {
            ClaseOpcion bean = (ClaseOpcion)i.next();            
            login.getOpciones().add(bean);
            }
        */
        
        
        
        
        int sw = 0;
        login.getOpciones().clear();
        login.setOpciones(new ArrayList());
                NodeList OpcionesLista =((Element)doc.getElementsByTagName("Opciones").item(0)).getElementsByTagName("Opcion");
                if (OpcionesLista != null) {
                    for (int i = 0; i < OpcionesLista.getLength(); i++) {
                        Element itemOpcion = (Element)OpcionesLista.item(i);                
                        ClaseOpcion bean=new ClaseOpcion();
                        if(GetTagXML(itemOpcion,"Codigo").equals(92))
                            sw=1;
                        bean.setCodopc(GetTagXML(itemOpcion,"Codigo"));
                        bean.setDesc(GetTagXML(itemOpcion,"Descripcion"));
                        bean.setCodant(GetTagXML(itemOpcion,"NivelSuperior"));
                        bean.setAccion(GetTagXML(itemOpcion,"Accion"));
                        login.getOpciones().add(bean);                
                    } 
                    if(sw==0)
                    {
                        ClaseOpcion bean=new ClaseOpcion();
                        /*
                        bean.setCodopc("91");
                        bean.setDesc("MISCELANEOS");
                        bean.setCodant("0");
                        bean.setAccion("");
                        login.getOpciones().add(bean); 
                        bean=new ClaseOpcion();
                        */
                        bean.setCodopc("98");
                        bean.setDesc("Cambiar Contrase&ntilde;a");
                        bean.setCodant("91");
                        bean.setAccion("cam.usu");
                        login.getOpciones().add(bean); 
                        bean=new ClaseOpcion();
                        bean.setCodopc("99");
                        bean.setDesc("Salir");
                        bean.setCodant("91");
                        bean.setAccion("sal.usu");
                        login.getOpciones().add(bean); 
                    }
                }
        
        
        
        
        return mapping.findForward("ok");
    }catch ( Exception e ){
        login.setFmensaje(Util.creamensaje("2", "No es posible autentificar el usuario y clave", "20"));
                       request.setAttribute("inputActionForm", login);
    }finally {
          if (!mensaje.isEmpty()) {
              saveErrors(request, mensaje);
          }
    }
    return mapping.findForward("nook"); 
  }
}