package cl.alonso.pioneerodyssey;

import java.util.concurrent.ThreadLocalRandom;

import cl.alonso.pioneerodyssey.core.Sector;
import cl.alonso.pioneerodyssey.core.SpaceShip;
import cl.alonso.pioneerodyssey.core.modules.Weapon;
import cl.alonso.pioneerodyssey.core.slots.WeaponSlot;

import cl.alonso.pioneerodyssey.utils.worldUtils;
import cl.alonso.pioneerodyssey.utils.equipUtils;
import cl.alonso.pioneerodyssey.utils.Tier;
import cl.alonso.pioneerodyssey.utils.Category;
import cl.alonso.pioneerodyssey.utils.Triple;

public class PioneerOdyssey {
    public static void main(String[] args) {
        // The proyect is under early development. this is pure testing ground.
        int xSize = ThreadLocalRandom.current().nextInt(1, 10+1);
        int ySize = ThreadLocalRandom.current().nextInt(1, 10+1);

        //xSize = 10;
        //ySize = 10;

        Sector[][] world = new Sector[xSize][ySize];
        worldUtils.setupWorld(world);

        System.out.println("Tamaño del mundo: "+xSize+","+ySize);

        int inRow = ThreadLocalRandom.current().nextInt(0, world.length);
        int inColumn = ThreadLocalRandom.current().nextInt(0, world[0].length);

        //inRow = 0;
        //inColumn = 0;

        System.out.println("Mapa del Mundo");
        System.out.println();

        Sector mySector = world[inRow][inColumn];

        for (Sector[] world1 : world) {
            for (Sector currentSector : world1) {
                if (currentSector == mySector) {
                    System.out.print("X" + "  |");
                } else if (currentSector == mySector.getNorth()) {
                    System.out.print("^" + "  |");
                } else if (currentSector == mySector.getEast()) {
                    System.out.print(">" + "  |");
                } else if (currentSector == mySector.getWest()) {
                    System.out.print("<" + "  |");
                } else if (currentSector == mySector.getSouth()) {
                    System.out.print("v" + "  |");
                } else {
                    System.out.print(currentSector.getID() + "|");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Ubicación actual: " + mySector.getName() + " (" + mySector.getXLocation()+","+mySector.getYLocation()+")");
        System.out.println("Norte: " + mySector.getNorth().getName()+" ("+mySector.getNorth().getID()+")");
        System.out.println("Sur: " + mySector.getSouth().getName()+" ("+mySector.getSouth().getID()+")");
        System.out.println("Este: " + mySector.getEast().getName()+" ("+mySector.getEast().getID()+")");
        System.out.println("Oeste: " + mySector.getWest().getName()+" ("+mySector.getWest().getID()+")");
        System.out.println();

        SpaceShip myShip = new SpaceShip(
            "SS-Enterprise",
            Tier.Tier5,
            Category.Category3,
            100,
            50,
            30,
            20,
            new Triple<>(WeaponSlot.class, Category.Category1, 3),
            new Triple<>(WeaponSlot.class, Category.Category2, 2),
            new Triple<>(WeaponSlot.class, Category.Category3, 1)
        );

        System.out.println(myShip.getInfo());

        Weapon supportLaser = new Weapon(
            "Support Laser",
            Tier.Tier2,
            Category.Category1,
            50,
            40,
            20,
            10,
            1,
            5
        );

        Weapon lightArtillery = new Weapon(
            "Light Artillery",
            Tier.Tier3,
            Category.Category2,
            80,
            70,
            40,
            30,
            2,
            10
        );

        Weapon heavyCannon = new Weapon(
            "Heavy Cannon",
            Tier.Tier5,
            Category.Category3,
            120,
            90,
            60,
            50,
            4,
            20
        );

        equipUtils.equipWeapon(myShip, supportLaser, 4);
        equipUtils.equipWeapon(myShip, lightArtillery, 3);
        equipUtils.equipWeapon(myShip, lightArtillery, 0);
        equipUtils.equipWeapon(myShip, heavyCannon, 5);
        System.out.println(myShip.getInfo());
        System.out.println(heavyCannon);
        System.out.println(((WeaponSlot) myShip.getSlots().get(5)).getWeapon());
    }
}
