package asign1;

/**
 * Created by hampus on 2016-09-09.
 */
public class Card {
    public enum Suite{
        Spades,
        Hearts,
        Clubes,
        Diamonds;
    }

    public enum RankValue{
        Ace (1),
        Two (2),
        Thre (3),
        Four (4),
        Five (5),
        Six (6),
        Seven (7),
        Eight (8),
        Nine (9),
        Ten (10),
        Knight (11),
        Queen (12),
        King (13);

        int value;
        RankValue(int val){
            value = val;
        }

    }

    private Suite _suite;
    private RankValue _rankValue;

    public Card(Suite suite, RankValue rankValue){
        _suite = suite;
        _rankValue = rankValue;
    }

    public Suite getSuit(){
        return this._suite;
    }

    public RankValue getRankValue(){
        return this._rankValue;
    }

    public String toString(){
        return this.getRankValue() + " of " + this.getSuit();
    }
}
