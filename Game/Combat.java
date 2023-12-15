public interface Combat extends Damageable {
    public void attack(Damageable target);

    public void lootWeapon(Weapon weapon);
}