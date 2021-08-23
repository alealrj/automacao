package br.com.bradesco.coredigital.api.automation.factory.authorization;

import br.com.bradesco.coredigital.api.automation.model.request.authorization.PermissionAuthorization;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class PermissionAuthorizationFactory {

    public PermissionAuthorization buildPermissionAuthorization(List<String> permissions) {

        return PermissionAuthorization.builder()
                .status("ACTIVE")
                .iss("bradesco-ob")
                .aud("https:// openbanking")
                .exp(new BigDecimal("1623546435"))
                .iat(new BigDecimal("543214532134"))
                .nbf(new BigDecimal("432143243214"))
                .kid("4783921748923")
                .jti(new BigDecimal("342343254343"))
                .sub("cpf-4u3i20248902")
                .scp("openid loans")
                .certificateDn("CN=Quickbooks Pro, OU=Quickbooks Prod, O=Intuit, C=BR")
                .consentData(buildConsetConsentData(permissions))
                .userInfo(buildUserInfo())
                .build();

    }

    private PermissionAuthorization.ConsentData buildConsetConsentData(List<String> permissions) {

        return PermissionAuthorization.ConsentData.builder()
                .consentID("123")
                .clientId("Identificador do TPP")
                .permissions(permissions)
                .build();
    }

    private PermissionAuthorization.UserInfo buildUserInfo() {

        return PermissionAuthorization.UserInfo.builder()
                .userId("12312312")
                .businessId("1234")
                .branch("237")
                .account("1996")
                .accountDigit("2001")
                .holder("1")
                .build();
    }
}
