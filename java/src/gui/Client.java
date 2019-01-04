package gui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

import org.overture.codegen.runtime.VDMSeq;

import Glovo.GlovoApp;
import Glovo.Item;
import Glovo.Restaurant;
import Glovo.User;
import Glovo.quotes.AsiaticaQuote;
import Glovo.quotes.Fast_FoodQuote;
import Glovo.quotes.InternacionalQuote;
import Glovo.quotes.ItalianaQuote;
import Glovo.quotes.JaponesaQuote;

public class Client {
	
	private static GlovoApp app;
	private static Scanner reader;
	

	public static void main(String[] args) {
		try {
			init();
		} catch (IOException e) {
			System.out.println("Error opening data file.");
		}
		
		printMainMenu();
	}
	
	static private void printMainMenu() {
		System.out.println("=== Glovo ===\n"
				+ "   1. Client area\n"
				+ "   2. Admin area\n"
				+ "Choose an option: ");

		int option = reader.nextInt();
		switch (option) {
			case 1: printClientArea();
					break;
			case 2: printAdminArea();
					break;
		}
	}
	
	static private void printClientArea() {
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
			case 0: printMainMenu();
					return;
		}
		
		printClientArea();
	}
	
	static private void login() {
		System.out.println("=== Login ===\n"
				+ "Username: ");

		String username = reader.next();
		if(!((User) app.getUserByName(username)).getName().isEmpty())
			System.out.println("Logged in");
		else {
			System.out.println("User not found. Redirecting to register");
			register();
		}
	}
	
	static private void register() {
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
		}
	}
	
	static private void printAdminArea() {
		System.out.println("=== Admin area ===\n"
				+ "   1. List all users\n"
				+ "   0. Back\n"
				+ "Choose an option: ");

		int option = reader.nextInt();
		switch (option) {
			case 1: listAllUsers();
					break;
			case 0: printMainMenu();
					return;
		}
		
		printAdminArea();
	}
	
	static private void listAllUsers() {
		System.out.println("=== Users ===");
		VDMSeq users = app.getUsers();
		for (int i = 0; i < users.size(); i++) {
			User user = (User) users.get(i);
			System.out.println("   " + i + " | " + user.getName() + " | " + user.getCity() + " | " + user.getBalance() + "€");
		}
	}
	
	static private void init() throws IOException {
		reader = new Scanner(System.in);
		app = new GlovoApp();
		
		initSellers();
		readItems();
	}
	
	static private void initSellers() {
		app.addSeller(new Restaurant("KFC", "Restaurante de Frango", "Rua Palmeiras, 51", "Porto", 2.5, new Fast_FoodQuote()));
		app.addSeller(new Restaurant("Pizza Hut", "Pizzaria", "Rua da Escola, 46", "Porto", 2.5, new Fast_FoodQuote()));
		app.addSeller(new Restaurant("Boa-Bao", "Cozinha pan-asiática", "Rua da Picaria 61-65", "Porto", 2.9, new AsiaticaQuote()));
		app.addSeller(new Restaurant("Munchie", "The Burger kitchen", "Praça D. Filipa de Lencastre 177", "Porto", 1.8, new Fast_FoodQuote()));
		app.addSeller(new Restaurant("Tapas N'Friends", "Sharing food", "Praça Guilherme Gomes Fernandes nº 37/39", "Porto", 1.9, new InternacionalQuote()));
		app.addSeller(new Restaurant("Temaki d'Lux", "Especialista em comida japonesa", "R. Preciosa 21", "Porto", 4, new JaponesaQuote()));
		app.addSeller(new Restaurant("La Piadona", "Piadinhas de alta qualidade", "R. de Santa Teresa 4", "Porto", 2.5, new ItalianaQuote()));
	}
	
	static private void readItems() throws IOException {
		try (Stream<String> stream = Files.lines(Paths.get("items.txt"))) {
	        stream.forEach(line-> {
	        	String[] args = line.split(";");
	    		app.addItemToSeller(args[0], new Item(args[1], args[2], Float.parseFloat(args[3])));
	    	});
		}
	}

}
