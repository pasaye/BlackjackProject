package com.skilldistillary.Blackjack.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillary.Blackjack.entities.Dealer;
import com.skilldistillary.Blackjack.entities.Player;

public class BlackjackApp {

	private Dealer dealer = new Dealer();
	private Player player = new Player();
	private final int MIN_DECK = 12;

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
		try {
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
				run();
				break;
			}

		} catch (InputMismatchException e) {
			System.out.println("Try again Numbers 1 or 2 only");
			run();
		}

	}

	private void startBlackjack(Scanner kb) {
		System.out.println("Dealer is shuffling...");
		dealer.shuffleCards();
		System.out.println("Dealer is dealing");

		player.dealtCard(dealer.deal());
		System.out.println(player);

		System.out.println("Dealers first card: face down");

		player.dealtCard(dealer.deal());
		System.out.println(player);

		dealer.addDealerCard(dealer.deal());
		System.out.println(dealer);

		System.out.println("Player total:" + player.getHandPlayer().getHandValue());
		if (player.getHandPlayer().getHandValue() == 21 || player.getHandPlayer().getHandValue() > 21) {
			blackjackOrBust(kb);
		} else {
			try {
				System.out.println("What would you like to do? \n 1:Hit \n 2:Stand");
				int choice = kb.nextInt();
				switch (choice) {
				case 1:
					hitOrStand(kb);
					break;
				case 2:
					dealerStartsTurn(kb);
					break;
				default:
					System.out.println("Invalid Entry. Please enter numerical value #1 or #2. ");
					break;

				}
			} catch (InputMismatchException e) {
				System.out.println("Enter 1 or 2 \nLose all save data \nStart Over.");
			}
		}

	}

	private void hitOrStand(Scanner kb) {
		System.out.println(player.getHandPlayer());
		System.out.println("  Current score:" + player.getHandPlayer().getHandValue());

		player.dealtCard(dealer.deal());
		System.out.println(player);
		System.out.println("New total " + player.getHandPlayer().getHandValue());
		if (player.getHandPlayer().getHandValue() == 21 || player.getHandPlayer().getHandValue() > 21) {
			blackjackOrBust(kb);

		}
		if (dealer.checkSize() > MIN_DECK) {

			int choice = 0;
			loop: do {
				System.out.println("Would like to Hit again or Stand?" + "\n1:Hit \n2:Stand");
				choice = kb.nextInt();
				switch (choice) {
				case 1:
					player.dealtCard(dealer.deal());
					System.out.println("You now hold:" + player.getHandPlayer().getHandValue());
					blackjackOrBust(kb);
					playAgain(kb);
					break loop;
				case 2:
					dealerStartsTurn(kb);
					break;
				default:
					System.out.println("Invalid Entry");
					break;
				}

			} while (choice != 2);
		}

	}

	private void dealerStartsTurn(Scanner kb) {
		dealer.addDealerCard(dealer.deal());
		System.out.println("Dealer revealing hand...");
		System.out.println(dealer.getHandDealer() + "Total: " + dealer.getHandDealer().getHandValue());

		if (dealer.getHandDealer().getHandValue() < 17) {

			while (dealer.getHandDealer().getHandValue() < 17) {
				dealer.addDealerCard(dealer.deal());
				System.out.println(dealer + " \n dealer total: " + dealer.getHandDealer().getHandValue());
				checkWinner();
				blackjackOrBust(kb);
			}
		} else {
			checkWinner();
			blackjackOrBust(kb);
		}

	}

	private void checkWinner() {
		if (dealer.getHandDealer().getHandValue() > player.getHandPlayer().getHandValue()
				&& dealer.getHandDealer().getHandValue() < 21) {
			System.out.println("house wins!");
			System.out.println("Dealer wins with: " + dealer.getHandDealer() + " \nTotal: "
					+ dealer.getHandDealer().getHandValue());
		} else if (dealer.getHandDealer().getHandValue() < player.getHandPlayer().getHandValue()
				&& player.getHandPlayer().getHandValue() < 21) {
			System.out.println("Player wins!");
			System.out.println("Player wins with: " + player.getHandPlayer() + " \nTotal: "
					+ player.getHandPlayer().getHandValue());
		}

	}

	private void blackjackOrBust(Scanner kb) {
		player.playerHandBust();
		player.playerHandBlackJack();
		dealer.dealerHandBust();
		dealer.dealerHandBlackJack();
		playAgain(kb);
	}

	private void playAgain(Scanner kb) {
		player.getHandPlayer().clear();
		dealer.getHandDealer().clear();

		if (dealer.checkSize() < MIN_DECK) {
			System.out.println("Game Over, Start new game.");

		} else {
			System.out.println("Play again? 1: yes, 2: no");
			int choice = kb.nextInt();

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
}
