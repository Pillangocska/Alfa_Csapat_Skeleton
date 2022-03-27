package main.com.teamalfa.blindvirologists.virologist.backpack;

import main.com.teamalfa.blindvirologists.AController;
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
        equipmentPocket = new EquipmentPocket(this);
        agentPocket = new AgentPocket(this);
        elementBank = new ElementBank(0,0);
        geneticCodePocket = new GeneticCodePocket(this);
        this.virologist = virologist;
    }

    public void registerObjects() {
        AController.registerObject(this, equipmentPocket, "eqPocket"); equipmentPocket.registerObjects();
        AController.registerObject(this, agentPocket, "agPocket"); agentPocket.registerObjects();
        AController.registerObject(this, elementBank, "elBank");
        AController.registerObject(this, geneticCodePocket, "gcPocket");
    }

    public void add(Equipment equipment) {
        if(equipmentPocket.getEquipmentHolder().add(equipment)){
            SafeHouse safeHouse = (SafeHouse) virologist.getField();
            safeHouse.remove(equipment);
        }
    }

    public void add(GeneticCode geneticCode) {
        AController.printCall(this, "add", new Object[]{geneticCode});
        geneticCodePocket.getGeneticCodes().add(geneticCode);
        AController.printReturn(null);
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

    public EquipmentPocket getEquipmentPocket(){
        return equipmentPocket;
    }

    public void deleteAllGeneticCodes() {
        geneticCodePocket.deleteAll();
    }

    public ElementBank getElementBank() {
        return elementBank;
    }
}