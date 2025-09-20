package cl.alonso.pioneerodyssey.core;

import java.util.List;
import java.util.ArrayList;

import cl.alonso.pioneerodyssey.core.slots.WeaponSlot;
import cl.alonso.pioneerodyssey.utils.Tier;
import cl.alonso.pioneerodyssey.utils.Category;
import cl.alonso.pioneerodyssey.utils.Triple;

public class SpaceShip {
    private String name;
    private Tier tier;
    private Category category;
    private int maxHealth;
    private int currentHealth;
    private int armor;
    private int blastResistance;
    private int agility;
    private final List<Object> slots = new ArrayList<>();

    @SafeVarargs
    public SpaceShip(
        String name, 
        Tier tier, 
        Category category, 
        int maxHealth, 
        int armor, 
        int blastResistance, 
        int agility,
        //TypeofSlot, MaxCategory, Quantity
        Triple<Class<?>, Category, Integer>... slotsToAdd
        )
        {
        this.name = name;
        this.tier = tier;
        this.category = category;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.armor = armor;
        this.blastResistance = blastResistance;
        this.agility = agility;
        for (Triple<Class<?>, Category, Integer> slotInfo : slotsToAdd) {
            Class<?> slotType = slotInfo.getFirst();
            Category maxCategory = slotInfo.getSecond();
            int quantity = slotInfo.getThird();

            for (int i = 0; i < quantity; i++) {
                try {
                    if (slotType == WeaponSlot.class) {
                        slots.add(new WeaponSlot(maxCategory));
                    } 
                    // Future slot types will be added here
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Tier getTier() {return tier;}
    public void setTier(Tier tier) {this.tier = tier;}

    public Category getCategory() {return category;}
    public void setCategory(Category category) {this.category = category;}

    public int getMaxHealth() {return maxHealth;}
    public void setMaxHealth(int maxHealth) {this.maxHealth = maxHealth;}

    public int getCurrentHealth() {return currentHealth;}
    public void setCurrentHealth(int currentHealth) {this.currentHealth = currentHealth;}

    public int getArmor() {return armor;}
    public void setArmor(int armor) {this.armor = armor;}

    public int getBlastResistance() {return blastResistance;}
    public void setBlastResistance(int blastResistance) {this.blastResistance = blastResistance;}

    public int getAgility() {return agility;}
    public void setAgility(int agility) {this.agility = agility;}

    public List<Object> getSlots() {return slots;}

    public String getInfo() {
    StringBuilder info = new StringBuilder();
    info.append("Nombre: ").append(name).append("\n");
    info.append("Tier: ").append(tier).append("\n");
    info.append("Categoría: ").append(category).append("\n");
    info.append("Integridad: ").append(currentHealth).append("/").append(maxHealth).append("\n");
    info.append("Blindaje: ").append(armor).append("\n");
    info.append("Resistencia a Explosiones: ").append(blastResistance).append("\n");
    info.append("Agilidad: ").append(agility).append("\n");
    info.append("Slots:\n");

    for (int i = 0; i < slots.size(); i++) {
        Object slot = slots.get(i);

        if (slot instanceof WeaponSlot) {
            WeaponSlot weaponSlot = (WeaponSlot) slot;
            String weaponName = (weaponSlot.getWeapon() != null) ? weaponSlot.getWeapon().getName() : "Vacío";
            String weaponCat = (weaponSlot.getWeapon() != null) ? weaponSlot.getWeapon().getCategory().toString() : "-";
            String maxCat = weaponSlot.getMaxCategory().toString();

            info.append("  - ").append(i)
                .append(" Arma: ").append(weaponName)
                .append(" (").append(weaponCat).append("/").append(maxCat).append(")\n");
        }

        // Future slot types can be added here
    }

    return info.toString();
}


}
