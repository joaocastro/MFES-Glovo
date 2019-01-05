package gui;

import java.util.Random;
import java.util.Scanner;

import org.overture.codegen.runtime.SeqUtil;
import org.overture.codegen.runtime.Utils;
import org.overture.codegen.runtime.VDMSeq;

import Glovo.GlovoApp;
import Glovo.Item;
import Glovo.Order;
import Glovo.Order.TimeStamp;
import Glovo.User;
import Glovo.Restaurant;
import Glovo.Seller;
import Glovo.Store;

public class Client {
	
	private Scanner reader;
	private GlovoApp app;
	private Main main;
	private boolean loggedIn = false;
	private User user;

	private VDMSeq orderItems = SeqUtil.seq();
	private String orderSeller = "";
	private String orderAddress = "";
	
	private Order order;
	

	Client (GlovoApp a, Scanner r, Main m) {
		app = a;
		reader = r;
		main = m;
	}
	
	public void menu() {
		if (loggedIn) loggedMenu();
		else loginMenu();
	}
	
	private void loginMenu() {
		System.out.println("=== Client area ===\n"
				+ "   1. Login\n"
				+ "   2. Register\n"
				+ "   0. Back\n"
				+ "Choose an option: ");

		int option = reader.nextInt();
		switch (option) {
			case 1: login();
					break;
			case 2: register();
					break;
			case 0: main.menu();
					return;
		}
	}
	
	private void loggedMenu() {
		String hasOrderOption = this.orderItems.isEmpty() ? "" : "4. Order Details\n";
		
		System.out.println("=== Welcome " + user.getName() + "! ===\n"
				+ "Balance: " + user.getBalance() + "€\n"
				+ "---------------\n"
				+ "1. Make deposit\n"
				+ "2. Stores\n"
				+ "3. Restaurants\n"
				+ hasOrderOption
				+ "0. Back\n"
				+ "Choose an option: ");

		int option = reader.nextInt();
		switch (option) {
			case 1: makeDeposit();
					break;
			case 2: listStores();
					break;
			case 3: listRestaurants();
					break;
			case 4: if(this.orderItems.isEmpty()) loggedMenu();
					else orderOptions();
					break;
			case 0: main.menu();
					break;
			default: 
				loggedMenu();
		}
	}
	
	private void orderOptions() {
		Random rand = new Random();
		
		if(this.orderAddress.isEmpty()) promptAddress();
		if (this.order == null) this.order = new Order(this.orderAddress, new TimeStamp(rand.nextInt(30) + 1, rand.nextInt(4) * 15), this.orderItems, this.user, app.getSellerByName(this.orderSeller));
				
		System.out.println("=== Order information ===\n"
				+ "Delivery Time: " + String.format("%02dm %02ds\n", this.order.getDeliveryTime().minutes, this.order.getDeliveryTime().seconds)
				+ String.format("Cost: %.2f€\n", this.order.getTotalPrice())
				+ "Seller: " + this.order.getSeller().getName() + "\n"
				+ "Address: " + this.order.getDeliveryAddress() + "\n"		
				+ "Items: \n"
				+ formatItems(this.order.getItems())
				+ "---------------\n"
				+ "1. Confirm order\n"
				+ "2. Cancel order\n"
				+ "0. Back\n"
				+ "Choose an option: ");

		int option = reader.nextInt();
		switch (option) {
			case 1: dispatchOrder();
					break;
			case 2: resetOrder();
					loggedMenu();
					break;
			case 0: main.menu();
					break;
			default: 
				loggedMenu();
		}
	}
	
	private void dispatchOrder() {
		if ((Float) this.order.getTotalPrice() > (Float) this.user.getBalance()) {
			System.out.println("Not enough balance to dispatch order. Please add funds to your account.");
		} else {
			main.dispatchOrder(this.order);
			resetOrder();
			System.out.println("Order dispatched.");			
		}
		loggedMenu();
	}
	
	private String formatItems(VDMSeq items) {
		String formatedItems = "";
		for (int i = 0; i < items.size(); i++) {
			Item item = (Item) items.get(i);
			formatedItems += "   - " + item.getName() + " - " + item.getPrice() + "€\n      " + item.getInfo() + "\n";
		}
		return formatedItems;
	}
	
	private void promptAddress() {
		System.out.println("Enter address for order:");

		this.orderAddress = reader.nextLine();
	}
	
	private void makeDeposit() {
		System.out.println("Enter amount to deposit:");

		float amount = Float.parseFloat(reader.next());
		user.deposit(amount);
		System.out.println("Amount deposited");
	};
	
	private void login() {
		System.out.println("=== Login ===\n"
				+ "Username: ");

		String username = reader.next();
		if(!((User) app.getUserByName(username)).getName().isEmpty()) {
			this.loggedIn = true;
			this.user = (User) app.getUserByName(username);
			loggedMenu();
		}
		else {
			System.out.println("User not found. Redirecting to register");
			register();
		}
	}
	
	private void register() {
		System.out.println("=== Register ===\n"
				+ "Username: ");

		String username = reader.next();
		if(!((User) app.getUserByName(username)).getName().isEmpty()) {
			System.out.println("User name \"" + username + "\"already in use.");
			register();
		}
		else {
			System.out.println("City");
			String city = reader.next();
			app.registerUser(new User(username, city));
			this.user = (User) app.getUserByName(username);
			this.loggedIn = true;
			loggedMenu();
		}
	}
	
	private void listRestaurants() {
		VDMSeq restaurants = app.getRestaurantsByCity(user.getCity());
		System.out.println("Here are all the options in your area.\n"
				+ "Choose an option:");
		for (int i = 0; i < restaurants.size(); i++) {
			Restaurant restaurant = (Restaurant) restaurants.get(i);
			System.out.println((i + 1) + ". " + restaurant.getName() + " - " + formatQuote(restaurant.getCategory()));
		}
		System.out.println("0. Back");
		
		int option = reader.nextInt();
		switch(option) {
			case 0: loggedMenu();
			default: restaurantPage(option - 1);
		}
	}
	
	private void listStores() {
		VDMSeq stores = app.getStoresByCity(user.getCity());
		System.out.println("Here are all the options in your area.\n"
				+ "Choose an option:");
		for (int i = 0; i < stores.size(); i++) {
			Store store = (Store) stores.get(i);
			System.out.println((i + 1) + ". " + store.getName() + " - " + formatQuote(store.getCategory()));
		}
		System.out.println("0. Back");
		
		int option = reader.nextInt();
		switch(option) {
			case 0: loggedMenu();
			default: storePage(option - 1);
		}
	}
	
	private void restaurantPage(int index) {
		Restaurant restaurant = (Restaurant) app.getRestaurantsByCity(user.getCity()).get(index);
		if (!this.orderSeller.equals(restaurant.getName())) resetOrder();
		
		printSellerInfo(restaurant);
		
		int option = reader.nextInt();
		switch(option) {
			case 0: listRestaurants();
			default: if(restaurant.getItems().get(option - 1) != null) {
				this.orderItems = SeqUtil.conc(Utils.copy(this.orderItems), SeqUtil.seq(restaurant.getItems().get(option - 1)));
				this.orderSeller = restaurant.getName();
				System.out.println("Item added to order.");
				restaurantPage(index);
			}
		}
	}
	
	private void storePage(int index) {
		Store store = (Store) app.getStoresByCity(user.getCity()).get(index);
		if (!this.orderSeller.equals(store.getName())) resetOrder();
		
		printSellerInfo(store);
		
		int option = reader.nextInt();
		switch(option) {
			case 0: listStores();
			default: if(store.getItems().get(option - 1) != null) {
				this.orderItems = SeqUtil.conc(Utils.copy(this.orderItems), SeqUtil.seq(store.getItems().get(option - 1)));
				this.orderSeller = store.getName();
				System.out.println("Item added to order.");
				storePage(index);
			}
		}
	}
	
	private void printSellerInfo(Seller seller) {
		System.out.println("== " + seller.getName() + " ==\n"
				+ "Description: " + seller.getDescription() + "\n"
				+ "Address: " + seller.getAddress() + "\n"
				+ "Items:");
		for (int i = 0; i < seller.getItems().size(); i++) {
			Item item = (Item) seller.getItems().get(i);
			System.out.println((i + 1) + ". " + item.getName() + " - " + item.getPrice() + "€\n"
					+ "   " + item.getInfo());
		}
		System.out.println("0. Back");
	}
	
	private void resetOrder() {
		this.orderItems.clear();
		this.orderSeller = "";
		this.order = null;
	}
	
	private String formatQuote(Object quote) {
		return quote.toString().replace("_", " ").replace("<", "").replace(">", "");
	}
}
