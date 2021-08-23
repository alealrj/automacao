package br.com.bradesco.coredigital.api.automation.model.response.egrees.card;

import br.com.bradesco.coredigital.api.automation.model.response.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class InvoiceTransactionEgrees extends Response implements Serializable {

    private String origem;

    private String codigoRetorno;

    private String mensagem;

    private String chaveReestart;

    @JsonProperty ("Transacoes")
    private List<Transacoes> Transacoes;

    @Getter
    @Setter
    public class Transacoes implements Serializable{

        private String codigo;

        private String dataEfetiva;

        private String dataPostagem;

        private String descricao;

        private String forma;

        private long numeroParcela;

        private long quantidadeParcelas;

        private String tipo;

        private String valorReal;

        private String valorDolar;

        private String valorOrigem;

        private long cotacaoDolar;

        private String numeroCartao;

        private String moedaOrigem;

        private String codigoMcc;
    }
}
