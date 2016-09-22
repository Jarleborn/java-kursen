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
    public int hashCode() { return word.hashCode(); }
    @Override
    public boolean equals(Object other) {
        return word.toLowerCase().hashCode() == other.toString().toLowerCase().hashCode(); }
    /* Implement Comparable */
    public int compareTo(Word w) {
        return word.compareToIgnoreCase(w.toString());
    }
}

