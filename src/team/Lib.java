package team;

import java.util.ArrayList;

import scum.Card;

public class Lib {
	/*
	 * check the type of selected cards or table. eg: 33 or 444 or 6666 or 34567
	 * return the type and the smallest number and the size
	 * the first number : 0 = duplicate, 1 = flush
	 * the second number : the smallest number 
	 * the third number : the size of cards
	 */
	
     public static int[] checkType(ArrayList<Card> selected, int size) 
     {
    	 int[] type = new int[3];
    	 if(size == 1 || selected.get(0).getValue() == selected.get(1).getValue())  type[0] = 0;
    	 else type[0] = 1; 
    	 type[1] = selected.get(0).getValue();
    	 type[2] = size;
    	 return type;
     }
     
     /*
      * check whether the selected cards comply with the rule or not
      * type1 is the cards player selected, type2 is the table cards
      */
     public static boolean checkRule(int[] type1, int[] type2) {
         boolean b = type1[0] == type2[0] && type1[1] > type2[1] && type1[2] == type2[2];
         System.out.println(b);
    	 return b;
     }
     
     /*
      * copy c2 to c1;
      */
     public static void copy(ArrayList<Card> c1, ArrayList<Card> c2) 
     {
    	 c1.clear();
    	 for(int i = 0; i < c2.size(); ++i) 
    	 {
    		 c1.add(c2.get(i));
    	 }
     }
     
     
}
