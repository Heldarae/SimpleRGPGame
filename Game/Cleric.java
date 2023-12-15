public class Cleric extends PlayableCharacter implements Caster {
    private Useable spell;

    public Cleric(String name) {
        super(name, new Attributes(2, 4));
        health = 25;
    }

    public void levelUp() {
        attributes.increaseIntelligence(2);
        attributes.increaseStrength(1);
        level++;
    }

    public void castSpell(Damageable target) {
        target.takeHealing(attributes.getIntelligence() + spell.use());
    }

    public void learnSpell(Spell spell) {
        this.spell = spell;
    }

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