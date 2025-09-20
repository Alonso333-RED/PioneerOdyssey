package cl.alonso.pioneerodyssey.core.slots;

import cl.alonso.pioneerodyssey.core.modules.Weapon;
import cl.alonso.pioneerodyssey.utils.Category;

public class WeaponSlot {
    private Category maxCategory;
    private Weapon weapon;

    public WeaponSlot(Category maxCategory) {
        this.maxCategory = maxCategory;
        this.weapon = null;
    }

    public void printInfo() {
        if (weapon != null) {
            System.out.println("Arma equipada: " + weapon.getName() + ", Categoría: " + weapon.getCategory());
        } else {
            System.out.println("No hay arma equipada en este slot.");
        }
    }
    public Category getMaxCategory() {return maxCategory;}
    public void setMaxCategory(Category maxCategory) {this.maxCategory = maxCategory;}

    public Weapon getWeapon() {return weapon;}
    public void setWeapon(Weapon weapon) {this.weapon = weapon;}
}
