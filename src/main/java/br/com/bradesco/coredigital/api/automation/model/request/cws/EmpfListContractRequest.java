package br.com.bradesco.coredigital.api.automation.model.request.cws;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class EmpfListContractRequest implements Serializable {

    private String agency;

    private String account;

    private String digit;

    private String ownership;

    private String cpfCnpj;

    private String digitCpfCnpj;

    private String filialCnpj;

    private String brand;

    private String requestDate;

    private String startDate;

    private String endDate;
}