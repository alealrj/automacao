package br.com.bradesco.coredigital.api.automation.model.response.core.businessqualification;

import br.com.bradesco.coredigital.api.automation.model.EconomicActivities;
import br.com.bradesco.coredigital.api.automation.model.InformedPatrimony;
import br.com.bradesco.coredigital.api.automation.model.InformedRevenue;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class BusinessQualificationCore implements Serializable {

    private String updateDateTime;

    private List<EconomicActivities> economicActivities;

    private InformedRevenue informedRevenue;

    private InformedPatrimony informedPatrimony;
}
