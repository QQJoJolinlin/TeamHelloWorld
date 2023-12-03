package team;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AiPlayer extends Player1 {

	public AiPlayer(String s) {
		super(s);
		convertHand();
		// TODO Auto-generated constructor stub
	}
	
	
	/*
     * convert the hand of Ai in different data structure that is easier to select card.
     */
    public void convertHand() 
    {
   	for(Card c : hand) 
   	{
   		h[c.value].add(c);
   	}
    }
	
	/*
     * select the cards that can play
     */
	
	public void selectCard(ArrayList<Card> t)
    {
   	 for(int i = 0; i < table.size(); ++i) 
   	 {
   		 table.get(i).setVisible(false);
   	 }
   	 if(table.equals(t))
   	 {
   		 table.clear();
   		 for(int i = 3; i < h.length; ++i) 
   		 {
   			 if(h[i].size() != 0) 
   			 {
   				 table.add(h[i].remove(0));
   				 
   				 break;
   			 }
   			 
   		 }
   	 }
   	 else
   	 {
   		 table.clear();
   		 int[] f = Lib.checkType(t, t.size());
   		 int a = f[0]; int b = f[1]; int c = f[2];
   		 if(b == 15) return ;
   		 /*
   		  * if the table is duplicate pattern eg: 3, 44, 555, or 6666
   		  */
   		 if(a == 0) 
   		 {
   			 for(int i = b+1; i < 16; ++i) 
   			 {
   				 if(h[i].size() >= c)
   				 {
   					 for(int j = 0; j < c; ++j) 
   					 {
   						table.add(h[i].remove(0));
   						 
   					 }
   				   break;
   				 }
   				
   			 }
   		 }
   		 /*
   		  * if table is flush
   		  */
   		 else 
   		 {
   			 if(b+c >= 16) return;
   			 for(int i = b+1; i < b+1+c; ++i) 
   			 {
   				 if(h[i].size() == 0) return;
   			 }
   			 for(int i = b+1; i < b+1+c; ++i) 
  			 {
  				 table.add(h[i].remove(0));
  				 
  			 }
   		 }
   	 }
   	  Lib.copy(t, table);;
   	  return;
    }

    
    
}
