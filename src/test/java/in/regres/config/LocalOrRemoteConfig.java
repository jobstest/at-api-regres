package in.regres.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${localOrRemote}.properties")
public interface LocalOrRemoteConfig extends Config {
    @Key("baseUri")
    @DefaultValue("https://reqres.in")
    String baseUri();

    @Key("basePath")
    @DefaultValue("/api")
    String basePath();

    @Key("remote")
    String remote();
}
