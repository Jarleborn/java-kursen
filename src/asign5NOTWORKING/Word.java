package asign5;

/**
 * Created by hampus on 2016-09-21.
 */
public class Word implements Comparable<Word> {
    private String word;

    public Word(String str) { word = str; }
    public String toString() { return word; }
    /* Override Object methods */
    @Override
    public int hashCode() { return word.toLowerCase().hashCode(); }
    @Override
    public boolean equals(Object other) {
        if(other instanceof Word){
        return word.toLowerCase().equals(other.toString().toLowerCase()); }
        else{
            return false;
        }
    }
    /* Implement Comparable */
    public int compareTo(Word w) {
        return word.compareToIgnoreCase(w.toString());
    }
}

