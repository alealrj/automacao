package br.com.bradesco.coredigital.api.automation.factory.cws;

import br.com.bradesco.coredigital.api.automation.model.request.cws.EmpgPaymentContractRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class EmpgPaymentContractFactory {

    public EmpgPaymentContractRequest buildEmpgPaymentContractRequest(BigDecimal ccontr, String dsoltcConsDados,
                                                                      String dinicConsent, String dfnalConsent) {

       return EmpgPaymentContractRequest.builder()
                .ccontr(ccontr)
               .dsoltcConsDados(dsoltcConsDados)
               .dinicConsent(dinicConsent)
               .dfnalConsent(dfnalConsent)
               .build();
    }
}
