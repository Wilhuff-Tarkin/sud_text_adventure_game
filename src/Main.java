import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        // system objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();


        //game variables
        EnemyModel Orc = new EnemyModel(50, 35, 20, "Tolkienish Orc", "Green");

        List <EnemyModel> enemies = new LinkedList<>();

        enemies.add(Orc);


        // Player variables
        int health = 100;
        int attackDamage = 50;
        int numHealPots = 3;
        int healthPotionEffect = 30;
        int healthPotionDropChance = 50; //percentage

        boolean running = true;

        System.out.println("Welcome to the dungeon!");

        GAME:
        while (running){

            System.out.println("------------------------------------------------------");

            EnemyModel currentEnemy = enemies.get(rand.nextInt(enemies.size()));
            int enemyHealth = rand.nextInt(currentEnemy.getMaxEnemyHealth());
            String enemyName = currentEnemy.getName();

            System.out.println("\t# " + enemyName + " appeared! #\n");

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
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(currentEnemy.getMaxEnemyAttackDamage());

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You strike the " + enemyName + " for " + damageDealt + " damage." );
                    System.out.println("\t> " + currentEnemy.getBloodColor() + " blood splashes on the floor!" );
                    System.out.println("\t> You receive " + damageTaken + " in retaliation." );

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

                    System.out.println("\tYou run away from " + enemyName + "!");
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
            System.out.println(" # " + enemyName + " was defeated! # ");
            System.out.println(" # You have " +  health + "HP left #");

            if (rand.nextInt(100) < healthPotionDropChance) {
                numHealPots++;
                System.out.println(" # The " + enemyName + " dropped the health potion"
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
