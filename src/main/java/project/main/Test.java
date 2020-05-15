package project.main;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;


public class Test {




    public static void main(String args[]) throws InterruptedException {




//       

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



        Owner owner = new Owner(thiev);
        Owner owner1 = new Owner(thiev);
        Owner owner2 = new Owner(thiev);
        Owner owner3 = new Owner(thiev);
        Owner owner4 = new Owner(thiev);
        Owner owner5 = new Owner(thiev);

        Thread ownerThread = new Thread(owner);
        Thread owner2Thread = new Thread(owner2);
        Thread owner1Thread = new Thread(owner1);
        Thread owner3Thread = new Thread(owner3);
        Thread owner4Thread = new Thread(owner4);
        Thread owner5Thread = new Thread(owner5);



        Thief thief = new Thief(thiev);
        Thief thief1 = new Thief(thiev);
        Thief thief2 = new Thief(thiev);
        Thief thief3 = new Thief(thiev);
        Thief thief4 = new Thief(thiev);
        Thief thief5 = new Thief(thiev);

        Thread thiefThread = new Thread(thief);
        Thread thief1Thread = new Thread(thief1);
        Thread thief2Thread = new Thread(thief2);
        Thread thief3Thread = new Thread(thief3);
        Thread thief4hread = new Thread(thief4);
        Thread thief5Thread = new Thread(thief5);

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

class Thiev{

     volatile CopyOnWriteArrayList<Object> hous = new CopyOnWriteArrayList<Object>();
     CopyOnWriteArrayList<Object> people = new CopyOnWriteArrayList<Object>();

     CopyOnWriteArrayList<Object> thef = new CopyOnWriteArrayList<Object>();

    boolean rez = false;
    boolean thief = false;
    public void add() throws InterruptedException {

        Random random = new Random();


            for (int i = 0; i < 3; i++) {
                int t = random.nextInt(10);
//            int t = 0;
            System.out.println("Это начал работать " + t + " поток (хозяин)");//
            hous.add(people.get(t));
            System.out.println("Хозяин" + hous);

            System.out.println("Это отработал " + t + " поток");//
            }
        }

}





 class Thief implements Runnable{

    private Thiev thiev;
    Thief(){}

     public Thief(Thiev thiev) {
         this.thiev = thiev;
     }




     public void putThiev() throws InterruptedException {



         System.out.println(thiev.rez);
         do{
             if(thiev.rez == false)
             {
                 thiev.thief = true;
                 System.out.println("В доме  нет хозяев");

                 System.out.println("Работает поток вор");

                 put();
                 thiev.thief = false;

                 System.out.println("Поток вора заканчивает работать");
             }
             else {
                 System.out.println("В доме хозяева");
                 System.out.println("Поток вор ждет");

                 Thread.sleep(100);
             }




         } while (thiev.rez == true);

     }




    @Override
    public void run() {



        try{
//            Thread.sleep(10);
            putThiev();

        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

     public void put() throws InterruptedException
     {


         synchronized (Thief.class) {


             Thread cut = Thread.currentThread();
             System.out.println(cut);
             Random random = new Random();
            int i = random.nextInt(2);



             int s = thiev.hous.size();
             if(s == 0){
                 System.out.println("В доме нет вещей");
             }else{

                 System.out.println("========================");

                 System.out.println("Это начал работать " + i + " поток (вор)");//



                 thiev.thef.add(thiev.hous.get(i));

                 thiev.hous.remove(i);
                 System.out.println("вор " + thiev.thef);
                 System.out.println("Вор украл: "+ thiev.thef + " и в доме осталось : " + thiev.hous);//

             }




         }

     }

}

  class Owner implements Runnable
 {

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
//






         System.out.println(thiev.thief);
         do{
         if(thiev.thief == false)
         {
             System.out.println("В доме  нет воров");
             System.out.println("Начинает работать поток хозяина");
             thiev.rez = true;
             thiev.add();


             System.out.println("Заканчивает работать поток хозяина");
             thiev.rez = false;
         }
         else {
             System.out.println("В доме воры");

             System.out.println("Хозяин ждет");
             Thread.sleep(100);
         }


     } while (thiev.thief == true);
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