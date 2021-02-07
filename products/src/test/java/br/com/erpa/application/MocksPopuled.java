package br.com.erpa.application;

import java.math.BigDecimal;

import br.com.erpa.application.dto.ProductsDTO;

public class MocksPopuled {
		
	public static ProductsDTO MockProductDTO() {
		ProductsDTO productsDTO = new ProductsDTO("SD-001", 
												  "SD SAMSUNG 500GB",
												  1,
												  new BigDecimal(250.00));

		return productsDTO;
	}	
	

}
