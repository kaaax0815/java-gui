package de.kaaaxcreators.swing;

import javax.swing.*;

public class Select extends JPanel {
    public Select() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        init();
    }

    void init() {
        JButton carButton = new JButton("Cars");
        add(carButton);
        JButton motorcycleButton = new JButton("Motorcycle");
        add(motorcycleButton);
    }
}