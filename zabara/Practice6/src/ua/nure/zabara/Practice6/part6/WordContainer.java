package ua.nure.zabara.Practice6.part6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        for (Word word:lWord) {
            if (w.equals(word)) {
                word.incFrequency();
                return;
            }
        }
        lWord.add(w);
    }
    public void frequency(){
        CmpFrequency cmpFreq=new CmpFrequency();
        Collections.sort(lWord,cmpFreq);
        int i=0;
        for (Word w:lWord) {
            if(i<3) {
                System.out.println(w.toString());
                i++;
            }
        }
    }
    public void maxLength(){
        CmpLength cmpLen=new CmpLength();
        Collections.sort(lWord,cmpLen);
        int i=0;
        for (Word w:lWord){
            if(i<3){
                System.out.println(w.getWord()+" : "+w.length);
                i++;
            }
        }
    }
    public void duplicate(){
        int i=0;
        for (Word w:lWord) {
            if(i<3&&w.getFrequency()>1){
                System.out.println(reverseWord(w.getWord()));
                i++;
            }
        }

    }
    public String reverseWord(String s){
        StringBuilder sb=new StringBuilder();
        for (int i = s.length()-1; i >=0 ; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }


}
class CmpFrequency implements Comparator {

    @Override
    public int compare(Object o, Object t1) {
        Word w=(Word)o;
        Word r1=(Word)t1;

        return w.getFrequency()-r1.getFrequency()==0?
                w.getWord().length()-r1.getWord().length()
                :w.getFrequency()-r1.getFrequency();
    }
}

class CmpLength implements Comparator{

    @Override
    public int compare(Object o, Object t1) {
        Word w=(Word)o;
        Word r1=(Word)t1;

        return w.length-r1.length==0?
                w.getFrequency()-r1.getFrequency()
                :w.length-r1.length;
    }
}