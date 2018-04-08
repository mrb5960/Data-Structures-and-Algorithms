package com.ctci.design.cardgame;

import java.util.HashMap;
import java.util.Map;

public class Temp {

	public enum Suit{
		Club(0), Diamond(1), Heart(2), Spade(3);
		private int value;
		
		private static Map<Integer, Suit> map = new HashMap<Integer, Suit>();
		
		static{
			for(Suit suit: Suit.values()){
				map.put(suit.value, suit);
			}
		}
		
		private Suit(int v){
			value = v;
		}
		
		public int getValue(){
			return value;
		}
		
		public static Suit getSuitFromValue(int value){
			return map.get(value);
		}
	}
	
	public abstract class Card{
		
		protected int faceValue;
		protected Suit suit;
		
		public Card(int face, Suit s){
			faceValue = face;
			suit = s;
		}
	}
	public static void main(String[] args) {
		
	}

}
