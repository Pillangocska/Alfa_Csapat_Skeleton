package main.com.teamalfa.blindvirologists.agents.genetic_code;
import main.com.teamalfa.blindvirologists.agents.Vaccine;
import main.com.teamalfa.blindvirologists.agents.virus.AmnesiaVirus;
import main.com.teamalfa.blindvirologists.virologist.backpack.ElementBank;

public class AmnesiaCode extends GeneticCode {
    @Override
    public AmnesiaVirus createVirus(ElementBank elementBank) {
        return new AmnesiaVirus();
    }

    @Override
    public Vaccine createVaccine(ElementBank elementBank) {
        return new Vaccine(this);
    }
}