package br.com.erpa.application.command;

import java.util.ArrayList;
import java.util.List;

import br.com.erpa.application.dto.CustomerDTO;
import br.com.erpa.domain.repository.RepositoryCustomer;


/**
 * Recover list customers
 *  
 * @author jonadabe
 * @param  methods Constructor RepositoryCustomer
 * @return List<CustomerDTO>
 */
public class RecoverCustomerAll {
	
	private final RepositoryCustomer repositoryCustomer;

	public RecoverCustomerAll(RepositoryCustomer repositoryCustomer) {
		this.repositoryCustomer = repositoryCustomer;
	}
	
	public List<CustomerDTO> execute () {
	
		List<CustomerDTO> listaConsumerDTO = new ArrayList<CustomerDTO>();
		repositoryCustomer.listaAllCustomers().forEach( customer -> {
			CustomerDTO customerDTO = new CustomerDTO(customer.getName(), 
					 customer.getCpf().getNumber(),
					 customer.getAddress().getStreet(),
					 customer.getAddress().getNumber(), 
					 customer.getAddress().getDistrict(),
					 customer.getAddress().getCity(), 
					 customer.getAddress().getState(),
					 customer.getAddress().getZipCode());
			listaConsumerDTO.add(customerDTO);
			
		});


		return listaConsumerDTO;
	}	
		

}
