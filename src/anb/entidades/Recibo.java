package anb.entidades;

public class Recibo {
    
    private String codigo;
    private String gestion;
    private String aduana;
    private String numero;
    private String tipo;
    private String fecha;
    private String importe;
    private String seq;

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setGestion(String gestion) {
        this.gestion = gestion;
    }

    public String getGestion() {
        return gestion;
    }

    public void setAduana(String aduana) {
        this.aduana = aduana;
    }

    public String getAduana() {
        return aduana;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getImporte() {
        return importe;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getSeq() {
        return seq;
    }
}
