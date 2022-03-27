package main.com.teamalfa.blindvirologists.virologist.backpack;

import main.com.teamalfa.blindvirologists.agents.genetic_code.GeneticCode;
import main.com.teamalfa.blindvirologists.city.fields.SafeHouse;
import main.com.teamalfa.blindvirologists.equipments.Equipment;
import main.com.teamalfa.blindvirologists.virologist.Virologist;
import main.com.teamalfa.blindvirologists.virologist.backpack.pockets.AgentPocket;
import main.com.teamalfa.blindvirologists.virologist.backpack.pockets.EquipmentPocket;
import main.com.teamalfa.blindvirologists.virologist.backpack.pockets.GeneticCodePocket;

public class Backpack {
    private EquipmentPocket equipmentPocket;
    private AgentPocket agentPocket;
    private ElementBank elementBank;
    private GeneticCodePocket geneticCodePocket;
    private Virologist virologist;

    public Backpack(Virologist virologist) {
        equipmentPocket = new EquipmentPocket();
        agentPocket = new AgentPocket();
        elementBank = new ElementBank();
        geneticCodePocket = new GeneticCodePocket();
        this.virologist = virologist;
    }

    public void add(Equipment equipment) {
        if(equipmentPocket.add(equipment)){
            SafeHouse safeHouse = (SafeHouse) virologist.getField();
            safeHouse.remove(equipment);
        };
    }

    public void add(GeneticCode geneticCode) {
        geneticCodePocket.add(geneticCode);
    }

    public void createVirus(GeneticCode geneticCode) {
        // TODO
    }

    public void createVaccine(GeneticCode geneticCode) {
        // TODO
    }


    public Virologist getVirologist() {
        return virologist;
    }
}
