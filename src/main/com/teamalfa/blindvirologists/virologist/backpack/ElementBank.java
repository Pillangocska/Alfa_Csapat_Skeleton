package main.com.teamalfa.blindvirologists.virologist.backpack;

public class ElementBank {
    private int aminoAcid;
    private int nucleotide;
    private int aminoAcidMaxSize;
    private int nucleotideMaxSize;

    public ElementBank(int amino, int nucleotide){
        this.aminoAcid = amino;
        this.nucleotide = nucleotide;
        aminoAcidMaxSize = 20;
        nucleotideMaxSize = 20;

    }

    public void increaseMaxSize(int extraSize) {
        aminoAcidMaxSize += extraSize;
        nucleotideMaxSize += extraSize;
    }


    public void decreaseMaxSize(int extraSize) {
        aminoAcidMaxSize -= extraSize;
        nucleotideMaxSize -= extraSize;
    }
}
