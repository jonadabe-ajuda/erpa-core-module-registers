package br.com.erpa.application;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.erpa.MocksPopuled;
import br.com.erpa.application.command.SaveCustomer;
import br.com.erpa.application.dto.CustomerDTO;
import br.com.erpa.domain.exception.ExceptionValidFields;
import br.com.erpa.infra.RepositoryCustomersMysql;

class SaveCustomerTest {

	@Mock
	RepositoryCustomersMysql repCustomersMysqlMock;
	private AutoCloseable closeable;
	private SaveCustomer saveCustomer;
	
	@BeforeEach
	public void beforeEach() {
		closeable = MockitoAnnotations.openMocks(this);
		saveCustomer = new SaveCustomer(repCustomersMysqlMock);
	}
	
	@Test
	void validFieldCPFBeforeSave() {
		CustomerDTO customerDTO = MocksPopuled.MockCustomerDTO(); 				
		customerDTO.setCpf("0123456789");
		Exception exception = assertThrows(ExceptionValidFields.class, () -> saveCustomer.execute(customerDTO));
		assertTrue(exception.getMessage().contains("Error"));
		
	}
	
	@Test
	void validFieldZipCodeBeforeSave() {
		CustomerDTO customerDTO = MocksPopuled.MockCustomerDTO(); 				
		customerDTO.setZipCode("1234567");
		Exception exception = assertThrows(ExceptionValidFields.class, () -> saveCustomer.execute(customerDTO));
		assertTrue(exception.getMessage().contains("Error"));
		//Mockito.verify(repCustomersMysqlMock).insertCustomer(Mockito.any());
		
	}	
	
	@Test
	void validFieldWithMinSize() {
		CustomerDTO customerDTO = MocksPopuled.MockCustomerDTO(); 				
		customerDTO.setName("Maia");
		Exception exception = assertThrows(ExceptionValidFields.class, () -> saveCustomer.execute(customerDTO));
		assertTrue(exception.getMessage().contains("Error"));
				
		customerDTO.setStreet("Rua");
		exception = assertThrows(ExceptionValidFields.class, () -> saveCustomer.execute(customerDTO));
		assertTrue(exception.getMessage().contains("Error"));		
				
	}
	
	@Test
	void validFieldWithNameMaxSize() {
		CustomerDTO customerDTO = MocksPopuled.MockCustomerDTO(); 				
		customerDTO.setName(RandomStringUtils.random(102));
		Exception exception = assertThrows(ExceptionValidFields.class, () -> saveCustomer.execute(customerDTO));
		assertTrue(exception.getMessage().contains("Error"));
				
	}
	
	@Test
	void validFieldWithStreetMaxSize() {
		CustomerDTO customerDTO = MocksPopuled.MockCustomerDTO(); 				
		customerDTO.setStreet(RandomStringUtils.random(106));
		Exception exception = assertThrows(ExceptionValidFields.class, () -> saveCustomer.execute(customerDTO));
		assertTrue(exception.getMessage().contains("Error"));
				
	}	
	
	
	@Test
	void saveWithFieldOK () {
		CustomerDTO customerDTO = MocksPopuled.MockCustomerDTO();
		saveCustomer.execute(customerDTO);
		Mockito.verify(repCustomersMysqlMock).insertCustomer(Mockito.any());
	
	}	
	
	@AfterEach
    void closeService() throws Exception {
        closeable.close();
    }	
	

}
