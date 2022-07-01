package com.albusxing.msa.order.web.showcase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Albusxing
 * @created 2022/6/10
 */
@Slf4j
@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Resource
    private Environment env;

    @GetMapping(value = "/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) throws UnknownHostException {
        log.info("hello，" + name);
        String port = env.getProperty("server.port");
        String myHostName = InetAddress.getLocalHost().getHostName();
        return "hello, this is [" + myHostName + ":" + port + "]";
    }
}
