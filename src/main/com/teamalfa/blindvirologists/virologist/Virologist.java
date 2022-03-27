package main.com.teamalfa.blindvirologists.virologist;

import main.com.teamalfa.blindvirologists.AController;
import main.com.teamalfa.blindvirologists.agents.Agent;
import main.com.teamalfa.blindvirologists.agents.Vaccine;
import main.com.teamalfa.blindvirologists.agents.genetic_code.GeneticCode;
import main.com.teamalfa.blindvirologists.agents.virus.Virus;
import main.com.teamalfa.blindvirologists.agents.virus.VirusComparator;
import main.com.teamalfa.blindvirologists.city.fields.Field;
import main.com.teamalfa.blindvirologists.equipments.Equipment;
import main.com.teamalfa.blindvirologists.equipments.active_equipments.ActiveEquipment;
import main.com.teamalfa.blindvirologists.virologist.backpack.Backpack;

import java.util.ArrayList;
import java.util.Collections;

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

    public void registerObjects() {
        AController.registerObject(this, protectionBank, "protectionBank");
        AController.registerObject(this, activeViruses, "activeViruses");
        AController.registerObject(this, backpack, "backpack");

        // register nested objects
        backpack.registerObjects();
    }

    public Field getField() {
        AController.printCall(this, "getField", null);
        return (Field) AController.printReturn(field);
    }
    public void setField(Field f){
        this.field = f;
    }

    public Backpack getBackpack() {
        AController.printCall(this, "getBackpack", null);
        return (Backpack) AController.printReturn(backpack);
    }

    public void move(Field destination) {
        AController.printCall(this, "move", new Object[]{destination});

        Field modified = null;

        if(!activeViruses.isEmpty()) modified = activeViruses.get(0).affectMovement(field);
        if(modified != null) destination = modified;

        field.remove(this);
        destination.accept(this);
        field = destination;

        AController.printReturn(null);
    }

    public void use(ActiveEquipment a, Virologist v) {
        //todo
    }

    public void use(Agent a, Virologist v){
        AController.printCall(this, "use", new Object[] {a, v});
        if (!checkUsageAffect())
            a.apply(v);
        AController.printReturn(null);
    }

    public void learn(GeneticCode gc) {
        if(!(this.checkUsageAffect())) {
            backpack.add(gc);
        }
    }

    public Backpack robbed() {
        AController.printCall(this, "robbed", null);
        if(!(activeViruses.isEmpty())){
            if(activeViruses.get(0).affectRobbability()){
                return (Backpack) AController.printReturn(this.backpack);
            }
        }
        AController.printReturn( "robbed");
        return null;
    }

    public void rob(Virologist v) {
        AController.printCall(this, "rob", new Object[] {v});
        v.robbed();
        AController.printReturn(null);
    }

    public boolean infectedBy(Virus virus) {
        // print method call
        AController.printCall(this, "infectedBy", new Object[]{virus});

        Boolean ret = true;

        // check if protected by any vaccine
        if(protectionBank.contains(virus.getGeneticCode())) {
            ret = false;
        }else {
            // check if protected by any equipment
            for(Equipment equipment : wornEquipments)
                if(equipment.protect())
                    ret = false;
        }
        activeViruses.add(virus);

        // print return value to console
        return (Boolean) AController.printReturn(ret);
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
        AController.printCall(this, "search", null);
        field.searchedBy(this);
        AController.printReturn(null);
    }

    //todo searchForVirologist

    private boolean checkUsageAffect() {
        AController.printCall(this, "checkUsageAffect", null);
        if(activeViruses.isEmpty()){
            AController.printReturn(false);
            return false;
        }

        AController.printReturn(activeViruses.get(0).affectUsage());
        return activeViruses.get(0).affectUsage();
    }

    public void addVirus(Virus virus) {
        AController.printCall(this, "addVirus", new Object[] {virus});
        activeViruses.add(virus);
        sortViruses();
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

    private void sortViruses(){
        Collections.sort(activeViruses, new VirusComparator());
    }
}