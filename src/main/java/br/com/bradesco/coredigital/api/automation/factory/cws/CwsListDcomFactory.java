package br.com.bradesco.coredigital.api.automation.factory.cws;

import br.com.bradesco.coredigital.api.automation.model.request.cws.CwsListDcomRequest;
import org.springframework.stereotype.Component;

@Component
public class CwsListDcomFactory {

    public CwsListDcomRequest buildCwsDcomRequest(
            String requestDate, String startDate, String endDate, String agency, String account, String ownership,
            String cpfCnpj, String filialCnpj, String digitCpfCnpj) {

        return CwsListDcomRequest.builder()
                .requestDate(requestDate)
                .startDate(startDate)
                .endDate(endDate)
                .agency(agency)
                .account(account)
                .ownership(ownership)
                .cpfCnpj(cpfCnpj)
                .filialCnpj(filialCnpj)
                .digitCpfCnpj(digitCpfCnpj)
                .build();
    }
}