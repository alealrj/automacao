package br.com.bradesco.coredigital.api.automation.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class LoansPropertiesTst {

    @Value("${application.loans.contract.supply}")
    private String contracSupplytHost;

    @Value("${application.loans.list.supply}")
    private String listSupplyHost;

    @Value("${application.loans.installment.supply}")
    private String installmentSupplyHost;

    @Value("${application.loans.payment.supply}")
    private String paymentSupplyHost;

    @Value("${application.loans.warranty.supply}")
    private String warrantySupplyHost;

    @Value("${application.loans.contract.core}")
    private String contracCoretHost;

    @Value("${application.loans.list.core}")
    private String listCoreHost;

    @Value("${application.loans.installment.core}")
    private String installmentCoreHost;

    @Value("${application.loans.payment.core}")
    private String paymentCoreHost;

    @Value("${application.loans.warranty.core}")
    private String warrantyCoreHost;
}
