package anb.entidades;

public class RepLiquidacionPreviaTot {
    private String totalDeuda;
    private String multaContravOmision;
    private String multacontravAduanera;
    private String totalAdeudo;

    public void setTotalDeuda(String totalDeuda) {
        this.totalDeuda = totalDeuda;
    }

    public String getTotalDeuda() {
        return totalDeuda;
    }

    public void setMultaContravOmision(String multaContravOmision) {
        this.multaContravOmision = multaContravOmision;
    }

    public String getMultaContravOmision() {
        return multaContravOmision;
    }

    public void setMultacontravAduanera(String multacontravAduanera) {
        this.multacontravAduanera = multacontravAduanera;
    }

    public String getMultacontravAduanera() {
        return multacontravAduanera;
    }

    public void setTotalAdeudo(String totalAdeudo) {
        this.totalAdeudo = totalAdeudo;
    }

    public String getTotalAdeudo() {
        return totalAdeudo;
    }
}
