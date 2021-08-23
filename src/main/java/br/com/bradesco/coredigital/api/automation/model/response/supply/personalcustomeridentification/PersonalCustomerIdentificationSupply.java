package br.com.bradesco.coredigital.api.automation.model.response.supply.personalcustomeridentification;

import br.com.bradesco.coredigital.api.automation.model.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class PersonalCustomerIdentificationSupply implements Serializable {

    private String updateDateTime;

    private String personalId;

    private String brandName;

    private String civilName;

    private String socialName;

    private String birthDate;

    private String maritalStatusCode;

    private String maritalStatusAdditionalInfo;

    private String sex;

    private List<String> companyCnpj;

    private Documents documents;

    private List<OtherDocuments> otherDocuments;

    private boolean hasBrazilianNationality;

    private List<Nationality> nationality;

    private List<Filiation> filiation;

    private Contact contacts;
}