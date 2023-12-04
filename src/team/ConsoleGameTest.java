package team;

import java.util.Scanner;

public class ConsoleGameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		String[] names = new String[4];
		
		for(int i = 0; i < names.length; i++) {
			System.out.println("Enter Player " + (i + 1) + " name");
			names[i] = scnr.nextLine();
		}
		
		for(int i = 0; i < names.length; i++) {
			System.out.println("Player " + (i + 1) + ": " + names[i]);
		}
		
		System.out.println();
		
		Game game = new Game(names);
		
		game.play(scnr);

	}

}
