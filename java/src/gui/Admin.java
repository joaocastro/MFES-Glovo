package gui;

import java.util.Scanner;

import org.overture.codegen.runtime.VDMSeq;

import Glovo.GlovoApp;
import Glovo.User;

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
		System.out.println("=== Admin area ===\n"
				+ "   1. List all users\n"
				+ "   0. Back\n"
				+ "Choose an option: ");

		int option = reader.nextInt();
		switch (option) {
			case 1: listAllUsers();
					break;
			case 0: main.menu();
					return;
		}
	}
	
	private void listAllUsers() {
		System.out.println("=== Users ===");
		VDMSeq users = app.getUsers();
		for (int i = 0; i < users.size(); i++) {
			User user = (User) users.get(i);
			System.out.println("   " + i + " | " + user.getName() + " | " + user.getCity() + " | " + user.getBalance() + "€");
		}
	}

}
