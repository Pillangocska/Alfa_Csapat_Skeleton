package main.com.teamalfa.blindvirologists.agents.genetic_code;
import main.com.teamalfa.blindvirologists.agents.Vaccine;
import main.com.teamalfa.blindvirologists.agents.virus.ParalyzeVirus;

public class ParalyzeCode extends GeneticCode{
    @Override
    public ParalyzeVirus createVirus() {
        return new ParalyzeVirus();
    }

    @Override
    public Vaccine createVaccine() {
        return new Vaccine(this);
    }
}
