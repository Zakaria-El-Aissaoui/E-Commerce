package services;

import java.util.Arrays;

import entities.Order;

public class DefaultOrderManagementService implements OrderManagementService {
	private static final int DEFAULT_ORDER_CAPACITY = 10;

	private static DefaultOrderManagementService instance;
	private int lastIndex;
	private Order[] orders;

	// <write your code here>
	
	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;}

	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		if (order == null) {
			return;
		}
		if (orders.length <= lastIndex) {
			orders = Arrays.copyOf(orders, orders.length << 1);
		}
		orders[lastIndex++] = order;
		

	}

	@Override
	public Order[] getOrdersByUserId(int userId) {
		// TODO Auto-generated method stub
		int amountOfUserOrders=0;
		
		for(Order order:orders) {
			if(order.getCustomer()==userId) {
				amountOfUserOrders++;
				
			}
		}
		Order[] ordersUser=new Order[amountOfUserOrders];
		int index=0;
		for(Order order:orders) {
			if(order.getCustomer()==userId) {
				ordersUser[amountOfUserOrders++]=order;
				
			}
		}
		
		return ordersUser;
	}

	@Override
	public Order[] getOrders() {
		// TODO Auto-generated method stub
		return orders;
	}

}
