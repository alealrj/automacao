package br.com.bradesco.coredigital.api.automation.factory.cws;

import br.com.bradesco.coredigital.api.automation.model.request.cws.CwsContractDcomRequest;
import org.springframework.stereotype.Component;

@Component
public class CwsContractDcomFactory {

    public CwsContractDcomRequest buildCwsDcomRequest(
            String requestDate, String requestDatePeriodBegin, String requestDatePeriodEnd, String contractId) {

        return CwsContractDcomRequest.builder()
                .requestDate(requestDate)
                .requestDatePeriodBegin(requestDatePeriodBegin)
                .requestDatePeriodEnd(requestDatePeriodEnd)
                .contractId(contractId)
                .build();
    }
}