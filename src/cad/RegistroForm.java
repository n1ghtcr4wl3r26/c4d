// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 16/05/2012 12:09:58
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   RegistroForm.java

package cad;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class RegistroForm extends ActionForm
{

    public RegistroForm()
    {
    }

    public void reset(ActionMapping mapping, HttpServletRequest request)
    {
        super.reset(mapping, request);
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
    {
        return super.validate(mapping, request);
    }

    public String getDsc_tpo()
    {
        return dsc_tpo;
    }

    public void setDsc_tpo(String newDsc_tpo)
    {
        dsc_tpo = newDsc_tpo;
    }

    public String getDsc_doc_ges()
    {
        return dsc_doc_ges;
    }

    public void setDsc_doc_ges(String newDsc_doc_ges)
    {
        dsc_doc_ges = newDsc_doc_ges;
    }

    public String getDsc_doc_ges2()
    {
        return dsc_doc_ges2;
    }

    public void setDsc_doc_ges2(String newDsc_doc_ges2)
    {
        dsc_doc_ges2 = newDsc_doc_ges2;
    }

    public String getDsc_doc_adm()
    {
        return dsc_doc_adm;
    }

    public void setDsc_doc_adm(String newDsc_doc_adm)
    {
        dsc_doc_adm = newDsc_doc_adm;
    }

    public String getDsc_doc_adm2()
    {
        return dsc_doc_adm2;
    }

    public void setDsc_doc_adm2(String newDsc_doc_adm2)
    {
        dsc_doc_adm2 = newDsc_doc_adm2;
    }

    public String getDsc_doc_num()
    {
        return dsc_doc_num;
    }

    public void setDsc_doc_num(String newDsc_doc_num)
    {
        dsc_doc_num = newDsc_doc_num;
    }

    public String getDsc_doc_num2()
    {
        return dsc_doc_num2;
    }

    public void setDsc_doc_num2(String newDsc_doc_num2)
    {
        dsc_doc_num2 = newDsc_doc_num2;
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

    public String getDsc_hra_dsc()
    {
        return dsc_hra_dsc;
    }

    public void setDsc_hra_dsc(String newDsc_hra_dsc)
    {
        dsc_hra_dsc = newDsc_hra_dsc;
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

    public String getDsc_adm()
    {
        return dsc_adm;
    }

    public void setDsc_adm(String newDsc_adm)
    {
        dsc_adm = newDsc_adm;
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

    public String getReg_serial()
    {
        return reg_serial;
    }

    public void setReg_serial(String newReg_serial)
    {
        reg_serial = newReg_serial;
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

    public String getKey_cuo2()
    {
        return key_cuo2;
    }

    public void setKey_cuo2(String newKey_cuo2)
    {
        key_cuo2 = newKey_cuo2;
    }

    public String getKey_year2()
    {
        return key_year2;
    }

    public void setKey_year2(String newKey_year2)
    {
        key_year2 = newKey_year2;
    }

    public String getReg_nber2()
    {
        return reg_nber2;
    }

    public void setReg_nber2(String newReg_nber2)
    {
        reg_nber2 = newReg_nber2;
    }

    public String getRadio()
    {
        return radio;
    }

    public void setRadio(String newRadio)
    {
        radio = newRadio;
    }

    private String dsc_tpo;
    private String dsc_doc_ges;
    private String dsc_doc_ges2;
    private String dsc_doc_adm;
    private String dsc_doc_adm2;
    private String dsc_doc_num;
    private String dsc_doc_num2;
    private String boton;
    private int val;
    private String dsc_num;
    private String dsc_fec_dsc;
    private String dsc_hra_dsc;
    private String dsc_des;
    private String dsc_cnt;
    private String dsc_adm;
    private String dsc_adi;
    private String dsc_lgr;
    private String dsc_fec_inc;
    private String dsc_usr;
    private String reg_serial;
    private String key_year;
    private String key_cuo;
    private String reg_nber;
    private String key_cuo2;
    private String key_year2;
    private String reg_nber2;
    private String radio;
}