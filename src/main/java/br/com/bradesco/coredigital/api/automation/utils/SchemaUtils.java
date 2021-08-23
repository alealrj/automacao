package br.com.bradesco.coredigital.api.automation.utils;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class SchemaUtils {

    final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .create();

    private final String FILE_EXTENSION = "json";

    public void createJsonDataFile(Object obj, String rootJsonDataPath, String jsonDataName) {

        try {

            createDirectoryIfNotExists(rootJsonDataPath);
            Path path = Paths.get(rootJsonDataPath
                    .concat(jsonDataName)
                    .concat(".")
                    .concat(FILE_EXTENSION));

            log.info("Criando o Json: {}", path.getFileName());
            String json = gson.toJson(obj);
            log.info(json);
            Files.write(path, json.getBytes());

        } catch (IOException e) {

            log.error("Erro ao criar Json");
            throw new RuntimeException(e);
        }
    }

    public boolean schemaValidation(String rootJsonDataPath, String rootJsonDataName,
                                    String rootJsonSchemaPath, String jsonSchemaName) {

        String jsonName = rootJsonDataName.concat(".").concat(FILE_EXTENSION);

        File jsonDataFile = FileUtils.getFile(rootJsonDataPath, jsonName);
        compareSchema(jsonDataFile, rootJsonSchemaPath, jsonSchemaName);

        return true;
    }

    private void compareSchema(File jsonDataFile, String rootJsonSchema, String jsonSchemaName) {

        try {

            File schemaFile = new File(
                    rootJsonSchema.concat(jsonSchemaName).concat(".").concat(FILE_EXTENSION));

            JSONTokener schemaData = new JSONTokener(new FileInputStream(schemaFile));
            JSONObject jsonSchema = new JSONObject(schemaData);

            JSONTokener jsonData = new JSONTokener(new FileInputStream(jsonDataFile));
            JSONObject jsonObject = new JSONObject(jsonData);

            log.info("Validando Json: {} com o Schema: {}", jsonDataFile.getName(), schemaFile.getName());
            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonObject);

        } catch (FileNotFoundException e) {

            log.error("Erro ao procurar arquivo");
            throw new RuntimeException(e);
        } catch (ValidationException e) {

            List<String> list = e.getCausingExceptions().stream()
                    .map(ValidationException::getMessage)
                    .collect(Collectors.toList());

            if (list.isEmpty()) {

                log.error(e.getMessage());
                throw new RuntimeException(e);
            } else {

                log.error(list.toString());
                throw new RuntimeException(list.toString());
            }
        }
    }

    private void createDirectoryIfNotExists(final String directoryName) {

        try {

            File directory = new File(directoryName);
            if (!directory.exists()) {
                log.info("Diretorio inexistente: {}", directoryName);
                log.info("Criando diretorio: {}", directoryName);
                directory.mkdirs();
            }
        } catch (Exception e) {

            log.error("Erro ao criar diretorio: {}", directoryName);
            throw new RuntimeException(e);
        }
    }
}