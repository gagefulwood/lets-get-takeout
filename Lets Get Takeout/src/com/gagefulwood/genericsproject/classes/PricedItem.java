package com.gagefulwood.genericsproject.classes;

interface PricedItem<T extends Number>{
	public abstract void setPrice(T price);
	public abstract T getPrice();
}
