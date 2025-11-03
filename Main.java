import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

//Mesmo que não tenha sido pedido, a main está como um dos testes usados para a validação do projeto

public class Main {
    public static void main(String[] args) {
        try {

            Cliente cliente = new Cliente("Fulano", "Ouro", 0.0, "Rua tal", "Centro", "Alegre");
            Item item1 = new Item("Lapis", 10, 1.43, "Educação");

            Pedido pedido = new Pedido(LocalDateTime.now(), cliente);
            CupomDescontoPedido cupomDescontoPedido = new CupomDescontoPedido("11/11", 0.1, LocalDateTime.of(2025, 5, 10, 0, 0),LocalDateTime.of(2025, 5, 12, 23, 59));
            ValidadorCupomService validadorCupomService = new ValidadorCupomService();
            RegraDescontoPorCupom regraDescontoPorCupom = new RegraDescontoPorCupom(cupomDescontoPedido,validadorCupomService);

            pedido.adicionarItem(item1);
            pedido.adicionarItem(item1);
            pedido.adicionarItem(item1);

            System.out.println("Pedido antes do cálculo do desconto na taxa de entrega");
            System.out.println(pedido);

            CalculadoraDeDescontoService calculadora = new CalculadoraDeDescontoService();

            calculadora.calcularDesconto(pedido);

            System.out.println("Pedido após o cálculo do desconto na taxa de entrega");
            System.out.println(pedido);

            System.out.println("Pedido após o cálculo do cupom na taxa de entrega");
            regraDescontoPorCupom.aplicarDesconto(pedido);
            //calculadora.calcularDesconto(pedido); rever esse erro
            System.out.println(pedido);


        } catch (Exception ex) {
            System.out.println("Falha:" + ex.getMessage());
        }

    }
}
