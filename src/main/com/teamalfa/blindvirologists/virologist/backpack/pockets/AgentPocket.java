package main.com.teamalfa.blindvirologists.virologist.backpack.pockets;

import main.com.teamalfa.blindvirologists.agents.Agent;
import main.com.teamalfa.blindvirologists.virologist.backpack.Backpack;

import java.util.ArrayList;

public class AgentPocket extends Pocket{

    private Backpack backpack;
    private ArrayList<Agent> agentHolder = new ArrayList<Agent>();

    public AgentPocket(Backpack b) {
        backpack = b;
        maxSize = 7;
    }

    public void addAgent(Agent a) {
        agentHolder.add(a);
    }

    public void removeAgent(Agent a) {
        agentHolder.remove(a);
    }

    public int getCurrentSize() {
        return  agentHolder.size();
    }
}
