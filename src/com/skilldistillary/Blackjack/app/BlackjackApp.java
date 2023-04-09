package com.skilldistillary.Blackjack.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillary.Blackjack.entities.Card;
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
		
		
		
		dealer.addPlayerCard(dealer.deal());
		System.out.println("Players first card: " + dealer);
		
		dealer.addDealerCard(dealer.deal());
		System.out.println("Dealers first card: face down");
		
		dealer.addPlayerCard(dealer.deal());
		System.out.println("Players second card: " + dealer);
		
		dealer.addDealerCard(dealer.deal());
		System.out.println("Dealer second card: " + dealer);
		
		
//		Card firstCard = dealer.deal();
//		Card dealerFirstCardDown = dealer.deal();
//		Card secondCard = dealer.deal();
//		System.out.println("Players second card: " + secondCard);
//		Card dealerSecondCard = dealer.deal();
//		System.out.println("Dealer second card: " + dealerSecondCard);
//
//		int playerSumOfCards = firstCard.getRank().getCardRank() + secondCard.getRank().getCardRank();
//		int dealerSumOfCards = dealerFirstCardDown.getRank().getCardRank() + dealerSecondCard.getRank().getCardRank();

		hitOrStand(kb);

	}

	private void hitOrStand(Scanner kb) {
		
			
	}

	private void dealerStartsTurn() { 
		
	}
	
		
	private void checkWinner() {
		
		
		
	}
}
