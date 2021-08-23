package br.com.bradesco.coredigital.api.automation.model.request.cws;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class GranWarrantyContractRequest implements Serializable {

    private BigDecimal ecpssoaJuridContr;

    private int ectpoContrNego;

    private BigDecimal enseqContrNego;

    private int ecbco;

    private int ecagBcria;

    private BigDecimal ecctaBcriaCli;

    private String eccart;

    private BigDecimal eccontrFincd;
}
