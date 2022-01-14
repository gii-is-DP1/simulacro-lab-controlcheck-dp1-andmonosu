package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, Integer>{
   
	
	List<Product> findAll();
    Optional<Product> findById(int id);
    
    @Query("SELECT DISTINCT productType FROM ProductType productType")
    public List<ProductType> findAllProductTypes();
	
	@Query("SELECT DISTINCT productType FROM ProductType productType WHERE productType.name = ?1")
    public ProductType findProductTypeByName(String name);
	
	@Query("SELECT DISTINCT product FROM Product product WHERE product.price < ?1")
	public List<Product> findByPriceLessThan(double cost);

	@Query("SELECT DISTINCT product FROM Product product WHERE product.name = ?1")
	public Product findByName(String string);
}
