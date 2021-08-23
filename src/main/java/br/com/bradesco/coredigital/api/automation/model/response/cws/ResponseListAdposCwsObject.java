package br.com.bradesco.coredigital.api.automation.model.response.cws;

import br.com.bradesco.coredigital.api.automation.model.response.Response;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ResponseListAdposCwsObject extends Response implements Serializable {

    private BigDecimal numberOfContracts;

    private List<ContractList> contracts;

    @Getter
    @Setter
    public static class ContractList {

        private String ccart;

        private BigDecimal cmodldRzCtbil;

        private String ncontrIpoc;

        private String descModld;

        private BigDecimal ncontrAdepos;
    }
}
