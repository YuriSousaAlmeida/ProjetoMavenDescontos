import java.time.LocalDate;
import java.util.Arrays;

//Mesmo que não tenha sido pedido, a main está como um dos testes usados para a validação do projeto

public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("Arroz",1,25.00,"Alimentação");
        Item item2 = new Item("Tabuleiro de Xadrez",1,150.00,"Lazer");
        Cliente cliente = new Cliente("Yuri", "Ouro", 0.00, "Rua Antônio Ribeiro De Almeida", "Centro", "Muniz Freire");
        LocalDate dataEntrega = LocalDate.now();
        Pedido pedido = new Pedido(dataEntrega,cliente);
        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);

        IFormaDescontoTaxaEntrega descontoBairro = new FormaDescontoTaxaPorBairro();
        IFormaDescontoTaxaEntrega descontoCliente = new FormaDescontoTaxaPorTipoCliente();
        IFormaDescontoTaxaEntrega descontoItem = new FormaDescontoTipoItem();
        IFormaDescontoTaxaEntrega descontoValorPedido = new FormaDescontoValorPedido(200.00);


        CalculadoraDeDescontoService calculadora = new CalculadoraDeDescontoService(Arrays.asList(descontoBairro, descontoCliente, descontoItem, descontoValorPedido));
        calculadora.calcularDesconto(pedido);

        System.out.println(pedido.toString());

    }
}
