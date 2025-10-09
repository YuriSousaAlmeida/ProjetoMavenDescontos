public class FormaDescontoTaxaPorBairro implements IFormaDescontoTaxaEntrega{

    private String bairroCliente;


    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido){
        if (pedido.getCliente().getBairro().equals("Centro")){
            bairroCliente = "Centro";
            CupomDescontoEntrega cupomAux = new CupomDescontoEntrega("Cupom bairro",2.00);
            return cupomAux;

        } else if (pedido.getCliente().getBairro().equals("Bela Vista")) {
            bairroCliente = "Bela Vista";
            CupomDescontoEntrega cupomAux = new CupomDescontoEntrega("Cupom bairro",3.00);
            return cupomAux;

        } else if (pedido.getCliente().getBairro().equals("Cidade Maravilhosa")) {
            bairroCliente = "Cidade Maravilhosa";
            CupomDescontoEntrega cupomAux = new CupomDescontoEntrega("Cupom bairro",1.50);
            return cupomAux;
        }
         return null;

    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return pedido.getCliente().getBairro().equals("Centro") || pedido.getCliente().getBairro().equals("Cidade Maravilhosa") || pedido.getCliente().getBairro().equals("Bela Vista");
    }
}
