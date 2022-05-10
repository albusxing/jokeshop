package com.albusxing.msa.showcase.web.vm;

import lombok.Builder;
import lombok.Data;
import org.springframework.cloud.client.ServiceInstance;

import java.io.Serializable;
import java.util.List;

/**
 * @author Albusxing
 * @created 2022/2/26
 */
@Data
@Builder
public class ServiceResp implements Serializable {

	private String description;
	private List<ServiceInstance> serviceInstances;

}
