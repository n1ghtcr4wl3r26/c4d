package anb.negocio;


import anb.entidades.Aduana;
import anb.entidades.Fiscalizador;
import anb.entidades.Gerencia;
import anb.entidades.InfoControl;
import anb.entidades.Paises;
import anb.entidades.Tramite;

import anb.general.Respuesta;

import anb.persistencia.GeneralDao;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.List;

import javax.naming.NamingException;

import org.apache.struts.upload.FormFile;


public class GeneralNeg {
    private final GeneralDao dao = new GeneralDao();
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
    
    public Respuesta<List<Aduana>> obtenerAduanas2() {
        Respuesta<List<Aduana>> respuesta = new Respuesta<List<Aduana>>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Aduana> res = dao.obtenerAduanas2();
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
    
    public Respuesta<List<Aduana>> obtenerAduanas(String gerencia) {
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
    public Respuesta<List<Aduana>> obtenerAduanas2(String gerencia) {
        Respuesta<List<Aduana>> respuesta = new Respuesta<List<Aduana>>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Aduana> res = dao.obtenerAduanas2(gerencia);
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
    
    public Respuesta<List<Paises>> obtenerPaises() {
        Respuesta<List<Paises>> respuesta = new Respuesta<List<Paises>>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Paises> res = dao.obtenerPaises();
                if (res == null && res.size() == 0) {
                    respuesta.setCodigo(0);
                    respuesta.setMensaje("No existen paises registrados");
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
    
    public Respuesta<List<Paises>> obtenerPaises2() {
        Respuesta<List<Paises>> respuesta = new Respuesta<List<Paises>>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Paises> res = dao.obtenerPaises2();
                if (res == null && res.size() == 0) {
                    respuesta.setCodigo(0);
                    respuesta.setMensaje("No existen paises registrados");
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
    
    public Respuesta<InfoControl> devuelveControl(String codigo) {
        Respuesta<InfoControl> respuesta = new Respuesta<InfoControl>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                InfoControl res = dao.devuelveControl(codigo);
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
    
   
    public Respuesta<InfoControl> devuelveConclusion(String codigo) {
        Respuesta<InfoControl> respuesta = new Respuesta<InfoControl>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                InfoControl res = dao.devuelveControl(codigo);
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
    public Respuesta<InfoControl> devuelveNotConclusion(String codigo) {
        Respuesta<InfoControl> respuesta = new Respuesta<InfoControl>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                InfoControl res = dao.devuelveControl(codigo);
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
    
    public Respuesta<List<Fiscalizador>> obtenerFiscalizadores(String Gerencia) {
        Respuesta<List<Fiscalizador>> respuesta = new Respuesta<List<Fiscalizador>>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Fiscalizador> res = dao.obtenerFiscalizadores(Gerencia);
                if (res == null && res.size() == 0) {
                    respuesta.setCodigo(0);
                    respuesta.setMensaje("No existen fiscalizadores registrados");
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
    
    public Respuesta<List<Fiscalizador>> obtenerFiscalizadoresT(String Gerencia) {
        Respuesta<List<Fiscalizador>> respuesta = new Respuesta<List<Fiscalizador>>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Fiscalizador> res = dao.obtenerFiscalizadoresT(Gerencia);
                if (res == null && res.size() == 0) {
                    respuesta.setCodigo(0);
                    respuesta.setMensaje("No existen fiscalizadores registrados");
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
    
    public Respuesta<List<Fiscalizador>> obtenerSupervisores(String Gerencia) {
        Respuesta<List<Fiscalizador>> respuesta = new Respuesta<List<Fiscalizador>>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Fiscalizador> res = dao.obtenerSupervisores(Gerencia);
                if (res == null && res.size() == 0) {
                    respuesta.setCodigo(0);
                    respuesta.setMensaje("No existen supervisores registrados");
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
    
    public Respuesta<List<Fiscalizador>> obtenerSupervisoresT(String Gerencia) {
        Respuesta<List<Fiscalizador>> respuesta = new Respuesta<List<Fiscalizador>>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Fiscalizador> res = dao.obtenerSupervisoresT(Gerencia);
                if (res == null && res.size() == 0) {
                    respuesta.setCodigo(0);
                    respuesta.setMensaje("No existen supervisores registrados");
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
    
    public Respuesta<List<Fiscalizador>> obtenerFuncionarios(String Gerencia) {
        Respuesta<List<Fiscalizador>> respuesta = new Respuesta<List<Fiscalizador>>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Fiscalizador> res = dao.obtenerFuncionarios(Gerencia);
                if (res == null && res.size() == 0) {
                    respuesta.setCodigo(0);
                    respuesta.setMensaje("No existen funcionarios registrados");
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
    
    public Respuesta<List<Gerencia>> obtenerGerencias(String Gerencia) {
        Respuesta<List<Gerencia>> respuesta = new Respuesta<List<Gerencia>>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Gerencia> res = dao.obtenerGerencias(Gerencia);
                if (res == null && res.size() == 0) {
                    respuesta.setCodigo(0);
                    respuesta.setMensaje("No existen gerencias registrados");
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
    
    public Respuesta<Tramite[]> ver_TramitesControl(String codigo) {
        Respuesta<Tramite[]> respuesta = new Respuesta<Tramite[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Tramite> result = dao.tramites(codigo);
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
    
    public Respuesta<Tramite[]> ver_TramitesControlxls(String codigo) {
        Respuesta<Tramite[]> respuesta = new Respuesta<Tramite[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Tramite> result = dao.tramitesxls(codigo);
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
    
    public Respuesta<Boolean> devuelveCodigo(String gestion,String tipo, String gerencia, String numero){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.devuelveCodigo(gestion, tipo, gerencia, numero);
                if (result == null) {
                    respuesta.setMensaje("No existe el control");
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
    
    public Respuesta<Fiscalizador[]> devuelveFisAsignados(String codigo) {
        Respuesta<Fiscalizador[]> respuesta = new Respuesta<Fiscalizador[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Fiscalizador> result = dao.devuelveFisAsignados(codigo);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new Fiscalizador[result.size()]));
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
    
    public Respuesta<Fiscalizador[]> devuelveFisAccesos(String codigo) {
        Respuesta<Fiscalizador[]> respuesta = new Respuesta<Fiscalizador[]>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                List<Fiscalizador> result = dao.devuelveFisAccesos(codigo);
                if (result == null || result.size() == 0) {
                    respuesta.setMensaje("No existen registros");
                    respuesta.setCodigo(0);
                } else {
                    respuesta.setCantidad(result.size());
                    respuesta.setCodigo(1);
                    respuesta.setMensaje("OK");
                    respuesta.setResultado(result.toArray(new Fiscalizador[result.size()]));
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
    
    // SUBIR ARCHIVOS 
    public Respuesta<String> subirArchivo(FormFile file, String codigo) {
        Respuesta<String> respuesta = new Respuesta<String>();
        respuesta.setCodigo(-1);
        if (estaConectadoBd()) {
            try {
                SimpleDateFormat fFecha = new SimpleDateFormat("yyyyMMddHHmmss");
                Calendar fecha = Calendar.getInstance();
                fecha.setTime(fecha.getTime());
                String fecmarca = fFecha.format(fecha.getTime());
                String ruta = "/u03/oracle/user_projects/data/fiscalizacion/resultados/";
                String filename = codigo+"-"+fecmarca+".xlsx";                
                InputStream stream = file.getInputStream();
                OutputStream bos = new FileOutputStream(ruta+filename);
                int bytesRead = 0;
                byte buffer[] = new byte[8192];
                while((bytesRead = stream.read(buffer, 0, 8192)) != -1) 
                    bos.write(buffer, 0, bytesRead);
                bos.close();
                respuesta.setCantidad(1);
                respuesta.setCodigo(1);
                respuesta.setMensaje("OK");
                respuesta.setResultado(ruta+filename);
            } catch(Exception e) {
                respuesta.setMensaje("Error no identificado -  " + e.getMessage());
            }
            
        } else {
            respuesta.setMensaje("Error. No se puede conectar a la base de datos.");
        }
        return respuesta;
    }
    public Respuesta<Boolean> verificaAccesoUsuario(String idControl,String usuario, String opcion, String gerencia){
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        respuesta.setResultado(false);
        if (estaConectadoBd()) {
            try {
                String result = dao.verificaAccesoUsuario(idControl, usuario, opcion, gerencia);
                if (result == null) {
                    respuesta.setMensaje("NOCORRECTO");
                } else if (result.equals(CORRECTO_BD)) {
                    respuesta.setCodigo(1);
                    respuesta.setMensaje(result);
                    respuesta.setResultado(true);
                } else {
                    respuesta.setCodigo(0);
                    respuesta.setMensaje(result);
                    respuesta.setResultado(false);
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
