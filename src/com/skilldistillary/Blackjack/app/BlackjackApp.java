package com.skilldistillary.Blackjack.app;

import java.util.Scanner;

import com.skilldistillary.Blackjack.entities.BlackjackHand;
import com.skilldistillary.Blackjack.entities.Dealer;
import com.skilldistillary.Blackjack.entities.Player;

public class BlackjackApp {

	private Dealer dealer = new Dealer();
	private Player player = new Player();
	private BlackjackHand hand = new BlackjackHand();

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
		System.out.println("Please Enter \n1: To Play \n2: To quit");
		int userChoice = kb.nextInt();
		kb.nextLine();
		switch (userChoice) {
		case 1:
			startBlackjack(kb);
			break;
		case 2:
			System.out.println("GoodBye");
			break;
		default:
			System.out.println("Invaild Entry");
			break;

		}

	}

	private void startBlackjack(Scanner kb) {
		System.out.println("Dealer is shuffling...");
		System.out.println();
		dealer.shuffleCards();
		System.out.println("Dealer is dealing");

		player.dealtCard(dealer.deal());
		System.out.println(player);

//		dealer.addDealerCard(dealer.deal());
		System.out.println("Dealers first card: face down");

		player.dealtCard(dealer.deal());
		System.out.println(player);

		dealer.addDealerCard(dealer.deal());
		System.out.println(dealer);
		System.out.println();
		System.out.println();

		System.out.println(player.getHandPlayer().getHandValue());
		System.out.println();
		System.out.println("What would you like to do? \n 1:Hit \n 2:Stand");
		int choice = kb.nextInt();
		switch (choice) {
		case 1:
			hitOrStand(kb);
			break;
		case 2:
			dealerStartsTurn();
			break;
		default:
			System.out.println("Invalid Entry. Please enter numerical value #1 or #2. ");
			break;

		}

	}

	private void hitOrStand(Scanner kb) {
		System.out.println(player.getHandPlayer());
		System.out.println("  Current score:" + player.getHandPlayer().getHandValue());

		player.dealtCard(dealer.deal());
		System.out.println(player);
		System.out.println("New total " + player.getHandPlayer().getHandValue());
		if (player.getHandPlayer().getHandValue() > 21) {
			player.playerHandBust();
			playAgain(kb);
		
		} else if (player.getHandPlayer().getHandValue() == 21) {
			player.playerHandBlackJack();
			playAgain(kb);
		}

		int choice = 0;
		loop: do {
			System.out.println("Would like to Hit again or Stand?" + "\n1:Hit \n2:Stand");
			choice = kb.nextInt();
			switch (choice) {
			case 1:
				player.dealtCard(dealer.deal());
				System.out.println("You now hold:" + player.getHandPlayer().getHandValue());
				if (player.getHandPlayer().getHandValue() > 21) {
					player.playerHandBust();
					playAgain(kb);
					break loop;
				} else if (player.getHandPlayer().getHandValue() == 21) {
					player.playerHandBlackJack();
					playAgain(kb);
					break loop;
				}
				break;
			case 2:
				dealerStartsTurn();
				break;
			default:
				System.out.println("Invalid Entry");
				break;
			}

		} while (choice != 2);

	}

	private void dealerStartsTurn() {

	}

	private void checkWinner() {

	}

	private void playAgain(Scanner kb) {
		System.out.println("Play again? 1: yes, 2: no");
		int choice = kb.nextInt();
		player.getHandPlayer().clear();
		dealer.getHandDealer().clear();

		switch (choice) {

		case 1:
			run();
			break;
		case 2:
			System.out.println("See ya!");
			break;
		default:
			System.out.println("Invalid entry");
			break;
		}

	}
}
