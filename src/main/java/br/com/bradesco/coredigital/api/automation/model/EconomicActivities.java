package br.com.bradesco.coredigital.api.automation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class EconomicActivities implements Serializable {

    private long code;

    @JsonProperty("isMain")
    private boolean isMain;
}
