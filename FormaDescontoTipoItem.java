import java.util.HashMap;
import java.util.Map;

public class FormaDescontoTipoItem implements IFormaDescontoTaxaEntrega {

    private Map<String,Double> descontosPorTipoItem;

    public FormaDescontoTipoItem() {
        this.descontosPorTipoItem = new HashMap<>();
        descontosPorTipoItem.put("Alimentação", 5.00);
        descontosPorTipoItem.put("Educação", 2.00);
        descontosPorTipoItem.put("Lazer", 1.50);
    }

    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido){
        double descontoTotal = 0.00;
        for (Item item: pedido.getItens()){
            if (descontosPorTipoItem.containsKey(item.getTipo())){
                descontoTotal += descontosPorTipoItem.get(item.getTipo());
            }
        }
        for(Item item: pedido.getItens()){
            if (descontosPorTipoItem.containsKey(item.getTipo())){
                CupomDescontoEntrega cupomDescontoEntrega = new CupomDescontoEntrega("Desconto por item", descontoTotal);
                return cupomDescontoEntrega;
            }
        }
        return null;
    }

    @Override
    public boolean seAplica(Pedido pedido){
        return pedido.getItens().stream()
                .anyMatch(item -> descontosPorTipoItem.containsKey(item.getTipo()));
    }
}
