package br.com.bradesco.coredigital.api.automation.utils;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

@Component
public class JsonUtils {

    public String convertToJson(Object obj) {

        return toJson(obj, true);
    }

    public String convertToLineJson(Object obj) {

        return toJson(obj, false);
    }

    public <T> T convertToObject(String json, Class<T> clazz) {

        return new Gson().fromJson(json, clazz);
    }

    private String toJson(Object obj, boolean prettyPrint) {

        Gson gson;

        if (prettyPrint) {

            gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .serializeNulls()
                    .create();
        } else {

            gson = new GsonBuilder()
                    .serializeNulls()
                    .create();
        }

        return gson.toJson(obj);
    }
}
