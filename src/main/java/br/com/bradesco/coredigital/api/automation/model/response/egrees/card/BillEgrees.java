package br.com.bradesco.coredigital.api.automation.model.response.egrees.card;

import br.com.bradesco.coredigital.api.automation.model.response.Response;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class BillEgrees extends Response implements Serializable {

    private String origem;

    private String codigoRetorno;

    private String mensagem;

    private List<CartoesFatura> cartoesFatura;

    @Getter
    @Setter
    public class CartoesFatura implements Serializable{

        private String situacaoFatura;

        private String dataVencimento;

        private String dataCorte;
    }
}
