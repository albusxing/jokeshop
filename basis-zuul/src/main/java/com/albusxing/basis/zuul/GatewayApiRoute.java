package com.albusxing.basis.zuul;

import lombok.Data;

@Data
public class GatewayApiRoute {
 
	private String id;
	private String path;
	private String serviceId;
	private String url;
	private boolean stripPrefix = true;
	private Boolean retryable;
	private Boolean enabled;
	

}