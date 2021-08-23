package br.com.bradesco.coredigital.api.automation.model.response.supply.account;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class TransactionSupply implements Serializable {

    private String completedAuthorisedPaymentType;

    private String creditDebitType;

    private String transactionName;

    private BigDecimal amount;

    private String transactionDate;

    private String partieCnpjCpf;

    private String partiePersonType;

    private String partieCompeCode;

    private String partieBranchCode;

    private String partieNumber;

    private String partieCheckDigit;
}
