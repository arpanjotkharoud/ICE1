import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects and then
 * searches the array of cards for a hard-coded lucky card and the user's card.
 * If either card is found, it reports a winning message; otherwise, it reports
 * a losing message.
 * 
 * @author [Arpanjot kaur kharoud]
 * @version 1.0
 * @studentNumber [991720256]
 */
public class CardTrick {

    public static void main(String[] args) {

        // Create a magic hand of 7 cards
        Card[] magicHand = new Card[7];

        // Fill the magic hand with random cards
        Random random = new Random();
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1); // random number between 1 and 13
            c.setSuit(Card.SUITS[random.nextInt(4)]); // random suit
            magicHand[i] = c;
        }

        // Add a lucky card (hard-coded)
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");

        // Ask the user for a card
        Scanner scanner = new Scanner(System.in);

        // Validate user input for card value
        int userValue;
        do {
            System.out.print("Enter your card value (1-13): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 13.");
                scanner.next(); // consume the invalid input
            }
            userValue = scanner.nextInt();
        } while (userValue < 1 || userValue > 13);

        // Validate user input for card suit
        System.out.print("Enter your card suit (Hearts, Diamonds, Clubs, Spades): ");
        String userSuit;
        do {
            userSuit = scanner.next();
            if (!Card.isValidSuit(userSuit)) {
                System.out.println("Invalid input. Please enter a valid suit.");
            }
        } while (!Card.isValidSuit(userSuit));

        // Create the user's card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);

        // Search for the user's card in magicHand
        boolean foundUserCard = searchForCard(magicHand, userCard);

        // Report the result for the user's card
        reportResult(foundUserCard, "your card");

        // Search for the lucky card in magicHand
        boolean foundLuckyCard = searchForCard(magicHand, luckyCard);

        // Report the result for the lucky card
        reportResult(foundLuckyCard, "the lucky card");
    }

    /**
     * Searches for a specific card in an array of cards.
     * 
     * @param cards The array of cards to search.
     * @param targetCard The card to search for.
     * @return true if the card is found, false otherwise.
     */
    private static boolean searchForCard(Card[] cards, Card targetCard) {
        for (Card card : cards) {
            if (card.equals(targetCard)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Reports the result of the card search.
     * 
     * @param found Whether the card was found or not.
     * @param cardDescription Description of the card (e.g., "your card").
     */
    private static void reportResult(boolean found, String cardDescription) {
        if (found) {
            System.out.println("Congratulations! The " + cardDescription + " is in the magic hand!");
        } else {
            System.out.println("Sorry, the " + cardDescription + " is not in the magic hand. Better luck next time!");
        }
    }

    /**
     * Inner class representing a playing card.
     */
    static class Card {

        private int value;
        private String suit;

        // Valid suits for a standard deck of cards
        public static final String[] SUITS = { "Hearts", "Diamonds", "Clubs", "Spades" };

        /**
         * Constructs a Card object with default values.
         */
        public Card() {
            this.value = 1; // Default value
            this.suit = "Hearts"; // Default suit
        }

        /**
         * Gets the value of the card.
         * 
         * @return The value of the card.
         */
        public int getValue() {
            return value;
        }

        /**
         * Sets the value of the card.
         * 
         * @param value The value to set.
         */
        public void setValue(int value) {
            this.value = value;
        }

        /**
         * Gets the suit of the card.
         * 
         * @return The suit of the card.
         */
        public String getSuit() {
            return suit;
        }

        /**
         * Sets the suit of the card.
         * 
         * @param suit The suit to set.
         */
        public void setSuit(String suit) {
            this.suit = suit;
        }

        /**
         * Checks if the given suit is valid.
         * 
         * @param suit The suit to check.
         * @return true if the suit is valid, false otherwise.
         */
        public static boolean isValidSuit(String suit) {
            for (String validSuit : SUITS) {
                if (validSuit.equalsIgnoreCase(suit)) {
                    return true;
                }
            }
            return false;
        }

        /**
         * Checks if two cards are equal based on value and suit.
         * 
         * @param otherCard The other card to compare.
         * @return true if the cards are equal, false otherwise.
         */
        public boolean equals(Card otherCard) {
            return this.value == otherCard.value && this.suit.equalsIgnoreCase(otherCard.suit);
        }
    }
}
