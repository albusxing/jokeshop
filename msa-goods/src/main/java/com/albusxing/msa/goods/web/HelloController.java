package com.albusxing.msa.goods.web;

import org.springframework.web.bind.annotation.*;

/**
 * @author Albusxing
 * @created 2022/5/30
 */
@RestController
public class HelloController {

    @GetMapping(value = "/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return "goods hello" + name;
    }
}
