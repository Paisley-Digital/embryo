package digital.paisley.genesis.clients;

import digital.paisley.genesis.config.ConfigMaps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DummyClient {

    private final String dummyURL;

    private static Logger log = LoggerFactory.getLogger(DummyClient.class);

    public DummyClient(ConfigMaps configMaps) {
        this.dummyURL = configMaps.getClientUrl();
    }

    public String getById(Long id) {
        //TODO: RestTemplate request example
        log.info(dummyURL);
        log.info("getByDummy");

        return "Client Test";
    }
}
