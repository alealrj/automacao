package br.com.bradesco.coredigital.api.automation.factory.egrees;

import br.com.bradesco.coredigital.api.automation.model.request.egrees.EgreesChaveIdentificationRequest;
import br.com.bradesco.coredigital.api.automation.model.request.egrees.EgreesIdentificationRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EgreesIdentificationFactory {

    public EgreesIdentificationRequest buildEgreesIdentificationRequest(List<String> origens, String marca,
                                                                        String numeroCartao, String contaFaturamento,
                                                                        String agenciaConta, String companyId, String canal, String usuario,
                                                                        EgreesChaveIdentificationRequest chavesRestart) {

       return EgreesIdentificationRequest.builder()
               .origens(origens)
               .marca(marca)
               .numeroCartao(numeroCartao)
               .contaFaturamento(contaFaturamento)
               .agenciaConta(agenciaConta)
               .companyId(companyId)
               .canal(canal)
               .usuario(usuario)
               .chavesRestart(chavesRestart)
               .build();
    }
}
