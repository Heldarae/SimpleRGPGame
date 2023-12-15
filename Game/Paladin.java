public class Paladin extends PlayableCharacter implements Combat, Caster {
    private Useable weapon, spell;

    public Paladin(String name) {
        super(name, new Attributes());
        health = 30;
    }

    public void levelUp() {
        if (level % 2 == 0) {
            attributes.increaseIntelligence(2);
            attributes.increaseStrength(1);
            level++;
        }

        else if (level % 2 != 0) {
            attributes.increaseIntelligence(1);
            attributes.increaseStrength(2);
            level++;
        }
    }

    public void attack(Damageable target) {
        if (this.weapon == null) {
            target.takeDamage(attributes.getStrength());
        } else {
            target.takeDamage(attributes.getStrength() + weapon.use());
        }

    }

    public void castSpell(Damageable target) {
        target.takeHealing(attributes.getIntelligence() + spell.use());
    }

    public void learnSpell(Spell spell) {
        this.spell = spell;
    }

    public void lootWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void takeHealing(int healing) {
        health += healing;
    }
}