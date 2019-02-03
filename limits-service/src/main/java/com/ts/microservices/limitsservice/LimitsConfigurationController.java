package com.ts.microservices.limitsservice;

import com.ts.microservices.limitsservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
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
}
