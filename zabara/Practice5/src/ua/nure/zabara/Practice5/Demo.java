package ua.nure.zabara.Practice5;


public class Demo {
	
	public static void main(String[] args) {
		try {


			System.out.println("~~~~~~~~~~~~Part1");
			Part1.main(args);

			System.out.println("~~~~~~~~~~~~Part2");

			Part2.main(args);

			System.out.println("~~~~~~~~~~~~Part3");
			Part3.main(args);

			System.out.println("~~~~~~~~~~~~Part4");
			Part4.main(args);

			System.out.println("~~~~~~~~~~~~Part5");
			Part5.main(args);

			System.out.println("~~~~~~~~~~~~Part6");
			Part6.main(args);
		}catch (Exception e){
			System.err.println(e);
		}

	}


}


/*
	todo   Spam в мейне класс принимает два массива в интервале поспал, вывел сообщения запустить поток и ожиать ввод в клаву
    todo    остановить корректно считывать сканнером

    todo      порождать потоки и единажды передать в контсрукторе обьект

            матрица м*н к поток должен обрабатывать прочитать в каждой строке при потоков максимум потом из потоков найти 1 максимум,
            задержка в 1 мсек
            есть файл в него пишут одновременно 10 потоков, нельзя записать всю строку
            рандомаксес файл это байтовый поток , записать символьным*/