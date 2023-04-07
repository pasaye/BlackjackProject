package com.skilldistillary.Blackjack.entities;

import java.util.List;

public abstract class Hand {
	
	List<Card> cards;
	
	
	public Hand() {
		
	}
	
	
	public void addCard(List<Card> cards) {
		
	}

	
	public void clear() {
		
	}
	
	
	public abstract int getHandValue();


	@Override
	public String toString() {
		return "Hand [cards=" + cards + "]";
	}
	
	
	
}
