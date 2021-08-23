package br.com.bradesco.coredigital.api.automation.factory.egrees;

import br.com.bradesco.coredigital.api.automation.model.request.egrees.EgreesBillRequest;
import org.springframework.stereotype.Component;


@Component
public class EgreesBillFactory {

    public EgreesBillRequest buildEgreesBillRequest(String origens, String marca, String numeroCartao,
                                                    String contaFaturamento, String dataVencimento,
                                                              String cnpj, String canal, String usuario) {

       return EgreesBillRequest.builder()
               .origens(origens)
               .marca(marca)
               .numeroCartao(numeroCartao)
               .contaFaturamento(contaFaturamento)
               .dataVencimento(dataVencimento)
               .cnpj(cnpj)
               .canal(canal)
               .usuario(usuario)
               .build();
    }
}
