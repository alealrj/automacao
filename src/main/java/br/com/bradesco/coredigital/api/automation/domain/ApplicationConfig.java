package br.com.bradesco.coredigital.api.automation.domain;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

@Configuration
@Slf4j
public class ApplicationConfig {

    @Bean
    public void deleteJsonDataFiles() {

        final String ROOT_JSON_DATA = "src/main/resources/json_data/";

        deleteDirectory(ROOT_JSON_DATA);
    }

    @Bean
    public void deleteLogFiles() {

        final String TARGET_LOGS = "target/logs/";

        deleteDirectoryFiles(TARGET_LOGS);
    }

    private void deleteDirectory(String path) {

        try {

            log.info("Excluindo arquivos do diretório: {}", path);
            File folder = new File(path);


            if (folder.exists() && folder.isDirectory()) {

                FileUtils.deleteDirectory(folder);
            }
        } catch (IOException e) {

            log.info("Erro ao excluir diretorio: {}", path);
            throw new RuntimeException(e);
        }
    }

    private void deleteDirectoryFiles(String path) {

        log.info("Excluindo arquivos do diretório: {}", path);
        File folder = new File(path);

        if(folder.isDirectory()) {

            File[] sun = folder.listFiles();
            for (File toDelete : sun) {
                toDelete.delete();
            }
        }
    }
}
