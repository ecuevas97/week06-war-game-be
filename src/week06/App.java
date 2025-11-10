package week06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Final Project: Simple automated version of the card game WAR.
 * App class with main method.
 */
public class App {

    public static void main(String[] args) {

        // 1. Instantiate a Deck and two Players
        Deck deck = new Deck();
        deck.shuffle();

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // 2. Deal the cards: 52 draws total, alternating between players
        for (int i = 0; i < 52; i++) {
            if (i % 2 == 0) {
                player1.draw(deck);
            } else {
                player2.draw(deck);
            }
        }

        System.out.println("Starting the game of War!");
        System.out.println("-------------------------------");
        System.out.println(player1.getName() + " and " + player2.getName() + " have 26 cards each.");
        System.out.println();

        // 3. Play 26 rounds using flip()
        for (int i = 0; i < 26; i++) {
            System.out.println("Round " + (i + 1) + ":");

            Card card1 = player1.flip();
            Card card2 = player2.flip();

            System.out.print(player1.getName() + " plays: ");
            card1.describe();

            System.out.print(player2.getName() + " plays: ");
            card2.describe();

            if (card1.getValue() > card2.getValue()) {
                player1.incrementScore();
                System.out.println("→ " + player1.getName() + " wins this round!");
            } else if (card2.getValue() > card1.getValue()) {
                player2.incrementScore();
                System.out.println("→ " + player2.getName() + " wins this round!");
            } else {
                System.out.println("→ Tie: no point awarded.");
            }

            System.out.println("Current score: "
                    + player1.getName() + " = " + player1.getScore()
                    + ", " + player2.getName() + " = " + player2.getScore());
            System.out.println("-------------------------------");
        }

        // 4. Compare final scores and print the winner
        System.out.println("Final Score:");
        System.out.println(player1.getName() + ": " + player1.getScore());
        System.out.println(player2.getName() + ": " + player2.getScore());

        if (player1.getScore() > player2.getScore()) {
            System.out.println(player1.getName() + " wins the game! 🎉");
        } else if (player2.getScore() > player1.getScore()) {
            System.out.println(player2.getName() + " wins the game! 🎉");
        } else {
            System.out.println("The game is a draw! 🤝");
        }
    }
}

/**
 * Card class
 * - value: 2–14 (2–10, J, Q, K, A)
 * - name: "Ace of Diamonds", "Two of Hearts", etc.
 */
class Card {

    private int value;
    private String name;

    public Card(int value, String name) {
        this.value = value;
        this.name = name;
    }

    // Getters and Setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // describe() prints information about the card
    public void describe() {
        System.out.println(name + " (value: " + value + ")");
    }
}

/**
 * Deck class
 * - cards: List of Card
 * - constructor fills the deck with 52 standard cards
 * - shuffle(): randomizes order
 * - draw(): removes and returns the top card
 */
class Deck {

    private List<Card> cards = new ArrayList<>();

    public Deck() {
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "Two", "Three", "Four", "Five", "Six", "Seven",
                           "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace" };
        int[] values = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

        // Populate the deck with 52 cards
        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                String name = ranks[i] + " of " + suit;
                int value = values[i];
                cards.add(new Card(value, name));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null; // should not happen in this controlled game
    }
}

/**
 * Player class
 * - hand: List of Card
 * - score: starts at 0
 * - name: player's name
 */
class Player {

    private List<Card> hand = new ArrayList<>();
    private int score;
    private String name;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    // describe player and their hand
    public void describe() {
        System.out.println("Player: " + name + " | Score: " + score);
        System.out.println("Hand:");
        for (Card card : hand) {
            card.describe();
        }
    }

    // flip: remove and return the top card
    public Card flip() {
        if (!hand.isEmpty()) {
            return hand.remove(0);
        }
        return null;
    }

    // draw: take a card from the given deck
    public void draw(Deck deck) {
        Card drawnCard = deck.draw();
        if (drawnCard != null) {
            hand.add(drawnCard);
        }
    }

    // incrementScore: add 1 to score
    public void incrementScore() {
        score++;
    }

    // Getters
    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
