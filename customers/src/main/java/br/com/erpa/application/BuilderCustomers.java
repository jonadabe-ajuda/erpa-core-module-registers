package br.com.erpa.application;

import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import br.com.erpa.domain.entity.CustomersEntity;
import br.com.erpa.domain.vo.CPF;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

/**
 * Build to create customerEntity.
 *  
 * @author jonadabe
 * @param  methods withCPFName String cpf and String name
 * @param  methods addressComplete String street, int number, String district, String city, String state, String zipCodee
 * @return CustomerEntity
 */
public class BuilderCustomers {
	
	
	private CustomersEntity customersEntity;
	
	public BuilderCustomers withCPFName(String cpf, String name) {
		this.customersEntity = new CustomersEntity(new CPF(cpf), name);
		return this;
	}
	
	public BuilderCustomers addressComplete(String street, int number, String district, String city, String state, String zipCode) {
		this.customersEntity.addAddress(street, number, district, city, state, zipCode);
		return this;
	}
	
	public CustomersEntity create () {
		
		return this.customersEntity;
	}	


}
