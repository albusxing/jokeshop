package com.albusxing.msa.account.web;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Albusxing
 * @created 2022/3/12
 */
@Api(tags = "用户演示案例")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/acount-case")
public class AccountCaseController {


	@GetMapping("/msg")
	public String getMsg() {
		return "Hello，This is msa-account";
	}

}
