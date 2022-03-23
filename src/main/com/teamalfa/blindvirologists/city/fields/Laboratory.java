package main.com.teamalfa.blindvirologists.city.fields;

import main.com.teamalfa.blindvirologists.agents.genetic_code.GeneticCode;
import main.com.teamalfa.blindvirologists.virologist.Virologist;

public class Laboratory extends Field{
    private GeneticCode geneticCode = null;

    @Override
    public void searchedBy(Virologist virologist) {

    }

    public void setGeneticCode(GeneticCode geneticCode) {
        this.geneticCode = geneticCode;
    }
}
