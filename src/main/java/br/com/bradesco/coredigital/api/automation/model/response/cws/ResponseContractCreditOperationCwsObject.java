package br.com.bradesco.coredigital.api.automation.model.response.cws;

import br.com.bradesco.coredigital.api.automation.model.response.Response;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ResponseContractCreditOperationCwsObject extends Response implements Serializable {

    private BigDecimal ncontrAdepos;

    private String ncontrIpoc;

    private String descModld;

    private BigDecimal cmodldRzCtbil;

    private String dcontrOper;

    private BigDecimal taxaJuros;

    private String ccart;

    private String descTarifa;

    private String siglaTarifa;

    private BigDecimal vlrTarifa;

    private BigDecimal qtsOccurs;

    private List<ListaEncargos> listaEncargos;

    @Getter
    @Setter
    public static class ListaEncargos {

        private BigDecimal sinfoAdic;

        private BigDecimal sctpoEncargo;

        private BigDecimal spercEncargo;
    }
}
