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


}
