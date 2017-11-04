package ua.nure.zabara.Practice6.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// you can extend this class from one of the core container
// or aggregate it inside of class 
public class WordContainer {  

    List<Word> lWord= new ArrayList<>();


    public void setString(String console){

        Pattern p= Pattern.compile("\\w+");
        Matcher m = p.matcher(console);
        Word w;

        while (m.find()){
            w=new Word(m.group());
            addWord(w);

        }
    }

    public void addWord(Word w){
        System.out.println("-----");

        for (Word word:lWord) {
            if (w.equals(word)) {
                word.incFrequency();
                return;
            }
        }
        lWord.add(w);

    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for (Word w:
             lWord) {
            sb.append(w.toString()+"\n");
        }

        return sb.toString();
    }
}
