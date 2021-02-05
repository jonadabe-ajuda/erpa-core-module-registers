package br.com.erpa.application.command;

import br.com.erpa.application.dto.CustomerDTO;
import br.com.erpa.domain.entity.CustomersEntity;
import br.com.erpa.domain.repository.RepositoryCustomer;
import br.com.erpa.domain.vo.CPF;

/**
 * Update customers
 *  
 * @author jonadabe
 * @param  methods Constructor RepositoryCustomer
 * @param  methods execute CustomerDTO
 * @return CustomerDTO
 */
public class DeleteCustomer {
	
	private final RepositoryCustomer repositoryCustomer;

	public DeleteCustomer(RepositoryCustomer repositoryCustomer) {
		this.repositoryCustomer = repositoryCustomer;
	}
	
	public void execute ( CustomerDTO customerDTO ) {
		CustomersEntity customersEntity = new CustomersEntity(new CPF(customerDTO.getCpf()), null);
		repositoryCustomer.deleteCustomer(customersEntity);
	}

}