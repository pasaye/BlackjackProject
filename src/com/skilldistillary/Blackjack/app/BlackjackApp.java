package com.skilldistillary.Blackjack.app;

import java.util.Scanner;

import com.skilldistillary.Blackjack.entities.BlackjackHand;
import com.skilldistillary.Blackjack.entities.Card;
import com.skilldistillary.Blackjack.entities.Dealer;
import com.skilldistillary.Blackjack.entities.Deck;
import com.skilldistillary.Blackjack.entities.Hand;
import com.skilldistillary.Blackjack.entities.Player;

public class BlackjackApp {
	private Dealer deal = new Dealer();
	private Player play = new Player();
	private Deck deck = new Deck();
	private Hand hand = new BlackjackHand();
	private BlackjackHand bjh = new BlackjackHand();

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
		if (userChoice == 1) {
			startBlackjack(kb);
		} else {
			System.out.println("GoodBye");
		}

	}

	private void startBlackjack(Scanner kb) {
		System.out.println("Dealer is shuffling...");
		System.out.println();
		deal.shuffleCards();
		System.out.println("Dealer is dealing");

		Card firstCard = deal.deal();
		System.out.println("Players first card: " + firstCard);
		Card dealerFirstCardDown = deal.deal();
		System.out.println("Dealers card face down");
		Card secondCard = deal.deal();
		System.out.println("Players second card: " + secondCard);
		Card dealerSecondCard = deal.deal();
		System.out.println("Dealer second card: " + dealerSecondCard);

		int playerSumOfCards = firstCard.getRank().getCardRank() + secondCard.getRank().getCardRank();
		int dealerSumOfCards = dealerFirstCardDown.getRank().getCardRank() + dealerSecondCard.getRank().getCardRank();

		hitOrStand(kb, playerSumOfCards, dealerSumOfCards, dealerFirstCardDown);

	}

	private void hitOrStand(Scanner kb, int player, int dealer, Card dealerFirstCardDown) {
		System.out.println(player);
		int choice = 0;
	loop:do {
			System.out.println();
			System.out.println("Would you like to Hit or Stand?");
			System.out.println("Enter the number 1 to Hit \nEnter the number 2 to Stand.");
			choice = kb.nextInt();

			switch (choice) {
			case 1:
				Card addCard = deal.dealOnHit();
				int sum = player += addCard.getRank().getCardRank();
				if (sum < 21) {
					System.out.println("Your new card: " + addCard + "\n Your current score is: " + sum);

				} else if (sum == 21) {
					System.out.println("Winner!!!! " + sum);
					play.playerHandBlackJack(sum);
					run();
					break loop;
				} else {
					System.out.println("Your Hand: " + sum);
					play.playerHandBust(sum);
					run();
					break loop;

				}
				break;
			case 2:
				System.out.println("Dealers turn");
				dealerStartsTurn(kb, dealer, dealerFirstCardDown);
				break;
			default:
				System.out.println("Invalid Entry, Please enter the numerical value #1 or #2");
				break;
			}
		} while (choice != 2);
	}

	private void dealerStartsTurn(Scanner kb, int dealer, Card dealerFirstCardDown) {
		System.out.println("Dealer flips card " + dealerFirstCardDown);

	}
}
