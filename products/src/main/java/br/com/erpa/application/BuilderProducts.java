package br.com.erpa.application;

import java.math.BigDecimal;

import br.com.erpa.domain.entity.ProductsEntity;

/**
 * Build to create productsEntity.
 *  
 * @author jonadabe
 * @param  methods withProduct String codigo, String name, int isActive, BigDecimal valueSale
 * @return ProductsEntity
 */
public class BuilderProducts {
	
	private ProductsEntity productsEntity;
	
	public BuilderProducts withProduct(String codigo, String name, int isActive, BigDecimal valueSale) {
		this.productsEntity = new ProductsEntity(codigo, name , isActive, valueSale);
		return this;
	}
	
	public ProductsEntity create () {
		return this.productsEntity;
	}	

}
