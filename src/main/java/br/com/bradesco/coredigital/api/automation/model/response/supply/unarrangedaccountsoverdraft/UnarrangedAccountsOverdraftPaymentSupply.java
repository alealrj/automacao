package br.com.bradesco.coredigital.api.automation.model.response.supply.unarrangedaccountsoverdraft;

import br.com.bradesco.coredigital.api.automation.model.Release;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class UnarrangedAccountsOverdraftPaymentSupply implements Serializable {

    private BigDecimal paidInstalments;

    private BigDecimal contractOutstandingBalance;

    private List<Release> releases;
}
