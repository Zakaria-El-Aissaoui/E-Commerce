package services;

import entities.Product;

public interface ProductManagementService {
	 Product[] getProducts();
	 Product getProductById(int productIdToAddCart);
	
	

}
