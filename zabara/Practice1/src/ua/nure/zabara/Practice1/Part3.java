package ua.nure.zabara.Practice1;

/**
 * Created by dobro on 6/27/17.
 */
public class Part3 {

    public static void main(String[] args) {
        int a=Integer.parseInt(args[0]);
        int b=Integer.parseInt(args[1]);


        while (a!=b) {
                if(a>b){
                    a=a-b;
                }
                else{
                    b=b-a;

                }
        }
        System.out.println(a);


    }
}


