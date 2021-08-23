package br.com.bradesco.coredigital.api.automation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Phone implements Serializable {

    @JsonProperty("isMain")
    private boolean isMain;

    private String type;

    private String additionalInfo;

    private String countryCallingCode;

    private String areaCode;

    private String number;

    private String phoneExtension;
}
