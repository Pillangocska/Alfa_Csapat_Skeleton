package main.com.teamalfa.blindvirologists.virologist;

import main.com.teamalfa.blindvirologists.agents.Vaccine;
import main.com.teamalfa.blindvirologists.agents.genetic_code.GeneticCode;
import main.com.teamalfa.blindvirologists.agents.virus.Virus;

import java.util.ArrayList;

public class Virologist {
    private ArrayList<GeneticCode> protectionBank;
    private ArrayList<Virus> activeViruses;

    public Virologist() {
        protectionBank = new ArrayList<>();
        activeViruses = new ArrayList<>();
    }


    public boolean infectedBy(Virus virus) {
        // Temporary implementation.
        activeViruses.add(virus);
        return true;
    }

    public void protectedBy(GeneticCode geneticCode) {
        protectionBank.add(geneticCode);
    }

    public void removeVirus(Virus virus) {
        activeViruses.remove(virus);
    }

    public void removeProtection(GeneticCode geneticCode) {
        protectionBank.remove(geneticCode);
    }
}
