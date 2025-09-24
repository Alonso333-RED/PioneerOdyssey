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
        int zSize = ThreadLocalRandom.current().nextInt(1, 10+1);

        xSize = 10;
        ySize = 10;
        zSize = 10;

        Sector[][][] world = new Sector[xSize][ySize][zSize];
        worldUtils.setupWorld(world);

        System.out.println("Tamaño del mundo: "+xSize+","+ySize+","+zSize);

        int inX = ThreadLocalRandom.current().nextInt(0, world.length);
        int inY = ThreadLocalRandom.current().nextInt(0, world[0].length);
        int inZ = ThreadLocalRandom.current().nextInt(0, world[0][0].length);

        //inX = 0;
        //inY = 0;
        //inZ = 0;

        System.out.println("Mapa del Mundo");
        System.out.println();

        Sector mySector = world[inX][inY][inZ];

        int z = mySector.getZLocation();
        //z = 0;
        System.out.println("Capa "+z);
        System.out.println(mySector.getTier());
        for (int x = 0; x < world.length; x++) {
            for (int y = 0; y < world[x].length; y++) {
                Sector currentSector = world[x][y][z];
                if (currentSector == mySector) {
                    System.out.print("X" + "    |");
                } else if (currentSector == mySector.getNorth()) {
                    System.out.print("^" + "    |");
                } else if (currentSector == mySector.getEast()) {
                    System.out.print(">" + "    |");
                } else if (currentSector == mySector.getWest()) {
                    System.out.print("<" + "    |");
                } else if (currentSector == mySector.getSouth()) {
                    System.out.print("v" + "    |");
                } else {
                    System.out.print(currentSector.getID() + "|");
                }
            }
            System.out.println();
        }
        
        z = ThreadLocalRandom.current().nextInt(0, world[0][0].length);
        System.out.println("Capa "+z);
        for (int x = 0; x < world.length; x++) {
            for (int y = 0; y < world[x].length; y++) {
                Sector currentSector = world[x][y][z];
                if (currentSector == mySector) {
                    System.out.print("X" + "    |");
                } else if (currentSector == mySector.getNorth()) {
                    System.out.print("^" + "    |");
                } else if (currentSector == mySector.getEast()) {
                    System.out.print(">" + "    |");
                } else if (currentSector == mySector.getWest()) {
                    System.out.print("<" + "    |");
                } else if (currentSector == mySector.getSouth()) {
                    System.out.print("v" + "    |");
                } else {
                    System.out.print(currentSector.getID() + "|");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Ubicación actual: " + mySector.getName() + " (" + mySector.getXLocation()+","+mySector.getYLocation()+","+mySector.getZLocation()+") "+mySector.getTier());
        System.out.println("Norte: " + mySector.getNorth().getName()+" ("+mySector.getNorth().getID()+") "+mySector.getNorth().getTier());
        System.out.println("Sur: " + mySector.getSouth().getName()+" ("+mySector.getSouth().getID()+") "+mySector.getSouth().getTier());
        System.out.println("Este: " + mySector.getEast().getName()+" ("+mySector.getEast().getID()+") "+mySector.getEast().getTier());
        System.out.println("Oeste: " + mySector.getWest().getName()+" ("+mySector.getWest().getID()+") "+mySector.getWest().getTier());

        inX = ThreadLocalRandom.current().nextInt(0, world.length);
        inY = ThreadLocalRandom.current().nextInt(0, world[0].length);
        inZ = ThreadLocalRandom.current().nextInt(0, world[0][0].length);
        Sector someSector = world[inX][inY][inZ];
        
        System.out.println("En algun lugar del universo: "+someSector.getName()+" "+someSector.getID()+" "+someSector.getTier());

        SpaceShip CNS_Chiloe = new SpaceShip(
            "CNS-Chiloe",
            "Un rudimentario crucero de la epoca pasada.",
            Tier.Tier2,
            Category.Category5,
            1465,
            30,
            4,
            45,
            765,
            100,
            450,
            245,
            325,
            100,
            new Triple<>(WeaponSlot.class, Category.Category1, 6),
            new Triple<>(WeaponSlot.class, Category.Category1, 6),
            new Triple<>(WeaponSlot.class, Category.Category2, 2),
            new Triple<>(WeaponSlot.class, Category.Category4, 1)
        );

        Weapon supportLaser = new Weapon(
            "Laser de Advertencia",
            "Arma Simple",
            Tier.Tier1,
            Category.Category1,
            35,
            1,
            10,

            10, 10, 0.1,
            50, 25, 0.25,
            25, 18, 0.18,
            0, 0, 0
        );

        Weapon ionColosalBlaster = new Weapon(
            "Blaster de Iones colosal",
            "Arma avanzada",
            Tier.Tier9,
            Category.Category10,
            55,
            5,
            235,

            100, 10, 0.01,
            850, 25, 0.75,
            450, 18, 0.40,
            100,10,0.01
        );

        CNS_Chiloe.setName("TricolorWhale");
        equipUtils.equipWeapon(CNS_Chiloe, supportLaser, 14);
        equipUtils.equipWeapon(CNS_Chiloe, ionColosalBlaster, 14);
        equipUtils.equipWeapon(CNS_Chiloe, ionColosalBlaster, 3);
        equipUtils.equipWeapon(CNS_Chiloe, ionColosalBlaster, 15);
        equipUtils.equipWeapon(CNS_Chiloe, supportLaser, 15);

        System.out.println(CNS_Chiloe.getBaseInfo());
        System.out.println(CNS_Chiloe.getInfo());
        System.out.println(supportLaser.getInfo());
        System.out.println(ionColosalBlaster.getInfo());
        System.out.println(supportLaser);
        System.out.println(ionColosalBlaster);
        System.out.println(((WeaponSlot) CNS_Chiloe.getSlots().get(14)).getWeapon());
        System.out.println(((WeaponSlot) CNS_Chiloe.getSlots().get(3)).getWeapon());

    }
}
