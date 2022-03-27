package main.com.teamalfa.blindvirologists.agents;

import main.com.teamalfa.blindvirologists.agents.genetic_code.*;

import java.util.ArrayList;

public class GeneticCodeBank {
    private static GeneticCodeBank instance = null;
    private ArrayList<GeneticCode> codes;

    private GeneticCodeBank() {
        codes = new ArrayList<>();
        codes.add(new ParalyzeCode());
        codes.add(new DanceCode());
        codes.add(new AmnesiaCode());
    }

    /**
     * Creates one object in the beginning of the game.
     */
    static {
        instance = new GeneticCodeBank();
    }

    public ArrayList<GeneticCode> getCodes() {
        return codes;
    }

    public static GeneticCodeBank getInstance() {
        return instance;
    }

}