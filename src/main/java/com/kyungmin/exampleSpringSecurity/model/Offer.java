package com.kyungmin.exampleSpringSecurity.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Offer {

	private int id;
	
	@Size(min=2, max=100, message="Name은 최소 2글자, 최대 100글자 입니다.")
	private String name;
	
	@Email(message="Email 형식을 지켜야 합니다.")
	@NotEmpty(message="Email은 반드시 입력해야 합니다.")
	private String email;
	
	@Size(min=5, max=100, message="Offer는 최소 5글자, 최대 100글자 입니다.")
	private String text;
	
}
