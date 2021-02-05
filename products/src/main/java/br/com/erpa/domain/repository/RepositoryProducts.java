package br.com.erpa.domain.repository;

import java.util.List;

import br.com.erpa.domain.entity.ProductsEntity;

/**
 * Repository from Products 
 *  
 * @author jonadabe
 * @param  methods insertProducts ProductsEntity
 * @param  methods updateProducts ProductsEntity
 * @param  methods deleteProductsr ProductsEntity
 * @param  methods listaAllProducts ProductsEntity
 * @return findByProducts ProductsEntity
 * @return listaAllProducts list from ProductssEntity
 */
public interface RepositoryProducts {
	
	public void insertProducts(ProductsEntity productsEntity);
	public void updateProducts(ProductsEntity productsEntity);
	public void deleteProducts(ProductsEntity productsEntity);
	public ProductsEntity findByCodigo(String codigo);
	public List<ProductsEntity> listaAllProducts();	

}
