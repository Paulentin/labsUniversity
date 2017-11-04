package ua.nure.zabara.Practice1;

/**
 * Created by dobro on 6/27/17.
 */
public class Part2 {
    public static void main(String[] args) {
        int sum=0;
        for (int i = 0; i < args.length; i++) {
            sum+= Integer.parseInt(args[i]);
        }
        System.out.println(sum);

    }

}
