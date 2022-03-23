package main.com.teamalfa.blindvirologists.city.fields;
import main.com.teamalfa.blindvirologists.equipments.Equipment;
import main.com.teamalfa.blindvirologists.virologist.Virologist;

import java.util.ArrayList;
import java.util.List;

public class Field {
    //Virologists on the field
    protected ArrayList<Virologist> virologists = new ArrayList<>();
    //Neighbouring fields
    protected ArrayList<Field> neighbours = new ArrayList<>();

    //Constructor todo
    public Field(){

    }

    //Getters&Setters
    public ArrayList<Virologist> getVirologists(){
        return virologists;
    }
    public ArrayList<Field> getNeighbours(){
        return neighbours;
    }

    //Adding and removing a virologist
    public void accept(Virologist virologist){
        virologists.add(virologist);
    }

    public void remove(Virologist virologist){
        virologists.remove(virologist);
    }

    //Gives back the virologists on the field
    //except the one calling it todo
    public List<Virologist> searchForVirologist(){ return null; }

    //Doesn't do anything
    public void searchedBy(Virologist virologist){}
    //todo
    public boolean canChangeEquipment() {
        return false;
    }
    public void add(Equipment e) { }
}
