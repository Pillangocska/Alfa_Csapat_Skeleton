package main.com.teamalfa.blindvirologists.equipments;

import java.util.Random;

public class Cloak extends Equipment{

    private final double protectionRate;

    public Cloak(){
        protectionRate = 82.3;
    }

    public boolean protect(){
        Random r = new Random();
        double tmp = 100 * r.nextDouble();
        if(tmp >= protectionRate)
            return true;
        return false;
    }

}
