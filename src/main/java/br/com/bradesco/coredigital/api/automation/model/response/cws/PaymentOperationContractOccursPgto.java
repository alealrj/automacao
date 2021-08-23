package br.com.bradesco.coredigital.api.automation.model.response.cws;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class PaymentOperationContractOccursPgto implements Serializable {

    private int codPgto;

    private String dtPgto;

    private int sitPgto;

    private String pgtoAvulso;

    private int codTpPagto;

    private BigDecimal vlrTpPagto;
}
