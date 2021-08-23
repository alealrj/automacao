package br.com.bradesco.coredigital.api.automation.test.steps;

import br.com.bradesco.coredigital.api.automation.request.HeaderUtils;
import br.com.bradesco.coredigital.api.automation.utils.JsonUtils;
import com.bradesco.core.exception.BradescoException;
import com.bradesco.core.report.BradescoReporter;
import com.bradesco.core.report.model.HttpRequestEvent;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
public abstract class AbstractStepDefinition {

    @Autowired
    protected HeaderUtils headerUtils;

    @Autowired
    protected JsonUtils jsonUtils;

    protected void printJsonBradescoReport(Object obj) {

        try {

            log.info(jsonUtils.convertToJson(obj));
            BradescoReporter.reportEvent(HttpRequestEvent.getRequest("", jsonUtils.convertToJson(obj)));
        } catch (Throwable e) {

            e.printStackTrace();
        }
    }

    protected Headers getHeaders(Map<String, String> headerMap) {

        return new Headers(
                headerMap.entrySet().stream()
                        .map(entry -> new Header(entry.getKey(), entry.getValue()))
                        .collect(Collectors.toList())
        );
    }
}
