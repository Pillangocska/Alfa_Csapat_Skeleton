package main.com.teamalfa.blindvirologists.agents;

import main.com.teamalfa.blindvirologists.agents.genetic_code.GeneticCode;
import main.com.teamalfa.blindvirologists.turn_handler.Steppable;
import main.com.teamalfa.blindvirologists.turn_handler.TurnHandler;
import main.com.teamalfa.blindvirologists.virologist.Virologist;
import main.com.teamalfa.blindvirologists.virologist.backpack.ElementBank;

abstract public class Agent implements Steppable {
    protected int duration;
    protected int expiry;
    protected ElementBank cost;
    protected Virologist target = null;
    protected GeneticCode geneticCode;

    public Agent() {
        // When an agent is created the decomposition starts.
        TurnHandler.getInstance().accept(this);
    }

    public void step() {
        if(target == null) {
            expiry--;
        }else {
            duration--;
        }
        if(duration == 0 | expiry == 0) {
            TurnHandler.getInstance().remove(this);
        }
    }

    abstract public void apply(Virologist target);
}

