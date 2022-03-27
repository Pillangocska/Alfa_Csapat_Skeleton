package main.com.teamalfa.blindvirologists.city.fields;

import main.com.teamalfa.blindvirologists.AController;
import main.com.teamalfa.blindvirologists.agents.genetic_code.GeneticCode;
import main.com.teamalfa.blindvirologists.virologist.Virologist;

public class Laboratory extends Field{
    private GeneticCode geneticCode;

    @Override
    public void searchedBy(Virologist virologist) {
        AController.printCall(this, "searchedBy", new Object[]{virologist});
        virologist.getBackpack().add(geneticCode);
        AController.printReturn(null);
    }
    public void setGeneticCode(GeneticCode geneticCode) {
        this.geneticCode = geneticCode;
    }
}