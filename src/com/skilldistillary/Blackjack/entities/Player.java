package com.skilldistillary.Blackjack.entities;

public class Player {
	private BlackjackHand playerHand = new BlackjackHand();

	public Hand getHandPlayer() {
		return playerHand;
	}

	public void setHandPlayer(BlackjackHand hand) {
		this.playerHand = hand;
	}
	
	
	public int checkPlayerScore() {
		return playerHand.getHandValue();
	}
	
	
	public void playerHandBlackJack(int sum) {
		playerHand.isBlackJack(sum);
	}
	
	public void playerHandBust(int sum) {
	
		playerHand.isBust(sum);
	}
	
	
	
	@Override
	public String toString() {
		return "Player hand=" + playerHand;
	}

}
