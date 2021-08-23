package br.com.bradesco.coredigital.api.automation.model.response.cws;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class UnarrangedAccountsOverdraftContractCws implements Serializable {

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

    private List<ListaEncargo> listaEncargos;

    @Getter
    @Setter
    public static class ListaEncargo {

        private BigDecimal ctpoEncargo;

        private String infoAdic;

        private BigDecimal percEncargo;
    }
}
