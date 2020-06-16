package digital.paisley.embryo.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Data
@ConfigurationProperties(prefix = "embryo-config")
@Slf4j
public class ConfigMaps {

    private String message;
    private String clientUrl;

    @PostConstruct
    private void checkProps() {
        log.info("message is: \n\n{}", message);
        log.info("client url is: \n\n{}", clientUrl);
    }
}
