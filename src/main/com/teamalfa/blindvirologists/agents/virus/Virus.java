package main.com.teamalfa.blindvirologists.agents.virus;

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

    /*@Override
    public void step() {
        super.step();
        if (target != null && duration == 0) {
            target.removeVirus(this);
        }
    }*/

    public boolean affectUsage() {
        return false;
    }

    public boolean affectRobbability() {
        return false;
    }

    public abstract Field affectMovement(Field current);
}