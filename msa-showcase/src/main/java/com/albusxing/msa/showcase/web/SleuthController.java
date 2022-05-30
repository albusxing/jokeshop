package com.albusxing.msa.showcase.web;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Albusxing
 * @created 2022/3/17
 */
@Api(tags = "Sleuth")
@Slf4j
@RestController
@RequestMapping("/sleuth")
public class SleuthController {
}
