package team;


import java.util.ArrayList;
import java.util.Scanner;

import team.Card;
import team.Lib;

public class Player1 {
     ArrayList<Card> hand = new ArrayList<Card>();
     ArrayList<Card>[] h = new ArrayList[16];
     ArrayList<Card> table = new ArrayList<Card>();
     
     String name;
     
     
     public Player1(String s) 
     {
    	 name = s;
    	 for(int i = 0; i < 16; ++i) 
    	 {
    		 h[i] = new ArrayList<Card>();
    	 }
     }
     

	
     /*
      * player play cards in turn
      * return true if the cards they play is correct
      * return false if the cards they play is wrong
      */
     
     
     public boolean playCards(ArrayList<Card> t) 
     {
    	 if(table.size() == 0 || t.size() == 0) {Lib.copy(t, table);; return true;}
    	 if(Lib.checkRule(Lib.checkType(table, table.size()),Lib.checkType(t, t.size()))) 
    	 {
    		 Lib.copy(t, table);;
    		 hand.removeAll(table); 
    		 return true;
    	 }
    	 else return false;
    	 
     }
}
