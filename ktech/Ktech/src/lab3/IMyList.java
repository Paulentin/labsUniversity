package lab3;

import lab2.Instrument;

interface IMyList extends Iterable {

    void add(Instrument e);
    void clear();
    boolean remove();
    Object[] toArray();
    boolean contains(Instrument e);

}



/*
    В лабораторной работе необходимо выполнить:
        1. Создать интерфейс IMyList (название может быть другим), который должен содержать список методов, необходимых для работы связанного списка. Минимальный набор методов должен быть следующим:
        void add(«Ваш класс» e); // добавить элемент в контейнер
        void clear(); // очистить контейнер
        boolean remove(«Ваш класс» o); // удалить элемент из контейнера
        Object[] toArray(); // вернуть массив элементов из контейнера

        int size(); // вернуть количество элементов в контейнере
        boolean contains(«Ваш класс» o); // проверить, содержится ли элемент в контейнере (с помощью метода equals).
        Дополнительные методы интерфейса IMyList согласовать с преподавателем.
        2. Переопределить метод toString таким образом, чтобы результат выводился в виде:
        {[результат вызова toString для элемента 1], [результат вызова toString для элемента 2], ... }
        3. Создать класс MyListImpl (название может быть другим), который реализует IMyList.
        4. Добавить к интерфейсу IMyList наследование интерфейса Iterable (java.lang.Iterable).
        5. Реализовать в классе MyListImpl метод
        который возвращает объект внутреннего класса IteratorImpl:
private class IteratorImpl implements Iterator<«Ваш класс» > {
            public boolean hasNext() { // проверяет, есть ли следующий элемент для выборки методом next
                // ...
            }
             public «Ваш класс» next() { // возвращает следующий элемент
                // ...
            }
             public void remove() { // удаляет элемент, который был возвращен ранее методом next
                АЛГОРИТМ:
                 ЕСЛИ ПЕРЕД ВЫЗОВОМ remove НЕ БЫЛ ВЫЗВАН МЕТОД next
                ИЛИ ПЕРЕД ВЫЗОВОМ remove БЫЛ ВЫЗВАН remove (повторный вызов remove)
                    ВЫБРОСИТЬ ИСКЛЮЧЕНИЕ (так и вставить в код):
                    throw new IllegalStateException();
            }       
        }
        6. Продемонстрировать работу итератора с помощью циклов while и for each:
        MyListImpl con = new MyListImpl();
// ...
                 
        for («Ваш класс» o : con) {
            System.out.println(o);
        }
                 
        Iterator<«Ваш класс» > it = con.iterator();
        while (it.hasNext())
            System.out.println(it.next());

*/
