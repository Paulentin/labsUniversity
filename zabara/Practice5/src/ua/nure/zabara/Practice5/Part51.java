package ua.nure.zabara.Practice5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Note!!! Without synchronization this application not work properly!! Most
 * likely a runtime exception will be thrown..
 * 
 */
public class Part51 {

	private static final int ITERATION_NUMBER = 3;

	private static final int READERS_NUMBER = 3;

	// shared resource (not thread-safe!!!)
	private static final StringBuilder BUFFER = new StringBuilder();

	private static final int BUFFER_LENGTH = 5;

	// speed parameter
	private static final int PAUSE = 5;

	// stop signal
	private static boolean stop;
    private static boolean canRead;
	private static int readerCountDown;

	// reader
	private static class Reader extends Thread {
	    public void run() {
			while (!stop) {
				try {
                    synchronized (BUFFER){
                        if (canRead&&readerCountDown!=0){
                        // read from the buffer
                            read(getName());
                            --readerCountDown;
                            BUFFER.notifyAll();

                        }
                        BUFFER.wait();
					}
				} catch (InterruptedException e) {
					System.err.println(e);
				}
				if(stop){
					System.out.println("stop");
				}
			}

		}
	}

    // writer
	private static class Writer extends Thread {
        public void run() {


		int tact=0;
				while (!stop) {
					try {
						// write to the buffer
						synchronized (BUFFER) {

							while (readerCountDown > 0) {
								BUFFER.wait();
							}
							canRead = false;

							write();
							readerCountDown = READERS_NUMBER;
							BUFFER.notifyAll();
							canRead = true;


						}
					} catch (InterruptedException e) {
						System.err.println(e);
					} finally {
						if (++tact == ITERATION_NUMBER) {
							stop = true;

						}
					}
				}

				Thread.currentThread().interrupt();


		}
	}



    private static void read(String threadName) throws InterruptedException {
        System.out.printf("Reader %s:", threadName);
        for (int j = 0; j < BUFFER_LENGTH; j++) {
            Thread.sleep(PAUSE);
            System.out.print(BUFFER.charAt(j));
        }
        System.out.println();
        Thread.sleep(5);
    }



	private static void write() throws InterruptedException {


		// clear buffer
		BUFFER.setLength(0);

		// write to buffer
		System.err.print("Writer writes:");

		Random random = new Random();
		for (int j = 0; j < BUFFER_LENGTH; j++) {
			Thread.sleep(PAUSE);
			char ch = (char) ('A' + random.nextInt(26));
			System.err.print(ch);
			BUFFER.append(ch);
		}

		System.err.println();
		Thread.sleep(5);


	}




	public static void main(String[] args) throws InterruptedException {
		// create writer
		Writer writer = new Writer();
        writer.setPriority(Thread.MAX_PRIORITY);
		// create readers
		List<Thread> readers = new ArrayList<>();
		for (int j = 0; j < READERS_NUMBER; j++) {
			readers.add(new Reader());
		}


        // start readers
        Thread.sleep(10);
        for (Thread reader : readers) {
            reader.setPriority(Thread.MIN_PRIORITY);
            reader.start();
        }
        // start writer
        Thread.sleep(10);
        writer.start();


		// main thread is waiting for the child threads
		for (Thread reader : readers) {
			reader.join();

		}
		System.out.println("joined");
		writer.join();
	}

}