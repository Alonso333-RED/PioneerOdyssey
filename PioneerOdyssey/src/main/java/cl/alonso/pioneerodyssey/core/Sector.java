package cl.alonso.pioneerodyssey.core;

public class Sector {
    
    private String name;
    
    private final int xLocation;
    private final int yLocation;
    private final int zLocation;
    private Sector north;
    private Sector east;
    private Sector west;
    private Sector south;
    
    public Sector(String name, int xLocation, int yLocation, int zLocation) {
        this.name = name;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.zLocation = zLocation;
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getID() { return xLocation+","+yLocation+","+zLocation; }

    public int getXLocation() { return xLocation; }
    public int getYLocation() { return yLocation; }
    public int getZLocation() { return zLocation; }

    public Sector getNorth() { return north; }
    public void setNorth(Sector north) { this.north = north; }

    public Sector getEast() { return east; }
    public void setEast(Sector east) { this.east = east; }

    public Sector getWest() { return west; }
    public void setWest(Sector west) { this.west = west; }

    public Sector getSouth() { return south; }
    public void setSouth(Sector south) { this.south = south; }
}