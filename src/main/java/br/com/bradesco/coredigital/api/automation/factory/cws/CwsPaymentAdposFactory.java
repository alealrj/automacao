package br.com.bradesco.coredigital.api.automation.factory.cws;

import br.com.bradesco.coredigital.api.automation.model.request.cws.CwsPaymentAdposRequest;
import org.springframework.stereotype.Component;

@Component
public class CwsPaymentAdposFactory {

    public CwsPaymentAdposRequest buildCwsPaymentAdposRequest (
            String contractId, String startDate, String endDate) {

        return CwsPaymentAdposRequest.builder()
                .contractId(contractId)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
