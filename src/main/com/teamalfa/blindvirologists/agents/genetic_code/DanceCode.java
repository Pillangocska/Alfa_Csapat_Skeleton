package main.com.teamalfa.blindvirologists.agents.genetic_code;
import main.com.teamalfa.blindvirologists.agents.Vaccine;
import main.com.teamalfa.blindvirologists.agents.virus.DanceVirus;

public class DanceCode extends GeneticCode{
    @Override
    public DanceVirus createVirus() {
        return new DanceVirus();
    }

    @Override
    public Vaccine createVaccine() {
        return new Vaccine(this);
    }
}
