import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class Pedido {

    private double taxaDeEntrega=10.00;

    private Cliente cliente;
    private List<Item> itens=new ArrayList<>();
    private List<CupomDescontoEntrega> cupomDescontoEntrega=new ArrayList<>();

    public Pedido(LocalDate data, Cliente cliente) {
        this.cliente = cliente;
        LocalDate dataEntrega = LocalDate.now();
    }

    public void adicionarItem(Item item){
        itens.add(item);
    }

    public double getValorPedido(){
        double valorTotal=0;
        for(Item item:itens){
            valorTotal+=item.getValorTotal();
        }
        return valorTotal;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItens(){
        return itens;
    }

    public double getTaxaDeEntrega() {
        return taxaDeEntrega;
    }

    public void aplicarDesconto(CupomDescontoEntrega desconto){
        if (desconto!=null){
            this.cupomDescontoEntrega.add(desconto);
        }
    }

    public double descontoConcedido(){
        double valorTotal=0;
        for(CupomDescontoEntrega cupom:cupomDescontoEntrega){
            valorTotal+=cupom.getValorDesconto();
        }
        return valorTotal;
    }

    public List<CupomDescontoEntrega> getCuponsDescontoEntrega() {
        return cupomDescontoEntrega;
    }

    @Override
    public String toString() {
        return "Taxa entrega: " + taxaDeEntrega + ", Valor pedido: " +getValorPedido() + ", Total desconto: " + descontoConcedido();
    }
}
