package br.com.bradesco.coredigital.api.automation.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseListData<T> extends Response {

    private List<T> data;

    private MetaObject meta;

    private Link links;
}
