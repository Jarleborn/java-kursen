package asign1;

/**
 * Created by hampus on 2016-09-09.
 */
public class PlayCardsMain {
    public static void main(String[] args) {
        System.out.println("Picking up the deck");
        Deck theDeck = new Deck();
        System.out.println("Shuffeling it");
        theDeck.shuffle();

        System.out.println("And here comes the cards");
        System.out.println("\n");
        theDeck.handOutNextCard();
        theDeck.handOutNextCard();
        theDeck.handOutNextCard();
        theDeck.handOutNextCard();
        theDeck.handOutNextCard();
        System.out.println("\n");

        System.out.println("Well, thats a poker hand, hope it where good");
    }
}
