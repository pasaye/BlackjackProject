package com.skilldistillary.Blackjack.app;

import java.util.Scanner;

import com.skilldistillary.Blackjack.entities.Dealer;
import com.skilldistillary.Blackjack.entities.Player;

public class BlackjackApp {

	private Dealer dealer = new Dealer();
	private Player player = new Player();

	public static void main(String[] args) {
		BlackjackApp dealapp = new BlackjackApp();
		dealapp.run();

	}

	public void run() {
		Scanner kb = new Scanner(System.in);
		displayWelcome(kb);
		kb.close();

	}

	public void displayWelcome(Scanner kb) {
		System.out.println("Lets Play");
		System.out.println("Please Enter \n1: To Play \nAny Key: To quit");
		int userChoice = kb.nextInt();
		kb.nextLine();
		if (userChoice == 1) {
			startBlackjack(kb);
		} else {
			System.out.println("GoodBye");
		}
	}

	private void startBlackjack(Scanner kb) {
		System.out.println("Dealer is shuffling...");
		System.out.println();
		dealer.shuffleCards();
		System.out.println("Dealer is dealing");

		player.dealtCard(dealer.deal());
		System.out.println("Players first card: " + player);

		dealer.addDealerCard(dealer.deal());
		System.out.println("Dealers first card: face down");

		player.dealtCard(dealer.deal());
		System.out.println("Players second card: " + player);

		dealer.addDealerCard(dealer.deal());
		System.out.println("Dealer second card: " + dealer);

		System.out.println("What would you like to do? \n 1:Hit \n 2: Stand");
		int choice = kb.nextInt();
		switch (choice) {
		case 1:
			hitOrStand(kb);
			run();
			break;
		case 2:
			dealerStartsTurn();
			run();
			break;
		default:
			System.out.println("Invalid Entry. Please enter numerical value #1 or #2. ");
			break;

		}

	}

	private void hitOrStand(Scanner kb) {

	}

	private void dealerStartsTurn() {

	}

	private void checkWinner() {

	}
}
