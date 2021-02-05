package br.com.erpa.application;

import br.com.erpa.domain.entity.CustomersEntity;
import br.com.erpa.domain.vo.CPF;

/**
 * Build to create customerEntity.
 *  
 * @author jonadabe
 * @param  methods withCPFName String cpf and String name
 * @param  methods addressComplete String street, int number, String district, String city, String state, String zipCodee
 * @return CustomerEntity
 */
public class builderCustomers {
	
	private CustomersEntity customersEntity;
	
	public builderCustomers withCPFName(String cpf, String name) {
		this.customersEntity = new CustomersEntity(new CPF(cpf), name);
		return this;
	}
	
	public builderCustomers addressComplete(String street, int number, String district, String city, String state, String zipCode) {
		this.customersEntity.addAddress(street, number, district, city, state, zipCode);
		return this;
	}
	
	public CustomersEntity create () {
		return this.customersEntity;
	}	

}
