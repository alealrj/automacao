package br.com.bradesco.coredigital.api.automation.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class InformedIncome implements Serializable {

    private String frequency;

    private BigDecimal amount;

    private String currency;

    private String date;
}
