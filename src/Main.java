import View.EditorPanel;
import View.SimulationPanel;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class Main {

    private static final int WINDOW_WIDTH = 1600;
    private static final int WINDOW_HEIGHT = 1024;
    private static SimulationPanel simulationPanel = new SimulationPanel();
    private static EditorPanel editorPanel = new EditorPanel();
    private static final int SCALE = 8;

    public static void main(String[] args) {
        //Window Setup//
        JFrame mainWindow = new JFrame("Traffic Simulator");
        mainWindow.setLayout(new BorderLayout());
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        //Simulator Status Bar//
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 0));
        bottomPanel.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        JLabel modeLabel = new JLabel("Mode: ");
        bottomPanel.add(modeLabel);
        JLabel statusLabel = new JLabel("Status: ");
        bottomPanel.add(statusLabel);
        mainWindow.add(bottomPanel, BorderLayout.SOUTH);

        //Simulator Menu Bar//
        JMenuBar menuBar = new JMenuBar();
        mainWindow.add(menuBar, BorderLayout.NORTH);

        JMenu editMenu = new JMenu("City Editor");
        MenuListener cityLis = new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                modeLabel.setText("Mode: Editor");
                mainWindow.repaint();
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        };

        editMenu.add(newMapItem);

        JMenuItem openMapItem = new JMenuItem("Open");
        openMapItem.addActionListener(e -> {
        });
        editMenu.add(openMapItem);

        JMenuItem saveMapItem = new JMenuItem("Save");
        saveMapItem.addActionListener(e -> {
        });
        editMenu.add(saveMapItem);

        JMenuItem exitProgramItem = new JMenuItem("Exit");
        exitProgramItem.addActionListener(e -> System.exit(0));
        editMenu.add(exitProgramItem);

        JMenu simMenu = new JMenu("Simulation");
        MenuListener simLis = new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                modeLabel.setText("Mode: Simulation");
                mainWindow.repaint();
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        };
        simMenu.addMenuListener(simLis);


        JMenuItem loadSimItem = new JMenuItem("Load Map");
        simMenu.add(loadSimItem);

        JMenuItem spawnItem = new JMenuItem("Add Vehicles");
        spawnItem.setEnabled(false);
        simMenu.add(spawnItem);

        JMenuItem startSimItem = new JMenuItem("Start");
        startSimItem.setEnabled(false);
        startSimItem.addActionListener(e -> {
            simulationPanel.simulate();
            statusLabel.setText("Status: Simulation Started");
            simulationPanel.setStopSim(false);
            mainWindow.validate();
            mainWindow.repaint();
        });
        simMenu.add(startSimItem);

        spawnItem.addActionListener(e -> {
            String spawnInput = JOptionPane.showInputDialog("Total number of Vehicles to spawn:");
            int spawns = Integer.parseInt(spawnInput);
            simulationPanel.setVehicleSpawn(spawns);
            String spawnRateInput = JOptionPane.showInputDialog("Number of Simulation tics between spawns:");
            int spawnRate = Integer.parseInt(spawnRateInput);
            simulationPanel.setVehicleSpawnRate(spawnRate);
        });



    }












}
