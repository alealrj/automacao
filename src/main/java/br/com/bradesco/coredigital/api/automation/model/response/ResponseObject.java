package br.com.bradesco.coredigital.api.automation.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseObject<T> extends Response {

    private T data;

    private MetaObject meta;

    private Link links;
}
