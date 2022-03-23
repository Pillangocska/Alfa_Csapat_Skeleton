package main.com.teamalfa.blindvirologists.agents.virus;

import main.com.teamalfa.blindvirologists.city.fields.Field;

public class DanceVirus extends Virus {

    private Field pickRandom(Field[] neighbours) {
        //Meg kell kérdezni a tesztelőtől hogy mit választ
        return null;
    }

    @Override
    public Field affectMovement(Field current) {
        Field[] neighbours = current.getNeighbours();
        return pickRandom(neighbours);
    }


}
