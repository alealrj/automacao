package br.com.bradesco.coredigital.api.automation.model.response.cws;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ResponseChesPaymentContractCwsObject implements Serializable {

    private String moeda;

    private BigDecimal sdoDvdor;

    private int qtdPgto;

    private List<PaymentOperationContractOccursPgto> occursPgto;
}
