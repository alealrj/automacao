package br.com.bradesco.coredigital.api.automation.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class InvoiceFinancingsPropertiesTst {

    @Value("${application.invoiceFinancings.contract.supply}")
    private String contractSupplyHost;

    @Value("${application.invoiceFinancings.list.supply}")
    private String listSupplyHost;

    @Value("${application.invoiceFinancings.instalment.supply}")
    private String instalmentSupplyHost;

    @Value("${application.invoiceFinancings.payment.supply}")
    private String paymentSupplyHost;

    @Value("${application.invoiceFinancings.contract.core}")
    private String contractCoreHost;

    @Value("${application.invoiceFinancings.list.core}")
    private String listCoreHost;

    @Value("${application.invoiceFinancings.instalment.core}")
    private String instalmentCoreHost;

    @Value("${application.invoiceFinancings.contract.cws}")
    private String contractCwsHost;

    @Value("${application.invoiceFinancings.list.cws}")
    private String listCwsHost;

    @Value("${application.invoiceFinancings.instalments.cws}")
    private String instalmentCwsHost;
}
