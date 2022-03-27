package main.com.teamalfa.blindvirologists.agents.virus;

import main.com.teamalfa.blindvirologists.AController;
import main.com.teamalfa.blindvirologists.city.fields.Field;

import java.util.ArrayList;

public class DanceVirus extends Virus {

    private Field pickRandom(ArrayList<Field> neighbours) {
        AController.printCall(this, "pickRandom", null);
        return neighbours.get(AController.askMultiChoice(neighbours.size(), "field"));
    }

    @Override
    public Field affectMovement(Field current) {
        int currentCall = AController.getCallCount();
        AController.printCall(this, "affectMovement", new Object[]{current});


        Field modified = pickRandom(current.getNeighbours());


        AController.setCallCount(currentCall);
        return modified;
    }
}