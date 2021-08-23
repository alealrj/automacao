package br.com.bradesco.coredigital.api.automation.model.request.cws;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class CwsListDcomRequest implements Serializable {

    private String requestDate;

    private String startDate;

    private String endDate;

    private String agency;

    private String account;

    private String ownership;

    private String cpfCnpj;

    private String filialCnpj;

    private String digitCpfCnpj;
}
