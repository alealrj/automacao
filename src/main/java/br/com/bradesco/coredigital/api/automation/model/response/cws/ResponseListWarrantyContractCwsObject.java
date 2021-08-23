package br.com.bradesco.coredigital.api.automation.model.response.cws;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ResponseListWarrantyContractCwsObject implements Serializable {

    private List<WarrantyContractList> contracts;

    @Getter
    @Setter
    public static class WarrantyContractList {

        private BigDecimal cgarnt;

        private BigDecimal cgpBacen;

        private BigDecimal csbgpBacen;

        private String dscMoeda;

        private BigDecimal vorignGarnt;
    }
}
