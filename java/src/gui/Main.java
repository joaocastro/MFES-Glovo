package gui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;

import Glovo.Driver;
import Glovo.GlovoApp;
import Glovo.Item;
import Glovo.Order;
import Glovo.Restaurant;
import Glovo.Store;
import Glovo.User;
import Glovo.quotes.AsiaticaQuote;
import Glovo.quotes.ElectronicaQuote;
import Glovo.quotes.Fast_FoodQuote;
import Glovo.quotes.InternacionalQuote;
import Glovo.quotes.ItalianaQuote;
import Glovo.quotes.JaponesaQuote;

public class Main {
	
	private GlovoApp app;
	private Scanner reader;
	private Client client;
	private Admin admin;

	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}
	
	private void start() {
		try {
			init();
		} catch (IOException e) {
			System.out.println("Error opening data file.");
			return;
		}
		
		menu();
		
	}
	
	public void menu() {
		clear();
		System.out.println("=== Glovo ===\n"
				+ "   1. Client area\n"
				+ "   2. Admin area\n"
				+ "   0. Exit\n"
				+ "Choose an option: ");

		int option; try { option = reader.nextInt(); } catch (InputMismatchException e) { reader.nextLine(); menu(); return; }
		switch (option) {
			case 1: client.menu();
					break;
			case 2: admin.menu();
					break;
			case 0: return;
			default: menu();
		}
	}
	
	private void init() throws IOException {
		this.reader = new Scanner(System.in);
		this.app = new GlovoApp();
		this.client = new Client(app, reader, this);
		this.admin = new Admin(app, reader, this);
		
		initSellers();
		initUsers();
		initDrivers();
		readItems();
	}
	
	private void initDrivers() {
		app.addDriver(new Driver("João Costa", "Porto"));
		app.addDriver(new Driver("Matilde Andrade", "Porto"));
		app.addDriver(new Driver("José António", "Porto"));
		app.addDriver(new Driver("Manuel Carreiro", "Porto"));
	}
	
	private void initUsers() {
		app.registerUser(new User("pipas", "Porto"));
	}
	
	private void initSellers() {
		app.addSeller(new Restaurant("KFC", "Restaurante de Frango", "Rua Palmeiras, 51", "Porto", 2.5, new Fast_FoodQuote()));
		app.addSeller(new Restaurant("Pizza Hut", "Pizzaria", "Rua da Escola, 46", "Porto", 2.5, new Fast_FoodQuote()));
		app.addSeller(new Restaurant("Boa-Bao", "Cozinha pan-asiática", "Rua da Picaria 61-65", "Porto", 2.9, new AsiaticaQuote()));
		app.addSeller(new Restaurant("Munchie", "The Burger kitchen", "Praça D. Filipa de Lencastre 177", "Porto", 1.8, new Fast_FoodQuote()));
		app.addSeller(new Restaurant("Tapas N'Friends", "Sharing food", "Praça Guilherme Gomes Fernandes nº 37/39", "Porto", 1.9, new InternacionalQuote()));
		app.addSeller(new Restaurant("Temaki d'Lux", "Especialista em comida japonesa", "R. Preciosa 21", "Porto", 4, new JaponesaQuote()));
		app.addSeller(new Restaurant("La Piadona", "Piadinhas de alta qualidade", "R. de Santa Teresa 4", "Porto", 2.5, new ItalianaQuote()));
		app.addSeller(new Store("FNAC", "Loja de Eletrónica", "Rua de Santa Catarina 73", "Porto", 6, new ElectronicaQuote()));
	}
	
	private void readItems() throws IOException {
		try (Stream<String> stream = Files.lines(Paths.get("items.txt"))) {
	        stream.forEach(line-> {
	        	String[] args = line.split(";");
	    		app.addItemToSeller(args[0], new Item(args[1], args[2], Float.parseFloat(args[3])));
	    	});
		}
	}

	public void dispatchOrder(Order order) {
		if(app.addOrder(order)) {
			Delivery delivery = new Delivery(order, this);
			delivery.start();
		}
	}
	
	public void triggerDelivery() {
		Order order = app.triggerWaitingOrder();
		if (order != null) {
			Delivery delivery = new Delivery(order, this);
			delivery.start();
		}
	}
	
	public void clear() {
		System.out.print("\033[H\033[2J");
	}
	
	public void showTooltip(String tooltip) {
		System.out.println(tooltip);
		try { Thread.sleep(1000); } catch (InterruptedException e) {}
	}
}
