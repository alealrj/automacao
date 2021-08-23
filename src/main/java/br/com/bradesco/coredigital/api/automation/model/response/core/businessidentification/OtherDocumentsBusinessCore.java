package br.com.bradesco.coredigital.api.automation.model.response.core.businessidentification;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OtherDocumentsBusinessCore implements Serializable {

    private String type;

    private String number;

    private String country;

    private String expirationDate;
}
