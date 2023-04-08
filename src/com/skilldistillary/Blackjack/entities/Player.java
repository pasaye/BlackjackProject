package com.skilldistillary.Blackjack.entities;

public class Player {
	private Hand hand;

	public Hand getHandPlayer() {
		return hand;
	}

	public void setHandPlayer(Hand hand) {
		this.hand = hand;
	}

	@Override
	public String toString() {
		return "Player hand=" + hand;
	}

}
