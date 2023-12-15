public class Warrior extends PlayableCharacter implements Combat {
    private Useable weapon;

    public Warrior(String name) {
        super(name, new Attributes(4, 2));
        health = 35;
    }

    @Override
    public void levelUp() {
        attributes.increaseIntelligence(1);
        attributes.increaseStrength(2);
        level++;
    }

    @Override
    public void attack(Damageable target) {
        if (this.weapon == null) {
            target.takeDamage(attributes.getStrength());
        } else {
            target.takeDamage(attributes.getStrength() + weapon.use());
        }
    }

    @Override
    public void lootWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void takeHealing(int healing) {
        health += healing;
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

    public Useable getWeapon() {
        return weapon;
    }
}