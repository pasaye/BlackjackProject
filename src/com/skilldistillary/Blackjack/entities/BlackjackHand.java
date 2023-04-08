package com.skilldistillary.Blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class BlackjackHand extends Hand {
	
	
	

	public BlackjackHand() {
		super();
		
		
	}

	@Override
	public int getHandValue() {
		int i = 0;
		for (Card card : cards) {
			i += card.getRank().getCardRank();
		}
		return i;
	}

	public boolean isBlackJack() {
		if(getHandValue()== 21) {
			System.out.println("BLACKJACK!!!!");
			return true;
		} else {
			return false;
			
		}
		
		
	}
	
	
	public boolean isBust() {
		if(getHandValue() > 21) {
			System.out.println("BUST!!! YOU LOSE!!!");
			return true;
		}else {
			return false;
			
		}
	}

	@Override
	public String toString() {
		return "BlackjackHand [cards=" + cards + "]";
	}
	
	
	
}
