package main.com.teamalfa.blindvirologists.agents.genetic_code;
import main.com.teamalfa.blindvirologists.agents.Vaccine;
import main.com.teamalfa.blindvirologists.agents.virus.ParalyzeVirus;

public class ParalyzeCode extends GeneticCode{

    /**
     * This method creates a Virus with the paralyze geneticcode.
     * @return The ParalyzeVirus that has been created.
     */
    @Override
    public ParalyzeVirus createVirus() {
        return new ParalyzeVirus();
    }

    /**
     * This method create a Vaccine with the paralyze geneticcode.
     * @return The Vaccine that has been created.
     */
    @Override
    public Vaccine createVaccine() {
        return new Vaccine(this);
    }
}
