package main.com.teamalfa.blindvirologists.agents.virus;

import main.com.teamalfa.blindvirologists.AController;
import main.com.teamalfa.blindvirologists.agents.Agent;
import main.com.teamalfa.blindvirologists.city.fields.Field;
import main.com.teamalfa.blindvirologists.virologist.Virologist;

abstract public class Virus extends Agent {

    protected int priority;

    @Override
    public void apply(Virologist target) {
        if (target.infectedBy(this)) {
            this.target = target;
        }
    }

    public boolean affectUsage() {
        return false;
    }

    public boolean affectRobbability() {
        return false;
    }

    public Field affectMovement(Field current) {
        AController.printCall(this, "affectMovement", new Object[]{current});

        AController.printReturn("null");
        return null;
    }

    public int getPriority() {
        return priority;
    }
}