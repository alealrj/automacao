package br.com.bradesco.coredigital.api.automation.model.response.core.personalcustomerqualification;

import br.com.bradesco.coredigital.api.automation.model.InformedIncome;
import br.com.bradesco.coredigital.api.automation.model.InformedPatrimony;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PersonalCustomerQualificationCore implements Serializable {

    private String updateDateTime;

    private String companyCnpj;

    private String occupationCode;

    private String occupationDescription;

    private InformedIncome informedIncome;

    private InformedPatrimony informedPatrimony;
}
