package br.com.erpa;

import br.com.erpa.application.BuilderCustomers;
import br.com.erpa.application.dto.CustomerDTO;
import br.com.erpa.domain.entity.CustomersEntity;
import br.com.erpa.domain.vo.Address;

public class MocksPopuled {
	
	
	public static CustomersEntity MockCustomerEntity() {
		CustomersEntity customerEntity = new BuilderCustomers()
										.withCPFName("12345678901", "Nome da Silva")
										.addressComplete("Rua dos Teste", 100,
														 "Bairro Teste", 
														 "Cidade Teste", 
														 "Estado Teste",
														 "09600100")
										.create();
		return customerEntity;
	}
	
	public static Address MockAddressVo() {
		Address addressVO = new Address("Rua dos Teste", 100, 
										 "Bairro Teste", 
										 "Cidade Teste", 
										 "Estado Teste",
										 "09600100");
		return addressVO;
	}
	
	public static Address MockAddressVoNull() {
		Address addressVO = new Address(null, 100, 
										 "Bairro Teste", 
										 "Cidade Teste", 
										 null,
										 "09600100");
		return addressVO;
	}	
	
	public static Address MockAddressVoEmpty() {
		Address addressVO = new Address("", 100, 
										 "Bairro Teste", 
										 "Cidade Teste", 
										 "",
										 "09600100");
		return addressVO;
	}
	
	public static CustomerDTO MockCustomerDTO() {
		CustomerDTO customerDTO = new CustomerDTO("Nome Teste", "12345678901", 
												  "Rua dos Tests",
												  100,
												  "Bairro Teste",
												  "Cidade Teste",
												  "Estado Teste",
												  "01000001");
		return customerDTO;
	}	
	

}
