package br.com.erpa.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.erpa.domain.vo.CPF;
import br.com.erpa.validator.ValidatorBean;

class CPFTest {

	@Test
	public void isNull() {
		CPF cpf = new CPF(null);	
		assertFalse(ValidatorBean.Validator().validate(cpf).isEmpty());
	
	}
	
	@Test
	public void fieldSize() {
		CPF cpf = new CPF("1234567890");
		assertFalse(ValidatorBean.Validator().validate(cpf).isEmpty());
	}
	
	@Test
	public void fieldValid() {
		CPF cpf = new CPF("12345678901");
		assertTrue(ValidatorBean.Validator().validate(cpf).isEmpty());
	}	

}
