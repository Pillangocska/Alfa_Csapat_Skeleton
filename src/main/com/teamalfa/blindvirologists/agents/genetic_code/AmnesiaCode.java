package main.com.teamalfa.blindvirologists.agents.genetic_code;
import main.com.teamalfa.blindvirologists.AController;
import main.com.teamalfa.blindvirologists.agents.Vaccine;
import main.com.teamalfa.blindvirologists.agents.virus.AmnesiaVirus;
import main.com.teamalfa.blindvirologists.agents.virus.ParalyzeVirus;
import main.com.teamalfa.blindvirologists.virologist.backpack.ElementBank;

public class AmnesiaCode extends GeneticCode {
    @Override
    public AmnesiaVirus createVirus(ElementBank elementBank) {
        // print out method call
        AController.printCall(this, "createVirus", new Object[]{elementBank});

        // create paralyze virus and register its name to the controller
        AmnesiaVirus av = new AmnesiaVirus();
        AController.registerObject(null, av, "amnesiaVirus");
        // register nested objects
        av.registerObjects();

        // handle cost
        ElementBank cost = av.getCost();
        if(elementBank.remove(cost)) {
            return (AmnesiaVirus) AController.printReturn(av);
        }

        // Null return can be printed out like this
        AController.printReturn("null");
        return null;
    }

    @Override
    public Vaccine createVaccine(ElementBank elementBank) {
        return new Vaccine(this);
    }
}