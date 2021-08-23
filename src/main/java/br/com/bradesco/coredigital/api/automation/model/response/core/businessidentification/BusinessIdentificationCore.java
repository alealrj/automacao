package br.com.bradesco.coredigital.api.automation.model.response.core.businessidentification;

import br.com.bradesco.coredigital.api.automation.model.Contact;
import br.com.bradesco.coredigital.api.automation.model.Parties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class BusinessIdentificationCore implements Serializable {

    private String updateDateTime;

    private String businessId;

    private String brandName;

    private String companyName;

    private String tradeName;

    private String incorporationDate;

    private String cnpjNumber;

    private List<String> companyCnpjNumber;

    private List<OtherDocumentsBusinessCore> otherDocuments;

    private List<Parties> parties;

    private Contact contacts;
}
