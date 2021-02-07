package br.com.erpa.application;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.erpa.application.command.SaveProducts;
import br.com.erpa.application.dto.ProductsDTO;
import br.com.erpa.domain.exception.ExceptionValidFields;
import br.com.erpa.infra.RepositoryProductsMysql;



class SaveProductsTest {

	@Mock
	RepositoryProductsMysql repCustomersMysqlMock;
	private AutoCloseable closeable;
	private SaveProducts saveProducts;
	
	@BeforeEach
	public void beforeEach() {
		closeable = MockitoAnnotations.openMocks(this);
		saveProducts = new SaveProducts(repCustomersMysqlMock);
	}
	
	
	@Test
	void validFieldCodigoSize() {
		ProductsDTO productsDTO = MocksPopuled.MockProductDTO();				
		productsDTO.setCodigo("SD");
		Exception exception = assertThrows(ExceptionValidFields.class, () -> saveProducts.execute(productsDTO));
		assertTrue(exception.getMessage().contains("Error"));
		
		productsDTO.setCodigo(RandomStringUtils.random(51));
		exception = assertThrows(ExceptionValidFields.class, () -> saveProducts.execute(productsDTO));
		assertTrue(exception.getMessage().contains("Error"));		
				
	}
	
	@Test
	void validFieldNameSize() {
		ProductsDTO productsDTO = MocksPopuled.MockProductDTO();				
		productsDTO.setCodigo("4");
		Exception exception = assertThrows(ExceptionValidFields.class, () -> saveProducts.execute(productsDTO));
		assertTrue(exception.getMessage().contains("Error"));
		
		productsDTO.setCodigo(RandomStringUtils.random(102));
		exception = assertThrows(ExceptionValidFields.class, () -> saveProducts.execute(productsDTO));
		assertTrue(exception.getMessage().contains("Error"));		
				
	}	
	
	@Test
	void saveWithFieldOK () {
		ProductsDTO productsDTO = MocksPopuled.MockProductDTO();
		saveProducts.execute(productsDTO);
		Mockito.verify(repCustomersMysqlMock).insertProducts(Mockito.any());
	
	}	
	
	@AfterEach
    void closeService() throws Exception {
        closeable.close();
    }	

}
