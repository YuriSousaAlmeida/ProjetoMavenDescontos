import java.util.ArrayList;
import java.util.List;

public class CalculadoraDeDescontoService {

    private List<IFormaDescontoTaxaEntrega> metodosDesconto;

    public CalculadoraDeDescontoService(List<IFormaDescontoTaxaEntrega> metodos) {
        this.metodosDesconto = metodos;
    }

    public List<CupomDescontoEntrega> calcularDesconto(Pedido pedido) {
        List<CupomDescontoEntrega> cupons = new ArrayList<>();

        double limiteMaximo = 10.0;
        double acumulado = 0.0;

        for (IFormaDescontoTaxaEntrega metodo : metodosDesconto) {

            if (metodo.seAplica(pedido)) {
                CupomDescontoEntrega cupom = metodo.calcularDesconto(pedido);

            if (cupom != null) {
                double valorCupom = cupom.getValorDesconto();

            if (acumulado + valorCupom > limiteMaximo) {
                double valorRestante = limiteMaximo - acumulado;

            if (valorRestante > 0) {
                cupom = new CupomDescontoEntrega(cupom.getNomeMetodo() + " (parcial)", valorRestante);
                pedido.aplicarDesconto(cupom);
                cupons.add(cupom);
                acumulado += valorRestante;
            }
                break;
            } else {
                pedido.aplicarDesconto(cupom);
                cupons.add(cupom);
                acumulado += valorCupom;
           }
          }
         }
        }
        return cupons;
    }
}
