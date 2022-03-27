package main.com.teamalfa.blindvirologists.agents.genetic_code;
import main.com.teamalfa.blindvirologists.agents.Vaccine;
import main.com.teamalfa.blindvirologists.agents.virus.AmnesiaVirus;

public class AmnesiaCode extends GeneticCode {
    /**
     * This method creates a Virus with the amnesia geneticcode.
     * @return The AmnesiaVirus that has been created.
     */
    @Override
    public AmnesiaVirus createVirus() {
        return new AmnesiaVirus();
    }

    /**
     * This method create a Vaccine with the amnesia geneticcode.
     * @return The Veccine that has been created.
     */
    @Override
    public Vaccine createVaccine() {
        return new Vaccine(this);
    }
}