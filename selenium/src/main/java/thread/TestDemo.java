package thread;

import thread.dao.PeopleDao;

public class TestDemo {

    public static void main(String[] args) {

        PeopleDao men = new PeopleDao();
        men.setName("xinxin");

        PeopleDao men2 = new PeopleDao();
        men2.setName("huanhuan");
        System.out.println("start running...");
        Thread thread1 = new Thread(men);
        Thread thread2 = new Thread(men2);
        thread1.start();
        thread2.start();
        System.out.println("game over...");




    }


}
