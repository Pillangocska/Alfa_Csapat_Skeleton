package main.com.teamalfa.blindvirologists;

import main.com.teamalfa.blindvirologists.agents.Agent;
import main.com.teamalfa.blindvirologists.agents.Vaccine;
import main.com.teamalfa.blindvirologists.agents.genetic_code.AmnesiaCode;
import main.com.teamalfa.blindvirologists.agents.genetic_code.GeneticCode;
import main.com.teamalfa.blindvirologists.agents.genetic_code.ParalyzeCode;
import main.com.teamalfa.blindvirologists.agents.virus.AmnesiaVirus;
import main.com.teamalfa.blindvirologists.agents.virus.DanceVirus;
import main.com.teamalfa.blindvirologists.agents.virus.ParalyzeVirus;
import main.com.teamalfa.blindvirologists.agents.virus.Virus;
import main.com.teamalfa.blindvirologists.city.fields.Field;
import main.com.teamalfa.blindvirologists.city.fields.Laboratory;
import main.com.teamalfa.blindvirologists.city.fields.SafeHouse;
import main.com.teamalfa.blindvirologists.city.fields.StoreHouse;
import main.com.teamalfa.blindvirologists.equipments.Bag;
import main.com.teamalfa.blindvirologists.equipments.Cloak;
import main.com.teamalfa.blindvirologists.equipments.active_equipments.Gloves;
import main.com.teamalfa.blindvirologists.virologist.Virologist;
import main.com.teamalfa.blindvirologists.virologist.backpack.ElementBank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AController{

    static private int callCount = 0;  // store call depth visualized with tabulators
    static private HashMap<Object, String> objectNameDict = new HashMap<>();  // store object names for printing
    static private boolean showMethods = true;

    public static void registerObject(Object parent, Object object, String name) {
        if(parent == null)
            objectNameDict.put(object, name);
        else
            objectNameDict.put(object, objectNameDict.get(parent)+"."+name);
    }

    public static int getCallCount() {
        return callCount;
    }

    /**
     * This method prints the return object to the console.
     * You must call this method at the end of every method.
     * @param object
     * @return Object
     * */
    public static Object printReturn(Object object) {
        // Decrease callCount to reset depth.
        callCount--;

        // Void methods pass a null as parameter.
        if(object != null && showMethods) {
            String msg = "";
            for(int i = 0; i < callCount; i++) msg += "\t";
            msg += "└→return ";
            if(object instanceof Boolean) msg += (Boolean) object;
            else if(object instanceof String) msg += (String) object;
            else msg += objectNameDict.get(object);
            System.out.println(msg);
        }

        // Returning the object, so it can be wrapped in the return line but a cast is needed.
        // Example usage: return (Field) AController.printReturn(field)
        return object;
    }

    /**
     * This method prints the object and the called method to the console.
     * You must call this method and the beginning of every method.
     * @param object
     * @param method
     * @param parameters
     * */
    public static void printCall(Object object, String method, Object[] parameters) {
        if(showMethods) {
            String msg = "";
            // add tabulators for depth
            for(int i = 0; i < callCount; i++) msg += '\t';

            // print object name and method name and open a bracket
            msg += objectNameDict.get(object) + "."  + method + "(";

            // print method parameters
            if(parameters != null) {
                for(int i = 0; i < parameters.length; i++) {
                    msg += objectNameDict.get(parameters[i]);
                    // if not last parameter use comma for separation
                    if(i != parameters.length - 1) msg += ", ";
                }
            }

            // close method with bracket
            msg += ")";

            // increase callCount
            System.out.println(msg);
        }
        callCount++;
    }

    public void runTests() {
        while(true) {
            System.out.println("\nEnter a number between 1 and 21...");
            System.out.println(
                    "1: Virologist searches in a laboratory that contains genetic code\n" +
                            "2: Virologist searches in a storehouse and collects elements\n" +
                            "3: Virologist searches a safehouse that contains equipment and picks it up\n" +
                            "4: Virologist moves while affected by DanceVirus\n" +
                            "5: Virologist moves while affected by ParalyzeVirus\n" +
                            "6: Virologist moves while affected by AmnesiaVirus\n" +
                            "7: Virologist uses ParalyzeVirus on another Virologist, who’s vaccinated without equipment\n" +
                            "8: Virologist uses AmnesiaVirus on another Virologist who’s not vaccinated but wears cape\n" +
                            "9: Virologist uses DanceVirus on another Virologist who’s not vaccinated but wears Gloves\n" +
                            "10: Virologist wants to create a ParalyzeVirus, but doesn't have enough elements\n" +
                            "11: Virologist creates an AmnesiaVaccine and uses it on itself\n" +
                            "12: Virologist starts to wear a bag, and then takes it off\n" +
                            "13: Virologist starts to wear a cloak and then takes it off\n" +
                            "14: Virologist starts to wear gloves and then takes it off\n" +
                            "15: Virologist wants to toggle bag, but the Virologist isn't  in a Safehouse\n" +
                            "16: Virologist tosses a cloak from the backpack to a Safehouse\n" +
                            "17: Virologist tosses a cloak from the backpack to a Field\n" +
                            "18: Virologist applies ParalyzeVirus with gloves on another Virologist who has no equipment or vaccination\n" +
                            "19: Virologist robs another Virologist\n" +
                            "20: Virologist can’t rob  enemy because not paralyzed\n" +
                            "21: VirologistA tries to use DanceVirus on VirologistB but VirologistB is under the effect of Paralyze Virus\n");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    //Virologist searches in a laboratory that contains genetic code
                    Test1();
                    break;
                case 2:
                    //Virologist searches in a storehouse and collects elements
                    Test2();
                    break;
                case 3:
                    //Virologist searches a safehouse that contains equipment and picks it up
                    Test3();
                    break;
                case 4:
                    //Virologist moves while affected by DanceVirus
                    Test4();
                    break;
                case 5:
                    //Virologist moves while affected by ParalyzeVirus
                    Test5();
                    break;
                case 6:
                    //Virologist moves while affected by AmnesiaVirus
                    Test6();
                    break;
                case 7:
                    //Virologist uses ParalyzeVirus on another Virologist, who’s vaccinated without equipment
                    Test7();
                    break;
                case 8:
                    //Virologist uses AmnesiaVirus on another Virologist who’s not vaccinated but wears cape
                    Test8();
                    break;
                case 9:
                    //Virologist uses DanceVirus on another Virologist who’s not vaccinated but wears Gloves
                    Test9();
                    break;
                case 10:
                    //Virologist wants to create a ParalyzeVirus, but doesn't have enough elements
                    Test10();
                    break;
                case 11:
                    //Virologist creates an AmnesiaVaccine and uses it on itself
                    Test11();
                    break;
                case 12:
                    //Virologist starts to wear a bag, and then takes it off
                    Test12();
                    break;
                case 13:
                    //Virologist starts to wear a cloak and then takes it off
                    Test13();
                    break;
                case 14:
                    //Virologist starts to wear gloves and then takes it off
                    Test14();
                    break;
                case 15:
                    //Virologist wants to toggle bag, but the Virologist isn't  in a Safehouse
                    Test15();
                    break;
                case 16:
                    //Virologist tosses a cloak from the backpack to a Safehouse
                    Test16();
                    break;
                case 17:
                    //Virologist tosses a cloak from the backpack to a Field
                    Test17();
                    break;
                case 18:
                    //Virologist applies ParalyzeVirus with gloves on another Virologist who has no equipment or vaccination
                    Test18();
                    break;
                case 19:
                    //Virologist robs another Virologist
                    Test19();
                    break;
                case 20:
                    //Virologist can’t rob  enemy because not paralyzed
                    Test20();
                    break;
                case 21:
                    //VirologistA tries to use DanceVirus on VirologistB but VirologistB is under the effect of Paralyze Virus
                    Test21();
                    break;
                default:
                    System.exit(0);
                    break;
            }
            backToMenuAndReset();
        }
    }

    public void Test1(){
        Virologist v1 = new Virologist(); objectNameDict.put(v1, "virologist"); v1.registerObjects();
        Laboratory l1 = new Laboratory(); objectNameDict.put(l1, "laboratory");
        AmnesiaCode ac = new AmnesiaCode(); objectNameDict.put(ac, "amnesiaCode");
        l1.setGeneticCode(ac);
        v1.setField(l1);
        v1.search();
    }

    public void Test2(){
        Virologist v1 = new Virologist(); objectNameDict.put(v1, "virologist"); v1.registerObjects();
        StoreHouse s1 = new StoreHouse(); objectNameDict.put(s1, "storeHouse");
        ElementBank elements = new ElementBank(
                askNumberInput("How many amino acids are on the field?"),
                askNumberInput("How many nucleotides are on the field?")
        );
        objectNameDict.put(elements, "elements"+elements.getAminoAcid()+"_"+elements.getNucleotide());
        s1.setElements(elements);
        v1.setField(s1);
        v1.search();
    }

    public void Test3(){
        Virologist v1 = new Virologist(); objectNameDict.put(v1, "virologist"); v1.registerObjects();
        SafeHouse sh1 = new SafeHouse(); objectNameDict.put(sh1, "safeHouse");
        Cloak cloak = new Cloak(); objectNameDict.put(cloak, "cloak");
        sh1.add(cloak);
        Field current = new Field(); objectNameDict.put(current, "current");
        current.setNeighbour(sh1);
        v1.setField(current);
        v1.move(sh1);
        v1.search();
    }

    public void Test4(){
        // create Virologist and DanceVirus and add them to hashmap
        Virologist v1 = new Virologist(); objectNameDict.put(v1, "v1");
        DanceVirus dv = new DanceVirus(); objectNameDict.put(dv, "danceVirus");
        v1.addVirus(dv);

        // create fields and add them to hashmap
        Field current = new Field(); objectNameDict.put(current, "current");
        Field destination = new Field(); objectNameDict.put(destination, "destination");

        // create neighbours for current field and add them to hashmap
        ArrayList<Field> neighbours = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            Field field = new Field(); objectNameDict.put(field, "alteredDestination"+i);
            neighbours.add(field);
        }
        neighbours.add(destination);
        current.setNeighbours(neighbours); objectNameDict.put(neighbours, "neighbours");
        v1.setField(current);

        // start move test
        v1.move(destination);
    }

    public void Test5(){
        Virologist v1 = new Virologist(); objectNameDict.put(v1, "virologist");
        ParalyzeVirus pv = new ParalyzeVirus(); objectNameDict.put(pv, "paralyzeVirus");
        v1.addVirus(pv);

        Field current = new Field(); objectNameDict.put(current, "current");
        Field destination = new Field(); objectNameDict.put(destination, "destination");
        current.setNeighbour(destination);
        v1.setField(current);

        v1.move(destination);
    }

    public void Test6(){
        Virologist v1 = new Virologist(); objectNameDict.put(v1, "virologist");
        AmnesiaVirus av = new AmnesiaVirus(); objectNameDict.put(av, "amnesiaVirus");
        v1.addVirus(av);

        Field current = new Field(); objectNameDict.put(current, "current");
        Field destination = new Field(); objectNameDict.put(destination, "destination");
        current.setNeighbour(destination);
        v1.setField(current);

        v1.move(destination);
    }

    public void Test7(){
        // set up virologist and create virus
        Virologist virologist = new Virologist(); objectNameDict.put(virologist, "virologist"); virologist.registerObjects();
        ParalyzeCode pc = new ParalyzeCode(); objectNameDict.put(pc, "paralyzeCode");
        virologist.getBackpack().createVirus(pc);


        // set up enemy and inject vaccine
        showMethods = false;
        Virologist enemy = new Virologist(); objectNameDict.put(enemy, "enemy"); enemy.registerObjects();
        Vaccine parVaccine = new Vaccine(pc); objectNameDict.put(parVaccine, "paralyzeVaccine");
        enemy.protectedBy(parVaccine);

        // apply virus
        Agent toUse = (Agent) askMultiChoice("agent to use",virologist.getBackpack().getAgents());
        showMethods = true;
        virologist.use(toUse, enemy);

        showMethods = true;


    }
    //todo
    public void Test8(){
    }
    //todo
    public void Test9(){
    }

    public void Test10(){
        Virologist v1 = new Virologist();
        ParalyzeCode paralyzeCode = new ParalyzeCode();
        v1.getBackpack().createVirus(paralyzeCode);
    }

    public void Test11(){
        Virologist v1 = new Virologist(); objectNameDict.put(v1, "virologist"); v1.registerObjects();
        AmnesiaCode amnesiaCode = new AmnesiaCode(); objectNameDict.put(amnesiaCode, "amnesiaCode");
        v1.getBackpack().createVaccine(amnesiaCode);
        Agent toUse = (Agent) askMultiChoice("vaccine to use",v1.getBackpack().getAgents());
        v1.use(toUse, v1);
    }

    public void Test12(){
        Virologist v1 = new Virologist(); objectNameDict.put(v1, "virologist");
        SafeHouse sh1 = new SafeHouse(); objectNameDict.put(sh1, "safeHouse");
        v1.setField(sh1);
        v1.registerObjects();
        Bag bag = new Bag(2000); objectNameDict.put(bag, "bag");
        bag.setVirologist(v1);

        v1.getBackpack().getEquipmentPocket().toggle(bag);
    }

    public void Test13(){
        Virologist v1 = new Virologist(); objectNameDict.put(v1, "virologist");
        SafeHouse sh1 = new SafeHouse(); objectNameDict.put(sh1, "safeHouse");
        v1.setField(sh1);
        v1.registerObjects();
        Cloak cloak = new Cloak();
        cloak.setVirologist(v1);

        v1.getBackpack().getEquipmentPocket().toggle(cloak);
    }

    public void Test14(){
        Virologist v1 = new Virologist();
        SafeHouse sh1 = new SafeHouse();
        v1.setField(sh1);
        Gloves glove = new Gloves();
        v1.getBackpack().getEquipmentPocket().toggle(glove);
    }

    public void Test15(){
        Virologist v1 = new Virologist();
        Field field = new Field();
        v1.setField(field);
        Bag bag = new Bag(2000);
        v1.getBackpack().getEquipmentPocket().toggle(bag);
    }

    public void Test16(){
        Virologist v1 = new Virologist();
        SafeHouse sh1 = new SafeHouse();
        v1.setField(sh1);
        Cloak cloak = new Cloak();
        v1.getBackpack().getEquipmentPocket().toss(cloak);
    }

    public void Test17(){
        Virologist v1 = new Virologist();
        Field field = new Field();
        v1.setField(field);
        Cloak cloak = new Cloak();
        v1.getBackpack().getEquipmentPocket().toss(cloak);
    }
    //Virologist applies ParalyzeVirus with gloves on another Virologist who has no equipment or vaccination
    public void Test18(){
        //set up virologists and create virus
        Virologist v1 = new Virologist(); objectNameDict.put(v1, "virologist1"); v1.registerObjects();
        Virologist v2 = new Virologist(); objectNameDict.put(v2, "virologist2"); v1.registerObjects();
        Field current = new Field(); objectNameDict.put(current, "current");
        ParalyzeCode pc = new ParalyzeCode(); objectNameDict.put(pc, "paralyzeCode");
        v1.getBackpack().createVirus(pc);
        v1.setField(current);
        v2.setField(current);
        Agent toUse = (Agent) askMultiChoice("agent to use",v1.getBackpack().getAgents());
        v1.use(toUse, v2);
    }

    public void Test19(){
        Virologist v1 = new Virologist(); objectNameDict.put(v1, "virologist1"); v1.registerObjects();
        Virologist v2 = new Virologist(); objectNameDict.put(v2, "virologist2"); v2.registerObjects();
        Field current = new Field();
        v1.setField(current);
        v2.setField(current);
        v2.addVirus(new ParalyzeVirus());
        v1.rob(v2);
    }

    public void Test20(){
        Virologist v1 = new Virologist(); objectNameDict.put(v1, "virologist_1"); v1.registerObjects();
        Virologist v2 = new Virologist(); objectNameDict.put(v2, "virologist_2"); v2.registerObjects();
        Field field = new Field();
        v1.setField(field);
        v2.setField(field);
        v1.rob(v2);
    }

    public void Test21(){
        Virologist v1 = new Virologist(); objectNameDict.put(v1, "virologist_1"); v1.registerObjects();
        Virologist v2 = new Virologist(); objectNameDict.put(v2, "virologist_2"); v2.registerObjects();
        Field field = new Field(); objectNameDict.put(field, "field");
        v1.setField(field);
        v2.setField(field);
        v1.addVirus(new ParalyzeVirus());
        v1.use(new DanceVirus(), v2);
    }

    public static String readInput(String msg) {
        System.out.print(msg);
        return new Scanner(System.in).nextLine();
    }

    public static boolean askYesOrNo(String msg) {
        // Returns true if user answered yes.
        String question = "\n" +  msg + " (y/n): ";
        while(true) {
            switch(readInput(question)) {
                case "y": return true;
                case "n": return false;
            }
        }
    }

    /**
     * This method is used when one of the testcases stop
     * so the user can decide which branch of the test should be run.
     * @param optionType The name of the choice that have to be made.
     * @param choices The options the user can choose from.
     * @return The chose option.
     */
    public static Object askMultiChoice(String optionType, ArrayList<Object> choices) {
        if(choices.isEmpty()) {
            System.out.println("There are no choices in "+ objectNameDict.get(choices));
            return null;
        }

        String question = "\nThe possible choices for " + optionType + " in " + objectNameDict.get(choices)+ " are:\n";
        for(int i = 0; i < choices.size(); i++) {
            question += "\t"+ i + ". " + objectNameDict.get(choices.get(i))+ "\n";
        }
        question += "answer (number): ";
        while(true) {
            Integer answer;
            try {
                answer = Integer.parseInt(readInput(question));
            }catch (NumberFormatException ex) {
                continue;
            }
            if(answer >=0 && answer < choices.size()) {
                return choices.get(answer);
            }
        }
    }

    public static Integer askNumberInput(String question) {
        question += "\n answer (number): ";
        while(true) {
            Integer answer;
            try {
                answer = Integer.parseInt(readInput(question));
            } catch (NumberFormatException ex) {
                continue;
            }
            if(answer >= 0) return answer;
        }
    }

    /**
     * This method is called when one of the testcases has finished running.
     * By pressing any key the user will be escorted back into the main menu.
     */
    private void backToMenuAndReset() {
        callCount = 0;
        objectNameDict.clear();
        readInput("\n Press enter to get back to menu . . . ");
    }
}
