package env;

import org.aeonbits.owner.ConfigFactory;

public class Configuration {
    public static WhiskConfig getWhiskConfig() {
        return ConfigFactory.newInstance().create(WhiskConfig.class);
    }
}
