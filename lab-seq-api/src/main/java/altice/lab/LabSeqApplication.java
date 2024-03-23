package altice.lab;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"altice.lab"})
@EntityScan(basePackages = {"altice.lab"})
@OpenAPIDefinition
@EnableCaching
public class LabSeqApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabSeqApplication.class, args);
    }


}