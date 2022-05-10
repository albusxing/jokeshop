package com.albusxing.msa.showcase.web.vm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Albusxing
 * @created 2022/3/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

	private Long id;
	private String name;
	private Integer age;
}
