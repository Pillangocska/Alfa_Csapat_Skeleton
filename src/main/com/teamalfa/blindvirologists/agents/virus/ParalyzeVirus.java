package main.com.teamalfa.blindvirologists.agents.virus;

import main.com.teamalfa.blindvirologists.city.fields.Field;

public class ParalyzeVirus extends Virus {

    @Override
    public Field affectMovement(Field current) {
        return current;
    }

    @Override
    public boolean affectUsage() {
        return true;
    }

    @Override
    public boolean affectRobbability() {
        return true;
    }
}