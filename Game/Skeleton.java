public class Skeleton extends NonPlayableCharacter implements Combat {

    public Skeleton(String name) {
        super(name, new Attributes(3, 1));
        health = 20;
    }

    public void lootWeapon(Weapon weapon) {
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
    }

    @Override
    public boolean isAlive() {
        if (health > 0) {
            return true;
        } else
            return false;
    }

    @Override
    public void levelUp() {
        level += 1;
        attributes.increaseIntelligence(1);
        attributes.increaseStrength(1);
    }

    @Override
    public void takeHealing(int healing) {
        health -= healing;
    }

    @Override
    public void attack(Damageable target) {
        target.takeDamage(attributes.getIntelligence() + attributes.getStrength());
    }
}