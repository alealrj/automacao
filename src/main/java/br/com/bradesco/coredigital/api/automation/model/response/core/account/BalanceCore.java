package br.com.bradesco.coredigital.api.automation.model.response.core.account;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class BalanceCore implements Serializable {

    private BigDecimal availableAmount;

    private BigDecimal blockedAmount;

    private BigDecimal automaticallyInvestedAmount;
}
