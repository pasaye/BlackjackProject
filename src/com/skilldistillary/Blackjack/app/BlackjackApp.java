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

	public static void main(String[] args) {
		BlackjackApp deal = new BlackjackApp();
		deal.run();

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
		System.out.println("Players first card:" + firstCard);
		Card dealerFirstCardDown = deal.deal();
		System.out.println("Dealers card face down");
		Card secondCard = deal.deal();
		System.out.println("Players second card:" + secondCard);
		Card dealerSecondCard = deal.deal();
		System.out.println("Dealer second card: " + dealerSecondCard);

		
		int playerSumOfCards = firstCard.getRank().getCardRank() + secondCard.getRank().getCardRank();
		int dealerSumOfCards = dealerFirstCardDown.getRank().getCardRank() + dealerSecondCard.getRank().getCardRank();
		
		System.out.println(playerSumOfCards);
		

	}
	
	
	private void hitOrStand() {
		
	}

}
