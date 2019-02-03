package com.ts.microservices.limitsservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ts.microservices.limitsservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
    @Autowired
    Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retreiveLimitsFromConfiguration(){
        return  new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());

    }

    @GetMapping("/fault-tollerant")
    @HystrixCommand(fallbackMethod = "faultTollerantLimits")
    public LimitConfiguration retreiveFaultTollerantLimitsFromConfiguration(){
        throw new RuntimeException("Not Available");

    }

    public LimitConfiguration faultTollerantLimits(){
        return  new LimitConfiguration(999,9);

    }
}
