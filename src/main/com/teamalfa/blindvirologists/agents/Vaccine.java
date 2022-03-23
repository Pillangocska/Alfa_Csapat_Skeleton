package main.com.teamalfa.blindvirologists.agents;

import main.com.teamalfa.blindvirologists.virologist.Virologist;

public class Vaccine extends Agent {

    @Override
    public void apply(Virologist target) {
        target.protectedBy(this);
        this.target = target;
    }
}
