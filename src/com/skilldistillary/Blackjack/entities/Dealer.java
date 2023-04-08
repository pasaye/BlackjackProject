package com.skilldistillary.Blackjack.entities;

import java.util.List;

public class Dealer extends Player {
	
	private Deck deck;
	private BlackjackHand hand;
	
	
	public Dealer() {
		deck= new Deck();
		hand= new BlackjackHand();
		
	}
	
	
	
	public void shuffleCards() {
		deck.mixCards();
	}
	
	public Card deal() {
		Card dealtHand = deck.deal();
		return dealtHand;
	}


	public Deck getDeck() {
		return deck;
	}


	public void setDeck(Deck deck) {
		this.deck = deck;
	}


	public Hand getHandDealer() {
		return hand;
	}


	public void setHandDealer(BlackjackHand hand) {
		this.hand = hand;
	}
	
	
	
	

}
