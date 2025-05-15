//package linkedLists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;




public class CardGame {
	
	private static LinkList cardList = new LinkList();  // make list

	public static void main(String[] args) {

		// File name to read from
        String fileName = "cards.txt"; // Ensure the file is in the working directory or specify the full path

        // Read the file and create Card objects
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into components
                String[] details = line.split(","); // Assuming comma-separated values
                if (details.length == 4) {
                    // Parse card details
                    String suit = details[0].trim();
                    String name = details[1].trim();
                    int value = Integer.parseInt(details[2].trim());
                    String pic = details[3].trim();

                    // Create a new Card object
                    Card card = new Card(suit, name, value, pic);

                    // Add the Card object to the list
                    cardList.add(card);
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Print the loaded cards
        System.out.println("Cards loaded:");
        cardList.displayList();

        Card[] player1Hand = new Card[5];
        Card[] player2Hand = new Card[5];

        for (int i = 0; i < 5; i++) {
            player1Hand[i] = cardList.getFirst();
            player2Hand[i] = cardList.getFirst();
        }

        System.out.println("Player 1 Hand:");
        for (int i = 0; i < 5; i++) 
            System.out.println(player1Hand[i]);

            System.out.println("Player 2 Hand:");
        for (int i = 0; i < 5; i++) 
            System.out.println(player2Hand[i]);

            int player1Score = 0;
            int player2Score = 0;

             System.out.println(" Game Start ");

             for (int i = 0; i < 5; i++) {
                Card p1Card = player1Hand[i];
                Card p2Card = player2Hand[i];
             

              System.out.println(" Round " + (i + 1) + ":");
              System.out.println("Player 1 plays:" + p1Card);
              System.out.println("Player 2 plays:" + p2Card);

             if (p1Card.getCardValue() > p2Card.getCardValue()) {
                System.out.println(" Player 1 wins the round! ");
                player1Score++;
              } else if (p2Card.getCardValue() > p1Card.getCardValue()) {
                System.out.println(" Player 2 wins the round! ");
                player2Score++;
              }else {
                System.out.println(" Its a tie");

              }
              System.out.println();

            }

		System.out.println(" Final Score ");
		System.out.println("Player 1: " + player1Score);
        System.out.println("Player 2: " + player2Score);

        if (player1Score > player2Score) {
            System.out.println(" Player 1 wins the game! ");
        } else if (player2Score > player1Score)  {
            System.out.println(" Player 2 wins the game! ");
        } else {
             System.out.println(" Its a tie! ");
        }


        System.out.println();
        System.out.println(" The deck ");
		cardList.displayList();

	}//end main

}//end class
