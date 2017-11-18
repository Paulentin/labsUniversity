package lab2;

public class Drum extends Percussion{

    @Override
    void beat() {
        System.out.println("Drum beat");
    }

    @Override
    public String toString() {
        return "Drum: "+ getModelName();
    }
}
