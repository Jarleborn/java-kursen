package asign1;

/**
 * Created by hampus on 2016-09-09.
 */
public class Play123Main {
    public static void main(String[] args) {
        int wining = 0;
        int loos = 0;
        double chance;
        for (int i = 0; i <= 999; i++) {
            if(Play123()){
                wining++;
            }
            else{
                loos++;
            }
        }


        if(loos == 0){
            chance = 100;
        }
        else {
            chance = (loos * 1.0 / wining) * 100;
        }

        System.out.println("You have played the game 1000 times");
        System.out.println("You won "+wining+" times");
        System.out.println("You lost "+loos+" times");
        System.out.println("And the chance to win is "+ String.format("%.2f", chance) +"%");

    }

    public static boolean Play123(){
        Deck deck = new Deck();
        deck.shuffle();

        for (int i = 0; i < 3 ; i++) {
            Card theCard = deck.handOutNextCard();
            //System.out.println("Your card is: " + theCard + "    ||     And the counting is on " + i);
            if(theCard.getRankValue().value == i){
                return false;
            }
        }
        return true;
    }
}
