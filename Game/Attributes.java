public class Attributes {
    private int strength, intelligence;

    public Attributes() {
        this.intelligence = 3;
        this.strength = 3;
    }

    public Attributes(int strength, int intelligence) {
        this.strength = strength;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void increaseStrength(int amount) {
        strength += amount;
    }

    public void increaseIntelligence(int amount) {
        intelligence += amount;
    }

    @Override
    public String toString() {
        return "Attributes [Strength= " + strength + ", intelligence= " + intelligence + "]";
    }
}