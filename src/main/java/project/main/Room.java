package project.main;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Room {
    // Коллекции "Воров", "Хозяев" и "Квартиры".
    CopyOnWriteArrayList<Object> hous = new CopyOnWriteArrayList<Object>();
    CopyOnWriteArrayList<Object> people = new CopyOnWriteArrayList<Object>();
    CopyOnWriteArrayList<Object> thef = new CopyOnWriteArrayList<Object>();

    // Булевые переменные для проверки нахождения "Воров" и "Хозяев" в "Квартире"
    boolean rez = false;
    boolean thief = false;

    // Метод добавления в коллекцию "Квартира" "Хозяином"
    public void add() throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int t = random.nextInt(10);
            hous.add(people.get(t));
                System.out.println("Хозяин" + hous);
                System.out.println("Это отработал " + t + " поток");//
        }
    }
}
