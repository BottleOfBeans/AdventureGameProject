import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class playerCharacter {
    public String name;
    public int level;
    public int health;

    public events event1 = new events(1,3,10,"You're car is broken down on the side of the road, three creatures appear from the dark!");
    public events event2 = new events(2,1,3,"Another creature blocks your way back to the car!");

    public playerCharacter(String gname, int glevel){
        name = gname;
        level = glevel;
    }
    public playerCharacter(){
        name = "Bozo who didn't enter a name";
        level = 0;
    }

    public void levelup(){
        System.out.println("You leveled up from "+level+" to "+(level+1));
        level +=1;
    }

    public void eventsPlay(){
        System.out.println("==============");
        System.out.println("You've got to go down this road buddy....the journey begins!");
        event1.startEvent();
        event2.startEvent();
    }


    public void startingScreen() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 1 to play and 0 to exit, anything else and you're bad at this!");
            try {
                switch (input.nextInt()) {
                    case 1:
                        System.out.println("We're good to go");
                        eventsPlay();
                        break;
                    case 0:
                        System.out.println("Its been good knowing you but I'm very sad about this choice!");
                        System.exit(1);
                    default:
                        System.out.println("Honestly just do better really man.....");
                }
            } catch (InputMismatchException errorOut) {
                System.out.println("You got this wacky error (hint: you didn't give me a number): " + errorOut);
            }
        }
    }
}
