package de.kaaaxcreators.swing;

import javax.swing.*;

public class Select extends JPanel {
    Selectable selectItem = Selectable.CAR;

    public Select() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        init();
    }

    void init() {
        JButton carButton = new JButton("Auto"); 
        JButton motorcycleButton = new JButton("Motorrad");
        JButton ownPhotoButton = new JButton("Eigenes");

        ClickListener click = new ClickListener(motorcycleButton, carButton, ownPhotoButton);
        carButton.addActionListener(click);
        motorcycleButton.addActionListener(click);
        ownPhotoButton.addActionListener(click);

        add(carButton);
        add(motorcycleButton);
        add(ownPhotoButton);
    }
}