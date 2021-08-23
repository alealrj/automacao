package br.com.bradesco.coredigital.api.automation.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class RegistrationDataPropertiesTst {

    @Value("${application.registrationdata.agora.supply}")
    private String agoraSupply;

    @Value("${application.registrationdata.bradescard.supply}")
    private String bradescardSupply;

    @Value("${application.registrationdata.bradesco.or.next.supply}")
    private String bradescoNextSupply;

    @Value("${application.registrationdata.losango.or.bf.supply}")
    private String losangoBfSupply;

    @Value("${application.registrationdata.agora.core}")
    private String agoraCore;

    @Value("${application.registrationdata.bradesco.or.next.core}")
    private String bradescoNextCore;
}
