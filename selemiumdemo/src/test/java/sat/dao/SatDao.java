package sat.dao;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sta")
@PropertySource(value = "application.yml")
public class SatDao {
    private String url;
    private String username;
    private String password;
}
