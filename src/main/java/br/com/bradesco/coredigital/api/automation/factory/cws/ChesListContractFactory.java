package br.com.bradesco.coredigital.api.automation.factory.cws;

import br.com.bradesco.coredigital.api.automation.model.request.cws.ChesListContractRequest;
import org.springframework.stereotype.Component;

@Component
public class ChesListContractFactory {

    public ChesListContractRequest buildChesListContractRequest(String agency, String account, String digit,
                                                                String ownership, String cpfCnpj, String digitCpfCnpj,
                                                                String filialCnpj, String brand, String requestDate,
                                                                String startDate, String endDate) {

       return ChesListContractRequest.builder()
               .agency(agency)
               .account(account)
               .digit(digit)
               .ownership(ownership)
               .cpfCnpj(cpfCnpj)
               .digitCpfCnpj(digitCpfCnpj)
               .filialCnpj(filialCnpj)
               .brand(brand)
               .requestDate(requestDate)
               .startDate(startDate)
               .endDate(endDate)
               .build();
    }
}
