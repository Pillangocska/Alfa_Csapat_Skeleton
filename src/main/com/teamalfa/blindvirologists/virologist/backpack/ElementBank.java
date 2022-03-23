package main.com.teamalfa.blindvirologists.virologist.backpack;

public class ElementBank {
    private int maxSize;

    public void increaseMaxSize(int extraSize) {
        maxSize += extraSize;
    }


    public void decreaseMaxSize(int extraSize) {
        maxSize -= extraSize;
    }
}
