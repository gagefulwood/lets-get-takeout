package com.gagefulwood.genericsproject.classes;

public class Food implements PricedItem<Integer>{
	private String name;
	private String description;
	private int price;
	
	public Food(String name, String description, int price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	@Override
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public Integer getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return (name+"($"+price+"):\t"+description);
	}
	
}
