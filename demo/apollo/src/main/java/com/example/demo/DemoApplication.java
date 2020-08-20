package com.example.demo;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApolloConfig
public class DemoApplication {

    public static void main(String[] args) {
       /* Config config = ConfigService.getAppConfig(); //config instance is singleton for each namespace and is never null
        String someKey = "someKeyFromDefaultNamespace";
        String someDefaultValue = "someDefaultValueForTheKey";
        String value = config.getProperty(someKey, someDefaultValue);*/
        SpringApplication.run(DemoApplication.class, args);
    }


}
