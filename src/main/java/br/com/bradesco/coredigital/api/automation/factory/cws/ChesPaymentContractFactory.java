package br.com.bradesco.coredigital.api.automation.factory.cws;

import br.com.bradesco.coredigital.api.automation.model.request.cws.ChesPaymentContractRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ChesPaymentContractFactory {

    public ChesPaymentContractRequest buildChesPaymentContractRequest(BigDecimal ccontr, String dsoltcConsDados,
                                                             String dinicConsent, String dfnalConsent) {

       return ChesPaymentContractRequest.builder()
                .ccontr(ccontr)
               .dsoltcConsDados(dsoltcConsDados)
               .dinicConsent(dinicConsent)
               .dfnalConsent(dfnalConsent)
               .build();
    }
}
