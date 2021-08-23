package br.com.bradesco.coredigital.api.automation.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Nationality implements Serializable {

    private String otherNationalitiesInfo;

    private List<DocumentsIdentifications> documents;

    @Getter
    @Setter
    public static class DocumentsIdentifications {

        private String type;

        private String number;

        private String expirationDate;

        private String issueDate;

        private String country;

        private String typeAdditionalInfo;
    }
}
