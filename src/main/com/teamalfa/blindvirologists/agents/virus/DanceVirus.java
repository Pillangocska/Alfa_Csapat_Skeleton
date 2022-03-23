package main.com.teamalfa.blindvirologists.agents.virus;

import main.com.teamalfa.blindvirologists.city.fields.Field;

import java.util.ArrayList;

public class DanceVirus extends Virus {

    private Field pickRandom(ArrayList<Field> neighbours) {
        //Meg kell kérdezni a tesztelőtől hogy mit választ
        return null;
    }

    @Override
    public Field affectMovement(Field current) {
        return pickRandom(current.getNeighbours());
    }


}
