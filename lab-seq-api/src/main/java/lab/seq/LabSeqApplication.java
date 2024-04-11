package lab.seq;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"lab"})
@EntityScan(basePackages = {"lab"})
@OpenAPIDefinition
@EnableCaching
public class LabSeqApplication {

    public static void main(String[] args) {

        SpringApplication.run(LabSeqApplication.class, args);
    }


}