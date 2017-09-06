package anb.persistencia;


import anb.bean.CuadroLiquidacionForm;

import anb.entidades.CuadroLiquidacion;

import anb.general.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import oracle.jdbc.OracleTypes;


public class CuadroLiquidacionDao extends Conexion {
    public List<CuadroLiquidacion> devuelveCuadroLiq(CuadroLiquidacionForm bean) throws SQLException,
                                                                                        ClassNotFoundException,
                                                                                        NamingException {
        List<CuadroLiquidacion> htls = new ArrayList<CuadroLiquidacion>();
        int cont = 1;
        String error = "";
        try {
            open();
            call = cn.prepareCall("{ ? = call pkg_reporte.dev_liquidacion (?)}");
            call.registerOutParameter(1, OracleTypes.CURSOR);
            call.setString(2, bean.getCodigo());
            call.execute();
            DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
            simbolo.setDecimalSeparator('.');
            simbolo.setGroupingSeparator(',');
            DecimalFormat formato = new DecimalFormat("#,###,###.##", simbolo);
            formato.setMaximumFractionDigits(2);
            formato.setMinimumFractionDigits(2);
            
            DecimalFormat formatoufv = new DecimalFormat("#,###,###.#####", simbolo);
            formatoufv.setMaximumFractionDigits(5);
            formatoufv.setMinimumFractionDigits(5);

            rs = (ResultSet)call.getObject(1);
            while (rs.next()) {
                CuadroLiquidacion ht = new CuadroLiquidacion();
                ht.setSequencia(String.valueOf(cont++));
                ht.setItem(rs.getString(1));
                ht.setSubpartidadec(rs.getString(2));
                ht.setSubpartidadet(rs.getString(3));
                ht.setGestion(rs.getString(4));
                ht.setAduana(rs.getString(5));
                ht.setSerial("C");
                ht.setNumero(rs.getString(6));
                ht.setFechaval(rs.getString(7));
                ht.setFechavcto(rs.getString(8));
                ht.setFechacalculo(rs.getString(9));

                ht.setDecfobusd(formato.format(rs.getFloat(10)));
                ht.setDecfleteusd(formato.format(rs.getFloat(11)));
                ht.setDecsegurousd(formato.format(rs.getFloat(12)));
                ht.setDecotrosusd(formato.format(rs.getFloat(13)));
                ht.setDeccifusd(formato.format(rs.getFloat(14)));
                ht.setDectc(formato.format(rs.getFloat(15)));
                ht.setDeccifbs(formato.format(rs.getFloat(16)));
                ht.setDecga(formato.format(rs.getFloat(17)));
                ht.setDeciva(formato.format(rs.getFloat(18)));
                ht.setDecice(formato.format(rs.getFloat(19)));
                ht.setDeciehd(formato.format(rs.getFloat(20)));
                ht.setDecicd(formato.format(rs.getFloat(21)));

                String fob2 = rs.getString(22);
                ht.setDetfobusd(formato.format(rs.getFloat(22)));
                ht.setDetfleteusd(formato.format(rs.getFloat(23)));
                ht.setDetsegurousd(formato.format(rs.getFloat(24)));
                ht.setDetotrosusd(formato.format(rs.getFloat(25)));
                ht.setDetcifusd(formato.format(rs.getFloat(26)));
                ht.setDettc(formato.format(rs.getFloat(27)));
                ht.setDetcifbs(formato.format(rs.getFloat(28)));
                ht.setDetga(formato.format(rs.getFloat(29)));
                ht.setDetiva(formato.format(rs.getFloat(30)));
                ht.setDetice(formato.format(rs.getFloat(31)));
                ht.setDetiehd(formato.format(rs.getFloat(32)));
                ht.setDeticd(formato.format(rs.getFloat(33)));

                ht.setUfvvenc(formatoufv.format(rs.getFloat(34)));

                ht.setToga(formato.format(rs.getFloat(35)));
                ht.setToiva(formato.format(rs.getFloat(36)));
                ht.setToice(formato.format(rs.getFloat(37)));
                ht.setToiehd(formato.format(rs.getFloat(38)));
                ht.setToicd(formato.format(rs.getFloat(39)));
                ht.setTototal(formato.format(rs.getFloat(40)));

                ht.setToufvga(formato.format(rs.getFloat(41)));
                ht.setToufviva(formato.format(rs.getFloat(42)));
                ht.setToufvice(formato.format(rs.getFloat(43)));
                ht.setToufviehd(formato.format(rs.getFloat(44)));
                ht.setToufvicd(formato.format(rs.getFloat(45)));
                ht.setToufvtotal(formato.format(rs.getFloat(46)));

                ht.setDias(rs.getString(47));
                ht.setFormula(rs.getString(48));

                ht.setIga(formato.format(rs.getFloat(49)));
                ht.setIiva(formato.format(rs.getFloat(50)));
                ht.setIice(formato.format(rs.getFloat(51)));
                ht.setIiehd(formato.format(rs.getFloat(52)));
                ht.setIicd(formato.format(rs.getFloat(53)));
                ht.setItotal(formato.format(rs.getFloat(54)));

                ht.setDtufvga(formato.format(rs.getFloat(55)));
                ht.setDtufviva(formato.format(rs.getFloat(56)));
                ht.setDtufvice(formato.format(rs.getFloat(57)));
                ht.setDtufviehd(formato.format(rs.getFloat(58)));
                ht.setDtufvicd(formato.format(rs.getFloat(59)));
                ht.setDtufvtotal(formato.format(rs.getFloat(60)));

                ht.setSancion(formato.format(rs.getFloat(61)));
                ht.setAdeudo_totalbs(formato.format(rs.getFloat(62)));
                ht.setAdeudo_totalufv(formato.format(rs.getFloat(63)));

                ht.setUfvhoy(formatoufv.format(rs.getFloat(64)));
                /*
                ht.setDecfobusd(rs.getString(10));
                String fob1 = rs.getString(10);
                ht.setDecfleteusd(Util.completaCerosDecimal(rs.getString(11)));
                ht.setDecsegurousd(Util.completaCerosDecimal(rs.getString(12)));
                ht.setDecotrosusd(Util.completaCerosDecimal(rs.getString(13)));
                ht.setDeccifusd(Util.completaCerosDecimal(rs.getString(14)));
                ht.setDectc(Util.completaCerosDecimal(rs.getString(15)));
                ht.setDeccifbs(Util.completaCerosDecimal(rs.getString(16)));
                ht.setDecga(Util.completaCerosDecimal(rs.getString(17)));
                ht.setDeciva(Util.completaCerosDecimal(rs.getString(18)));
                ht.setDecice(Util.completaCerosDecimal(rs.getString(19)));
                ht.setDeciehd(Util.completaCerosDecimal(rs.getString(20)));
                ht.setDecicd(Util.completaCerosDecimal(rs.getString(21)));

                String fob2 = rs.getString(22);
                ht.setDetfobusd(Util.completaCerosDecimal(rs.getString(22)));
                ht.setDetfleteusd(Util.completaCerosDecimal(rs.getString(23)));
                ht.setDetsegurousd(Util.completaCerosDecimal(rs.getString(24)));
                ht.setDetotrosusd(Util.completaCerosDecimal(rs.getString(25)));
                ht.setDetcifusd(Util.completaCerosDecimal(rs.getString(26)));
                ht.setDettc(Util.completaCerosDecimal(rs.getString(27)));
                ht.setDetcifbs(Util.completaCerosDecimal(rs.getString(28)));
                ht.setDetga(Util.completaCerosDecimal(rs.getString(29)));
                ht.setDetiva(Util.completaCerosDecimal(rs.getString(30)));
                ht.setDetice(Util.completaCerosDecimal(rs.getString(31)));
                ht.setDetiehd(Util.completaCerosDecimal(rs.getString(32)));
                ht.setDeticd(Util.completaCerosDecimal(rs.getString(33)));

                ht.setUfvvenc(Util.completaCerosDecimal(rs.getString(34)));

                ht.setToga(Util.completaCerosDecimal(rs.getString(35)));
                ht.setToiva(Util.completaCerosDecimal(rs.getString(36)));
                ht.setToice(Util.completaCerosDecimal(rs.getString(37)));
                ht.setToiehd(Util.completaCerosDecimal(rs.getString(38)));
                ht.setToicd(Util.completaCerosDecimal(rs.getString(39)));
                ht.setTototal(Util.completaCerosDecimal(rs.getString(40)));

                ht.setToufvga(Util.completaCerosDecimal(rs.getString(41)));
                ht.setToufviva(Util.completaCerosDecimal(rs.getString(42)));
                ht.setToufvice(Util.completaCerosDecimal(rs.getString(43)));
                ht.setToufviehd(Util.completaCerosDecimal(rs.getString(44)));
                ht.setToufvicd(Util.completaCerosDecimal(rs.getString(45)));
                ht.setToufvtotal(Util.completaCerosDecimal(rs.getString(46)));

                ht.setDias(rs.getString(47));
                ht.setFormula(rs.getString(48));

                ht.setIga(Util.completaCerosDecimal(rs.getString(49)));
                ht.setIiva(Util.completaCerosDecimal(rs.getString(50)));
                ht.setIice(Util.completaCerosDecimal(rs.getString(51)));
                ht.setIiehd(Util.completaCerosDecimal(rs.getString(52)));
                ht.setIicd(Util.completaCerosDecimal(rs.getString(53)));
                ht.setItotal(Util.completaCerosDecimal(rs.getString(54)));

                ht.setDtufvga(Util.completaCerosDecimal(rs.getString(55)));
                ht.setDtufviva(Util.completaCerosDecimal(rs.getString(56)));
                ht.setDtufvice(Util.completaCerosDecimal(rs.getString(57)));
                ht.setDtufviehd(Util.completaCerosDecimal(rs.getString(58)));
                ht.setDtufvicd(Util.completaCerosDecimal(rs.getString(59)));
                ht.setDtufvtotal(Util.completaCerosDecimal(rs.getString(60)));

                ht.setSancion(Util.completaCerosDecimal(rs.getString(61)));
                ht.setAdeudo_totalbs(Util.completaCerosDecimal(rs.getString(62)));
                ht.setAdeudo_totalufv(Util.completaCerosDecimal(rs.getString(63)));
*/
                htls.add(ht);
            }

        } catch (Exception ex) {
            error = ex.toString();
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return htls;
    }

}
