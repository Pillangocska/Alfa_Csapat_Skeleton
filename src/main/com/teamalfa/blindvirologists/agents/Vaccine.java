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

    @Override
    public void apply(Virologist target) {
        target.protectedBy(this);
        this.target = target;
    }
}
