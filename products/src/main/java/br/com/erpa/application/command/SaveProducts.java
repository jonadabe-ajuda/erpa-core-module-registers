package br.com.erpa.application.command;

import br.com.erpa.application.BuilderProducts;
import br.com.erpa.application.dto.ProductsDTO;
import br.com.erpa.domain.entity.ProductsEntity;
import br.com.erpa.domain.repository.RepositoryProducts;

/**
 * Save Products
 *  
 * @author jonadabe
 * @param  methods Constructor RepositoryProducts
 * @param  methods execute ProductorsDTO
 * @return ProductsDTO
 */
public class SaveProducts {
	
	private final RepositoryProducts repositoryProducts;

	public SaveProducts(RepositoryProducts repositoryProducts) {
		this.repositoryProducts = repositoryProducts;
	}
	
	public void execute ( ProductsDTO productsDTO ) {
		ProductsEntity productorsEntity = new BuilderProducts()
											.withProduct(productsDTO.getCodigo(), 
														 productsDTO.getName(),
														 productsDTO.getIsActive(),
														 productsDTO.getValueSale())
											.create();
		
		repositoryProducts.insertProducts(productorsEntity);
		
	}

}
