package de.kaaaxcreators.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Clicklistener implements ActionListener {
    JButton motorcycleButton;
    JButton carButton;
    JButton ownPhotoButton;
    
    Clicklistener(JButton _motorcycleButton, JButton _carButton, JButton _ownPhotoButton) {
        this.motorcycleButton = _motorcycleButton;
        this.carButton = _carButton;
        this.ownPhotoButton = _ownPhotoButton;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == motorcycleButton) {
            Select.isSelected = Selectable.motorcycle;
            System.out.println("motorcycle");
        }
        else if (e.getSource() == carButton) {
            Select.isSelected = Selectable.car;
            System.out.println("car");
        }
        else if(e.getSource() == ownPhotoButton) {
            Select.isSelected = Selectable.own;
        }
        App.result.update();
    } 
}

