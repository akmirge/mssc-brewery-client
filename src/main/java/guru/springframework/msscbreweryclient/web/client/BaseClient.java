package guru.springframework.msscbreweryclient.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

@ConfigurationProperties(value="sfg.brewery", ignoreUnknownFields = false)
public class BaseClient {
    protected String apihost;

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
