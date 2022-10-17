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

    public void startEvent() throws InterruptedException {
        System.out.println("=======================");
        System.out.println("Something Important Happened!: "+prompt);
        int startHealth = phealth;
        for(int i=0; i<enemyAmount; i++){
            String ename = enemyNames[random.nextInt(enemyNames.length)];
            int ehealth = random.nextInt(10)+1;
            phealth = startHealth;
            System.out.println("You are facing "+ ename+"...He has "+ehealth+" health, you have "+phealth+" health.");
            Thread.sleep(100);
            while(ehealth>0){
                Scanner input = new Scanner(System.in);
                System.out.println("Do you want to fight(1) or heal(2) or run(3) or do nothing(4)?: ");
                Thread.sleep(100);
                try{
                    if (phealth ==0){
                        System.out.println("You ran out of health you noob, lets try again with another dude... \n\n");
                        Thread.sleep(100);
                        ehealth=0;
                        break;
                    }
                    switch(input.nextInt()){
                        case 1:
                            System.out.println("You were attacked you lost 1 health, your enemy is at "+ehealth+" health!");
                            Thread.sleep(100);
                            phealth -=1;
                            System.out.println("You attacked with your sharpened pinky! You deal 2 damage!");
                            Thread.sleep(100);
                            ehealth -=2;
                            System.out.println("Enemy is now at "+ ehealth+" health!");
                            Thread.sleep(100);
                            break;
                        case 2:
                            System.out.println("You were attacked you lost 1 health, your enemy is at "+ehealth+" health!");
                            Thread.sleep(100);
                            phealth -=1;
                            System.out.println("You wrapped gauze on your forearms, I don't see how that helps. You heal 3 health pts! You're at "+phealth+" health!");
                            Thread.sleep(100);
                            break;
                        case 3:
                            if (ehealth<5){
                                System.out.println("He was too injured to notice you dive into the bush and hide, he walks away after a couple of minutes off into the sunset!");
                                Thread.sleep(100);
                                ehealth = 0;
                            }else{
                                System.out.println("You dive into a bush but he can still you, he kicks the bush and you take 1 damage!");
                                Thread.sleep(100);
                                phealth -=1;
                            }
                        case 4:
                            System.out.println("You kinda just stand there?");
                            Thread.sleep(100);
                            System.out.println("You were attacked you lost 1 health, your enemy is at "+ehealth+" health!");
                            Thread.sleep(100);
                            phealth -=1;
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + input.nextInt());
                    }
                }catch(InputMismatchException | InterruptedException errorOut){
                    System.out.println("You got this wacky error (hint: you didn't give me a number in the parentheses please get better at this!): ");
                }
            }

        }
        System.out.println("Congrats you defeated all of the entities!");
    }
}
