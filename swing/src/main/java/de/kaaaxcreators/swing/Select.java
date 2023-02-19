package de.kaaaxcreators.swing;

import javax.swing.*;

public class Select extends JPanel {
    static String isSelected = Selectable.car;

    public Select() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        init();
    }

    void init() {
        JButton carButton = new JButton("Cars"); 
        JButton motorcycleButton = new JButton("Motorcycle");
        JButton ownPhotoButton = new JButton("Eigenes");

        Clicklistener click = new Clicklistener(motorcycleButton, carButton, ownPhotoButton);
        carButton.addActionListener(click);
        motorcycleButton.addActionListener(click);
        ownPhotoButton.addActionListener(click);

        add(carButton);
        add(motorcycleButton);
        add(ownPhotoButton);
        }
    

    void update() {
        removeAll();
        init();
        revalidate();
        repaint();
    }
}