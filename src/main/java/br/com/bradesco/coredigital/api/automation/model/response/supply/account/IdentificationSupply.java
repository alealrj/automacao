package br.com.bradesco.coredigital.api.automation.model.response.supply.account;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class IdentificationSupply implements Serializable {

    private String compeCode;

    private String branchCode;

    private String number;

    private String checkDigit;

   private String type;

    private String subtype;

    private String currency;
}
