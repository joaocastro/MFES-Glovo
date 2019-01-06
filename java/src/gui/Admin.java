package gui;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.overture.codegen.runtime.VDMSeq;

import Glovo.Driver;
import Glovo.GlovoApp;
import Glovo.Order;
import Glovo.User;
import Glovo.quotes.deliveringQuote;
import Glovo.quotes.waitingQuote;

public class Admin {
	
	private Scanner reader;
	private GlovoApp app;
	private Main main;

	Admin (GlovoApp a, Scanner r, Main m) {
		app = a;
		reader = r;
		main = m;
	}
	
	public void menu() {
		main.clear();
		System.out.println("=== Admin area ===\n"
				+ "   1. List all users\n"
				+ "   2. List all orders\n"
				+ "   3. List all drivers\n"
				+ "   0. Back\n"
				+ "Choose an option: ");

		int option; try { option = reader.nextInt(); } catch (InputMismatchException e) { reader.nextLine(); menu(); return; }
		switch (option) {
			case 1: listAllUsers();
					break;
			case 2: listAllOrders();
					break;
			case 3: listAllDrivers();
					break;
			case 0: main.menu();
					return;
		}
	}
	
	private void listAllUsers() {
		main.clear();
		System.out.println("=== Users ===");
		VDMSeq users = app.getUsers();
		if (users.isEmpty()) System.out.println("No users to display.");
		
		for (int i = 0; i < users.size(); i++) {
			User user = (User) users.get(i);
			System.out.println("   " + i + " | " + user.getName() + " | " + user.getCity() + " | " + user.getBalance() + "€");
		}
		
		System.out.println("Press any key to return.");
		reader.nextLine();
		reader.nextLine();
		menu();
	}
	
	private void listAllDrivers() {
		main.clear();
		System.out.println("=== Drivers ===");
		VDMSeq drivers = app.getDrivers();
		if (drivers.isEmpty()) System.out.println("No Drivers to display.");
		
		for (int i = 0; i < drivers.size(); i++) {
			Driver driver = (Driver) drivers.get(i);
			System.out.println("   " + i + " | " + driver.getName() + " | " + driver.getCity() + " | " + formatQuote(driver.getStatus()));
		}
		
		System.out.println("Press any key to return.");
		reader.nextLine();
		reader.nextLine();
		menu();
	}

	private void listAllOrders() {
		main.clear();
		System.out.println("=== Orders ===");
		
		VDMSeq orders = app.getOrders();
		if (orders.isEmpty()) System.out.println("No orders to display.");
		
		for (int i = 0; i < orders.size(); i++) {
			Order order = (Order) orders.get(i);

			String state;
			if (order.getState() instanceof waitingQuote) {
				state = "Waiting for driver"; 
			} else if (order.getState() instanceof deliveringQuote) {
				state = "Being delivered by driver " + order.getDriver().getName();
			} else {
				state = "Delivered by driver " + order.getDriver().getName();
			}
			
			System.out.println("   " + i 
					+ " | " + order.getUser().getName()
					+ " | " + order.getSeller().getName()
					+ String.format(" | %.2f€ | ", order.getTotalPrice())
					+ String.format("%02dm %02ds | ", order.getDeliveryTime().minutes, order.getDeliveryTime().seconds)
					+ state);
		}
		
		System.out.println("Press any key to return.");
		reader.nextLine();
		reader.nextLine();
		menu();
	}
	
	private String formatQuote(Object quote) {
		return quote.toString().replace("_", " ").replace("<", "").replace(">", "");
	}
	
}
