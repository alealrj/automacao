package br.com.bradesco.coredigital.api.automation.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OtherDocuments implements Serializable {

    private String type;

    private String typeAdditionalInfo;

    private String number;

    private String checkDigit;

    private String additionalInfo;

    private String expirationDate;
}
