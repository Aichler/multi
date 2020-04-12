package project.main;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;
import java.util.concurrent.*;


public class Test {




    public static void main(String args[]) throws InterruptedException {
        final Thiev thiev = new Thiev();
//        final Thiev thiev1 = new Thiev();
//        final Thiev thiev2 = new Thiev();
//        final Thiev thiev3 = new Thiev();

        Thread threadAdd = new Thread(new Runnable() {
            @Override
            public void run() {
                    try{
                        thiev.add();
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });

        Thread threadAdd1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    thiev.add();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadAdd2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    thiev.add();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadRemove = new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    thiev.put();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });


        thiev.people.add("Tomcs");
        thiev.people.add("Tomcd");
        thiev.people.add("Tomcf");

        thiev.people.add("Sanvc");
        thiev.people.add("Sanvf");
        thiev.people.add("Sanvb");


        thiev.people.add("Thmz");
        thiev.people.add("Thmx");
        thiev.people.add("Thmb");

        thiev.people.add("Avice");



        threadAdd.start();
        threadAdd1.start();

        System.out.println(threadAdd.isAlive());
        System.out.println(threadRemove.isAlive());
        System.out.println("========================");
        // получаем 2-й объект
//        threadRemove.sleep();
        threadRemove.sleep(5000);
        threadRemove.start();
        System.out.println(threadAdd.isAlive());
        System.out.println(threadRemove.isAlive());
//        threadRemove.sleep(3000);
        threadAdd2.start();

        System.out.println("++++");
        System.out.println(threadAdd2.isAlive());
        System.out.println(threadRemove.isAlive());


        threadAdd.join();
        threadAdd1.join();

        threadRemove.join();
        threadAdd2.join();
    }



}

class Thiev{

     volatile CopyOnWriteArrayList<Object> hous = new CopyOnWriteArrayList<Object>();
     CopyOnWriteArrayList<Object> people = new CopyOnWriteArrayList<Object>();

     CopyOnWriteArrayList<Object> thef = new CopyOnWriteArrayList<Object>();
//        static int t = 6;
    public void add() throws InterruptedException
    {
        Random random = new Random();
        synchronized (Thiev.class) {


//            for (int i = 0; i < 4; i++) {
                int t = random.nextInt(3);
//                int t = 0;
                System.out.println("Это начал работать " + t + " поток (хозяин)");//
                hous.add(people.get(t));
                System.out.println(hous);
//            wait();
//                notify();
//            System.out.println(hous);//
                System.out.println("Это отработал " + t + " поток");//
//            }
        }
    }

    public void put() throws InterruptedException
    {
        synchronized (Thiev.class) {
            Random random = new Random();
            int i = random.nextInt(3);
            System.out.println("Lol " + hous.get(i));
            System.out.println("Это начал работать " + i + " поток (вор)");//
//

//            wait();
            thef.add(hous.get(i));
            System.out.println("KEK");//
        hous.remove(i);
            System.out.println("вор " + thef);
        System.out.println("Вор украл: "+ thef + " и в доме осталось : " + hous);//
            System.out.println("Это отработал " + i + " поток");//
//            wait();
        }

    }



}

//class Thing{
//    private String name;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}