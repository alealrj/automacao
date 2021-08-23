package br.com.bradesco.coredigital.api.automation.service;


import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseListData;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.request.RequestUtils;
import br.com.bradesco.coredigital.api.automation.request.UrlUtils;
import br.com.bradesco.coredigital.api.automation.utils.SchemaUtils;
import io.restassured.http.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecimentoService {

    @Autowired
    private RequestUtils requestUtils;

    @Autowired
    private SchemaUtils schemaUtils;

    @Autowired
    private UrlUtils urlUtils;

    public <T> ResponseObject<T> getResponseObject(ProjectType projectType, String jsonDataPath, String jsonDataName,
                                                   Headers headers, final Class<T> clazz, String endpoint,
                                                   Object... endpointParameters) {

        String url = urlUtils.buildUrl(projectType, endpoint, endpointParameters);

        ResponseObject<T> responseObject = requestUtils.getResponseObject(headers, clazz, url);
        schemaUtils.createJsonDataFile(responseObject, jsonDataPath, jsonDataName);

        return responseObject;
    }

    public <T> ResponseListData<T> getResponseListData(ProjectType projectType, String jsonDataPath, String jsonDataName,
                                                 Headers headers, final Class<T> clazz, String endpoint,
                                                 Object... endpointParameters) {

        String url = urlUtils.buildUrl(projectType, endpoint, endpointParameters);

        ResponseListData<T> responseObject = requestUtils.getResponseListData(headers, clazz, url);
        schemaUtils.createJsonDataFile(responseObject, jsonDataPath, jsonDataName);

        return responseObject;
    }

    public <T> ResponseObject<T> getStatus(ProjectType projectType, Headers headers, final Class<T> clazz,
                                           String endpoint, Object... endpointParameters) {

        String url = urlUtils.buildUrl(projectType, endpoint, endpointParameters);

        return requestUtils.getResponseObject(headers, clazz, url);
    }

    public <T> ResponseObject<T> postObject(ProjectType projectType, String jsonDataPath, String jsonDataName,
                       Headers headers, Object body, final Class<T> clazz, String endpoint,
                       Object... endpointParameters) {

        String url = urlUtils.buildUrl(projectType, endpoint, endpointParameters);

        ResponseObject<T> responseObject = requestUtils.postResponseObject(headers, body, clazz, url);
        schemaUtils.createJsonDataFile(responseObject.getData(), jsonDataPath, jsonDataName);

        return responseObject;
    }

    public boolean validateSchema(String jsonDataPath, String jsonDataName,
                                        String jsonSchemaPath, String jsonSchemaName) {

        return schemaUtils.schemaValidation(jsonDataPath, jsonDataName, jsonSchemaPath,
                jsonSchemaName);
    }
}
