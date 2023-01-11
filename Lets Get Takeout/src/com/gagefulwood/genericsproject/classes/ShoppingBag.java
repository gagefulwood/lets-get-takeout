package com.gagefulwood.genericsproject.classes;
import java.util.HashMap;
import java.util.Map;


public class ShoppingBag<T extends PricedItem<Integer>> {
	private Map<T,Integer> shoppingBag = new HashMap<>();
	
	public ShoppingBag() {
		this.shoppingBag = shoppingBag;
	}
	
	public void addItem(T item) {
		Integer mapping = shoppingBag.get(item);
		if (mapping == null) {
			shoppingBag.put(item, 1);
		} else {
			shoppingBag.put(item, mapping++);
		}
	}
	
	public int getTotalPrice() {
		int totalPrice = 0;
		for(Map.Entry<T,Integer> item: shoppingBag.entrySet()) {
			T food = item.getKey();
			int count = item.getValue();
			int price = food.getPrice();
			totalPrice += (price*count);
		}
		return totalPrice;
	}
}
