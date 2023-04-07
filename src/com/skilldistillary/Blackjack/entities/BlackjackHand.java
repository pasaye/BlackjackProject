package com.skilldistillary.Blackjack.entities;

public class BlackjackHand extends Hand {

	@Override
	public int getHandValue() {
		
		return 0;
	}

	public boolean isBlackJack() {
		return false;
		
	}
	
	
	public boolean isBust() {
		return false;
		
	}
}
