package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects and then
 * asks the user to pick a card and searches the array of cards for the match to
 * the user's card. To be used as starting code in ICE 1
 * 
 * @author [Arpanjot Kaur Kharoud]
 * @version 1.0
 * @studentNumber [991720256]
 */
public class CardTrick {

    public static void main(String[] args) {
        
        Card[] magicHand = new Card[7];

        // Fill the magic hand with random cards
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            Random random = new Random();
            c.setValue(random.nextInt(13) + 1); // random number between 1 and 13
            c.setSuit(Card.SUITS[random.nextInt(4)]); // random suit
            magicHand[i] = c;
        }

        // Add a lucky card (hard-coded)
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");
        magicHand[0] = luckyCard;

        // Ask the user for a card
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your card value (1-13): ");
        int userValue = scanner.nextInt();
        System.out.print("Enter your card suit (Hearts, Diamonds, Clubs, Spades): ");
        String userSuit = scanner.next();

        // Create the user's card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        // Search for the user's card in magicHand
        boolean found = false;
        for (Card card : magicHand) {
            if (card.equals(userCard)) {
                found = true;
                break;
            }
        }

        // Report the result
        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand!");
        } else {
            System.out.println("Sorry, your card is not in the magic hand. Try again!");
        }
    }
}
