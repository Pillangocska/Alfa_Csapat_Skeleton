package main.com.teamalfa.blindvirologists.agents.virus;

import main.com.teamalfa.blindvirologists.AController;
import main.com.teamalfa.blindvirologists.city.fields.Field;

import java.util.ArrayList;

public class DanceVirus extends Virus {

    private Field pickRandom(ArrayList<Field> neighbours) {
        AController.printCall(this, "pickRandom", new Object[]{neighbours});
        return (Field) AController.printReturn(neighbours.get(AController.askMultiChoice(neighbours.size(), "field")));
    }

    @Override
    public Field affectMovement(Field current) {
        AController.printCall(this, "affectMovement", new Object[]{current});
        return (Field) AController.printReturn(pickRandom(current.getNeighbours()));
    }
}