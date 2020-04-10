package project.main;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;
import java.util.concurrent.*;


public class Test {




    public static void main(String args[]) throws InterruptedException {
        final Thiev thiev = new Thiev();
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


        thiev.people.add("Tomc");
        thiev.people.add("Alidfe");
        thiev.people.add("Katf");
        thiev.people.add("Sanv");
        thiev.people.add("Tuym");
        thiev.people.add("Axice");
        thiev.people.add("Knte");
        thiev.people.add("Srm");
        thiev.people.add("Thm");
        thiev.people.add("Avice");
        thiev.people.add("Kfte");
        thiev.people.add("Sdm");


        threadAdd.start();
        threadAdd1.start();
        threadAdd2.start();
        System.out.println(threadAdd.isAlive());
        System.out.println(threadRemove.isAlive());
        System.out.println("========================");
        // получаем 2-й объект
//        threadRemove.sleep();
        threadRemove.start();
        System.out.println(threadAdd.isAlive());
        System.out.println(threadRemove.isAlive());
//        threadRemove.sleep(3000);

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


            for (int i = 0; i < 4; i++) {
                int t = random.nextInt(12);
                System.out.println("Это начал работать " + t + " поток (хозяин)");//
                hous.add(people.get(t));
                System.out.println(hous);
//            wait();
//            System.out.println(hous);//
                System.out.println("Это отработал " + t + " поток");//
            }
        }
    }

    public void put() throws InterruptedException
    {
        synchronized (Thiev.class) {
            Random random = new Random();
            int i = random.nextInt(10);
            System.out.println("Это начал работать " + i + " поток (вор)");//
//            notify();
            thef.add(hous.get(i));
        hous.remove(i);
            System.out.println("вор " + thef);
        System.out.println("Вор украл: "+ thef + " и в доме осталось : " + hous);//
            System.out.println("Это отработал " + i + " поток");//
        }

    }

}