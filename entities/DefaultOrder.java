package entities;

import java.util.Arrays;

public class DefaultOrder implements Order {
	private static final int AMOUNT_OF_DIGIT_CARD_NUMBER=16;
	private String creditCardNumber;
	private Product[] products;
	private int customerId;

	@Override
	public boolean isCreditCardValid(String creditCardNumber) {
		// TODO Auto-generated method stub
		if(creditCardNumber.toCharArray().length==AMOUNT_OF_DIGIT_CARD_NUMBER&&creditCardNumber.contains(" ")) {
			return true;
		}
		return false;
	}

	@Override
	public void setCreditCardNumber(String userInput) {
		// TODO Auto-generated method stub
		if(userInput==null) {
			return;
		}
		this.creditCardNumber=userInput;

	}

	@Override
	public void setProducts(Product[] products) {
		// TODO Auto-generated method stub
		this.products=products;

	}

	@Override
	public void setCustomerId(int customerId) {
		// TODO Auto-generated method stub
		this.customerId=customerId;

	}

	@Override
	public int getCustomer() {
		// TODO Auto-generated method stub
		return this.customerId;
	}

	@Override
	public String toString() {
		return "DefaultOrder [creditCardNumber=" + creditCardNumber + ", products=" + Arrays.toString(products)
				+ ", customerId=" + customerId + "]";
	}
	

}
