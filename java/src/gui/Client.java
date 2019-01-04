package gui;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Glovo.GlovoApp;
import Glovo.Item;
import Glovo.Restaurant;
import Glovo.Seller;
import Glovo.quotes.Fast_FoodQuote;

public class Client {
	
	private static GlovoApp app;
	

	public static void main(String[] args) {
		try {
			init();
		} 
		catch (IOException e) {
			System.out.println("Error when initializing app.");
			return;
		}
		
		System.out.println("Welcome to Glovo!");
		
		System.out.println(((Seller) app.getSellers().get(0)).getItems());
		
	}
	
	static private void init() throws IOException {
		app = new GlovoApp();
		app.addSeller(new Restaurant("KFC", "Restaurante de Frango", "Rua de teste", "Porto", 3, new Fast_FoodQuote()));
			
		FileReader fr = new FileReader("data.txt"); 
			  
	    int i; 
	    while ((i = fr.read()) != -1) 
	      System.out.print((char) i); 
	    
	    fr.close();
	}

}
