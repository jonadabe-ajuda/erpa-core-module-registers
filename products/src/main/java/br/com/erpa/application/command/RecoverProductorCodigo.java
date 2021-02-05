package br.com.erpa.application.command;

import br.com.erpa.application.dto.ProductsDTO;
import br.com.erpa.domain.entity.ProductsEntity;
import br.com.erpa.domain.repository.RepositoryProducts;

/**
 * Recover products
 *  
 * @author jonadabe
 * @param  methods Constructor RepositoryProducts
 * @param  methods execute cpf
 * @return ProductsDTO
 */
public class RecoverProductorCodigo {
	
	private final RepositoryProducts repositoryProducts;

	public RecoverProductorCodigo(RepositoryProducts repositoryProducts) {
		this.repositoryProducts = repositoryProducts;
	}
	
	public ProductsDTO execute ( String codigo ) {
		
		ProductsEntity  product = repositoryProducts.findByCodigo(codigo);
		
		if ( product != null ) {
			ProductsDTO productsDTO = new ProductsDTO(product.getCodigo(),
													 product.getName(),
													 product.getIsActive(),
													 product.getValueSale());
			return productsDTO;
		} else {
			return new ProductsDTO();
		}
		 
	}	
		

}
