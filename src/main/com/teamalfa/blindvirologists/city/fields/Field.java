package main.com.teamalfa.blindvirologists.city.fields;
import main.com.teamalfa.blindvirologists.AController;
import main.com.teamalfa.blindvirologists.equipments.Equipment;
import main.com.teamalfa.blindvirologists.virologist.Virologist;

import java.lang.reflect.Array;
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
        AController.printCall(this, "accept", new Object[]{virologist});
        virologists.add(virologist);
        AController.decCallCount();
    }

    public void remove(Virologist virologist){
        AController.printCall(this, "remove", new Object[]{virologist});
        virologists.remove(virologist);
        AController.decCallCount();
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

    public void setNeighbour(Field f1) {
        this.neighbours.add(f1);
    }

    public void setNeighbours(ArrayList<Field> neighbours) {
        this.neighbours = neighbours;
    }
}
