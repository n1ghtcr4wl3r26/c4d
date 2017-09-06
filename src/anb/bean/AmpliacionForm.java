package anb.bean;

import org.apache.struts.action.ActionForm;

public class AmpliacionForm extends ActionForm {
    
    /* VARIABLES DE BUSQUEDA*/
    private String tipoTramite;
    private String tipoBusqueda;
    private String fecIni;
    private String fecFin;
    private String aduana;
    private String partida;
    private String declarante;
    private String operador;
    private String emisor;
    private String origen;
    private String gestion;
    private String numero;
    private String fecha;
    private String tipoDoc;
    
    /* VARIABLES DE INTERCAMBIO CON EL ACTION FORM */    
    private String fmemorizado;
    private String fgestion;
    private String fcontrol;
    private String fgerencia;
    private String fnumero;
    
    private String codigo;
    private String boton;
    private String opcion;
    private String usuario;
    private String usuarioger;
    
    private String borrarid;
    
    private int cantidad_alc;
    private int cantidad_dec;
    
    private int cantidad_amp;
    
    /* DOCUMETNOS POR TRAMITE */ 
    private String facnumero;
    private String facfecha;
    private String facemisor;
    
    private String tragestion;
    private String trafecha;
    private String traemisor;
    
    private String otrgestion;
    private String otrfecha;
    private String otremisor;
    private String otrtipoDoc;
    
    private String chvalor;
    private String chpartida;
    private String chorigen;
    private String chotro;
    
    /* VARIABLES PARA GRABADO POR LOTES DE DECLARACIONES */
    private String codigoconcat;
    private String codigoconcatval;
    private String codigoconcatpar;
    private String codigoconcatori;
    private String codigoconcatotr;
    
    /* VARIABLE DE INFORMACION DEL CONTROL */
    private String numeroOperador;
    private String tipoOperador;
    
    public AmpliacionForm() {
        super();
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public String getTipoTramite() {
        return tipoTramite;
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

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getPartida() {
        return partida;
    }

    public void setDeclarante(String declarante) {
        this.declarante = declarante;
    }

    public String getDeclarante() {
        return declarante;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getOperador() {
        return operador;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getOrigen() {
        return origen;
    }

    public void setTipoBusqueda(String tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }

    public String getTipoBusqueda() {
        return tipoBusqueda;
    }

    public void setGestion(String gestion) {
        this.gestion = gestion;
    }

    public String getGestion() {
        return gestion;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setFmemorizado(String fmemorizado) {
        this.fmemorizado = fmemorizado;
    }

    public String getFmemorizado() {
        return fmemorizado;
    }

    public void setFgestion(String fgestion) {
        this.fgestion = fgestion;
    }

    public String getFgestion() {
        return fgestion;
    }

    public void setFcontrol(String fcontrol) {
        this.fcontrol = fcontrol;
    }

    public String getFcontrol() {
        return fcontrol;
    }

    public void setFgerencia(String fgerencia) {
        this.fgerencia = fgerencia;
    }

    public String getFgerencia() {
        return fgerencia;
    }

    public void setFnumero(String fnumero) {
        this.fnumero = fnumero;
    }

    public String getFnumero() {
        return fnumero;
    }

    public void setBoton(String boton) {
        this.boton = boton;
    }

    public String getBoton() {
        return boton;
    }

    public void setCodigoconcat(String codigoconcat) {
        this.codigoconcat = codigoconcat;
    }

    public String getCodigoconcat() {
        return codigoconcat;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }


    

    public void setCantidad_dec(int cantidad_dec) {
        this.cantidad_dec = cantidad_dec;
    }

    public int getCantidad_dec() {
        return cantidad_dec;
    }

    public void setBorrarid(String borrarid) {
        this.borrarid = borrarid;
    }

    public String getBorrarid() {
        return borrarid;
    }

    public void setCodigoconcatval(String codigoconcatval) {
        this.codigoconcatval = codigoconcatval;
    }

    public String getCodigoconcatval() {
        return codigoconcatval;
    }

    public void setCodigoconcatpar(String codigoconcatpar) {
        this.codigoconcatpar = codigoconcatpar;
    }

    public String getCodigoconcatpar() {
        return codigoconcatpar;
    }

    public void setCodigoconcatori(String codigoconcatori) {
        this.codigoconcatori = codigoconcatori;
    }

    public String getCodigoconcatori() {
        return codigoconcatori;
    }

    public void setCantidad_amp(int cantidad_amp) {
        this.cantidad_amp = cantidad_amp;
    }

    public int getCantidad_amp() {
        return cantidad_amp;
    }

    public void setNumeroOperador(String numeroOperador) {
        this.numeroOperador = numeroOperador;
    }

    public String getNumeroOperador() {
        return numeroOperador;
    }

    public void setTipoOperador(String tipoOperador) {
        this.tipoOperador = tipoOperador;
    }

    public String getTipoOperador() {
        return tipoOperador;
    }

    public void setUsuarioger(String usuarioger) {
        this.usuarioger = usuarioger;
    }

    public String getUsuarioger() {
        return usuarioger;
    }

    public void setCantidad_alc(int cantidad_alc) {
        this.cantidad_alc = cantidad_alc;
    }

    public int getCantidad_alc() {
        return cantidad_alc;
    }

    public void setCodigoconcatotr(String codigoconcatotr) {
        this.codigoconcatotr = codigoconcatotr;
    }

    public String getCodigoconcatotr() {
        return codigoconcatotr;
    }

    public void setFacnumero(String facnumero) {
        this.facnumero = facnumero;
    }

    public String getFacnumero() {
        return facnumero;
    }

    public void setFacfecha(String facfecha) {
        this.facfecha = facfecha;
    }

    public String getFacfecha() {
        return facfecha;
    }

    public void setFacemisor(String facemisor) {
        this.facemisor = facemisor;
    }

    public String getFacemisor() {
        return facemisor;
    }

    public void setTragestion(String tragestion) {
        this.tragestion = tragestion;
    }

    public String getTragestion() {
        return tragestion;
    }

    public void setTrafecha(String trafecha) {
        this.trafecha = trafecha;
    }

    public String getTrafecha() {
        return trafecha;
    }

    public void setTraemisor(String traemisor) {
        this.traemisor = traemisor;
    }

    public String getTraemisor() {
        return traemisor;
    }

    public void setOtrgestion(String otrgestion) {
        this.otrgestion = otrgestion;
    }

    public String getOtrgestion() {
        return otrgestion;
    }

    public void setOtrfecha(String otrfecha) {
        this.otrfecha = otrfecha;
    }

    public String getOtrfecha() {
        return otrfecha;
    }

    public void setOtremisor(String otremisor) {
        this.otremisor = otremisor;
    }

    public String getOtremisor() {
        return otremisor;
    }

    public void setOtrtipoDoc(String otrtipoDoc) {
        this.otrtipoDoc = otrtipoDoc;
    }

    public String getOtrtipoDoc() {
        return otrtipoDoc;
    }

    public void setChvalor(String chvalor) {
        this.chvalor = chvalor;
    }

    public String getChvalor() {
        return chvalor;
    }

    public void setChpartida(String chpartida) {
        this.chpartida = chpartida;
    }

    public String getChpartida() {
        return chpartida;
    }

    public void setChorigen(String chorigen) {
        this.chorigen = chorigen;
    }

    public String getChorigen() {
        return chorigen;
    }

    public void setChotro(String chotro) {
        this.chotro = chotro;
    }

    public String getChotro() {
        return chotro;
    }
}

