public class Spell implements Useable {
    private int minHeal, maxHeal;
    private String name;

    public Spell(String name, int minHeal, int maxHeal) {
        setName(name);
        this.minHeal = minHeal;
        this.maxHeal = maxHeal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private int heal() {
        return (int) (Math.random() * (maxHeal - minHeal + 1)) + minHeal;
    }

    public int use() {
        return heal();
    }
}
