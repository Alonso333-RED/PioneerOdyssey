package cl.alonso.pioneerodyssey.core.modules;

import cl.alonso.pioneerodyssey.utils.Tier;
import cl.alonso.pioneerodyssey.utils.Category;

public class Weapon {
    private String name;
    private Tier tier;
    private Category category;
    private int maxDamage;
    private int accuracy;
    private int explosivity;
    private int explosionDamage;
    private int reloadTime;
    private int energyConsumption;
    private int currentReload = 0;

    public Weapon(
        String name, 
        Tier tier, 
        Category category, 
        int maxDamage, 
        int accuracy, 
        int explosivity, 
        int explosionDamage, 
        int reloadTime, 
        int energyConsumption) 
        {
        this.name = name;
        this.tier = tier;
        this.category = category;
        this.maxDamage = maxDamage;
        this.accuracy = accuracy;
        this.explosivity = explosivity;
        this.explosionDamage = explosionDamage;
        this.reloadTime = reloadTime;
        this.energyConsumption = energyConsumption;
    }

    public Weapon(Weapon other) {
        this.name = other.name;
        this.tier = other.tier;
        this.category = other.category;
        this.maxDamage = other.maxDamage;
        this.accuracy = other.accuracy;
        this.explosivity = other.explosivity;
        this.explosionDamage = other.explosionDamage;
        this.reloadTime = other.reloadTime;
        this.energyConsumption = other.energyConsumption;
        this.currentReload = other.currentReload;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Tier getTier() {return tier;}
    public void setTier(Tier tier) {this.tier = tier;}

    public Category getCategory() {return category;}
    public void setCategory(Category category) {this.category = category;}

    public int getMaxDamage() {return maxDamage;}
    public void setMaxDamage(int maxDamage) {this.maxDamage = maxDamage;}

    public int getAccuracy() {return accuracy;}
    public void setAccuracy(int accuracy) {this.accuracy = accuracy;}

    public int getExplosivity() {return explosivity;}
    public void setExplosivity(int explosivity) {this.explosivity = explosivity;}

    public int getExplosionDamage() {return explosionDamage;}
    public void setExplosionDamage(int explosionDamage) {this.explosionDamage = explosionDamage;}

    public int getReloadTime() {return reloadTime;}
    public void setReloadTime(int reloadTime) {this.reloadTime = reloadTime;}

    public int getEnergyConsumption() {return energyConsumption;}
    public void setEnergyConsumption(int energyConsumption) {this.energyConsumption = energyConsumption;}

    public int getCurrentReload() {return currentReload;}
    public void setCurrentReload(int currentReload) {this.currentReload = currentReload;}
}
