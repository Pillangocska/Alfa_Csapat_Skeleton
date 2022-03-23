package main.com.teamalfa.blindvirologists.equipments.active_equipments;

import main.com.teamalfa.blindvirologists.agents.virus.Virus;
import main.com.teamalfa.blindvirologists.equipments.Equipment;
import main.com.teamalfa.blindvirologists.virologist.Virologist;

abstract public class ActiveEquipment extends Equipment {

    public abstract void use(Virologist v, Virus virus);

    public void equip(){
        virologist.addWorn(this);
        virologist.addActive(this);
    }

    public void unEquip(){
        virologist.removeWorn(this);
        virologist.removeActive(this);
    }

}
