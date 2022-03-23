package main.com.teamalfa.blindvirologists.agents.genetic_code;
import main.com.teamalfa.blindvirologists.agents.Vaccine;
import main.com.teamalfa.blindvirologists.agents.virus.Virus;

abstract public class GeneticCode {
    abstract public Virus createVirus();
    abstract public Vaccine createVaccine();
}
