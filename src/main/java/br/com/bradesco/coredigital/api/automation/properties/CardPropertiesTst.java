package br.com.bradesco.coredigital.api.automation.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CardPropertiesTst {

    @Value("${application.card.list.supply}")
    private String listSupplytHost;

    @Value("${application.card.identification.supply}")
    private String identificationSupplyHost;

    @Value("${application.card.bill.supply}")
    private String billSupplyHost;

    @Value("${application.card.transaction.supply}")
    private String transactionSupplyHost;

    @Value("${application.card.limit.supply}")
    private String limitSupplyHost;

    @Value("${application.card.invoice.transaction.supply}")
    private String invoiceTransactionSupplyHost;
}
