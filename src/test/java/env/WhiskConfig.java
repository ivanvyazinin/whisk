package env;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:whisk.properties"})
public interface WhiskConfig extends Config{
    @Key("api.host")
    String getHost();

    @Key("token")
    String getToken();

    @Key("front")
    String getFrontUrl();
}