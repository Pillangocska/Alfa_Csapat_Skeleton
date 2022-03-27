package main.com.teamalfa.blindvirologists.agents.genetic_code;
import main.com.teamalfa.blindvirologists.agents.Vaccine;
import main.com.teamalfa.blindvirologists.agents.virus.DanceVirus;
import main.com.teamalfa.blindvirologists.virologist.backpack.ElementBank;

public class DanceCode extends GeneticCode{
    @Override
    public DanceVirus createVirus(ElementBank elementBank) {
        return new DanceVirus();
    }

    @Override
    public Vaccine createVaccine(ElementBank elementBank) {
        return new Vaccine(this);
    }
}
