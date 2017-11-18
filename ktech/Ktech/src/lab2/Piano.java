package lab2;

public class Piano extends Keyboard{

    @Override
    void pressKeys() {
        System.out.println("Piano key pressing");
    }

    @Override
    public String toString() {
        return "Piano: "+ getModelName();
    }
}
