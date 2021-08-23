package br.com.bradesco.coredigital.api.automation.service;

import br.com.bradesco.coredigital.api.automation.properties.GsegPropertiesTst;
import br.com.bradesco.coredigital.api.automation.request.HeaderUtils;
import br.com.bradesco.coredigital.api.automation.request.RequestUtils;
import br.com.bradesco.coredigital.api.automation.utils.JsonUtils;
import br.com.bradesco.coredigital.api.automation.utils.SchemaUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public abstract class AbstractService {

    @Autowired
    protected RequestUtils requestUtils;

    @Autowired
    protected HeaderUtils headerUtils;

    @Autowired
    protected SchemaUtils schemaUtils;

    @Autowired
    protected GsegPropertiesTst gsegPropertiesTst;

    @Autowired
    protected JsonUtils jsonUtils;
}
