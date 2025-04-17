package com.innoventes.test.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "company")
@Entity
public class Company extends BaseEntity {

	@Id
	@SequenceGenerator(sequenceName = "company_seq", allocationSize = 1, name = "company_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
	private Long id;

	@Column(name = "company_name")
	@NotBlank(message = "company name is mandatory")
	@Size(min = 5, message = "company name must be at least 5 characters")
	private String companyName;

	@Column(name = "email")
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be valid")
	private String email;
	
	@Column(name = "strength")
	@PositiveOrZero(message = "strength must be zero or positive number")
	private Integer strength;
	
	@Column(name = "website_url")
	private String webSiteURL;

	@Column(name = "company_code", unique = true)
	@Pattern(regexp = "^[A-Za-z]{2}\\d{2}[ENen]{1}$",message = "Value must be 5 characters: 2 letters, 2 digits, followed by 'E' or 'N'")
	private String companyCode;
}
