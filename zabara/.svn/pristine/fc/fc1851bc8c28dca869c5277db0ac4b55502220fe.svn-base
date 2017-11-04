package ua.nure.zabara.Practice5;

import java.util.Arrays;

public class Spam extends Thread {

    private long [] mSec;
    private String [] strings;

    Spam(long[] mSec, String[] strings){

        if(mSec==null||strings==null){
            this.mSec=new long[0];
            this.strings=new String[0];
        }else {
            this.mSec= new long[mSec.length];
            this.strings= new String[strings.length];

            for (int i = 0; i < mSec.length; i++) {

                this.mSec[i]= new Long(mSec[i]);
            }
            for (int i = 0; i < strings.length; i++) {

                this.strings[i]= new String(strings[i]);
            }
        }

    }

    public void run(){
        for (int i = 0; i<mSec.length; i++) {
            try {
                Thread.sleep(mSec[i]);
                System.out.println(strings[i]);
            } catch (InterruptedException e) {
                break;
            }

        }

    }

}
