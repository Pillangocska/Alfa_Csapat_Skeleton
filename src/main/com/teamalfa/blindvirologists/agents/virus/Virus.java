package main.com.teamalfa.blindvirologists.agents.virus;

import main.com.teamalfa.blindvirologists.AController;
import main.com.teamalfa.blindvirologists.agents.Agent;
import main.com.teamalfa.blindvirologists.city.fields.Field;
import main.com.teamalfa.blindvirologists.virologist.Virologist;

abstract public class Virus extends Agent {

    protected int priority;

    @Override
    public void apply(Virologist target) {
        AController.printCall(this, "apply", new Object[]{target});
        if (target.infectedBy(this)) {
            //this.target = target;
            this.setTarget(target);
            target.addVirus(this);
        }
        AController.printReturn(null);
    }

    public void setTarget(Virologist v){
        AController.printCall(this, "setTarget", new Object[] {v});
        this.target = v;
    }

    public boolean affectUsage() {
        return false;
    }

    public boolean affectRobbability() {
        AController.printCall(this, "affectRobbability", null);

        return (boolean) AController.printReturn(false);
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