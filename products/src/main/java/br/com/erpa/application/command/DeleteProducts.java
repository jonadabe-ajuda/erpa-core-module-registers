package br.com.erpa.application.command;

import br.com.erpa.application.dto.ProductsDTO;
import br.com.erpa.domain.entity.ProductsEntity;
import br.com.erpa.domain.repository.RepositoryProducts;

/**
 * Delete products
 *  
 * @author jonadabe
 * @param  methods Constructor RepositoryProducts
 * @param  methods execute ProductsDTO
 */
public class DeleteProducts {
	
	private final RepositoryProducts repositoryProducts;

	public DeleteProducts(RepositoryProducts repositoryProducts) {
		this.repositoryProducts = repositoryProducts;
	}
	
	public void execute ( ProductsDTO productorDTO ) {
		ProductsEntity productsEntity = new ProductsEntity(productorDTO.getCodigo(), productorDTO.getName(),
														   productorDTO.getIsActive(), productorDTO.getValueSale());
		repositoryProducts.deleteProducts(productsEntity);
	}

}