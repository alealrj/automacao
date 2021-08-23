package br.com.bradesco.coredigital.api.automation.model.response.supply.account;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class BalanceSupply implements Serializable {

    private BigDecimal availableAmount;

    private BigDecimal blockedAmount;

    private BigDecimal automaticallyInvestedAmount;

    private String availableAmountCurrency;

    private String blockedAmountCurrency;

    private String automaticallyInvestedAmountCurrency;
}

