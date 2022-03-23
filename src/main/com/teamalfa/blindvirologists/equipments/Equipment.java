package main.com.teamalfa.blindvirologists.equipments;

import main.com.teamalfa.blindvirologists.virologist.Virologist;

abstract public class Equipment {
    private Virologist virologist;

    public void unEquip(){
        virologist.removeWorn(this);
    }

    public void Equip(){
        virologist.addWorn(this);
    }
}
