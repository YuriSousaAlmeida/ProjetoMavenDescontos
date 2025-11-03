import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidadorCupomService {
    private List<CupomDescontoPedido> cupons = new ArrayList<>();

    public boolean validarCupom(CupomDescontoPedido cupom){
        LocalDateTime dataAgora = LocalDateTime.now();
        if ( ((cupom.getInicio().equals(dataAgora))||cupom.getInicio().isBefore(dataAgora)) &&
             ((cupom.getFim().equals(dataAgora))||cupom.getFim().isAfter(dataAgora))){
            return true;
        }else{
            return false;
        }
    }

    public void adicionar(CupomDescontoPedido cupom){
        cupons.add(cupom);
    }

    public void remover(CupomDescontoPedido cupom){
        cupons.remove(cupom);
    }

}
