package main.com.teamalfa.blindvirologists.agents.genetic_code;
import main.com.teamalfa.blindvirologists.agents.Vaccine;
import main.com.teamalfa.blindvirologists.agents.virus.AmnesiaVirus;

public class AmnesiaCode extends GeneticCode {
    @Override
    public AmnesiaVirus createVirus() {
        return new AmnesiaVirus();
    }

    @Override
    public Vaccine createVaccine() {
        return new Vaccine(this);
    }
}
