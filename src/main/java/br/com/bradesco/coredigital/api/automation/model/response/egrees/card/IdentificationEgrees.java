package br.com.bradesco.coredigital.api.automation.model.response.egrees.card;

import br.com.bradesco.coredigital.api.automation.model.response.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class IdentificationEgrees extends Response implements Serializable {

    private List<Mensagens> mensagens;

    private List<CartoesCliente> cartoesCliente;

    private Chaves chavesRestart;

    @Getter
    @Setter
    public static class Mensagens implements Serializable{

        private String origem;

        private String codigoRetorno;

        private String mensagem;
    }

    @Getter
    @Setter
    public static class CartoesCliente implements Serializable{

        private String origem;

        private String numeroCartao;

        private String contaFaturamento;

        private String bandeiraCartao;

        private String nomeProduto;

        private String tipoCartao;

        private String produtoCartao;

        private String subProdutoCartao;

        private String titularidade;

        private String statusCartao;

        private int tipoBloqueio;

        private String cartaoMultiplo;

        private String cartaoEspelho;

        private String companyId;

        private String statusConta;

        private int tipoBloqCta001;

        private int tipoBloqCta002;
    }

    @Getter
    @Setter
    public static class Chaves implements Serializable {

        private String b2k;
    }
}
