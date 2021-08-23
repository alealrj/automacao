package br.com.bradesco.coredigital.api.automation.model.response.egrees.card;

import br.com.bradesco.coredigital.api.automation.model.response.Response;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TokenEgrees extends Response implements Serializable {

    private String accessToken;

    private String tokenType;

    private String expiresIn;
}
