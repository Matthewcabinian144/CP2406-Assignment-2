package Model;

import java.util.ArrayList;

public class Road {

    public enum Orientation {
        HORIZONTAL, VERTICAL
    }

    private Orientation orientation;
    private String id;
    private int speedLimit;
    private int length;
    private int width;
    private int[] startLocation;
    private int[] endLocation;
    private ArrayList<Vehicle> vehiclesOnRoad = new ArrayList<>();
    private ArrayList<TrafficLight> lightsOnRoad = new ArrayList<>();
    private ArrayList<Road> connectedRoads = new ArrayList<>();

    public Road(String id, int speedLimit, int length, int[] startLocation, Orientation orientation) {
        this.id = "road_" + id;
        this.speedLimit = speedLimit;
        this.length = length;
        width = 8;
        this.orientation = orientation;
        this.startLocation = startLocation;
        setEndLocation();
    }

}
