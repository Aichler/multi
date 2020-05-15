package project.main;

import java.util.Random;

class Thief implements Runnable{

    private Room room;

    Thief(){}

    public Thief(Room room) {
        this.room = room;
    }


    public void putThiev() throws InterruptedException {
        // Цикл, предназначеныый для отслеживания нахожденив в квартире "Хозяев"
        do{
            if(room.rez == false)
            {
                room.thief = true;
                System.out.println("В доме  нет хозяев");
                System.out.println("Работает поток вор");
                //Вход в "Квартиру"
                put();
                room.thief = false;
                System.out.println("Поток вора заканчивает работать");
            }
            else {
                System.out.println("В доме хозяева");
                System.out.println("Поток вор ждет");
                Thread.sleep(100);
            }
        } while (room.rez == true);
    }


    @Override
    public void run() {
        try{
            putThiev();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Метод кражи из коллекции "Квартира" "Вором"
    public void put() throws InterruptedException
    {
        synchronized (Thief.class) {
            Random random = new Random();
            int i = random.nextInt(2);
            int s = room.hous.size();
                if(s == 0){
                    System.out.println("В доме нет вещей");
                }else{
                    room.thef.add(room.hous.get(i));
                    room.hous.remove(i);
                       System.out.println("Вор украл: "+ room.thef + " и в доме осталось : " + room.hous);//

                }
        }
    }
}