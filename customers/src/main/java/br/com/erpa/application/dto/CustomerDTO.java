package br.com.erpa.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Data Acess Object customers
 *  
 * @author jonadabe
 * @param  methods Constructor all attribute
 */
public class CustomerDTO {
	

	@NotNull
	@NotEmpty
	@Size(min = 5,max = 100,message = "CustomerDTO field name between 5 and 100")
	private String name;
	
	@NotNull
	@NotEmpty
	@Size(min = 11,max = 11,message = "CustomerDTO field number equal 11")
	private String cpf;
	
	@NotNull
	@NotEmpty
	@Size(min = 5,max = 100,message = "CustomerDTO field street between 5 and 100")	
	private String street;
	
	@NotNull
	private Integer number;
	
	@NotNull
	@NotEmpty
	@Size(min = 5,max = 100,message = "CustomerDTO field district between 5 and 100")	
	private String district;
	
	@NotNull
	@NotEmpty
	@Size(min = 5,max = 100,message = "CustomerDTO field city between 5 and 100")	
	private String city;
	
	@NotNull
	@NotEmpty
	@Size(min = 5,max = 100,message = "CustomerDTO field state between 5 and 100")
	private String state;
	
	@NotNull
	@NotEmpty
	@Size(min = 8,max = 8,message = "CustomerDTO field zipCode equal 8")		
	private String zipCode;
	
	public CustomerDTO() {}

	public CustomerDTO(
			@NotNull @NotEmpty @Size(min = 5, max = 100, message = "CustomerDTO field name between 5 and 100") String name,
			@NotNull @NotEmpty @Size(min = 11, max = 11, message = "CustomerDTO field number equal 11") String cpf,
			@NotNull @NotEmpty @Size(min = 5, max = 100, message = "CustomerDTO field street between 5 and 100") String street,
			@NotNull Integer number,
			@NotNull @NotEmpty @Size(min = 5, max = 100, message = "CustomerDTO field district between 5 and 100") String district,
			@NotNull @NotEmpty @Size(min = 5, max = 100, message = "CustomerDTO field city between 5 and 100") String city,
			@NotNull @NotEmpty @Size(min = 5, max = 100, message = "CustomerDTO field state between 5 and 100") String state,
			@NotNull @NotEmpty @Size(min = 8, max = 8, message = "CustomerDTO field zipCode equal 8") String zipCode) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.street = street;
		this.number = number;
		this.district = district;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}	

}
