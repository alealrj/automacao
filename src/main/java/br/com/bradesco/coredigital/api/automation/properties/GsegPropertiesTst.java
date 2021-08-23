package br.com.bradesco.coredigital.api.automation.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class GsegPropertiesTst {

    @Value("${application.gseg.token.host}")
    private String gsegHost;

    @Value("${application.gseg.token.xlogincanal}")
    private String gsegXlogincanal;

    @Value("${application.gseg.token.xloginempresa}")
    private String gsegXloginempresa;

    @Value("${application.gseg.token.xloginidioma}")
    private String gsegXloginidioma;

    @Value("${application.gseg.token.xloginperiferico}")
    private String gsegXloginperiferico;

    @Value("${application.gseg.token.xlogindependencia}")
    private String gsegXloginindependencia;
}
