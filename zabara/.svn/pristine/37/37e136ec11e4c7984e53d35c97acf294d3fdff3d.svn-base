package ua.nure.zabara.Practice6.part6;

public class Word implements Comparable{

    private String word;
    public int length;
    private int frequency=0;

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }


    public Word(String word) {
        this.word = word;
        frequency = 1;
        length=this.word.length();
    }

    public void incFrequency(){
        frequency++;
    }


    @Override
    public boolean equals(Object o) {
        Word w=(Word)o;

        if (o == null) {
            return false;
        }
        if(word.equals(w.word)){
            return true;
        }
        return false;
    }




    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return word+" : "+frequency;
    }
}
