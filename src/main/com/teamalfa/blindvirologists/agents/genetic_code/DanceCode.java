package main.com.teamalfa.blindvirologists.agents.genetic_code;
import main.com.teamalfa.blindvirologists.AController;
import main.com.teamalfa.blindvirologists.agents.Vaccine;
import main.com.teamalfa.blindvirologists.agents.virus.AmnesiaVirus;
import main.com.teamalfa.blindvirologists.agents.virus.DanceVirus;
import main.com.teamalfa.blindvirologists.virologist.backpack.ElementBank;

public class DanceCode extends GeneticCode{
    @Override
    public DanceVirus createVirus(ElementBank elementBank) {
        // print out method call
        AController.printCall(this, "createVirus", new Object[]{elementBank});

        // create paralyze virus and register its name to the controller
        DanceVirus dv = new DanceVirus();
        AController.registerObject(null, dv, "danceVirus");
        // register nested objects
        dv.registerObjects();

        // handle cost
        ElementBank cost = dv.getCost();
        if(elementBank.remove(cost)) {
            return (DanceVirus) AController.printReturn(dv);
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
