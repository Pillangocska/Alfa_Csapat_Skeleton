package main.com.teamalfa.blindvirologists.city.fields;
import main.com.teamalfa.blindvirologists.AController;
import main.com.teamalfa.blindvirologists.virologist.Virologist;
import main.com.teamalfa.blindvirologists.virologist.backpack.ElementBank;

public class StoreHouse extends Field {

    private ElementBank elements;
    public StoreHouse(){ elements = new ElementBank(0,0); }
    public StoreHouse(int amino, int nucleotide) {
        elements = new ElementBank(amino, nucleotide);
    }

    public void registerObjects() {
        AController.registerObject(this, elements, "elements"+elements.getAminoAcid() +"_"+ elements.getNucleotide());
    }

    @Override
    public void searchedBy(Virologist virologist) {
        AController.printCall(this, "searchedBy", new Object[]{virologist});
        virologist.getBackpack().add(elements);
        AController.printReturn(null);
    }

    public void setElements(ElementBank elements) {
        this.elements = elements;
    }
}
