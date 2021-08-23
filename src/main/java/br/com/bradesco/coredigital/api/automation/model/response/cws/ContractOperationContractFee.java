package br.com.bradesco.coredigital.api.automation.model.response.cws;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class ContractOperationContractFee implements Serializable {

    private int formaCobrTarf;

    private BigDecimal valorTarifa;

    private BigDecimal percentualTarifa;
}
