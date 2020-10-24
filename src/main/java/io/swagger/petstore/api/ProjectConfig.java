package io.swagger.petstore.api;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface ProjectConfig extends Config {
    // if no key and value in 'config.property' file '@DefaultValue("{value}")' value will be used by default
    @DefaultValue("production") String environment();
    @Key("${environment}.baseUrl") String baseUrl();
    @DefaultValue("false") boolean isRequestAndResponseLoggingEnable();
    @DefaultValue("zh-CN") String locale();
}