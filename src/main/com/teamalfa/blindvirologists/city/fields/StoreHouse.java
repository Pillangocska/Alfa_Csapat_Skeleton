package main.com.teamalfa.blindvirologists.city.fields;
import main.com.teamalfa.blindvirologists.virologist.Virologist;
import main.com.teamalfa.blindvirologists.virologist.backpack.ElementBank;

public class StoreHouse extends Field {

    private ElementBank elements;
    public StoreHouse(){ elements = null; }
    public StoreHouse(int amino, int nucleotid) {
        elements = new ElementBank(amino, nucleotid);
    }

    @Override
    public void searchedBy(Virologist virologist) {
        //todo
    }
}
