package br.com.bradesco.coredigital.api.automation.model.response.cws;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ResponseEmpfInstallmentContractCwsObject implements Serializable {

    private BigDecimal prazoRemanes;

    private BigDecimal tpPrazoRemanes;

    private BigDecimal prazoTotal;

    private BigDecimal tpPrazoTotal;

    private BigDecimal qpcelaVencd;

    private BigDecimal qpcelaAvenc;

    private BigDecimal qpcelaPg;

    private BigDecimal numConsultas;

    private List<Parcela> parcela;

    @Getter
    @Setter
    public static class Parcela {

        private BigDecimal cpcelaContr;

        private String dvctoPcela;

        private BigDecimal vpcelaInfmdNegoc;

        private BigDecimal ctpoSitPcela;
    }
}
