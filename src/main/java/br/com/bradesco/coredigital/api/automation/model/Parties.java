package br.com.bradesco.coredigital.api.automation.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Parties implements Serializable {

    private String personType;

    private String type;

    private String civilName;

    private String socialName;

    private String companyName;

    private String tradeName;

    private String startDate;

    private String shareholding;

    private String documentType;

    private String documentNumber;

    private String documentAdditionalInfo;

    private String documentCountry;

    private String documentExpirationDate;

    private String documentIssueDate;
}
