package br.com.bradesco.coredigital.api.automation.factory.cws;

import br.com.bradesco.coredigital.api.automation.model.request.cws.CwsAdposRequest;
import org.springframework.stereotype.Component;

@Component
public class CwsListAdposFactory {

    public CwsAdposRequest buildCwsAdposRequest(
            String agency, String account, String groupAccount, String subGroupAccount, String startDate, String endDate) {

        return CwsAdposRequest.builder()
                .agency(agency)
                .account(account)
                .groupAccount(groupAccount)
                .subGroupAccount(subGroupAccount)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
