package com.albusxing.msa.showcase;

import com.albusxing.msa.common.base.BaseResult;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Albusxing
 * @created 2022/3/15
 */
@Component
public class UrlBlockHandler implements BlockExceptionHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
		String msg = null;
		if (e instanceof FlowException) {
			msg = "接口已被限流";
		} else if (e instanceof DegradeException) {
			msg = "接口已被熔断,请稍后再试";
		} else if (e instanceof ParamFlowException) {
			msg = "热点参数限流";
		} else if (e instanceof SystemBlockException) {
			msg = "系统规则(负载/....不满足要求)";
		} else if (e instanceof AuthorityException) {
			msg = "授权规则不通过";
		}
		response.setStatus(500);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.writeValue(response.getWriter(), BaseResult.error(msg));
	}

}
