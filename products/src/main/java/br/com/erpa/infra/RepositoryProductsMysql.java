package br.com.erpa.infra;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.erpa.application.BuilderProducts;
import br.com.erpa.domain.entity.ProductsEntity;
import br.com.erpa.domain.model.Products;
import br.com.erpa.domain.repository.RepositoryProducts;

/**
 * Repository products with jpa used in mysql
 *  
 * @author jonadabe
 * @param  methods Constructor RepositoryProducts
 * @param  methods insertProducts ProductsEntity
 * @param  methods updateProducts ProductsEntity
 * @param  methods deleteProducts ProductsEntity
 * @param  methods findByProducts String codigo
 * @param  methods convertToProductEntity Products
 * @param  methods convertToProduct ProductsEntity
 * @return findByProduct ProductEntity
 * @return listaAllProducts List<ProductsEntity>
 */
public class RepositoryProductsMysql implements RepositoryProducts {

	private final String unitPersistence;
	
	public RepositoryProductsMysql(String unitPersistence) {
		this.unitPersistence = unitPersistence;
	}	


	private EntityManagerFactory entityManagerFactory() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitPersistence);
		return emf; 
	}



	@Override
	public void insertProducts(ProductsEntity productsEntity) {
		EntityManager em = entityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(convertToProduct(productsEntity));
		em.getTransaction().commit();
		
	}



	@Override
	public void updateProducts(ProductsEntity productsEntity) {
		EntityManager em = entityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Products product =  bankFindByProducts(em, productsEntity.getCodigo());
		product.setName(productsEntity.getName());
		product.setIsActive(productsEntity.getIsActive());
		product.setValueSale(productsEntity.getValueSale());
		em.getTransaction().commit();	
		
	}



	@Override
	public void deleteProducts(ProductsEntity productsEntity) {
		EntityManager em = entityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Products product =  bankFindByProducts(em, productsEntity.getCodigo());
		em.remove(product);
		em.getTransaction().commit();
		
	}



	@Override
	public ProductsEntity findByCodigo(String codigo) {
		EntityManager em = entityManagerFactory().createEntityManager();
		return convertToProductsEntity(bankFindByProducts(em, codigo));
	}



	@Override
	public List<ProductsEntity> listaAllProducts() {
		EntityManager em = entityManagerFactory().createEntityManager();
		String sql = "SELECT products FROM Products products ";
		Query query = em.createQuery(sql);
		List<Products> listProducts = new ArrayList<Products>();
		List<ProductsEntity> listProductsEntity = new ArrayList<ProductsEntity>();
		listProducts = query.getResultList();
		listProducts.forEach( product -> {
			listProductsEntity.add(convertToProductsEntity(product));
		});
		return listProductsEntity;
	}	
	
	
	
	private Products bankFindByProducts(EntityManager em, String codigo) {
		String sql = "SELECT products FROM Products products where products.codigo = :codigo ";
		Query query = em.createQuery(sql);
		query.setParameter("codigo",codigo);
		query.setMaxResults(1);
		return (Products) query.getSingleResult();		
	}
	
	private ProductsEntity convertToProductsEntity( Products products ) {
		ProductsEntity productsEntity = new BuilderProducts()
		   .withProduct(products.getCodigo(),
				   		products.getName(),
				   		products.getIsActive(),
				   		products.getValueSale())
		   .create();		
		return productsEntity;
	}
	
	private Products convertToProduct( ProductsEntity productsEntity ) {
		Products products = new Products();
		products.setCodigo(productsEntity.getCodigo());
		products.setName(productsEntity.getName());
		products.setIsActive(productsEntity.getIsActive());
		products.setValueSale(productsEntity.getValueSale());
		return products;
	}
		
	
	

}
