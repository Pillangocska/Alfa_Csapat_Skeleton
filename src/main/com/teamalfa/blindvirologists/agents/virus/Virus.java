package main.com.teamalfa.blindvirologists.agents.virus;
import main.com.teamalfa.blindvirologists.agents.Agent;
import main.com.teamalfa.blindvirologists.virologist.Virologist;

abstract public class Virus extends Agent {
    @Override
    public void apply(Virologist target) {
        if(target.infectedBy(this)) {
            this.target = target;
        }
    }
}
