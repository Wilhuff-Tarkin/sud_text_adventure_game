public class EnemyModel {

    private int maxEnemyHealth;
    private int maxEnemyAttackDamage;
    private int maxEnemyGold;
    private String name;
    private String bloodColor;

    public EnemyModel(int maxEnemyHealth, int maxEnemyAttackDamage, int maxEnemyGold, String name, String bloodColor) {
        this.maxEnemyHealth = maxEnemyHealth;
        this.maxEnemyAttackDamage = maxEnemyAttackDamage;
        this.maxEnemyGold = maxEnemyGold;
        this.name = name;
        this.bloodColor = bloodColor;
    }

    public int getMaxEnemyHealth() {
        return maxEnemyHealth;
    }

    public int getMaxEnemyAttackDamage() {
        return maxEnemyAttackDamage;
    }

    public int getMaxEnemyGold() {
        return maxEnemyGold;
    }

    public String getName() {
        return name;
    }

    public String getBloodColor(){
        return bloodColor;
    }
}
