package main.com.teamalfa.blindvirologists.city.fields;

import main.com.teamalfa.blindvirologists.equipments.Equipment;

import java.util.ArrayList;

public class SafeHouse extends Field{
    private ArrayList<Equipment> equipments;

    public SafeHouse() {
        equipments = new ArrayList<>();
    }

    public void add(Equipment equipment) {
        equipments.add(equipment);
    }

    public void remove(Equipment equipment) {
        equipments.remove(equipment);
    }
}