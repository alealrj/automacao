package br.com.bradesco.coredigital.api.automation.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class EgreesCardPropertiesTst {

    @Value("${application.card.list.egrees}")
    private String listEgreestHost;

    @Value("${application.card.identification.egrees}")
    private String identificationEgreesHost;

    @Value("${application.card.bill.egrees}")
    private String billEgreesHost;

    @Value("${application.card.transaction.egrees}")
    private String transactionEgreesHost;

    @Value("${application.card.limit.egrees}")
    private String limitsEgreesHost;

    @Value("${application.card.invoice.transaction.egrees}")
    private String invoiceTransactionEgreesHost;

    @Value("${application.card.token.egrees}")
    private String tokenEgreesHost;

    @Value("${application.card.list.losango.egrees}")
    private String listLosangoEgreestHost;

    @Value("${application.card.identification.losango.egrees}")
    private String identificationLosangoEgreesHost;

    @Value("${application.card.bill.losango.egrees}")
    private String billLosangoEgreesHost;

    @Value("${application.card.transaction.losango.egrees}")
    private String transactionLosangoEgreesHost;

    @Value("${application.card.limit.losango.egrees}")
    private String limitsLosangoEgreesHost;

    @Value("${application.card.invoice.transaction.losango.egrees}")
    private String invoiceTransactionLosangoEgreesHost;
}
