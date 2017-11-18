package lab2;

public class Trumpet extends Wind{
    @Override
    void blow() {
        System.out.println("Trumpet blowing");
    }

    @Override
    public String toString() {
        return "Trumpet: "+ getModelName();
    }
}
