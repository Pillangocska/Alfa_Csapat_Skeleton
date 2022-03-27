
package main.com.teamalfa.blindvirologists.agents;

import main.com.teamalfa.blindvirologists.AController;
import main.com.teamalfa.blindvirologists.agents.genetic_code.GeneticCode;
import main.com.teamalfa.blindvirologists.virologist.Virologist;
import main.com.teamalfa.blindvirologists.virologist.backpack.ElementBank;

abstract public class Agent {
    protected ElementBank cost;
    protected Virologist target = null;
    protected GeneticCode geneticCode;

    public Agent() {
        cost = new ElementBank(0,0);
    }

    public void registerObjects() {
        AController.registerObject(this, cost, "cost");
    }

    public GeneticCode getGeneticCode() {
        return geneticCode;
    }

    abstract public void apply(Virologist target);

    public ElementBank getCost() {
        AController.printCall(this, "getCost", null);
        return (ElementBank) AController.printReturn(cost);
    }
}