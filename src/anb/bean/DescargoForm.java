package anb.bean;

import java.util.ArrayList;

public class DescargoForm extends ActionForm
{

    public DescargoForm()
    {
    }

    public void nuevo_descargo()
    {
        dsc_num = "";
        dsc_fec_dsc = "";
        dsc_fec_reg = "";
        dsc_doc = "";
        dsc_des = "";
        dsc_cnt = "";
        dsc_adi = "";
        dsc_lgr = "";
        dsc_fec_inc = "";
        dsc_usr = "";
        registros = new ArrayList();
    }

    public void limpiaFnc()
    {
        dsc_fec_dsc = null;
        dsc_hra_dsc = null;
        dsc_des = null;
        dsc_cnt = null;
        dsc_adm = null;
        dsc_adi = null;
        dsc_lgr = null;
        dsc_fec_inc = null;
        dsc_usr = null;
    }

    public String getDsc_num()
    {
        return dsc_num;
    }

    public void setDsc_num(String newDsc_num)
    {
        dsc_num = newDsc_num;
    }

    public String getDsc_fec_dsc()
    {
        return dsc_fec_dsc;
    }

    public void setDsc_fec_dsc(String newDsc_fec_dsc)
    {
        dsc_fec_dsc = newDsc_fec_dsc;
    }

    public String getDsc_fec_reg()
    {
        return dsc_fec_reg;
    }

    public void setDsc_fec_reg(String newDsc_fec_reg)
    {
        dsc_fec_reg = newDsc_fec_reg;
    }

    public String getDsc_doc()
    {
        return dsc_doc;
    }

    public void setDsc_doc(String newDsc_doc)
    {
        dsc_doc = newDsc_doc;
    }

    public String getDsc_des()
    {
        return dsc_des;
    }

    public void setDsc_des(String newDsc_des)
    {
        dsc_des = newDsc_des;
    }

    public String getDsc_cnt()
    {
        return dsc_cnt;
    }

    public void setDsc_cnt(String newDsc_cnt)
    {
        dsc_cnt = newDsc_cnt;
    }

    public String getDsc_adi()
    {
        return dsc_adi;
    }

    public void setDsc_adi(String newDsc_adi)
    {
        dsc_adi = newDsc_adi;
    }

    public String getDsc_lgr()
    {
        return dsc_lgr;
    }

    public void setDsc_lgr(String newDsc_lgr)
    {
        dsc_lgr = newDsc_lgr;
    }

    public String getDsc_fec_inc()
    {
        return dsc_fec_inc;
    }

    public void setDsc_fec_inc(String newDsc_fec_inc)
    {
        dsc_fec_inc = newDsc_fec_inc;
    }

    public String getDsc_usr()
    {
        return dsc_usr;
    }

    public void setDsc_usr(String newDsc_usr)
    {
        dsc_usr = newDsc_usr;
    }

    public String getBoton()
    {
        return boton;
    }

    public void setBoton(String newBoton)
    {
        boton = newBoton;
    }

    public int getVal()
    {
        return val;
    }

    public void setVal(int newVal)
    {
        val = newVal;
    }

    public int getPos()
    {
        return pos;
    }

    public void setPos(int newPos)
    {
        pos = newPos;
    }

    public String getDsc_adm()
    {
        return dsc_adm;
    }

    public void setDsc_adm(String newDsc_adm)
    {
        dsc_adm = newDsc_adm;
    }

    public int getLlave()
    {
        return llave;
    }

    public void setLlave(int newLlave)
    {
        llave = newLlave;
    }

    public String getDsc_doc_ges()
    {
        return dsc_doc_ges;
    }

    public void setDsc_doc_ges(String newDsc_doc_ges)
    {
        dsc_doc_ges = newDsc_doc_ges;
    }

    public String getDsc_doc_adm()
    {
        return dsc_doc_adm;
    }

    public void setDsc_doc_adm(String newDsc_doc_adm)
    {
        dsc_doc_adm = newDsc_doc_adm;
    }

    public String getDsc_doc_num()
    {
        return dsc_doc_num;
    }

    public void setDsc_doc_num(String newDsc_doc_num)
    {
        dsc_doc_num = newDsc_doc_num;
    }

    public String getBoton2()
    {
        return boton2;
    }

    public void setBoton2(String newBoton2)
    {
        boton2 = newBoton2;
    }

    public int getLlave2()
    {
        return llave2;
    }

    public void setLlave2(int newLlave2)
    {
        llave2 = newLlave2;
    }

    public String getDsc_doc_tpo()
    {
        return dsc_doc_tpo;
    }

    public void setDsc_doc_tpo(String newDsc_doc_tpo)
    {
        dsc_doc_tpo = newDsc_doc_tpo;
    }

    public String getDsc_doc_ges2()
    {
        return dsc_doc_ges2;
    }

    public void setDsc_doc_ges2(String newDsc_doc_ges2)
    {
        dsc_doc_ges2 = newDsc_doc_ges2;
    }

    public String getDsc_doc_adm2()
    {
        return dsc_doc_adm2;
    }

    public void setDsc_doc_adm2(String newDsc_doc_adm2)
    {
        dsc_doc_adm2 = newDsc_doc_adm2;
    }

    public String getDsc_doc_num2()
    {
        return dsc_doc_num2;
    }

    public void setDsc_doc_num2(String newDsc_doc_num2)
    {
        dsc_doc_num2 = newDsc_doc_num2;
    }

    public String getDsc_tpo()
    {
        return dsc_tpo;
    }

    public void setDsc_tpo(String newDsc_tpo)
    {
        dsc_tpo = newDsc_tpo;
    }

    public String getDsc_hra_dsc()
    {
        return dsc_hra_dsc;
    }

    public void setDsc_hra_dsc(String newDsc_hra_dsc)
    {
        dsc_hra_dsc = newDsc_hra_dsc;
    }

    public ArrayList getRegistros()
    {
        return registros;
    }

    public void setRegistros(ArrayList newRegistros)
    {
        registros = newRegistros;
    }

    public int getParaedit()
    {
        return paraedit;
    }

    public void setParaedit(int newParaedit)
    {
        paraedit = newParaedit;
    }

    public boolean isSw_enc()
    {
        return sw_enc;
    }

    public void setSw_enc(boolean newSw_enc)
    {
        sw_enc = newSw_enc;
    }

    public String getBoton_f()
    {
        return boton_f;
    }

    public void setBoton_f(String newBoton_f)
    {
        boton_f = newBoton_f;
    }

    public ArrayList getListad()
    {
        return listad;
    }

    public void setListad(ArrayList newListad)
    {
        listad = newListad;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int newIndex)
    {
        index = newIndex;
    }

    public String getKey_year()
    {
        return key_year;
    }

    public void setKey_year(String newKey_year)
    {
        key_year = newKey_year;
    }

    public String getKey_cuo()
    {
        return key_cuo;
    }

    public void setKey_cuo(String newKey_cuo)
    {
        key_cuo = newKey_cuo;
    }

    public String getReg_nber()
    {
        return reg_nber;
    }

    public void setReg_nber(String newReg_nber)
    {
        reg_nber = newReg_nber;
    }

    public String getReg_serial()
    {
        return reg_serial;
    }

    public void setReg_serial(String newReg_serial)
    {
        reg_serial = newReg_serial;
    }

    public String getKey_year2()
    {
        return key_year2;
    }

    public void setKey_year2(String newKey_year2)
    {
        key_year2 = newKey_year2;
    }

    public String getKey_cuo2()
    {
        return key_cuo2;
    }

    public void setKey_cuo2(String newKey_cuo2)
    {
        key_cuo2 = newKey_cuo2;
    }

    public String getReg_nber2()
    {
        return reg_nber2;
    }

    public void setReg_nber2(String newReg_nber2)
    {
        reg_nber2 = newReg_nber2;
    }

    public String getDesc1()
    {
        return desc1;
    }

    public void setDesc1(String newDesc1)
    {
        desc1 = newDesc1;
    }

    public String getDesc2()
    {
        return desc2;
    }

    public void setDesc2(String newDesc2)
    {
        desc2 = newDesc2;
    }

    public String getDesc3()
    {
        return desc3;
    }

    public void setDesc3(String newDesc3)
    {
        desc3 = newDesc3;
    }

    public String getBultos()
    {
        return bultos;
    }

    public void setBultos(String newBultos)
    {
        bultos = newBultos;
    }

    public String getVal_adm()
    {
        return val_adm;
    }

    public void setVal_adm(String newVal_adm)
    {
        val_adm = newVal_adm;
    }

    public int getYy()
    {
        return yy;
    }

    public void setYy(int newYy)
    {
        yy = newYy;
    }

    private String dsc_num;
    private String dsc_fec_dsc;
    private String dsc_fec_reg;
    private String dsc_doc;
    private String dsc_des;
    private String dsc_cnt;
    private String dsc_adi;
    private String dsc_lgr;
    private String dsc_fec_inc;
    private String dsc_usr;
    private String boton;
    private int val;
    private int pos;
    private String dsc_adm;
    private int llave;
    private String dsc_doc_ges;
    private String dsc_doc_adm;
    private String dsc_doc_num;
    private String boton2;
    private int llave2;
    private String dsc_doc_tpo;
    private String dsc_doc_ges2;
    private String dsc_doc_adm2;
    private String dsc_doc_num2;
    private String dsc_tpo;
    private String dsc_hra_dsc;
    private ArrayList registros;
    private int paraedit;
    private boolean sw_enc;
    private String boton_f;
    public ArrayList listad;
    private int index;
    private String key_year;
    private String key_cuo;
    private String reg_nber;
    private String reg_serial;
    private String key_year2;
    private String key_cuo2;
    private String reg_nber2;
    private String desc1;
    private String desc2;
    private String desc3;
    private String bultos;
    private String val_adm;
    private int yy;
}