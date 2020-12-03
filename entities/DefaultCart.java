package entities;

import java.util.Arrays;

public class DefaultCart implements Cart {
	private Product[] products;
	private static final int DEFAULT_PRODUCT_CAPACITY=10;
	private int lastIndex;

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(products==null || products.length==0) {
			return true;
			}
		else {
			for(Product product:products ) {
				if(product!=null) {
					return true;
				}
				
			}
			return true;
		}
	}

	@Override
	public void addProduct(Product productById) {
		// TODO Auto-generated method stub
		if(productById==null) {
			return;	
		}
		if(products.length<=lastIndex) {
			products=Arrays.copyOf(products, products.length<<1);
		}
		products[lastIndex++]=productById;
		

	}

	@Override
	public Product[] getProducts() {
		// TODO Auto-generated method stub
		int nonNullProduct=0;
		for(Product product:products) {
			if(product!=null) {
				nonNullProduct++;
			}
		}
		int index=0;
		Product[] productFiltred=new Product[nonNullProduct];
		for(Product product:products) {
			if(product!=null) {
				productFiltred[index++]=product;
			}
		}
		
		return productFiltred;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		products=new Product[DEFAULT_PRODUCT_CAPACITY];

	}

}
