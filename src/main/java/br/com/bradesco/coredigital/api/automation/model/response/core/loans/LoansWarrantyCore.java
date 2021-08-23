package br.com.bradesco.coredigital.api.automation.model.response.core.loans;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class LoansWarrantyCore implements Serializable {

    private String currency;

    private String warrantyType;

    private String warrantySubType;

    private BigDecimal warrantyAmount;
}
