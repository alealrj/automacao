package br.com.bradesco.coredigital.api.automation.model.response.supply.account;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Resources implements Serializable {

    private String resourceId;

    private String type;

    private String status;
}
