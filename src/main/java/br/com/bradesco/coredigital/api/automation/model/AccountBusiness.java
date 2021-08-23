package br.com.bradesco.coredigital.api.automation.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AccountBusiness implements Serializable {

    private String compeCode;

    private String branchCode;

    private String number;

    private String checkDigit;

    private String type;
}
