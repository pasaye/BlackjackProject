package com.skilldistillary.Blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cardsInDeck = new ArrayList<>();

	public Deck() {
		Rank[] ranks = Rank.values();
		Suit[] suits = Suit.values();

		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				Card card = new Card(suit, rank);
				cardsInDeck.add(card);
			}
		}
	}

	public int deckSize() {
		return cardsInDeck.size();
	}

	public void mixCards() {
		Collections.shuffle(cardsInDeck);
	}

	public Card deal() {

		return cardsInDeck.remove(0);

	}

	public List<Card> getCardsInDeck() {
		return cardsInDeck;
	}

}
