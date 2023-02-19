package de.kaaaxcreators.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ClickListener implements ActionListener {
    JButton motorcycleButton;
    JButton carButton;
    JButton ownPhotoButton;
    
    ClickListener(JButton motorcycleButton, JButton carButton, JButton ownPhotoButton) {
        this.motorcycleButton = motorcycleButton;
        this.carButton = carButton;
        this.ownPhotoButton = ownPhotoButton;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == motorcycleButton) {
            App.select.selectItem = Selectable.MOTORCYCLE;
        }
        else if (e.getSource() == carButton) {
            App.select.selectItem = Selectable.CAR;
        }
        else if(e.getSource() == ownPhotoButton) {
            App.select.selectItem = Selectable.OWN;
        }
        App.result.update();
    } 
}

