package com.skilldistillary.Blackjack.entities;

import java.util.List;

public class Player {
	
	private BlackjackHand playerHand;
	
	public Player() {
		this.playerHand = new BlackjackHand();
	}

	public void playerHandBlackJack() {
		playerHand.isBlackJack();
	}
	
	public void playerHandBust() {
	
		playerHand.isBust();
	}

	public Hand getHandPlayer() {
		return playerHand;
	}
	
	public void setHandPlayer(BlackjackHand hand) {
		this.playerHand = hand;
	}
	
//	@Override
//	public String toString() {
//		return "Player hand=" + playerHand;
//	}

}
