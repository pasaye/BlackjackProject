package com.skilldistillary.Blackjack.app;

import java.util.Scanner;

import com.skilldistillary.Blackjack.entities.Card;
import com.skilldistillary.Blackjack.entities.Dealer;

public class BlackjackApp {
	private Dealer deal = new Dealer();
	
	public static void main(String[] args) {
		BlackjackApp deal = new BlackjackApp();
		deal.run();
		
	}

	public void run() {
		Scanner kb = new Scanner(System.in);
		displayWelcome(kb);	
	}
	
	
	public void displayWelcome(Scanner kb) {
		System.out.println("Lets Play");
		System.out.println("Please Enter \n1: To Play \n2: To quit");
		int userChoice = kb.nextInt();
		kb.nextLine();
		if(userChoice == 1) {
			startBlackjack(kb);
		}else {
				System.out.println("GoodBye");
		}
		
	}

	private  void startBlackjack(Scanner kb) {
		System.out.println("Dealer is shuffling...");
		System.out.println();
		deal.shuffleCards();
		System.out.println("Dealer is dealing");
		
		System.out.println(deal.deal());
		
		
		
//		int sumOfCards = 0;
//		for(int cardNum = 0; cardNum < numCard; cardNum++) {
//			Card dealtCard = deck.deal();
//			sumOfCards += dealtCard.getRank().getCardRank();
//			System.out.println("you now have " + dealtCard+ " " + "sum of cards "+ sumOfCards+ " "+ deck.deckSize() + " Cards left");
//		}
//		
	
		
	}

}
