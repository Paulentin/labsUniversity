package ua.nure.zabara.Practice5;

public class Part1 extends Thread{
	private boolean flag=true;

	public void run(){
		while (flag){
			try {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(500);
			}catch (InterruptedException e){
				System.err.println(e);
			}
		}
	}

	public static void main(String[] args) {
		Part1 p=new Part1();
		p.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.err.println(e);
		}
		p.flag=false;


		new Thread(new Main()).start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}

}


class Main implements Runnable{

	private boolean flag;
	@Override
	public void run() {
		while (flag){
			try {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(500);
			}catch (InterruptedException e){
				System.err.println(e);
			}
		}
	}
}