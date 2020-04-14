package project.main;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;
    import java.util.concurrent.*;


public class Test {




    public static void main(String args[]) throws InterruptedException {




//        final Thiev thiev1 = new Thiev();
//        final Thiev thiev2 = new Thiev();
//        final Thiev thiev3 = new Thiev();

//        Thread threadAdd = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                    try{
//                        thiev.add();
//                    }catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//            }
//        });
//
//        Thread threadAdd1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try{
//                    thiev.add();
//                }catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        Thread threadAdd2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try{
//                    thiev.add();
//                }catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        Thread threadRemove = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                try{
//                    thiev.put();
//                }catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });

        final Thiev thiev = new Thiev();
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



//        threadAdd.start();
//        threadAdd1.start();
////        threadAdd1.sleep(2000);
//        threadAdd.join();
//        threadAdd1.join();
//
//
//        System.out.println(threadAdd.isAlive());
//        System.out.println(threadAdd1.isAlive());
//        System.out.println(threadAdd2.isAlive());
//        System.out.println(threadRemove.isAlive());
//        System.out.println("========================");
//        // получаем 2-й объект
////        threadRemove.sleep();
////        threadRemove.sleep(1000);
//
//        if(threadAdd1.isAlive() && threadAdd.isAlive()  == true)
//        {
//            System.out.println("В доме хозяин");
//        } else {
//            threadRemove.start();
//        }
//
//        threadRemove.join();
////        threadRemove.sleep(1000);
//        System.out.println(threadAdd.isAlive());
//        System.out.println(threadAdd1.isAlive());
//        System.out.println(threadAdd2.isAlive());
//        System.out.println(threadRemove.isAlive());
////        threadRemove.sleep(3000);
//
//
//        System.out.println("++++");
//        threadAdd2.start();
//        System.out.println(threadRemove.isAlive());
//        System.out.println(threadAdd2.isAlive());
//
//
////        threadAdd.join();
////        threadAdd1.join();
//
//
//        threadAdd2.join();
//
////        threadAdd.start();


        Owner owner = new Owner(thiev);
        Thread ownerThread = new Thread(owner);


        Owner owner1 = new Owner(thiev);
        Thread owner1Thread = new Thread(owner1);





        Thief thief = new Thief(thiev);
        Thread thiefThread = new Thread(thief);

        Thief thief1 = new Thief(thiev);
        Thread thief1Thread = new Thread(thief1);



        ownerThread.start();

        System.out.println(ownerThread.isAlive());
        System.out.println(owner1Thread.isAlive());
        System.out.println(thiefThread.isAlive());
        System.out.println("==============");

        owner1Thread.start();

        System.out.println(ownerThread.isAlive());
        System.out.println(owner1Thread.isAlive());
        System.out.println(thiefThread.isAlive());
        System.out.println("==============");

        ownerThread.join();
        owner1Thread.join();

        thiefThread.start();
        thiefThread.join();

        System.out.println(thiefThread.isAlive());
        System.out.println(thief1Thread.isAlive());
        System.out.println("==============");

        thief1Thread.start();

        System.out.println(ownerThread.isAlive());
        System.out.println(owner1Thread.isAlive());
        System.out.println(thiefThread.isAlive());
        System.out.println(thief1Thread.isAlive());
        System.out.println("==============");





        thief1Thread.join();

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
//        synchronized ( ) {
//            Thiev.class

//            for (int i = 0; i < 4; i++) {
//                int t = random.nextInt(3);
                int t = 0;
                System.out.println("Это начал работать " + t + " поток (хозяин)");//
                hous.add(people.get(t));
                System.out.println(hous);
//            wait();
//                notify();
//            System.ouzt.println(hous);//
                System.out.println("Это отработал " + t + " поток");//
//            }
//        }
    }

    public void put() throws InterruptedException
    {
        synchronized (Thiev.class) {
            Random random = new Random();
//            int i = random.nextInt(2);
            int i = 0;
            System.out.println("========================");
            System.out.println("Lol " + hous.get(0));
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

 class Thing{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

 class Thief implements Runnable{
    public Thiev getThiev() {
         return thiev;
     }

    public void setThiev(Thiev thiev) {
         this.thiev = thiev;
     }

    private Thiev thiev;
    Thief(){}
    Thief(Thiev thiev){
        this.thiev = thiev;
    }

    public void putThiev() throws InterruptedException {

        thiev.put();

    }

    @Override
    public void run() {

        try{
//            System.out.println("Lol");
//            System.out.println(thiev.people.get(0));
            putThiev();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

  class Owner implements Runnable
 {
//    Thiev thiev = new Thiev();Thiev
    private Thiev thiev;

    Owner(Thiev thiev){
        this.thiev = thiev;
    }

     public Thiev getThiev() {
         return thiev;
     }

     public void setThiev(Thiev thiev) {
         this.thiev = thiev;
     }

     public void addThiev() throws InterruptedException {
        System.out.println(thiev.people.get(0));
        thiev.add();
     }

    @Override
    public void run() {

        try{
            addThiev();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
 }