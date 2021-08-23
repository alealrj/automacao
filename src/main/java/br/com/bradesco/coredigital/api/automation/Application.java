package br.com.bradesco.coredigital.api.automation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.bradesco")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
