package br.com.bradesco.coredigital.api.automation.utils;

import br.com.bradesco.coredigital.api.automation.model.request.authorization.PermissionAuthorization;
import br.com.bradesco.coredigital.api.automation.model.request.authorization.TokenAuthorization;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@Slf4j
public class Base64Utils {

    @Autowired
    private JsonUtils jsonUtils;

    private String jsonText = "";

    private final String ENCODED_TOKEN_JWT = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.{0}.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";

    private final String ENCODED_PERMISSION_JWT = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.{0}.1Vr8UougDL5ZrD7PQvnh_z-gWSVYvSY0oF54ur_DCNc";

    public String getTokenEncodedAuthorization(TokenAuthorization tokenAuthorization) {

        String json = jsonUtils.convertToLineJson(tokenAuthorization)
                .replace("userInfo", "user.info")
                .replace("userAuth", "user.auth")
                .replace("deviceID", "DeviceID")
                .replace("statelessOpen", "stateless-open")
                .replace("statelessClosed", "stateless-closed");

        String encodedString = new String(Base64.encodeBase64(json.getBytes()));
        String encondedFormat = "Bearer ".concat(MessageFormat.format(ENCODED_TOKEN_JWT, encodedString));

        log.info("ENCODED TOKEN AUTHORIZATION: {}", encondedFormat);

        return encondedFormat;
    }

    public String getPermissionEncodedAuthorization(PermissionAuthorization permissionAuthorization) {

        String json = jsonUtils.convertToLineJson(permissionAuthorization)
                .replace("certificateDn", "certificate-dn")
                .replace("consentData", "consent.data")
                .replace("userInfo", "user.info");
        String encodedString = new String(Base64.encodeBase64(json.getBytes()));
        String encondedFormat = "Bearer ".concat(MessageFormat.format(ENCODED_PERMISSION_JWT, encodedString));

        log.info("ENCODED PERMISSION AUTHORIZATION: {}", encondedFormat);
        return encondedFormat;
    }
}
