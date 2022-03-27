package main.com.teamalfa.blindvirologists.agents;

import main.com.teamalfa.blindvirologists.agents.genetic_code.AmnesiaCode;
import main.com.teamalfa.blindvirologists.agents.genetic_code.DanceCode;
import main.com.teamalfa.blindvirologists.agents.genetic_code.ParalyzeCode;
import main.com.teamalfa.blindvirologists.virologist.Virologist;

public class Vaccine extends Agent {

    public Vaccine(AmnesiaCode amnesiaCode) {
    }

    public Vaccine(DanceCode danceCode) {
    }

    public Vaccine(ParalyzeCode paralyzeCode) {
    }

    /**
     * This method is called when a Vaccine is used on a Virologist.
     * @param target The virologist that got vaccinated.
     */
    @Override
    public void apply(Virologist target) {
        target.protectedBy(this);
        this.target = target;
    }

    //@Override
    /*public void step() {
        super.step();
        if(target != null && duration == 0) {
            target.removeProtection(geneticCode);
        }
    }*/
}
