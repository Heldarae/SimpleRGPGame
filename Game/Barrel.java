public class Barrel implements Damageable {
    private int health = 30, capacity = 10;

    public void explode() {
        System.out.println("Explodes");
    }

    public void repair() {
        System.out.println("Repairing");
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            explode();
        }
    }

    public void takeHealing(int healing) {
        health += healing;
        repair();
    }

    public boolean isAlive() {
        if (health > 0) {
            return true;
        } else
            return false;
    }
}
