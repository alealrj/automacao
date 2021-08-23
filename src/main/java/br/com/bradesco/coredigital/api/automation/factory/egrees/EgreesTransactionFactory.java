package br.com.bradesco.coredigital.api.automation.factory.egrees;

import br.com.bradesco.coredigital.api.automation.model.request.egrees.EgreesTransactionRequest;
import org.springframework.stereotype.Component;

@Component
public class EgreesTransactionFactory {

    public EgreesTransactionRequest buildEgreesTransactRequest(String origens, String marca, String numeroCartao,
                                                               String contaFaturamento, String dataVencimento,
                                                               String canal, String usuario, String chaveRestart) {

       return EgreesTransactionRequest.builder()
               .origens(origens)
               .marca(marca)
               .numeroCartao(numeroCartao)
               .contaFaturamento(contaFaturamento)
               .dataVencimento(dataVencimento)
               .canal(canal)
               .usuario(usuario)
               .chaveRestart(chaveRestart)
               .build();
    }
}
