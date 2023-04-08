package com.skilldistillary.Blackjack.entities;

import java.util.List;

public class Dealer extends Player {

	private Deck deck;
	private BlackjackHand dealerHand;

	public Dealer() {
		deck = new Deck();
		dealerHand = new BlackjackHand();

	}

	public void shuffleCards() {
		deck.mixCards();
	}

	public Card deal() {
		Card dealtHand = deck.deal();
		return dealtHand;
	}
	
	
	
	public int checkDealerScore() {
		return dealerHand.getHandValue();
	}

	
	public Card dealOnHit() {
		Card newCard = deck.deal();
		
		return newCard;
	}

	public void dealerHandBlackJack() {
		dealerHand.isBlackJack();
	}
	
	public void dealerHandBust(int sum) {
	
		dealerHand.isBust(sum);
	}
	
	
	
	
	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Hand getHandDealer() {
		return dealerHand;
	}

	public void setHandDealer(BlackjackHand hand) {
		this.dealerHand = hand;
	}

	@Override
	public String toString() {
		return "Dealer [deck=" + deck + ", dealerHand=" + dealerHand + "]";
	}

}
