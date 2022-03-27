package main.com.teamalfa.blindvirologists.agents.genetic_code;
import main.com.teamalfa.blindvirologists.agents.Vaccine;
import main.com.teamalfa.blindvirologists.agents.virus.DanceVirus;

public class DanceCode extends GeneticCode{

    /**
     * This method creates a Virus with the dance geneticcode.
     * @return The DanceVirus that has been created.
     */
    @Override
    public DanceVirus createVirus() {
        return new DanceVirus();
    }

    /**
     * This method create a Vaccine with the dance geneticcode.
     * @return The Vaccine that has been created.
     */
    @Override
    public Vaccine createVaccine() {
        return new Vaccine(this);
    }
}
