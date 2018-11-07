package com.da2win.springbootlesson18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@ImportResource(locations = {
        "classpath:META-INF/spring/context.xml",
        "classpath:META-INF/spring/context-test.xml",
        "classpath:META-INF/spring/context-prod.xml"
})
public class SpringBootLesson18Application implements EnvironmentAware {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringBootLesson18Application.class);
        application.setAdditionalProfiles("prod");
        application.run(args);
    }

    @Override
    public void setEnvironment(Environment environment) {
        // get current Profiles
        System.err.println("当前激活的Profiles : " + Arrays.asList(environment.getActiveProfiles()));

        if (environment instanceof ConfigurableEnvironment) {
            ConfigurableEnvironment env = ConfigurableEnvironment.class.cast(environment);

            MutablePropertySources propertySources = env.getPropertySources();

            Map<String, Object> source = new HashMap<>();

            source.put("server.port", "1234");

            PropertySource propertySource = new MapPropertySource("java-code", source);
            propertySources.addFirst(propertySource);
        }
    }
}
