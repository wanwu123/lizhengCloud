package com.example.demo.config;


import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Configuration
@EnableApolloConfig
public class ApolloCofig {

    //namespcese
    @ApolloConfig("application")
    private Config anotherConfig;

    @ApolloConfig("Test1.mysql")
    private Config test1;

    //监听器
    //config change listener for namespace application
    @ApolloConfigChangeListener("application")
    private void someOnChange(ConfigChangeEvent changeEvent) {
        boolean testKey = changeEvent.isChanged("testKey");
        if (testKey){
            System.out.println("更新key到redis");
        }

    }

    public String getConfig(String nameSpcae,String name){
        return anotherConfig.getProperty(nameSpcae,name);
    }

    public String getConfig2(String nameSpcae,String name){
        return test1.getProperty(nameSpcae,name);
    }

}
