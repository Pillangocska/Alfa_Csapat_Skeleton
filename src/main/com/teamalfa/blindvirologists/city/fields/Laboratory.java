package main.com.teamalfa.blindvirologists.city.fields;

import main.com.teamalfa.blindvirologists.agents.genetic_code.GeneticCode;
import main.com.teamalfa.blindvirologists.virologist.Virologist;

public class Laboratory extends Field{
    private GeneticCode geneticCode;

    @Override
    public void searchedBy(Virologist virologist) {
        virologist.getBackpack().add(geneticCode);
        //Printouts
        System.out.println("Laboratory.searchedBy()");
    }

    public void setGeneticCode(GeneticCode geneticCode) {
        this.geneticCode = geneticCode;
    }
}