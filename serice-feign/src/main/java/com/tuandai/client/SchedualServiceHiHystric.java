package com.tuandai.client;

import org.springframework.stereotype.Component;

/**
 * Created by chenjianshuo on 2017/10/21 17:41.
 */
@Component
public class SchedualServiceHiHystric implements client{
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
