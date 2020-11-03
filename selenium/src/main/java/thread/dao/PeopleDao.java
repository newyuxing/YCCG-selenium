package thread.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PeopleDao implements Runnable {

    
    private String name;
    private String work;
    private int age;


    public void run() {
        System.out.println(this.name + " start running...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + " run over...");

    }
}
