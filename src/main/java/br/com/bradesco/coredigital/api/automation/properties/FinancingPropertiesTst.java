package br.com.bradesco.coredigital.api.automation.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class FinancingPropertiesTst {

    @Value("${application.financings.contract.supply}")
    private String contracSupplytHost;

    @Value("${application.financings.list.supply}")
    private String listSupplyHost;

    @Value("${application.financings.installment.supply}")
    private String installmentSupplyHost;

    @Value("${application.financings.payment.supply}")
    private String paymentSupplyHost;

    @Value("${application.financings.warranty.supply}")
    private String warrantySupplyHost;

    @Value("${application.financings.contract.core}")
    private String contracCoretHost;

    @Value("${application.financings.list.core}")
    private String listCoreHost;

    @Value("${application.financings.installment.core}")
    private String installmentCoreHost;

    @Value("${application.financings.payment.core}")
    private String paymentCoreHost;

    @Value("${application.financings.warranty.core}")
    private String warrantyCoreHost;
}
