package main.com.teamalfa.blindvirologists.virologist.backpack.pockets;

import main.com.teamalfa.blindvirologists.equipments.Equipment;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EquipmentPocket extends Pocket{

    private Backpack backpack;
    private ArrayList<Equipment> equipmentHolder = new ArrayList<Equipment>();
    private ArrayList<Equipment> wornequipments= new ArrayList<Equipment>();

    private void toggle(Equipment e){
        Virologist v = backpack.getVirologist();
        Field f = v.getField();
        if(f.canChangeEquipment)
    }


}
