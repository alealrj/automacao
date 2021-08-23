package br.com.bradesco.coredigital.api.automation.request;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.properties.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@Slf4j
public class UrlUtils {

    @Autowired
    private FinancingPropertiesTst financingPropertiesTst;

    @Autowired
    private LoansPropertiesTst loansPropertiesTst;

    @Autowired
    private CwsLoansFinancingsPropertiesTst cwsLoansFinancingsPropertiesTst;

    @Autowired
    private PreConsentPropertiesTst preConsentPropertiesTst;

    @Autowired
    private GsegPropertiesTst gsegPropertiesTst;

    @Autowired
    private AccountPropertiesTst accountPropertiesTst;

    @Autowired
    private UnarrangedAccountsOverdraftPropertiesTst unarrangedAccountsOverdraftPropertiesTst;

    @Autowired
    private InvoiceFinancingsPropertiesTst invoiceFinancingsPropertiesTst;

    @Autowired
    private CardPropertiesTst cardPropertiesTst;

    @Autowired
    private EgreesCardPropertiesTst egreesPropertiesTst;

    @Autowired
    private RegistrationDataPropertiesTst registrationDataPropertiesTst;

    public String buildUrl(ProjectType projectType, String endpoint, Object... args) {

        log.info("Using project type: {}", projectType);

        String url = null;
        switch (projectType) {

            case FINANCINGS_CONTRACT_SUPPLY:
                url = financingPropertiesTst.getContracSupplytHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case FINANCINGS_LIST_SUPPLY:
                url = financingPropertiesTst.getListSupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case FINANCINGS_INSTALLMENT_SUPPLY:
                url = financingPropertiesTst.getInstallmentSupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case FINANCINGS_PAYMENT_SUPPLY:
                url = financingPropertiesTst.getPaymentSupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case FINANCINGS_WARRANTY_SUPPLY:
                url = financingPropertiesTst.getWarrantySupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case FINANCINGS_CONTRACT_CORE:
                url = financingPropertiesTst.getContracCoretHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case FINANCINGS_LIST_CORE:
                url = financingPropertiesTst.getListCoreHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case FINANCINGS_INSTALLMENT_CORE:
                url = financingPropertiesTst.getInstallmentCoreHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case FINANCINGS_PAYMENT_CORE:
                url = financingPropertiesTst.getPaymentCoreHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case FINANCINGS_WARRANTY_CORE:
                url = financingPropertiesTst.getWarrantyCoreHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case LOANS_CONTRACT_SUPPLY:
                url = loansPropertiesTst.getContracSupplytHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case LOANS_LIST_SUPPLY:
                url = loansPropertiesTst.getListSupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case LOANS_INSTALLMENT_SUPPLY:
                url = loansPropertiesTst.getInstallmentSupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case LOANS_PAYMENT_SUPPLY:
                url = loansPropertiesTst.getPaymentSupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case LOANS_WARRANTY_SUPPLY:
                url = loansPropertiesTst.getWarrantySupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case LOANS_CONTRACT_CORE:
                url = loansPropertiesTst.getContracCoretHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case LOANS_LIST_CORE:
                url = loansPropertiesTst.getListCoreHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case LOANS_INSTALLMENT_CORE:
                url = loansPropertiesTst.getInstallmentCoreHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case LOANS_PAYMENT_CORE:
                url = loansPropertiesTst.getPaymentCoreHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case LOANS_WARRANTY_CORE:
                url = loansPropertiesTst.getWarrantyCoreHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CWS_LOANS_FINANCINGS_CHES:
                url = cwsLoansFinancingsPropertiesTst.getChesHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CWS_LOANS_FINANCINGS_CRIM:
                url = cwsLoansFinancingsPropertiesTst.getCrinHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CWS_LOANS_FINANCINGS_EMPF:
                url = cwsLoansFinancingsPropertiesTst.getEmpfHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CWS_LOANS_FINANCINGS_EMPG:
                url = cwsLoansFinancingsPropertiesTst.getEmpgHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CWS_LOANS_FINANCINGS_GRAN:
                url = cwsLoansFinancingsPropertiesTst.getGranHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case PRE_CONSENT:
                url = preConsentPropertiesTst.getPreConsenthost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case GSEG:
                url = gsegPropertiesTst.getGsegHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case UNARRANGED_ACCOUNTS_OVERDRAFT_CONTRACT_SUPPLY:
                url = unarrangedAccountsOverdraftPropertiesTst.getContractSupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case UNARRANGED_ACCOUNTS_OVERDRAFT_LIST_SUPPLY:
                url = unarrangedAccountsOverdraftPropertiesTst.getListSupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case UNARRANGED_ACCOUNTS_OVERDRAFT_PAYMENT_SUPPLY:
                url = unarrangedAccountsOverdraftPropertiesTst.getPaymentSupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case UNARRANGED_ACCOUNTS_OVERDRAFT_CONTRACT_CORE:
                url = unarrangedAccountsOverdraftPropertiesTst.getContractCoreHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case UNARRANGED_ACCOUNTS_OVERDRAFT_LIST_CORE:
                url = unarrangedAccountsOverdraftPropertiesTst.getListCoreHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case UNARRANGED_ACCOUNTS_OVERDRAFT_PAYMENT_CORE:
                url = unarrangedAccountsOverdraftPropertiesTst.getPaymentCoreHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case UNARRANGED_ACCOUNTS_OVERDRAFT_LIST_CWS:
                url = unarrangedAccountsOverdraftPropertiesTst.getListCwsHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case UNARRANGED_ACCOUNTS_OVERDRAFT_CONTRACT_CWS:
                url = unarrangedAccountsOverdraftPropertiesTst.getContractCwsHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case UNARRANGED_ACCOUNTS_OVERDRAFT_PAYMENT_CWS:
                url = unarrangedAccountsOverdraftPropertiesTst.getPaymentCwsHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case INVOICE_FINANCINGS_CONTRACT_SUPPLY:
                url = invoiceFinancingsPropertiesTst.getContractSupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case INVOICE_FINANCINGS_LIST_SUPPLY:
                url = invoiceFinancingsPropertiesTst.getListSupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case INVOICE_FINANCINGS_INSTALMENT_SUPPLY:
                url = invoiceFinancingsPropertiesTst.getInstalmentSupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case INVOICE_FINANCINGS_PAYMENT_SUPPLY:
                url = invoiceFinancingsPropertiesTst.getPaymentSupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case INVOICE_FINANCINGS_CONTRACT_CORE:
                url = invoiceFinancingsPropertiesTst.getContractCoreHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case INVOICE_FINANCINGS_LIST_CORE:
                url = invoiceFinancingsPropertiesTst.getListCoreHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case INVOICE_FINANCINGS_INSTALMENT_CORE:
                url = invoiceFinancingsPropertiesTst.getInstalmentCoreHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case INVOICE_FINANCINGS_CONTRACT_CWS:
                url = invoiceFinancingsPropertiesTst.getContractCwsHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case INVOICE_FINANCINGS_LIST_CWS:
                url = invoiceFinancingsPropertiesTst.getListCwsHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case INVOICE_FINANCINGS_INSTALMENT_CWS:
                url = invoiceFinancingsPropertiesTst.getInstalmentCwsHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case ACCOUNT_LIST_SUPPLY:
                url = accountPropertiesTst.getListAccountSupplytHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case ACCOUNT_IDENTIFICATION_SUPPLY:
                url = accountPropertiesTst.getIdentificationAccountSupplytHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case ACCOUNT_BALANCE_SUPPLY:
                url = accountPropertiesTst.getBalanceAccountSupplytHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case ACCOUNT_TRANSACTION_SUPPLY:
                url = accountPropertiesTst.getTransactionAccountSupplytHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case ACCOUNT_LIMIT_SUPPLY:
                url = accountPropertiesTst.getLimitsAccountSupplytHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case ACCOUNT_LIST_CORE:
                url = accountPropertiesTst.getListAccountCoretHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case ACCOUNT_IDENTIFICATION_CORE:
                url = accountPropertiesTst.getIdentificationAccountCoretHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case ACCOUNT_BALANCE_CORE:
                url = accountPropertiesTst.getBalanceAccountCoretHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case ACCOUNT_TRANSACTION_CORE:
                url = accountPropertiesTst.getTransactionAccountCoretHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case ACCOUNT_LIMIT_CORE:
                url = accountPropertiesTst.getLimitsAccountCoretHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case ACCOUNT_RESOURCES:
                url = accountPropertiesTst.getResourcesAccountHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;


            case ACCOUNT_LIST_CWS:
                url = accountPropertiesTst.getLimitsAccountCoretHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case ACCOUNT_TRANSACTION_TYPE_CWS:
                url = accountPropertiesTst.getTransactionTypeAccountCwsHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case ACCOUNT_IDENTIFICATION_CWS:
                url = accountPropertiesTst.getIdentificationAccountCwsHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CARD_LIST_SUPPLY:
                url = cardPropertiesTst.getListSupplytHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CARD_IDENTIFICATION_SUPPLY:
                url = cardPropertiesTst.getIdentificationSupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CARD_BILL_SUPPLY:
                url = cardPropertiesTst.getBillSupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CARD_LIMIT_SUPPLY:
                url = cardPropertiesTst.getLimitSupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CARD_TRANSACTION_SUPPLY:
                url = cardPropertiesTst.getTransactionSupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CARD_INVOICE_TRANSACTION_SUPPLY:
                url = cardPropertiesTst.getInvoiceTransactionSupplyHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CARD_LIST_EGREES:
                url = egreesPropertiesTst.getListEgreestHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CARD_IDENTIFICATION_EGREES:
                url = egreesPropertiesTst.getIdentificationEgreesHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CARD_BILL_EGREES:
                url = egreesPropertiesTst.getBillEgreesHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CARD_LIMITS_EGREES:
                url = egreesPropertiesTst.getLimitsEgreesHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CARD_TRANSACTION_EGREES:
                url = egreesPropertiesTst.getTransactionEgreesHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CARD_INVOICE_TRANSACTION_EGREES:
                url = egreesPropertiesTst.getInvoiceTransactionEgreesHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;


            case REGISTRATION_DATA_AGORA_SUPPLY:
                url = registrationDataPropertiesTst.getAgoraSupply()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case REGISTRATION_DATA_BRADESCARD_SUPPLY:
                url = registrationDataPropertiesTst.getBradescardSupply()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case REGISTRATION_DATA_BRADESCO_OR_NEXT_SUPPLY:
                url = registrationDataPropertiesTst.getBradescoNextSupply()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case REGISTRATION_DATA_LOSANGO_OR_BF_SUPPLY:
                url = registrationDataPropertiesTst.getLosangoBfSupply()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case REGISTRATION_DATA_AGORA_CORE:
                url = registrationDataPropertiesTst.getAgoraCore()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case REGISTRATION_DATABRADESCO_OR_NEXT_CORE:
                url = registrationDataPropertiesTst.getBradescoNextCore()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CARD_LIST_LOSANGO_EGREES:
                url = egreesPropertiesTst.getListLosangoEgreestHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CARD_IDENTIFICATION_LOSANGO_EGREES:
                url = egreesPropertiesTst.getIdentificationLosangoEgreesHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CARD_BILL_LOSANGO_EGREES:
                url = egreesPropertiesTst.getBillLosangoEgreesHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CARD_LIMITS_LOSANGO_EGREES:
                url = egreesPropertiesTst.getLimitsLosangoEgreesHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CARD_TRANSACTION_LOSANGO_EGREES:
                url = egreesPropertiesTst.getTransactionLosangoEgreesHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            case CARD_INVOICE_TRANSACTION_LOSANGO_EGREES:
                url = egreesPropertiesTst.getInvoiceTransactionLosangoEgreesHost()
                        .concat(MessageFormat.format(endpoint, args));
                break;

            default:
                throw new IllegalStateException("Host invalido: " + projectType);
        }

        return url;
    }
}
