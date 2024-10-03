package com.enesbayram.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoPersonel {

	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private DtoDepartment department;
}
