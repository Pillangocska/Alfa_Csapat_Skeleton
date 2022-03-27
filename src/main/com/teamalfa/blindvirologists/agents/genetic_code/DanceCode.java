package main.com.teamalfa.blindvirologists.agents.genetic_code;
import main.com.teamalfa.blindvirologists.agents.Vaccine;
import main.com.teamalfa.blindvirologists.agents.virus.DanceVirus;
import main.com.teamalfa.blindvirologists.virologist.backpack.ElementBank;

public class DanceCode extends GeneticCode{

    /**
     * This method creates a Virus with the dance geneticcode.
     * @return The DanceVirus that has been created.
     */
    @Override
    public DanceVirus createVirus(ElementBank elementBank) {
        return new DanceVirus();
    }

    /**
     * This method create a Vaccine with the dance geneticcode.
     * @return The Vaccine that has been created.
     */
    @Override
    public Vaccine createVaccine(ElementBank elementBank) {
        return new Vaccine(this);
    }
}
