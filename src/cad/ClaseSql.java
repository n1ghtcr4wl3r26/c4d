package cad;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.util.Iterator;
import java.util.Vector;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.servlet.http.HttpServletRequest;

import javax.sql.PooledConnection;

import oracle.jdbc.OracleTypes;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;


public class ClaseSql {
  private PooledConnection pc = null;
  public Connection cn = null;
  public Statement st = null;

  public void getConexion() throws SQLException, NamingException {
    InitialContext ic = new InitialContext();
    OracleConnectionPoolDataSource pd = (OracleConnectionPoolDataSource) ic.lookup("jdbc/asy_cad");
    pc = pd.getPooledConnection();
    cn = pc.getConnection();
    st = cn.createStatement();
  }

  public void getClose() {
    try {
      if (st != null) {
        st.close();
      }

      if (cn != null) {
        cn.close();
      }

      if (pc != null) {
        pc.close();
      }

      pc = null;
      cn = null;
      st = null;
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  private String[] split(String cadena_i, String caracter_i) {
    Vector split = new Vector();
    int i = -1;
    int j = 0;
    boolean flag = true;

    while (flag) {
      j = cadena_i.indexOf(caracter_i, i + 1);
      flag = j >= 0;

      if (flag) {
        if (j == (i + 1)) {
          split.add("");
        } else {
          split.add(cadena_i.substring(i + 1, j));
        }

        i = j;
      } else {
        split.add(cadena_i.substring(i + 1));
      }
    }

    String[] items = new String[split.size()];
    items = (String[]) split.toArray(items);

    return items;
  }

}
