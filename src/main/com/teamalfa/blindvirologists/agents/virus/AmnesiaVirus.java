package main.com.teamalfa.blindvirologists.agents.virus;

import main.com.teamalfa.blindvirologists.virologist.Virologist;

public class AmnesiaVirus extends Virus {

    @Override
    public void apply(Virologist target) {
        if (target.infectedBy(this)) {
            this.target = target;
            this.target.getBackPack().deleteAllGeneticCodes();
        }
    }
}
