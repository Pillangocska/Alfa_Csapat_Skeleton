package main.com.teamalfa.blindvirologists.virologist.backpack.pockets;

import main.com.teamalfa.blindvirologists.GodController;
import main.com.teamalfa.blindvirologists.city.fields.Field;
import main.com.teamalfa.blindvirologists.city.fields.SafeHouse;
import main.com.teamalfa.blindvirologists.equipments.Equipment;
import main.com.teamalfa.blindvirologists.virologist.Virologist;
import main.com.teamalfa.blindvirologists.virologist.backpack.Backpack;

import java.util.ArrayList;
import java.util.Scanner;

public class EquipmentPocket extends Pocket{

    private Backpack backpack;
    private ArrayList<Equipment> equipmentHolder = new ArrayList<>();
    private ArrayList<Equipment> wornEquipments= new ArrayList<>();

    public Backpack getBackpack() { return backpack; }

    public void setBackpack(Backpack b) { backpack = b; }

    public ArrayList<Equipment> getEquipmentHolder() { return equipmentHolder; }

    public void setEquipEquipmentHolder(ArrayList<Equipment> e) { equipmentHolder = e; }

    public ArrayList<Equipment> getWornEquipments() { return wornEquipments; }

    public void setWornEquipments(ArrayList<Equipment> e) { wornEquipments = e; }



    public void toggle(Equipment equipment){
        Virologist v = backpack.getVirologist();
        Field f = v.getField();
        if(f.canChangeEquipment()){
            if(wornEquipments.contains(equipment))
                equipment.unEquip();
            else
                equipment.equip();
        }
    }

    public void toss(Equipment equipment){
        if(!(wornEquipments.contains(equipment))){
            Virologist v = backpack.getVirologist();
            Field f = v.getField();
            if(f.canChangeEquipment()){
                equipmentHolder.remove(equipment);
                SafeHouse sh = (SafeHouse) f;
                sh.add(equipment);
            }
        }
    }

    public boolean add(Equipment equipment) {
        if(GodController.askYesOrNo("Is the backpack full? (y/n)")) {
            return false;
        }else {
            equipmentHolder.add(equipment);
            return true;
        }
    }


}