package main.com.teamalfa.blindvirologists.agents;

import main.com.teamalfa.blindvirologists.virologist.Virologist;

public class Vaccine extends Agent {

    @Override
    public void apply(Virologist target) {
        target.protectedBy(geneticCode);
        this.target = target;
    }

    @Override
    public void step() {
        super.step();
        if(target != null && duration == 0) {
            target.removeProtection(geneticCode);
        }
    }
}
