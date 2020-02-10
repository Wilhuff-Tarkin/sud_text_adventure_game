import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        // system objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();


        //game variables
        String [] enemies = {"orc1", "orc2", "orc3", "orc4", "orc5"};
        int maxEnemyHealth = 75;
        int maxEnemyAttachDamage = 25;

        // Player variables
        int health = 100;
        int attachDamage = 50;
        int numHealPots = 3;
        int healthPotionEffect = 30;
        int healthPotionDropChance = 50; //percentage

        boolean running = true;

        System.out.println("Welcome to the dungeon!");

        GAME:
        while (running){

            System.out.println("------------------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];

            System.out.println("\t# " + enemy + " appeared! #\n");

            while (enemyHealth > 0){
                System.out.println("\tYour hp = " + health);
                System.out.println("\tEnemy hp = " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink potion");
                System.out.println("\t3. Run");
                System.out.println("");

                String input = in.nextLine();
                if (input.equals("1")){
                    int damageDealt = rand.nextInt(attachDamage);
                    int damageTaken = rand.nextInt(maxEnemyAttachDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage" );
                    System.out.println("\t> You receive " + damageTaken + " in retaliation" );

                    if (health < 1) {

                        System.out.println("you have taken too much damage");

                    }


                } else if (input.equals("2")){

                    if (numHealPots > 0) {
                        health += healthPotionEffect;
                        numHealPots --;
                        System.out.println("\t> you drink health potion for " + healthPotionEffect + "."
                        + "\n\t>You now have " + health + " hp"
                        + "\n\t>You have " + numHealPots + " left");
                    } else {
                        System.out.println("\t>No potions left, fight enemies to find more");
                    }

                } else if (input.equals("3")){

                    System.out.println("\tYou run away from " + enemy + "!");
                    continue GAME;
                    
                }

                else {
                    System.out.println("\t>invaid command");
                }

            }

            if (health < 1) {
                System.out.println("you run from the dungeon, low on health");
                break;
            }


            System.out.println("------------------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println(" # You have " +  health + "HP left #");

            if (rand.nextInt(100) < healthPotionDropChance) {
                numHealPots++;
                System.out.println(" # The " + enemy + " dropped the health potion"
                + "\n\t>You now have " + numHealPots + " potion(s)");
           }


            System.out.println("------------------------------------------------------");
            System.out.println(" what would you like to do?");
            System.out.println("\t1. keep  fighting");
            System.out.println("\t2. exit from dungeon");

            String input = in.nextLine();

            while (!input.equals("1")&&!input.equals("2")){
                System.out.println("invalid input");
                input = in.nextLine();
            }

            if (input.equals("1")){
                System.out.println("you continue on your adventure");
            } else {

                System.out.println("you exit from dungeon as a champion and saviour of empire");
                break;
            }

        }


        System.out.println("thanks for playing!");


    }



}
