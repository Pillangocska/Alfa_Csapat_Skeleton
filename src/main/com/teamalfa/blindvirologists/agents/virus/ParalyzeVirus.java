package main.com.teamalfa.blindvirologists.agents.virus;

import main.com.teamalfa.blindvirologists.AController;
import main.com.teamalfa.blindvirologists.city.fields.Field;

public class ParalyzeVirus extends Virus {

    @Override
    public Field affectMovement(Field current) {
        AController.printCall(this, "affectMovement", new Object[] {current});
        return (Field) AController.printReturn(current);
    }

    @Override
    public boolean affectUsage() {
        return true;
    }

    @Override
    public boolean affectRobbability() {
        AController.printCall(this, "affectRobbability", null);
        return (boolean) AController.printReturn(true);
    }
}