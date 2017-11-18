package lab2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;

public abstract class Instrument implements Comparable{
    public int price;
    private String modelName;
    public void play(){}

    @Override
    public int compareTo(Object o) {
        Instrument ob= (Instrument) o;
        return (int) (this.price-ob.price);
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}

 abstract class Wind extends Instrument {
    abstract void blow();

     @Override
     public void play() {
         blow();
     }

     @Override
     public String toString() {
         return "Wind instr";
     }


 }
 abstract class Keyboard extends Instrument {

     abstract void pressKeys();

     @Override
     public void play() {
         pressKeys();
     }

     @Override
     public String toString() {
         return "Key instr";
     }


 }
 abstract class Stringed extends Instrument {

     abstract void twitchStrings();

     @Override
     public void play() {
         twitchStrings();
     }


     @Override
     public String toString() {
         return "Stringed instr";
     }


 }
 abstract class Percussion extends Instrument {

     abstract void beat();

     @Override
     public void play() {
         beat();
     }

     @Override
     public String toString() {
         return "Percussion instr";
     }


 }

 class CmpInstrumentsPrice implements Comparator<Instrument>{

     @Override
     public int compare(Instrument o, Instrument t1) {

         return (int) (o.price-t1.price);
     }

 }
 class CmpInstrumentsByToString implements Comparator<Instrument>{

     @Override
     public int compare(Instrument o, Instrument t1) {

         return o.toString().length()-t1.toString().length();
     }
 }