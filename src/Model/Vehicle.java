package Model;

import java.awt.*;
import java.util.Random;

public abstract class Vehicle {

    private static final int STOPPED = 0;
    private static final int START_POSITION = 0;
    int length;
    int breadth;
    String id;
    private int speed;
    private Road currentRoad;
    int position;
    private Color colour;
    private Random random = new Random();

    public Vehicle(Road currentRoad) {
        id = "000";
        length = 4;
        breadth = 2;
        speed = 0;
        this.currentRoad = currentRoad;
        currentRoad.getVehiclesOnRoad().add(this); //add this vehicle to the road its on.
        colour = randomColour();
    }

    public Vehicle() {
        id = "000";
        length = 0;
        breadth = 0;
        speed = 0;
        position = 0;
    }

    public void move() {
        Random random = new Random();
        int nextPosition = position + length + speed;
        for (Vehicle nextVehicle : currentRoad.getVehiclesOnRoad()) {
            if (nextVehicle.position > position && nextVehicle.position <= nextPosition + 4) {
                speed = STOPPED;
                break;
            } else {
                speed = currentRoad.getSpeedLimit();
            }
        }


}
