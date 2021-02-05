package br.com.erpa.application.command;

import br.com.erpa.application.BuilderProducts;
import br.com.erpa.application.dto.ProductsDTO;
import br.com.erpa.domain.entity.ProductsEntity;
import br.com.erpa.domain.repository.RepositoryProducts;

/**
 * Update products
 *  
 * @author jonadabe
 * @param  methods Constructor RepositoryProducts
 * @param  methods execute CustomerDTO
 * @return ProductsDTO
 */
public class UpdateProducts {
	
	private final RepositoryProducts repositoryProducts;

	public UpdateProducts(RepositoryProducts repositoryProducts) {
		this.repositoryProducts = repositoryProducts;
	}
	
	public void execute ( ProductsDTO productsDTO ) {
		ProductsEntity productsEntity = new BuilderProducts()
										   .withProduct(productsDTO.getCodigo(), 
													   productsDTO.getName(),
													   productsDTO.getIsActive(),
													   productsDTO.getValueSale())
										   .create();
		
		repositoryProducts.updateProducts(productsEntity);
		
	}	

}
