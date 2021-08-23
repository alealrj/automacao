package br.com.bradesco.coredigital.api.automation.request;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseListData;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.utils.JsonUtils;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.MessageFormat;

import static io.restassured.RestAssured.given;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class RequestUtils {

    private final UrlUtils urlUtils;

    private final JsonUtils jsonUtils;

    public <T> ResponseObject<T> postResponseObject(Headers headers, Object body, final Class<T> clazz, String url) {

        log.info("REQUEST -> Executing POST on {}", url);
        log.info("REQUEST -> Headers: {}", jsonUtils.convertToJson(headers.asList()));
        log.info("REQUEST -> Body: {}", jsonUtils.convertToJson(body));

        RestAssured.useRelaxedHTTPSValidation();
        final Response response = given()
                .config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames()))
                .contentType(APPLICATION_JSON_VALUE)
                .headers(headers)
                .body(jsonUtils.convertToJson(body))
                .post(url);

        T data = convertResponseToObject(response, clazz);

        ResponseObject<T> responseObject = new ResponseObject<>();
        responseObject.setData(data);
        responseObject.setHttpCode(response.getStatusCode());

        return responseObject;
    }

    public <T> ResponseObject<T> getResponseObject (Headers headers, final Class<T> clazz, String url) {

        log.info("REQUEST -> Executing GET on {}", url);
        log.info("REQUEST -> Headers: {}", jsonUtils.convertToJson(headers.asList()));

        RestAssured.useRelaxedHTTPSValidation();
        final Response response = given()
                .contentType(APPLICATION_JSON_VALUE)
                .headers(headers)
                .get(url);

        boolean contains = response.getBody().asString()
                .replace("\n", "")
                .replace("\r", "")
                .replace(" ", "")
                .contains("{\"data\":{");

        if(contains) {
            return convertResponseToResponseObject(response, clazz);
        }

        T data = convertResponseToObject(response, clazz);

        ResponseObject<T> responseObject = new ResponseObject<>();
        responseObject.setData(data);
        responseObject.setHttpCode(response.getStatusCode());

        return responseObject;
    }

    public <T> ResponseListData<T> getResponseListData(Headers headers, final Class<T> clazz, String url) {

        log.info("REQUEST -> Executing GET on {}", url);
        log.info("REQUEST -> Headers: {}", jsonUtils.convertToJson(headers.asList()));

        RestAssured.useRelaxedHTTPSValidation();
        final Response response = given()
                .contentType(APPLICATION_JSON_VALUE)
                .headers(headers)
                .get(url);

        return converResponseToResponsetListData(response, clazz);
    }

    public Headers getHeadersResponse(Headers headers, String endpoint, Object... endpointParameters) {

        String url = urlUtils.buildUrl(ProjectType.GSEG, endpoint, endpointParameters);

        log.info("REQUEST -> Executing GET on {}", url);
        log.info("REQUEST -> Headers: {}", jsonUtils.convertToJson(headers.asList()));

        RestAssured.useRelaxedHTTPSValidation();
        final Response response = given()
                .contentType(APPLICATION_JSON_VALUE)
                .headers(headers)
                .get(url);

        log.info("RESPONSE -> Response Headers: {}", response.getHeaders().asList());
        log.info("RESPONSE -> Status Code: {}", response.getStatusCode());
        log.info("RESPONSE -> Time: {} ms", response.getTime());

        return response.getHeaders();
    }

    private <T> ResponseObject<T> convertResponseToResponseObject(Response response, Class<T> clazz) {

        ResponseObject<T> responseConverted = new ResponseObject<>();

        logInfoResponseInfo(response, clazz.getTypeName());

        try {

            if (!response.getBody().asString().isEmpty()) {

                responseConverted = response.getBody().as(getTypeFromClassResponseObject(clazz));
                log.info("RESPONSE -> Body: {}", jsonUtils.convertToJson(responseConverted));
            }

            responseConverted.setHttpCode(response.getStatusCode());
        } catch (Exception e) {

            handlerException(response, e);
        }

        return responseConverted;
    }

    private <T> ResponseListData<T> converResponseToResponsetListData(Response response, Class<T> clazz) {

        ResponseListData<T> responseConverted = null;

        logInfoResponseInfo(response, clazz.getTypeName());

        try {

            if (!response.getBody().asString().isEmpty()) {

                responseConverted = response.getBody().as(getTypeFromClassResponseListData(clazz));
                log.info("RESPONSE -> Body: {}", jsonUtils.convertToJson(responseConverted));
            }

            responseConverted.setHttpCode(response.getStatusCode());
        } catch (Exception e) {

            handlerException(response, e);
        }

        return responseConverted;
    }

    private <T> T convertResponseToObject(Response response, Class<T> clazz) {

        T responseConverted = null;

        logInfoResponseInfo(response, clazz.getTypeName());

        try {

            if (!response.getBody().asString().isEmpty()) {

                responseConverted = jsonUtils.convertToObject(response.getBody().asString(), clazz);
                log.info("RESPONSE -> Body: {}", jsonUtils.convertToJson(responseConverted));
            }

        } catch (Exception e) {

            handlerException(response, e);
        }

        return responseConverted;
    }

    private void logInfoResponseInfo(Response response, String clazzTypeName) {

        log.info("RESPONSE -> ResponseType: {}", clazzTypeName);
        log.info("RESPONSE -> Status Code: {}", response.getStatusCode());
        log.info("RESPONSE -> Time: {} ms", response.getTime());
    }

    private void handlerException(Response response, Exception exception) {

        throw new RuntimeException(
                MessageFormat.format("Failure to convert response -> {0}\nException Message -> {1}",
                        response.getBody().print(), exception.getMessage()));
    }

    private <T> Type getTypeFromClassResponseObject(Class<T> clazz) {

        return new ParameterizedTypeReference<ResponseObject<T>>() {

            public Type getType() {

                return new ParameterizedTypeImpl((ParameterizedType) super.getType(), new Type[]{clazz});
            }
        }.getType();
    }

    private <T> Type getTypeFromClassResponseListData(Class<T> clazz) {

        return new ParameterizedTypeReference<ResponseListData<T>>() {

            public Type getType() {

                return new ParameterizedTypeImpl((ParameterizedType) super.getType(), new Type[]{clazz});
            }
        }.getType();
    }
}
