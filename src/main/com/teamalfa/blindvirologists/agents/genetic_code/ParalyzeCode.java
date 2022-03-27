package main.com.teamalfa.blindvirologists.agents.genetic_code;
import main.com.teamalfa.blindvirologists.AController;
import main.com.teamalfa.blindvirologists.agents.Vaccine;
import main.com.teamalfa.blindvirologists.agents.virus.ParalyzeVirus;
import main.com.teamalfa.blindvirologists.virologist.backpack.ElementBank;

public class ParalyzeCode extends GeneticCode{
    @Override
    public ParalyzeVirus createVirus(ElementBank elementBank) {
        // print out method call
        AController.printCall(this, "createVirus", new Object[]{elementBank});

        // create paralyze virus and register its name to the controller
        ParalyzeVirus pv = new ParalyzeVirus();
        AController.registerObject(null, pv, "paralyzeVirus");
        // register nested objects
        pv.registerObjects();

        // handle cost
        ElementBank cost = pv.getCost();
        if(elementBank.remove(cost)) {
            return (ParalyzeVirus) AController.printReturn(pv);
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
