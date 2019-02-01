package com.ts.microservices.limitsservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class LimitConfiguration {
    private int maximum;
    private int minimum;
}
