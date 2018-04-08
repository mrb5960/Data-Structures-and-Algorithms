package com.ctci.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Card extends Thread{
	private static int no_of_players;
	private String card_type;
	private String card_number;
	private String[] DENOMINATIONS = {"ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};
	private String[] SUITS = {"DIAMONDS", "CLUBS", "HEARTS", "SPADES"};
	static int share;
	private static int remaining_cards;
	private static ArrayList<Card> deck = new ArrayList<>();
	private static ArrayList<ArrayList<Card>> players = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	static Object o = new Object();
	static int counter = 0;
	int info;
	
	public Card(String type, String num){
		this.card_type = type;
		this.card_number = num;
	}
	
	public Card(int info){this.info =  info;}
	public Card(){}
	
	public void get_card(){
		
	}
	public void init_deck(){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 13; j++){
			Card c = new Card(SUITS[i], DENOMINATIONS[j]);
			deck.add(c);
			}
		}
		Collections.shuffle(deck);
	}
	
	public void shuffle_deck(){
		Collections.shuffle(deck);
	}
	
	public ArrayList<Card> create_hand(int cut){
		ArrayList<Card> hand = new ArrayList<>();
		int partition = share + cut;
		for(int i = share; i < partition; i++){
			if(share < 53){
				share++;
				Card c = deck.get(i);
				hand.add(c);
			}
		}
		return hand;
	}
	
	public void print_players(){
		int size = players.size();
		for(int i = 0; i < size; i++){
			System.out.println();
			ArrayList<Card> hand = players.get(i);
			System.out.println("Player" + (i+1) + "'s hand :");
			for(int j = 0; j < hand.size(); j++){
				Card c = hand.get(j);
				System.out.println(c.card_number + " of " + c.card_type);			
			}
		}
	}
	
	@Override
	public void run(){
		while (true) {
    		synchronized(o){
    			o.notifyAll();
    			if(this.info != counter){
    				try {
    					o.wait();
    				} catch (InterruptedException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    			else{
    				System.out.println(">>>>>> CURRENT THREAD <<<<<<<" + Thread.currentThread().getName());
    				play();
    				while (!sc.next().equals("/n"));
    				//System.out.println("");
    				try {
    					Thread.sleep(500);
    				} catch (InterruptedException e) {
    				}
    				System.out.println("Done looping.");
        			counter++;
        			if(counter == 4)
        				counter = 0;
    			}
    		}
    	}
	}
	
	@SuppressWarnings("resource")
	public void play(){
		Card previous_card = null;
		Card current_card;
		ArrayList<Card> current_run = new ArrayList<>();
		for(int i = 0; i < no_of_players; i++){
			System.out.println("Player" + (i+1) + "'s turn");
			ArrayList<Card> player = players.get(i);
			if(player.size() == 0){
				System.out.println("Player" + (i+1) + " out of cards...pass to next player ");
				System.out.println();
				
				if(i == no_of_players - 1)
					i = -1;
				continue;
			}
			if(player.size() == 52){
				System.out.println("Player" + (i+1) + " wins!!!");
				System.exit(0);
				break;
			}
			current_card = player.remove(0);
			current_run.add(current_card);
			System.out.println("Your card is  " + current_card.card_number + " of " + current_card.card_type);
			System.out.println("You have " + player.size() + " left.");
			System.out.println("Current gain is " + current_run.size() + " cards");
			if(previous_card == null){
				previous_card = current_card;
			}
			else{
				if(current_card.card_type.equals(previous_card.card_type)){
					System.out.println("Previous  :" + previous_card.card_type + "   Current   :" + current_card.card_type);
					System.out.println("Player" + (i+1) + "'s hand...");
					player.addAll(current_run);
					System.out.println("You now have " + player.size() + " cards");
					current_run.clear();
					previous_card = null;
				}
				else
					previous_card = current_card;
			}
			System.out.println("Hit enter...");
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			if(i == no_of_players - 1)
				i = -1;
		}
	}
	
	@SuppressWarnings("resource")
	public static void main(String args[]){
		Card c = new Card();
		c.init_deck();
		System.out.println("Enter the number of players  :   ");
		Scanner sc = new Scanner(System.in);
		no_of_players = Integer.parseInt(sc.nextLine());
		int cut = (int)52/no_of_players;
		remaining_cards = 52 - (no_of_players * cut);
		for(int i = 0; i < no_of_players; i++){
			players.add(c.create_hand(cut));
		}
		int remaining_index = (52 - remaining_cards);
		for(int i = 0; i < players.size(); i++){
			if(remaining_index < 52){
				ArrayList<Card> hand = players.get(i);
				hand.add(deck.get(remaining_index));
				remaining_index++;
			}
			else
				break;
		}
		c.print_players();
		
		for(int i = 1; i < 5; i++){
			new Thread(new Card()).start();
		}
	}
}
