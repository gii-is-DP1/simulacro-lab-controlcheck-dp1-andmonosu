package org.springframework.samples.petclinic.product;

import java.util.Collection;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductService {
	
	
	private ProductRepository productRepository;	
	
	
	@Autowired
    public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Transactional
	public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

	@Transactional
    public List<Product> getProductsCheaperThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }

	@Transactional
    public ProductType getProductType(String typeName) {
        return productRepository.findProductTypeByName(typeName);
    }

	public Collection<ProductType> findAllProductTypes(){
		return productRepository.findAllProductTypes();
	}
	
	@Transactional
    public Product save(Product p){
        return productRepository.save(p);       
    }

    
}
