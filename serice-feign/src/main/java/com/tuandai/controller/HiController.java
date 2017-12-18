package com.tuandai.controller;

import com.tuandai.client.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenjianshuo on 2017/10/21 17:05.
 */
@RestController
public class HiController {
    @Autowired
    client client1;
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return client1.sayHiFromClientOne(name);
    }
}
