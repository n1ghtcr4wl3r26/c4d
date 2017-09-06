package anb.entidades;

public class RepCantidades {
    private String funcionario;
    private String gerencia;
    private String cantAsigFAP;
    private String cantConFAP;
    private String cantAsigCD;
    private String cantConCD;


    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setCantAsigFAP(String cantAsigFAP) {
        this.cantAsigFAP = cantAsigFAP;
    }

    public String getCantAsigFAP() {
        return cantAsigFAP;
    }

    public void setCantConFAP(String cantConFAP) {
        this.cantConFAP = cantConFAP;
    }

    public String getCantConFAP() {
        return cantConFAP;
    }

    public void setCantAsigCD(String cantAsigCD) {
        this.cantAsigCD = cantAsigCD;
    }

    public String getCantAsigCD() {
        return cantAsigCD;
    }

    public void setCantConCD(String cantConCD) {
        this.cantConCD = cantConCD;
    }

    public String getCantConCD() {
        return cantConCD;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getGerencia() {
        return gerencia;
    }
}
