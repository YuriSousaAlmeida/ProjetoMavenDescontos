import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;


public class Pedido {

    private double taxaDeEntrega=10.00;
    private LocalDateTime data;
    private Cliente cliente;
    private List<Item> itens=new ArrayList<>();
    private List<CupomDescontoEntrega> cupomDescontoEntrega=new ArrayList<>();
    private CupomDescontoPedido cupomDescontoPedido;

    public Pedido(LocalDateTime data, Cliente cliente) {
        this.cliente = cliente;
        this.data = data;
    }

    public void adicionarItem(Item item){
        itens.add(item);
    }

    public double getValorPedido(){
        try {
            double valorTotal=0;
            for(Item item:itens){
                valorTotal+=item.getValorTotal();
            }
            valorTotal+=(taxaDeEntrega-descontoConcedido());
            valorTotal-=valorTotal*cupomDescontoPedido.getPercentual();
            return valorTotal;
        }catch (RuntimeException e){
            double valorTotal=0;
            for(Item item:itens){
                valorTotal+=item.getValorTotal();
            }
            valorTotal+=(taxaDeEntrega-descontoConcedido());
            return valorTotal;
        }
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

    public void setCupomDescontoPedido(CupomDescontoPedido cupomDescontoPedido) {
        this.cupomDescontoPedido = cupomDescontoPedido;
    }

    @Override
    public String toString() {
        return "Taxa entrega: " + (taxaDeEntrega-descontoConcedido()) + ", Valor pedido: " +getValorPedido() + ", Total desconto: " + descontoConcedido();
    }
}
