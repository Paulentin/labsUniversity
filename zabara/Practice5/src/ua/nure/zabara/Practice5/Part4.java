package ua.nure.zabara.Practice5;


import java.util.Arrays;

public class Part4 {
	
	public static void main(String[] args) {

		//Set array
		int [][]a = new int[4][100];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 100; j++) {
				a[i][j]=i+j;

			}
		}


		//get array of threads
		FinderMax[] f=new FinderMax[4];
		for (int j = 0; j < f.length ; j++) {
			f[j]=new FinderMax(a[j]);
			f[j].start();
		}

		//wait for ending
		for (int j = 0; j <f.length ; j++) {
			try {
				f[j].join();
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}

		//initializing array of maxes
		int [] arrOfMax=new int[4];
		for (int i = 0; i < arrOfMax.length; i++) {
			arrOfMax[i]=f[i].getMax();
		}
		//getting max value
		FinderMax fMax=new FinderMax(arrOfMax);
		fMax.start();
		try {
			fMax.join();
		} catch (InterruptedException e) {
			System.err.println(e);
		}
		System.out.println(fMax.getMax());

	}

}
class FinderMax extends Thread{

	private int []mat;
    private int max;

    public int getMax() {
        return this.max;
    }

	FinderMax(int [] mat){
		if(mat==null){
			this.mat=new int[0];
		}else {
		    this.mat= new int[mat.length];
            for (int i = 0; i < mat.length; i++) {
                this.mat[i]=new Integer(mat[i]);
            }
        }
	}
	public void run(){
		max=0;

		for (int i = 0; i < mat.length; i++) {
			if (mat[i]>max){
				max=mat[i];
			}
		}
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}
}