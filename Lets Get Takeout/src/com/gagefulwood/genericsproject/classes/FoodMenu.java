package com.gagefulwood.genericsproject.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FoodMenu {
	private List<Food> menu;
	
	public FoodMenu() {
		this.menu = new ArrayList<>();
		menu.add(new Food("Street Tacos","Tacos",6));
		menu.add(new Food("Burgers","Burger",5));
		menu.add(new Food("Chips","Chips",2));
	}
	@Override
	public String toString() {
		StringBuilder compiledMenu = new StringBuilder();
		int index = 0;
		for (Food food : menu) {
			index++;
			compiledMenu.append("[").append(index).append("]\t");
			compiledMenu.append("$").append(food.getPrice()).append("\t");
			compiledMenu.append(food.getName()).append(" (").append(food.getDescription()).append(")");
		}
		return compiledMenu.toString();
	}
	
	public Food getFood(int item) {
		item--;
		if (item>=0 && item<menu.size()) {
			return menu.get(item);
		} else {
			return null;
		}
	}
	
	public Food getLowestCostFood() {
		Food lowestCostFood = menu.get(0);
		for (Food food:menu) {
			if (food.getPrice()<lowestCostFood.getPrice()) {
				lowestCostFood = food;
			}
		}
		return lowestCostFood;
	}
}
