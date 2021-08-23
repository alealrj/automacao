package br.com.bradesco.coredigital.api.automation.service;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.springframework.stereotype.Service;

@Service
public class CwsTokenService extends AbstractService {

    private final String URL_CWS_AUTENTICACAO = "/gseg-srv-login-confianca/api/login/{0}/{1}/{2}";

    public Headers getCwsHeadersAutenticacao(String agency, String account, String accountType) {


        return requestUtils.getHeadersResponse(
                headerUtils.getHeader(
                        new Header("x-login-canal", gsegPropertiesTst.getGsegXlogincanal()),
                        new Header("x-login-empresa", gsegPropertiesTst.getGsegXloginempresa()),
                        new Header("x-login-idioma", gsegPropertiesTst.getGsegXloginidioma()),
                        new Header("x-login-periferico", gsegPropertiesTst.getGsegXloginperiferico()),
                        new Header("x-login-dependencia", gsegPropertiesTst.getGsegXloginindependencia())),
                URL_CWS_AUTENTICACAO, agency, account, accountType);
    }
}
