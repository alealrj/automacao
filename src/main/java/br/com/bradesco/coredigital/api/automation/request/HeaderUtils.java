package br.com.bradesco.coredigital.api.automation.request;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class HeaderUtils {

    public Headers getHeader() {

        return new Headers(getAuthorization());
    }

    public Headers getHeader(Header... headers) {

        return new Headers(headers);
    }

    private Header getAuthorization() {

        return new Header("Authorization", "test");
    }
}
