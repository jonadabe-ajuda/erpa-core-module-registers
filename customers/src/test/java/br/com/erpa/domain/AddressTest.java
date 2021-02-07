package br.com.erpa.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.erpa.MocksPopuled;
import br.com.erpa.domain.vo.Address;
import br.com.erpa.validator.ValidatorBean;

class AddressTest {

	@Test
	public void isNull() {
		Address address = MocksPopuled.MockAddressVoNull();
		assertFalse(ValidatorBean.Validator().validate(address).isEmpty());
	
	}
	
	@Test
	public void fieldSize() {
		Address address = MocksPopuled.MockAddressVoEmpty();
		assertFalse(ValidatorBean.Validator().validate(address).isEmpty());
	}
	
	@Test
	public void fieldZipCode() {
		Address address = MocksPopuled.MockAddressVo();
		address.setZipCode("01000");
		assertFalse(ValidatorBean.Validator().validate(address).isEmpty());
	}
	
	@Test
	public void fieldValid() {
		Address address = MocksPopuled.MockAddressVo();
		assertTrue(ValidatorBean.Validator().validate(address).isEmpty());
	}	

}
