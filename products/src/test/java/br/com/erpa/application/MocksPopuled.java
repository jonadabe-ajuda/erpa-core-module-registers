package br.com.erpa.application;

import java.math.BigDecimal;

import br.com.erpa.application.dto.ProductsDTO;

public class MocksPopuled {
	
	
	public static ProductsDTO MockProductDTO() {
		ProductsDTO productsDTO = new ProductsDTO("SD-0001", 
												  "SD SAMSUNG 500G", 
												  1, 
												  new BigDecimal(350.00));
		return productsDTO;
	}	
	

}
