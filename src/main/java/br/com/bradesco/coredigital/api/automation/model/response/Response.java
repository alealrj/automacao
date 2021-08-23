package br.com.bradesco.coredigital.api.automation.model.response;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

import java.util.List;

@Getter
@Setter
public class Response {

    public Integer httpCode;

    public List<ResponseError> errors;

    @Getter
    @Setter
    public static class ResponseError {

        private String code;

        private String title;

        private String detail;
    }
}
