package br.com.bradesco.coredigital.api.automation.model.response.core.account;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class TransactionCore implements Serializable {

    private String completedAuthorisedPaymentType;

    private String creditDebitType;

    private String transactionName;

    private BigDecimal amount;

    private String transactionDate;

    private String transactionId;
}
