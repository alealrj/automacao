package br.com.bradesco.coredigital.api.automation.model.request.authorization;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
public class PermissionAuthorization implements Serializable {

    private String status;

    private String iss;

    private String aud;

    private BigDecimal exp;

    private BigDecimal iat;

    private BigDecimal nbf;

    private String kid;

    private BigDecimal jti;

    private String sub;

    private String scp;

    @JsonProperty("certificate-dn")
    private String certificateDn;

    @JsonProperty("consent.data")
    private ConsentData consentData;

    @JsonProperty("user.info")
    private UserInfo userInfo;

    @Getter
    @Setter
    @Builder
    public static class ConsentData {

        private String consentID;

        private String clientId;

        private List<String> permissions;
    }

    @Getter
    @Setter
    @Builder
    public static class UserInfo {

        private String userId;

        private String businessId;

        private String branch;

        private String account;

        private String accountDigit;

        private String holder;
    }
}
