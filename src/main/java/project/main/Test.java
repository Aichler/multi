package project.main;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;


public class Test {




    public static void main(String args[]) throws InterruptedException {
        final Room room = new Room();

        // Заполнение вещей в коллекцию "Хозяев"
        room.people.add("Tomcs");
        room.people.add("Tomcd");
        room.people.add("Tomcf");
        room.people.add("Sanvc");
        room.people.add("Sanvf");
        room.people.add("Sanvb");
        room.people.add("Thmz");
        room.people.add("Thmx");
        room.people.add("Thmb");
        room.people.add("Avice");

        // Инициализирование "Хозяев"
        Owner owner = new Owner(room);
        Owner owner1 = new Owner(room);
        Owner owner2 = new Owner(room);
        Owner owner3 = new Owner(room);
        Owner owner4 = new Owner(room);
        Owner owner5 = new Owner(room);

        //Создание потоков "Хозяев"
        Thread ownerThread = new Thread(owner);
        Thread owner2Thread = new Thread(owner2);
        Thread owner1Thread = new Thread(owner1);
        Thread owner3Thread = new Thread(owner3);
        Thread owner4Thread = new Thread(owner4);
        Thread owner5Thread = new Thread(owner5);

        //Инициализирование "Воров"
        Thief thief = new Thief(room);
        Thief thief1 = new Thief(room);
        Thief thief2 = new Thief(room);
        Thief thief3 = new Thief(room);
        Thief thief4 = new Thief(room);
        Thief thief5 = new Thief(room);

//      Создание потоков "Воров"
        Thread thiefThread = new Thread(thief);
        Thread thief1Thread = new Thread(thief1);
        Thread thief2Thread = new Thread(thief2);
        Thread thief3Thread = new Thread(thief3);
        Thread thief4hread = new Thread(thief4);
        Thread thief5Thread = new Thread(thief5);

//      Запуск потоков "Воров" и "Хозяев"
        thief1Thread.start();
        owner2Thread.start();
        ownerThread.start();
        thief5Thread.start();
        owner1Thread.start();
        thiefThread.start();
        thief2Thread.start();
        owner3Thread.start();
        thief4hread.start();
        owner4Thread.start();
        thief3Thread.start();
   }
}









