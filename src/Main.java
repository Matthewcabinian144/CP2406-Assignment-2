import View.EditorPanel;
import View.SimulationPanel;

import javax.swing.*;
import java.awt.*;

public class Main {

    private static final int WINDOW_WIDTH = 1600;
    private static final int WINDOW_HEIGHT = 1024;
    private static SimulationPanel simulationPanel = new SimulationPanel();
    private static EditorPanel editorPanel = new EditorPanel();
    private static final int SCALE = 8;

    public static void main(String[] args) {
        JFrame mainWindow = new JFrame("Traffic Simulator");
        mainWindow.setLayout(new BorderLayout());
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    }












}
