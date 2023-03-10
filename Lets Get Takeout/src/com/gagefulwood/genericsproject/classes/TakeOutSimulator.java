package com.gagefulwood.genericsproject.classes;
import java.util.Scanner;

public class TakeOutSimulator {
	private Customer customer;
	private FoodMenu menu;
	private Scanner input;
	
	public TakeOutSimulator(Customer customer,FoodMenu menu,Scanner input) {
		this.customer = customer;
		this.menu = menu;
		this.input = input;
	}

	private <T> T getOutputOnIntInput(String userInputPrompt, IntUserInputRetriever<T> intUserInputRetriever) {
		while(true) {
			System.out.println(userInputPrompt);
			if (input.hasNextInt()) {
				int userInput = input.nextInt();
				try {
					return intUserInputRetriever.produceOutputOnIntUserInput(userInput);
				} catch (IllegalArgumentException e) {
					System.out.println("Invalid input provided. Please try again.");
				}
			} else {
				System.out.println("Input must be an integer. Please try again.");
				input.next();
			}
		}
		
	}
	
	public boolean shouldSimulate() {
		String userPrompt = "Enter [1] to CONTINUE\nEnter [0] to EXIT\n\t";
		IntUserInputRetriever<Boolean> intUserInputRetriever = (int selection) -> { 
			if (selection==1 && customer.getMoney()>=menu.getLowestCostFood().getPrice()) {
				return true;
			} else if (selection==0 || customer.getMoney()<menu.getLowestCostFood().getPrice()) {
				return false;
			} else {
				throw new IllegalArgumentException("Invalid selection: Selection must be [0] or [1]");
			}
		};
		
		return intUserInputRetriever.produceOutputOnIntUserInput(input.nextInt());
	}
	
	public Food getMenuSelection() {
		String userPrompt = menu.toString();
		IntUserInputRetriever<Food> intUserInputRetriever = (int selection) -> {
			Food selectedFood = menu.getFood(selection-1);
			if (selectedFood == null) {
				throw new IllegalArgumentException("Menu Food Value is Null.");
			} else {
				return selectedFood;
			}
		};
		return getOutputOnIntInput(userPrompt,intUserInputRetriever);
	}
	
	public boolean isStillOrderingFood() {
		String userPrompt = "Enter [1] to CONTINUE SHOPPING\nEnter [0] to CHECKOUT\n\t";
		IntUserInputRetriever<Boolean> intUserInputRetriever = (int selection) -> {
			if (selection==1) {
				return true;
			} else if (selection==0) {
				return false;
			} else {
				throw new IllegalArgumentException("Invalid selection: Selection must be [0] or [1]");
			}
		};
		return getOutputOnIntInput(userPrompt,intUserInputRetriever);
	}
	
	public void checkCustomer(ShoppingBag<Food> shoppingBag) {
		StringBuilder checkoutMessage = new StringBuilder();
		customer.setMoney(customer.getMoney()-shoppingBag.getTotalPrice());
		checkoutMessage.append("Payment processing...\n");
		checkoutMessage.append("Remaining Balance: $").append(customer.getMoney());
		checkoutMessage.append("\nEnjoy your food!");
		System.out.print(checkoutMessage);
	}
}
