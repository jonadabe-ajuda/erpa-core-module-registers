package br.com.erpa.application.command;

import java.util.ArrayList;
import java.util.List;

import br.com.erpa.application.dto.ProductsDTO;
import br.com.erpa.domain.repository.RepositoryProducts;


/**
 * Recover list products
 *  
 * @author jonadabe
 * @param  methods Constructor RepositoryProducts
 * @return List<ProductsDTO>
 */
public class RecoverProductsAll {
	
	private final RepositoryProducts repositoryProducts;

	public RecoverProductsAll(RepositoryProducts repositoryProducts) {
		this.repositoryProducts = repositoryProducts;
	}
	
	public List<ProductsDTO> execute () {
	
		List<ProductsDTO> listaProductsDTO = new ArrayList<ProductsDTO>();
		repositoryProducts.listaAllProducts().forEach( product -> {
			ProductsDTO productDTO = new ProductsDTO(product.getCodigo(), 
					 product.getName(),
					 product.getIsActive(),
					 product.getValueSale());
			listaProductsDTO.add(productDTO);
			
		});


		return listaProductsDTO;
	}	
		

}
