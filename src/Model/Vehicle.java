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

        if (speed == STOPPED) { //intentionally left empty
        } else {
            if (!currentRoad.getLightsOnRoad().isEmpty() && nextPosition + 1 >= currentRoad.getLightsOnRoad().get(0).getPosition() && this.currentRoad.getLightsOnRoad().get(0).getState().equals("red")) {
                speed = STOPPED;
            } else {
                speed = currentRoad.getSpeedLimit();
                if (currentRoad.getLength() <= nextPosition && !currentRoad.getConnectedRoads().isEmpty()) {
                    currentRoad.getVehiclesOnRoad().remove(this);
                    int nextRoadIndex = random.nextInt(2);
                    currentRoad = currentRoad.getConnectedRoads().get(nextRoadIndex);
                    currentRoad.getVehiclesOnRoad().add(this);
                    position = START_POSITION;
                } else if (currentRoad.getLength() >= nextPosition) {
                    position = (position + speed);
                } else {
                    speed = STOPPED;
                }
            }
        }
    }

    public void draw(Graphics g, int scale) {
        int xValue = 0;
        int yValue = 1;
        if (currentRoad.getOrientation() == Road.Orientation.HORIZONTAL) {
            int[] startLocation = getCurrentRoad().getStartLocation();
            int width = getLength() * scale;
            int height = getBreadth() * scale;
            int x = (getPosition() + startLocation[xValue]) * scale;
            int y = (startLocation[yValue] * scale) + scale;
            g.setColor(colour);
            g.fillRect(x, y, width, height);
        } else if (currentRoad.getOrientation() == Road.Orientation.VERTICAL) {
            int[] startLocation = getCurrentRoad().getStartLocation();
            int width = getBreadth() * scale;
            int height = getLength() * scale;
            int x = (startLocation[xValue] * scale) + ((currentRoad.getWidth() * scale) - (width + scale));
            int y = (getPosition() + startLocation[yValue]) * scale;
            g.setColor(colour);
            g.fillRect(x, y, width, height);
        }
    }


}
