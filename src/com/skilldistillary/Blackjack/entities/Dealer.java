package com.skilldistillary.Blackjack.entities;

import java.util.List;

public class Dealer extends Player {

	private Deck deck;
	private BlackjackHand dealerHand;

	public Dealer() {
		super();
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
	
	public void addDealerCard(Card card) {
		dealerHand.addCard(card);
	}

	
	public void dealerHandBlackJack() {
		dealerHand.isBlackJack();
	}
	
	public void dealerHandBust() {
	
		dealerHand.isBust();
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
		return "Dealt is " + dealerHand;
	}

}
