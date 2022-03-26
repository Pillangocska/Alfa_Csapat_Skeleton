package main.com.teamalfa.blindvirologists.equipments;

import main.com.teamalfa.blindvirologists.virologist.Virologist;

abstract public class Equipment {
    protected Virologist virologist;

    public void unEquip(){
        virologist.removeWorn(this);
    }

    public void equip(){
        virologist.addWorn(this);
    }

    public boolean protect() {
        return false;
    }
}
