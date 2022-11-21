package com.userinfo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class UserInfoVO {
	@JsonProperty(value="id")
	private String id;
	   
	@JsonProperty(value="name")
	private String name;
	   
	@JsonProperty(value="age")
	private int age;

}
