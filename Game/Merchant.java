public class Merchant extends NonPlayableCharacter {
    public Merchant(String name) {
        super(name, new Attributes(0, 0));
        health = 50;
    }

    @Override
    public void levelUp() {
    }

}