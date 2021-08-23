package br.com.bradesco.coredigital.api.automation.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CwsLoansFinancingsPropertiesTst {

    @Value("${application.ches.host}")
    private String chesHost;

    @Value("${application.empf.host}")
    private String empfHost;

    @Value("${application.empg.host}")
    private String empgHost;

    @Value("${application.gran.host}")
    private String granHost;

    @Value("${application.crin.host}")
    private String crinHost;
}
