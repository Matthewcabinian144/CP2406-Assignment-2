package Model;

import java.util.Random;

public class TrafficLight {
    private static final double CHANGE = 0.4; // more often red
    private static final String GREEN = "green";
    private static final String RED = "red";
    private String id;
    private String state;
    private int position;
    private Road roadAttachedTo;

    public TrafficLight(String id, Road road) {
        this.id = "light_" + id;
        state = RED;
        this.roadAttachedTo = road;
        position = this.roadAttachedTo.getLength();
        this.roadAttachedTo.getLightsOnRoad().add(this);
    }

    public void operate(int seed) {
        Random random = new Random(seed);
        double probability = random.nextDouble();
        if (probability > CHANGE && !getRoadAttachedTo().getVehiclesOnRoad().isEmpty()) {
            setState(RED);
        } else {
            setState(GREEN);
        }
    }

    public void printLightStatus() {
        System.out.printf("%s is:%s on %s at position:%s%n", getId(), getState(), this.getRoadAttachedTo().getId(), this.getPosition());
    }

    public String getState() {
        return state;
    }

    private void setState(String state) {
        this.state = state;
    }

    public Road getRoadAttachedTo() {
        return roadAttachedTo;
    }

    public int getPosition() {
        return position;
    }

    public String getId() {
        return id;
    }



}
