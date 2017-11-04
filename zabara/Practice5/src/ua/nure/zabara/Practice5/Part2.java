package ua.nure.zabara.Practice5;


public class Part2 {




	public static void main(String[] args) {
		Spam s=new Spam(new long[]{1000,2000,3000,4000,5000},new String[]{"1","2","3","4","5"});
		s.start();

		s.interrupt();

	}

}

