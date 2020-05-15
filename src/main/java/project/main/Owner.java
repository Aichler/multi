package project.main;

class Owner implements Runnable
{
    private Room room;

    Owner(Room room){
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }



    public void addRoom() throws InterruptedException {

        // Цикл, предназначеныый для отслеживания нахожденив в квартире "Воров"
        do{
            if(room.thief == false)
            {
                System.out.println("В доме  нет воров");
                System.out.println("Начинает работать поток хозяина");

                //Вход в "Квартиру"
                room.rez = true;
                room.add();
                System.out.println("Заканчивает работать поток хозяина");
                room.rez = false;
            }
            else {
                System.out.println("В доме воры");
                System.out.println("Хозяин ждет");
                Thread.sleep(100);
            }


        } while (room.thief == true);
    }

    @Override
    public void run() {

        try{
            addRoom();

        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}