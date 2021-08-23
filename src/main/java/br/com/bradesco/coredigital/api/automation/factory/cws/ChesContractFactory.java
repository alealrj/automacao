package br.com.bradesco.coredigital.api.automation.factory.cws;

import br.com.bradesco.coredigital.api.automation.model.request.cws.ChesContractRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ChesContractFactory {

    public ChesContractRequest buiChesContractRequest(BigDecimal ccontr, String dsoltcConsDados,
                                                      String dinicConsent, String dfnalConsent) {

       return ChesContractRequest.builder()
                .ccontr(ccontr)
               .dsoltcConsDados(dsoltcConsDados)
               .dinicConsent(dinicConsent)
               .dfnalConsent(dfnalConsent)
               .build();
    }
}
