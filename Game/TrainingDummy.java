public class TrainingDummy implements Damageable {
    private int health = 25;

    public boolean isAlive() {
        if (health > 0) {
            return true;
        } else
            return false;
    }

    public void takeHealing(int healing) {
        health += healing;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }
}