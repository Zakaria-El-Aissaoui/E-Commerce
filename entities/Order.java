package entities;

public interface Order {
	boolean isCreditCardValid(String userInput);
	void setCreditCardNumber(String userInput);
	void setProducts(Product[] products);
	void setCustomerId(int customerId);
	int getCustomer();
	

}
