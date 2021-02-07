package br.com.erpa.application.command;

import br.com.erpa.application.BuilderProducts;
import br.com.erpa.application.dto.ProductsDTO;
import br.com.erpa.domain.entity.ProductsEntity;
import br.com.erpa.domain.exception.ExceptionValidFields;
import br.com.erpa.domain.repository.RepositoryProducts;
import br.com.erpa.validator.ValidatorBean;

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
		if ( !ValidatorBean.Validator().validate(productsDTO).isEmpty() ) throw new ExceptionValidFields("Error valid fields",null);
		ProductsEntity productorsEntity = new BuilderProducts()
											.withProduct(productsDTO.getCodigo(), 
														 productsDTO.getName(),
														 productsDTO.getIsActive(),
														 productsDTO.getValueSale())
											.create();
		
		repositoryProducts.insertProducts(productorsEntity);
		
	}

}
