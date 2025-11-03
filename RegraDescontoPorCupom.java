public class RegraDescontoPorCupom implements IRegraDescontoValorPedido{

    private CupomDescontoPedido cupomDescontoPedido;

    RegraDescontoPorCupom(CupomDescontoPedido cupomDescontoPedido, ValidadorCupomService validadorCupomService){
        if (validadorCupomService.validarCupom(cupomDescontoPedido)){
            this.cupomDescontoPedido=cupomDescontoPedido;
        }else{
            this.cupomDescontoPedido=null;
        }
    }

    public void setCupomDescontoPedido(CupomDescontoPedido cupomDescontoPedido, ValidadorCupomService validadorCupomService){
        if (validadorCupomService.validarCupom(cupomDescontoPedido)){
            this.cupomDescontoPedido=cupomDescontoPedido;
        }else{
            this.cupomDescontoPedido=null;
        }
    }

    @Override
    public void aplicarDesconto(Pedido pedido){
        pedido.setCupomDescontoPedido(cupomDescontoPedido);
    }

}
