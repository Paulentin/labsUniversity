package lab2;

public class Guitar extends Stringed {
    @Override
    void twitchStrings() {
        System.out.println("Guitar twitching");
    }
    @Override
    public String toString() {
        return "Guitar: "+ getModelName();
    }

}
