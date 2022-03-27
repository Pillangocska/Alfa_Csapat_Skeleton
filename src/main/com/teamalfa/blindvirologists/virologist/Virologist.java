package main.com.teamalfa.blindvirologists.virologist;

import main.com.teamalfa.blindvirologists.AController;
import main.com.teamalfa.blindvirologists.agents.Agent;
import main.com.teamalfa.blindvirologists.agents.Vaccine;
import main.com.teamalfa.blindvirologists.agents.genetic_code.GeneticCode;
import main.com.teamalfa.blindvirologists.agents.virus.Virus;
import main.com.teamalfa.blindvirologists.city.fields.Field;
import main.com.teamalfa.blindvirologists.equipments.Equipment;
import main.com.teamalfa.blindvirologists.equipments.active_equipments.ActiveEquipment;
import main.com.teamalfa.blindvirologists.virologist.backpack.Backpack;

import java.util.ArrayList;

public class Virologist {
    private ArrayList<GeneticCode> protectionBank;
    private ArrayList<Virus> activeViruses;
    private ArrayList<Equipment> wornEquipment = new ArrayList<>();
    private ArrayList<ActiveEquipment> activeEquipments = new ArrayList<>();
    private Backpack backpack;
    private Field field;

    public Virologist() {
        protectionBank = new ArrayList<>();
        activeViruses = new ArrayList<>();
        backpack = new Backpack(this);
    }

    public Field getField() {
        return field;
    }
    public void setField(Field f){
        this.field = f;
    }

    public Backpack getBackpack() { return backpack; }

    public void move(Field destination) {
        AController.printCall(this, "move", new Object[]{destination});

        Field modified = null;
        for(Virus virus : activeViruses) {
            modified = virus.affectMovement(field);
        }


        if(modified != null) destination = modified;

        field.remove(this);
        destination.accept(this);
        field = destination;

        AController.decCallCount();
    }

    public void use(ActiveEquipment a, Virologist v) {
        //todo
    }

    public void use(Agent a, Virologist v){
        a.apply(v);
    }

    public void learn(GeneticCode gc) {
        if(!(this.checkUsageAffect())) {
            backpack.add(gc);
        }
    }

    public Backpack robbed() {
        if(!(activeViruses.isEmpty())){
            if(activeViruses.get(0).affectRobbability())
                return this.backpack;
        }
        return null;
    }

    public void rob(Virologist v) {
        v.robbed();
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

    public void removeVaccine(Vaccine vaccine) {
        protectionBank.remove(vaccine.getGeneticCode());
    }

    public void search() {
        field.searchedBy(this);
        //Printouts
        System.out.println("Virologist.search()");
    }

    //todo searchForVirologist

    private boolean checkUsageAffect() {
        if(activeViruses.isEmpty())
            return false;
        else return activeViruses.get(0).affectUsage();
    }

    public void addVirus(Virus virus) {
        activeViruses.add(virus);
    }

    private boolean checkRobbable() {
        //todo ilyet sehol se használunk
        return true;
    }

    public void removeWorn(Equipment equipment) {
        wornEquipment.remove(equipment);
    }

    public void addWorn(Equipment equipment) {
        if(wornEquipment.size() < 3)
            wornEquipment.add(equipment);
    }

    public void addActive(ActiveEquipment activeEquipment) {
        if(wornEquipment.size() < 3)
            activeEquipments.add(activeEquipment);
    }

    public void removeActive(ActiveEquipment activeEquipment) {
        activeEquipments.remove(activeEquipment);
    }
}