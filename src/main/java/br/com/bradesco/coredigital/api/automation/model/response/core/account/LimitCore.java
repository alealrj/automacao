package br.com.bradesco.coredigital.api.automation.model.response.core.account;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class LimitCore implements Serializable {

    private BigDecimal overdraftLimitContracted;

    private BigDecimal overdraftLimitUsed;
}
