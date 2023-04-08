package com.skilldistillary.Blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	
	protected List<Card> cards = new ArrayList<>();
	
	public Hand() {
		
	}
	
	public Hand(List<Card> cards) {
		this.cards = cards;
		
	}
	
	
	public void addCard(Card card) {
		cards.add (card);
		
	}

	
	public void clear() {
		cards.clear();
		
	}
	
	
	public abstract int getHandValue();
	
	
	public List<Card> getCards() {
		return cards;
	}


	public void setCards(List<Card> cards) {
		this.cards = cards;
	}


	@Override
	public String toString() {
		return "Hand: " + cards;
	}
	
	
	
}
