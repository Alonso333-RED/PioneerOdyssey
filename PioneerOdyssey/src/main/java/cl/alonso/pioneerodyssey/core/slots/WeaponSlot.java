package cl.alonso.pioneerodyssey.core.slots;

import cl.alonso.pioneerodyssey.core.modules.Weapon;
import cl.alonso.pioneerodyssey.utils.Category;
import cl.alonso.pioneerodyssey.utils.WeaponType;

public class WeaponSlot {
    private Category maxCategory;
    private final WeaponType weaponType;
    private Weapon weapon;

    public WeaponSlot(Category maxCategory, WeaponType weaponType) {
        this.maxCategory = maxCategory;
        this.weaponType = weaponType;
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

    public WeaponType getWeaponType() {return weaponType;}
    public String getWeaponTypeValue() {return weaponType.getValue();}

    public Weapon getWeapon() {return weapon;}
    public void setWeapon(Weapon weapon) {this.weapon = weapon;}
}
