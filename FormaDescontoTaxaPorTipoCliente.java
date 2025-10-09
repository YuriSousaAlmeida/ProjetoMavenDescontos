import java.util.HashMap;
import java.util.Map;

public class FormaDescontoTaxaPorTipoCliente implements IFormaDescontoTaxaEntrega {

    private Map<String,Double> descontosPorTipoCliente;
    private String tipoCliente;

    public FormaDescontoTaxaPorTipoCliente() {
        this.descontosPorTipoCliente = new HashMap<>();
        descontosPorTipoCliente.put("Ouro", 3.00);
        descontosPorTipoCliente.put("Prata", 2.00);
        descontosPorTipoCliente.put("Bronze", 1.00);
    }

    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido){
        tipoCliente=pedido.getCliente().getTipo();
        if (descontosPorTipoCliente.containsKey(pedido.getCliente().getTipo())) {
            CupomDescontoEntrega cupomDescontoEntrega = new CupomDescontoEntrega("Desconto tipo cliente", descontosPorTipoCliente.get(tipoCliente));
            return cupomDescontoEntrega;
        }
        return null;
    }

    @Override
    public boolean seAplica(Pedido pedido){
        return descontosPorTipoCliente.containsKey(pedido.getCliente().getTipo());
    }

}
