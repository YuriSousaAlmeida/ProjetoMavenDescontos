public class FormaDescontoValorPedido implements IFormaDescontoTaxaEntrega {

    private double limiteValorPedido;
    private double VALOR_DESCONTO=5.00;


    public FormaDescontoValorPedido(double limiteValorPedido) {
        this.limiteValorPedido = 200.00; //pela regra de negócio
    }

    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido){
        if (seAplica(pedido)) {
            CupomDescontoEntrega cupomDescontoEntrega = new CupomDescontoEntrega("Desconto Valor Pedido", VALOR_DESCONTO);
            return cupomDescontoEntrega;
        }
        return null;
    }

    public boolean seAplica(Pedido pedido){
        return limiteValorPedido<=pedido.getValorPedido();
    }
}
