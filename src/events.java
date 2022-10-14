import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class events {
    int levelNum, enemyAmount, phealth;
    String prompt;
    String[] enemyNames = {"“Pimple”", "Dimple", "Domple", "Doople", "Boople"};
    Random random = new Random();

    public events(int glevelNum, int genemyAmount, int gphealth,String gprompt){
        levelNum = glevelNum;
        enemyAmount = genemyAmount;
        prompt = gprompt;
        phealth = gphealth;
    }

    public void startEvent(){
        System.out.println("=======================");
        System.out.println("Something Important Happened!: "+prompt);
        for(int i=0; i<enemyAmount; i++){
            String ename = enemyNames[random.nextInt(5)];
            int ehealth = random.nextInt(10);

            System.out.println("You are facing "+ ename+"...He has "+ehealth+" health.");

            while(ehealth>0){
                Scanner input = new Scanner(System.in);
                System.out.println("Do you want to fight(1) or heal(2)?: ");
                try{
                    switch(input.nextInt()){
                        case 1:
                            System.out.println("You were attacked you lost 1 health, your enemy is at "+ehealth+"health!");
                            phealth -=1;
                            System.out.println("You attacked with your sharpened pinky! You deal 2 damage!");
                            ehealth -=2;
                            System.out.println("Enemy is now at "+ ehealth+" health!");
                            break;
                        case 2:
                            System.out.println("You were attacked you lost 1 health, your enemy is at "+ehealth+"health!");
                            phealth -=1;
                            System.out.println("You wrapped gauze on your forearms, I don't see how that helps. You heal 3 health pts!");

                    }
                }catch(InputMismatchException errorOut){
                    System.out.println("You got this wacky error (hint: you didn't give me a number in the parentheses please get better at this!): ");
                }
            }

        }
        System.out.println("Congrats you defeated all of the entities!");
    }
}
