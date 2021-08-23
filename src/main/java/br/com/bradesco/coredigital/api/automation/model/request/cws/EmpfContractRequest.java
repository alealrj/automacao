package br.com.bradesco.coredigital.api.automation.model.request.cws;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class EmpfContractRequest implements Serializable {

    private long contractNumber;

    private long productCode;

    private long familyContractCode;

    private String requestDate;

    private String startConsentDate;

    private String endConsentDate;
}
