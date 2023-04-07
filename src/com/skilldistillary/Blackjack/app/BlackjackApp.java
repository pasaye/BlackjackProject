package com.skilldistillary.Blackjack.app;

import java.util.Scanner;

public class BlackjackApp {
	
	public static void main(String[] args) {
		BlackjackApp deal = new BlackjackApp();
		deal.run();
		
	}

	public void run() {
		Scanner kb = new Scanner(System.in);
		
		int userChoice = 0;
		
		System.out.println("How many Cards would you like.");
		userChoice = kb.nextInt();
		
		
	}

}
