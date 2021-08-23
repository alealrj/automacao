package br.com.bradesco.coredigital.api.automation.factory.cws;

import br.com.bradesco.coredigital.api.automation.model.request.cws.CwsScheduledInstalmentsDcomRequest;
import org.springframework.stereotype.Component;

@Component
public class CwsScheduledInstalmentsDcomFactory {

    public CwsScheduledInstalmentsDcomRequest buildCwsDcomRequest(
            String requestDate, String requestDatePeriodBegin, String requestDatePeriodEnd, String contractId) {

        return CwsScheduledInstalmentsDcomRequest.builder()
                .requestDate(requestDate)
                .requestDatePeriodBegin(requestDatePeriodBegin)
                .requestDatePeriodEnd(requestDatePeriodEnd)
                .contractId(contractId)
                .build();
    }
}
