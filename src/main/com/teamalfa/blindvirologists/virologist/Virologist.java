package main.com.teamalfa.blindvirologists.virologist;

import main.com.teamalfa.blindvirologists.agents.Vaccine;
import main.com.teamalfa.blindvirologists.agents.genetic_code.GeneticCode;
import main.com.teamalfa.blindvirologists.agents.virus.Virus;
import main.com.teamalfa.blindvirologists.city.fields.Field;
import main.com.teamalfa.blindvirologists.virologist.backpack.Backpack;

import java.util.ArrayList;

public class Virologist {
    private ArrayList<GeneticCode> protectionBank;
    private ArrayList<Virus> activeViruses;
    private Backpack backpack;
    private Field field;

    public Virologist() {
        protectionBank = new ArrayList<>();
        activeViruses = new ArrayList<>();
        backpack = new Backpack();
    }


    public boolean infectedBy(Virus virus) {
        // Temporary implementation.
        activeViruses.add(virus);
        return true;
    }

    public void protectedBy(Vaccine vaccine) {
        protectionBank.add(vaccine.getGeneticCode());
    }

    public void removeVirus(Virus virus) {
        activeViruses.remove(virus);
    }

    public void removeProtection(Vaccine vaccine) {
        protectionBank.remove(vaccine.getGeneticCode());
    }

    public Field getField() {
        return field;
    }
}
