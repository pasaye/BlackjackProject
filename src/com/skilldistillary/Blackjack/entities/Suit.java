package com.skilldistillary.Blackjack.entities;

public enum Suit {
	HEARTS("Hearts"),
	SPADES("Spades"),
	CLUBS("Clubs"),
	DIAMONDS("Diamonds");
	
	
	final private String cardSuit;

	Suit(String cardSuit) {
		this.cardSuit = cardSuit;
	}
	
	
	@Override
	public String toString() {
		return cardSuit;
	}
	
	
	public String getCardSuit() {
		return cardSuit;
	}

}
