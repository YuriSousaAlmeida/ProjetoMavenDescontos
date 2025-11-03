import java.time.LocalDateTime;

public class CupomDescontoPedido {
    private String codigo;
    private double percentual;
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public CupomDescontoPedido(String codigo, double percentual, LocalDateTime inicio, LocalDateTime fim) {
        this.codigo = codigo;
        this.percentual = percentual;
        this.inicio = inicio;
        this.fim = fim;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }
}
