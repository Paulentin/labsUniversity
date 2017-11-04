package ua.nure.zabara.Practice5;

public class Part3 extends Thread {
	private Counter c=null;

	Part3(Counter c){
		this.c=c;
	}

	public  void run(){
		int i=0;

		while (i < 10) {
			if (c.getCounter1() > c.getCounter2()) {
				System.out.println(Thread.currentThread().getName() + " C1:" + c.getCounter1() + " bigger than C2:" + c.getCounter2());
			} else if (c.getCounter1() < c.getCounter2()) {
				System.out.println(Thread.currentThread().getName() + " C2:" + c.getCounter1() + " bigger than C1:" + c.getCounter1());
			}else{
				System.out.println(Thread.currentThread().getName() + " C2:" + c.getCounter2() + " ======== equal ======= C1:" + c.getCounter1());
			}

			c.incrementOne();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.err.println(e);
			}
			c.incrementTwo();
			i++;
		}
	}

	public static void main(String[] args) {
		Counter c=new Counter();

		Part3 p1 =new Part3(c);
		Part3 p2 = new Part3(c);
		p1.start();
		p2.start();
	}

}
class Counter{
	public int getCounter1() {
		return this.counter1;
	}

	public void setCounter1(int counter1) {
		this.counter1 = counter1;
	}

	public int getCounter2() {
		return this.counter2;
	}

	public void setCounter2(int counter2) {
		this.counter2 = counter2;
	}

	private int counter1=0;
	private int counter2=0;

	public void incrementOne(){
		counter1++;
	}
	public void incrementTwo(){
		counter2++;
	}



}
