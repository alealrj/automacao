package br.com.bradesco.coredigital.api.automation.model;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class InformedRevenue implements Serializable {

    private String frequency;

    private String frequencyAdditionalInfo;

    private BigDecimal amount;

    private String currency;

    private int year;
}
