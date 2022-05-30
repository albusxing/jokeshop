package com.albusxing.basis.zuul;

import lombok.Data;

@Data
public class GrayReleaseConfig {
	
	private int id;
	private String serviceId;
	private String path;
	private int enableGrayRelease;
	

	
}
