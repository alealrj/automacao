package br.com.bradesco.coredigital.api.automation.factory.cws;

import br.com.bradesco.coredigital.api.automation.model.request.cws.EmpfListContractRequest;
import org.springframework.stereotype.Component;

@Component
public class EmpfListContractFactory {

    public EmpfListContractRequest buildEmpfListContractRequest(String agency, String account, String digit,
                                                                String ownership, String cpfCnpj,String digitCpfCnpj,
                                                                String cnpjFilial, String brand, String requestDate,
                                                                String startDate, String endDate) {
       return EmpfListContractRequest.builder()
               .agency(agency)
               .account(account)
               .digit(digit)
               .ownership(ownership)
               .cpfCnpj(cpfCnpj)
               .digitCpfCnpj(digitCpfCnpj)
               .filialCnpj(cnpjFilial)
               .brand(brand)
               .requestDate(requestDate)
               .startDate(startDate)
               .endDate(endDate)
               .build();
    }
}
