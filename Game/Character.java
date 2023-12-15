public abstract class Character implements Comparable<Character> {
    private String name;
    protected int level, health;
    protected Attributes attributes;

    public Character(String name, Attributes attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    abstract void levelUp();

    @Override
    public int compareTo(Character other) {
        if (this.level < other.level) {
            return 1;
        }
        if (this.level == other.level) {
            return 0;
        }
        return -1;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "LvL: " + level + "-" + attributes;
    }
}