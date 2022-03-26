package main.com.teamalfa.blindvirologists.virologist.backpack.pockets;

import main.com.teamalfa.blindvirologists.city.fields.Field;
import main.com.teamalfa.blindvirologists.equipments.Equipment;
import main.com.teamalfa.blindvirologists.virologist.Virologist;
import main.com.teamalfa.blindvirologists.virologist.backpack.Backpack;

import java.util.ArrayList;

public class EquipmentPocket extends Pocket{

    private Backpack backpack;
    private ArrayList<Equipment> equipmentHolder = new ArrayList<>();
    private ArrayList<Equipment> wornEquipments= new ArrayList<>();
    //private int wornSize;

    public EquipmentPocket(Backpack b){
        backpack = b;
        //wornSize = 3;
        maxSize = 5;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack b) {
        backpack = b;
    }

    public ArrayList<Equipment> getEquipmentHolder() {
        return equipmentHolder;
    }

    public void setEquipEquipmentHolder(ArrayList<Equipment> e) {
        equipmentHolder = e;
    }

    public ArrayList<Equipment> getWornEquipments() {
        return wornEquipments;
    }

    public void setWornEquipments(ArrayList<Equipment> e) {
        wornEquipments = e;
    }

    public boolean add(Equipment e) {
        if(equipmentHolder.size()+ 1 <= maxSize){
            equipmentHolder.add(e);
            return true;
        }
        return false;
    }

    public void toggle(Equipment e){
        Virologist v = backpack.getVirologist();
        Field f = v.getField();
        if(f.canChangeEquipment()){
            if(wornEquipments.contains(e))
                e.unEquip();
            else
                e.equip();
        }
    }


    public void toss(Equipment e){
        if(!(wornEquipments.contains(e))){
            Virologist v = backpack.getVirologist();
            Field f = v.getField();
            if(f.canChangeEquipment()){
                equipmentHolder.remove(e);
                f.add(e);
            }
        }
    }

    @Override
    public int getCurrentSize() {
        return equipmentHolder.size();
    }
}
