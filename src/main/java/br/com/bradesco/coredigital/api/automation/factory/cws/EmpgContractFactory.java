package br.com.bradesco.coredigital.api.automation.factory.cws;

import br.com.bradesco.coredigital.api.automation.model.request.cws.EmpgContractRequest;
import org.springframework.stereotype.Component;

@Component
public class EmpgContractFactory {

    public EmpgContractRequest buildEmpgContractRequest(String ccontr, String cprodtBdsco, String cfamlContr,
                                                        String dsoltcConsDados, String dinicConsent,
                                                        String dfnalConsent) {

       return EmpgContractRequest.builder()
                .ccontr(ccontr)
                .cprodtBdsco(cprodtBdsco)
                .cfamlContr(cfamlContr)
                .dsoltcConsDados(dsoltcConsDados)
                .dinicConsent(dinicConsent)
                .dfnalConsent(dfnalConsent)
                .build();
    }
}
