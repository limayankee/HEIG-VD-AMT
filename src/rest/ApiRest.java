package rest;

import javax.ejb.Stateless;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.Map;

/**
 * Main class of the REST API
 * @author Julien Leroy & Loic Serafin
 */
@Stateless
@ApplicationPath("/api")
public class ApiRest extends Application {
    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("jersey.config.disable.MoxyJson", true);
        return properties;
    }

}
