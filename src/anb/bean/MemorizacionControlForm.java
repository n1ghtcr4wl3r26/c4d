package anb.bean;

import org.apache.struts.action.ActionForm;

public class MemorizacionControlForm extends ActionForm {

    private String tipoControl;
    private String tab;
    private String gerencia;
    
    private String mgestion;
    private String maduana;
    private String mnumero;
    
    private String fropcion;
    private String frcodigo;
    
    private String fecIni;
    private String fecFin;
    private String aduana;
    private String codigo;
    private String opcion;
    private String usuarioger; 
    private int cantidad_dec;
    
    private String fd1FecIni;
    private String fd1FecFin;
    private String fd1Aduana;
    
    private String fd2FecIni;
    private String fd2FecFin;
    private String fd2Aduana;
    private String fd2Importador;
    
    private String fd3Gestion;
    private String fd3Aduana;
    private String fd3Numero;

    private String posTipoDocumento;
    private String posNroDocumento;
    private String posFecDocumento;
    private String posDetDocumento;
    private String posRiesgoIdentificado;
    private String posTipoDocPersona;
    private String posNitEmpresa;
    private String posNomEmpresa;
    private String posNroCIPersona;
    private String posExpCIPersona;
    private String posNombrePersona;
    private String posApPatPersona;
    private String posApMatPersona;
    private String posDireccion;
    private String posActividad;
    private String posTipoOperador;
    
    private String posTribTodos;
    private String posTribGa;
    private String posTribIva;
    private String posTribIce;
    private String posTribIehd;
    private String posTribIcd;
    private String posTribNoaplica;
    private String posPeriodo;
    
    private String posRiesgoDelito;
    private String posRiesgoSubval;
    private String posRiesgoClas;
    private String posRiesgoContrab;
    
    private String ampNroOrden;
    private String ampTipoDocPersona;
    private String ampNitEmpresa;
    private String ampNomEmpresa;
    private String ampNroCIPersona;
    private String ampExpCIPersona;
    private String ampNombrePersona;
    private String ampApPatPersona;
    private String ampApMatPersona;
    private String ampDireccion;
    private String ampActividad;
    private String ampGestion;
    private String ampControl;
    private String ampGerencia;
    private String ampNumero;
    private String ampTipoOperador;

    private String difTipoDocumento;
    private String difNroDocumento;
    private String difFecDocumento;
    private String difDetDocumento;
    private String difRiesgoIdentificado;
    private String difTipoDocPersona;
    private String difNitEmpresa;
    private String difNomEmpresa;
    private String difNroCIPersona;
    private String difExpCIPersona;
    private String difNombrePersona;
    private String difApPatPersona;
    private String difApMatPersona;
    private String difDireccion;
    private String difActividad;
    private String difTipoOperador;
    
    private String difTribTodos;
    private String difTribGa;
    private String difTribIva;
    private String difTribIce;
    private String difTribIehd;
    private String difTribIcd;
    private String difTribNoaplica;
    private String difPeriodo;
    
    private String difRiesgoDelito;
    private String difRiesgoSubval;
    private String difRiesgoClas;
    private String difRiesgoContrab;

    private String boton;
    private String usuario;
    private String codigocontrol;

    public void setTipoControl(String tipoControl) {
        this.tipoControl = tipoControl;
    }

    public String getTipoControl() {
        return tipoControl;
    }

    public void setPosTipoDocumento(String posTipoDocumento) {
        this.posTipoDocumento = posTipoDocumento;
    }

    public String getPosTipoDocumento() {
        return posTipoDocumento;
    }

    public void setPosNroDocumento(String posNroDocumento) {
        this.posNroDocumento = posNroDocumento;
    }

    public String getPosNroDocumento() {
        return posNroDocumento;
    }

    public void setPosFecDocumento(String posFecDocumento) {
        this.posFecDocumento = posFecDocumento;
    }

    public String getPosFecDocumento() {
        return posFecDocumento;
    }

    public void setPosDetDocumento(String posDetDocumento) {
        this.posDetDocumento = posDetDocumento;
    }

    public String getPosDetDocumento() {
        return posDetDocumento;
    }

    public void setPosRiesgoIdentificado(String posRiesgoIdentificado) {
        this.posRiesgoIdentificado = posRiesgoIdentificado;
    }

    public String getPosRiesgoIdentificado() {
        return posRiesgoIdentificado;
    }

    public void setPosTipoDocPersona(String posTipoDocPersona) {
        this.posTipoDocPersona = posTipoDocPersona;
    }

    public String getPosTipoDocPersona() {
        return posTipoDocPersona;
    }

    

    public void setPosNomEmpresa(String posNomEmpresa) {
        this.posNomEmpresa = posNomEmpresa;
    }

    public String getPosNomEmpresa() {
        return posNomEmpresa;
    }

    public void setPosNroCIPersona(String posNroCIPersona) {
        this.posNroCIPersona = posNroCIPersona;
    }

    public String getPosNroCIPersona() {
        return posNroCIPersona;
    }

    public void setPosExpCIPersona(String posExpCIPersona) {
        this.posExpCIPersona = posExpCIPersona;
    }

    public String getPosExpCIPersona() {
        return posExpCIPersona;
    }

    public void setPosNombrePersona(String posNombrePersona) {
        this.posNombrePersona = posNombrePersona;
    }

    public String getPosNombrePersona() {
        return posNombrePersona;
    }

    public void setPosApPatPersona(String posApPatPersona) {
        this.posApPatPersona = posApPatPersona;
    }

    public String getPosApPatPersona() {
        return posApPatPersona;
    }

    public void setPosApMatPersona(String posApMatPersona) {
        this.posApMatPersona = posApMatPersona;
    }

    public String getPosApMatPersona() {
        return posApMatPersona;
    }

    public void setPosDireccion(String posDireccion) {
        this.posDireccion = posDireccion;
    }

    public String getPosDireccion() {
        return posDireccion;
    }

    public void setPosActividad(String posActividad) {
        this.posActividad = posActividad;
    }

    public String getPosActividad() {
        return posActividad;
    }

    

    public void setAmpNomEmpresa(String ampNomEmpresa) {
        this.ampNomEmpresa = ampNomEmpresa;
    }

    public String getAmpNomEmpresa() {
        return ampNomEmpresa;
    }

    public void setAmpNroCIPersona(String ampNroCIPersona) {
        this.ampNroCIPersona = ampNroCIPersona;
    }

    public String getAmpNroCIPersona() {
        return ampNroCIPersona;
    }

    public void setAmpExpCIPersona(String ampExpCIPersona) {
        this.ampExpCIPersona = ampExpCIPersona;
    }

    public String getAmpExpCIPersona() {
        return ampExpCIPersona;
    }

    public void setAmpNombrePersona(String ampNombrePersona) {
        this.ampNombrePersona = ampNombrePersona;
    }

    public String getAmpNombrePersona() {
        return ampNombrePersona;
    }

    public void setAmpApPatPersona(String ampApPatPersona) {
        this.ampApPatPersona = ampApPatPersona;
    }

    public String getAmpApPatPersona() {
        return ampApPatPersona;
    }

    public void setAmpApMatPersona(String ampApMatPersona) {
        this.ampApMatPersona = ampApMatPersona;
    }

    public String getAmpApMatPersona() {
        return ampApMatPersona;
    }

    public void setAmpDireccion(String ampDireccion) {
        this.ampDireccion = ampDireccion;
    }

    public String getAmpDireccion() {
        return ampDireccion;
    }

    public void setAmpActividad(String ampActividad) {
        this.ampActividad = ampActividad;
    }

    public String getAmpActividad() {
        return ampActividad;
    }

    public void setDifTipoDocumento(String difTipoDocumento) {
        this.difTipoDocumento = difTipoDocumento;
    }

    public String getDifTipoDocumento() {
        return difTipoDocumento;
    }

    public void setDifNroDocumento(String difNroDocumento) {
        this.difNroDocumento = difNroDocumento;
    }

    public String getDifNroDocumento() {
        return difNroDocumento;
    }

    public void setDifFecDocumento(String difFecDocumento) {
        this.difFecDocumento = difFecDocumento;
    }

    public String getDifFecDocumento() {
        return difFecDocumento;
    }

   
    public void setDifNomEmpresa(String difNomEmpresa) {
        this.difNomEmpresa = difNomEmpresa;
    }

    public String getDifNomEmpresa() {
        return difNomEmpresa;
    }

    public void setDifNroCIPersona(String difNroCIPersona) {
        this.difNroCIPersona = difNroCIPersona;
    }

    public String getDifNroCIPersona() {
        return difNroCIPersona;
    }

    public void setDifExpCIPersona(String difExpCIPersona) {
        this.difExpCIPersona = difExpCIPersona;
    }

    public String getDifExpCIPersona() {
        return difExpCIPersona;
    }

    public void setDifNombrePersona(String difNombrePersona) {
        this.difNombrePersona = difNombrePersona;
    }

    public String getDifNombrePersona() {
        return difNombrePersona;
    }

    public void setDifApPatPersona(String difApPatPersona) {
        this.difApPatPersona = difApPatPersona;
    }

    public String getDifApPatPersona() {
        return difApPatPersona;
    }

    public void setDifApMatPersona(String difApMatPersona) {
        this.difApMatPersona = difApMatPersona;
    }

    public String getDifApMatPersona() {
        return difApMatPersona;
    }

    public void setDifDireccion(String difDireccion) {
        this.difDireccion = difDireccion;
    }

    public String getDifDireccion() {
        return difDireccion;
    }

    public void setDifActividad(String difActividad) {
        this.difActividad = difActividad;
    }

    public String getDifActividad() {
        return difActividad;
    }

    public void setBoton(String boton) {
        this.boton = boton;
    }

    public String getBoton() {
        return boton;
    }

    public void setAmpNroOrden(String ampNroOrden) {
        this.ampNroOrden = ampNroOrden;
    }

    public String getAmpNroOrden() {
        return ampNroOrden;
    }

    public void setAmpTipoDocPersona(String ampTipoDocPersona) {
        this.ampTipoDocPersona = ampTipoDocPersona;
    }

    public String getAmpTipoDocPersona() {
        return ampTipoDocPersona;
    }

    public void setDifTipoDocPersona(String difTipoDocPersona) {
        this.difTipoDocPersona = difTipoDocPersona;
    }

    public String getDifTipoDocPersona() {
        return difTipoDocPersona;
    }

    public void setAmpGestion(String ampGestion) {
        this.ampGestion = ampGestion;
    }

    public String getAmpGestion() {
        return ampGestion;
    }

    public void setAmpControl(String ampControl) {
        this.ampControl = ampControl;
    }

    public String getAmpControl() {
        return ampControl;
    }

    public void setAmpGerencia(String ampGerencia) {
        this.ampGerencia = ampGerencia;
    }

    public String getAmpGerencia() {
        return ampGerencia;
    }

    public void setAmpNumero(String ampNumero) {
        this.ampNumero = ampNumero;
    }

    public String getAmpNumero() {
        return ampNumero;
    }

    public void setDifRiesgoIdentificado(String difRiesgoIdentificado) {
        this.difRiesgoIdentificado = difRiesgoIdentificado;
    }

    public String getDifRiesgoIdentificado() {
        return difRiesgoIdentificado;
    }

    public void setDifDetDocumento(String difDetDocumento) {
        this.difDetDocumento = difDetDocumento;
    }

    public String getDifDetDocumento() {
        return difDetDocumento;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setPosNitEmpresa(String posNitEmpresa) {
        this.posNitEmpresa = posNitEmpresa;
    }

    public String getPosNitEmpresa() {
        return posNitEmpresa;
    }

    public void setAmpNitEmpresa(String ampNitEmpresa) {
        this.ampNitEmpresa = ampNitEmpresa;
    }

    public String getAmpNitEmpresa() {
        return ampNitEmpresa;
    }

    public void setDifNitEmpresa(String difNitEmpresa) {
        this.difNitEmpresa = difNitEmpresa;
    }

    public String getDifNitEmpresa() {
        return difNitEmpresa;
    }

    public void setCodigocontrol(String codigocontrol) {
        this.codigocontrol = codigocontrol;
    }

    public String getCodigocontrol() {
        return codigocontrol;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public String getTab() {
        return tab;
    }

    public void setPosTipoOperador(String posTipoOperador) {
        this.posTipoOperador = posTipoOperador;
    }

    public String getPosTipoOperador() {
        return posTipoOperador;
    }

    public void setAmpTipoOperador(String ampTipoOperador) {
        this.ampTipoOperador = ampTipoOperador;
    }

    public String getAmpTipoOperador() {
        return ampTipoOperador;
    }

    public void setDifTipoOperador(String difTipoOperador) {
        this.difTipoOperador = difTipoOperador;
    }

    public String getDifTipoOperador() {
        return difTipoOperador;
    }

    public void setPosTribTodos(String posTribTodos) {
        this.posTribTodos = posTribTodos;
    }

    public String getPosTribTodos() {
        return posTribTodos;
    }

    public void setPosTribGa(String posTribGa) {
        this.posTribGa = posTribGa;
    }

    public String getPosTribGa() {
        return posTribGa;
    }

    public void setPosTribIva(String posTribIva) {
        this.posTribIva = posTribIva;
    }

    public String getPosTribIva() {
        return posTribIva;
    }

    public void setPosTribIce(String posTribIce) {
        this.posTribIce = posTribIce;
    }

    public String getPosTribIce() {
        return posTribIce;
    }

    public void setPosTribIehd(String posTribIehd) {
        this.posTribIehd = posTribIehd;
    }

    public String getPosTribIehd() {
        return posTribIehd;
    }

    public void setPosTribIcd(String posTribIcd) {
        this.posTribIcd = posTribIcd;
    }

    public String getPosTribIcd() {
        return posTribIcd;
    }

    public void setPosTribNoaplica(String posTribNoaplica) {
        this.posTribNoaplica = posTribNoaplica;
    }

    public String getPosTribNoaplica() {
        return posTribNoaplica;
    }

    public void setPosPeriodo(String posPeriodo) {
        this.posPeriodo = posPeriodo;
    }

    public String getPosPeriodo() {
        return posPeriodo;
    }

    public void setPosRiesgoDelito(String posRiesgoDelito) {
        this.posRiesgoDelito = posRiesgoDelito;
    }

    public String getPosRiesgoDelito() {
        return posRiesgoDelito;
    }

    public void setPosRiesgoSubval(String posRiesgoSubval) {
        this.posRiesgoSubval = posRiesgoSubval;
    }

    public String getPosRiesgoSubval() {
        return posRiesgoSubval;
    }

    public void setPosRiesgoClas(String posRiesgoClas) {
        this.posRiesgoClas = posRiesgoClas;
    }

    public String getPosRiesgoClas() {
        return posRiesgoClas;
    }

    public void setPosRiesgoContrab(String posRiesgoContrab) {
        this.posRiesgoContrab = posRiesgoContrab;
    }

    public String getPosRiesgoContrab() {
        return posRiesgoContrab;
    }

    public void setDifTribTodos(String difTribTodos) {
        this.difTribTodos = difTribTodos;
    }

    public String getDifTribTodos() {
        return difTribTodos;
    }

    public void setDifTribGa(String difTribGa) {
        this.difTribGa = difTribGa;
    }

    public String getDifTribGa() {
        return difTribGa;
    }

    public void setDifTribIva(String difTribIva) {
        this.difTribIva = difTribIva;
    }

    public String getDifTribIva() {
        return difTribIva;
    }

    public void setDifTribIce(String difTribIce) {
        this.difTribIce = difTribIce;
    }

    public String getDifTribIce() {
        return difTribIce;
    }

    public void setDifTribIehd(String difTribIehd) {
        this.difTribIehd = difTribIehd;
    }

    public String getDifTribIehd() {
        return difTribIehd;
    }

    public void setDifTribIcd(String difTribIcd) {
        this.difTribIcd = difTribIcd;
    }

    public String getDifTribIcd() {
        return difTribIcd;
    }

    public void setDifTribNoaplica(String difTribNoaplica) {
        this.difTribNoaplica = difTribNoaplica;
    }

    public String getDifTribNoaplica() {
        return difTribNoaplica;
    }

    public void setDifPeriodo(String difPeriodo) {
        this.difPeriodo = difPeriodo;
    }

    public String getDifPeriodo() {
        return difPeriodo;
    }

    public void setDifRiesgoDelito(String difRiesgoDelito) {
        this.difRiesgoDelito = difRiesgoDelito;
    }

    public String getDifRiesgoDelito() {
        return difRiesgoDelito;
    }

    public void setDifRiesgoSubval(String difRiesgoSubval) {
        this.difRiesgoSubval = difRiesgoSubval;
    }

    public String getDifRiesgoSubval() {
        return difRiesgoSubval;
    }

    public void setDifRiesgoClas(String difRiesgoClas) {
        this.difRiesgoClas = difRiesgoClas;
    }

    public String getDifRiesgoClas() {
        return difRiesgoClas;
    }

    public void setDifRiesgoContrab(String difRiesgoContrab) {
        this.difRiesgoContrab = difRiesgoContrab;
    }

    public String getDifRiesgoContrab() {
        return difRiesgoContrab;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getGerencia() {
        return gerencia;
    }

    public void setFecIni(String fecIni) {
        this.fecIni = fecIni;
    }

    public String getFecIni() {
        return fecIni;
    }

    public void setFecFin(String fecFin) {
        this.fecFin = fecFin;
    }

    public String getFecFin() {
        return fecFin;
    }

    public void setAduana(String aduana) {
        this.aduana = aduana;
    }

    public String getAduana() {
        return aduana;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setUsuarioger(String usuarioger) {
        this.usuarioger = usuarioger;
    }

    public String getUsuarioger() {
        return usuarioger;
    }

    public void setCantidad_dec(int cantidad_dec) {
        this.cantidad_dec = cantidad_dec;
    }

    public int getCantidad_dec() {
        return cantidad_dec;
    }

    public void setFd1FecIni(String fd1FecIni) {
        this.fd1FecIni = fd1FecIni;
    }

    public String getFd1FecIni() {
        return fd1FecIni;
    }

    public void setFd1FecFin(String fd1FecFin) {
        this.fd1FecFin = fd1FecFin;
    }

    public String getFd1FecFin() {
        return fd1FecFin;
    }

    public void setFd1Aduana(String fd1Aduana) {
        this.fd1Aduana = fd1Aduana;
    }

    public String getFd1Aduana() {
        return fd1Aduana;
    }

    public void setFd2FecIni(String fd2FecIni) {
        this.fd2FecIni = fd2FecIni;
    }

    public String getFd2FecIni() {
        return fd2FecIni;
    }

    public void setFd2FecFin(String fd2FecFin) {
        this.fd2FecFin = fd2FecFin;
    }

    public String getFd2FecFin() {
        return fd2FecFin;
    }

    public void setFd2Aduana(String fd2Aduana) {
        this.fd2Aduana = fd2Aduana;
    }

    public String getFd2Aduana() {
        return fd2Aduana;
    }

    public void setFd2Importador(String fd2Importador) {
        this.fd2Importador = fd2Importador;
    }

    public String getFd2Importador() {
        return fd2Importador;
    }

    public void setFd3Gestion(String fd3Gestion) {
        this.fd3Gestion = fd3Gestion;
    }

    public String getFd3Gestion() {
        return fd3Gestion;
    }

    public void setFd3Aduana(String fd3Aduana) {
        this.fd3Aduana = fd3Aduana;
    }

    public String getFd3Aduana() {
        return fd3Aduana;
    }

    public void setFd3Numero(String fd3Numero) {
        this.fd3Numero = fd3Numero;
    }

    public String getFd3Numero() {
        return fd3Numero;
    }

    public void setMgestion(String mgestion) {
        this.mgestion = mgestion;
    }

    public String getMgestion() {
        return mgestion;
    }

    public void setMaduana(String maduana) {
        this.maduana = maduana;
    }

    public String getMaduana() {
        return maduana;
    }

    public void setMnumero(String mnumero) {
        this.mnumero = mnumero;
    }

    public String getMnumero() {
        return mnumero;
    }

    public void setFropcion(String fropcion) {
        this.fropcion = fropcion;
    }

    public String getFropcion() {
        return fropcion;
    }

    public void setFrcodigo(String frcodigo) {
        this.frcodigo = frcodigo;
    }

    public String getFrcodigo() {
        return frcodigo;
    }
}
