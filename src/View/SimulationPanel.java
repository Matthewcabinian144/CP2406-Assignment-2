package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
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

    public void setVehicleSpawnRate(int rate) {
        this.numberOfCycles = rate;
    }

    private void createVehicle() {
        int randomVehicle = random.nextInt(3);
        switch (randomVehicle) {
            case 0:
                vehicles.add(new Car(Integer.toString(cycle), roads.get(0)));
                break;
            case 1:
                vehicles.add(new Bus(Integer.toString(cycle), roads.get(0)));
                break;
            case 2:
                vehicles.add(new Motorbike(Integer.toString(cycle), roads.get(0)));
                break;
        }
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public void simulate() {
        setLayout(new BorderLayout());
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(1, 0));
        infoPanel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        JLabel vehicleLabel = new JLabel("Vehicles: ");
        infoPanel.add(vehicleLabel);
        JLabel averageSpeedLabel = new JLabel("Average Speed: ");
        infoPanel.add(averageSpeedLabel);
        JLabel stateLabel = new JLabel("State: " + state);
        infoPanel.add(stateLabel);
        add(infoPanel, BorderLayout.SOUTH);

}
