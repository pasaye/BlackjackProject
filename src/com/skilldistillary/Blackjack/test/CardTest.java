package com.skilldistillary.Blackjack.test;

import com.skilldistillary.Blackjack.entities.Rank;
import com.skilldistillary.Blackjack.entities.Suit;

public class CardTest {
  public static void main(String[] args) {
    Rank[] ranks = Rank.values();
    for(int i=0; i<ranks.length; i++) {
      System.out.println(ranks[i] + " " + ranks[i].getCardRank());
    }
    
    for(Suit s : Suit.values()){
      System.out.println(s);
    }
  }
}
