package View;

import Model.Road;
import Model.TrafficLight;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class EditorPanel extends JPanel {
    private ArrayList<Road> roads;
    private ArrayList<TrafficLight> lights;
    private int scale;

    public void newMap() {
        roads = new ArrayList<>();
        lights = new ArrayList<>();
        MouseAdapter mouseLis = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int xValue = e.getX() / scale;
                int yValue = e.getY() / scale;
                System.out.println("X: " + xValue);
                System.out.println("Y: " + yValue);
                if (roads.size() == 0) {
                    if (e.getY() < 10) {
                        roads.add(new Road(Integer.toString(roads.size()), 1, 50, new int[]{xValue, 0}
                                , Road.Orientation.VERTICAL));
                    } else if (e.getX() < 10) {
                        roads.add(new Road(Integer.toString(roads.size()), 1, 50, new int[]{0, yValue}
                                , Road.Orientation.HORIZONTAL));
                    }


}
