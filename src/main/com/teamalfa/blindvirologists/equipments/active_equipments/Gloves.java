package main.com.teamalfa.blindvirologists.equipments.active_equipments;

import main.com.teamalfa.blindvirologists.agents.virus.Virus;
import main.com.teamalfa.blindvirologists.virologist.Virologist;

public class Gloves extends ActiveEquipment {

    public void use(Virologist v, Virus virus){
        virus.apply(v);
    }
}
