package br.com.bradesco.coredigital.api.automation.model.response.core.account;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ListCore implements Serializable {

    private String cpfCnpj;

    private String ownership;

    private String club;

    private String type;

    private String companyContractCode;

    private String contractType;

    private String contractId;

    private String segmentCode;

    private String segmentDescription;

    private String reasonGroup;

    private String reasonSubGroup;

    private String compeCode;

    private String branchCode;

    private String number;

    private String checkDigit;
}
