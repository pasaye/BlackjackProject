package com.skilldistillary.Blackjack.test;

import java.util.Scanner;

import com.skilldistillary.Blackjack.entities.Card;
import com.skilldistillary.Blackjack.entities.Deck;

public class DealingTest {

	public static void main(String[] args) {
		DealingTest dealer = new DealingTest();
		dealer.run();

	}

	public void run() {
		Deck deck = new Deck();
		System.out.println("Card number: " + deck.deckSize());
		
	
		
		
		Scanner kb = new Scanner(System.in);
		System.out.print("How many cards");
		deck.mixCards();
		int numCard = kb.nextInt();
		kb.nextLine();
		
		int sumOfCards = 0;
		for(int cardNum = 0; cardNum < numCard; cardNum++) {
			Card dealtCard = deck.deal();
			sumOfCards += dealtCard.getRank().getCardRank();
			System.out.println("you now have " + dealtCard+ " " + "sum of cards "+ sumOfCards+ " "+ deck.deckSize() + " Cards left");
		}
		kb.close();
	}

}
