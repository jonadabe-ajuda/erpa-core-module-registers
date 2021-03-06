package br.com.erpa.application.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Data Acess Object products
 *  
 * @author jonadabe
 * @param  methods Constructor all attribute
 */
public class ProductsDTO {
	

	@NotNull
	@NotEmpty
	@Size(min = 3,max = 50,message = "CustomerDTO field name between 2 and 50")
	private String codigo;
	
	@NotNull
	@NotEmpty
	@Size(min = 5,max = 100,message = "CustomerDTO field number equal 11")
	private String name;
	
	@NotNull	
	private int isActive;
	
	@NotNull
	private BigDecimal valueSale;
	
	public ProductsDTO() {}

	public ProductsDTO(
			@NotNull @NotEmpty @Size(min = 2, max = 50, message = "CustomerDTO field name between 2 and 50") String codigo,
			@NotNull @NotEmpty @Size(min = 5, max = 100, message = "CustomerDTO field number equal 11") String name,
			@NotNull int isActive, @NotNull BigDecimal valueSale) {
		super();
		this.codigo = codigo;
		this.name = name;
		this.isActive = isActive;
		this.valueSale = valueSale;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public BigDecimal getValueSale() {
		return valueSale;
	}

	public void setValueSale(BigDecimal valueSale) {
		this.valueSale = valueSale;
	}
	
	
	

}
