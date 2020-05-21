package View;

import Model.Road;
import Model.TrafficLight;
import Model.Vehicle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class SimulationPanel extends JPanel {

    public enum State {
        STOPPED, RUNNING, FINISHED
    }

    private State state = State.STOPPED;
    private int scale;
    private ArrayList<Road> roads;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private ArrayList<TrafficLight> lights;
    private Timer timer;
    private Boolean stop = true;
    private Random random = new Random();
    private static int cycle = 0;
    private int vehiclesToSpawn = 2;
    private int vehiclesSpawned = 0;
    private int vehiclesRemoved = 0;
    private int numberOfCycles = 20;
    private int updateRate = 1000;

    public void loadMap(ArrayList<Road> roads, ArrayList<TrafficLight> lights) {
        this.roads = roads;
        this.lights = lights;
    }

    public void setVehicleSpawn(int spawns) {
        this.vehiclesToSpawn = spawns - 1;
        createVehicle();
    }

    

}
