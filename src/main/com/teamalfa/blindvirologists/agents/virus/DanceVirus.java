package main.com.teamalfa.blindvirologists.agents.virus;

import main.com.teamalfa.blindvirologists.AController;
import main.com.teamalfa.blindvirologists.city.fields.Field;

import java.util.ArrayList;

public class DanceVirus extends Virus {

    private Field pickRandom(ArrayList<Field> neighbours) {

        AController.printCall(this, "pickRandom", new Object[]{neighbours});
        return (Field) AController.printReturn(AController.askMultiChoice("destination field", migrateChoices(neighbours)));
    }

    @Override
    public Field affectMovement(Field current) {
        AController.printCall(this, "affectMovement", new Object[]{current});
        return (Field) AController.printReturn(pickRandom(current.getNeighbours()));
    }

    private ArrayList<Object> migrateChoices(ArrayList<Field> neighbours) {
        ArrayList<Object> choices = new ArrayList<>();
        for(Field field : neighbours)
            choices.add(field);
        return choices;
    }
}