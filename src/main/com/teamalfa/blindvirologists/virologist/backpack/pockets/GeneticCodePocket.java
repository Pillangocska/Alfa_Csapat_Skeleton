package main.com.teamalfa.blindvirologists.virologist.backpack.pockets;

import main.com.teamalfa.blindvirologists.agents.genetic_code.GeneticCode;

import java.util.ArrayList;

public class GeneticCodePocket extends Pocket{
    private ArrayList<GeneticCode> geneticCodes;

    public GeneticCodePocket() {
        geneticCodes = new ArrayList<>();
    }

    public void add(GeneticCode geneticCode) {
        geneticCodes.add(geneticCode);
    }

    public void deleteAll() {
        geneticCodes.clear();
    }
}
