package br.com.bradesco.coredigital.api.automation.model.request.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class TokenAuthorization implements Serializable {

    public String ver;

    public String iss;

    public String aud;

    public String jti;

    public BigDecimal iat;

    public String tokenID;

    public String scp;

    @JsonProperty("user.info")
    public UserInfo userInfo;

    public Data data;

    @JsonProperty("user.auth")
    public UserAuth userAuth;

    @Getter
    @Setter
    @Builder
    public static class UserInfo {

        public String userId;

        public String agency;

        public String account;

        public String accountDigit;

        public String holder;
    }

    @Getter
    @Setter
    @Builder
    public static class Data {
        public String consentId;

        public String clientId;
    }

    @Getter
    @Setter
    @Builder
    public static class UserAuth {
        public String channelSessID;

        @JsonProperty("DeviceID")
        public String deviceID;

        @JsonProperty("stateless-open")
        public String statelessOpen;

        @JsonProperty("stateless-closed")
        public String statelessClosed;
    }
}
