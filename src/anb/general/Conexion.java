package anb.general;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;


/*
*   Nombre de la clase: conexion, metodos de conexion al esquema de la base de datos
*
*   Fecha creación, Fecha Modificación
*
*   Autor creador, Autor Modificador
*/
public class Conexion {
    protected InitialContext ic = null;
    protected DataSource ds;
    protected Connection cn = null;
    protected Statement st = null;
    protected CallableStatement call = null;
    protected ResultSet rs = null;
    private boolean transaccional = false;

    public static final int MODO_TRANSACCIONAL = 1;
    public Conexion(){
    }

    protected void open() throws ClassNotFoundException, SQLException, NamingException {
        ic = new InitialContext();
        ds = (DataSource)ic.lookup(Log.JDBC_MAIN);
        cn = ds.getConnection();
        st = cn.createStatement();
    }
    
    protected void open(String jdbc) throws ClassNotFoundException, SQLException, NamingException {
        ic = new InitialContext();
        ds = (DataSource)ic.lookup(jdbc);
        cn = ds.getConnection();
        st = cn.createStatement();
    }

    public void close() {
        try {
            if (st != null){
                st.close();
            }
            if (cn != null) {
                cn.close();
                cn = null;
            }
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (call != null) {
                call.close();
                call = null;
            }            
            cn = null;
            st = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void close(Connection con, ResultSet res) {
        try {
            if (res != null) {
                res.close();
                res = null;
            }
            if (con != null) {
                con.close();
                con = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Connection abrirConexion() throws SQLException, NamingException {
      InitialContext ic = new InitialContext();
      DataSource ds;
      ds=(DataSource)ic.lookup(Log.JDBC_MAIN);
      cn=ds.getConnection();
      st=cn.createStatement();
      return cn;      
    }
    
    public void setTransaccional(boolean transaccional) {
        this.transaccional = transaccional;
    }

    public boolean esTransaccional() {
        return transaccional;
    }

}
