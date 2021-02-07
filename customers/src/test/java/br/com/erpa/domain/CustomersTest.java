package br.com.erpa.domain;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import br.com.erpa.MocksPopuled;
import br.com.erpa.domain.entity.CustomersEntity;
import br.com.erpa.validator.ValidatorBean;

class CustomersTest {

		
	@Test
	public void nameNullAndEmpty() {
		CustomersEntity customerEntity = MocksPopuled.MockCustomerEntity();
		customerEntity.setName(null);
		assertFalse(ValidatorBean.Validator().validate(customerEntity).isEmpty());
		
		customerEntity = MocksPopuled.MockCustomerEntity();
		customerEntity.setName("");
		assertFalse(ValidatorBean.Validator().validate(customerEntity).isEmpty());		
	}
	
	@Test
	public void nameFieldSizeMin() {
		CustomersEntity customerEntity = MocksPopuled.MockCustomerEntity();
		customerEntity.setName("Nom");
		assertFalse(ValidatorBean.Validator().validate(customerEntity).isEmpty());
	}
	
	@Test
	public void fieldValid() {
		CustomersEntity customerEntity = MocksPopuled.MockCustomerEntity();
		assertTrue(ValidatorBean.Validator().validate(customerEntity).isEmpty());
	}

}
