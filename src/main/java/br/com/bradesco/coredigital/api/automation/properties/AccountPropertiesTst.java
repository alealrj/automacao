package br.com.bradesco.coredigital.api.automation.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class AccountPropertiesTst {

    @Value("${application.account.list.supply}")
    private String listAccountSupplytHost;

    @Value("${application.account.identification.supply}")
    private String identificationAccountSupplytHost;

    @Value("${application.account.balance.supply}")
    private String balanceAccountSupplytHost;

    @Value("${application.account.transaction.supply}")
    private String transactionAccountSupplytHost;

    @Value("${application.account.limits.supply}")
    private String limitsAccountSupplytHost;

    @Value("${application.account.list.core}")
    private String listAccountCoretHost;

    @Value("${application.account.identification.core}")
    private String identificationAccountCoretHost;

    @Value("${application.account.balance.core}")
    private String balanceAccountCoretHost;

    @Value("${application.account.transaction.core}")
    private String transactionAccountCoretHost;

    @Value("${application.account.limits.core}")
    private String limitsAccountCoretHost;

    @Value("${application.account.list}")
    private String listAccountCwsHost;

    @Value("${application.account.identification}")
    private String identificationAccountCwsHost;

    @Value("${application.account.resources}")
    private String resourcesAccountHost;

    @Value("${application.account.transaction.type}")
    private String transactionTypeAccountCwsHost;
}
