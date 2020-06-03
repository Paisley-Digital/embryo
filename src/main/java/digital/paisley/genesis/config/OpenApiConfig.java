package digital.paisley.genesis.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition()
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String apiVersion) {
        return new OpenAPI()
                .addServersItem(new Server()
                        .description("DEV Server")
                        .url("https://api-dev.covidmonitor.tech"))
                .components(new Components())
                .info(new io.swagger.v3.oas.models.info.Info()
                        .description("Covid Notifier RESTful service using springdoc-openapi and OpenAPI 3")
                        .title("Covid Notifier Application API")
                        .version(apiVersion));
    }
}
