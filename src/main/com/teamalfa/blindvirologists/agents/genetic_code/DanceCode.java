package main.com.teamalfa.blindvirologists.agents.genetic_code;
import main.com.teamalfa.blindvirologists.AController;
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
        AController.printCall(this, "createVaccine", new Object[]{elementBank});

        Vaccine dv = new Vaccine(this);
        AController.registerObject(null, dv, "DanceVaccine");
        // register nested objects
        dv.registerObjects();

        // handle cost
        ElementBank cost = dv.getCost();
        if(elementBank.remove(cost)) {
            return (Vaccine) AController.printReturn(dv);
        }

        // Null return can be printed out like this
        AController.printReturn("null");
        return null;
    }
}
