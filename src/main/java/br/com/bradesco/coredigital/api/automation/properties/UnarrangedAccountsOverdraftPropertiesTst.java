package br.com.bradesco.coredigital.api.automation.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class UnarrangedAccountsOverdraftPropertiesTst {

    @Value("${application.unarrangedAccountsOverdraft.contract.supply}")
    private String contractSupplyHost;

    @Value("${application.unarrangedAccountsOverdraft.list.supply}")
    private String listSupplyHost;

    @Value("${application.unarrangedAccountsOverdraft.payment.supply}")
    private String paymentSupplyHost;

    @Value("${application.unarrangedAccountsOverdraft.contract.core}")
    private String contractCoreHost;

    @Value("${application.unarrangedAccountsOverdraft.list.core}")
    private String listCoreHost;

    @Value("${application.unarrangedAccountsOverdraft.payment.core}")
    private String paymentCoreHost;

    @Value("${application.unarrangedAccountsOverdraft.list.cws}")
    private String listCwsHost;

    @Value("${application.unarrangedAccountsOverdraft.contract.cws}")
    private String contractCwsHost;

    @Value("${application.unarrangedAccountsOverdraft.payment.cws}")
    private String paymentCwsHost;
}
