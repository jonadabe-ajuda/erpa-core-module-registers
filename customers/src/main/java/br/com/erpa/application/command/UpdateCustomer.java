package br.com.erpa.application.command;

import br.com.erpa.application.builderCustomers;
import br.com.erpa.application.dto.CustomerDTO;
import br.com.erpa.domain.entity.CustomersEntity;
import br.com.erpa.domain.repository.RepositoryCustomer;

/**
 * Update customers
 *  
 * @author jonadabe
 * @param  methods Constructor RepositoryCustomer
 * @param  methods execute CustomerDTO
 * @return CustomerDTO
 */
public class UpdateCustomer {
	
	private final RepositoryCustomer repositoryCustomer;

	public UpdateCustomer(RepositoryCustomer repositoryCustomer) {
		this.repositoryCustomer = repositoryCustomer;
	}
	
	public void execute ( CustomerDTO customerDTO ) {
		CustomersEntity customersEntity = new builderCustomers()
										   .withCPFName(customerDTO.getCpf(), customerDTO.getName())
										   .addressComplete(customerDTO.getStreet(), 
												   			customerDTO.getNumber(), 
												   			customerDTO.getDistrict(),
												   			customerDTO.getCity(),
												   			customerDTO.getState(),
												   			customerDTO.getZipCode())
										   .create();
		
		repositoryCustomer.updateCustomer(customersEntity);
		
	}	

}
