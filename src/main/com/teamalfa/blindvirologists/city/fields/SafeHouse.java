package main.com.teamalfa.blindvirologists.city.fields;

import main.com.teamalfa.blindvirologists.AController;
import main.com.teamalfa.blindvirologists.equipments.Equipment;
import main.com.teamalfa.blindvirologists.virologist.Virologist;

import java.util.ArrayList;

public class SafeHouse extends Field{
    private ArrayList<Equipment> equipments;

    public SafeHouse() {
        equipments = new ArrayList<>();
    }

    public void registerChoices() {
        AController.registerObject(null, equipments, "equipments");
    }

    public void add(Equipment equipment) {
        AController.printCall(this, "add", new Object[]{equipment});
        equipments.add(equipment);
        AController.registerObject(null, equipments, "equipments");
        AController.printReturn(null);
    }

    public void remove(Equipment equipment) {
        AController.printCall(this, "remove", new Object[]{equipment});
        equipments.remove(equipment);
        AController.printReturn(null);
    }

    @Override
    public void searchedBy(Virologist virologist) {
        AController.printCall(virologist, "searchedBy", new Object[]{virologist});
        virologist.getBackpack().add((Equipment) AController.askMultiChoice("equipment", migrateChoices(equipments)));
        AController.printReturn(null);
    }

    private ArrayList<Object> migrateChoices(ArrayList<Equipment> equipments) {
        ArrayList<Object> choices = new ArrayList<>();
        for(Equipment equipment : equipments)
            choices.add(equipment);
        return choices;
    }
}