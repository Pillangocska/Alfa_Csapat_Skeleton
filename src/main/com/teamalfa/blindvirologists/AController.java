package main.com.teamalfa.blindvirologists;

import main.com.teamalfa.blindvirologists.agents.genetic_code.AmnesiaCode;
import main.com.teamalfa.blindvirologists.agents.genetic_code.ParalyzeCode;
import main.com.teamalfa.blindvirologists.agents.virus.AmnesiaVirus;
import main.com.teamalfa.blindvirologists.agents.virus.DanceVirus;
import main.com.teamalfa.blindvirologists.agents.virus.ParalyzeVirus;
import main.com.teamalfa.blindvirologists.city.fields.Field;
import main.com.teamalfa.blindvirologists.city.fields.Laboratory;
import main.com.teamalfa.blindvirologists.city.fields.SafeHouse;
import main.com.teamalfa.blindvirologists.city.fields.StoreHouse;
import main.com.teamalfa.blindvirologists.equipments.Bag;
import main.com.teamalfa.blindvirologists.equipments.Cloak;
import main.com.teamalfa.blindvirologists.equipments.active_equipments.Gloves;
import main.com.teamalfa.blindvirologists.virologist.Virologist;

import java.util.ArrayList;
import java.util.Scanner;

public class AController{

    public void runTests() {
        while(true) {
        System.out.println("\nEnter a number between 1 and 21...");
        System.out.println("1: Virologist searches in a laboratory that contains genetic code\n" +
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
        }
    }

    public void Test1(){
        Virologist v1 = new Virologist();
        Laboratory l1 = new Laboratory();
        v1.setField(l1);
        v1.search();
    }

    public void Test2(){
        Virologist v1 = new Virologist();
        StoreHouse s1 = new StoreHouse(20,30);
        v1.setField(s1);
        v1.search();
    }

    public void Test3(){
        Virologist v1 = new Virologist();
        SafeHouse sh1 = new SafeHouse();
        Field f1 = new Field();
        f1.setNeighbour(sh1);
        v1.setField(f1);
        v1.move(sh1);
        v1.search();
    }

    public void Test4(){
        Virologist v1 = new Virologist();
        DanceVirus dv = new DanceVirus();
        v1.infectedBy(dv);
        ArrayList<Field> fields = v1.getField().getNeighbours();
        v1.move(fields.get(0));
    }

    public void Test5(){
        Virologist v1 = new Virologist();
        ParalyzeVirus pv = new ParalyzeVirus();
        v1.infectedBy(pv);
        ArrayList<Field> fields = v1.getField().getNeighbours();
        v1.move(fields.get(0));
    }

    public void Test6(){
        Virologist v1 = new Virologist();
        AmnesiaVirus av = new AmnesiaVirus();
        v1.infectedBy(av);
        ArrayList<Field> fields = v1.getField().getNeighbours();
        v1.move(fields.get(0));
    }
    //todo
    public void Test7(){
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
        Virologist v1 = new Virologist();
        AmnesiaCode amnesiaCode = new AmnesiaCode();
        v1.getBackpack().createVaccine(amnesiaCode);
        //todo itt vhogy vissza kellene kapni a vakcinat
        //v1.use(,v1);
    }

    public void Test12(){
        Virologist v1 = new Virologist();
        SafeHouse sh1 = new SafeHouse();
        v1.setField(sh1);
        Bag bag = new Bag(2000);
        v1.getBackpack().getEquipmentPocket().toggle(bag);
    }

    public void Test13(){
        Virologist v1 = new Virologist();
        SafeHouse sh1 = new SafeHouse();
        v1.setField(sh1);
        Cloak cloak = new Cloak();
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

    public void Test18(){
        Virologist v1 = new Virologist();
        Virologist v2 = new Virologist();
        Field field = new Field();
        v1.setField(field);
        v2.setField(field);
        //todo itt baj van a szekvenciaval
    }

    public void Test19(){
        Virologist v1 = new Virologist();
        Virologist v2 = new Virologist();
        Field field = new Field();
        v1.setField(field);
        v2.setField(field);
        v2.infectedBy(new ParalyzeVirus());
        v1.rob(v2);
    }

    public void Test20(){
        Virologist v1 = new Virologist();
        Virologist v2 = new Virologist();
        Field field = new Field();
        v1.setField(field);
        v2.setField(field);
        v1.rob(v2);
    }

    public void Test21(){
        Virologist v1 = new Virologist();
        Virologist v2 = new Virologist();
        Field field = new Field();
        v1.setField(field);
        v2.setField(field);
        v2.infectedBy(new ParalyzeVirus());
        v1.use(new DanceVirus(), v2);
    }
}
