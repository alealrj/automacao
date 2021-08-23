package br.com.bradesco.coredigital.api.automation.factory.authorization;

import br.com.bradesco.coredigital.api.automation.model.request.authorization.TokenAuthorization;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TokenAuthorizationFactory {

    public TokenAuthorization buildTokenAuthorization(String statelessOpen, String statelessClosed) {

        return TokenAuthorization.builder()
                .ver("1.0")
                .iss("https://openbanking/brand.token")
                .aud("https://openbanking")
                .jti("79847070-6636-474a-a189-6707246b08d9")
                .iat(new BigDecimal("1622154689"))
                .tokenID("GUID gerado para o acess-token")
                .scp("ermissões solicitadas pela marca/canal e validadas no OPBK")
                .userInfo(buildUserInfo())
                .data(buildData())
                .userAuth(buildUserAuth(statelessOpen, statelessClosed))
                .build();
    }

    private TokenAuthorization.UserInfo buildUserInfo() {

        return TokenAuthorization.UserInfo.builder()
                .userId("12312312")
                .agency("0001")
                .account("1234567")
                .accountDigit("1")
                .holder("00")
                .build();
    }

    private TokenAuthorization.Data buildData() {

        return TokenAuthorization.Data.builder()
                .consentId("Id do consentimento")
                .clientId("Id do cliente")
                .build();
    }

    private TokenAuthorization.UserAuth buildUserAuth(String statelessOpen, String statelessClosed) {

        return TokenAuthorization.UserAuth.builder()
                .channelSessID("úmero que identifica a sessão do canal")
                .deviceID("informações do dispositivo do usuário")
                .statelessOpen(statelessOpen)
                .statelessClosed(statelessClosed)
                .build();
    }
}
