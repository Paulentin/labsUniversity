package ua.nure.zabara.Practice6.part3;

public class Part3 {
	
	public static void main(String[] args) {


		Parking p = new Parking();

		for (int i = 0; i < 10; i++) {
			p.addCar(new Car(),i);
		}

		p.addCar(new Car(),5);
		p.removeCar(8);
        p.addCar(new Object(),7);
	}

}

class Car{}