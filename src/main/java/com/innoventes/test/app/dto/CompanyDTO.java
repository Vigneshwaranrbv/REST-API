package com.innoventes.test.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CompanyDTO {

	private Long id;

	@NotBlank(message = "company name is mandatory")
	@Size(min = 5, message = "company name must be at least 5 characters")
	private String companyName;

	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be valid")
	private String email;

	@PositiveOrZero(message = "strength must be zero or positive number")
	private Integer strength;


	private String webSiteURL;

	@Column( unique = true)
	@Pattern(regexp = "^[A-Za-z]{2}\\d{2}[ENen]{1}$",message = "Value must be 5 characters: 2 letters, 2 digits, followed by 'E' or 'N'")
	private String companyCode;
}
