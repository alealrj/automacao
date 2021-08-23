package br.com.bradesco.coredigital.api.automation.factory.egrees;

import br.com.bradesco.coredigital.api.automation.model.request.egrees.EgreesLimitRequest;
import org.springframework.stereotype.Component;

@Component
public class EgreesLimitFactory {

    public EgreesLimitRequest buildEgreesLimitRequest(String origens, String marca, String numeroCartao,
                                                      String contaFaturamento, String canal, String usuario) {

       return EgreesLimitRequest.builder()
               .origens(origens)
               .marca(marca)
               .numeroCartao(numeroCartao)
               .contaFaturamento(contaFaturamento)
               .canal(canal)
               .usuario(usuario)
               .build();
    }
}
