package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@Size(min = 3, max = 15, message = "The first name should be min 3 and max of 15 characters.")
	private String firstName;
	
	@Size(min = 1, max = 15, message = "The last name should be min 1 and max of 15 characters.")
	private String lastName;
	
	@Size(min = 10, max = 10, message = "Mobile Number should contain 10 digit only")
	private String mobileNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_address",joinColumns = @JoinColumn(name="customer_id",referencedColumnName = "customerId"))
	private Address address;
	
	@Email(message = "Please enter valid email address")
	private String email;
	
	@NotNull(message ="username should not be null")
	@Size(min =3,max=15,message="length of username must be between 3 & 15")
	private String username;

	@NotNull(message ="user password should not be null")
	@Size(min =3,max=10,message="length of username must be between 3 & 10")
	private String password;
	

	

	
	

}
