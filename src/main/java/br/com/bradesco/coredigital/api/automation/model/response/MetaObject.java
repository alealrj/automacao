package br.com.bradesco.coredigital.api.automation.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaObject {

    private Integer totalRecords;

    private Integer totalPages;

    private String requestDateTime;
}
